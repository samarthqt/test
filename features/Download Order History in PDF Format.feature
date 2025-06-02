Feature: Download Order History in PDF Format
Verify that users can download their order history in PDF format.
@TC-192
Scenario: User logs in to their account
Given the user has valid credentials
When the user logs in to their account
Then the user is successfully logged in and redirected to the dashboard
@TC-192
Scenario: Navigate to Order History section
Given the user is logged in
When the user navigates to the 'Order History' section
Then the order history page is displayed with a list of past orders
@TC-192
Scenario: Select orders for PDF download
Given the user is on the order history page
When the user selects orders to be included in the PDF download
Then the selected orders are highlighted and ready for download
@TC-192
Scenario: Download PDF of order history
Given the user has selected orders for download
When the user clicks on the 'Download PDF' button
Then a prompt appears asking for confirmation to download the selected orders in PDF format
@TC-192
Scenario: Confirm PDF download action
Given the user is prompted to confirm the download
When the user confirms the download action
Then the PDF file containing the order history is generated and downloaded successfully
@TC-192
Scenario: Open downloaded PDF file
Given the PDF file is downloaded
When the user opens the downloaded PDF file
Then the PDF file opens correctly, displaying the selected order history
@TC-192
Scenario: Verify contents of PDF for accuracy
Given the PDF file is opened
When the user views the contents of the PDF
Then the PDF contains accurate details of the selected orders including order ID, date, items, and total amount
@TC-192
Scenario: Check format and readability of PDF
Given the PDF file is opened
When the user checks the format and readability
Then the PDF is well-formatted, readable, and free of any layout issues
@TC-192
Scenario: Attempt repeated PDF download
Given the user has downloaded the PDF
When the user attempts to download the PDF again
Then the system allows repeated downloads without errors
@TC-192
Scenario: Download PDF with different selection of orders
Given the user is on the order history page
When the user selects different orders for PDF download
Then the PDF download functionality works correctly for different selections
@TC-192
Scenario: Check file size and download speed
Given the PDF file is downloaded
When the user checks the file size and download speed
Then the file size is reasonable and the download completes in a timely manner
@TC-192
Scenario: Ensure downloaded file is saved in correct directory
Given the PDF file is downloaded
When the user checks the file location
Then the PDF file is saved in the user's designated download folder
@TC-192
Scenario: Prevent PDF download when logged out
Given the user is logged out
When the user attempts to download the PDF
Then the system prevents download attempts when the user is not logged in
@TC-192
Scenario: Check for error messages during download
Given the user is downloading the PDF
When the download process is underway
Then no error messages are displayed, indicating a smooth download process
@TC-192
Scenario: Verify download functionality on different browsers
Given the user is logged in on different browsers
When the user attempts to download the PDF
Then PDF download works consistently across different web browsers