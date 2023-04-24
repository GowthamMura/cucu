package com.stepdenfinction;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotelStepDefiniations {
WebDriver driver;

@Given("user is on the login page")
public void user_is_on_the_login_page() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://adactinhotelapp.com/");
	
    }

@When("user enter the valid {string} and {string}")
public void user_enter_the_valid_and(String uname, String password) {
	driver.findElement(By.id("username")).sendKeys(uname);
	driver.findElement(By.id("password")).sendKeys(password);
    }

@When("click the login buttton")
public void click_the_login_buttton() {
	driver.findElement(By.id("login")).click();
    }

@Then("The should be valid Success message")
public void the_should_be_valid_Success_message() {
	boolean status = driver.findElement(By.xpath("//td[text()='Welcome to Adactin Group of Hotels']")).isDisplayed();
	Assert.assertTrue(status);
	
    }


}
