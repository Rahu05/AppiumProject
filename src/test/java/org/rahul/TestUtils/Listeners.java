package org.rahul.TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import androidUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;

public class Listeners extends AndroidActions implements ITestListener {
	
	    ExtentReports extent=  ExtentReport.getReportObject();
	    ExtentTest tests;
	    AndroidDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
	 
		 tests=extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tests.log(Status.PASS,"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		 tests.fail(result.getThrowable());
		
		//to get driver from respective test
      try {
		driver=   (AndroidDriver) result.getTestClass().getRealClass().getField("driver")
				  .get(result.getInstance());
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
       
        //to add screenshot to extentReprts with name of screenshot as test case name
        try {
        	tests.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver));
			//tests.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
