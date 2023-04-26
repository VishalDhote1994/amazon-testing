package com.amazonShopping.testClasses;

import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.amazonShopping.utilities.ReadConfig;
import com.amazonShopping.utilities.Screenshot;


public class TestBaseClass 
{
	public static WebDriver driver;
	 Logger log= Logger.getLogger("amazonShopping");
		
	ReadConfig rc= new ReadConfig();
	
	public String Url =rc.getUrl();
	public String username = rc.getUsername();
	public String Password = rc.getPassword();
	public String ChromePath = rc.getChromePath();
	public String edgePath = rc.getEdgePath();
	public String firefoxPath = rc.getFirefoxPath();
	
	
	 @Parameters("browserName")
	 @BeforeClass
	public void setUp(String browserName) throws IOException 
	{
		 PropertyConfigurator.configure("./configuration\\log4j.properties");			
			
		if(browserName.equals("chrome"))
		
		{
			System.setProperty("webdriver.chrome.driver", ChromePath);
			driver=new ChromeDriver();
			log.info("Chrome browser opened successfully");
		}
		else if(browserName.equals("edge"))
		{
			
			System.setProperty("webdriver.edge.driver", edgePath);
			driver=new EdgeDriver();
			log.info("Edge browser opened successfully");
		}
		else if(browserName.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			driver=new EdgeDriver();
			log.info("Edge browser opened successfully");
		}
			
			
			driver.manage().window().maximize();
		log.info("Window maximized");
	
		driver.get(Url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Screenshot.captureScreenshot(driver, browserName+"_opened_successsful");

	}
	 
	 
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		log.info("Browser quit successfully");
	
	}

}
