package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountpage {
	
	WebDriver driver;
	
	public accountpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[text()='My Account']")
	private WebElement accountbc;
	
	public WebElement accountbc() {
		return accountbc;
		
	}
	
}
