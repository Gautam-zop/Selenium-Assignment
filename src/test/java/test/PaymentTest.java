package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.page.*;
import util.ExcelUtils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaymentTest {
    private WebDriver webDriver;
    private String baseUrl;
    private IndexPage indexPage = new IndexPage();
    private DressesPage dressesPage= new DressesPage();
    private CartPage cartPage = new CartPage();
    private LoginPage loginPage = new LoginPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private OrderConfirmPage orderConfirmPage = new OrderConfirmPage();

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

    @DataProvider
    public Iterator<Object[]> payment(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("payment.xlsx");
        return list.iterator();
    }

    /**
     * This tests payment by wire method after adding one casual dress and one tshirt
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     */
    @Test(dataProvider = "payment")
    public void validatePaymentByWireWhenAlreadySignedIn(String email, String firstName, String lastName, String password){
        indexPage.clickSignInButton(webDriver);
        loginPage.login(email.trim(), password.trim(), webDriver);
        indexPage.assertLogin(webDriver, firstName+" "+lastName);

        indexPage.navigateToDressesTab(webDriver);
        dressesPage.navigateToParticularDress(webDriver, "Casual Dresses");

        indexPage.navigateToTshirtTab(webDriver);
        dressesPage.addTshirtToCart(webDriver);
        dressesPage.navigateToCart(webDriver);

        checkoutPage.clickProceedToCheckoutButtonOnSummaryPage(webDriver);
        checkoutPage.clickProceedToCheckoutButtonOnAddressPage(webDriver);
        checkoutPage.clickIagreeCheckboxOnShippingPage(webDriver);
        checkoutPage.clickProceedToCheckoutButtonOnShippingPage(webDriver);
        cartPage.assertCartItems(webDriver, "Your shopping cart contains: 2 Product");

        checkoutPage.clickOnWirePaymentButton(webDriver);
        checkoutPage.clickConfirmPaymentPage(webDriver);
        orderConfirmPage.assertOrderDetails(webDriver, "Your order on My Store is complete.pa");
    }

    @AfterMethod
    public void teardown() {
        webDriver.quit();
    }
}
