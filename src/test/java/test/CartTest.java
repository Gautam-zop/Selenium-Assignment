package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.page.CartPage;
import ui.page.DressesPage;
import ui.page.IndexPage;

import java.util.concurrent.TimeUnit;

public class CartTest {
    private WebDriver webDriver;
    private String baseUrl;
    private IndexPage indexPage = new IndexPage();
    private DressesPage dressesPage= new DressesPage();
    private CartPage cartPage = new CartPage();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        webDriver = new ChromeDriver();
        baseUrl = "http://automationpractice.com";
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(baseUrl);
    }

    @Test
    public void addSingleDressToCart() {
        indexPage.navigateToDressesTab(webDriver);
        dressesPage.navigateToParticularDress(webDriver, "Casual Dresses");
        dressesPage.navigateToCart(webDriver);
        cartPage.assertCartItems(webDriver,"Your shopping cart contains: 1 Product");
    }

    @AfterMethod
    public void teardown() {
        webDriver.quit();
    }
}
