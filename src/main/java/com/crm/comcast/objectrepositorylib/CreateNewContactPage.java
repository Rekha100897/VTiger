package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Greneric_utilities.WebDriverUtility;


public class CreateNewContactPage extends WebDriverUtility {

	public CreateNewContactPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement contactNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookupImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getcontactNameEdt()
	{
		return contactNameEdt;
	}
	
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	
	public void createContact(String CONTACT)
	{
		contactNameEdt.sendKeys(CONTACT);
		saveBtn.click();
	}
	public void createContact(String CONTACT,WebDriver driver,String NAME)
	{
		contactNameEdt.sendKeys(CONTACT);
		orgLookupImg.click();
		switchToWindow(driver, "Accounts&action");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getSrchTextEdt().sendKeys(NAME);
		op.getSrchBtn().click();
		driver.findElement(By.xpath("//a[.='"+NAME+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	}
	
}
