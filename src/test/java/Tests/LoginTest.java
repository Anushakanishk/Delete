
package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.accountpage;
import PageObjects.landingpage;
import PageObjects.loginpage;

import resources.Base;

public class LoginTest extends Base {
	
	Logger log;
	
	WebDriver driver;
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
		
		landingpage landingPage = new landingpage(driver);
		landingPage.accountsdropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginclick().click();
		log.debug("Clicked on login option");
		
		Thread.sleep(3000);
	
		loginpage loginPage = new loginpage(driver);
		loginPage.Email().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.Password().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginbutton().click();
		log.debug("Clicked on Login Button");
		
		accountpage accountPage = new accountpage(driver);
		
		String acutualResult = null;
		
		try {
			
			if(accountPage.accountbc().isDisplayed()) {
			   log.debug("User got logged in");
			   acutualResult = "Success";
			}
			
		}catch(Exception e) {
			log.debug("User didn't log in");
			acutualResult = "Failure";
			
		}
		
		if(acutualResult.equals(expectedResult)) {
			
			log.info("Login Test got passed");
			
		}else {
			
			log.error("Login Test got failed");
		}

		 
	}
	
	@AfterMethod
	public void closure() {
		
		driver.close();
		log.debug("Browser got closed");
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"arun.selenium@gmail.com","Second@123","Success"},{"dummy@test.com","1234","Failure"}};
		
		return data;
		
	}
	

}
