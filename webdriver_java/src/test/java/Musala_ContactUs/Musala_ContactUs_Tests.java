package Musala_ContactUs;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTests;
import pages.Musala_ContactUs_Page;

public class Musala_ContactUs_Tests extends BaseTests{

	@Test
    public void testWrongEmail(){
		
		
		Musala_ContactUs_Page ContactUsPage= musalahomePage.clickContactUsBtn();
		
		ContactUsPage.setName("Riham");
		ContactUsPage.setEmail("1a2");
		ContactUsPage.setMobile("00201045990019");
		ContactUsPage.setSubject("Hello");
		ContactUsPage.setMessage("This is the message");
		ContactUsPage.clickSend();
		
		
		AssertJUnit.assertTrue(ContactUsPage.getEmailAlertText()
              .contains("The e-mail address entered is invalid"));
    }
}
