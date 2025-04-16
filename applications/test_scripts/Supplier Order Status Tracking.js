describe('Supplier Order Status Tracking', () => {
  const supplierManagement = new SupplierManagementPage();

  before(() => {
    cy.login('validUsername', 'validPassword');
  });

  beforeEach(() => {
    cy.visit('/dashboard');
    supplierManagement.navigateToSupplierManagement();
  });

  it('should view order details for Supplier ID SUP123', () => {
    supplierManagement.selectOrderTracking();
    supplierManagement.searchBySupplierID('SUP123');
    supplierManagement.viewOrderDetails('ORD456');
    supplierManagement.verifyOrderStatus('ORD456');
    supplierManagement.verifyExpectedDeliveryDate('ORD456', '2023-11-15');
  });

  it('should filter and view In Transit orders', () => {
    supplierManagement.navigateToOrderTrackingOverview();
    supplierManagement.filterOrdersByStatus('In Transit');
    supplierManagement.viewInTransitOrderDetails();
  });

  it('should export order tracking information', () => {
    supplierManagement.exportOrderTrackingToExcel();
  });

  it('should log out and log in with a different Supplier ID', () => {
    cy.logout();
    cy.login('validUsername', 'validPassword');
    supplierManagement.navigateToSupplierManagement();
    supplierManagement.selectOrderTracking();
    supplierManagement.searchBySupplierID('NEW_SUP_ID'); // Replace with actual ID
    supplierManagement.viewOrderDetails('NEW_ORD_ID'); // Replace with actual ID
  });

  after(() => {
    cy.logout();
  });
});