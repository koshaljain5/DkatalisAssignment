package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * @author: Koshal Jain
 * Page Class: Select Payment
 */
public class SelectPayment extends BaseClass{

	public SelectPayment()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='list with-promo']//div[contains(@class,'text-actionable-bold')]")
	@CacheLookup
	List<WebElement> link_PaymentMethod;
	
	
	/*
	 * function to click on Payment Method: parameters input from feature file
	 */
	@SuppressWarnings("unchecked")
	public void clicklinkPaymentMethod(String paymentMethod)
	{
		
		wait.ignoring(WebDriverException.class)
			.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameOrderSummary));
		
		for (WebElement ele : link_PaymentMethod) {
			if(ele.getText().equalsIgnoreCase(paymentMethod))
			{
				waitfluent.until(ExpectedConditions.visibilityOf(ele));
				ele.click();
				break;
			}
		}
		driver.switchTo().defaultContent();
	}
}
