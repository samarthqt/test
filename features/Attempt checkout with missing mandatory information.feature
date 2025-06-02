Feature: Attempt checkout with missing mandatory information
@TC-270
Scenario: Proceed to checkout without entering shipping address
Given the user has items in the shopping cart
When the user proceeds to checkout without entering the shipping address
Then an error message is displayed indicating missing shipping information
@TC-270
Scenario: Enter incorrect billing address format
Given the user is on the checkout page
When the user enters an incorrect billing address format
Then an error message is displayed indicating incorrect billing address format
@TC-270
Scenario: Leave payment method field empty and attempt checkout
Given the user is on the checkout page
When the user leaves the payment method field empty and attempts checkout
Then an error message is displayed indicating missing payment information
@TC-270
Scenario: Enter invalid credit card number and attempt checkout
Given the user is on the checkout page
When the user enters an invalid credit card number and attempts checkout
Then an error message is displayed indicating invalid credit card number
@TC-270
Scenario: Enter expired credit card details and attempt checkout
Given the user is on the checkout page
When the user enters expired credit card details and attempts checkout
Then an error message is displayed indicating expired credit card details
@TC-270
Scenario: Attempt checkout without agreeing to terms and conditions
Given the user is on the checkout page
When the user attempts checkout without agreeing to terms and conditions
Then an error message is displayed indicating agreement to terms is required
@TC-270
Scenario: Attempt to use a promo code that is expired
Given the user is on the checkout page
When the user attempts to use a promo code that is expired
Then an error message is displayed indicating promo code is expired
@TC-270
Scenario: Attempt checkout with an invalid CVV number
Given the user is on the checkout page
When the user attempts checkout with an invalid CVV number
Then an error message is displayed indicating invalid CVV number
@TC-270
Scenario: Attempt checkout with incorrect zip code for billing address
Given the user is on the checkout page
When the user attempts checkout with incorrect zip code for billing address
Then an error message is displayed indicating incorrect zip code
@TC-270
Scenario: Attempt checkout with incorrect cardholder name
Given the user is on the checkout page
When the user attempts checkout with incorrect cardholder name
Then an error message is displayed indicating incorrect cardholder name
@TC-270
Scenario: Attempt checkout with incorrect expiration date
Given the user is on the checkout page
When the user attempts checkout with incorrect expiration date
Then an error message is displayed indicating incorrect expiration date
@TC-270
Scenario: Attempt checkout with incorrect shipping address format
Given the user is on the checkout page
When the user attempts checkout with incorrect shipping address format
Then an error message is displayed indicating incorrect shipping address format
@TC-270
Scenario: Attempt checkout with missing phone number for shipping address
Given the user is on the checkout page
When the user attempts checkout with missing phone number for shipping address
Then an error message is displayed indicating missing phone number