package org.outofmilk;

/**
 * Created by Araks on 7/30/17.
 */

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetup {
    public WebDriver driver;
//    File classpathRoot = new File(System.getProperty("user.dir"));
//    File appDir = new File(classpathRoot,"apps");
//    File app = new File(appDir, "lib.apk");

    File currDir = new File("");
    String path = currDir.getAbsolutePath();
    String myapp = path + ".apps/com.capigami.outofmilk.apk";

    protected void prepareAndroidForAppium() throws IOException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.6.5");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("deviceName", "SM_N900");
        capabilities.setCapability("udid", "4d00546c5663a0e1");
        capabilities.setCapability("newCommandTimeout", 60);
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability("appPath", myapp);
        capabilities.setCapability("appPackage", "com.capigami.outofmilk");
        capabilities.setCapability("appActivity", ".MainActivity");capabilities.setCapability("resetKeyboard", true);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}

