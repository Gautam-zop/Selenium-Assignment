package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.page.*;
import utils.ExcelUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaymentTest {

    public static final String LOGIN_WAS_UNSUCCESSFUL_MESSAGE = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    private WebDriver driver;
    private String baseUrl;
    private final IndexPage indexPage = new IndexPage();
    private final ComputerPage computerPage = new ComputerPage();
    private final CartPage cartPage = new CartPage();
    private final ElectronicPage electronicPage = new ElectronicPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final RegisterPage registerPage = new RegisterPage();

    @DataProvider
    public Iterator<Object[]> payWithCheck(){
        List<Object[]> list = ExcelUtils.getDataFromExcel("payWithCheck.xlsx");
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

    @Test(dataProvider = "payWithCheck")
    public void validatePaymentByCheck(String gender, String firstName, String lastName, String email, String password,
                                       String city, String address, String zipcode, String phoneNumber){

        implicitWaitTimout(5, driver);
        // register
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");

        // add one electronic to cart
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToCartButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your shopping cart");

        // add one computer to cart
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToCart(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your shopping cart");
        computerPage.clickCloseMessageButton(driver);
        // navigate to cart

        cartPage.navigateToCartButton(driver);
        List<String> productNames = new ArrayList<>();
        productNames.add("Nikon D5500 DSLR - Black");
        productNames.add("Digital Storm VANQUISH 3 Custom Performance PC");
        cartPage.assertCartProducts(driver, productNames);

        cartPage.checkIAgreeCheckBox(driver);
        cartPage.clickContinueButton(driver);
        checkoutPage.fillAddressFieldsTextBox(driver, city, address, Integer.parseInt(zipcode), Long.parseLong(phoneNumber));
        checkoutPage.selectGroundShippingRadioButton(driver);
        checkoutPage.payByCheckRadioButton(driver);
        checkoutPage.paymentInfoContinueButton(driver);
        checkoutPage.confirmOrderButton(driver);
        checkoutPage.assertConfirmOrder(driver, "Your order has been successfully processed!");
    }

    @Test(dataProvider = "payWithCheck")
    public void validatePaymentByCreditCard(String gender, String firstName, String lastName, String email, String password,
                                       String city, String address, String zipcode, String phoneNumber){

        implicitWaitTimout(5, driver);
        // register
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");

        // add one electronic to cart
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToCartButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your shopping cart");

        // add one computer to cart
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToCart(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your shopping cart");
        computerPage.clickCloseMessageButton(driver);
        // navigate to cart

        cartPage.navigateToCartButton(driver);
        List<String> productNames = new ArrayList<>();
        productNames.add("Nikon D5500 DSLR - Black");
        productNames.add("Digital Storm VANQUISH 3 Custom Performance PC");
        cartPage.assertCartProducts(driver, productNames);

        cartPage.checkIAgreeCheckBox(driver);
        cartPage.clickContinueButton(driver);
        checkoutPage.fillAddressFieldsTextBox(driver, city, address, Integer.parseInt(zipcode), Long.parseLong(phoneNumber));
        checkoutPage.selectGroundShippingRadioButton(driver);
        checkoutPage.payByCardRadioButton(driver);
        checkoutPage.paymentInfoContinueButton(driver);
        checkoutPage.confirmOrderButton(driver);
        checkoutPage.assertConfirmOrder(driver, "Your order has been successfully processed!");
    }

    @Test(dataProvider = "payWithCheck")
    public void validatePaymentByCreditCardForNextDayDelivery(String gender, String firstName, String lastName, String email, String password,
                                            String city, String address, String zipcode, String phoneNumber){

        implicitWaitTimout(5, driver);
        // register
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");

        // add one electronic to cart
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToCartButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your shopping cart");

        // add one computer to cart
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToCart(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your shopping cart");
        computerPage.clickCloseMessageButton(driver);
        // navigate to cart

        cartPage.navigateToCartButton(driver);
        List<String> productNames = new ArrayList<>();
        productNames.add("Nikon D5500 DSLR - Black");
        productNames.add("Digital Storm VANQUISH 3 Custom Performance PC");
        cartPage.assertCartProducts(driver, productNames);

        cartPage.checkIAgreeCheckBox(driver);
        cartPage.clickContinueButton(driver);
        checkoutPage.fillAddressFieldsTextBox(driver, city, address, Integer.parseInt(zipcode), Long.parseLong(phoneNumber));
        checkoutPage.selectNextDayDeliveryRadioButton(driver);
        checkoutPage.payByCardRadioButton(driver);
        checkoutPage.paymentInfoContinueButton(driver);
        checkoutPage.confirmOrderButton(driver);
        checkoutPage.assertConfirmOrder(driver, "Your order has been successfully processed!");
    }

    @Test(dataProvider = "payWithCheck")
    public void validatePaymentByCreditCardForNextDayDeliveryFromWishList(String gender, String firstName, String lastName, String email, String password,
                                                              String city, String address, String zipcode, String phoneNumber){

        implicitWaitTimout(5, driver);
        // register
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");

        // add one electronic to cart
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToWishListButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your wishlist");

        // add one computer to cart
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToWishlist(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your wishlist");
        computerPage.clickCloseMessageButton(driver);

        //navigate to wishlist
        cartPage.clickWishlistButton(driver);

        // navigate to cart
        List<String> productNames = new ArrayList<>();
        productNames.add("Nikon D5500 DSLR - Black");
        productNames.add("Digital Storm VANQUISH 3 Custom Performance PC");
        cartPage.assertCartProducts(driver, productNames);

        cartPage.checkIAgreeCheckBox(driver);
        cartPage.clickContinueButton(driver);
        checkoutPage.fillAddressFieldsTextBox(driver, city, address, Integer.parseInt(zipcode), Long.parseLong(phoneNumber));
        checkoutPage.selectNextDayDeliveryRadioButton(driver);
        checkoutPage.payByCardRadioButton(driver);
        checkoutPage.paymentInfoContinueButton(driver);
        checkoutPage.confirmOrderButton(driver);
        checkoutPage.assertConfirmOrder(driver, "Your order has been successfully processed!");
    }

    @Test(dataProvider = "payWithCheck")
    public void validatePaymentByCheckForNextDayDeliveryFromWishList(String gender, String firstName, String lastName, String email, String password,
                                                                          String city, String address, String zipcode, String phoneNumber){

        implicitWaitTimout(5, driver);
        // register
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");

        // add one electronic to cart
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToWishListButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your wishlist");

        // add one computer to cart
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToWishlist(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your wishlist");
        computerPage.clickCloseMessageButton(driver);

        //navigate to wishlist
        cartPage.clickWishlistButton(driver);

        // navigate to cart
        List<String> productNames = new ArrayList<>();
        productNames.add("Nikon D5500 DSLR - Black");
        productNames.add("Digital Storm VANQUISH 3 Custom Performance PC");
        cartPage.assertCartProducts(driver, productNames);

        cartPage.checkIAgreeCheckBox(driver);
        cartPage.clickContinueButton(driver);
        checkoutPage.fillAddressFieldsTextBox(driver, city, address, Integer.parseInt(zipcode), Long.parseLong(phoneNumber));
        checkoutPage.selectNextDayDeliveryRadioButton(driver);
        checkoutPage.payByCheckRadioButton(driver);
        checkoutPage.paymentInfoContinueButton(driver);
        checkoutPage.confirmOrderButton(driver);
        checkoutPage.assertConfirmOrder(driver, "Your order has been successfully processed!");
    }

    @Test(dataProvider = "payWithCheck")
    public void validatePaymentByCheckForGroundDeliveryFromWishList(String gender, String firstName, String lastName, String email, String password,
                                                                     String city, String address, String zipcode, String phoneNumber){

        implicitWaitTimout(5, driver);
        // register
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");

        // add one electronic to cart
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToWishListButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your wishlist");

        // add one computer to cart
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToWishlist(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your wishlist");
        computerPage.clickCloseMessageButton(driver);

        //navigate to wishlist
        cartPage.clickWishlistButton(driver);

        // navigate to cart
        List<String> productNames = new ArrayList<>();
        productNames.add("Nikon D5500 DSLR - Black");
        productNames.add("Digital Storm VANQUISH 3 Custom Performance PC");
        cartPage.assertCartProducts(driver, productNames);

        cartPage.checkIAgreeCheckBox(driver);
        cartPage.clickContinueButton(driver);
        checkoutPage.fillAddressFieldsTextBox(driver, city, address, Integer.parseInt(zipcode), Long.parseLong(phoneNumber));
        checkoutPage.selectGroundShippingRadioButton(driver);
        checkoutPage.payByCheckRadioButton(driver);
        checkoutPage.paymentInfoContinueButton(driver);
        checkoutPage.confirmOrderButton(driver);
        checkoutPage.assertConfirmOrder(driver, "Your order has been successfully processed!");
    }

    @Test(dataProvider = "payWithCheck")
    public void validatePaymentByCardForGroundDeliveryFromWishList(String gender, String firstName, String lastName, String email, String password,
                                                                    String city, String address, String zipcode, String phoneNumber){

        implicitWaitTimout(5, driver);
        // register
        indexPage.clickRegisterButton(driver);
        registerPage.fillFormFieldTextBox(driver, gender.toLowerCase(), firstName, lastName, email, password);
        registerPage.assertAccountSuccessMessage(driver, "Your registration completed");

        // add one electronic to cart
        indexPage.clickElectronicButton(driver);
        electronicPage.clickCameraButton(driver);
        electronicPage.clickAddCameraToWishListButton(driver);
        electronicPage.assertCartWithElectronicProduct(driver, "The product has been added to your wishlist");

        // add one computer to cart
        indexPage.clickComputerButton(driver);
        computerPage.clickDesktopAnchor(driver);
        computerPage.clickDigitalStormCpuAnchor(driver);
        computerPage.clickAddCpuToWishlist(driver);
        computerPage.assertCartWithComputer(driver, "The product has been added to your wishlist");
        computerPage.clickCloseMessageButton(driver);

        //navigate to wishlist
        cartPage.clickWishlistButton(driver);

        // navigate to cart
        List<String> productNames = new ArrayList<>();
        productNames.add("Nikon D5500 DSLR - Black");
        productNames.add("Digital Storm VANQUISH 3 Custom Performance PC");
        cartPage.assertCartProducts(driver, productNames);

        cartPage.checkIAgreeCheckBox(driver);
        cartPage.clickContinueButton(driver);
        checkoutPage.fillAddressFieldsTextBox(driver, city, address, Integer.parseInt(zipcode), Long.parseLong(phoneNumber));
        checkoutPage.selectGroundShippingRadioButton(driver);
        checkoutPage.payByCardRadioButton(driver);
        checkoutPage.paymentInfoContinueButton(driver);
        checkoutPage.confirmOrderButton(driver);
        checkoutPage.assertConfirmOrder(driver, "Your order has been successfully processed!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    private void implicitWaitTimout(int time, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
