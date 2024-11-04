package Pages;


import Utilities.UtilityClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_LoginPage {

    private final WebDriver driver;

    public P02_LoginPage(WebDriver driver)
    {
        this.driver = driver ;
    }



    private final By userInp=  By.id("txt-username") ;
    private final By passInp =  By.id("txt-password");
    private final By loginBtn = By.id("btn-login");
    private final By textDanger = By.xpath("//p[contains(@class,\"text-danger\")]");

    public P02_LoginPage enterUserName(String userName)
    {
        UtilityClasses.sendData(driver ,userInp ,userName);
        return this;
    }

    public P02_LoginPage enterUserPassword(String password)
    {
        UtilityClasses.sendData(driver,passInp,password);
        return this;
    }

    public P03_makeAppointmentPage clickOnLoginBtn()
    {
        UtilityClasses.clickOnEle(driver,loginBtn);
        return new P03_makeAppointmentPage(driver);
    }
public boolean assertOnHomeUrl(String expectUrl)
{
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectUrl));
}


    public String assertOnTextDanger()
    {
        return driver.findElement(textDanger).getText() ;
    }





}
