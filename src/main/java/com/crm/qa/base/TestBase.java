package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.WebEventListener;

//here we define default method which needed in every class such as openBrowser(), MaximizeWindows(0, etc.
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	//base constructor
	public TestBase(){
		try {
		prop = new Properties(); //this will read the properties
		FileInputStream f = new FileInputStream("E:\\Selenium_WorkSpace\\CRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"); //has properties file
		prop.load(f); //this will load the valuesS
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ie")){
			System.setProperty("webdriver.ie.driver", "E:\\SeleniumJars\\iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//Now create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver= e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); // we have decide this into utilities package
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);  // we have decide this into utilities package
		
		driver.get(prop.getProperty("url"));

	}
	
}
