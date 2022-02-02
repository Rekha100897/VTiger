package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {  
	
	
	
	@FindBy(name = "user_name")   
	private WebElement userNameEdt;
	
	
	@FindBy(name = "user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginBtn;
	
	public  LoginPage(WebDriver driver)  
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}
	public WebElement getUserPasswordEdt(){
		return userPasswordEdt;
	}
	public WebElement getLoginBtn(){
		return loginBtn; 
	}
	
	public void loginToApp(String userName, String password){
		
		userNameEdt.sendKeys("admin");
		userPasswordEdt.sendKeys("admin");
		loginBtn.click();
	}

}
