import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.example.Listener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageOblects.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

@Listeners (Listener.class)
public class BaseTest {
    protected String baseURL = "https://www.saucedemo.com/";
    protected WebDriver webDriver;
    protected MainPage mainPage;

    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void beforeClass() {
        logger.info("Before test started");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        WebDriverRunner.setWebDriver(webDriver);
        mainPage = new MainPage(webDriver);
        logger.info("Before test ended");
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("beforeMethod deleting cookies");
        webDriver.manage().deleteAllCookies();
        logger.info("Opening " + baseURL);
        open(baseURL);
    }

//    @AfterClass
//    public void afterClass() {
//        logger.info("Tests ended");
//        webDriver.quit();
//    }

}
