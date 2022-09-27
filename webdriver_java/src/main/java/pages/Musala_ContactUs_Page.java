package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Musala_ContactUs_Page {
	
	private WebDriver driver;
	private By nameField = By.name("your-name");
	private By emailField = By.name("your-email");
	private By mobileField = By.name("mobile-number");
	private By subjectField = By.name("your-subject");
	private By messageField = By.name("your-message");
	private By sendBtn = By.xpath("//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/div[3]/p[1]/input[1]");
	private By emailAlert = By.xpath("//span[contains(text(),'The e-mail address entered is invalid.')]");
	
	public Musala_ContactUs_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	 public void setName(String name){
	        driver.findElement(nameField).sendKeys(name);
	 }
	 
	 public void setEmail(String email){
	        driver.findElement(emailField).sendKeys(email);
	 }
	 
	 public void setMobile(String mobile){
	        driver.findElement(mobileField).sendKeys(mobile);
	 }
	 
	 public void setSubject(String subject){
	        driver.findElement(subjectField).sendKeys(subject);
	 }
	 
	 public void setMessage(String message){
	        driver.findElement(messageField).sendKeys(message);
	 }
	 
	 public void clickSend(){
		 ScrolltoElement("//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/div[3]/p[1]/input[1]");
		 driver.findElement(sendBtn).click();
	 }
	 
	 public String getEmailAlertText(){
	        return driver.findElement(emailAlert).getText();
	 }
	 
	 public void ScrolltoElement(String text) {
			WebElement element = driver.findElement(By.xpath(text));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			//Thread.sleep(500); 
	 }

}
