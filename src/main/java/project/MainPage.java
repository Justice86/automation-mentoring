package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testSelenium.configs.DriverConfigs;

import java.util.List;

public class MainPage {
    
    public WebDriver driver;

    DriverConfigs driverConfigs = new DriverConfigs();

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy (className = "button-search")
    private WebElement searchButton;

    @FindBy (className = "product_img_link")
    private List<WebElement> products;

    @FindBy (css = "div[class='right-block'] span[itemprop='price']:first-child")
    private WebElement productPrice;

    @FindBy (css = "a[data-id-product='1']")
    private WebElement addProductToBasketButton;

    @FindBy (css = "a[class='btn btn-default button button-medium']")
    private WebElement agreePopupButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String search){
        searchField.sendKeys(search);
        searchButton.click();
    }

    public boolean isElementPresent() {
        return products.size() > 0;
    }

    public String priceBeforeBasket() {
        return productPrice.getText().trim();
    }

    public void addItemToBasket() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driverConfigs.scrollDown(driver);
        WebElement imageLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='product_img_link']")));
        driverConfigs.onMouseOver(imageLink, driver);
        addProductToBasketButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(agreePopupButton));
        agreePopupButton.click();
    }
}
