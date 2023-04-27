package pageOblects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(300));
    }
}
