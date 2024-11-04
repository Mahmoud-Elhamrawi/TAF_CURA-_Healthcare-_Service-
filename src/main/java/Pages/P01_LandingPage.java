package Pages;

import Utilities.UtilityClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_LandingPage {

    public WebDriver driver ;

    public P01_LandingPage(WebDriver driver)
    {
        this.driver = driver ;
    }

    private final By makeAppointmentBtn = By.id("btn-make-appointment") ;




    public P02_LoginPage goToLoginForm()
    {
        UtilityClasses.clickOnEle(driver,makeAppointmentBtn);
        return new P02_LoginPage(driver);
    }


    public boolean assertOnUrl(String expectUrl)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(expectUrl));
    }

}
