package org.screens;

import org.openqa.selenium.*;

/**
 * Created by Araks on 7/31/17.
 */
public class ShoppingListScreen {
        public WebDriver driver;

        public ShoppingListScreen(WebDriver driver) {
            this.driver = driver;
        }

        private final By ADD_ITEM_FIELD = By.id("com.capigami.outofmilk:id/input");
        private final By SUBMIT_BUTTON = By.id("com.capigami.outofmilk:id/submit");
        private final By ITEM_DESCRIPTION = By.id("com.capigami.outofmilk:id/description");
        private final By OK_BTN_POPUP = By.id("android:id/button1");


        public boolean addItemFieldDisplayed() {
            if (driver.findElement(ADD_ITEM_FIELD).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        }
        public void addItem(String value) {
            WebElement myInput = driver.findElement(ADD_ITEM_FIELD);
            myInput.sendKeys(value);
            driver.findElement(SUBMIT_BUTTON).click();
        }

        public boolean checkItemName(String item) {
            String toCompare = driver.findElement(ITEM_DESCRIPTION).getText();
            if(toCompare.equals(item)) {
                return true;
            } else {
                System.out.println("ITEM = " + item + " --toCompare = " + toCompare);
                return false;
            }
        }
        protected boolean isOkPresent() {
            try {
                driver.findElement(OK_BTN_POPUP);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        public void clickOkIfPopupIsDisplayed() {
            if(isOkPresent()) {
                driver.findElement(OK_BTN_POPUP).click();
            } else {
                System.out.println("OK Button is not displayed, continue testing.");
            }
        }

}
