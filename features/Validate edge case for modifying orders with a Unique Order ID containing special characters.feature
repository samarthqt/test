Feature: Validate edge case for modifying orders with a Unique Order ID containing special characters  
  Ensure the system can handle and save changes for orders with a Unique Order ID containing special characters.  
  System must allow changes only for existing orders with a 36-character Unique Order ID.  

  @TC-344
  Scenario Outline: Validate order modification with a 36-character Unique Order ID containing special characters  
    Given the user is logged into the SAP S/4HANA system using valid credentials  
    And the user navigates to the Sales Order processing screen  
    When the user searches for an order using the Unique Order ID "<UniqueOrderID>"  
    Then the order details corresponding to the Unique Order ID are displayed  
    When the user modifies the order details with "<UpdatedDetails>"  
    And the user saves the changes  
    Then the changes are saved successfully, and a confirmation message is displayed  
    When the user verifies the changes in the order details screen  
    Then the updated details are displayed correctly  
    When the user checks the order history  
    Then the order history shows the modification details with a timestamp  
    When the user validates the system logs for any errors or warnings during the update process  
    Then no errors or warnings are logged  
    When the user generates an order confirmation document  
    Then the order confirmation document reflects the updated details  

    Examples:  
      | UniqueOrderID                                 | UpdatedDetails                |  
      | 1234-5678-9012-3456-7890-1234-5678-9012       | Quantity: 10, Delivery Date: 2023-12-01 |  
      | 5678-1234-9012-3456-7890-5678-1234-9012       | Quantity: 20, Delivery Date: 2023-12-15 |  
      | 9012-3456-7890-1234-5678-9012-3456-7890       | Quantity: 30, Delivery Date: 2023-12-20 |  
      | 1234-5678-9012-3456-7890-1234-5678-9012       | Quantity: 50, Delivery Date: 2023-12-25 |  

  @TC-344
  Scenario: Log out of the SAP S/4HANA system  
    Given the user is logged into the SAP S/4HANA system  
    When the user logs out of the system  
    Then the user is logged out successfully