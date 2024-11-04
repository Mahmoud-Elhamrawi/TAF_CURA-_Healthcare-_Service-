package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static void setupDriver(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions chromeOptions =new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driverThreadLocal.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                driverThreadLocal.set(new FirefoxDriver());
                break;
            default:
                driverThreadLocal.set(new EdgeDriver());
        }
    }


      public static WebDriver getDriver()
      {
          return driverThreadLocal.get();
      }

      public static void tearDown()
      {
          getDriver().quit();
          driverThreadLocal.remove();
      }




}
