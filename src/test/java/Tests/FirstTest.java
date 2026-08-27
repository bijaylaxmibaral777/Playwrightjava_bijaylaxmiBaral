package Tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public void verifyTitle() {
		page.navigate("https://www.google.com/ncr");
		// optional:handle cookie popup
		if (page.isVisible("button:has-text('Accept all')")) {
			page.click("button:has-text('Accept all')");
		}

		System.out.println("the page title is :" + page.title());
	}

//	// create main method
//	public static void main(String[] args) {
//		try (Playwright playwright = Playwright.create()) {
//			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//			Page page = browser.newPage();
//			page.navigate("https://google.com");
//			System.out.println("the page title is :" + page.title());
//			page.title();
//			browser.close();
//
//		}
//	}
}
