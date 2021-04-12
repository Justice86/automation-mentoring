package testSelenium.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(BrowserTypes type){
        switch (type){
            case ChromeBrowser:
                System.setProperty("webdriver.chrome.driver", "//Users//zhovtukha//Downloads//chromedriver");
                return new ChromeDriver();
            case SafariBrowser:
                return new SafariDriver();
            case FirefoxBrowser:
                System.setProperty("webdriver.gecko.driver", "//Users//zhovtukha//Downloads//geckodriver");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("No browser selected");
        }
    }
}
