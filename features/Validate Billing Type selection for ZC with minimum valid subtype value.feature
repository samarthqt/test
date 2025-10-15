Feature: Validate Billing Type selection for ZC with minimum valid subtype value  
  Ensure the system handles the minimum valid subtype value for ZC scenarios and generates the correct billing document.  

  @TC-162  
  Scenario Outline: Validate the billing due program for ZC with minimum valid subtype value  
    Given the user is logged into the SAP S/4HANA Cloud system with appropriate credentials  
    And Attribute 1 is set to "<attribute_1>"  
    And Attribute 2 is correctly configured as "<attribute_2>"  
    When the user navigates to the billing due program  
    Then the billing due program screen is displayed and is active  
    When the user enters Attribute 1 as "<attribute_1>" in the relevant field  
    Then Attribute 1 is accepted as "<attribute_1>"  
    When the user enters the minimum valid value "<subtype>" for Subtype in the respective field  
    Then the minimum valid subtype value "<subtype>" is accepted  
    When the user populates Attribute 2 with "<attribute_2>"  
    Then Attribute 2 is populated successfully  
    When the user executes the billing due program  
    Then the billing due program executes without errors  
    When the user verifies the generated billing document in the system  
    Then a billing document of the correct type is generated  
    When the user checks the document details for proper mapping of Attribute 1 "<attribute_1>" and minimum valid subtype value "<subtype>"  
    Then the document details match the expected mapping  
    When the user verifies the document flow for correct linkage  
    Then the document flow shows proper linkage and no errors  
    When the user validates the financial postings associated with the billing document  
    Then the financial postings are accurate and reflect the correct billing type  
    When the user checks the system logs for any warnings or errors during the process  
    Then no warnings or errors are logged  
    When the user ensures the billing document is ready for further processing or transmission  
    Then the billing document is marked as ready for further processing  

    Examples:  
      | attribute_1 | attribute_2 | subtype |  
      | ZC          | Valid data  | Minimum valid value |