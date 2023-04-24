package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClassAdactinHotel;

public class SearchHotelPage extends BaseClassAdactinHotel {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy (id="location")
	private WebElement txtLocation;

	@FindBy (id="hotels")
	private WebElement txtHotel;

	@FindBy (id="room_type")
	private WebElement txtRoomType;

	@FindBy (id="room_nos")
	private WebElement txtRoomNos;

	@FindBy (id="datepick_in")
	private WebElement txtCheckIn;

	@FindBy (id="datepick_out")
	private WebElement txtCheckOut;

	@FindBy (id="adult_room")
	private WebElement txtAdultRoom;

	@FindBy (id="child_room")
	private WebElement txtChildRoom;

	public WebElement getTxtCheckInErrorMsg() {
		return txtCheckInErrorMsg;
	}

	public WebElement getTxtCheckOutErrorMsg() {
		return txtCheckOutErrorMsg;
	}

	public WebElement getTxtLocationErrorMsg() {
		return txtLocationErrorMsg;
	}

	public WebElement getTxtSelectHotelSuccessMsg() {
		return txtSelectHotelSuccessMsg;
	}
	@FindBy (id="Submit")
	private WebElement txtSubmit;

	@FindBy (id="checkin_span")
	private WebElement txtCheckInErrorMsg;

	@FindBy (id="checkout_span")
	private WebElement txtCheckOutErrorMsg;

	@FindBy (id="location_span")
	private WebElement txtLocationErrorMsg;

	@FindBy (id="username_show")
	private WebElement txtSelectHotelSuccessMsg;


	public WebElement getTxtLocation() {
		return txtLocation;
	}

	public WebElement getTxtHotel() {
		return txtHotel;
	}

	public WebElement getTxtRoomType() {
		return txtRoomType;
	}

	public WebElement getTxtRoomNos() {
		return txtRoomNos;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getTxtAdultRoom() {
		return txtAdultRoom;
	}

	public WebElement getTxtChildRoom() {
		return txtChildRoom;
	}

	public WebElement getTxtSubmit() {
		return txtSubmit;
	}

	public void searchCommonPage(String txtLocation,String txtRoomNos, 
			String txtCheckIn, String txtCheckOut,String txtAdultRoom ) {
		selectByTextDropdown(getTxtLocation(), txtLocation);
		selectByTextDropdown(getTxtRoomNos(), txtRoomNos);
		selectByTextDropdown(getTxtCheckIn(), txtCheckIn);
		selectByTextDropdown(getTxtCheckOut(), txtCheckOut);
		selectByTextDropdown(getTxtAdultRoom(), txtAdultRoom);

	}
	public void allFields(String txtLocation,String txtRoomNos, 
			String txtCheckIn, String txtCheckOut,String txtAdultRoom,String txtHotel, String txtRoomType, String txtChildRoom) {
		searchCommonPage(txtLocation, txtRoomNos, txtCheckIn, txtCheckOut, txtAdultRoom);
		selectByTextDropdown(getTxtHotel(), txtHotel);
		selectByTextDropdown(getTxtRoomType(), txtRoomType);
		selectByTextDropdown(getTxtChildRoom(), txtChildRoom);
		click(getTxtSubmit());

	}
	public void mandatoryFields(String txtLocation,String txtRoomNos, 
			String txtCheckIn, String txtCheckOut,String txtAdultRoom) {
		searchCommonPage(txtLocation, txtRoomNos, txtCheckIn, txtCheckOut, txtAdultRoom);
		click(getTxtSubmit());

	}
	public void dateChecking(String txtLocation,String txtRoomNos, 
			String txtCheckIn, String txtCheckOut,String txtAdultRoom,String txtHotel, String txtRoomType, String txtChildRoom) {
		searchCommonPage(txtLocation, txtRoomNos, txtCheckIn, txtCheckOut, txtAdultRoom);
		selectByTextDropdown(getTxtHotel(), txtHotel);
		selectByTextDropdown(getTxtRoomType(), txtRoomType);
		selectByTextDropdown(getTxtChildRoom(), txtChildRoom);
		click(getTxtSubmit());
	}
	public void clckSearch() {
		click(getTxtSubmit());
	}


}



