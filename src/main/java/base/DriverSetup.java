package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
//import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {

	protected WebDriver driver;
	//public static ChromeDriver driver;

	
		@BeforeMethod
		
		public  void setDriver() throws InterruptedException{
			
			 String baseUrl = "https://opensource-demo.orangehrmlive.com/";
			/*
			System.setProperty("webdriver.chrome.driver", "C:\\Chrome-Driver\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.setBrowserVersion("123");
			co.setBinary("C:\\Chrome_version\\chrome-win64\\chrome.exe");
		  */
		   
			
	        WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
			
			driver.get(baseUrl);
			driver.manage().window().maximize();
			Thread.sleep(1000);


	}
	

  
	@AfterMethod
	public void afterMethod1(ITestResult result1) {
	    if (result1.getStatus() == ITestResult.SUCCESS) {
	        captureScreenshot1();
	    }
	}

	@Attachment(value = "Success Screenshot", type = "image/png")
    public byte[] captureScreenshot1() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        captureScreenshot();
	    }
	}

	@Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
	
	


	@AfterMethod
	public  void tearDown() {
		//driver.close();

		driver.quit();
	}
	
	
       

	
}



