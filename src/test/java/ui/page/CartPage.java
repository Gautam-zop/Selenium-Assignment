package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.CartMap;

public class CartPage {
    private final CartMap cartMap = new CartMap();
    public void assertCart(WebDriver driver) {
        String actualShoppingCart = driver.findElement(cartMap.cartQTYButton()).getText();
        Assert.assertEquals(actualShoppingCart, "(0)");
    }
}
