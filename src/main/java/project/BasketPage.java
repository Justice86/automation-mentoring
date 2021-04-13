package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    @FindBy(id = "total_product")
    private WebElement totalPrice;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String basketPrice() {
        return totalPrice.getText().trim();
    }
}
