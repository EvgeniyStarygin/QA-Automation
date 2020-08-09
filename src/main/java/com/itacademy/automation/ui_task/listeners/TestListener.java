package com.itacademy.automation.ui_task.listeners;

import com.itacademy.automation.ui_task.entities.Browser;
import com.itacademy.automation.ui_task.loggers.CustomLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        CustomLogger.logTestStarted(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        CustomLogger.logTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        CustomLogger.logTestFailed(iTestResult.getThrowable());
        Browser.getInstance().takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        CustomLogger.logTestSkipped(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
