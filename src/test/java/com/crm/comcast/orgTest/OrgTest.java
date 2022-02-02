package com.crm.comcast.orgTest;



import org.testng.annotations.Test;

import com.crm.comcast.objectrepositorylib.CreateNewOrgPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.OrganizationsInfo;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

import Greneric_utilities.BaseClass;


public class OrgTest extends BaseClass 
{
	@Test(groups="ST")
	public void CreateOrgTest() throws Throwable  
		
	{
		String NAME = eLib.getDataFromExcel("org", 10, 2)+ jLib.getRanDomNumber();
		//1.Navigate to org page
		HomePage hp = new HomePage(driver);
		hp.getorgLnk().click();
		
		//2.navigate to create new org
		OrganizationsPage  op = new OrganizationsPage (driver);
		op.getCreateOrgImg().click();
		
		//3.create new org
		CreateNewOrgPage  cnop = new CreateNewOrgPage (driver);
		cnop.createOrg(NAME);
	
		//4.verify
		OrganizationsInfo oinfop = new OrganizationsInfo(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccefullMsg());
		 String actSucMsg = oinfop.getSuccefullMsg().getText();
		 if(actSucMsg.contains(NAME)){
			 System.out.println("org is created");
			 System.out.println(actSucMsg);
			 System.out.println(NAME); 
		 }
		 else{
			 System.out.println("org is not created");
		 }
		
	}

@Test(groups="RT")

	public void CreateOrgWithIndustriesTest() throws Throwable 
	{
		String NAME = eLib.getDataFromExcel("org", 10, 2)+ jLib.getRanDomNumber();
		String INDUSTRY=eLib.getDataFromExcel("org", 10, 3);
		
		//1.Navigate to org
		HomePage hp = new HomePage(driver);
		hp.getorgLnk().click();
		
		//2.Navigate to create new org
		OrganizationsPage  op = new OrganizationsPage (driver);
		op.getCreateOrgImg().click();
		
		//3.create new organization
		CreateNewOrgPage  cnop = new CreateNewOrgPage (driver);
		cnop.createOrg(NAME,INDUSTRY);
		
		//4.verify
		OrganizationsInfo oinfop = new OrganizationsInfo(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccefullMsg());
		 String actSucMsg = oinfop.getSuccefullMsg().getText();
		
		 if(actSucMsg.contains(NAME)){
			 System.out.println("org with industry is created");
			 System.out.println(actSucMsg);
			 System.out.println(NAME); 
		 }
		 else{
			 System.out.println("org with industry is not created");
		 }
	}

}


