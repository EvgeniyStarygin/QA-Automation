package com.itacademy.automation;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener{
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        System.out.println("METHOD STARTED - " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        System.out.println(String.format("METHOD FINISHED - %s >>> %s",
                method.getTestMethod().getMethodName(),
                result.getStatus() == 1 ? "Success" : "Fail"));
    }
}
