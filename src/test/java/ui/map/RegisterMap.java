package ui.map;

import org.openqa.selenium.By;

public class RegisterMap {
    public By firstNameTextBox() {
        return By.cssSelector("input[name='customer_firstname']");
    }

    public By lastNameTextBox() {
        return By.cssSelector("input[name='customer_lastname']");
    }

    public By passwordTextBox() {
        return By.cssSelector("input[name='passwd']");
    }

    public By addressTextBox() {
        return By.cssSelector("input[name='address1']");
    }

    public By cityTextBox() {
        return By.cssSelector("input[name='city']");
    }

    public By stateDropDown() {
        return By.cssSelector("select[name='id_state']");
    }

    public By selectParticularStateDropDown(String state) {
        return By.cssSelector("#id_state > option:nth-child(2)");
    }

    public By zipcodeTextBox() {
        return By.cssSelector("input[name='postcode']");
    }

    public By mobileNoTextBox() {
        return By.cssSelector("input[name='phone_mobile']");
    }

    public By addressRefTextBox() {
        return By.cssSelector("input[name='alias']");
    }

    public By registerButton() {
        return By.cssSelector("button[name='submitAccount']");
    }

    public By dateDropDown() {
        return By.cssSelector("select[name='days']");
    }

    public By monthDropDown() {
        return By.cssSelector("select[name='months']");
    }

    public By yearDropDown() {
        return By.cssSelector("select[name='years']");
    }

    public By particularDateDropDown() {
        return By.cssSelector("#days > option:nth-child(2)");
    }

    public By particularMonthDropDown() {
        return By.cssSelector("#months > option:nth-child(2)");
    }

    public By particularYearDropDown() {
        return By.cssSelector("#years > option:nth-child(2)");
    }
}
