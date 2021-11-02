package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.page.*;

import java.util.concurrent.TimeUnit;

/**
 * This class contains test cases related to cart
 */
public class CartTest {

    public static final String LOGIN_WAS_UNSUCCESSFUL_MESSAGE = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    private WebDriver driver;
    private String baseUrl;
    private final IndexPage indexPage = new IndexPage();
    private final ComputerPage computerPage = new ComputerPage();
    private final CartPage cartPage = new CartPage();
    private final ElectronicPage electronicPage = new ElectronicPage();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/zop9604/developer/selenium/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    /**
     * Validate empty cart
     */
    @Test
    public void emptyCart(){
        implicitWaitTimout(5, driver);
        cartPage.assertCart(driver);
    }

    /**
     * validate cart after adding one electronic product
     */
    @Test
    public void validateCartAfterAddingOneElectronicItem(){
        implicitWaitTimout(5, driver);
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToCartButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your shopping cart");
    }

    /**
     * validate wishlist after adding one electronic product
     */
    @Test
    public void validateWishListAfterAddingOneElectronicItem(){
        implicitWaitTimout(5, driver);
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToWishListButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your wishlist");
    }

    /**
     * validate cart after adding one computer
     */
    @Test
    public void validateCartAfterAddingOneComputer(){
        implicitWaitTimout(5, driver);
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToCart(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your shopping cart");
    }

    /**
     * validate wishlist after adding one computer
     */
    @Test
    public void validateWishlistAfterAddingOneComputer(){
        implicitWaitTimout(5, driver);
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToWishlist(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your wishlist");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    private void implicitWaitTimout(int time, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
