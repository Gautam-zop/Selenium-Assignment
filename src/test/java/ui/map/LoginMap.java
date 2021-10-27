package ui.map;

import org.openqa.selenium.By;

public class LoginMap {
    public By usernameTextbox() {
        return By.cssSelector("#email");
    }

    public By passwordTextbox() {
        return By.cssSelector("#passwd");
    }

    public By signInButton() {
        return By.cssSelector("#SubmitLogin");
    }

    public By authenticationErrorMessage() {
        return By.cssSelector(".alert.alert-danger ol li");
    }

    public By createAccountButton() {
        return By.cssSelector("#SubmitCreate");
    }

    public By createUsernameTextbox() {
        return By.cssSelector("#email_create");
    }
}
