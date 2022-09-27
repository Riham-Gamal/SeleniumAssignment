package pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Musala_Company_Page {
	private WebDriver driver;
	private By leadershipLabel = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/section[3]/div[1]/h2[1]");
	private By fbLink = By.xpath("//body/footer[1]/div[1]/div[1]/a[4]/span[1]");
	private By cookies = By.id("wt-cli-accept-all-btn");
//	private By fbProfilePicture = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/svg[1]/g[1]/image[1]");
	private By fbProfilePicture = By.xpath("(//*[name()='image'])[1]");
	
	
	public Musala_Company_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertURL(String URL) { 
		//System.out.println("driver.getCurrentUrl()" + driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl()
	              .contains(URL),
	              "URL is correct");
	}
	
	public void assertLeadershipSection() {
		WebElement leaderShip = driver.findElement(leadershipLabel);
		Assert.assertEquals(true, leaderShip.isDisplayed());
		
	}
	
	public void acceptCookies()
	{
		driver.findElement(cookies).click();
	}
	
	public void clickLink(String link) {
		switch (link) {
		case "Facebook": {
			System.out.println("Link = " + link);
			driver.findElement(fbLink).click();
		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + link);
		}
	}
	
	public void switchTab() {
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
	}
	
	
	public void verifyFacebookProfilePicture() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement profilePicture = driver.findElement(fbProfilePicture);

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", profilePicture);
	       
//		Boolean p = (Boolean) ((JavascriptExecutor)driver)
//		.executeScript("return arguments[0].complete "
//		+ "&& typeof arguments[0].naturalWidth != \"undefined\" "
//		+ "&& arguments[0].naturalWidth > 0", profilePicture);
		
		assertTrue(ImagePresent, "Musala Soft profile picture appears on the new page");
	}
}
