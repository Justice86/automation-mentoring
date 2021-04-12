package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testSelenium.configs.DriverConfigs;

public class MainPage extends DriverConfigs {

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String search){
        driver.findElement(By.id("search_query_top")).sendKeys(search);
        driver.findElement(By.className("button-search")).click();
    }

    public boolean isElementPresent() {
        return driver.findElements(By.className("product_img_link")).size() > 0;
    }

    public String priceBeforeBasket() {
        return driver.findElement(By.cssSelector("div[class='right-block'] span[itemprop='price']:first-child")).getText().trim();
    }

    public void addItemToBasket() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        scrollDown();
        WebElement imageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='product_img_link']")));
        onMouseOver(imageLink);
        driver.findElement(By.cssSelector("a[data-id-product='1']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='btn btn-default button button-medium']")));
        driver.findElement(By.cssSelector("a[class='btn btn-default button button-medium']")).click();
    }
}
