package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    private final WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public String basketPrice(){
        return driver.findElement(By.id("total_product")).getText().trim();
    }
}
