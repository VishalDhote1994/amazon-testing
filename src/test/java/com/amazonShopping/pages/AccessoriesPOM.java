package com.amazonShopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesPOM 
{

	private WebDriver driver;
	
	@FindBy(xpath="(//div[@class='a-section a-spacing-mini a-spacing-top-micro acs-product-block__product-image'])[1]")
	private WebElement product;
	
	public void selectProduct()
	{
		product.click();
		
	}
	
	
	
	public AccessoriesPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
