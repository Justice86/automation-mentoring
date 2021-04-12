package testSelenium.configs;

import org.openqa.selenium.WebDriver;

public class SeleniumConfig {

    private final WebDriver driver;

    public SeleniumConfig(WebDriver driver) {
        this.driver = driver;
    }

    public void openBrowser() {
        driver.get("http://automationpractice.com/index.php");
    }

    public void closeBrowser() {
        driver.close();
    }
}
