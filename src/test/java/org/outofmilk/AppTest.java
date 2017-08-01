package org.outofmilk;

import org.screens.HomeScreen;
import org.screens.ShoppingListScreen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;

/**
 * Created by Araks on 7/30/17.
 */
public class AppTest extends AndroidSetup {
    HomeScreen homescreen;
    ShoppingListScreen shoppingListScreen;

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        homescreen = new HomeScreen(driver);
        shoppingListScreen = new ShoppingListScreen(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void addItemManually() throws InterruptedException {
        homescreen.clickSkipButton();
        Thread.sleep(3000);
        shoppingListScreen.clickOkIfPopupIsDisplayed();
        String itemName = "MyItemName";
        shoppingListScreen.addItem(itemName);
        Assert.assertTrue(shoppingListScreen.checkItemName(itemName), "Adding new item has failed!");
    }
    
}
