package pageClasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * @author: Koshal Jain
 * Base Class in POM framework
 * Webdriver Initialization and Common function/Variable declaration
 */

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Wait waitfluent;
	
	/*
	 * function to Launch browser as per user's input from feature file
	 */
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver,30);
		
		waitfluent = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(WebDriverException.class);
		
		driver.manage().window().maximize();
	}
	
	
	/*
	 * Launch URL, parameter input from feature file
	 */
	public void launchUrl(String url)
	{
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	//common elements
	@FindBy(id = "snap-midtrans")
	@CacheLookup
	WebElement frameOrderSummary;
	
	@FindBy(xpath = "//iframe[contains(@src,'api.sandbox')]")
	@CacheLookup
	WebElement frameOTPPage;
	
	/*
	 * Class constructor to initialising same properties as parent constructor
	 */
	public BaseClass() {
		
		PageFactory.initElements(driver, this);
	}

}
