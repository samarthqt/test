Feature: Validate system behavior for edge cases with all mandatory fields missing in ZRK correction request

  @TC-98
  Scenario: User logs in to the SAP system
    Given the user has valid credentials
    When the user logs in to the SAP system
    Then the user is successfully logged in

  @TC-98
  Scenario: User navigates to the billing correction form
    Given the user has appropriate permissions to create correction requests
    When the user navigates to the billing correction form
    Then the billing correction form is displayed

  @TC-98
  Scenario: User selects ZRK as the correction request type
    When the user selects "ZRK" as the correction request type
    Then "ZRK" correction request type is selected

  @TC-98
  Scenario Outline: Validate the system's response for mandatory fields in ZRK correction request
    Given the user is on the billing correction form
    When the user enters the following mandatory fields:
      | Customer ID          | Billing Document Number |
      | <CustomerID>         | <BillingDocumentNumber> |
    And the user submits the form
    Then the system responds with "<SystemResponse>"
    And the correction request "<RequestStatus>"

    Examples:
      | CustomerID | BillingDocumentNumber | SystemResponse                                             | RequestStatus           |
      |            |                       | Error messages for all missing mandatory fields displayed  | No correction request created |
      | ValidID    |                       | Error message for missing Billing Document Number displayed| No correction request created |
      |            | ValidNumber           | Error message for missing Customer ID displayed           | No correction request created |
      | ValidID    | ValidNumber           | Success message displayed                                 | Correction request created   |

  @TC-98
  Scenario: User logs out of the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the SAP system
    Then the user is successfully logged out

  @TC-98
  Scenario: User verifies the correction request after logging back in
    Given the user has logged out of the SAP system
    When the user logs back into the SAP system
    Then the correction request is found in the system with accurate details