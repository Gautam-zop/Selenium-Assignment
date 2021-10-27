package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.page.IndexPage;
import ui.page.LoginPage;
import util.ExcelUtils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterTest {
    private LoginPage loginPage = new LoginPage();
    private IndexPage indexPage = new IndexPage();
    private WebDriver webDriver;
    private String baseUrl;

    @DataProvider
    public Iterator<Object[]> loginWithValidData(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("login_credentials.xlsx");
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registerNewUser(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("register.xlsx");
        return list.iterator();
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        webDriver = new ChromeDriver();
        baseUrl = "http://automationpractice.com";
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * This method tests register new users with valid data
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     * @param address
     * @param city
     * @param state
     * @param zipcode
     * @param mobileNo
     * @param addressRef
     */
    @Test(dataProvider = "registerNewUser")
    public void registerWithValidCredentials(String email, String firstName, String lastName, String password,
                                          String address, String city, String state, String zipcode, String mobileNo,
                                          String addressRef) {
        webDriver.get(baseUrl);
        indexPage.clickSignInButton(webDriver);
        loginPage.createAnAccount(webDriver, email, firstName, lastName, password, address, city, state, zipcode,
                mobileNo, addressRef);
        indexPage.assertLogin(webDriver, firstName + " " + lastName);
    }

//    @AfterMethod
//    public void teardown() {
//        webDriver.quit();
//    }
}




