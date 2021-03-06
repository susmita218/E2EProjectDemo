package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws Throwable
	{
		driver=initializeDriver();
		
	}
	
	@Test (dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws Throwable
	{
	driver.get(prop.getProperty("url"));
	log.info("navigated to the homepage");
	
	
	LandingPage l=new LandingPage(driver);
	l.closeNotification().click();
	l.getLogin().click();
	LoginPage lp=new LoginPage(driver);
	lp.enterMail().sendKeys(username);
	lp.enterPassword().sendKeys(password);
	lp.clickLogin().click();
	log.info(text);
	
	}
	
	@DataProvider
	public Object[][] getData()
	{//rows stand for how many different data
		Object[][] data=new Object[1][3];
		data[0][0]="restricteduser@ubc.com";
		data[0][1]="password";
		data[0][2]="text";
		
//		data[1][0]="nonrestricteduser@ubc.com";
//		data[1][1]="password123";
//		data[1][2]="specialtext";
		
		return data;
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
