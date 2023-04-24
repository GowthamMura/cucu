package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClassAdactinHotel;

public class BookHotelPage extends BaseClassAdactinHotel {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
		}
	@CacheLookup
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHotel;
	@CacheLookup
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	@CacheLookup
	@FindBy(id="last_name")
	private WebElement txtLastName;
	@CacheLookup
	@FindBy(id="address")
	private WebElement txtAddress;
	@CacheLookup
	@FindBy(id="cc_num")
	private WebElement txtCcNum;
	@CacheLookup
	@FindBy(id="cc_type")
	private WebElement ddnCcType;
	@CacheLookup
	@FindBy(id="cc_exp_month")
	private WebElement ddnCcExpMonth;
	@CacheLookup
	@FindBy(id="cc_exp_year")
	private WebElement ddnCcExpYear;
	@CacheLookup
	@FindBy(id="cc_cvv")
	private WebElement txtCcCvv;
	@CacheLookup
	@FindBy(id="book_now")
	private WebElement btnbookNow;
	@FindBy(id="first_name_span")
	private WebElement firstNameErrorMsg;
	@FindBy(id="last_name_span")
	private WebElement lastNameerrorMsg;
	@FindBy(id="address_span")
	private WebElement addressErrorMsg;
	@FindBy(id="cc_num_span")
	private WebElement ccNumErrorMsg;
	@FindBy(id="cc_type_span")
	private WebElement ccTypeErrorMsg;
	@FindBy(id="cc_expiry_span")
	private WebElement ccExpiryErrorMsg;
	@FindBy(id="cc_cvv_span")
	private WebElement ccCvvNumErrorMsg;
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookAHotelSuccessMsg;
	
	@FindBy (id="cc_num_span")
	private WebElement txtCreditCardNoErrorMsg;

	
	public WebElement getTxtCreditCardErrorMsg() {
		return txtCreditCardNoErrorMsg;
	}
	public WebElement getTxtBookAHotelSuccessMsg() {
		return txtBookAHotelSuccessMsg;
	}
	public WebElement getFirstNameErrorMsg() {
		return firstNameErrorMsg;
	}
	public WebElement getLastNameerrorMsg() {
		return lastNameerrorMsg;
	}
	public WebElement getAddressErrorMsg() {
		return addressErrorMsg;
	}
	public WebElement getCcNumErrorMsg() {
		return ccNumErrorMsg;
	}
	public WebElement getCcTypeErrorMsg() {
		return ccTypeErrorMsg;
	}
	public WebElement getCcExpiryErrorMsg() {
		return ccExpiryErrorMsg;
	}
	public WebElement getCcCvvNumErrorMsg() {
		return ccCvvNumErrorMsg;
	}
	public WebElement getTxtBookHotel() {
		return txtBookHotel;
	}
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getTxtCcNum() {
		return txtCcNum;
	}
	public WebElement getDdnCcType() {
		return ddnCcType;
	}
	public WebElement getDdnCcExpMonth() {
		return ddnCcExpMonth;
	}
	public WebElement getDdnCcExpYear() {
		return ddnCcExpYear;
	}
	public WebElement getTxtCcCvv() {
		return txtCcCvv;
	}
	public WebElement getBtnbookNow() {
		return btnbookNow;
	}
	
	public void bookHotel(String firstName,String lastName,String address, String ccNum,
								String ccType,String ccExpMonth,String ccExpYear, String txtCcV) {
		sendKeys(getTxtFirstName(), firstName);
		sendKeys(getTxtLastName(), lastName);
		sendKeys(getTxtAddress(), address);
		sendKeys(getTxtCcNum(), ccNum);
		selectByTextDropdown(getDdnCcType(), ccType);
		selectByTextDropdown(getDdnCcExpMonth(), ccExpMonth);
		selectByTextDropdown(getDdnCcExpYear(), ccExpYear);
		sendKeys(getTxtCcCvv(), txtCcV);
		clickBookNow();
	}
	public void clickBookNow() {
		click(getBtnbookNow());	
	}

}
