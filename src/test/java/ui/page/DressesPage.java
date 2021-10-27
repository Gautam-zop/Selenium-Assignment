package ui.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.map.DressesMap;

public class DressesPage {

    private DressesMap dressesMap = new DressesMap();

    public void navigateToParticularDress(WebDriver webDriver, String type){
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesMap.dressesTab(type)));

        webDriver.findElement(dressesMap.dressesTab(type)).click();
        try{
            Thread.sleep(3000);
            ((JavascriptExecutor)webDriver).executeScript("scroll(0, 400)");

            //hover
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webDriver.findElement(dressesMap.dressesHover())).perform();
            Thread.sleep(3000);
            webDriver.findElement(dressesMap.addToCartButton()).click();

            wait = new WebDriverWait(webDriver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(dressesMap.closeCartButton()));
            webDriver.findElement(dressesMap.closeCartButton()).click();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void navigateToCart(WebDriver webDriver){
        ((JavascriptExecutor)webDriver).executeScript("scroll(0, 0)");
        webDriver.findElement(dressesMap.cartButton()).click();
    }

    public void addTshirtToCart(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        try{
            Thread.sleep(3000);
            ((JavascriptExecutor)webDriver).executeScript("scroll(0, 300)");

            //hover
            Actions actions = new Actions(webDriver);
            actions.moveToElement(webDriver.findElement(dressesMap.dressesHover())).perform();
            Thread.sleep(3000);
            webDriver.findElement(dressesMap.addToCartButton()).click();

            wait = new WebDriverWait(webDriver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(dressesMap.closeCartButton()));
            webDriver.findElement(dressesMap.closeCartButton()).click();

            // scroll to top
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
