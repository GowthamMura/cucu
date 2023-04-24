
package com.steps;
import java.awt.AWTException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.manager.PageObjectManager;
import com.test.BaseClassAdactinHotel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC1_LoginStep extends BaseClassAdactinHotel {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to perform login
	 * @param string
	 * @param string2
	 * @throws AWTException
	 */

	@When("User should Perform Login {string} and {string} with Enter Key")
	public void user_should_perform_login_and_with_enter_key(String string, String string2) throws AWTException {
		pom.getLoginPage().loginWithEnterKey(string, string2);
	}

	/**
	 * @see used to verify error msg login by invalid credentials
	 * @param expErrorMsg
	 */

	@Then("User should Verify Login with Invalid Login Credential and Error Message contains {string}")
	public void user_should_verify_login_with_invalid_login_credential_and_error_message_contains(String expErrorMsg) {

		WebElement error = pom.getLoginPage().getTxtErrorMsg();
		String text = getText(error);
		boolean b = text.contains(expErrorMsg);
		Assert.assertTrue("verify login error msg", b);
	}

}
