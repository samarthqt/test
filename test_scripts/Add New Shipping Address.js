describe('Add New Shipping Address', () => {
    const accountSettingsPage = new AccountSettingsPage();
    const manageAddressesPage = new ManageAddressesPage();

    beforeEach(() => {
        cy.login(); // Assume a custom command for login
        accountSettingsPage.navigate();
    });

    it('should add a new shipping address successfully', () => {
        accountSettingsPage.clickManageAddresses();
        manageAddressesPage.clickAddNewAddress();
        manageAddressesPage.enterFullName('John Doe');
        manageAddressesPage.enterStreetAddress('123 Main St');
        manageAddressesPage.enterCity('Springfield');
        manageAddressesPage.selectState('IL');
        manageAddressesPage.enterZipCode('62704');
        manageAddressesPage.selectCountry('USA');
        manageAddressesPage.enterPhoneNumber('555-1234');
        manageAddressesPage.clickSave();
        manageAddressesPage.verifyAddressInList('John Doe', '123 Main St', 'Springfield', 'IL', '62704', 'USA', '555-1234');
    });

    it('should persist the new address after logging out and back in', () => {
        cy.logout();
        cy.login();
        accountSettingsPage.navigate();
        accountSettingsPage.clickManageAddresses();
        manageAddressesPage.verifyAddressInList('John Doe', '123 Main St', 'Springfield', 'IL', '62704', 'USA', '555-1234');
    });

    it('should not allow adding an address with missing required fields', () => {
        accountSettingsPage.clickManageAddresses();
        manageAddressesPage.clickAddNewAddress();
        manageAddressesPage.enterFullName('');
        manageAddressesPage.clickSave();
        manageAddressesPage.verifyMissingFieldError();
    });

    it('should not allow adding a duplicate address', () => {
        accountSettingsPage.clickManageAddresses();
        manageAddressesPage.clickAddNewAddress();
        manageAddressesPage.enterFullName('John Doe');
        manageAddressesPage.enterStreetAddress('123 Main St');
        manageAddressesPage.enterCity('Springfield');
        manageAddressesPage.selectState('IL');
        manageAddressesPage.enterZipCode('62704');
        manageAddressesPage.selectCountry('USA');
        manageAddressesPage.enterPhoneNumber('555-1234');
        manageAddressesPage.clickSave();
        manageAddressesPage.verifyDuplicateAddressError();
    });
});