package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws Throwable
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
		
	@Test
	public void basePageNavigation() throws Throwable
	{
	
		LandingPage l=new LandingPage(driver);
		
		System.out.println(l.getTitle().getText());
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		Assert.assertTrue(l.getTitle().getText().equals("FEATURED COURSES"));
		log.info("Succesfully validated the text");
	}
	
	@DataProvider
	public Object[][] getData()
	{//rows stand for how many different data
		Object[][] data=new Object[2][3];
		data[0][0]="abcd";
		data[0][1]="password";
		data[0][2]="text";
		
		data[1][0]="restricteduser@abc.com";
		data[1][1]="password123";
		data[1][2]="specialtext";
		
		return data;
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
