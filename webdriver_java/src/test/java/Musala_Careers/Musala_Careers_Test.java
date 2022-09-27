package Musala_Careers;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTests;
import config.PropertiesFile;
import pages.Musala_Apply_Page;
import pages.Musala_Careers_Page;
import pages.Musala_JoinUs_Page;

public class Musala_Careers_Test extends BaseTests{
	
	@Test
    public void testCareersPage() {
		
		PropertiesFile prop = new PropertiesFile();
		Musala_Careers_Page CareersPage= musalahomePage.clickCareersLink();
		
		Musala_JoinUs_Page JoinUsPage = CareersPage.clickopenPositionBtn();
		
		CareersPage.assertURL(prop.getApplicationUrl()+"/careers/join-us/");
		
		JoinUsPage.selectLocation("Anywhere");
		JoinUsPage.ScrolltoElement("Senior Java Developer");
		JoinUsPage.chooseOpenPosition("Senior Java Developer");
		
		JoinUsPage.assertElementExist("General description");
		JoinUsPage.assertElementExist("Requirements");
		JoinUsPage.assertElementExist("Responsibilities");
		JoinUsPage.assertElementExist("What we offer");
		JoinUsPage.acceptCookies();
		
		Musala_Apply_Page applyPage = JoinUsPage.clickApply();
		applyPage.setEmail("123@qq");
		applyPage.selectCheckbox();
		
		applyPage.ChooseFile(System.getProperty("user.dir") + "//resources");
		
		applyPage.clickSend();

//		System.out.println("Responseee = " + applyPage.validateOutputResponse());
		
//		assertTrue(applyPage.validateOutputResponse()
//	              .contains("One or more fields have an error. Please check and try again."),
//	              "Response output is correct");
		
		applyPage.clickClose();
		
		AssertJUnit.assertTrue(applyPage.getEmailAlertText()
	              .contains("The e-mail address entered is invalid"));
		
		AssertJUnit.assertTrue(applyPage.getNameAlertText()
	              .contains("The field is required"));
		
		AssertJUnit.assertTrue(applyPage.getMobileAlertText()
	              .contains("The field is required"));
	}
}
