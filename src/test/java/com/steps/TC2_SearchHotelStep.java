package com.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.manager.PageObjectManager;
import com.test.BaseClassAdactinHotel;

import cucumber.api.java.en.Then;

public class TC2_SearchHotelStep extends BaseClassAdactinHotel {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see used to search hotel by filling all fields
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param CheckInDate
	 * @param CheckOutDate
	 * @param adultsRoom
	 * @param childrenRoom
	 */

	@Then("User should Search the Hotel Details {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_the_hotel_details_and(String location, String hotels, String roomType,
			String noOfRooms, String CheckInDate, String CheckOutDate, String adultsRoom, String childrenRoom) {

		pom.getSearchHotelPage().allFields(location, hotels, roomType, noOfRooms, CheckInDate, CheckOutDate, adultsRoom,
				childrenRoom);
	}

	/**
	 * @see used to verify success msg after search hotel
	 * @param string
	 */
	@Then("User should verify After Search Hotel Get the Success Message {string}")
	public void user_should_verify_after_search_hotel_get_the_success_message(String string) {
		
	}

	/**
	 * @see used to search hotel by filling mandatory fields only
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 * @param string5
	 */

	@Then("User should Entry Mandatory Details {string},{string},{string},{string} and {string}")
	public void user_should_entry_mandatory_details_and(String string, String string2, String string3, String string4,
			String string5) {
		pom.getSearchHotelPage().mandatoryFields(string, string2, string3, string4, string5);
	}

	/**
	 * @see used to verify checkIn and checkOut date error messages
	 * @param actCheckInErrorMsg
	 * @param actCheckOutErrorMsg
	 */
	@Then("User should verify After Search Hotel Get the Error Message {string} and {string}")
	public void user_should_verify_after_search_hotel_get_the_error_message_and(String actCheckInErrorMsg,
			String actCheckOutErrorMsg) {
		WebElement noCheckIn = pom.getSearchHotelPage().getTxtCheckIn();
		String expCheckInErrorMsg = getText(noCheckIn);
		Assert.assertEquals("verify checkIn Error Msg", actCheckInErrorMsg, expCheckInErrorMsg);

		WebElement noCheckOut = pom.getSearchHotelPage().getTxtCheckOut();
		String expCheckOutErrorMsg = getText(noCheckOut);
		Assert.assertEquals("verify CheckOut Error Msg", actCheckOutErrorMsg, expCheckOutErrorMsg);
	}

	/**
	 * @see used to select the search hotel
	 */

	@Then("User should select search button")
	public void user_should_select_search_button() {
		pom.getSearchHotelPage().clckSearch();

		/**
		 * @see used to verify error message after click search hotel without filling
		 *      any fields
		 */
	}

	@Then("User should verify After Search Hotel Get the Error message {string}")
	public void user_should_verify_after_search_hotel_get_the_error_message(String actSearchHotelErrorMsg) {
		WebElement noLocation = pom.getSearchHotelPage().getTxtLocation();
		String expSearchHotelErrorMsg = getText(noLocation);
		Assert.assertEquals("verify SearchHotel Error Msg ", actSearchHotelErrorMsg, expSearchHotelErrorMsg);
		System.out.println("success");
	}

	
	
	
	
}
