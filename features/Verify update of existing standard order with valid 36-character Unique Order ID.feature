Feature: Verify update of existing standard order with valid 36-character Unique Order ID

  @TC-332
  Scenario Outline: Validate payload processing and updates for an existing standard order
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a payload containing the "<Unique Order ID>" and updated order details "<Item>", "<Quantity>", and "<Price>"
    When the system processes the inbound payload
    Then the user navigates to the updated standard order in S/4HANA using the "<Unique Order ID>"
    And the order details reflect the updates "<Item>", "<Quantity>", and "<Price>"
    And the Sales Area "<Sales Area>" is correctly assigned to the updated order
    And the document flow shows proper linkage and updates
    And no errors or warnings are logged during the update process
    And the order status reflects the changes made
    And the financial tables reflect the updated order details accurately
    And the updated order details are visible in the relevant reports
    And the updates align with business rules and compliance requirements

    Examples:
      | Unique Order ID                           | Item       | Quantity | Price | Sales Area    |
      | 123456789012345678901234567890123456      | Product A  | 10       | 100   | 1022/10/10    |
      | 987654321098765432109876543210987654      | Product B  | 5        | 50    | 1022/10/10    |

  @TC-332
  Scenario: Validate successful processing of inbound payload
    Given the user triggers the inbound interface from Lisbon to S/4HANA with a valid payload containing a 36-character Unique Order ID
    When the system processes the inbound payload
    Then the interface processing logs in S/4HANA indicate successful data processing

  @TC-332
  Scenario: Verify visibility of updated order details
    Given the user navigates to the updated standard order in S/4HANA using the Unique Order ID
    Then the updated order details are visible in the system

  @TC-332
  Scenario: Validate financial impact of order update
    Given the user reviews the relevant financial tables in S/4HANA
    Then the financial tables reflect the updated order details accurately

  @TC-332
  Scenario: Verify updated order details in reports
    Given the user accesses the relevant reports in S/4HANA
    Then the reports display the updated order details correctly

  @TC-332
  Scenario: Perform final review for compliance
    Given the user performs a final review of the updated order
    Then all updates align with business rules and compliance requirements