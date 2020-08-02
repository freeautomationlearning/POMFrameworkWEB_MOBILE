/**
 * 
 */
package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.baseclass.BaseClass;
import com.automation.objects.LoginPageObject;
import com.automation.utility.GernalKeywors;
import com.automation.utility.GlobalParameters;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author CHIRAG
 *
 */
public class LoginPage {

	LoginPageObject loginPageObject = new LoginPageObject();
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if(GlobalParameters.runType.equalsIgnoreCase("web"))
		{
			PageFactory.initElements(driver, loginPageObject);
		}else
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObject);
		}
		
	}
	
	public void enterUserName(String username)
	{
		GernalKeywors.sendkeys(loginPageObject.usernameTextField, username);
	}
	
	public boolean isUserNameDisplay()
	{
		return GernalKeywors.isDisplayed(loginPageObject.usernameTextField);
	}
	
	public void enterPassword(String password)
	{
		GernalKeywors.sendkeys(loginPageObject.passwordTextField, password);
		System.out.println(loginPageObject.loginButton.getText());
	}
	
	public void clickContinueButton()
	{
		GernalKeywors.click(loginPageObject.continuebutton);
	}
	
	public DashboardPage clickLoginButton()
	{
		GernalKeywors.click(loginPageObject.loginButton);
		return new DashboardPage(driver);
	}
}
