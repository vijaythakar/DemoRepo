package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	// test cases should be sepArated -- independent with eaCH OTHER
	// BEFORE EACH TEST CASE - launch the browser and login
	// @Test -- execute test case
	// after each test case - close the browser.
	// we have to access the Homepage, therefore we have added login page object
	// here so in beforemethod it will be initialized
	@BeforeMethod
	public void setUp() {
		initialization();
		contactsPage = new ContactsPage();
		lp = new LoginPage();
		homePage = lp.login(prop.getProperty("username"), prop.getProperty("password")); // here returning HomePage so
																							// we created object
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle(); // here using the created object we are calling the page
																// title
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched"); // if the test case failed
																							// then it will print the
																							// 3rd parameter
	}

	@Test(priority = 2)
	public void verifyUserNameLabel() {
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
