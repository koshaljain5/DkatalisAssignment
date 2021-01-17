Feature: PurchasePillow

@WebScenario
Scenario Outline: Test end to end checkout flow for purchasing Pillow using Credit Card as payment method
Given User Launches "chrome" browser
When Navigate to URL "https://demo.midtrans.com/"
Then Verify home page title as "Sample Store" and BuyNow button
When User clicks on BuyNow button
Then User verifies Shopping Cart panel page
When User clicks on checkout button
Then User verifies popup page title as "Order Summary"
When User clicks on Continue button
Then User verifies popup page title as "Select Payment"
When User clicks on payment method as "Credit/Debit Card"
Then User verifies popup page title as "Credit/Debit Card"
When User enters card details "<cardnumber>" and "<expiryMonth>" and "<expiryYear>" and "<cvv>"
And User clicks on PayNow button
Then User verifies pop password textbox
When User enters password details "<otp>" and clicks ok button
Then User verfies transaction successfull message
And close the browser

Examples:
| cardnumber | expiryMonth | expiryYear | cvv | otp |
| 4811111111111114 | 12 | 24 | 123 | 112233 |
| 4911111111111113 | 02 | 20 | 123 | 112233 |





