package com.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class myListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started :"+ result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test started :"+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test started :"+ result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test started :"+ result.getName());
    }

	

}
