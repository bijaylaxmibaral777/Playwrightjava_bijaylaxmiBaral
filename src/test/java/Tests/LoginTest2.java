package Tests;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.xml.sax.ext.Locator2Impl;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Page.NavigateOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitUntilState;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest2 extends BaseTest{
	@Test
	public void logintest1() {
		LoginPage loginPage = new LoginPage(page);
		HomePage homePage = new HomePage(page);
		
		test.info("Navigating to login page");
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", new NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED).setTimeout(60000));
		
		test.info("Adding username");
		loginPage.addusername("Admin");
		
		test.info("Adding password");
		loginPage.addpassword("admin123");
		
		test.info("clicking login button");
		loginPage.clickloginButton();
		
		test.info("checking homepage");
		homePage.clickTimelink();
		
		test.info("all step completed");
		
	}
	@Test
	public void logintest2() {	
    LoginPage loginPage = new LoginPage(page);
	HomePage homePage = new HomePage(page);
	
	test.info("Navigating to login page");
	page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", new NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED).setTimeout(30000));
	
	test.info("Adding username");
	loginPage.addusername("Admin");
	
	test.info("Adding incorrect password");
	loginPage.addpassword("admin1234");
	
	test.info("clicking login button");
	loginPage.clickloginButton();
	//this should fail because login should not succeed
	test.info("checking homepage");
	homePage.clickTimelink();
	
	test.info("all step completed");
	
	test.skip("Skipping this test");
	throw new SkipException("skipping this test");

	}

}

