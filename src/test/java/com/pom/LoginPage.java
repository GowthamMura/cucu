package com.pom;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClassAdactinHotel;

public class LoginPage extends BaseClassAdactinHotel {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(id="username")
	private WebElement txtUserName;
	
	@FindBy (id="password")
	private WebElement txtPassWord;
	
	@FindBy (id="login")
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
	@FindBy (xpath="//b[contains(text(),'Invalid')]")
	private WebElement txtErrorMsg;

	public WebElement getTxtErrorMsg() {
		return txtErrorMsg;
	}

	public void loginCommonSteps(String userName, String password) {
		
		sendKeys(getTxtUserName(), userName);
		sendKeys(getTxtPassWord(), password);
		
	}
	public void login(String userName, String password) {
		loginCommonSteps(userName, password);
		click(getBtnLogin());
	}
	public void loginWithEnterKey(String userName, String password) throws AWTException {
		loginCommonSteps(userName, password);
		robotkey(KeyEvent.VK_TAB);
		robotkey(KeyEvent.VK_TAB);
		robotkey(KeyEvent.VK_ENTER);
	}
}
	
	


