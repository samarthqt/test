Feature: Validate error handling for null KATR1/KATR2 values during the Sales Order to Billing Document copy process

  @TC-550
  Scenario Outline: Validate system behavior for KATR1 and KATR2 values during the Sales Order to Billing Document copy process
    Given the user is logged into the SAP S/4HANA system
    And the user navigates to the Sales Order to Billing Document copy process
    And the Sales Order ID "<SalesOrderID>" is entered in the input field
    And the system retrieves the Sales Order details with KATR1 as "<KATR1>" and KATR2 as "<KATR2>"
    When the user initiates the copy process to create a Billing Document
    Then the system "<Outcome>"
    And the system displays "<ErrorMessage>"
    And the system log contains "<LogDetails>"
    And no Billing Document is created
    And data integrity is maintained in all related tables

    Examples:
      | SalesOrderID | KATR1 | KATR2 | Outcome                                  | ErrorMessage                          | LogDetails                     |
      | SO12346      | null  | null  | prevents the copy process from proceeding | KATR1 and KATR2 values cannot be null | Details about null value error |

  @TC-550
  Scenario Outline: Validate successful copy process after correcting KATR1 and KATR2 values
    Given the user is logged into the SAP S/4HANA system
    And the user navigates to the Sales Order to Billing Document copy process
    And the Sales Order ID "<SalesOrderID>" is entered in the input field
    And the user corrects the Sales Order by entering valid KATR1 as "<KATR1>" and KATR2 as "<KATR2>"
    When the user re-initiates the copy process with the corrected Sales Order
    Then the copy process proceeds successfully
    And a Billing Document is created

    Examples:
      | SalesOrderID | KATR1 | KATR2 |
      | SO12346      | ABC   | XYZ   |

  @TC-550
  Scenario: Validate user logout process
    Given the user is logged into the SAP S/4HANA system
    When the user logs out of the SAP S/4HANA system
    Then the user is logged out successfully