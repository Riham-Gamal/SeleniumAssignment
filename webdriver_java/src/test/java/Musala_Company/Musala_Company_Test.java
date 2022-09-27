package Musala_Company;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import base.BaseTests;
import config.PropertiesFile;
import pages.Musala_Company_Page;

public class Musala_Company_Test extends BaseTests {
	
	@Test
    public void testCompanyPage() {
		Musala_Company_Page CompanyPage= musalahomePage.clickCompanyLink();
		PropertiesFile prop = new PropertiesFile();

		CompanyPage.assertURL(prop.getApplicationUrl() + "/company/");
		CompanyPage.assertLeadershipSection();
		CompanyPage.acceptCookies();
		CompanyPage.clickLink("Facebook");
		CompanyPage.switchTab();
		CompanyPage.assertURL("https://www.facebook.com/MusalaSoft?fref=ts");
//		CompanyPage.verifyFacebookProfilePicture();
	}
}