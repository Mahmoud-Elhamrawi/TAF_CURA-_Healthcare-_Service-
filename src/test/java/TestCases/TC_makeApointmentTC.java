package TestCases;

import DriverFactory.DriverFactory;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Pages.P01_LandingPage;
import Pages.P03_makeAppointmentPage;
import Utilities.UtilityData;
import Utilities.UtilityLogs;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({ITestListener.class, IInvokedListener.class})
public class TC_makeApointmentTC {


    public String userName = UtilityData.readDataFromJsonFile("validLoginData", "userName");
    public String password = UtilityData.readDataFromJsonFile("validLoginData", "password");

    @BeforeMethod
    public void setup() {
        DriverFactory.setupDriver(UtilityData.readDataFromPropertyFile("ENV", "Browser"));
        UtilityLogs.info("the browser is opening......");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(UtilityData.readDataFromPropertyFile("ENV", "landingUrl"));
        UtilityLogs.info("the landing Url is opening.....");

    }

    @Description("test makeAppointment feature with valid data ")
    @Epic("Web App")
    @Feature("makeAppointment feature")
    @Story("valid makeAppointment")
    @Test(priority = 1)
    public void makeAppointment() {
        new P01_LandingPage(getDriver()).goToLoginForm()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickOnLoginBtn()
                .scrollToEle()
                .selectFacility()
                .checkHospitalReadmission()
                .clickOnRadioProgramMedicaid()
                .enterVisitDate(UtilityData.readDataFromJsonFile("appointmentData", "Date"))
                .addComment(UtilityData.readDataFromPropertyFile("appointmentData", "comment"))
                .submitAppointment();
        new P03_makeAppointmentPage(getDriver()).assertOnConfirmationAppointment(UtilityData.readDataFromPropertyFile("ENV", "appointmentConfirmURL"));


    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.tearDown();
        UtilityLogs.info("the browser is closed.....");
    }


}
