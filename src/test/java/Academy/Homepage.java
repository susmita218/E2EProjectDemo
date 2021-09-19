package Academy;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class Homepage extends Base {
	
	@Test
	public void basePageNavigation() throws Throwable
	{
		driver=initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
	LandingPage lp=new LandingPage(driver);
	lp.getLogin().click();
	}

}
