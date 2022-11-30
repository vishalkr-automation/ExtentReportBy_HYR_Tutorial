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

public class Video_06_AddScreenshotsInExtentReport {
	WebDriver driver;
	public static String screenshotSubFolderName;
	
	
	@Test(enabled=false,priority=1)
	public void f() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestReport6.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		String base64Code=captureScreenShot();
		String Screenshotpath=captureScreenShot("Google");
		
		
		//Capture Screenshots in Test Level
		extentReports
		.createTest("Screenshot Test1", "This is attaching screenhsot example")
		.info("This is imfo message")
		.addScreenCaptureFromBase64String(base64Code);
		
		extentReports
		.createTest("Screenshot Test2", "This is attaching screenhsot example")
		.info("This is imfo message")
		.addScreenCaptureFromBase64String(base64Code,"Google HomePage");
		
		 extentReports
		.createTest("Screenshot Test3", "This is attaching screenhsot example")
		.info("This is imfo message")
		.addScreenCaptureFromPath(Screenshotpath);
		 
		 extentReports
			.createTest("Screenshot Test4", "This is attaching screenhsot example")
			.info("This is imfo message")
			.addScreenCaptureFromPath(Screenshotpath,"Google HomePag");
		 
		 extentReports
			.createTest("Screenshot Test5", "This is attaching screenhsot in Test level")
			.info("This is imfo message")
			.addScreenCaptureFromPath(Screenshotpath,"Google HomePag")
			.addScreenCaptureFromPath(Screenshotpath,"Google HomePag")
			.addScreenCaptureFromPath(Screenshotpath,"Google HomePag")
			.addScreenCaptureFromPath(Screenshotpath,"Google HomePag"); 	 	
		
		
		extentReports.flush();
		driver.quit();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}
	
	@Test(enabled=true,priority=2)
	public void f2() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestReport1.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		String base64Code=captureScreenShot();
		String Screenshotpath=captureScreenShot("Google");
		
		
		//Capture Screenshots in Log Level
		 extentReports
			.createTest("Screenshot Test1", "This is attaching screenhsot example")
			.info("This is imfo message")
			.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google HomePag").build())
			.fail(MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath,"Google HomePag").build());
		 
		 extentReports
			.createTest("Screenshot Test2", "This is attaching screenhsot example")
			.info("This is imfo message")
			.fail("This is a info message",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google HomePag").build())
			.fail("This is a info message",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());
		 	 	
		 extentReports
			.createTest("Screenshot Test3", "This is attaching screenhsot example")
			.info("This is imfo message")
			.fail("This is a info message",MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath,"Google HomePag").build())
			.fail("This is a info message",MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
		 
		//Pass Throwable Exception
		Throwable t=new Throwable("This is throwable exception");
		
		 extentReports
			.createTest("Screenshot Test2", "This is attaching screenhsot example")
			.info("This is imfo message")
			.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Google HomePag").build())
			.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());
		 	 	
		 extentReports
			.createTest("Screenshot Test3", "This is attaching screenhsot example")
			.info("This is imfo message")
			.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath,"Google HomePag").build())
			.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
		 	 	
		extentReports.flush();
		driver.quit();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}

	public String captureScreenShot(String fileName) {
		if (screenshotSubFolderName == null) {
			LocalDateTime loaDateTime = LocalDateTime.now();
			System.out.println("Before Formatting: " + loaDateTime);
			DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			screenshotSubFolderName = loaDateTime.format(format);
		}
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+".\\Screenshot\\"+screenshotSubFolderName+"\\"+fileName+".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return path;
	}
	
	public String captureScreenShot() {
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot saved successfully");
		return base64Code;
	}
}
