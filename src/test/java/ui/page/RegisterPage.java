package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.RegisterMap;

import java.util.concurrent.TimeUnit;

public class RegisterPage {
    private RegisterMap registerMap = new RegisterMap();
    public void fillFormFieldTextBox(WebDriver driver, String gender, String firstName, String lastName, String email,
                                     String password) {
        implicitWaitTimout(5, driver);
        if(gender.equals("male"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        else if (gender.equals("female"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        driver.findElement(registerMap.inputTextfield("FirstName")).sendKeys(firstName);
        driver.findElement(registerMap.inputTextfield("LastName")).sendKeys(lastName);
        driver.findElement(registerMap.inputTextfield("Email")).sendKeys(email);
        driver.findElement(registerMap.inputTextfield("Password")).sendKeys(password);
        driver.findElement(registerMap.inputTextfield("ConfirmPassword")).sendKeys(password);
        driver.findElement(registerMap.registerButton()).click();
    }

    public void assertAccountSuccessMessage(WebDriver driver, String message) {
        implicitWaitTimout(5, driver);
        String actualSuccessMessage = driver.findElement(registerMap.successMessage()).getText();
        Assert.assertEquals(actualSuccessMessage, message);
    }
    private void implicitWaitTimout(int time, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void fillFormFieldTextBoxExceptFirstName(WebDriver driver, String gender, String lastName, String email,
                                                    String password) {
        implicitWaitTimout(5, driver);
        if(gender.equals("male"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        else if (gender.equals("female"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        driver.findElement(registerMap.inputTextfield("LastName")).sendKeys(lastName);
        driver.findElement(registerMap.inputTextfield("Email")).sendKeys(email);
        driver.findElement(registerMap.inputTextfield("Password")).sendKeys(password);
        driver.findElement(registerMap.inputTextfield("ConfirmPassword")).sendKeys(password);
        driver.findElement(registerMap.registerButton()).click();
    }

    public void assertErrorMessage(WebDriver driver, String firstName, String message) {
        implicitWaitTimout(5, driver);
        String actualErrorMessage = driver.findElement(registerMap.errorMessage(firstName)).getText();
        Assert.assertEquals(actualErrorMessage, message);
    }

    public void fillFormFieldTextBoxExceptLastName(WebDriver driver, String gender, String firstName, String email,
                                                   String password) {
        implicitWaitTimout(5, driver);
        if(gender.equals("male"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        else if (gender.equals("female"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        driver.findElement(registerMap.inputTextfield("FirstName")).sendKeys(firstName);
        driver.findElement(registerMap.inputTextfield("Email")).sendKeys(email);
        driver.findElement(registerMap.inputTextfield("Password")).sendKeys(password);
        driver.findElement(registerMap.inputTextfield("ConfirmPassword")).sendKeys(password);
        driver.findElement(registerMap.registerButton()).click();
    }

    public void fillFormFieldTextBoxWithDuplicateEmailField(WebDriver driver, String gender, String firstName,
                                                            String lastName, String email, String password) {
        implicitWaitTimout(5, driver);
        if(gender.equals("male"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        else if (gender.equals("female"))
            driver.findElement(registerMap.genderRadioButton(gender)).click();
        driver.findElement(registerMap.inputTextfield("FirstName")).sendKeys(firstName);
        driver.findElement(registerMap.inputTextfield("LastName")).sendKeys(lastName);
        driver.findElement(registerMap.inputTextfield("Email")).sendKeys(email);
        driver.findElement(registerMap.inputTextfield("Password")).sendKeys(password);
        driver.findElement(registerMap.inputTextfield("ConfirmPassword")).sendKeys(password);
        driver.findElement(registerMap.registerButton()).click();
    }

    public void assertDuplicateErrorMessage(WebDriver driver, String message) {
        implicitWaitTimout(5, driver);
        String actualErrorMessage = driver.findElement(registerMap.duplicateEmailErrorMessage()).getText();
        Assert.assertEquals(actualErrorMessage, message);

    }
}
