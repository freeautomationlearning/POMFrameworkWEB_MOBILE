/**
 * 
 */
package com.automation.utility;

import org.openqa.selenium.WebElement;

/**
 * @author CHIRAG
 *
 */
public class GernalKeywors {

	public static void click(WebElement ele)
	{
		ele.click();
	}
	
	public static void sendkeys(WebElement ele, String text)
	{
		ele.sendKeys(text);
	}
	
	public static boolean isDisplayed(WebElement ele)
	{
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
}
