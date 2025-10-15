Feature: Validate Billing Type ZI and Ensure Correct Billing Document Generation

  @TC-427
  Scenario: User logs into the SAP S/4HANA Cloud system successfully
    Given the user has appropriate credentials
    When the user logs into the SAP S/4HANA Cloud system
    Then the user is successfully logged into the system

  @TC-427
  Scenario: User navigates to the billing due program
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing due program
    Then the billing due program interface is displayed
    And the billing due program is active and accessible

  @TC-427
  Scenario Outline: Validate Attribute1 and Attribute2 input in the billing due program
    Given the user is on the billing due program interface
    When the user inputs Attribute1 as "<Attribute1>" and populates Attribute2 with "<Attribute2>"
    Then the attributes are entered successfully

    Examples:
      | Attribute1 | Attribute2    |
      | ZI         | Valid Data    |
      | ZI         | Blank         |
      | ZI         | Invalid Data  |

  @TC-427
  Scenario: Execute the billing due program
    Given the user has entered valid attributes in the billing due program
    When the user executes the billing due program
    Then the billing due program executes successfully

  @TC-427
  Scenario: Verify billing document generation of type ZF2
    Given the billing due program has executed successfully
    When the system generates billing documents
    Then the system generates billing documents of type ZF2

  @TC-427
  Scenario: Validate consolidation scope
    Given the billing documents of type ZF2 are generated
    When the user checks the consolidation scope
    Then the consolidation scope is correctly set to "Individual"

  @TC-427
  Scenario: Check document header for accuracy
    Given the billing documents are generated
    When the user reviews the document header
    Then the document header displays the correct billing type and attributes

  @TC-427
  Scenario: Validate content of generated billing documents
    Given the billing documents are generated
    When the user reviews the content of the billing documents
    Then the content aligns with the defined rules and mappings

  @TC-427
  Scenario: Verify system logs for billing document creation
    Given the billing documents are generated
    When the user checks the system logs for the billing document creation process
    Then the logs show successful creation of billing documents without errors

  @TC-427
  Scenario: Check financial posting for billing documents
    Given the billing documents are generated
    When the user reviews the financial posting for the billing documents
    Then the billing documents are posted successfully to the financial module

  @TC-427
  Scenario: Validate status of billing documents in the system
    Given the billing documents are generated
    When the user checks the status of the billing documents in the system
    Then the billing document statuses are updated to "Completed"

  @TC-427
  Scenario: Review billing documents for customer-specific compliance
    Given the billing documents are generated
    When the user reviews the generated billing documents for compliance with customer-specific requirements
    Then the billing documents comply with customer-specific requirements