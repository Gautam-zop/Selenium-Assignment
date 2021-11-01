package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.page.IndexPage;
import ui.page.RegisterPage;
import utils.ExcelUtils;

import java.util.Iterator;
import java.util.List;

public class RegisterTest {
    private WebDriver driver;
    private final IndexPage indexPage = new IndexPage();
    private final RegisterPage registerPage = new RegisterPage();
    private String baseUrl = "";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/zop9604/developer/selenium/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
    }

    @DataProvider
    public Iterator<Object[]> registerWithValidCredentails(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("registerWithValid.xlsx");
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registerWithDuplicateEmail(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("registerWithDuplicateEmail.xlsx");
        return list.iterator();
    }

    @Test(dataProvider = "registerWithValidCredentails")
    public void registerValidCredentails(String gender, String firstName, String lastName, String email, String password){
        driver.get(baseUrl);
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");
    }

    @Test(dataProvider = "registerWithValidCredentails")
    public void registerWithFirstNameFieldEmpty(String gender, String firstName, String lastName, String email, String password){
        driver.get(baseUrl);
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBoxExceptFirstName(driver, gender.toLowerCase(), lastName, email, password);
        registerPage.assertErrorMessage(driver, "FirstName", "First name is required.");
    }

    @Test(dataProvider = "registerWithValidCredentails")
    public void registerWithLastNameFieldEmpty(String gender, String firstName, String lastName, String email, String password){
        driver.get(baseUrl);
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBoxExceptLastName(driver, gender.toLowerCase(), firstName, email, password);
        registerPage.assertErrorMessage(driver, "LastName", "Last name is required.");
    }

    @Test(dataProvider = "registerWithDuplicateEmail")
    public void registerWithDuplicateEmailField(String gender, String firstName, String lastName, String email, String password){
        driver.get(baseUrl);
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBoxWithDuplicateEmailField(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertDuplicateErrorMessage(driver, "The specified email already exists");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
