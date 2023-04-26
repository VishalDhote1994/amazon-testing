package com.amazonShopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilesPOM 
{

	private WebDriver driver;
	@FindBy(xpath="(//li[@class='a-tab-heading htw-tab-heading'])[1]")
	WebElement accessories;
	
	public void clickOnAccessories()
	{
		accessories.click();
	}
	
	public MobilesPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
