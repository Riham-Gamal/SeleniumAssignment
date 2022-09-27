package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Musala_Careers_Page {
	private WebDriver driver;
	private By openPositionBtn = By.xpath("//span[contains(text(),'Check our open positions')]");	
	
	public Musala_Careers_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public Musala_JoinUs_Page clickopenPositionBtn()
	{
		driver.findElement(openPositionBtn).click();
		return new Musala_JoinUs_Page(driver);
	}
	
	public void assertURL(String URL) { 
		assertTrue(driver.getCurrentUrl()
	              .contains(URL), "URL is correct");
	}
	
	
}
