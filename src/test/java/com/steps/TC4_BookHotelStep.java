package com.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;
import com.test.BaseClassAdactinHotel;

import cucumber.api.java.en.Then;

public class TC4_BookHotelStep extends BaseClassAdactinHotel{
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to book the hotel by fiiling all fields also using dataTables for
	 *      some fields
	 * @param firstName
	 * @param lastName
	 * @param billingAddress
	 * @param dataTable
	 */
	@Then("User Should Book the Hotel {string},{string} and {string}")
	public void user_should_book_the_hotel_and(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(0);
		String ccNum = map.get("cc_num");
		String ccType = map.get("cc_type");
		String expMonth = map.get("cc_exp_month");
		String expYear = map.get("cc_exp_year");
		String cvv = map.get("cc_cvv");

		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, ccNum, ccType, expMonth, expYear,
				cvv);

	}

	/**
	 * @see used to get the order id and check the success message after book the
	 *      hotel
	 * @param string
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@Then("User Should Verify After Book the Hotel Get Success Message {string} and Save the Generated OrderId")
	public void user_should_verify_after_book_the_hotel_get_success_message_and_save_the_generated_order_id(
			String string) throws IOException, InterruptedException {
		Thread.sleep(5000);
		//WebDriverWait wait= new WebDriverWait(BaseClass2.driver, Duration.ofSeconds(10));
		WebElement msg = pom.getBookingConformationPage().getBookingConfirmationSuccessMsg();
		String text = getText(msg);
		System.out.println(text);
		Assert.assertEquals("verify", string, text);
		String bookingConfirmPageId = pom.getBookingConformationPage().bookingConfirmPageId();
		System.out.println("The booking order Id is"+bookingConfirmPageId);
	}

	/**
	 * @see used to book the hotel without enter any fields
	 */

	@Then("User Should Select the Book Now button without Entering any Fields")
	public void user_should_select_the_book_now_button_without_entering_any_fields() {
		pom.getBookHotelPage().clickBookNow();

	}

	/**
	 * 
	 * @param actFirstNameErrorMsg
	 * @param actLastNameErrorMsg
	 * @param actAddressErrorMsg
	 * @param actCreditCardErrorMsg
	 * @param actCreditCardTypeErrorMsg
	 * @param actCreditCardExpErrorMsg
	 * @param actCvvErrorMsg
	 * @see used to verify the error messages by book the hotel by without entering
	 *      any fields
	 * 
	 */

	@Then("User Should Verify Error Message {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_error_message_and(String actFirstNameErrorMsg, String actLastNameErrorMsg,
			String actAddressErrorMsg, String actCreditCardErrorMsg, String actCreditCardTypeErrorMsg,
			String actCreditCardExpErrorMsg, String actCvvErrorMsg) {

		// String[] strings = {first,last,addrs,cCard,ccType,ccExp,ccvError};
		WebElement firstNameErrorMsg = pom.getBookHotelPage().getFirstNameErrorMsg();
		String expFirstNameError = firstNameErrorMsg.getText();
		Assert.assertEquals("verify firstName Error Msg", actFirstNameErrorMsg, expFirstNameError);

		WebElement laststNameErrorMsg = pom.getBookHotelPage().getLastNameerrorMsg();
		String expLastNameErrorMsg = laststNameErrorMsg.getText();
		Assert.assertEquals("verify lastName Error Msg", actLastNameErrorMsg, expLastNameErrorMsg);

		WebElement addressErrorMsg = pom.getBookHotelPage().getAddressErrorMsg();
		String expAddressErrorMsg = addressErrorMsg.getText();
		Assert.assertEquals("verify address Error msg", actAddressErrorMsg, expAddressErrorMsg);

		WebElement creditCardErrorMsg = pom.getBookHotelPage().getTxtCreditCardErrorMsg();
		String expCreditCardErrorMsg = creditCardErrorMsg.getText();
		Assert.assertEquals("verify CreditCard Error Msg", actCreditCardErrorMsg, expCreditCardErrorMsg);

		WebElement cardTypeErrorMsg = pom.getBookHotelPage().getCcTypeErrorMsg();
		String expCreditCardTypeErrorMsg = cardTypeErrorMsg.getText();
		Assert.assertEquals("verify credit card type error msg", actCreditCardTypeErrorMsg, expCreditCardTypeErrorMsg);

		WebElement cardExpErrorMsg = pom.getBookHotelPage().getCcExpiryErrorMsg();
		String expCreditCardExpErrorMsg = cardExpErrorMsg.getText();
		Assert.assertEquals("verify credit card exp error msg", actCreditCardExpErrorMsg, expCreditCardExpErrorMsg);

		WebElement cvvErrorMsg = pom.getBookHotelPage().getCcCvvNumErrorMsg();
		String expCvvErrorMsg = cvvErrorMsg.getText();
		Assert.assertEquals("cvv verify", actCvvErrorMsg, expCvvErrorMsg);

	}


}
