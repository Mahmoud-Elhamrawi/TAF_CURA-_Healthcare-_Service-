package TestCases;

import DriverFactory.DriverFactory;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Pages.P01_LandingPage;
import Pages.P04_HistoryPage;
import Utilities.UtilityData;
import Utilities.UtilityLogs;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;


@Listeners({ITestListener.class, IInvokedListener.class})

public class TC04_HistoryTest {
    public String userName = UtilityData.readDataFromJsonFile("validLoginData", "userName");
    public String password = UtilityData.readDataFromJsonFile("validLoginData", "password");


    @BeforeMethod
    public void setup() {
        DriverFactory.setupDriver(UtilityData.readDataFromPropertyFile("ENV", "Browser"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().get(UtilityData.readDataFromPropertyFile("ENV", "landingUrl"));
        UtilityLogs.info("the browser is opening......");
    }

    @Description("test confimration feature with valid data ")
    @Epic("Web App")
    @Feature("makeAppointment feature")
    @Story("valid makeAppointment")
    @Test()
    public void testConfirmApp() {

        new P01_LandingPage(getDriver()).goToLoginForm()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickOnLoginBtn()
                .selectFacility(UtilityData.readDataFromJsonFile("appointmentData", "Facility"))
                .checkHospitalReadmission()
                .clickOnRadioProgramMedicaid(UtilityData.readDataFromJsonFile("appointmentData", "Healthcare"))

                .enterVisitDate(UtilityData.readDataFromJsonFile("appointmentData", "Date"))
                .addComment(UtilityData.readDataFromJsonFile("appointmentData", "comment"))
                .submitAppointment();


        Assert.assertEquals(new P04_HistoryPage(getDriver()).assertOnFacility(), UtilityData.readDataFromJsonFile("Appointment", "Facility"));
        Assert.assertEquals(new P04_HistoryPage(getDriver()).assertOnProgram(), UtilityData.readDataFromJsonFile("Appointment", "Healthcare"));
        Assert.assertEquals(new P04_HistoryPage(getDriver()).assertOnComment(), UtilityData.readDataFromJsonFile("Appointment", "comment"));
        Assert.assertEquals(new P04_HistoryPage(getDriver()).checkOnHistoryData(), UtilityData.readDataFromJsonFile("Appointment", "Date"));


        UtilityLogs.info(UtilityData.readDataFromJsonFile("Appointment", "Facility"));
        UtilityLogs.info(UtilityData.readDataFromJsonFile("Appointment", "Healthcare"));
        UtilityLogs.info(UtilityData.readDataFromJsonFile("Appointment", "comment"));
        UtilityLogs.info(UtilityData.readDataFromJsonFile("Appointment", "Date"));


    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.tearDown();
        UtilityLogs.info("the browser is closed.....");
    }


}
