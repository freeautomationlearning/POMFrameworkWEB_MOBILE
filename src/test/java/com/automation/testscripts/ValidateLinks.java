package com.automation.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.baseclass.BaseClass;
import com.automation.pages.HomePage;

/**
 * @author CHIRAG
 *
 */
public class ValidateLinks {

	HomePage homePage ;
	BaseClass baseClass;

	@BeforeClass
	public void initalizeObject()
	{
		baseClass = new BaseClass();
		baseClass.setup();
	}

	@Test
	public void validateHomePageLink()
	{
		homePage = new HomePage(baseClass.getDriver());
		int link = homePage.verifyNumberofLinks();
		System.out.println("LINK : "+link);
		System.out.println(homePage.isSignAndLoginDisplay());
	}

	@AfterClass
	public void tearDown()
	{
		baseClass.tearDown(baseClass.getDriver());
	}
}
