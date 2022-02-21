package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage lp;
	HomePage homePage;
	TestUtil tu;
	ContactsPage cp;
	
	//here I'm adding sheet name for excel file which I added there
	String sheetName = "contacts";

	public ContactsPageTest() {
		super(); // to call the super class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		homePage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		// here returning HomePage so
		// we created object
		cp = new ContactsPage();
		cp = homePage.clickOnContactsLink(); // it will return contactsLink page
	}

	//@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(cp.verifyContactsLabel(), "Contacts label is missing on the page"); // this 2nf parameter will
																								// pass in console if
																								// contacts page label
																								// is not found
	}

	//@Test(priority = 2)
	public void selectContactsTest() throws InterruptedException {

		cp.selectContactsByName(); //if want to select multiple then add another linee
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data; //because it is returning data from TestUtil
		
	}
	
	
	@Test(priority=3, dataProvider = "getTestData")
	public void validateCreateNewContactString(String firstName, String lastName, String company) throws InterruptedException {
		homePage.clickOnNewContactsLink();
		Thread.sleep(2000);
		cp.fillNewContactForm(firstName, lastName, company);
		//cp.fillNewContactFoem("Chris", "Brown", "adecco");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
