Feature: Validate successful outbound transmission of direct sales billing documents

  @TC-14
  Scenario: User successfully logs into SAP S/4HANA
    Given the user has authorized credentials
    When the user logs into SAP S/4HANA
    Then the user is successfully logged in
    And the Model N interface is active and ready to receive data

  @TC-14
  Scenario: User navigates to transaction ZOTC_SALES_ORDER
    Given the user is logged into SAP S/4HANA
    When the user navigates to transaction ZOTC_SALES_ORDER
    Then the transaction ZOTC_SALES_ORDER is opened
    And test data for direct sales is available

  @TC-14
  Scenario Outline: User enters valid data for direct sales billing document
    Given the user is on the ZOTC_SALES_ORDER transaction
    When the user enters valid data including Product Number "<Product Number>", Ship-to "<Ship-to>", Sold-to "<Sold-to>", Quantity "<Quantity>", Amount "<Amount>", and Invoice Number "<Invoice Number>"
    Then the data is entered without errors

    Examples:
      | Product Number | Ship-to     | Sold-to     | Quantity | Amount | Invoice Number |
      | P12345         | Customer A  | Customer B  | 100      | 5000   | INV12345       |

  @TC-14
  Scenario: User saves the direct sales billing document
    Given the user has entered valid data for the billing document
    When the user saves the direct sales billing document
    Then the billing document is saved successfully

  @TC-14
  Scenario: User triggers the outbound interface to send the billing document
    Given the billing document is saved successfully
    When the user triggers the outbound interface to send the billing document to Model N
    Then the outbound interface is triggered successfully

  @TC-14
  Scenario: User monitors the outbound transmission logs
    Given the outbound interface is triggered successfully
    When the user monitors the outbound transmission logs
    Then the logs indicate successful transmission of the direct sales billing document

  @TC-14
  Scenario: User verifies data reception in Model N
    Given the direct sales billing document is transmitted successfully
    When the user verifies data reception in Model N
    Then Model N receives the billing document with all required fields

  @TC-14
  Scenario: User checks entries in ZOTC_CROSSREFTAB for document type updates
    Given the direct sales billing document is transmitted successfully
    When the user checks the entries in ZOTC_CROSSREFTAB
    Then the entries confirm that new document types are updated correctly

  @TC-14
  Scenario: User validates linkage between the billing document and Model N
    Given the direct sales billing document is received by Model N
    When the user validates the linkage between the billing document and Model N
    Then the linkage is established successfully

  @TC-14
  Scenario: User reviews error logs for any anomalies
    Given the direct sales billing document is transmitted successfully
    When the user reviews error logs
    Then no errors are logged

  @TC-14
  Scenario: User generates a report of transmitted billing documents
    Given the direct sales billing document is transmitted successfully
    When the user generates a report of transmitted billing documents
    Then the report shows all transmitted documents including the tested one

  @TC-14
  Scenario: User confirms financial calculations in Model N
    Given the direct sales billing document is received by Model N
    When the user confirms the financial calculations in Model N based on the transmitted data
    Then Model N calculates rebates and administrative fees accurately