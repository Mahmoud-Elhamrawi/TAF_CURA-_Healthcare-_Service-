package TestCases;

import DriverFactory.DriverFactory;
import Pages.P01_LandingPage;
import Utilities.UtilityData;
import Utilities.UtilityLogs;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.*;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
@Listeners({ITestListener.class, IInvokedListener.class})
public class TC01_LandingTC {


    @BeforeMethod
    public void setup()
    {
        DriverFactory.setupDriver(UtilityData.readDataFromPropertyFile("ENV","Browser"));
        UtilityLogs.info("the browser is opening......");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(UtilityData.readDataFromPropertyFile("ENV","landingUrl"));
        UtilityLogs.info("the landing Url is opening.....");

    }


    @Test
    public void openLandingPage() {
        new P01_LandingPage(getDriver()).goToLoginForm();
        UtilityLogs.info("navigate to Form Page...");
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnUrl(UtilityData.readDataFromPropertyFile("ENV","LoginUrl")));
    }


  @AfterMethod
    public void tearDown()
    {
        DriverFactory.tearDown();
        UtilityLogs.info("the Browser is closed....");
    }


}
