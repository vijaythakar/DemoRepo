package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {



	// Page Factory - OR(Object Repository)
	@FindBy(xpath = "//div[@class='rd-navbar-wrap']/a")
	WebElement loginHome;

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement LoginWindow;

	@FindBy(linkText = "sign up")
	WebElement signup;

	@FindBy(className = "brand-name")
	WebElement crmLogo;

	// initializing the page objects
	// here we are creating constructor of our page which has Page Factory
	// variables, such as login,email, etc.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed(); // it will written true or false
	}

	public void loginBtnClick() {
		loginHome.click();

	}

	public HomePage login(String un, String pwd) {
		loginHome.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginWindow.click();
		
		return new HomePage();
	}

}
