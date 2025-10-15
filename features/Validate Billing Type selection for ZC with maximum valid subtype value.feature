Feature: Validate Billing Type selection for ZC with maximum valid subtype value  
  Ensure the system handles the maximum valid subtype value for ZC scenarios and generates the correct billing document.  

  @TC-161  
  Scenario: User logs into the SAP S/4HANA Cloud system successfully  
    Given the user has appropriate credentials  
    When the user logs into the SAP S/4HANA Cloud system  
    Then the user is successfully logged in  

  @TC-161  
  Scenario: User navigates to the billing due program  
    Given the user is logged into the SAP S/4HANA Cloud system  
    When the user navigates to the billing due program  
    Then the billing due program screen is displayed  
    And the billing due program is active and accessible  

  @TC-161  
  Scenario Outline: Validate Attribute 1 and Subtype fields in the billing due program  
    Given the user is on the billing due program screen  
    When the user enters Attribute 1 as "<Attribute1>" in the relevant field  
    And the user enters the Subtype field with "<Subtype>"  
    Then the system accepts Attribute 1 as "<Attribute1>"  
    And the system accepts the Subtype field with "<Subtype>"  

    Examples:  
      | Attribute1 | Subtype              |  
      | ZC         | Maximum valid value |  

  @TC-161  
  Scenario Outline: Populate Attribute 2 and execute the billing due program  
    Given the user has entered Attribute 1 as "<Attribute1>" and Subtype as "<Subtype>"  
    When the user populates Attribute 2 with "<Attribute2>"  
    And the user executes the billing due program  
    Then the system accepts Attribute 2 as "<Attribute2>"  
    And the billing due program executes without errors  

    Examples:  
      | Attribute1 | Subtype              | Attribute2 |  
      | ZC         | Maximum valid value | Valid data |  

  @TC-161  
  Scenario: Verify the generated billing document  
    Given the billing due program has been executed successfully  
    When the user verifies the generated billing document in the system  
    Then a billing document of the correct type is generated  

  @TC-161  
  Scenario: Validate the mapping of document details  
    Given a billing document is generated  
    When the user checks the document details for proper mapping of Attribute 1 and Subtype  
    Then the document details match the expected mapping  

  @TC-161  
  Scenario: Verify the document flow for correct linkage  
    Given a billing document is generated  
    When the user verifies the document flow  
    Then the document flow shows proper linkage and no errors  

  @TC-161  
  Scenario: Validate financial postings associated with the billing document  
    Given a billing document is generated  
    When the user validates the financial postings associated with the billing document  
    Then the financial postings are accurate and reflect the correct billing type  

  @TC-161  
  Scenario: Check system logs for warnings or errors  
    Given the billing due program has been executed  
    When the user checks the system logs for any warnings or errors  
    Then no warnings or errors are logged  

  @TC-161  
  Scenario: Ensure the billing document is ready for further processing  
    Given a billing document is generated  
    When the user ensures the billing document is ready for further processing or transmission  
    Then the billing document is marked as ready for further processing