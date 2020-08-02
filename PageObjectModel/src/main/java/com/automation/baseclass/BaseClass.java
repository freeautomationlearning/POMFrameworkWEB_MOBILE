/**
 * 
 */
package com.automation.baseclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.automation.utility.GlobalParameters;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author CHIRAG
 *
 */
public class BaseClass {

	private WebDriver driver;
	
	public void setup()
	{
		// Select platform in which you need to run web or mobile
		String platform = System.getProperty("platform", "web"); // platform should be web or mobile
		System.out.println("Your script will be run on "+platform);
		GlobalParameters.runType = platform;
		
		String path = System.getProperty("user.dir");
		WebDriver driver = null;
		if(platform.equalsIgnoreCase("web"))
		{
			System.out.println("Chrome Browser is opening..... ");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://wordpress.com");
		} else if(platform.equalsIgnoreCase("mobile"))
		{
			System.out.println("Application is opening... ");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("app", path+"//App//wordpress.apk");
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "Moto G");
			cap.setCapability("appWaitActivity", "org.wordpress.android.ui.accounts.SignInActivity");
			cap.setCapability("appPackage", "org.wordpress.android");
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("mobile will launch");
		}
		setDriver(driver);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	public void tearDown(WebDriver driver)
	{
		driver.quit();
	}
}
