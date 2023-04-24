package com.Greeens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClassAdactinHotel;

public class FaceBookLogin extends BaseClassAdactinHotel {
	public FaceBookLogin() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement txtUserName;
	
	@FindBy (id="pass")
	private WebElement txtPassWord;
	
	@FindBy (name="login")
	private WebElement btnLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}



}
