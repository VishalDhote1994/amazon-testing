package com.amazonShopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePOM 
{
	private WebDriver driver;
	private Actions act;
	@FindBy(id="nav-link-accountList")
	WebElement AccountAndLists;
	
	@FindBy(xpath="//a[text()='Mobiles']")
	WebElement mobileTab;
	
	@FindBy(id="nav-item-signout")
	WebElement signOut;
	
	public void clickOnSignInLink()
	{
		AccountAndLists.click();
	}
	
	public void clickOnMobileTab()
	{
		mobileTab.click();
	}
	
	public void clickOnSignOut()
	{
		act.moveToElement(AccountAndLists).perform();
		signOut.click();
	}
	public String getPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	public HomePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
	}

}
