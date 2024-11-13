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
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({ITestListener.class, IInvokedListener.class})
public class TC03_makeApointmentTC {


    public String userName = UtilityData.readDataFromJsonFile("validLoginData", "userName");
    public String password = UtilityData.readDataFromJsonFile("validLoginData", "password");
    private Set<Cookie> cookies;
/*
    @BeforeClass
    public void loginPreCondition() {
        DriverFactory.setupDriver(UtilityData.readDataFromPropertyFile("ENV", "Browser"));
        UtilityLogs.info("the browser is opening......");
        getDriver().get(UtilityData.readDataFromPropertyFile("ENV", "landingUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        UtilityLogs.info("the landing page Url is opening.....");
        new P01_LandingPage(getDriver())
                .goToLoginForm()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickOnLoginBtn();
        cookies = UtilityClasses.getAllCookies(getDriver());
        System.out.println("//////////////" + cookies);
        DriverFactory.tearDown();
    }
*/

    @BeforeMethod
    public void setup() {
        DriverFactory.setupDriver(UtilityData.readDataFromPropertyFile("ENV", "Browser"));
        getDriver().get(UtilityData.readDataFromPropertyFile("ENV", "landingUrl"));
        UtilityLogs.info("the browser is opening......");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Description("test makeAppointment feature with valid data ")
    @Epic("Web App")
    @Feature("makeAppointment feature")
    @Story("valid makeAppointment")
    @Test(priority = 1)
    public void makeAppointmentOne() {
        new P01_LandingPage(getDriver()).goToLoginForm()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickOnLoginBtn()
                .selectFacility("Hongkong CURA Healthcare Center")
                .checkHospitalReadmission()
                .clickOnRadioProgramMedicaid("medicare")

                .enterVisitDate(UtilityData.readDataFromJsonFile("appointmentData", "Date"))
                .addComment(UtilityData.readDataFromJsonFile("appointmentData", "comment"))
                .submitAppointment();

        Assert.assertTrue(new P03_makeAppointmentPage(getDriver()).assertOnConfirmationAppointmentURL(UtilityData.readDataFromPropertyFile("ENV", "appointmentConfirmURL")));
        Assert.assertEquals(new P03_makeAppointmentPage(getDriver()).assertOnConfirmAppoimtmentText(), "Appointment Confirmation");
        Assert.assertEquals(new P03_makeAppointmentPage(getDriver()).assertOnDateEntering(), UtilityData.readDataFromJsonFile("appointmentData", "Date"));
        Assert.assertEquals(new P03_makeAppointmentPage(getDriver()).assertOnCommentEntering(), UtilityData.readDataFromJsonFile("appointmentData", "comment"));

        new P03_makeAppointmentPage(getDriver()).goToHomePage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnUrl(UtilityData.readDataFromPropertyFile("ENV", "landingUrl")));


    }

    @Description("test makeAppointment feature with valid data ")
    @Epic("Web App")
    @Feature("makeAppointment feature")
    @Story("valid makeAppointment")
    @Test(priority = 2)
    public void makeAppointmentTwo() {
        new P01_LandingPage(getDriver()).goToLoginForm()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickOnLoginBtn()
                .selectFacility("Seoul CURA Healthcare Center")
                .checkHospitalReadmission()
                .clickOnRadioProgramMedicaid("none")

                .enterVisitDate(UtilityData.readDataFromJsonFile("appointmentData", "Date"))
                .addComment(UtilityData.readDataFromJsonFile("appointmentData", "comment"))
                .submitAppointment();

        Assert.assertTrue(new P03_makeAppointmentPage(getDriver()).assertOnConfirmationAppointmentURL(UtilityData.readDataFromPropertyFile("ENV", "appointmentConfirmURL")));
        Assert.assertEquals(new P03_makeAppointmentPage(getDriver()).assertOnConfirmAppoimtmentText(), "Appointment Confirmation");
        Assert.assertEquals(new P03_makeAppointmentPage(getDriver()).assertOnDateEntering(), UtilityData.readDataFromJsonFile("appointmentData", "Date"));
        Assert.assertEquals(new P03_makeAppointmentPage(getDriver()).assertOnCommentEntering(), UtilityData.readDataFromJsonFile("appointmentData", "comment"));

        new P03_makeAppointmentPage(getDriver()).goToHomePage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnUrl(UtilityData.readDataFromPropertyFile("ENV", "landingUrl")));

    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.tearDown();
        UtilityLogs.info("the browser is closed.....");
    }

//    @AfterClass
//    private void deleteSession() {
//        cookies.clear();
//    }


}
