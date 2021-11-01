package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.page.CartPage;
import ui.page.ElectronicPage;
import ui.page.IndexPage;
import ui.page.LoginPage;
import utils.ExcelUtils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartTest {

    public static final String LOGIN_WAS_UNSUCCESSFUL_MESSAGE = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    private WebDriver driver;
    private String baseUrl;
    private final IndexPage indexPage = new IndexPage();
    private final LoginPage loginPage = new LoginPage();
    private final CartPage cartPage = new CartPage();
    private final ElectronicPage electronicPage = new ElectronicPage();

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

    @Test
    public void emptyCart(){
        implicitWaitTimout(5, driver);
        cartPage.assertCart(driver);
    }

    @Test
    public void validateCartAfterAddingOneElectronicItem(){
        implicitWaitTimout(5, driver);
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToCartButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your shopping cart");
    }

    @Test
    public void validateWishListAfterAddingOneElectronicItem(){
        implicitWaitTimout(5, driver);
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToWishListButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your wishlist");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    private void implicitWaitTimout(int time, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
