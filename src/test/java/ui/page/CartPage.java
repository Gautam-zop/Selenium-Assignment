package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ui.map.CartMap;

import java.util.List;

public class CartPage {
    private final CartMap cartMap = new CartMap();
    public void assertCart(WebDriver driver) {
        String actualShoppingCart = driver.findElement(cartMap.cartQTYButton()).getText();
        Assert.assertEquals(actualShoppingCart, "(0)");
    }

    public void navigateToCartButton(WebDriver driver) {
        driver.findElement(cartMap.cartButton()).click();
    }

    public void assertCartProducts(WebDriver driver, List<String> productNames) {
        List<WebElement> productList = driver.findElements(cartMap.cartProducts());
        for(int i=0; i<productList.size(); i++){
            Assert.assertEquals(productList.get(i).getText(), productNames.get(i));
        }
    }

    public void checkIAgreeCheckBox(WebDriver driver) {
        driver.findElement(cartMap.iAgreeCheckbox()).click();
    }

    public void clickContinueButton(WebDriver driver) {
        driver.findElement(cartMap.continueButton()).click();
    }
}
