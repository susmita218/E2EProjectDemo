package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop=new Properties();
	public WebDriver initializeDriver() throws Throwable
	{
		//chrome
		
		//Mozilla
		
		//internet explorer
				
		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\workspace2\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			//execute in chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
			//execute in firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Susmita\\geckodriver_win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		else if(browserName.equals("IE"))
		{
			//execute in chrome
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Susmita\\IEDriverServer_x64\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
				
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
	TakesScreenshot ts=(TakesScreenshot)driver;	
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destFile=System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destFile));
	return destFile;
	}
	}
	
