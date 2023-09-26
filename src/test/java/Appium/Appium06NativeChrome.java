package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06NativeChrome {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        driver.get("https://www.amazon.com");


        Thread.sleep(7000);
        MobileElement homeScreenLogo = driver.findElementByXPath("//android.view.View[@text='Amazon']");
        Assert.assertTrue(homeScreenLogo.isDisplayed());

        MobileElement signInButton = driver.findElementByXPath("//android.view.View[@text='Sign in ›']");
        signInButton.click();

        Thread.sleep(4000);
        MobileElement welcomeText = driver.findElementByXPath("//android.view.View[@text='Welcome']");
        Assert.assertEquals(welcomeText.getText(),"Welcome");

        driver.navigate().back();


    }
}
