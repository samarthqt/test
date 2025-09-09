Feature: Shopping cart persistence for guest users with browser cookies enabled
@TC-9
Scenario: Verify shopping cart items persist for guest users with browser cookies enabled
Given the user opens the web application in Firefox browser
And the user is browsing as a guest
And browser cookies are enabled
When the user navigates to the 'Electronics' category
And the user selects 'Wireless Headphones' product and adds it to the cart
And the user continues browsing in the 'Electronics' category
And the user selects 'Bluetooth Speaker' product and adds it to the cart
Then the user views the shopping cart
And both 'Wireless Headphones' and 'Bluetooth Speaker' are displayed in the cart with correct quantities
When the user closes the browser tab without clearing cookies
And the user opens a new browser tab and navigates to the web application
Then the user is still browsing as a guest
And the user views the shopping cart
And both 'Wireless Headphones' and 'Bluetooth Speaker' are displayed in the cart with correct quantities
And the cart subtotal shows $149.98