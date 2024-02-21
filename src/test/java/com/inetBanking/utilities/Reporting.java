package com.inetBanking.utilities;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestResult;


public class Reporting implements ITestListener
{
	
	public static ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	

     public Reporting()
   {
	   extent=new ExtentReports();
   }

	
	public void OnStart(ITestContext context)
	{
		System.out.println("hi");
	 sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");
	 sparkReporter.config().setDocumentTitle("Automation Report");
	 sparkReporter.config().setReportName("Functional Testing");
	 sparkReporter.config().setTheme(Theme.STANDARD);
	
     extent=new ExtentReports();
	 extent.attachReporter(sparkReporter);
	 extent.setSystemInfo("Computer Name", "localhost");
	 extent.setSystemInfo("Environment", "QA");
	 extent.setSystemInfo("Tester Name", "pavan");
	 extent.setSystemInfo("os", "Windows10");
	 extent.setSystemInfo("Browser name", "Chrome,Firefox,Edge");
	 
	}
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is:" +result.getName());
		
	}

     public void onTestFailure(ITestResult result)
   {
    	 test=extent.createTest(result.getName());   
    	 test.log(Status.FAIL, "Test case FAILED is:" +result.getName());
    	 test.log(Status.FAIL, "Test case FAILED is:" +result.getThrowable());
   }
     
     public void onTestSkipped(ITestResult result)
     {
    	 test=extent.createTest(result.getName());
    	 test.log(Status.SKIP, "Test case SKIPPED is:" +result.getName());
    	  	 
     }
   
     public void onFinish(ITestContext context)
     
     
     {
    
   
    	 extent.flush();
    	 }
	 
}
