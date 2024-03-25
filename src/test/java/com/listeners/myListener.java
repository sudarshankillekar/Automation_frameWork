package com.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.*;

public class myListener implements ITestListener {
    private ExtentTest extentTest; 
    private ExtentReports extentReports ;
    private ExtentSparkReporter  extentSparkReporter;
	
	
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("************Test started **************:"+ result.getMethod().getMethodName());
        File reportfile = new File(	System.getProperty("user.dir")+"//report//report.html");
        extentSparkReporter = new ExtentSparkReporter(reportfile);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test started :"+ result.getName());
        extentTest.pass("Test executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test started :"+ result.getName());
        extentTest.fail("Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test started :"+ result.getName());
        extentTest.skip("Test failed");
    }

    public void onFinish (ITestResult result) {
        System.out.println("Test started :"+ result.getName());
        extentTest.skip("Test failed");
    }

}
