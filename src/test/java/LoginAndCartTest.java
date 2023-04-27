import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndCartTest extends BaseTest {

    String expectedSuccessMessage = "Swag Labs";
    String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    String expectedResult = "1";

    Logger logger = Logger.getLogger(LoginAndCartTest.class);

    @Test(priority = 1)
    @Description("TestCorrectLogin is ................................")
    @Epic("Checking correct user ...................")
    public void TestCorrectLogin() {
        logger.info("TestCorrectLogin started");
        mainPage.fillCorrectLoginAndSend();
        Assert.assertEquals(mainPage.getSuccessMessage(), expectedSuccessMessage, "Actual success message is " + "'" + mainPage.getSuccessMessage() + "'");
    }

    @Test(priority = 2)
    @Description("TestIncorrectLogin is ......................................")
    @Epic("Checking incorrect user ...................")
    public void TestIncorrectLogin() {
        logger.info("TestIncorrectLogin started");
        mainPage.fillIncorrectLoginAndSend();
        Assert.assertEquals(mainPage.getErrorMessage(), expectedErrorMessage, "Actual error message is " + "'" + mainPage.getErrorMessage() + "'");
    }

    @Test(priority = 3)
    @Description("TestBasket is ......................................")
    @Epic("Adding a good ...................")
    @Feature("Shop functionality")
    public void TestGoodInABasket() {
        logger.info("TestBasket started");
        mainPage.fillCorrectLoginAndSend();
        mainPage.addGoodToBasket();
        Assert.assertEquals(mainPage.getGoodInACart(), expectedResult, "Actual goods in the cart " + "'" + expectedResult + "'");
    }
}
