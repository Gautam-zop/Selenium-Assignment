package ui.map;

import org.openqa.selenium.By;

public class CheckoutMap {
    public By countryDropDown() {
        return By.cssSelector("select[data-trigger='country-select']");
    }

    public By selectCountry() {
        return By.cssSelector("select[data-trigger='country-select'] option[value='1']");
    }

    public By cityTextBox() {
        return By.cssSelector("#BillingNewAddress_City");
    }

    public By addressTextBox() {
        return By.cssSelector("#BillingNewAddress_Address1");
    }

    public By zipcodeTextBox() {
        return By.cssSelector("#BillingNewAddress_ZipPostalCode");
    }

    public By phoneNumberTextBox() {
        return By.cssSelector("#BillingNewAddress_PhoneNumber");
    }

    public By billingContinueButton() {
        return By.cssSelector("div#billing-buttons-container .button-1.new-address-next-step-button");
    }

    public By stateDropDown() {
        return By.cssSelector("select#BillingNewAddress_StateProvinceId");
    }

    public By selectState() {
        return By.cssSelector("select#BillingNewAddress_StateProvinceId option[value='1']");
    }

    public By groundShippingRadioButton() {
        return By.cssSelector("#shippingoption_0");
    }

    public By shippingContinueButton() {
        return By.cssSelector(".button-1.shipping-method-next-step-button");
    }

    public By payByCheckRadioButton() {
        return By.cssSelector("#paymentmethod_0");
    }

    public By paymentContinueButton() {
        return By.cssSelector(".button-1.payment-method-next-step-button");
    }

    public By paymentInfoContinueButton() {
        return By.cssSelector(".button-1.payment-info-next-step-button");
    }

    public By confirmButton() {
        return By.cssSelector(".button-1.confirm-order-next-step-button");
    }

    public By confirmMessage() {
        return By.cssSelector("div.section.order-completed .title strong");
    }

    public By payByCardRadioButton() {
        return By.cssSelector("#paymentmethod_1");
    }

    public By nextDayDeliveryRadioButton() {
        return By.cssSelector("#shippingoption_1");
    }
}
