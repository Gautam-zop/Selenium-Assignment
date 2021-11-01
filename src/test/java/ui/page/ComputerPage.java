package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.ComputerMap;

public class ComputerPage {
    private final ComputerMap computerMap = new ComputerMap();
    public void clickDesktopAnchor(WebDriver driver) {
        driver.findElement(computerMap.desktopAnchor()).click();
    }

    public void clickDigitalStormCpuAnchor(WebDriver driver) {
        driver.findElement(computerMap.digitalStormCpuButton()).click();
    }

    public void clickAddCpuToCart(WebDriver driver) {
        driver.findElement(computerMap.addToCartButton()).click();
    }

    public void assertCartWithComputer(WebDriver driver, String message) {
        String actualCartMessage = driver.findElement(computerMap.addMessage()).getText();
        Assert.assertEquals(actualCartMessage, message);
    }

    public void clickAddCpuToWishlist(WebDriver driver) {
        driver.findElement(computerMap.addToWishlistButton()).click();
    }
}
