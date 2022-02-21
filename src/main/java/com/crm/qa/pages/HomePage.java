package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	
	//Page Factors
	@FindBy(className = "user-display")
	@CacheLookup //it will store the webelement and from next time it will get the element from cache lookup
	
	WebElement userNamelabel;
	
	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][3]/button")
	@CacheLookup
	WebElement newContactLink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement tasksLink;
	
	//for outside click
	@FindBy(xpath = "//div[@id='dashboard-toolbar']")
	WebElement click; 

	
	//this will initialize all the page objects.
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//whenever performing testing firstly check page title, some symbol or names which are written there to confirm that page is correct.
	//this is  called pageLibraries.
	public String verifyHomePageTitle() {
		return driver.getTitle(); //this will return string
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();	
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();	
	}
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();	
	}
	
	public Boolean verifyUserNameLabel() {
		return userNamelabel.isDisplayed();
	}
	
	//clicking on plus sign
	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		click.click();
		
	}
	
}
