Feature: Validate Invoice Correction Request creation with maximum allowable items

  @TC-395
  Scenario Outline: User creates an Invoice Correction Request with maximum allowable items
    Given the user logs into the SAP S/4HANA system with valid credentials
    When the user navigates to the Invoice Correction Request creation screen
    And the user selects an existing sales invoice "<Invoice Number>" with "<Number of Items>" items
    And the user enters correction details "<Correction Details>" for all items
    And the user saves the Invoice Correction Request
    Then the system successfully saves the Invoice Correction Request without errors
    And subsequent invoices "<Subsequent Invoice Type>" are generated correctly for all items
    And the linkage between the correction request and the original billing document is maintained
    And the system logs do not contain any errors or warnings
    And the system performance remains stable and responsive
    And the generated invoices are accurate and consistent with the correction details

    Examples:
      | Invoice Number | Number of Items | Correction Details               | Subsequent Invoice Type |
      | INV67890       | Maximum allowable (e.g., 1000) | Adjust price and quantity for all items | ZG2C (credit), ZL2C (debit) |

  @TC-395
  Scenario: User modifies a saved Invoice Correction Request
    Given the user has successfully created and saved an Invoice Correction Request
    When the user attempts to modify the saved correction request
    Then the system allows modifications to the saved correction request
    And the updated correction request is correctly linked to the original invoice