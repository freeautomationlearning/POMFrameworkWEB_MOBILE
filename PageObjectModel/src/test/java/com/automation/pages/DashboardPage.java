/**
 * 
 */
package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.BaseClass;
import com.automation.objects.DashboardPageObject;
import com.automation.utility.GernalKeywors;
import com.automation.utility.GlobalParameters;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author CHIRAG
 *
 */
public class DashboardPage {

	DashboardPageObject dashboardPageObject = new DashboardPageObject();
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		if(GlobalParameters.runType.equalsIgnoreCase("web"))
		{
			PageFactory.initElements(driver, dashboardPageObject);
		}else
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageObject);
		}
	}
	
	public boolean isDashbordDisplay()
	{
		if(GlobalParameters.runType.equalsIgnoreCase("mobile"))
		{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return GernalKeywors.isDisplayed(dashboardPageObject.dashboard);
	}
	
	public AccountPage clickOnMyAccount()
	{
		GernalKeywors.click(dashboardPageObject.dashboard);
		return new AccountPage(driver);
	}
}
