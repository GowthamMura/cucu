package com.steps;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;
import com.test.BaseClassAdactinHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommenStep extends BaseClassAdactinHotel{
	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @see used to launch webpage
	 * @throws IOException
	 */
	@Given("User is on the Adactin Page")
	public void userIsOnTheAdactinPage() throws IOException {
		browserLaunch(getPropertyFileValue("browser"));
		getUrl(getPropertyFileValue("url"));
		maximize();
		implicityWait(20);
	}

	/**
	 * @see used to perform login
	 * @param userName
	 * @param password
	 */
	@When("User Should Perform Login {string} and {string}")
	public void userShouldPerformLogin(String userName, String password) {
		pom.getLoginPage().login(userName, password);

	}

	/**
	 * @see used to verify success msg after login
	 * @param actLoginSuucessMsg
	 */
	@Then("User Should Verify After Login Success Message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String actLoginSuucessMsg) {
		WebElement successMsg2 = pom.getSearchHotelPage().getTxtSelectHotelSuccessMsg();
		String expLoginSuucessMsg = getAttribute(successMsg2);
		Assert.assertEquals("Verify after login success message", actLoginSuucessMsg, expLoginSuucessMsg);
	}

	
	
	

}
