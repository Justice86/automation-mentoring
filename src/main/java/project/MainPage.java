package project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    public boolean onMouseOver(WebElement element)
    {
        boolean result = false;
        try
        {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false);" +
                    "arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(mouseOverScript, element);
            result = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    private final WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, 500);");
        WebElement hoverElement = driver.findElement(By.cssSelector("a[class='product_img_link']"));
        onMouseOver(hoverElement);
        driver.findElement(By.cssSelector("a[data-id-product='1']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='btn btn-default button button-medium']")));
        driver.findElement(By.cssSelector("a[class='btn btn-default button button-medium']")).click();
    }
}
