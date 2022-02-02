package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrgPage 
{
	public CreateNewOrgPage  (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement dropdown;
	
	
	
	public void createOrg(String NAME, String INDUSTRY)
	{
		orgNameEdt.sendKeys(NAME);
		Select s = new Select(dropdown);
		s.selectByVisibleText(INDUSTRY);
		saveBtn.click();	
	}
	public void createOrg(String NAME)
	{
		orgNameEdt.sendKeys(NAME);
		saveBtn.click();	
	}

}
