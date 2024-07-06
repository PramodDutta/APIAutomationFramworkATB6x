package com.thetestingacademy.tests.extendDemo;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}

