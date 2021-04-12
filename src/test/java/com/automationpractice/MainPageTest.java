package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import project.MainPage;
import testSelenium.configs.BrowserTypes;
import testSelenium.configs.SeleniumConfig;
import testSelenium.configs.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class MainPageTest {

    private static final WebDriver driver = WebDriverFactory.getWebDriver(BrowserTypes.ChromeBrowser);
    private final SeleniumConfig seleniumConfig = new SeleniumConfig(driver);
    private final MainPage mainPage = new MainPage(driver);

    @BeforeSuite
    public void setUp(){
        seleniumConfig.openBrowser();
    }

    @AfterSuite
    public void tearDown(){
        seleniumConfig.closeBrowser();
    }

    @Test
    public void testCanCheckSearchOption() {
        mainPage.search("dress");
        assertTrue(mainPage.isElementPresent());
    }
}
