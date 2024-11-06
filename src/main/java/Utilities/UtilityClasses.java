package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class UtilityClasses {


    public static final String file_path = "test-outputs/screen-shots/";

    //TODO::clicking on Ele
    public static void clickOnEle(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //TODO::send Data
    public static void sendData(WebDriver driver, By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //TODO::get Text
    public static String getTextFromEle(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    //TODO::General Wait
    public static void waiting(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //TODO::Scrolling
    public static void scroll(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));

    }

    //TODO:: generate timestamp
    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd h-m-ssa").format(new Date());

    }

    //TODO::Taking ScreenShot
    public static void takeScreenShot(WebDriver driver, String screenName) {
        try {
            File screenSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenDis = new File(file_path + screenName + "_" + timestamp() + ".png");
            FileUtils.copyFile(screenSrc, screenDis);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //TODO::Selecting from drop-down
    public static void selectDropDown(WebDriver driver, By locator, String value) {
        new Select(driver.findElement(locator)).selectByValue(value);
    }

    //TODO::convert locator to WebEle
    public static WebElement convertEle(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    //TODO:: add set cookies
    public static Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    //TODO:: restore cookies
    public static void restoreCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);

        }
    }


}
