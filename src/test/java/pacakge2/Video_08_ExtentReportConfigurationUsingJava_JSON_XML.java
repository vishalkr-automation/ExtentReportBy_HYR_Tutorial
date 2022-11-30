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
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Video_08_ExtentReportConfigurationUsingJava_JSON_XML {
	
	@Test(enabled=false,priority=2)
	public void ChangeExtentReportUIUsingJAVA() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestRepor8.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		
		
		//Using this line of code we can change the UI of Extent Report
		
		//Method 1
//		extentSparkReporter.config().setTheme(Theme.DARK);
//		extentSparkReporter.config().setReportName("Report Name: Yadagiri Report");
//		extentSparkReporter.config().setDocumentTitle("Document Title: Yadagiri");
//		extentSparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
//		extentSparkReporter.config().setCss(".badge-primary{background-color:#df6565}");
//		extentSparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
		//Method 2
		ExtentSparkReporterConfig extentSparkReporterConfig=extentSparkReporter.config();
		extentSparkReporterConfig.setTheme(Theme.DARK);
		extentSparkReporterConfig.setReportName("Report Name: Yadagiri Report");
		extentSparkReporterConfig.setDocumentTitle("Document Title: Yadagiri");
		extentSparkReporterConfig.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		extentSparkReporterConfig.setCss(".badge-primary{background-color:#df6565}");
		extentSparkReporterConfig.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
		
		//This will create the logs for every test case
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
		 
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}
	
	@Test(enabled=false,priority=2)
	public void ChangeExtentReportUIUsingJSON() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestRepor8_Part2.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		
		extentSparkReporter.loadJSONConfig(new File("./src/test/resource/extent-reports-config.json"));
		
		extentReports.attachReporter(extentSparkReporter);
		
		
		//This will create the logs for every test case
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
		 
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}
	
	@Test(enabled=true,priority=2)
	public void ChangeExtentReportUIUsingXML() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestRepor8_Part3.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		
		extentSparkReporter.loadXMLConfig(new File("./src/test/resource/extent-report-config.xml"));
		
		extentReports.attachReporter(extentSparkReporter);
		
		
		//This will create the logs for every test case
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
		 
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}
	
}
