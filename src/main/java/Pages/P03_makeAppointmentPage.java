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
    private final By radio_program_medicaid = By.id("radio_program_medicaid");
    private final By txt_visit_date = By.id("txt_visit_date");
    private final By txt_comment = By.id("txt_comment");
    private final By btn_appointment = By.id("btn-book-appointment");
    private final By appointmentText = By.cssSelector("section[id=\"summary\"] h2");
    private final By dateAssert = By.id("visit_date");
    private final By commentAssert = By.id("comment");
    private final By GoToHomepage = By.linkText("Go to Homepage");


    public P03_makeAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }


    public P03_makeAppointmentPage selectFacility() {
        UtilityClasses.selectDropDown(driver, combo_facility, "Tokyo CURA Healthcare Center");
        return this;
    }

    public P03_makeAppointmentPage checkHospitalReadmission() {
        UtilityClasses.clickOnEle(driver, chk_hospotal_readmission);
        return this;
    }
    //chk_hospotal_readmission

    public P03_makeAppointmentPage clickOnRadioProgramMedicaid() {
        UtilityClasses.clickOnEle(driver, radio_program_medicaid);
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

    public P04_AppointmentConfirmationPage submitAppointment() {
        UtilityClasses.clickOnEle(driver, btn_appointment);
        return new P04_AppointmentConfirmationPage(driver);
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


}
