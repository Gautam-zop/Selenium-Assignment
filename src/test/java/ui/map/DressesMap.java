package ui.map;

import org.openqa.selenium.By;

public class DressesMap {
    public By dressesTab(String selector) {
        return By.cssSelector("a[title='"+selector+"'].img");
    }

    public By addToCartButton() {
        return By.cssSelector("#center_column > ul > li > div > div.right-block > div.button-container > " +
                "a.button.ajax_add_to_cart_button.btn.btn-default > span");
    }

    public By cartButton() {
        return By.cssSelector("a[title='View my shopping cart']");
    }

    public By closeCartButton() {
        return By.cssSelector("span[title='Close window']");
    }
}
