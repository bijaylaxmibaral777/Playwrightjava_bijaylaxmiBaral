package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	//Locators
	private final String usernameTextbox = "input[name='username']";
	private final String PasswordTextbox = "input[name='password']";
	private final String loginButton = "button[type='submit']";
	//constructor
	public LoginPage(Page page)
	{
		this.page = page;
	}
	//page actions
//	public void navigation()
//	{
//		page.navigate("https://opensource-demo.orangehrmlive.com/");
//		
//	}
	public void addusername(String username)
	{
		page.fill(usernameTextbox, username);
	}
	public void addpassword(String password)
	{
		page.fill(PasswordTextbox, password);
	}
	public void clickloginButton()
	{
		page.click(loginButton);
	}
	public void click(String username, String password)
	{
		page.fill(usernameTextbox, username);
		page.fill(PasswordTextbox, password);
		page.click(loginButton);
	}
	
}
