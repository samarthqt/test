describe('Customer Profile Management', () => {
  const customerData = {
    name: 'John Doe',
    email: 'johndoe@example.com',
    phone: '123-456-7890',
    address: '123 Main St, City, State, ZIP',
    orderId: '12345'
  };

  beforeEach(() => {
    cy.loginAsAdmin();
  });

  afterEach(() => {
    cy.logout();
  });

  it('should create, update, and delete a customer profile', () => {
    const customerManagementPage = new CustomerManagementPage();
    customerManagementPage.navigate();
    customerManagementPage.createNewProfile(customerData);
    customerManagementPage.verifyProfileCreation(customerData);

    customerManagementPage.editProfile(customerData.email);
    customerManagementPage.updatePreferencesAndHistory({ preferences: 'New Preferences', orderHistory: 'Updated Order History' });
    customerManagementPage.verifyProfileUpdate(customerData.email);

    customerManagementPage.deleteProfile(customerData.email);
    customerManagementPage.verifyProfileDeletion(customerData.email);
  });

  it('should repeat the process with different customer details', () => {
    const newCustomerData = {
      name: 'Jane Smith',
      email: 'janesmith@example.com',
      phone: '987-654-3210',
      address: '456 Elm St, City, State, ZIP',
      orderId: '54321'
    };

    const customerManagementPage = new CustomerManagementPage();
    customerManagementPage.navigate();
    customerManagementPage.createNewProfile(newCustomerData);
    customerManagementPage.verifyProfileCreation(newCustomerData);

    customerManagementPage.editProfile(newCustomerData.email);
    customerManagementPage.updatePreferencesAndHistory({ preferences: 'Updated Preferences', orderHistory: 'New Order History' });
    customerManagementPage.verifyProfileUpdate(newCustomerData.email);
  });
});