package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver driver;
	
	public loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(xpath="//*[@value='Login']")
	private WebElement loginbutton;
	
	public WebElement Email() {
		return Email;
	}
	public WebElement Password() {
		return Password;
	}
	public WebElement loginbutton() {
		return loginbutton;
	}

}
