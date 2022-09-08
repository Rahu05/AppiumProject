package org.rahul.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		//ExtentReports ExtentSparkRepoter

		String path=System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		 reporter.config().setReportName("Android test results");
		reporter.config().setDocumentTitle("Test Result");

		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Rahul");
		return extent;
	}

}
