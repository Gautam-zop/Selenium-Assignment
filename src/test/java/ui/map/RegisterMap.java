package ui.map;

import org.openqa.selenium.By;

public class RegisterMap {
    public By genderRadioButton(String gender) {
        return By.id("gender-"+ gender);
    }

    public By inputTextfield(String fieldName) {
        return By.cssSelector("input[name='"+fieldName+"']");
    }

    public By registerButton() {
        return By.cssSelector(".button-1.register-next-step-button");
    }

    public By successMessage() {
        return By.cssSelector("div.result");
    }

    public By errorMessage(String field) {
        return By.id(field+"-error");
    }

    public By duplicateEmailErrorMessage() {
        return By.cssSelector(".message-error.validation-summary-errors");
    }
}
