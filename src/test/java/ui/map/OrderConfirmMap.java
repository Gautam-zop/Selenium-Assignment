package ui.map;

import org.openqa.selenium.By;

public class OrderConfirmMap {
    public By confirmationText() {
        return By.cssSelector("#center_column > div > p > strong");
    }
}
