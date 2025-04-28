Feature: Navigate to 'Update Mobile Number' Page via Email Link
Scenario: User is directed to the 'Update Mobile Number' page successfully after clicking the link in an email
Given the user has access to their email account
And the user receives an email with the subject "Update Your Mobile Number" at user@example.com
When the user opens the email client
And the user locates the email in the inbox
And the user opens the email to view its contents
Then the email content is displayed with a link to update the mobile number
When the user clicks on the link provided in the email
Then the browser opens and starts loading the 'Update Mobile Number' page
And the correct URL "https://example.com/update-number" is displayed in the browser's address bar
Then the page title is "Update Mobile Number"
And there is a form to update the mobile number present on the page
And the form fields for entering the new mobile number are available and editable
And there is a 'Submit' button visible and clickable on the form
And instructions or help text related to updating the mobile number is displayed
When the user attempts to navigate away from the page and return using the browser's back button
Then the user is able to return to the 'Update Mobile Number' page without issues
Then the page is responsive on different devices and screen sizes
And no security warnings or certificate issues are present in the browser
And the page loads quickly and efficiently
When the user attempts to refresh the page
Then the page refreshes and reloads without errors
When the user logs out and logs back into the email account
Then the link remains valid and directs to the correct page after logging back in