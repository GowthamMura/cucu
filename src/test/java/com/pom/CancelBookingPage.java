package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClassAdactinHotel;

public class CancelBookingPage extends BaseClassAdactinHotel {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "order_id_text")
	private WebElement txtSearch;
	@CacheLookup
	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;
	@CacheLookup
	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement btnCancel;
	@FindBy(id="search_result_error")
	private WebElement cancelSuccessMsg;

	public WebElement getCancelSuccessMsg() {
		return cancelSuccessMsg;
	}


	public WebElement getBtnCancel() {
		return btnCancel;
	}


	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public void cancelBookingId(String orderNo) {
		
		sendKeys(getTxtSearch(), orderNo);
		click(getBtnGo());
		click(getBtnCancel());
		clickOkAlert();
	}

}
	
