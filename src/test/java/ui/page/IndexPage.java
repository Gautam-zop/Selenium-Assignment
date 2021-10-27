package ui.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.map.IndexMap;

public class IndexPage {
    private IndexMap indexMap = new IndexMap();

    public void clickSignInButton(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(indexMap.signInButton()));
        webDriver.findElement(indexMap.signInButton()).click();
    }

    public void assertLogin(WebDriver webDriver, String userName) {
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(indexMap.userNameSpan()));
        String actualUserName = webDriver.findElement(indexMap.userNameSpan()).getText();
        Assert.assertEquals(actualUserName, userName);
    }

    public void navigateToDressesTab(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(indexMap.dressesTab()));
        webDriver.findElement(indexMap.dressesTab()).click();
    }

    public void navigateToTshirtTab(WebDriver webDriver) {
        ((JavascriptExecutor)webDriver).executeScript("scroll(0, 0)");

        WebDriverWait wait = new WebDriverWait(webDriver,30);
        webDriver.findElements(indexMap.tshirtTab()).get(0).click();
    }
}
