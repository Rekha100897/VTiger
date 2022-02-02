package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.objectrepositorylib.ContactInfo;
import com.crm.comcast.objectrepositorylib.ContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewContactPage;
import com.crm.comcast.objectrepositorylib.CreateNewOrgPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.OrganizationsInfo;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

import Greneric_utilities.BaseClass;


public class ContactTest extends BaseClass
{
	@Test(groups="ST")
	public void createContact() throws Throwable  
		
	{
		String NAME = eLib.getDataFromExcel("contact", 1, 1) + "_"+jLib.getRanDomNumber();
	
		//1.contact page
		HomePage hp = new HomePage(driver);
		hp.getContactLnk().click();
		
		//2.navigate to create contact page
		ContactsPage op = new ContactsPage(driver);
		op.getCreateContactImg().click();
		
		//3.create new contact
		CreateNewContactPage cnop = new CreateNewContactPage(driver);
		cnop.createContact(NAME);

		//4.verify
		ContactInfo oinfop = new ContactInfo(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccefullMsg());
		 String actSucMsg = oinfop.getSuccefullMsg().getText();
		if(actSucMsg.contains(NAME))
		{
			System.out.println("contact is created successfully ==>PASS");
			System.out.println(NAME);
		}
		else
		{
			
			System.out.println("contact is NOT created successfully ==>FAIL");
		}
	}
	
@Test(groups="RT")
	public void createContactWithOrgTest() throws Throwable 
	{
		String NAME = eLib.getDataFromExcel("org", 1, 1) + "_"+jLib.getRanDomNumber();
		String CONTACT = eLib.getDataFromExcel("contact", 1, 1) + "_"+jLib.getRanDomNumber();
	
		//1.NAVIGATE TO ORG PAGE
		HomePage hp = new HomePage(driver);
		hp.getorgLnk().click();
		
		//2.NAVIGATE TO CREATE NEW ORG
		OrganizationsPage  op = new OrganizationsPage (driver);
		op.getCreateOrgImg().click();
		
		//3.CREATE NEW ORGANIZATION
		CreateNewOrgPage  cnop = new CreateNewOrgPage (driver);
		cnop.createOrg(NAME);
		
		//4.VERIFY ORG CREATION
		OrganizationsInfo oinfop = new OrganizationsInfo(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccefullMsg());
		
	
		
		
		//5.NAVIGATE TO CONTACT PAGE
		hp.getContactLnk().click();
		
		//6.CREATE NEW CONTACT PAGE
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactImg().click();
		
		//7.CREATE NEW CONTACT WITH ORG NAME
		CreateNewContactPage candn = new CreateNewContactPage(driver);
		candn.createContact(CONTACT,driver, NAME);
		
		//8.VERIFY 
		ContactInfo cinfop = new ContactInfo(driver);
		wLib.waitForElementVisibility(driver, cinfop.getSuccefullMsg());
		String ConfMsg = cinfop.getSuccefullMsg().getText();
		Assert.assertTrue(ConfMsg.contains(CONTACT), "FAIL");
		System.out.println("PASS");
		
		String actSucMsg = oinfop.getSuccefullMsg().getText();
		System.out.println(NAME);
		System.out.println(actSucMsg);
		hp.getContactLnk().click();
		
	}
		
}

