package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(@style,'position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;')]")
	WebElement rejectnot;
	
	@FindBy(xpath="//a[contains(@href,'sign_in')]")
	WebElement signin;
	
	@FindBy(css=".container>div>h2")
	WebElement title;
	
	@FindBy(css=".nav.navbar-nav.navbar-right")
	WebElement navbar;
	
		
	
	public WebElement getLogin()
	{
		return signin;
	}
	
	public WebElement getTitle()
	{
		return title;
	}
	
	public WebElement getNavigationBar()
	{
		return navbar;
	}

	public WebElement closeNotification()
	{
		return rejectnot;
	}
	
	
	
}
