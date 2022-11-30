package package3;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.View;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class Video_10_RemoveOrChangeOrderOfTabsInTheExtentReports {
	
	@Test(enabled=true, description="Capture HTML Tag value")
	public void f() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		//String path=System.getProperty("user.dir")+".\\Reports\\TestReport10.html";
		//File file=new File(path);
		ExtentSparkReporter extentSparkReporter_all=new ExtentSparkReporter("AllTests.html");
		
		ExtentSparkReporter extentSparkReporter_failed=new ExtentSparkReporter("FailedTests.html");
		extentSparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL});
		
		ExtentSparkReporter extentSparkReporter_SkipAndWarning=new ExtentSparkReporter("SkipAndWarningTests.html");
		extentSparkReporter_SkipAndWarning.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				});
		
		extentReports.attachReporter(extentSparkReporter_all,extentSparkReporter_failed,extentSparkReporter_SkipAndWarning);
		
		 extentReports
			.createTest("Test1", "Test Description Sample 1")
			.assignAuthor("Yadagiri")
			.assignCategory("Smoke")
			.assignDevice("Chrome 99")
			.pass("This is passed Test");
		 
		 extentReports
			.createTest("Test2", "Test Description Sample 2")
			.assignAuthor("John")
			.assignCategory("Sanity")
			.assignDevice("Edge 99")
			.fail("This is failed Test");
		 
		 extentReports
			.createTest("Test3", "Test Description Sample 2")
			.assignAuthor("John")
			.assignCategory("Sanity")
			.assignDevice("Edge 99")
			.skip("This is Skiped Test");
		 
		//Exception Example 2
		Throwable t=new RuntimeException("This is a custom Exception");
		extentReports
		.createTest("Exception Test 4")
		.fail(t);
		
		extentReports
		.createTest("Test5", "Test Description Sample 5")
		.assignAuthor("John")
		.assignCategory("Sanity")
		.assignDevice("Edge 99")
		.warning("This is warning Test");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("SkipAndWarningTests.html").toURI());//This will automatically open the report in default browser
		
	} 
	
}
