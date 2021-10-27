package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.map.CheckoutMap;

import java.util.List;

public class CheckoutPage {
    private CheckoutMap checkoutMap = new CheckoutMap();

    public void clickProceedToCheckoutButtonOnSummaryPage(WebDriver webDriver) {
        try{
            Thread.sleep(3000);
            ((JavascriptExecutor)webDriver).executeScript("scroll(0, 500)");
            webDriver.findElement(checkoutMap.proceedToCheckoutOnSummaryPageButton()).click();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void clickProceedToCheckoutButtonOnAddressPage(WebDriver webDriver) {
        try{
            Thread.sleep(3000);
            ((JavascriptExecutor)webDriver).executeScript("scroll(0, 500)");
            webDriver.findElement(checkoutMap.proceedToCheckoutOnAddressPageButton()).click();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void clickIagreeCheckboxOnShippingPage(WebDriver webDriver){
        webDriver.findElement(checkoutMap.iAgreeCheckbox()).click();
    }

    public void clickProceedToCheckoutButtonOnShippingPage(WebDriver webDriver) {
        webDriver.findElement(checkoutMap.proceedToCheckoutOnShippingPage()).click();
    }

    public void clickOnWirePaymentButton(WebDriver webDriver) {
        try{
            Thread.sleep(3000);
            ((JavascriptExecutor)webDriver).executeScript("scroll(0, 300)");
            webDriver.findElement(checkoutMap.payByWire()).click();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void clickConfirmPaymentPage(WebDriver webDriver) {
        webDriver.findElement(checkoutMap.confirmPageButton());
    }
}
