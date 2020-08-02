/**
 * 
 */
package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.BaseClass;
import com.automation.objects.HomePageObject;
import com.automation.utility.GernalKeywors;

/**
 * @author CHIRAG
 *
 */
public class HomePage {

	HomePageObject homePageObject = new HomePageObject();
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, homePageObject);
	}
	
	public int verifyNumberofLinks()
	{
		return homePageObject.homePageLinks.size();
	}
	
	public boolean isSignAndLoginDisplay()
	{
		return GernalKeywors.isDisplayed(homePageObject.loginLink);
	}
	public LoginPage clickOnSignIn()
	{
		GernalKeywors.click(homePageObject.logIn);
		return new LoginPage(driver);
	}
	
	public boolean isSignInLinkDisplay()
	{
		return GernalKeywors.isDisplayed(homePageObject.signInLink);
	}
	
}
