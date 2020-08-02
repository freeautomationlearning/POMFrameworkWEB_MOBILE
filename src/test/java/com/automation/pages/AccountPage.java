/**
 * 
 */
package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.BaseClass;
import com.automation.objects.AccountPageObject;
import com.automation.utility.GernalKeywors;
import com.automation.utility.GlobalParameters;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author CHIRAG
 *
 */
public class AccountPage {
	
	AccountPageObject accountPageObject = new AccountPageObject();
	WebDriver driver;
	public AccountPage(WebDriver driver) {
	
		this.driver = driver;
		if(GlobalParameters.runType.equalsIgnoreCase("web"))
		{
			PageFactory.initElements(driver, accountPageObject);
		}else
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), accountPageObject);
		}
	}
	
	public Object clickSignOutButton()
	{
		GernalKeywors.click(accountPageObject.signoutButton);
		if(GlobalParameters.runType.equalsIgnoreCase("mobile"))
		{
			GernalKeywors.click(accountPageObject.disconnect);
			return new LoginPage(driver);
		}else
		{
			return new HomePage(driver);
		}
		
	}

}
