package commonLibs.contracts;

public interface IDriver {

	public void navigateToFirstUrl(String url);
	public String getTitle();
	public String getCurrentURL();
	public String getPageSource();
	public void navigateToUrl(String url);
	public void navigateForward();
	public void navigateBackward();
	public void refresh();
	public void closeBrowser();
	public void closeAllBrowsers();
	
	
}
