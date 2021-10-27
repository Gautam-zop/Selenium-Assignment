package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.map.LoginMap;

public class LoginPage {
    private LoginMap loginMap = new LoginMap();
    private WebDriverWait wait;
    private RegisterPage registerPage = new RegisterPage();

    public void login(String email, String password, WebDriver webDriver) {
        wait = new WebDriverWait(webDriver,30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginMap.usernameTextbox()));
        webDriver.findElement(loginMap.usernameTextbox()).click();
        webDriver.findElement(loginMap.usernameTextbox()).clear();
        webDriver.findElement(loginMap.usernameTextbox()).sendKeys(email);

        webDriver.findElement(loginMap.passwordTextbox()).click();
        webDriver.findElement(loginMap.passwordTextbox()).clear();
        webDriver.findElement(loginMap.passwordTextbox()).sendKeys(password);

        webDriver.findElement(loginMap.signInButton()).click();
    }

    public void assertInValidLogin(WebDriver webDriver, String message) {
        String actualErrorMessage = webDriver.findElement(loginMap.authenticationErrorMessage()).getText();
        Assert.assertEquals(actualErrorMessage, message);
    }

    public void createAnAccount(WebDriver webDriver, String email, String firstName, String lastName, String password,
                                String address, String city, String state, String zipcode, String mobileNo,
                                String addressRef) {
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginMap.createUsernameTextbox()));
        enterEmailAddressTextBox(webDriver,email);
        registerPage.register(webDriver, firstName, lastName, password, address, city, state, zipcode, mobileNo,
                addressRef);
    }

    private void enterEmailAddressTextBox(WebDriver webDriver, String email) {
        webDriver.findElement(loginMap.createUsernameTextbox()).sendKeys(email);
        webDriver.findElement(loginMap.createAccountButton()).click();
    }
}
