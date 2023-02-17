package org.euro.utils;

import org.euro.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

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

    public static boolean isDisplayedForElement(WebDriver driver,
                                                WebElement element, long timeout) {
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }


}