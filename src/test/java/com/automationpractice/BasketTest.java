package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import project.BasketPage;
import project.MainPage;
import testSelenium.configs.BrowserTypes;
import testSelenium.configs.SeleniumConfig;
import testSelenium.configs.WebDriverFactory;

import static org.testng.Assert.assertEquals;

public class BasketTest {

    private static final WebDriver driver = WebDriverFactory.getWebDriver(BrowserTypes.SafariBrowser);
    private final SeleniumConfig seleniumConfig = new SeleniumConfig(driver);
    private final BasketPage basketPage = new BasketPage(driver);
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
    public void testCanCheckPriceMatch() throws InterruptedException {
        String expected = mainPage.priceBeforeBasket();
        mainPage.addItemToBasket();
        assertEquals(expected, basketPage.basketPrice());
    }
}
