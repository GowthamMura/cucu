package com.method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotelNotifications {
	WebDriver driver;
	private WebElement fi;

@Given("Start up the adactin webpage")
public void start_up_the_adactin_webpage() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
	
	
	
   }

@When("User should enter the {string},{string}")
public void user_should_enter_the(String uname, String password) throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("username")).sendKeys(uname);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("login")).click();
	
	
	
    }

@When("After logged in fill the datas to select hotel {string},{string},{string},{string},{string},{string},{string},{string}")
public void after_logged_in_fill_the_datas_to_select_hotel(String location, String Hotels, String RoomType, 
		String NoofRooms, String checkindate, String checkoutdate, String adults, String children) { 
	driver.findElement(By.id("location")).sendKeys(location);
	driver.findElement(By.id("hotels")).sendKeys(Hotels);
	driver.findElement(By.id("room_type")).sendKeys(RoomType);
	driver.findElement(By.id("room_nos")).sendKeys(NoofRooms);
	driver.findElement(By.id("datepick_in")).sendKeys(checkindate);
	driver.findElement(By.id("datepick_out")).sendKeys(checkoutdate );
	driver.findElement(By.id("adult_room")).sendKeys(adults);
	driver.findElement(By.id("child_room")).sendKeys(children);
	driver.findElement(By.id("Submit")).click();
	
    }

@When("After fill the datas select the hotel")
public void after_fill_the_datas_select_the_hotel() {
	driver.findElement(By.id("radiobutton_0")).click();
	driver.findElement(By.name("continue")).click();
    }

@When("Fill up the personal details {string},{string},{string},{string},{string},{string},{string},{string}")
public void fill_up_the_personal_details(String firstname, String lastname, 
		String billingaddress, String creditno, String creditcardtype, 
		String expirymonth, String expiryyear, String cvvnumber) {
	driver.findElement(By.name("first_name")).sendKeys(firstname);
	driver.findElement(By.id("last_name")).sendKeys(lastname);
	driver.findElement(By.name("address")).sendKeys(billingaddress);
	driver.findElement(By.name("cc_num")).sendKeys(creditno);
	driver.findElement(By.name("cc_type")).sendKeys(creditcardtype);
	driver.findElement(By.name("cc_exp_month")).sendKeys(expirymonth);
	driver.findElement(By.name("cc_exp_year")).sendKeys(expiryyear);
	driver.findElement(By.id("cc_cvv")).sendKeys(cvvnumber);
	driver.findElement(By.id("book_now")).click();
	
		
    }

@Then("Once we done booking we get order id which will display on console")
public void once_we_done_booking_we_get_order_id_which_will_display_on_console() throws InterruptedException  {
	
	Thread.sleep(5000);
	  String attribute = driver.findElement(By.name("order_no")).getAttribute("value");
	   System.out.println(attribute);
    }


}
