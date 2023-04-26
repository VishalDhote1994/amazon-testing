package com.amazonShopping.testClasses;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazonShopping.pages.AccessoriesPOM;
import com.amazonShopping.pages.HomePOM;
import com.amazonShopping.pages.LoginPOM;
import com.amazonShopping.pages.MobilesPOM;
import com.amazonShopping.pages.ProductPOM;

public class TC_AmazonTests_001 extends TestBaseClass
{
	@Test
	public void loginTest()
	{
		HomePOM hp=new HomePOM(driver);
		hp.clickOnSignInLink();
		log.info("Login Window is opened");
		
		LoginPOM lp=new LoginPOM(driver);
		lp.enterUsername(username);
		
		
		lp.clickOnContinueButton();
		log.info("Username entered successfully and clicked on continue");
		lp.enterPassword(Password);
		lp.clickOnSignInButton();
		log.info("password entered successfully and clicked on continue");
		
	}
	
	@Test
	public void nevigateToAccessories()
	{
		HomePOM hp= new HomePOM(driver);
		hp.clickOnMobileTab();
		log.info("Clicked on Mobile Tab");
		
		MobilesPOM mp=new MobilesPOM(driver);
		mp.clickOnAccessories();
		log.info("clicked on Accessories");
		AccessoriesPOM ap=new AccessoriesPOM(driver);
		ap.selectProduct();
		log.info("Clicked on AddToCart");
		
		ProductPOM pp = new ProductPOM(driver);
		pp.clickOnAddToCart();
		log.info("Product is added to the cart");
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(pp.cartAlert));
		pp.clickOnCartButton();
		String itemsInCarts=pp.getCartItemNumber();
		
		log.info("Items in Cart are "+itemsInCarts);
		if(itemsInCarts.equals(0))
		{
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		log.info("Total number of items in the cart are"+itemsInCarts);
		
	}
	
	
	@Test(dependsOnMethods = {"nevigateToAccessories"})
	public void logOut()
	{
		HomePOM hp=new HomePOM(driver);
		hp.clickOnSignOut();
		String ExpectedTitle=hp.getPageTitle();
		
		if(ExpectedTitle.equals("Amazon Sign In"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		log.info("Logout Functionality successful");
		
	}
	

}
