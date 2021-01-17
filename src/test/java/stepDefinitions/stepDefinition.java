package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageClasses.BaseClass;
import pageClasses.HomePage;
import pageClasses.OrderSummary;
import pageClasses.SelectPayment;


public class stepDefinition extends BaseClass{

	HomePage hp;
	OrderSummary os;
	SelectPayment sp;
	
	
	@After
	public void closeBrowser(Scenario scenario)
	{
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Failed Step");
			driver.quit();
		}
	}
	
	@Given("User Launches {string} browser")
	public void user_launches_browser(String browser) {
		launchBrowser(browser);
		hp = new HomePage();
		os = new OrderSummary();
		sp = new SelectPayment();
	}

	@When("Navigate to URL {string}")
	public void navigate_to_url(String url) {
		launchUrl(url);
	}

	@Then("Verify home page title as {string} and BuyNow button")
	public void verify_home_page_title_as_and_buy_now_button(String title) {		
		Assert.assertEquals(title, driver.getTitle());
	}

	@When("User clicks on BuyNow button")
	public void user_clicks_on_buy_now_button() {
		
		hp.clickbtnBuyNow();
	}

	@Then("User verifies Shopping Cart panel page")
	public void user_verifies_shopping_cart_panel_page() {
		
	}

	@When("User clicks on checkout button")
	public void user_clicks_on_checkout_button() {
		hp.clickbtnCheckOut();
	}

	@Then("User verifies popup page title as {string}")
	public void user_verifies_popup_page_title_as(String title) {
		os.verifyPageTitle(title);
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		os.clickbtnContinue();
	}

	@When("User clicks on payment method as {string}")
	public void user_clicks_on_payment_method_as(String paymentType) {
		sp.clicklinkPaymentMethod(paymentType);
	}

	@When("User enters card details {string} and {string} and {string} and {string}")
	public void user_enters_card_details_and_and_and(String cardnumber, String expiryMonth, String expiryYear, String cvv) {
		os.setCarddetails(cardnumber, expiryMonth+"/"+expiryYear, cvv);
	}

	@When("User clicks on PayNow button")
	public void user_clicks_on_pay_now_button() {
		os.clickbtnPayNow();
	}
	
	@Then("User verifies pop password textbox")
	public void user_verifies_pop_password_textbox() throws InterruptedException {
		os.verifyOTPpage();
	}

	@When("User enters password details {string} and clicks ok button")
	public void user_enters_password_details_and_clicks_ok_button(String otp) {
		os.setOTP(otp);
	}

	@Then("User verfies transaction successfull message")
	public void user_verfies_transaction_successfull_message() throws InterruptedException {
		Assert.assertTrue(hp.isTransactionSuccess());
	}
	
	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
