package pacakge1;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Video_05_LogDifferentTypesOfInformationInTheExtentReports {
	
	@Test(enabled=true, description="Capture HTML Tag value")
	public void f() throws Exception {
		ExtentReports extentReports=new ExtentReports();
		String path=System.getProperty("user.dir")+".\\Reports\\TestReport5.html";
		File file=new File(path);
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(extentSparkReporter);

		//HTML Data Added
		extentReports.createTest("Test 1")
		.log(Status.INFO,"Info")
		.log(Status.INFO,"<b>Info</b>")
		.log(Status.INFO,"<i>Info</i>")
		.log(Status.INFO,"<b><i>Info</i></b>");	
		
		String xmlData="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		
		String jsonData="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		
		//XML Data Added
		extentReports
		.createTest("XML Based Test")
	    .log(Status.INFO, MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
		
		//JSON Data Added
		extentReports
		.createTest("JSON Based Test")
	    .log(Status.INFO, MarkupHelper.createCodeBlock(jsonData,CodeLanguage.JSON));
		
		//List,Set, Map
		List<String> listData=new ArrayList<>();
		
		listData.add("ABC");
		listData.add("Xyz");
		listData.add("FEG");
		listData.add("KLM");
		
		Map<String, String> mapData=new HashMap<>();
		
		mapData.put("One", "1");
		mapData.put("Two", "2");
		mapData.put("Three", "3");
		mapData.put("Three", "4");
		
		Set<String> setData=mapData.keySet();
		
		extentReports
		.createTest("List Based Test")
	    .log(Status.INFO, MarkupHelper.createOrderedList(listData))
	    .log(Status.INFO, MarkupHelper.createUnorderedList(listData));
		
		extentReports
		.createTest("Set Based Test")
	    .log(Status.INFO, MarkupHelper.createOrderedList(setData))
	    .log(Status.INFO, MarkupHelper.createUnorderedList(setData));
		
		extentReports
		.createTest("Map Based Test")
	    .log(Status.INFO, MarkupHelper.createOrderedList(mapData))
	    .log(Status.INFO, MarkupHelper.createUnorderedList(mapData));
		
		//Highlight Log Test
		extentReports
		.createTest("Highlight Log Test")
		.info("This is a highlighted message")
	    .info(MarkupHelper.createLabel("This is a highlighted message",ExtentColor.PURPLE));
		
		//Exception Data Added
		
		try {
			int i=5/0;
			
		} catch (Exception e) {
			extentReports
			.createTest("Exception Test1")
			.info(e);
		}

		//Exception Example 2
		Throwable t=new RuntimeException("This is a custom Exception");
		extentReports
		.createTest("Exception Test2")
		.fail(t);
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File(path).toURI());    //This will automatically open the report in default browser
		
	}
	
}
