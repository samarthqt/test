Feature: Personalized Content Display
Scenario: Display personalized banners based on user behavior
Given a user is logged into the retail platform
And the user has a browsing history of electronic products
When the user visits the homepage
Then the user should see personalized banners related to electronic products
Scenario: Display personalized promotions based on user behavior
Given a user is logged into the retail platform
And the user has previously purchased clothing items
When the user visits the promotions page
Then the user should see personalized promotions related to clothing items
Scenario: Display personalized content for new users
Given a user is logged into the retail platform for the first time
When the user visits any page on the platform
Then the user should see general promotional banners and content
Scenario: Update personalized content based on recent user activity
Given a user is logged into the retail platform
And the user recently added kitchen appliances to their cart
When the user visits the homepage
Then the user should see updated personalized banners related to kitchen appliances
Scenario: No personalized content for users with no activity
Given a user is logged into the retail platform
And the user has no browsing or purchase history
When the user visits the homepage
Then the user should see default promotional content
Scenario: Personalized content enhances user engagement
Given a user is logged into the retail platform
And the user interacts with personalized content such as clicking on a banner
When the user navigates through the platform
Then the user should experience enhanced engagement with relevant content and promotions