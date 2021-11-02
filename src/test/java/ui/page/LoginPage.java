package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.LoginMap;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private LoginMap loginMap = new LoginMap();

    public void fillLoginForm(WebDriver driver, String email, String password) {
        implicitWaitTimout(5, driver);
        driver.findElement(loginMap.emailTextbox()).sendKeys(email);
        driver.findElement(loginMap.passwordTextbox()).sendKeys(password);
        driver.findElement(loginMap.rememberMeCheckbox()).click();
        driver.findElement(loginMap.loginButton()).click();
    }

    private void implicitWaitTimout(int time, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void assertLoginErrorMessage(WebDriver driver, String loginWasUnsuccessfulMessage) {
        implicitWaitTimout(5, driver);
        String actualErrorMessage = driver.findElement(loginMap.errorMessage()).getText();
        Assert.assertEquals(actualErrorMessage, loginWasUnsuccessfulMessage);
    }

    public void assertLoginMessage(WebDriver driver) {
        implicitWaitTimout(5, driver);
        Assert.assertEquals(driver.findElement(loginMap.logoutButton()).getText(), "Log out");
    }
}
