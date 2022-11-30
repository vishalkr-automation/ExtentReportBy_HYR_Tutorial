package pacakge1;

import java.awt.Desktop;
import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Video_04_UnderstnadTheLogLevelsInExtentReport {
	
	@Test
	public void f() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestReport4.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		
//		ExtentTest extentTest1=extentReports.createTest("Test 1");
//		extentTest1.pass("This is Passed");
//		
//		ExtentTest extentTest2=extentReports.createTest("Test 2");
//		extentTest2.log(Status.FAIL, "This is failed");
		
		extentReports.createTest("Test 1")
		.log(Status.INFO,"Info")
		.log(Status.PASS,"Pass")
		.log(Status.WARNING, "Warning")
		.log(Status.FAIL, "Fail")
		.log(Status.SKIP, "Skipped");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}

}
