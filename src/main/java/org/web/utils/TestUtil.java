package org.web.utils;

import org.web.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 90;
    public static long IMPLICIT_WAIT = 30;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(
                currentDir + "//screenshots//" + System.currentTimeMillis()
                        + ".jpg"));
    }

    public static boolean isDisplayedForElement(WebDriver driver, WebElement element, long timeoutInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element))
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}