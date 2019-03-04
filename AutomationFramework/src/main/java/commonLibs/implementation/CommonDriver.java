package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {

	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementDetectTimeout;

	public CommonDriver(String browserType) throws Exception {

		pageLoadTimeout = 60;
		elementDetectTimeout = 6;
		browserType = browserType.trim();

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"F:\\Lakshmy-softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"F:\\Lakshmy-softwares\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser type not listed, setting Chrome as default browser");
			System.setProperty("webdriver.chrome.driver",
					"F:\\Lakshmy-softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectTimeout(int elementDetectTimeout) {
		this.elementDetectTimeout = elementDetectTimeout;
	}

	@Override
	public void navigateToFirstUrl(String url) {

		url = url.trim();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectTimeout, TimeUnit.SECONDS);
		driver.get(url);

	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) {
		url = url.trim();
		driver.navigate().to(url);
	}

	@Override
	public void navigateForward() {
		driver.navigate().forward();
	}

	@Override
	public void navigateBackward() {
		driver.navigate().back();
	}

	@Override
	public void refresh() {
		driver.navigate().refresh();
	}

	@Override
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	@Override
	public void closeAllBrowsers() {
		if (driver != null) {
			driver.quit();
		}
	}

}
