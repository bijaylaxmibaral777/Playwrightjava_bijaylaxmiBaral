package base;

import java.lang.reflect.Method;
import java.security.PublicKey;
import java.sql.ResultSet;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Utils.ExtentManager;
import Utils.ScreenshotUtil;

public class BaseTest {

	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeMethod
	public void setup(Method method) {
		// Reporting
		extent = ExtentManager.getInstance();
		test = extent.createTest(method.getName());

		// playwright setup
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		page = browser.newPage();

	}

	
	@AfterMethod
	public void tearDown(ITestResult result) {

	    String screenshotPath =
	            ScreenshotUtil.takeScreenshot(page, result.getName());

	    String projectpath = System.getProperty("user.dir");
	    String absoluteScreenshotpath =
	            projectpath + "/" + screenshotPath;

	    System.out.println("*** screenshotPath : " + screenshotPath);
	    System.out.println("*** absoluteScreenshotpath : " + absoluteScreenshotpath);

	    if (result.getStatus() == ITestResult.FAILURE) {

	        test.fail(result.getThrowable());
	        test.addScreenCaptureFromPath(absoluteScreenshotpath);

	    } else if (result.getStatus() == ITestResult.SUCCESS) {

	        test.pass("Test passed");
	        test.addScreenCaptureFromPath(absoluteScreenshotpath);

	    } else {

	        test.skip("Test skipped");
	    }

	    extent.flush();

	    if (browser != null) {
	        browser.close();
	    }

	    if (playwright != null) {
	        playwright.close();
	    }
	}
}

