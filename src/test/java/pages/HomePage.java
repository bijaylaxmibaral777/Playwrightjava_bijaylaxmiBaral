package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;

public class HomePage {

	private final Page page;
    private final String timeLink = "oxd-text oxd-text--span oxd-main-menu-item--name";
    public HomePage(Page page)
    {
    	this.page = page;
    }

	public void clickTimelink() {
		// TODO Auto-generated method stub
		//page.click(timelink);
		page.getByText("Time" , new GetByTextOptions().setExact(true)).click();
		
	}
    
    
}

