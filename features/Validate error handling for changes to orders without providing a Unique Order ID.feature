Feature: Validate error handling for changes to orders without providing a Unique Order ID

  @TC-342
  Scenario Outline: User attempts to modify an order with or without a Unique Order ID
    Given the user is logged into the SAP S/4HANA system using valid credentials
    When the user navigates to the Sales Order processing screen
    And the user attempts to modify an order with "<Unique Order ID>"
    Then the system "<System Response>"
    And the user checks the system logs for any errors or warnings
    And the logs "<Log Response>"
    When the user attempts to save the changes
    Then the system "<Save Response>"
    And the user logs out of the system
    Then the user is logged out successfully

    Examples:
      | Unique Order ID                           | System Response                                      | Log Response                                      | Save Response                                    |
      |                                           | displays an error message indicating a Unique Order ID is required | indicate the missing Unique Order ID error       | prevents saving and displays an error message    |
      | 123                                       | displays an error message indicating invalid Unique Order ID      | indicate the invalid Unique Order ID error       | prevents saving and displays an error message    |
      | abcdefghijklmnopqrstuvwxyz1234567890abcd | allows the user to modify the order                 | show no errors                                   | allows saving and confirms the changes           |