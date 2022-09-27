package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Musala_JoinUs_Page {
	private WebDriver driver;
	private By drpMenuLocation = By.name("get_location");
	private By applyBtn = By.className("btn-apply");
	private By cookies = By.id("wt-cli-accept-all-btn");
	
	
	public Musala_JoinUs_Page(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
	}
	
	public void selectLocation (String Location) {
		Select drpLocation = new Select(driver.findElement(drpMenuLocation));
		drpLocation.selectByValue(Location);
	}
	
	public void chooseOpenPosition(String Position) {
		Position = "//h2[contains(text(),'" + Position + "')]";
		driver.findElement(By.xpath(Position)).click();
	}
	
	public void ScrolltoElement(String text) {
		WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'" + text + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void assertElementExist(String labelText) {
		assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'" + labelText + "')]")).getText(),
	              labelText, labelText + " section is correct");
	}
	
	public void acceptCookies() {
		driver.findElement(cookies).click();
	}
	
	public Musala_Apply_Page clickApply() { 
		driver.findElement(applyBtn).click();
		return new Musala_Apply_Page(driver);
	}
}
