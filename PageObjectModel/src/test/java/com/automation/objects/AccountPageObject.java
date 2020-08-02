/**
 * 
 */
package com.automation.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author CHIRAG
 *
 */
public class AccountPageObject {
	
	@AndroidFindBy(id="org.wordpress.android:id/me_login_logout_text_view")
	@FindBy(how = How.XPATH,using="//button[text()='Log out']")
	public WebElement signoutButton;
	
	@AndroidFindBy(xpath = "//*[@text='Disconnect']")
	public WebElement disconnect;
}
