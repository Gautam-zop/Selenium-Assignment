package ui.map;

import org.openqa.selenium.By;

public class DressesMap {
    public By dressesTab(String selector) {
        return By.cssSelector("a[title='"+selector+"'].img");
    }

    public By addToCartButton() {
        return By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default");
    }

    public By cartButton() {
        return By.cssSelector("a[title='View my shopping cart']");
    }

    public By closeCartButton() {
        return By.cssSelector("span[title='Close window']");
    }

    public By dressesHover() {
        return By.cssSelector("a.product_img_link img");
    }
}
