/**
 * 
 */
package com.automation.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author CHIRAG
 *
 */
public class LoginPageObject {

	@FindBy(id="usernameOrEmail")
	@AndroidFindBy(id="org.wordpress.android:id/nux_username")
	public WebElement usernameTextField;
	
	@AndroidFindBy(id="org.wordpress.android:id/nux_password")
	@FindBy(id="password")
	public WebElement passwordTextField;
		
	@FindBy(xpath="//button[text()='Continue']")
	public WebElement continuebutton;
	
//	@AndroidFindBy(xpath= "//*[@text='Sign in']/../following::android.widget.TextView[1]")
	@AndroidFindBy(id = "org.wordpress.android:id/nux_sign_in_button")		
	@FindBy(xpath="//button[text()='Log In']")
	public WebElement loginButton;
}
