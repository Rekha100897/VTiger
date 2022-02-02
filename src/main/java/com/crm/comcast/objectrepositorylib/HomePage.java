package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactsLnk;
	
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement orgLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorImg;
	
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	
	public WebElement getContactLnk()
	{
		return contactsLnk;
	}
	
	public WebElement getorgLnk()
	{
		return orgLnk;
	}
	
	public WebElement getAdministatorImg()
	{
		return administatorImg;
	}
	
	public WebElement getSignOutLnk()
	{
		return signOutLnk;
	}
	
	public void logout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(administatorImg).perform();
		signOutLnk.click();
	}
	
}
