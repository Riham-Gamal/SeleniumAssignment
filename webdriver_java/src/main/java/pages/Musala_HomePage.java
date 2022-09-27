package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Musala_HomePage {
	private WebDriver driver;
	
	public Musala_HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public Musala_ContactUs_Page clickContactUsBtn(){
		ScrolltoElement("//*[text()='Contact us']");
		clickButton("//*[text()='Contact us']");
        return new Musala_ContactUs_Page(driver);
        
    }
	
	public Musala_Careers_Page clickCareersLink(){
		clickButton("//header/nav[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");
        return new Musala_Careers_Page(driver);
    }
	
	public Musala_Company_Page clickCompanyLink(){
		clickButton("//header/nav[2]/div[1]/div[1]/ul[1]/li[1]/a[1]");
		return new Musala_Company_Page(driver);
    }
	
	public void ScrolltoElement(String linkText) {
		WebElement element = driver.findElement(By.xpath(linkText));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//Thread.sleep(500); 
	}
	
	
	private void clickButton(String linkText){
        driver.findElement(By.xpath(linkText)).click();
		
    }
	
}
