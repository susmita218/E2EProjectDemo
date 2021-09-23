package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement emailid;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@class,'login')]")
	WebElement login;
	
	public WebElement enterMail()
	{
		return emailid;
	}
	
	public WebElement enterPassword()
	{
		return password;
	}
	
	public WebElement clickLogin()
	{
		return login;
	}

}
