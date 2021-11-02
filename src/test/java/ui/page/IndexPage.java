package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.map.IndexMap;

import java.util.concurrent.TimeUnit;

public class IndexPage {
    private IndexMap indexMap = new IndexMap();

    public void clickRegisterButton(WebDriver driver) {
        implicitWaitTimout(5, driver);
        driver.findElement(indexMap.registerButton()).click();
    }

    private void implicitWaitTimout(int time, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void clickLoginButton(WebDriver driver, String email, String password) {
        implicitWaitTimout(5, driver);
        driver.findElement(indexMap.loginButton()).click();
    }

    public void clickElectronicButton(WebDriver driver) {
        driver.findElement(indexMap.electronicButton()).click();
    }

    public void clickComputerButton(WebDriver driver) {
        driver.findElement(indexMap.computerButton()).click();
    }
}
