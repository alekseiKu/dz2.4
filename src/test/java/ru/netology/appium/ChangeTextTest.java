package ru.netology.appium;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ChangeTextTest {

    private AndroidDriver driver;
    private AppScreen screen;
    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "SomeOne");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        screen = new AppScreen(driver);
    }

    @Test
    @Order(1)
    public void sampleTest() {
            String textBefore = screen.textToBeChanged.getText();
            screen.inputField.sendKeys(" ");
            screen.buttonChange.click();
            String textAfter = screen.textToBeChanged.getText();
            assertEquals(textBefore, textAfter);
        }

    @Test
    @Order(2)
    public void testOpenNewActivity() {
        String textToSet = "Netology";
        screen.inputField.sendKeys(textToSet);
        screen.buttonActivity.click();
        String textAfter = screen.activityText.getText();
        assertEquals(textToSet, textAfter);
    }


    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}


