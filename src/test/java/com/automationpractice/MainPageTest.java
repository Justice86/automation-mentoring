package com.automationpractice;

import org.testng.annotations.Test;
import project.MainPage;

import static org.testng.Assert.assertTrue;

public class MainPageTest extends BaseTest {

    public final MainPage mainPage = new MainPage(driver);
    //public final BasketPage basketPage = new BasketPage(driver);

    @Test
    public void testCanCheckSearchOption() {
        mainPage.search("dress");
        assertTrue(mainPage.isElementPresent());
    }
}
