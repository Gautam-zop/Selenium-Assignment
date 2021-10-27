package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.map.RegisterMap;

public class RegisterPage {
    private RegisterMap registerMap = new RegisterMap();
    public void register(WebDriver webDriver, String firstName, String lastName, String password,
                         String address, String city, String state, String zipcode, String mobileNo,
                         String addressRef) {

        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerMap.firstNameTextBox()));

        webDriver.findElement(registerMap.firstNameTextBox()).click();
        webDriver.findElement(registerMap.firstNameTextBox()).sendKeys(firstName);

        webDriver.findElement(registerMap.lastNameTextBox()).click();
        webDriver.findElement(registerMap.lastNameTextBox()).sendKeys(lastName);

        webDriver.findElement(registerMap.passwordTextBox()).click();
        webDriver.findElement(registerMap.passwordTextBox()).sendKeys(password);

        webDriver.findElement(registerMap.dateDropDown()).click();
        webDriver.findElement(registerMap.particularDateDropDown());

        webDriver.findElement(registerMap.monthDropDown()).click();
        webDriver.findElement(registerMap.particularMonthDropDown());

        webDriver.findElement(registerMap.yearDropDown()).click();
        webDriver.findElement(registerMap.particularYearDropDown());

        webDriver.findElement(registerMap.addressTextBox()).click();
        webDriver.findElement(registerMap.addressTextBox()).sendKeys(address);

        webDriver.findElement(registerMap.cityTextBox()).click();
        webDriver.findElement(registerMap.cityTextBox()).sendKeys(city);

        webDriver.findElement(registerMap.stateDropDown()).click();
        webDriver.findElement(registerMap.selectParticularStateDropDown(state)).click();

        webDriver.findElement(registerMap.zipcodeTextBox()).click();
        webDriver.findElement(registerMap.zipcodeTextBox()).sendKeys(zipcode);

        webDriver.findElement(registerMap.mobileNoTextBox()).click();
        webDriver.findElement(registerMap.mobileNoTextBox()).sendKeys(mobileNo);

        webDriver.findElement(registerMap.addressRefTextBox()).clear();
        webDriver.findElement(registerMap.addressRefTextBox()).sendKeys(addressRef);

        webDriver.findElement(registerMap.registerButton()).click();
    }
}
