package pageOblects;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final By EMAIL = By.xpath("//input[@data-test='username']");
    private static final By PASSWORD = By.xpath("//input[@data-test='password']");
    private static final By LOGIN = By.xpath("//input[@data-test='login-button']");
    private static By errorText = By.xpath("//h3[@data-test=\"error\"]/text()");
    private static By successHeader = By.xpath("//div[@class='app_logo']");
    String correctUsername = "standard_user";
    String incorrectUsername = "locked_out_user";
    String correctPassword = "secret_sauce";
    String incorrectPassword = "123";

    private static final By ADD_TO_CART_BUTTON = By.xpath("//button[@data-test=\"add-to-cart-sauce-labs-backpack\"]");
    private static final By CART_ITEM = By.xpath("//span[@class='shopping_cart_badge']");

    Logger logger = Logger.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectLoginAndSend() {
        logger.info("start filling with " + incorrectUsername);
        $(EMAIL).shouldBe(Condition.exist).sendKeys(incorrectUsername);
        logger.info("start filling with " + incorrectPassword);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(incorrectPassword);
        logger.info("start clicking button " + LOGIN);
        $(LOGIN).shouldBe(Condition.exist).click();
        logger.info("method 'fillIncorrectLoginAndSend' ended");
    }

    public void fillCorrectLoginAndSend() {
        logger.info("start filling " + correctUsername);
        $(EMAIL).shouldBe(Condition.exist).sendKeys(correctUsername);
        logger.info("start filling " + correctPassword);
        $(PASSWORD).shouldBe(Condition.exist).sendKeys(correctPassword);
        logger.info("start clicking button " + LOGIN);
        $(LOGIN).shouldBe(Condition.exist).click();
        logger.info("method 'fillCorrectLoginAndSend' ended");
    }

    public void addGoodToBasket() {
        logger.info("Start clicking " + ADD_TO_CART_BUTTON);
        $(ADD_TO_CART_BUTTON).shouldBe(Condition.exist).click();
    }

    public String getErrorMessage() {
        logger.info("start getting error message: " + $(errorText).shouldBe(Condition.visible).getText());
        return $(errorText).shouldBe(Condition.visible).getText();
    }

    public String getSuccessMessage() {
        logger.info("start getting success message: " + $(successHeader).shouldBe(Condition.visible).getText());
        return $(successHeader).shouldBe(Condition.visible).getText();
    }

    public String getGoodInACart() {
        logger.info("start getting goods: " + $(CART_ITEM).shouldBe(Condition.visible).getText());
        return $(CART_ITEM).shouldBe(Condition.visible).getText();
    }
}
