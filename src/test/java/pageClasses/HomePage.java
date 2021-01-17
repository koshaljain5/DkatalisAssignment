package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
 * @author: Koshal Jain
 * Page Class: HomePage
 */

public class HomePage extends BaseClass{

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn buy']")
	@CacheLookup
	WebElement btn_BuyNow;
	
	@FindBy(xpath = "//div[@class='cart-checkout']")
	@CacheLookup
	WebElement btn_CheckOut;
	
	@FindBy(xpath = "//div[@class='trans-status trans-success']")
	@CacheLookup
	WebElement message_Success;
	
	
	
	//Action Methods
	
	/*
	 * function to click button BuyNow
	 */
	@SuppressWarnings("unchecked")
	public void clickbtnBuyNow()
	{
		waitfluent.until(ExpectedConditions.visibilityOf(btn_BuyNow));
		btn_BuyNow.click();
	}
	
	/*
	 * function to click button CheckOut
	 */
	@SuppressWarnings("unchecked")
	public void clickbtnCheckOut()
	{
		waitfluent.until(ExpectedConditions.visibilityOf(btn_CheckOut));
		btn_CheckOut.click();
	}

	/*
	 * function to Verify Transaction is successful or not
	 */
	@SuppressWarnings("unchecked")
	public Boolean isTransactionSuccess() throws InterruptedException
	{
		waitfluent.until(ExpectedConditions.visibilityOf(message_Success));
		Boolean flag = message_Success.isDisplayed();
		return flag;
	}
	
}
