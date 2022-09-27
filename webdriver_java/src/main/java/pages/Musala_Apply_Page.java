package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Musala_Apply_Page {
	private WebDriver driver;
//	private By nameField = By.name("your-name");
	private By emailField = By.name("your-email");
//	private By mobileField = By.name("mobile-number");
	private By agreeCheckbox = By.id("adConsentChx");
//	private By messageField = By.name("your-message");
	private By sendBtn = By.className("btn-cf-submit");
	private By outputResponse = By.className("wpcf7-response-output");
	private By closeButton = By.className("close-form");
	private By emailAlert = By.xpath("//span[contains(text(),'The e-mail address entered is invalid.')]");
	private By nameAlert = By.xpath("//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/p[2]/span[1]/span[1]");
	private By mobileAlert = By.xpath("//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/p[4]/span[1]/span[1]");
	private By fileInputField = By.name("uploadtextfield");
	
	public Musala_Apply_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	 public void setEmail(String email){
	        driver.findElement(emailField).sendKeys(email);
	 }
	 
	 public void selectCheckbox() {
		 driver.findElement(agreeCheckbox).click();
	 }
	
	 public void ScrolltoElement(String text) {
		 WebElement element = driver.findElement(By.className(text));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 }
	 
	 public void clickSend(){
		 ScrolltoElement("btn-cf-submit");
		 driver.findElement(sendBtn).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	 
	 public String validateOutputResponse() {
		 System.out.println("Responseee in method = " + driver.findElement(outputResponse).getText());
		 return driver.findElement(outputResponse).getText();
	 }
	 
	 public void ChooseFile(String filePath){
		 driver.findElement(fileInputField).sendKeys(filePath);
	 }
	 
	 
	 public void clickClose(){
		 driver.findElement(closeButton).click();
	 }
	 
	 public String getEmailAlertText(){
	        return driver.findElement(emailAlert).getText();
	 }
	 
	 public String getNameAlertText(){
	        return driver.findElement(nameAlert).getText();
	 }
	 
	 public String getMobileAlertText(){
	        return driver.findElement(mobileAlert).getText();
	 }
	 
	 
	
}
