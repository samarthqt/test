Feature: Validate display and processing restrictions for Sales Organization 1022 and Document Types ZOR/ZORF

  @TC-502
  Scenario: User logs in to the SAP S/4HANA system with valid credentials
    Given the user has valid credentials with appropriate access rights
    When the user logs in to the SAP S/4HANA system
    Then the user is successfully logged into the system

  @TC-502
  Scenario: User navigates to the Sales Order processing screen
    Given the user is logged into the SAP S/4HANA system
    When the user navigates to the Sales Order processing screen
    Then the Sales Order processing screen is displayed

  @TC-502
  Scenario Outline: Upload and process a pipe-delimited file containing sales order data
    Given the inbound interface for customer sales data is active and operational
    When the user uploads a pipe-delimited file containing sales order data
    Then the file is successfully uploaded and data is processed

    Examples:
      | File Content                                |
      | Valid sales order data                     |
      | Invalid sales order data                   |
      | Blank file                                 |
      | File containing multiple organizations and document types |

  @TC-502
  Scenario Outline: Filter sales orders based on Sales Organization and Document Types
    Given the user is on the Sales Order processing screen
    When the user filters sales orders for "<Sales Organization>" and "<Document Types>"
    Then "<Expected Result>" is displayed

    Examples:
      | Sales Organization | Document Types | Expected Result                                       |
      | 1022               | ZOR/ZORF       | Only sales orders for Sales Organization 1022 and Document Types ZOR/ZORF are displayed |
      | Other              | Other types    | No sales orders are displayed                        |

  @TC-502
  Scenario Outline: Attempt to process filtered sales orders
    Given the user has filtered sales orders for "<Sales Organization>" and "<Document Types>"
    When the user attempts to process the displayed sales orders
    Then "<Processing Result>" is achieved

    Examples:
      | Sales Organization | Document Types | Processing Result                                    |
      | 1022               | ZOR/ZORF       | Sales orders are successfully processed             |
      | Other              | Other types    | System prevents processing of sales orders          |

  @TC-502
  Scenario: Validate system logs for processing activities
    Given the user has processed sales orders for Sales Organization 1022 and Document Types ZOR/ZORF
    When the user validates the system logs
    Then the system logs show successful processing of sales orders for Sales Organization 1022 and Document Types ZOR/ZORF only

  @TC-502
  Scenario: Verify user access rights in the system configuration
    Given the user is logged into the SAP S/4HANA system
    When the user verifies user access rights in the system configuration
    Then user access rights are correctly configured to restrict access to Sales Organization 1022 and Document Types ZOR/ZORF

  @TC-502
  Scenario: Check the audit trail for sales order processing
    Given the user has processed sales orders
    When the user checks the audit trail for sales order processing
    Then the audit trail shows no unauthorized access or processing of sales orders for other organizations or document types

  @TC-502
  Scenario Outline: Validate error messages for unauthorized access attempts
    Given the user attempts unauthorized access or processing of sales orders
    When "<Access Attempt>" is made
    Then the system displays "<Error Message>"

    Examples:
      | Access Attempt                         | Error Message                                     |
      | Attempt to access other organizations | Appropriate error message for unauthorized access |
      | Attempt to process other document types | Appropriate error message for unauthorized access |

  @TC-502
  Scenario: Generate a report of processed sales orders for verification
    Given the user has processed sales orders for Sales Organization 1022 and Document Types ZOR/ZORF
    When the user generates a report of processed sales orders
    Then the report shows only sales orders for Sales Organization 1022 and Document Types ZOR/ZORF