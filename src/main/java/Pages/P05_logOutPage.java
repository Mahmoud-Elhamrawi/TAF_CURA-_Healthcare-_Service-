package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P05_logOutPage {
    private final WebDriver driver;

    public P05_logOutPage(WebDriver driver) {

        this.driver = driver;
    }


    public boolean assertOnLogOutUrl(String expectUrl) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectUrl));
    }
}
