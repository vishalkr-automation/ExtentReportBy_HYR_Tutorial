package pacakge2;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Video_07_DifferentAttributesAvailableForTestInExtentReport {
	
	@Test(enabled=true,priority=2)
	public void f2() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestRepor7.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		
		//Capture Screenshots in Log Level
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
			.createTest("Test3", "Test Description Sample 3")
			.assignCategory("Regression")
			.assignDevice("Firefox 60")
			.fail("This is failed Test");
		 
		 extentReports
			.createTest("Test4", "Test Description Sample 4")
			.assignAuthor("John")
			.assignAuthor("Yadagiri")
			.assignCategory("Smoke")
			.assignCategory("Regression")
			.assignDevice("Firefox 97")
			.assignDevice("Firefox 99")
			.fail("This is Passed Test");
		 
		 extentReports
			.createTest("Test5", "Test Description Sample 5")
			.assignAuthor("John","Yadagiri","Jeevan")
			.assignCategory("Smoke","Sanity","Regression")
			.assignDevice("Firefox 97","Firefox 99","Chrome96")
			.pass("This is Passed Test");
			
		 extentReports
			.createTest("Test5", "Test Description Sample 5")
			.assignAuthor(new String[]{"John","Yadagiri","Jeevan"})
			.assignCategory(new String[]{"Smoke","Sanity","Regression"})
			.assignDevice(new String[]{"Firefox 97","Firefox 99","Chrome96"})
			.pass("This is Passed Test");
			
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}
}
