Feature: Verify Product Details Visibility on Desktop and Mobile Platforms
@TC-140
Scenario: Verify product details visibility on desktop platform
Given the retail application is open on a desktop browser
When I navigate to the product catalog section
Then the product catalog is displayed on the desktop screen
When I select a product from the catalog
Then the product details page is displayed with product information
And product name, description, price, and image are visible and correctly displayed on the desktop
@TC-140
Scenario: Verify product details visibility on mobile platform
Given the retail application is open on a mobile browser
When I navigate to the product catalog section on mobile
Then the product catalog is displayed on the mobile screen
When I select the same product from the catalog on mobile
Then the product details page is displayed with product information on mobile
And product name, description, price, and image are visible and correctly displayed on the mobile
@TC-140
Scenario: Check for discrepancies between desktop and mobile product detail displays
Given the product details are visible on both desktop and mobile platforms
Then there are no discrepancies; product details are consistent across platforms
@TC-140
Scenario: Test responsiveness of product details page on mobile
Given the product details page is displayed on mobile
When I rotate the mobile device
Then the product details page adjusts correctly to landscape and portrait orientations
@TC-140
Scenario: Check loading time of product details page on both platforms
Given the product details page is displayed on both desktop and mobile
Then the product details page loads within acceptable time limits on both platforms
@TC-140
Scenario: Verify functionality of interactive elements on both platforms
Given the product details page is displayed on both desktop and mobile
When I click on the 'Add to Cart' button
Then the 'Add to Cart' button functions correctly on both platforms
@TC-140
Scenario: Ensure product image displays correctly on both platforms
Given the product details page is displayed on both desktop and mobile
Then the product image displays correctly without distortion on both desktop and mobile
@TC-140
Scenario: Check for error messages or broken links on product details page
Given the product details page is displayed on both desktop and mobile
Then no error messages or broken links are present on the product details page
@TC-140
Scenario: Confirm product details sharing via social media links
Given the product details page is displayed on both desktop and mobile
When I share product details via social media links
Then product details can be shared successfully via social media links on both desktop and mobile