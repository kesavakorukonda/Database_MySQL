package com.resolver.AutomationTest;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.Test1;
import pages.Test2;
import pages.Test3;
import pages.Test4;

public class ResolverTestClass {
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	
	
	Test1 test1;
	Test2 test2;
	Test3 test3;
	Test4 test4;
	
	String Name;
	String City1;
	String City2;
	String Language1;
	String Language2;
	String Country;
	
	
	@BeforeTest
	public void setup() throws IOException
	{
		report = new ExtentReports("C:\\Users\\my pc\\eclipse-workspace\\AutomationTest\\src\\test\\java\\com\\resolver\\AutomationTest\\ExtReports\\ResolverTest.html");
		test = report.startTest("Testing has been started"); 
		
		System.setProperty("webdriver.chrome.driver", "E:\\\\Study\\\\Selenium\\\\ChromeDriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Study/Selenium/Automation%20Challenge/index.html#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String path = "C:\\Users\\my pc\\eclipse-workspace\\AutomationTest\\src\\test\\java\\com\\resolver\\AutomationTest\\data.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);

		Name = prop.getProperty("Name");
		City1 = prop.getProperty("City1");
		City2 = prop.getProperty("City2");
		Language1 = prop.getProperty("Language1");
		Language2 = prop.getProperty("Language2");
		Country = prop.getProperty("Country");
	}
	
	@Test(priority=1)
	public void FirstTest() throws Exception
	{
		
		test1 = new Test1(driver);
		
		test1.dataEntry(Name, City1);
		test1.dataVerify(Name, City1);
		
		test.log(LogStatus.INFO, "Test-1 has passed");
		
		//For -ve testing we can use the below method
		//test1.dataVerify(Name, City2);
	}
	
	@Test(priority=2)
	public void SecondTest() throws Exception
	{
		String[] testLang = {"Java", "C#", "Python", "Angular 2", "Angular"};

		test2 = new Test2(driver);
		
		test2.ClickingVerifying(testLang);
		test2.langVerify(Language1);
		test2.langVerify2(Language2);
		
		test.log(LogStatus.INFO, "Test-2 has passed");
	}

	@Test(priority=3)
	public void ThirdTest()
	{
		test3 = new Test3(driver);
		test3.SearchVerify(Country);
		test3.ResearchVerify();
		
		test.log(LogStatus.INFO, "Test-3 has passed");
	}
	
	@Test(priority=4)
	public void FourthTest() throws InterruptedException, AWTException
	{
		test4 = new Test4(driver);
		test4.DragAndDrop();
		
		test.log(LogStatus.INFO, "Test-4 has passed");
	}
	
	@AfterClass
	public void finish()
	{
		report.endTest(test);
		report.flush();
	}
}
