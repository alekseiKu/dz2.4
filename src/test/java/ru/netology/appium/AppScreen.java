package ru.netology.appium;

import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppScreen {
    @AndroidFindBy(id = "userInput")
    public MobileElement inputField;

    @AndroidFindBy(id = "buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textToBeChanged;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "text")
    public MobileElement activityText;

    private AppiumDriver  driver;

    public AppScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}

