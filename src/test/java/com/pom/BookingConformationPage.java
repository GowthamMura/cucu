package com.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClassAdactinHotel;

public class BookingConformationPage extends BaseClassAdactinHotel {
	public void BookingConfirmationPage() {
		PageFactory.initElements(driver, this);

	}

	@CacheLookup
	@FindBy(xpath = "//td[@class='login_title']")
	private WebElement txtBookingConfirmationSuccessMsg;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement txtLnkBookedItinerary;

	@CacheLookup
	@FindBy(id = "order_no")
	private WebElement txtOrderNo;

	public WebElement getLnkBookedItinerary() {
		return txtLnkBookedItinerary;
	}

	public WebElement getBookingConfirmationSuccessMsg() {
		return txtBookingConfirmationSuccessMsg;
	}

	public WebElement getOrderNo() {
		return txtOrderNo;
	}

	public String bookingConfirmPageId() throws IOException {
		String oredrId = getAttribute(txtOrderNo);
		return oredrId;

	}


}
