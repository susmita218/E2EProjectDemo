package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateBar extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws Throwable
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test 
	public void basePageNavigation() throws Throwable
	{
	LandingPage l=new LandingPage(driver);
	Assert.assertTrue(l.getNavigationBar().isDisplayed());
	log.info("Navigation bar is validated succesfully");
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
}
