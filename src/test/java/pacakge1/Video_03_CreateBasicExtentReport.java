package pacakge1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Video_03_CreateBasicExtentReport {
	
	@Test
	public void f() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestReport3.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentTest extentTest1=extentReports.createTest("Test 1");
		extentTest1.pass("This is Passed");
		
		ExtentTest extentTest2=extentReports.createTest("Test 2");
		extentTest2.log(Status.FAIL, "This is failed");
		
		extentReports.createTest("Test 3").skip("This is skipped");

		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}

}
