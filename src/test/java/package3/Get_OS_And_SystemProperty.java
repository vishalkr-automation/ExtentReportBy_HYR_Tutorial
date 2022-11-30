package package3;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Get_OS_And_SystemProperty {
	
	@Test
	public void f() throws Exception{
		
		//Get Browser Property
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());
		driver.quit();
		
		//Get System Property
		
		//It will print all the properties of system
		//System.getProperties().list(System.out);
		
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version"));
		
	}

}
