Feature: High-Resolution Image Display for Product Page

  @TC-11 @TC-57
  Scenario: User views high-resolution image on product detail page
    Given the user navigates to the 'Camera B' product detail page
    Then the product detail page is displayed
    When the user selects the product image to view in high resolution
    Then the high-resolution image is displayed and can be zoomed in

  @TC-11 @TC-9 @TC-10
  Scenario: Initiate Live Chat from Product Page
    Given the user is logged into the retail application
    When the user navigates to a product page
    Then the product page is displayed to the user
    When the user locates the 'Live Chat' button or link
    Then the 'Live Chat' button or link is visible on the product page
    When the user clicks on the 'Live Chat' button
    Then the live chat window opens, and the user is prompted to start a conversation
    When the user enters a sample message in the chat window
    Then the message is displayed in the chat window
    When the user sends the message
    Then the message is sent, and a response is received from a live agent within 30 seconds

  @TC-11 @TC-10
  Scenario: Live Chat Agent Unavailability
    Given the user is logged into the retail application
    When the user navigates to any page with 'Live Chat' functionality
    Then the page with 'Live Chat' functionality is displayed
    When the user clicks on the 'Live Chat' button
    Then the live chat window opens
    When the user attempts to start a conversation when no agents are available
    Then an automated message informs the user that no agents are available, offering options to leave a message or providing estimated wait times

  @TC-11
  Scenario: Delayed Agent Response in Live Chat
    Given the user is logged into the retail application
    When the user navigates to any page with 'Live Chat' functionality
    Then the page with 'Live Chat' functionality is displayed
    When the user clicks on the 'Live Chat' button
    Then the live chat window opens
    When the user enters a sample message and sends it
    Then the message is sent, and no response is received within 30 seconds
    When the user observes the system behavior after 30 seconds
    Then the system provides a notification or message indicating the delay and possible options for the user