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
    private final By logout = By.linkText("Logout");


    public P04_HistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String assertOnFacility() {

        return UtilityClasses.getTextFromEle(driver, facility);

    }

    public String assertOnProgram() {

        return UtilityClasses.getTextFromEle(driver, program);
    }

    public String assertOnComment() {

        return UtilityClasses.getTextFromEle(driver, comment);
    }

    public String checkOnHistoryData() {

        return UtilityClasses.getTextFromEle(driver, Date);
    }


    public P05_logOutPage clickOnLogout() {
        UtilityClasses.clickOnEle(driver, logout);
        return new P05_logOutPage(driver);
    }


}
