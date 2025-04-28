Feature: Check Badge Color Consistency Across Different Browsers and Devices
Scenario: Verify badge color consistency across different browsers and devices on the Brand Two PLP
Given I have access to Brand Two PLP
And different browsers and devices are available for testing
When I navigate to the Brand Two PLP using Browser A
Then the Brand Two PLP is displayed on Browser A
When I identify a product with a badge on Browser A
Then a product with a badge is identified on Browser A
When I verify the badge color on Browser A
Then the badge color is correct on Browser A
When I navigate to the Brand Two PLP using Browser B
Then the Brand Two PLP is displayed on Browser B
When I identify a product with a badge on Browser B
Then a product with a badge is identified on Browser B
When I verify the badge color on Browser B
Then the badge color is correct on Browser B
When I navigate to the Brand Two PLP using Device A
Then the Brand Two PLP is displayed on Device A
When I identify a product with a badge on Device A
Then a product with a badge is identified on Device A
When I verify the badge color on Device A
Then the badge color is correct on Device A
When I navigate to the Brand Two PLP using Device B
Then the Brand Two PLP is displayed on Device B
When I identify a product with a badge on Device B
Then a product with a badge is identified on Device B
When I verify the badge color on Device B
Then the badge color is correct on Device B
When I compare badge color consistency between Browser A and Browser B
Then the badge color remains consistent between browsers
When I compare badge color consistency between Device A and Device B
Then the badge color remains consistent between devices
When I inspect the badge color using browser developer tools on each browser
Then the badge color CSS property is consistent across browsers