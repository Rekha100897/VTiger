package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
	 {
			
			public OrganizationsPage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			
			@FindBy(xpath="//img[@title='Create Organization...']")
			private WebElement createOrgImg;
			
			@FindBy(xpath="//input[@type='button']")
			private WebElement SrchBtn;
			
			@FindBy(xpath="//input[@name='search_text']")
			private WebElement SrchTextEdt;
			
			public WebElement getCreateOrgImg()
			{
				return createOrgImg;
			}
			
			public WebElement getSrchTextEdt()
			{
				return SrchTextEdt;
			}
			
			public WebElement getSrchBtn()
			{
				return SrchBtn;
			}
			

	 }
