package authenTication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverSetup;
import io.qameta.allure.Allure;




public class Login_Logout extends DriverSetup {
	
	
	@Test(priority=1)
	public void invalidUser_ValidPassword () throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys("gafisdfoisilf");
		driver.findElement(By.name("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click(); //last name
		Thread.sleep(4000);
		
	     WebElement element = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']//p[1]"));

	        String actualText = element.getText();
	        System.out.println("Alert text: " + actualText);
	        Assert.assertEquals("Invalid credentials", actualText);
	        Allure.addAttachment("Warning is: ", actualText);
		
		
	}

	@Test(priority=2)
	public void invalidPassword_ValidUser () throws InterruptedException{
	
		driver.findElement(By.name("username")).sendKeys("qgwrlfjd;lsjfl");
		driver.findElement(By.name("password")).sendKeys("asglfhaf;sjfaf");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click(); //last name
		Thread.sleep(4000);
		
	     WebElement element = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']//p[1]"));

	     String actualText = element.getText();
	        System.out.println("Alert text: " + actualText);
	        Assert.assertEquals("Invalid credentials", actualText);
	        Allure.addAttachment("Warning is: ", actualText);

}
	
	@Test(priority=3)
	public void invalidPassword_InvalidUser () throws InterruptedException{
	
		driver.findElement(By.name("username")).sendKeys("gfdsklfk");
		driver.findElement(By.name("password")).sendKeys("iugzvso;v'svs");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click(); //last name
		Thread.sleep(4000);
		
	     WebElement element = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']//p[1]"));

	     String actualText = element.getText();
	        System.out.println("Alert text: " + actualText);
	        Assert.assertEquals("Invalid credentials", actualText);
	        Allure.addAttachment("Warning is: ", actualText);

}
	@Test(priority=4)
	public void validPassword_ValidUser () throws InterruptedException{
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click(); //last name
		Thread.sleep(4000);
		
	   System.out.println("Login Successful");
	  
       Allure.addAttachment("Test Result: ", "Successfully Login");

	     

}
	

	
}
