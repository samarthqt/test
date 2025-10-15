Feature: Verify error handling when RV60C901 is not assigned  

  @TC-215  
  Scenario: Validate system behavior when RV60C901 is missing in copy-control mappings  
    Given the user logs into SAP S/4HANA Cloud with valid credentials  
    And the user navigates to the Billing Document creation screen  
    And the user enters Sales Order ID "SO54321" in the relevant field  
    When the user attempts to execute the Sales Order to Billing Document copy process  
    Then the system displays an error indicating RV60C901 is missing  
    And the system logs confirm that RV60C901 was not assigned, causing errors  
    And no Billing Document is generated due to the error  
    And the system complies with error handling protocols and provides clear messages  
    And the Sales Order remains unchanged and retains its original status  
    And no financial postings are created due to the error  
    And the system identifies the missing RV60C901 assignment as the root cause  
    And corrective actions, such as assigning RV60C901, are highlighted