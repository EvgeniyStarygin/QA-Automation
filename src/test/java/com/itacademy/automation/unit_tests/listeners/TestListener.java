package com.itacademy.automation.unit_tests.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;

public class TestListener implements IInvokedMethodListener {

    private SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy hh:mm:ss");

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        System.out.println(String.format("METHOD %s STARTED in %s",
                method.getTestMethod().getMethodName(),
                sdf.format(method.getDate())));
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        System.out.println(String.format("METHOD %s FINISHED in %s >>> %s",
                method.getTestMethod().getMethodName(),
                sdf.format(method.getDate()),
                result.getStatus() == 1 ? "Success" : "Fail"));
    }
}
