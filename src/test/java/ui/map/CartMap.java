package ui.map;

import org.openqa.selenium.By;

public class CartMap {
    public By cartQTYButton() {
        return By.cssSelector("span.cart-qty");
    }

    public By cartButton() {
        return By.cssSelector(".cart-label");
    }

    public By cartProducts() {
        return By.cssSelector(".product-name");
    }

    public By iAgreeCheckbox() {
        return By.cssSelector("input#termsofservice");
    }

    public By continueButton() {
        return By.cssSelector("button#checkout");
    }
}
