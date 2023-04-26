package com.amazonShopping.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot 
{
	
	public static void captureScreenshot(WebDriver driver, String name) throws IOException
	{
		Date d= new Date();
		DateFormat df= new SimpleDateFormat("MM-dd-yy & HH-mm-ss");
		String date= df.format(d);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File seleFile= ts.getScreenshotAs(OutputType.FILE);
		File jpgFile= new File("./screenshots\\"+ name + date +".jpg");
		FileHandler.copy(seleFile, jpgFile);
		
	}

}
