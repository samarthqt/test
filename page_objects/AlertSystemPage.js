import { Selector } from 'testcafe';
export default class AlertSystemPage {
  constructor() {
    this.usernameInput = Selector('#username');
    this.passwordInput = Selector('#password');
    this.loginButton = Selector('#loginButton');
    this.dashboard = Selector('#dashboard');
    this.ordersTable = Selector('#ordersTable').find('tr');
    this.subscriptionStatus = Selector('#subscriptionStatus');
    this.ordersModule = Selector('#ordersModule');
    this.ordersList = Selector('#ordersList');
    this.orderDetails = Selector('#orderDetails');
    this.shipmentStatus = Selector('#shipmentStatus');
    this.updateStatusButton = Selector('#updateStatusButton');
    this.statusDropdown = Selector('#statusDropdown');
    this.confirmUpdate = Selector('#confirmUpdate');
    this.shipmentStatusUpdated = Selector('#shipmentStatusUpdated');
    this.alertMonitor = Selector('#alertMonitor');
    this.alertLogs = Selector('#alertLogs');
    this.performanceMetrics = Selector('#performanceMetrics');
    this.performanceStatus = Selector('#performanceStatus');
  }

  async login(t, username, password) {
    await t
      .typeText(this.usernameInput, username)
      .typeText(this.passwordInput, password)
      .click(this.loginButton);
  }

  async verifyDashboard(t) {
    await t.expect(this.dashboard.visible).ok();
  }

  async verifyShipmentOrdersExist(t) {
    await t.expect(this.ordersTable.count).gt(50);
  }

  async verifyCustomerSubscription(t) {
    await t.expect(this.subscriptionStatus.innerText).contains('Subscribed');
  }

  async navigateToOrdersModule(t) {
    await t.click(this.ordersModule);
  }

  async verifyOrdersModuleDisplayed(t) {
    await t.expect(this.ordersList.visible).ok();
  }

  async selectOrdersByIdRange(t, startId, endId) {
    for (let id = startId; id <= endId; id++) {
      await t.click(Selector(`#order-${id}`));
    }
  }

  async verifyOrderDetailsDisplayed(t) {
    await t.expect(this.orderDetails.visible).ok();
  }

  async verifyShipmentStatus(t, status) {
    await t.expect(this.shipmentStatus.innerText).contains(status);
  }

  async updateShipmentStatus(t, status) {
    await t
      .click(this.updateStatusButton)
      .click(this.statusDropdown)
      .click(Selector('option').withText(status))
      .click(this.confirmUpdate);
  }

  async verifyShipmentStatusUpdated(t, status) {
    await t.expect(this.shipmentStatusUpdated.innerText).contains(status);
  }

  async monitorAlertSystem(t) {
    await t.expect(this.alertMonitor.visible).ok();
  }

  async verifyAlertsSent(t, email) {
    await t.expect(this.alertLogs.innerText).contains(email);
  }

  async verifyPerformanceMetrics(t) {
    await t.expect(this.performanceMetrics.visible).ok();
  }

  async verifyOptimalPerformance(t) {
    await t.expect(this.performanceStatus.innerText).contains('Optimal');
  }
}