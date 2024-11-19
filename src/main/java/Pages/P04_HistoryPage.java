package Pages;

import Utilities.UtilityClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_HistoryPage {
    private final WebDriver driver;
    private final By facility = By.id("facility");
    private final By program = By.id("program");
    private final By comment = By.id("comment");
    private final By Date = By.className("panel-heading");


    public P04_HistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_HistoryPage assertOnFacility() {

        UtilityClasses.getTextFromEle(driver, facility);
        return this;
    }

    public P04_HistoryPage assertOnProgram() {

        UtilityClasses.getTextFromEle(driver, program);
        return this;
    }

    public P04_HistoryPage assertOnComment() {

        UtilityClasses.getTextFromEle(driver, comment);
        return this;
    }

    public P04_HistoryPage checkOnHistoryData() {

        UtilityClasses.getTextFromEle(driver, Date);
        return this;
    }
}
