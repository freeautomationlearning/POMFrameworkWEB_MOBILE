/**
 * 
 */
package com.automation.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.automation.baseclass.BaseClass;
import com.automation.pages.AccountPage;
import com.automation.pages.DashboardPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utility.GlobalParameters;

/**
 * @author CHIRAG
 *
 */
public class LoginTest {

	HomePage homePage ;
	LoginPage loginPage;
	DashboardPage dashboardPage;	
	AccountPage accountPage;
	BaseClass baseClass;
	
	@BeforeClass
	public void initalizeObject()
	{
		baseClass = new BaseClass();
		baseClass.setup();
	}
	
	@Test
	public void login()
	{
		// Check scripts run on web or mobile from BaseClass
		
		if(GlobalParameters.runType.equalsIgnoreCase("web")) // It condition helps to create a single test script to run both environment
		{
			homePage = new HomePage(baseClass.getDriver());
			loginPage = homePage.clickOnSignIn();
		}else
		{
			loginPage = new LoginPage(baseClass.getDriver());
		}
		
		// Enter user name
		loginPage.enterUserName("vodqa@gmail.com");
		
		if(GlobalParameters.runType.equalsIgnoreCase("web"))
		{
			// Click on Continue
			loginPage.clickContinueButton();
		}
		
		// Enter password
		loginPage.enterPassword("Hello12345678");
		
		// Click on Login button
		dashboardPage = loginPage.clickLoginButton();
		// Verify Dash board is displayed or not
		Assert.assertTrue(dashboardPage.isDashbordDisplay(), "Dashboard page is not displayed");
	}
	
	@Test(dependsOnMethods={"login"})
	public void logout()
	{
		accountPage = dashboardPage.clickOnMyAccount();
		if(GlobalParameters.runType.equalsIgnoreCase("web"))
		{
			homePage = (HomePage) accountPage.clickSignOutButton();
			Assert.assertTrue(homePage.isSignInLinkDisplay(), "Sign In Link is not displayed");
		}else
		{
			loginPage = (LoginPage) accountPage.clickSignOutButton();
			Assert.assertTrue(loginPage.isUserNameDisplay(), "UserName is not displayed");
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{
		baseClass.tearDown(baseClass.getDriver());
	}
}
