package ui.map;

import org.openqa.selenium.By;

public class ElectronicMap {
    public By cameraButton() {
        return By.cssSelector("div.picture a[title='Show products in category Camera & photo']");
    }

    public By addCameraToCartButton() {
        return By.cssSelector("button#add-to-cart-button-14");
    }

    public By cameraImage() {
        return By.cssSelector("a[title='Show details for Nikon D5500 DSLR']");
    }

    public By addMessage() {
        return By.cssSelector(".content");
    }

    public By addCameraToWishListButton() {
        return By.cssSelector("#add-to-wishlist-button-14");
    }
}
