package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.CheckoutMap;

public class CheckoutPage {
    private CheckoutMap checkoutMap = new CheckoutMap();
    public void fillAddressFieldsTextBox(WebDriver driver, String city, String address, int zipcode, long phoneNumber) {
        driver.findElement(checkoutMap.countryDropDown()).click();
        driver.findElement(checkoutMap.selectCountry()).click();
        driver.findElement(checkoutMap.cityTextBox()).sendKeys(city);
        driver.findElement(checkoutMap.addressTextBox()).sendKeys(address);
        driver.findElement(checkoutMap.zipcodeTextBox()).sendKeys(String.valueOf(zipcode));
        driver.findElement(checkoutMap.phoneNumberTextBox()).sendKeys(String.valueOf(phoneNumber));
        driver.findElement(checkoutMap.stateDropDown()).click();
        driver.findElement(checkoutMap.selectState()).click();
        driver.findElement(checkoutMap.billingContinueButton()).click();
    }

    public void selectGroundShippingRadioButton(WebDriver driver) {
        driver.findElement(checkoutMap.groundShippingRadioButton()).click();
        driver.findElement(checkoutMap.shippingContinueButton()).click();
    }

    public void payByCheckRadioButton(WebDriver driver) {
        driver.findElement(checkoutMap.payByCheckRadioButton()).click();
        driver.findElement(checkoutMap.paymentContinueButton()).click();
    }

    public void paymentInfoContinueButton(WebDriver driver) {
        driver.findElement(checkoutMap.paymentInfoContinueButton()).click();
    }

    public void confirmOrderButton(WebDriver driver) {
        driver.findElement(checkoutMap.confirmButton()).click();
    }

    public void assertConfirmOrder(WebDriver driver, String message) {
        String actualConfirmMessage = driver.findElement(checkoutMap.confirmMessage()).getText();
        Assert.assertEquals(actualConfirmMessage, message);
    }

    public void payByCardRadioButton(WebDriver driver) {
        driver.findElement(checkoutMap.payByCardRadioButton()).click();
        driver.findElement(checkoutMap.paymentContinueButton()).click();
    }

    public void selectNextDayDeliveryRadioButton(WebDriver driver) {
        driver.findElement(checkoutMap.nextDayDeliveryRadioButton()).click();
        driver.findElement(checkoutMap.shippingContinueButton()).click();
    }
}
