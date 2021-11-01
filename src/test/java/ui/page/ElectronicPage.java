package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.ElectronicMap;

public class ElectronicPage {
    private final ElectronicMap electronicMap = new ElectronicMap();
    public void clickCameraButton(WebDriver driver) {
        driver.findElement(electronicMap.cameraButton()).click();
    }

    public void clickAddCameraToCartButton(WebDriver driver) {
        driver.findElement(electronicMap.cameraImage()).click();
        driver.findElement(electronicMap.addCameraToCartButton()).click();
    }

    public void assertCartWithElectronicProduct(WebDriver driver, String message) {
        String actualCartMessage = driver.findElement(electronicMap.addMessage()).getText();
        Assert.assertEquals(actualCartMessage, message);
    }

    public void clickAddCameraToWishListButton(WebDriver driver) {
        driver.findElement(electronicMap.cameraImage()).click();
        driver.findElement(electronicMap.addCameraToWishListButton()).click();
    }
}
