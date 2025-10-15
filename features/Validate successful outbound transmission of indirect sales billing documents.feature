Feature: Validate successful outbound transmission of indirect sales billing documents
  Ensure the system successfully transmits indirect sales billing documents to Model N with all required fields. The system is configured with new document types (ZF2, S1, ZG2C, ZL2C) in ZOTC_CROSSREFTAB.

  @TC-15
  Scenario Outline: Validate indirect sales billing document creation and transmission
    Given the user logs in to SAP S/4HANA with authorized credentials
    And the user navigates to transaction ZOTC_INDSALES_MDLNE
    When the user enters valid data including Indirect Sale Type "<IndirectSaleType>", Product Number "<ProductNumber>", Quantity "<Quantity>", Amount "<Amount>", and Invoice Number "<InvoiceNumber>"
    And the user saves the indirect sales billing document
    And the user triggers the outbound interface to send the billing document to Model N
    Then the outbound transmission logs indicate successful transmission of the indirect sales billing document
    And Model N receives the billing document with all required fields
    And the entries in ZOTC_CROSSREFTAB confirm that new document types are updated correctly
    And the linkage between the billing document and Model N is validated successfully
    And no errors are logged in the error logs
    And the report of transmitted billing documents includes the tested document
    And the financial calculations in Model N based on the transmitted data, including rebates and administrative fees, are accurate

    Examples:
      | IndirectSaleType | ProductNumber | Quantity | Amount | InvoiceNumber |
      | IST123           | P67890        | 50       | 2500   | INV67890      |