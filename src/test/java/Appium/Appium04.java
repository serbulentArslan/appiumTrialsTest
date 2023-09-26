package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\serars\\IdeaProjects\\appiumProject\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        if (driver.isDeviceLocked()){
            driver.unlockDevice();
        }

        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());

        MobileElement addGestureButton = driver.findElementByXPath("//android.widget.Button[@text='Add gesture']");
        addGestureButton.click();

        Thread.sleep(2000);
        MobileElement createAGestureTitle = driver.findElementByXPath("//android.widget.TextView[@text='Create a gesture']");
        Assert.assertTrue(createAGestureTitle.isDisplayed());

        MobileElement nameArea = driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
        nameArea.sendKeys("appiumTest");

        MobileElement spaceArea = driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay");
        spaceArea.click();

        MobileElement doneButton = driver.findElementById("com.davemac327.gesture.tool:id/done");
        doneButton.click();

        MobileElement gestureToolTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(gestureToolTitle.isDisplayed());


        driver.hideKeyboard();


    }
}
