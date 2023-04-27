package org.example;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listener implements ITestListener {
    Logger logger = Logger.getLogger(Listener.class);
    static WebDriver driver;


    @Override
    public void onTestFailure(ITestResult result) {
        //getScreen();
        logger.info("Start screenshot");
        attachScreenshot();
        logger.info("End screenshot");
        logger.info("Test failed");
    }


    public File getScreen(){
        String fileName;
        logger.info("start getting screenshot");
        File screenshot = ((TakesScreenshot)
                WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
        fileName = "src/main/resources/screenshots/screen_" + System.currentTimeMillis() + ".png";
        File res = new File(fileName);
        try {
            FileUtils.copyFile(screenshot, res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("screenshot was saved to " + fileName);
        return res;
    }

    @Attachment
    public byte[] attachScreenshot()  {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
