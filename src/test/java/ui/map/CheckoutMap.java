package ui.map;

import org.openqa.selenium.By;

public class CheckoutMap {
    public By proceedToCheckoutOnSummaryPageButton() {
        return By.cssSelector("a.button.btn.btn-default.standard-checkout.button-medium");
    }

    public By proceedToCheckoutOnAddressPageButton() {
        return By.cssSelector("p button");
    }

    public By iAgreeCheckbox() {
        return By.cssSelector("#cgv");
    }

    public By proceedToCheckoutOnShippingPage() {
        return By.cssSelector("p button");
    }

    public By payByWire() {
        return By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p");
    }

    public By confirmPageButton() {
        return By.cssSelector("#cart_navigation > button > span");
    }

    public By payByCheck() {
        return By.cssSelector("a[title='Pay by check.']");
    }
}
