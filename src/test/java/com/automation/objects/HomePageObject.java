package com.automation.objects;



import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class HomePageObject {

	@FindBy(xpath="//a[@title='Log In']")
	public WebElement logIn;
	
	@FindBy(linkText="Sign In")
	public WebElement signInLink;
	
	@FindBy(how = How.TAG_NAME, using="a")
	public List<WebElement> homePageLinks;
	
	// Match atleast one condition
	/*@FindAll({
		@FindBy(xpath="//a[@title='Log In']"),
		@FindBy(linkText="Sign In")
	})
	public WebElement loginLink;*/
	
	
	// Should be matched both condition
	@FindBys({
		@FindBy(xpath="//a[@title='Log In']"),
		@FindBy(xpath="//a[@title='Log In']")
	})
	public WebElement loginLink;
}
