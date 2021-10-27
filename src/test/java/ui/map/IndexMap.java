package ui.map;

import org.openqa.selenium.By;

public class IndexMap {
    public By signInButton() {
        return By.cssSelector(".login");
    }

    public By userNameSpan() {
        return By.cssSelector(".account");
    }

    public By dressesTab() {
        return By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    }

    public By tshirtTab() {
        return By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a");
    }
}