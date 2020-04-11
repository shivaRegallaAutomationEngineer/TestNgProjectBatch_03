package com.infosys.netBanking.testCases;


import org.codehaus.plexus.logging.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.infosys.netBanking.baseClass.BaseClass;
import com.infosys.netBanking.browseFactory.BrowseFactory;
import com.infosys.netBanking.pages.LoginPage;
import com.infosys.netBanking.pages.NewCustomer;
import com.infosys.netBanking.utilities.ExcelUtility;
import com.infosys.netBanking.utilities.commonMethods;

public class TC_001 extends BaseClass {
public TC_001() {
	super(driver);
}
	
	LoginPage loginpage;
	NewCustomer	newcustomer;
	@BeforeMethod
	public void setUp() {
		
		driver=BrowseFactory.initaiteBrowser();
		
		logger.info("Browser is getting intilazed in before Method");
		newcustomer=PageFactory.initElements(driver, NewCustomer.class);
		
	}
	
	
	@Test(enabled=false)

	public void test_001_newCustomerRegistration() {
	System.out.println("Login into the test case");
	    logger.info("TestCase_001 execution is started");
	   commonMethods.getTitle(getDriver(),"Guru99 Bank Manager HomePage");
	   commonMethods.click(newcustomer.clickCustomer, getDriver(), "clicking on the element");	   commonMethods.sendData(newcustomer.customerName, getDriver(), "shiva");
	   commonMethods.sendData(newcustomer.txtdob, getDriver(), "01/01/1991");
	   commonMethods.sendData(newcustomer.txtaddress, getDriver(), "new yourk usa");
	   commonMethods.sendData(newcustomer.txtcity, getDriver(), "Hyderabad");
	   commonMethods.sendData(newcustomer.txtstate, getDriver(), "Telangana");
	   commonMethods.sendData(newcustomer.txtpinno, getDriver(), "898987");
	   
	   commonMethods.sendData(newcustomer.txttelephoneno, getDriver(), "9876543568");
	   commonMethods.sendData(newcustomer.txtemailid, getDriver(), "shiva@gmail.com");
	   commonMethods.sendData(newcustomer.txtpassword, getDriver(), "pranitha143");
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   logger.info("Execution of test case_001 is completed");
	} 
	
	@Test(dataProvider="New Customer",dataProviderClass=ExcelUtility.class)

	public void test_002(String customerName,String dob,String address,String city,String state,String pin,String phone,String email,String password) {
	
	    logger.info("user successfully Login");
	   commonMethods.getTitle(getDriver(),"Guru99 Bank Manager HomePage");
	   commonMethods.click(newcustomer.clickCustomer, getDriver(), "clicking on the element");
	   
	   commonMethods.sendData(newcustomer.customerName, getDriver(),customerName );
	   commonMethods.sendData(newcustomer.txtdob, getDriver(),dob);
	   commonMethods.sendData(newcustomer.txtaddress, getDriver(), address);
	   commonMethods.sendData(newcustomer.txtcity, getDriver(), city);
	   commonMethods.sendData(newcustomer.txtstate, getDriver(), state);
	   commonMethods.sendData(newcustomer.txtpinno, getDriver(), pin);
	   
	   commonMethods.sendData(newcustomer.txttelephoneno, getDriver(), phone);
	   commonMethods.sendData(newcustomer.txtemailid, getDriver(),email);
	   commonMethods.sendData(newcustomer.txtpassword, getDriver(), password);
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} 
	
	@AfterMethod
	public void tearDown() {
		
		commonMethods.closeBrowser(driver);
	}
}
