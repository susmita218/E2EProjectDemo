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

	
	@FindBy(xpath="//a[contains(@href,'sign_in')]")
	WebElement signin;
	
	public WebElement getLogin()
	{
		return signin;
	}

}
