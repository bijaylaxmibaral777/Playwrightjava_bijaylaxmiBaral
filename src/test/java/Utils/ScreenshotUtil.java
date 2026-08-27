package Utils;

import java.io.File;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class ScreenshotUtil
{
	
	public static String takeScreenshot(Page page, String testName)
	{
		
		String folder = "test-output/screenshots/";
		File directoryFile = new File(folder);
		if(!directoryFile.exists())
		{
			directoryFile.mkdirs();
		}
		
		String path = folder+ testName+ ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		return path;
	}
}

