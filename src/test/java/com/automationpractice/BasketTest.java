package com.automationpractice;

import org.testng.annotations.Test;
import project.BasketPage;
import project.MainPage;

import static org.testng.Assert.assertEquals;

public class BasketTest extends BaseTest {

    public final MainPage mainPage = new MainPage(driver);
    public final BasketPage basketPage = new BasketPage(driver);

    @Test
    public void testCanCheckPriceMatch() {
        String expected = mainPage.priceBeforeBasket();
        mainPage.addItemToBasket();
        assertEquals(expected, basketPage.basketPrice());
    }
}
