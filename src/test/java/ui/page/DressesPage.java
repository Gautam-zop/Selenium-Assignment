package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.map.DressesMap;

public class DressesPage {

    private DressesMap dressesMap = new DressesMap();

    public void navigateToParticularDress(WebDriver webDriver, String type){
        webDriver.findElement(dressesMap.dressesTab(type)).click();
        webDriver.findElement(dressesMap.addToCartButton()).click();

        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesMap.closeCartButton()));
        webDriver.findElement(dressesMap.closeCartButton()).click();

        webDriver.findElement(dressesMap.cartButton()).click();

    }
}
