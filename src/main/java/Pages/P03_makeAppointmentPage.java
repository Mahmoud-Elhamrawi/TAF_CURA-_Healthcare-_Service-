package Pages;

import Utilities.UtilityClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_makeAppointmentPage {
    private final WebDriver driver;
    private final By appointmentForm = By.className("form-horizontal");
    private final By combo_facility = By.id("combo_facility");
    private final By chk_hospotal_readmission = By.id("chk_hospotal_readmission");
    //    private final By radio_program_medicaid = By.xpath("//input[@id=\"radio_program_medicaid\"]");
//    private final By radio_program_medicare = By.xpath("//input[@id=\"radio_program_medicare\"]");
//    private final By radio_program_none =By.xpath("//input[@id=\"radio_program_none\"]");
    private final By txt_visit_date = By.id("txt_visit_date");
    private final By txt_comment = By.id("txt_comment");
    private final By btn_appointment = By.id("btn-book-appointment");
    private final By appointmentText = By.cssSelector("section[id=\"summary\"] h2");
    private final By dateAssert = By.id("visit_date");
    private final By commentAssert = By.id("comment");
    private final By GoToHomepage = By.linkText("Go to Homepage");


    private final By menu_toggle = By.id("menu-toggle");
    private final By historyBtn = By.linkText("History");

    //radio_program_none   radio_program_medicare
    public P03_makeAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }


    public P03_makeAppointmentPage selectFacility(String val) {
        UtilityClasses.selectDropDown(driver, combo_facility, val);
        return this;
    }

    public P03_makeAppointmentPage checkHospitalReadmission() {
        UtilityClasses.clickOnEle(driver, chk_hospotal_readmission);
        return this;
    }


    public P03_makeAppointmentPage clickOnRadioProgramMedicaid(String prog) {
        UtilityClasses.clickOnEle(driver, By.xpath("//input[@id=\"radio_program_" + prog + "\"]"));
        return this;
    }

    public P03_makeAppointmentPage enterVisitDate(String date) {
        UtilityClasses.sendData(driver, txt_visit_date, date);
        return this;
    }

    public P03_makeAppointmentPage addComment(String comment) {
        UtilityClasses.sendData(driver, txt_comment, comment);
        return this;
    }

    public P04_HistoryPage submitAppointment() {
        UtilityClasses.clickOnEle(driver, btn_appointment);
        return new P04_HistoryPage(driver);
    }

    public boolean assertOnConfirmationAppointmentURL(String expectUrl) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectUrl));
    }

    public String assertOnConfirmAppoimtmentText() {
        return UtilityClasses.getTextFromEle(driver, appointmentText);
        //return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(appointmentText));
    }

    public String assertOnDateEntering() {
        return UtilityClasses.getTextFromEle(driver, dateAssert);

    }

    public String assertOnCommentEntering() {
        return UtilityClasses.getTextFromEle(driver, commentAssert);

    }

    public void goToHomePage() {
        UtilityClasses.clickOnEle(driver, GoToHomepage);
    }


    public P03_makeAppointmentPage clickingOnToggle() {
        UtilityClasses.clickOnEle(driver, menu_toggle);
        return this;
    }

    public P04_HistoryPage goToHistoryPage() {
        UtilityClasses.clickOnEle(driver, historyBtn);
        return new P04_HistoryPage(driver);
    }

    public boolean assertOnUrlHistory(String expectUrl) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectUrl));
    }


}
