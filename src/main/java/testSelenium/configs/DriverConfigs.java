package testSelenium.configs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverConfigs {

    public void onMouseOver (WebElement element, WebDriver driver) {
        try {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false);" +
                    "arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(mouseOverScript, element);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, 500);");
    }
}
