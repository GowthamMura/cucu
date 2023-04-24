package com.stepdenfinction;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
 WebDriver driver;

 

@Given("user is adactin hotel login page")
public void user_is_adactin_hotel_login_page() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://adactinhotelapp.com/");
	
   }

@When("user should enter username & password")
public void user_should_enter_username_password() {
	WebElement txtusername = driver.findElement(By.id("username"));
	txtusername.sendKeys("Akilan1008");
	
	//driver.findElement(By.id("username")).sendKeys("Akilan1008");

	WebElement txtpass = driver.findElement(By.id("password"));
	txtpass.sendKeys("Iphone@11promax");
    }

@When("user should click login button")
public void user_should_click_login_button() {
	WebElement btnlogin = driver.findElement(By.id("login"));
	btnlogin.click();
	
	//Anther method of using webelement
	//driver.findElement(By.id("login")).click();
	
   }

@Then("user should be validate success message")
public void user_should_be_validate_success_message() {
	
	String verifymessage = driver.findElement(By.xpath("//td[contains(text(),'Welcome')]")).getText();
	if (verifymessage.contains("Welcome")) {
		System.out.println("login successful message");
		
	}else {
		System.out.println("login unsuccessful message ");
	}
	//boolean status = driver.findElement(By.linkText("Welcome to Adactin Group of Hotels")).isDisplayed();
	//Assert.assertTrue(status);
		
	
   }


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
