package TestCases;

import DriverFactory.DriverFactory;
import Pages.P01_LandingPage;
import Pages.P02_LoginPage;
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
import Listeners.*;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;


@Listeners({ITestListener.class, IInvokedListener.class})
public class TC02_LoginTC {

public String userName = UtilityData.readDataFromJsonFile("validLoginData","userName") ;
public String password = UtilityData.readDataFromJsonFile("validLoginData","password") ;
    @BeforeMethod
    public void setup() {
        DriverFactory.setupDriver(UtilityData.readDataFromPropertyFile("ENV","Browser"));
        UtilityLogs.info("the browser is opening......");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(UtilityData.readDataFromPropertyFile("ENV","landingUrl"));
        UtilityLogs.info("the landing Url is opening.....");

    }

@Test(priority = 1)
@Description("test login feature with valid data ")
@Epic("Web App")
@Feature("login feature")
@Story("valid login")
public void validLogin()
{
     new  P01_LandingPage(getDriver()).goToLoginForm()
                     .enterUserName(userName)
                             .enterUserPassword(password)
                                     .clickOnLoginBtn() ;
    Assert.assertTrue(new P02_LoginPage(getDriver()).assertOnHomeUrl(UtilityData.readDataFromPropertyFile("ENV","HomePage")));
}



    @Test(priority = 2)
    @Description("test invalid login feature with in valid user name ")
    @Epic("Web App")
    @Feature("login feature")
    @Story("invalid login")
    public void inValidLogin()
    {
        new  P01_LandingPage(getDriver()).goToLoginForm()
                .enterUserName("jon d")
                    .enterUserPassword(password)
                       .clickOnLoginBtn() ;


        Assert.assertEquals(new P02_LoginPage(getDriver()).assertOnTextDanger(),"Login failed! Please ensure the username and password are valid.");
    }


    @Test(priority = 3)
    @Description("test invalid login feature with empty coordination")
    @Epic("Web App")
    @Feature("login feature")
    @Story("invalid login")
    public void inValidLoginTwo()
    {
        new  P01_LandingPage(getDriver()).goToLoginForm()
                .enterUserName("")
                .enterUserPassword("")
                .clickOnLoginBtn() ;
        Assert.assertEquals(new P02_LoginPage(getDriver()).assertOnTextDanger(),"Login failed! Please ensure the username and password are valid.");
    }



    @AfterMethod
    public void tearDown()
    {
        DriverFactory.tearDown();
        UtilityLogs.info("the browser is closed.....");
    }



    }
