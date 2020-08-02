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
public class DashboardPageObject {

	@AndroidFindBy(xpath="//android.widget.HorizontalScrollView//android.support.v7.app.ActionBar.Tab[3]//android.widget.ImageView")
	@FindBy(xpath="(//*[@class='masterbar__item-content'])[4]/..")
	public WebElement dashboard;
}
