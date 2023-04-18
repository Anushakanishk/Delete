package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {
	
	WebDriver driver;
	public landingpage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@class=\"fa fa-user\"]/following::span[text()='My Account']")
	private WebElement accountsdropdown;
	
	@FindBy(xpath="//*[@class=\"fa fa-user\"]/following::*[text()='Login']")
	private WebElement loginclick;
	
	public WebElement accountsdropdown() {
		return accountsdropdown;
	}
	
	public WebElement loginclick() {
		return loginclick;
	}

}
