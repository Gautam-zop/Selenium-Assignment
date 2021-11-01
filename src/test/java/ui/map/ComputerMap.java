package ui.map;

import org.openqa.selenium.By;

public class ComputerMap {
    public By desktopAnchor() {
        return By.cssSelector("div.picture a[title='Show products in category Desktops']");
    }

    public By digitalStormCpuButton() {
        return By.cssSelector("a[title='Show details for Digital Storm VANQUISH 3 Custom Performance PC']");
    }

    public By addToCartButton() {
        return By.cssSelector(".button-1.add-to-cart-button");
    }

    public By addMessage() {
        return By.cssSelector(".content");
    }

    public By addToWishlistButton() {
        return By.cssSelector("div.add-to-wishlist .button-2.add-to-wishlist-button");
    }
}
