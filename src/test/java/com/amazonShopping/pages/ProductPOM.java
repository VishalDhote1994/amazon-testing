package com.amazonShopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPOM 
{
	private WebDriver driver;
	Actions act;

	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	
	@FindBy(xpath="//form[@id='attach-view-cart-button-form']/descendant::input")
	 public WebElement cartAlert;
	
	@FindBy(xpath="//*[@id='nav-cart-count']")
	private WebElement cart;
	

	
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	
	
	public String getCartItemNumber()
	{
		String totalCartItems=cart.getText();
		return totalCartItems;
	}
	
	public void clickOnCartButton()
	{
		
		act.moveToElement(cartAlert).click().build().perform();
	}
	
	public ProductPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
	}
	
	

}
