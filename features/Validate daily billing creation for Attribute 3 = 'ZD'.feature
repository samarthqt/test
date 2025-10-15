Feature: Validate daily billing creation for Attribute 3 = 'ZD'

  @TC-435
  Scenario: User logs into SAP S/4HANA Cloud system successfully
    Given user has appropriate credentials to access the SAP S/4HANA Cloud system
    When user logs into the system
    Then user is successfully logged into the SAP system
    And the billing due program is active and accessible

  @TC-435
  Scenario: User navigates to the billing due program
    Given user is logged into the SAP system
    When user navigates to the billing due program using the transaction code for billing
    Then the billing due program interface is displayed

  @TC-435
  Scenario Outline: Validate Attribute 3 configuration for Ship-to BP
    Given user is on the billing due program interface
    When user verifies the configuration of Attribute 3 for Ship-to BP ID <ShipToBPID>
    Then the Attribute 3 value is confirmed to be <AttributeValue> for the specified Ship-to BP

    Examples:
      | ShipToBPID | AttributeValue |
      | 10001      | ZD             |

  @TC-435
  Scenario: User executes the billing due program in background mode
    Given user is on the billing due program interface
    When user selects the option to execute the billing due program in background mode
    Then the background execution option is selected successfully

  @TC-435
  Scenario: User starts the billing due program execution
    Given user has selected background execution
    When user starts the billing due program execution
    Then the billing due program starts executing in the background

  @TC-435
  Scenario: Monitor job execution status in the job log
    Given user has started the billing due program execution
    When user monitors the job execution status in the job log
    Then the job execution status is 'Completed' without errors

  @TC-435
  Scenario: Access generated billing documents in the billing document overview
    Given the job execution status is 'Completed' without errors
    When user accesses the billing document overview
    Then the billing documents are displayed in the billing document overview

  @TC-435
  Scenario Outline: Verify generated billing documents include orders with Attribute 3 = 'ZD'
    Given the billing documents are displayed in the billing document overview
    When user verifies the inclusion of orders with Attribute 3 = <AttributeValue>
    Then all orders with Attribute 3 = <AttributeValue> are included in the billing documents

    Examples:
      | AttributeValue |
      | ZD             |

  @TC-435
  Scenario: Check the status of orders processed in the billing batch
    Given orders with Attribute 3 = 'ZD' are included in the billing documents
    When user checks the status of orders processed in the billing batch
    Then orders processed in the billing batch have a status of 'Billed'

  @TC-435
  Scenario Outline: Validate exclusion of orders with Attribute 3 not equal to 'ZD'
    Given the billing batch has been processed
    When user validates the exclusion of orders with Attribute 3 not equal to <AttributeValue>
    Then orders with Attribute 3 not equal to <AttributeValue> are excluded as expected

    Examples:
      | AttributeValue |
      | ZD             |

  @TC-435
  Scenario: Verify billing documents are posted to accounting
    Given the billing documents are generated
    When user verifies the posting of billing documents to accounting
    Then billing documents are successfully posted to accounting without errors

  @TC-435
  Scenario: Check system logs for errors or warnings during billing process
    Given the billing process is completed
    When user checks the system logs for errors or warnings
    Then system logs confirm error-free execution of the billing process