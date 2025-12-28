Feature: Validate Periodic Billing Order Creation for Last Milestone  
  Ensure the system creates a Periodic Billing order with document type ZPB when the last milestone in a billing plan is marked as 'Achieved'.  

  @TC-413  
  Scenario Outline: User validates the creation of a Periodic Billing order for the last milestone  
    Given the user logs into the SAP S/4HANA Cloud system with valid credentials  
    And the user navigates to the Milestone Management module  
    When the user searches for the billing plan ID "<billing_plan_id>"  
    And the user selects the last milestone in the billing plan  
    And the user marks the last milestone as "<milestone_status>"  
    And the user saves the changes to the milestone  
    Then the system triggers the creation of a Periodic Billing order  
    And the created Periodic Billing order has the document type "<document_type>"  
    And the created order is linked to the last milestone  
    And the created order is available for subsequent billing steps  
    And the system logs contain no errors or warnings during the process  
    And the billing workflow continues seamlessly without interruptions  

    Examples:  
      | billing_plan_id | milestone_status | document_type |  
      | BP1234          | Achieved         | ZPB           |