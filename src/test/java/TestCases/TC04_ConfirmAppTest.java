package TestCases;

import DriverFactory.DriverFactory;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Utilities.UtilityData;
import Utilities.UtilityLogs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;


@Listeners({ITestListener.class, IInvokedListener.class})

public class TC04_ConfirmAppTest {


    @BeforeMethod
    public void setup() {
        DriverFactory.setupDriver(UtilityData.readDataFromPropertyFile("ENV", "Browser"));
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        DriverFactory.getDriver().get(UtilityData.readDataFromPropertyFile("ENV", "landingUrl"));
        UtilityLogs.info("the browser is opening......");
    }

    @Test
    private void testConfirmApp() {


    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.tearDown();
        UtilityLogs.info("the browser is closed.....");
    }


}
