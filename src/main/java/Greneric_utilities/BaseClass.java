package Greneric_utilities;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;

import Greneric_utilities.ExcelUtility;
import Greneric_utilities.FileUTiltiy;
import Greneric_utilities.JavaUtility;
import Greneric_utilities.WebDriverUtility;

public class BaseClass 
{
	public WebDriver driver = null;
	//object creation 
	public ExcelUtility eLib = new ExcelUtility();
	public FileUTiltiy fLib = new FileUTiltiy();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	@BeforeSuite(groups={"ST","RT"})
	public void cinfigBS()
	{
		System.out.println("========== connect to DB =================");
	}
	
	
	@BeforeClass(groups={"ST","RT"})
	public void configBC()throws Throwable
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		System.out.println("============== launch Browser ============");
		if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod(groups={"ST","RT"})
	public void configBM() throws Throwable
	{
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups={"ST","RT"})
	public void configAM()
	{
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups={"ST","RT"})
	public void cofigAC()
	{
		driver.close();
	}

	@AfterSuite(groups={"ST","RT"})
	public void configAS()
	{
		System.out.println("========== close DB =================");
	}

}
