package com.infosys.netBanking.browseFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.infosys.netBanking.baseClass.BaseClass;
import com.infosys.netBanking.utilities.configReader;
public class BrowseFactory extends BaseClass{
	public BrowseFactory() {
		super(driver);
	}
	
	 static configReader property=PageFactory.initElements(driver, configReader.class);

	public  static WebDriver initaiteBrowser() {
		
		
		driver=BaseClass.getDriver();
		
		if(property.getTestData("browser1").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		
		}
		else if(property.getTestData("browser1").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".//drivers//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(property.getTestData("browser1").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else {
			System.out.println("Invalid browser selected");
		}
		driver.get(property.getTestData("URL"));
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(property.getTestData("UserName"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(property.getTestData("Password"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		return driver;
		
	}
	

}
