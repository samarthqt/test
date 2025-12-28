Feature: Verify periodic billing document generation with ZPB1 form  
  Ensure that periodic billing documents of type ZPB are generated and associated with the ZPB1 form template.  

  @TC-420  
  Scenario: Verify the Billing application is displayed successfully  
    Given the user logs in to the SAP S/4HANA Cloud system  
    When the user navigates to the Billing application  
    Then the Billing application is displayed successfully  

  @TC-420  
  Scenario Outline: Create and validate a periodic billing document of type ZPB  
    Given the user navigates to the Billing application  
    When the user creates a new periodic billing document of type "<Billing Document Type>"  
    And the user populates the periodic billing document with test data "<Field1>", "<Field2>", "<Field3>"  
    And the user saves the periodic billing document  
    And the user assigns the "<Form Template>" form template to the periodic billing document  
    Then the "<Form Template>" form template is correctly associated with the billing document  
    When the user generates the periodic billing document output  
    Then the periodic billing document output is generated successfully  

    Examples:  
      | Billing Document Type | Field1  | Field2  | Field3  | Form Template |  
      | ZPB                  | Test1   | Test2   | Test3   | ZPB1          |  

  @TC-420  
  Scenario: Verify the content of the printed ZPB1 form  
    Given the user has generated the periodic billing document output  
    When the user prints the ZPB1 form  
    Then the ZPB1 form is printed successfully  
    And the content is accurate and formatted correctly  

  @TC-420  
  Scenario: Verify periodic billing fields in the printed form  
    Given the user has printed the ZPB1 form  
    When the user verifies the periodic billing fields in the printed form  
    Then the periodic billing fields are displayed correctly in the printed form  

  @TC-420  
  Scenario: Check for errors or warnings during the process  
    Given the user has completed the periodic billing document process  
    When the user checks for any errors or warnings  
    Then no errors or warnings are encountered during the process  

  @TC-420  
  Scenario: Validate alignment of the printed form with the ZPB1 template structure  
    Given the user has printed the ZPB1 form  
    When the user validates the alignment of the printed form with the ZPB1 template structure  
    Then the printed form aligns with the ZPB1 template structure  

  @TC-420  
  Scenario: Save the generated periodic billing document for future reference  
    Given the user has generated the periodic billing document  
    When the user saves the generated periodic billing document for future reference  
    Then the periodic billing document is saved successfully for future reference