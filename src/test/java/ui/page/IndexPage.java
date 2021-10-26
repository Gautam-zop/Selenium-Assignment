package ui.page;

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
}
