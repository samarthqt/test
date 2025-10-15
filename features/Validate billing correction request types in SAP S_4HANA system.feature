Feature: Validate billing correction request types in SAP S/4HANA system

  @TC-51
  Scenario Outline: Validate the behavior of the system for billing correction request types
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the user has access to the Finance module
    And original billing documents exist with valid line items
    When the user navigates to the transaction for creating billing correction requests
    And the user enters the billing correction request type as "<RequestType>"
    Then the system "<SystemBehavior>"
    And the system "<AdditionalBehavior>"

    Examples:
      | RequestType | SystemBehavior                                               | AdditionalBehavior                                   |
      | ZINVALID    | displays an error message indicating an invalid request type | prevents linking to an existing billing document    |
      | ZINVALID    | prevents saving the correction request                       | displays an error message                           |
      | ZINVALID    | prevents generation of the corresponding ZG2C billing document | displays an error message                          |
      | ZINVALID    | logs an error indicating an invalid billing correction request type | maintains system performance                       |
      | ZINVALID    | ensures no partial or incomplete documents are created       | ensures no financial postings are made             |
      | ZRK         | accepts the valid request type without errors                | successfully processes the request and generates the corresponding document |

  @TC-51
  Scenario: Verify document flow and system performance during invalid request type handling
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the user has access to the Finance module
    When the user navigates to the transaction for creating billing correction requests
    And the user enters the billing correction request type as "ZINVALID"
    Then the system ensures no partial or incomplete documents are created
    And the system performance remains stable despite the error

  @TC-51
  Scenario: Ensure financial postings are not impacted for invalid billing correction requests
    Given the user is logged into the SAP S/4HANA system with appropriate credentials
    And the user has access to the Finance module
    When the user navigates to the transaction for creating billing correction requests
    And the user enters the billing correction request type as "ZINVALID"
    Then the system ensures no financial postings are made for the failed document creation