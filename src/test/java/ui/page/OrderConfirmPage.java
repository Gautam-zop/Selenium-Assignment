package ui.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.map.OrderConfirmMap;

public class OrderConfirmPage {
    private OrderConfirmMap orderConfirmMap = new OrderConfirmMap();
    public void assertOrderDetails(WebDriver webDriver, String message) {
        String actualConfirmationText  = webDriver.findElement(orderConfirmMap.confirmationText()).getText();
        Assert.assertEquals(actualConfirmationText, message);
    }
}
