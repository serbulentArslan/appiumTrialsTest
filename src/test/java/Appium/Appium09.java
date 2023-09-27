package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium09 extends BaseClass{
    @Test
    public void testName() throws MalformedURLException, InterruptedException {
        //DesiredCapabilities capabilities = new DesiredCapabilities();
//
        //capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\serars\\IdeaProjects\\appiumProject\\src\\Apps\\ApiDemos.apk");
        //capabilities.setCapability("appPackage", "io.appium.android.apis");
        //capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        //capabilities.setCapability("noReset", true);
//
        //AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        AndroidDriver driver = getAndroidDriver();

        //Prefence butonuna tıkla
        driver.findElementByAccessibilityId("Preference").click();

        //Prefence dependencies butonuna tıkla
        driver.findElementByAccessibilityId("3. Preference dependencies").click();

        //Wifi checkbox'a tıkla
        WebElement wifiButton = driver.findElementById("android:id/checkbox");
        if (wifiButton.getAttribute("checked").contains("false")){
            wifiButton.click();
        }

        //tıklandığını doğrula
        Assert.assertEquals(wifiButton.getAttribute("checked"),"true");

        //Wifi settings butonuna tıkla
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();

        //pencerenin açıldıgını dogrula
        WebElement wifiTitle = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        Assert.assertTrue(wifiTitle.isDisplayed());

        //text gönder
        driver.findElementById("android:id/edit").sendKeys("text");

        //ok butonuna tıkla
        driver.findElementById("android:id/button1").click();

    }


}
