package org.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Araks on 7/30/17.
 */
public class HomeScreen {
    public WebDriver driver;

    public HomeScreen(WebDriver driver) {
        this.driver = driver;
    }

    private final By SKIP_BUTTON = By.id("com.capigami.outofmilk:id/action_skip");

    public void clickSkipButton() {
        driver.findElement(SKIP_BUTTON).click();
    };


}
