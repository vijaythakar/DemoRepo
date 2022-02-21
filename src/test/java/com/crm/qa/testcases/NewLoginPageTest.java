package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class NewLoginPageTest extends TestBase {
	
	LoginPage lp;	
	HomePage homePage;
	
	SoftAssert softAssert = new SoftAssert();

	public NewLoginPageTest() {
		super(); // it will call superclass constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();

	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = lp.validateLoginPageTitle();
		softAssert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}

	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag = lp.validateCRMLogo();
		softAssert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginTest() throws InterruptedException {
		homePage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
