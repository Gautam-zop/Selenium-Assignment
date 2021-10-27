package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.CartMap;

public class CartPage {
    private CartMap cartMap = new CartMap();
    public void assertCartItems(WebDriver webDriver, String message) {

        String actualItems = webDriver.findElement(cartMap.headingSpan()).getText();
        Assert.assertEquals(actualItems, message);
    }
}
