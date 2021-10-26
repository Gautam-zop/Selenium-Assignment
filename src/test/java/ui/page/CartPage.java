package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.map.CartMap;

public class CartPage {
    private CartMap cartMap = new CartMap();
    public void assertCartItems(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartMap.headingSpan()));
        String actualItems = webDriver.findElement(cartMap.headingSpan()).getText();
        Assert.assertEquals(actualItems, "1 Product");
    }
}
