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

public class LoginTest {
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
    public Iterator<Object[]> loginWithInValidData(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("Invalid_login_credentials.xlsx");
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

    @Test(dataProvider = "loginWithValidData")
    public void loginWithValidCredentials(String email, String password, String userName) {
        webDriver.get(baseUrl);
        indexPage.clickSignInButton(webDriver);
        loginPage.login(email.trim(), password.trim(), webDriver);
        indexPage.assertLogin(webDriver, userName.trim());
    }

    @Test(dataProvider = "loginWithInValidData")
    public void loginWithInValidCredentials(String email, String password, String message) {
        webDriver.get(baseUrl);
        indexPage.clickSignInButton(webDriver);
        loginPage.login(email.trim(), password.trim(), webDriver);
        loginPage.assertInValidLogin(webDriver, message.trim());
    }

    @AfterMethod
    public void teardown() {
        webDriver.quit();
    }
}
