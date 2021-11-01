package ui.map;

import org.openqa.selenium.By;

public class LoginMap {
    public By emailTextbox() {
        return By.cssSelector(".email");
    }

    public By passwordTextbox() {
        return By.cssSelector(".password");
    }

    public By loginButton() {
        return By.cssSelector(".button-1.login-button");
    }

    public By errorMessage() {
        return By.cssSelector(".message-error.validation-summary-errors");
    }

    public By logoutButton() {
        return By.cssSelector(".ico-logout");
    }

    public By rememberMeCheckbox() {
        return By.cssSelector("#RememberMe");
    }
}
