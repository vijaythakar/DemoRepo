package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class ContactsPage extends TestBase{
	
	
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement checkContactsLabel;
	
	@FindBy(xpath = "//div[@class='table-wrapper']//td[1]")
	WebElement checkBox;
	
	@FindBy(xpath = "//div[@id='dashboard-toolbar']")
	WebElement click; 
	
	//for firstname
	@FindBy(name = "first_name")
	WebElement firstName;
	
	//for lastname
	@FindBy(name = "last_name")
	WebElement lastName;
	
	//for company
	@FindBy(xpath = "//div[@name='company']/input")
	WebElement company;
	
	//for company drop down
	@FindBy(xpath = "//div[@class='visible menu transition']")
	WebElement addCompany;
	
	//for category
	@FindBy(name = "category")
	WebElement category;
	
	// for save button
	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	WebElement save;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		 return checkContactsLabel.isDisplayed(); 
	}
	
	public void selectContactsByName() {
		click.click();
		checkBox.click();
	}
	
	public void fillNewContactForm(String fName, String lName, String comp) throws InterruptedException {
				
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		Thread.sleep(2000);
		addCompany.click();
		
//		Select select = new Select(category);
//		select.selectByVisibleText(cat);
		save.click();
		
		
		
		
		
	}
}
