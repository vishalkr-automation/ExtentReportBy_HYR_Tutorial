package package3;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Video_09_Add_System_Environment_InformationInExtentReport {
	
	@Test(enabled=true)
	public void ChangeExtentReportUIUsingJAVA() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestRepor9.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		
		
		//Using this line of code we can change the UI of Extent Report
			
		//Method 2
		ExtentSparkReporterConfig extentSparkReporterConfig=extentSparkReporter.config();
		extentSparkReporterConfig.setTheme(Theme.STANDARD);
		extentSparkReporterConfig.setReportName("Report Name: Yadagiri Report");
		extentSparkReporterConfig.setDocumentTitle("Document Title: Yadagiri");
		extentSparkReporterConfig.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		extentSparkReporterConfig.setCss(".badge-primary{background-color:#df6565}");
		extentSparkReporterConfig.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/");
		Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
		
		//Set System/OS Properties
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("OS", capabilities.getBrowserName()+capabilities.getBrowserVersion());
		extentReports.setSystemInfo("APP URL", driver.getCurrentUrl());
		extentReports.setSystemInfo("User Name", "abc@gmail.com");
		extentReports.setSystemInfo("Password", "Test123");
		
		
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
		driver.quit();
		
		Desktop.getDesktop().browse(new File(path).toURI());  
		//This will automatically open the report in default browser
		
	}
	
}
