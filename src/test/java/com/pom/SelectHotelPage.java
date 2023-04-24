package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClassAdactinHotel;

public class SelectHotelPage extends BaseClassAdactinHotel {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtSelectHotel;

	@CacheLookup
	@FindBy(id = "radiobutton_0")
	private WebElement radioSelect;
	@CacheLookup
	@FindBy(id = "continue")
	private WebElement btnContinue;
	@FindBy(id="radiobutton_span")
	private WebElement selectErrorMsg;

	public WebElement getSelectErrorMsg() {
		return selectErrorMsg;
	}

	public WebElement getTxtSelectHotel() {
		return txtSelectHotel;
	}

	public WebElement getRadioSelect() {
		return radioSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selectHotel() {
		click(getRadioSelect());
		clickContinue();

	}

	public void clickContinue() {
		click(getBtnContinue());

	}

}

