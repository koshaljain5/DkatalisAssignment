package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.junit.*;;

/*
 * @author: Koshal Jain
 * Page Class: Order Summary
 */
public class OrderSummary extends BaseClass {

	@FindBy(xpath = "//a//span[text()='Continue']")
	@CacheLookup
	WebElement btn_Continue;
	
	@FindBy(xpath = "//a[@class='list with-promo']//div[contains(@class,'text-actionable-bold')]")
	@CacheLookup
	List<WebElement> link_PaymentMethod;
	
	@FindBy(xpath = "//p[@class='text-page-title-content']")
	@CacheLookup
	WebElement pageTitle;
	
	@FindBy(xpath = "//input[@name='cardnumber']")
	@CacheLookup
	WebElement txt_CardNumber;
	
	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	@CacheLookup
	WebElement txt_CardExpiry;
	
	@FindBy(xpath = "//input[@style='font-family: cvvpass;']")
	@CacheLookup
	WebElement txt_CardCVV;
	
	@FindBy(xpath = "//a//span[text()='Pay Now']")
	@CacheLookup
	WebElement btn_PayNow;

	@FindBy(id = "PaRes")
	@CacheLookup
	WebElement txt_OTP;

	@FindBy(xpath = "//button[@name='ok']")
	@CacheLookup
	WebElement btn_Ok;
	
	@FindBy(xpath = "//div[@class='trans-status trans-success']")
	@CacheLookup
	WebElement message_Success;
	

	public OrderSummary () {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * function to Verify page title: input from feature file
	 */
	@SuppressWarnings("unchecked")
	public void verifyPageTitle(String title)
	{
		wait.ignoring(WebDriverException.class)
			.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameOrderSummary));
		waitfluent.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='text-page-title']/p[text()='"+title+"']")));
		Assert.assertTrue(pageTitle.getText()
			.equals(title));
		driver.switchTo().defaultContent();
	}
	
	/*
	 * function to Click Continue button
	 */
	@SuppressWarnings("unchecked")
	public void clickbtnContinue()
	{
		wait.ignoring(WebDriverException.class)
			.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameOrderSummary));
		waitfluent.until(ExpectedConditions.visibilityOf(btn_Continue));
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", btn_Continue);
		driver.switchTo().defaultContent();
	}
	
	/*
	 * function to Set Card Details: Number, Expiry & CVV
	 */
	public void setCarddetails(String cardnumer, String expiryDate, String cvv)
	{
		wait.ignoring(WebDriverException.class)
			.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameOrderSummary));
		txt_CardNumber.sendKeys(cardnumer);
		txt_CardExpiry.sendKeys(expiryDate);
		txt_CardCVV.sendKeys(cvv);
		driver.switchTo().defaultContent();
	}
	
	/*
	 * function to Click Pay Now button
	 */
	@SuppressWarnings("unchecked")
	public void clickbtnPayNow()
	{
		wait.ignoring(WebDriverException.class)
			.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameOrderSummary));
		waitfluent.until(ExpectedConditions.visibilityOf(btn_PayNow));
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", btn_PayNow);
		driver.switchTo().defaultContent();
	}
	
	/*
	 * function to click OK button on OTP page
	 */
	public void clickbtnOk()
	{
		switchTwoFrames();
		btn_Ok.click();
		driver.switchTo().defaultContent();
	}

	/*
	 * function to Set OTP
	 */
	@SuppressWarnings("unchecked")
	public void setOTP(String otp)
	{
		switchTwoFrames();
		waitfluent.until(ExpectedConditions.visibilityOf(txt_OTP));
		//((JavascriptExecutor) driver).executeScript("document.getElementById('s').value='Avinash Mishra';");
		txt_OTP.sendKeys(otp);
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", btn_Ok);
		//btn_Ok.click();
		driver.switchTo().defaultContent();
	}
	
	/*
	 * function to Verify OTP field
	 */
	@SuppressWarnings("unchecked")
	public void verifyOTPpage()
	{
		switchTwoFrames();
		waitfluent.until(ExpectedConditions.visibilityOf(txt_OTP));
		Assert.assertTrue(txt_OTP.isDisplayed());
		driver.switchTo().defaultContent();
	}
	
	/*
	 * function to Switch two frames on OTP page
	 */
	public void switchTwoFrames()
	{
		wait.ignoring(WebDriverException.class).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameOrderSummary));
        wait.ignoring(WebDriverException.class).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameOTPPage));
	}
}
