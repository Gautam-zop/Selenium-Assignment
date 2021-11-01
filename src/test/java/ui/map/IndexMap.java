package ui.map;

import org.openqa.selenium.By;

public class IndexMap {
    public By registerButton() {
        return By.cssSelector(".ico-register");
    }

    public By loginButton() {
        return By.cssSelector(".ico-login");
    }

    public By electronicButton() {
        return By.cssSelector(".top-menu.notmobile li a[href='/electronics']");
    }

    public By computerButton() {
        return By.cssSelector("ul.top-menu.notmobile li a[href='/computers']");
    }
}
