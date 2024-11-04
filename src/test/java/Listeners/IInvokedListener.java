package Listeners;

import Utilities.UtilityClasses;
import Utilities.UtilityLogs;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedListener implements IInvokedMethodListener {


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        UtilityLogs.info(String.valueOf(method.getDate()));
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        UtilityLogs.info(testResult.getName()+" executed..");
        if(testResult.getStatus() == ITestResult.FAILURE)
        {
            UtilityLogs.error(testResult.getName()+"fail.......");
            UtilityClasses.takeScreenShot(getDriver() ,testResult.getName());

    }
}





}
