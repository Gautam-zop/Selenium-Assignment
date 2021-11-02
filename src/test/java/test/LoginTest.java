package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.page.IndexPage;
import ui.page.LoginPage;
import utils.ExcelUtils;

import java.util.Iterator;
import java.util.List;

/**
 * This class contains test cases related to login
 */
public class LoginTest {
    public static final String LOGIN_WAS_UNSUCCESSFUL_MESSAGE = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    private WebDriver driver;
    private String baseUrl;
    private final IndexPage indexPage = new IndexPage();
    private final LoginPage loginPage = new LoginPage();

    @DataProvider
    public Iterator<Object[]> loginWithValidData(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("assignment2_login_valid.xlsx");
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginWithInValidData(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("assignment2_login_Invalid.xlsx");
        return list.iterator();
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/zop9604/developer/selenium/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    /**
     * Login with valid credentials
     * @param email
     * @param password
     */
    @Test(dataProvider = "loginWithValidData")
    public void loginWithValidCredentials(String email, String password) {
        indexPage.clickLoginButton(driver, email, password);
        loginPage.fillLoginForm(driver, email, password);
        loginPage.assertLoginMessage(driver);
    }

    /**
     * Login with Invalid credentials
     * @param email
     * @param password
     */
    @Test(dataProvider = "loginWithInValidData")
    public void loginWithInValidCredentials(String email, String password) {
        indexPage.clickLoginButton(driver, email, password);
        loginPage.fillLoginForm(driver, email, password);
        loginPage.assertLoginErrorMessage(driver, LOGIN_WAS_UNSUCCESSFUL_MESSAGE);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}



