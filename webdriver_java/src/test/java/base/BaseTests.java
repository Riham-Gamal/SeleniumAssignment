package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.google.common.io.Files;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.Musala_HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected Musala_HomePage musalahomePage;
    PropertiesFile prop = new PropertiesFile();
    
	@Parameters("browserName")
    @BeforeClass
    public void setUp(String browserName){
//        String browser = prop.getBrowser();
//    	System.out.println("browser = " + browserName);
        if (browserName.equalsIgnoreCase("Chrome")) {
        	WebDriverManager.chromedriver().setup();
	        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
	        goHome();
        }
        else if (browserName.equalsIgnoreCase("Firefox")) {
        	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	        goHome();
		}
    }

    @BeforeMethod
    public void goHome(){
        driver.get(prop.getApplicationUrl());
        musalahomePage = new Musala_HomePage(driver);
    }

	@AfterClass
    public void tearDown(){
       driver.quit();
    }

    @AfterMethod
//    public void recordFailure(ITestResult result){
//        if(ITestResult.FAILURE == result.getStatus())
//        {
//            var camera = (TakesScreenshot)driver;
//            File screenshot = camera.getScreenshotAs(OutputType.FILE);
//            try{
//                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//        }
//    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

}