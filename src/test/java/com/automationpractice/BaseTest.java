package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import testSelenium.configs.BrowserTypes;
import testSelenium.configs.SeleniumConfig;
import testSelenium.configs.WebDriverFactory;

public class BaseTest {

    public static final WebDriver driver = WebDriverFactory.getWebDriver(BrowserTypes.SafariBrowser);
    public final SeleniumConfig seleniumConfig = new SeleniumConfig(driver);

    @BeforeMethod
    public void setUp(){
        seleniumConfig.openBrowser();
    }

    @AfterSuite
    public void tearDown(){
        seleniumConfig.closeBrowser();
    }
}
