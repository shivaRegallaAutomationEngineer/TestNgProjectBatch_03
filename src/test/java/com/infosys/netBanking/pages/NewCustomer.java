package com.infosys.netBanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.infosys.netBanking.baseClass.BaseClass;

public class NewCustomer extends BaseClass {

public NewCustomer(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='name']")
	public WebElement customerName;
	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	public WebElement clickCustomer;
	
	@FindBy(how = How.NAME, using = "rad1")
	
	public WebElement rdGender;

	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	public WebElement txtdob;

	
	@FindBy(how = How.NAME, using = "addr")
	public WebElement txtaddress;

	
	@FindBy(how = How.NAME, using = "city")
 public	WebElement txtcity;

	
	@FindBy(how = How.NAME, using = "state")
   public	WebElement txtstate;

	
	@FindBy(how = How.NAME, using = "pinno")
	public WebElement txtpinno;

	
	@FindBy(how = How.NAME, using = "telephoneno")
	public WebElement txttelephoneno;

	
	@FindBy(how = How.NAME, using = "emailid")
	public WebElement txtemailid;

	
	@FindBy(how = How.NAME, using = "password")
	public WebElement txtpassword;

	
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

}
