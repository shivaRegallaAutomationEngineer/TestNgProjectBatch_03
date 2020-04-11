package com.infosys.netBanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.infosys.netBanking.baseClass.BaseClass;


public class LoginPage extends BaseClass{
  
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	public WebElement txtUserName;
	@FindBy(xpath="//input[@name='password']")
	public WebElement txtPassword;
	@FindBy(xpath="//input[@name='btnLogin']")
	public WebElement loginButton;
	
}
