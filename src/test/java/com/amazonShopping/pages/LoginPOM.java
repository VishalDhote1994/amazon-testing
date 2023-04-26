package com.amazonShopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM 
{
	private WebDriver driver;
	
	@FindBy(id="ap_email")
	private WebElement username;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	@FindBy(id="ap_password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signInButton;
	
	public void enterUsername(String name)
	{
		username.sendKeys(name);
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public void enterPassword(String name)
	{
		password.sendKeys(name);
	}
	
	public void clickOnSignInButton()
	{
		signInButton.click();
	}
	
	public String getPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public LoginPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
