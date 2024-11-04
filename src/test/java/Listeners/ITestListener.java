package Listeners;

import Utilities.UtilityLogs;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ITestListener implements org.testng.ITestListener {
    public void onStart(ITestContext context) {
        UtilityLogs.info("suite  starting in execution moo...");
    }

    public void onFinish(ITestContext context) {
        UtilityLogs.info("suite Finish...");
    }


    public void onTestStart(ITestResult result) {
        UtilityLogs.info("Test Case is starting ...");
    }
    public void onTestSuccess(ITestResult result) {
        UtilityLogs.info("Test Case is success ...");
    }

    public void onTestFailure(ITestResult result) {
        UtilityLogs.info("Test Case is fail ...");
    }

    public void onTestSkipped(ITestResult result) {
        UtilityLogs.info("Test Case is skipped ...");
    }
}
