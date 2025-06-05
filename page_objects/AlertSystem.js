import { Selector } from 'testcafe';

class AlertSystem {
  constructor() {
    this.alertSystemButton = Selector('#alertSystem');
    this.outgoingAlerts = Selector('#outgoingAlerts');
    this.customerAlerts = Selector('#customerAlerts');
    this.alertMessageInput = Selector('#alertMessage');
    this.sendAlertButton = Selector('#sendAlert');
  }

  async openAlertSystem() {
    await t.click(this.alertSystemButton);
  }

  async checkOutgoingAlerts(email) {
    await this.openAlertSystem();
    await t.expect(this.outgoingAlerts.innerText).contains(email);
  }

  async verifyAlertSent(email, message) {
    await this.openAlertSystem();
    await t.expect(this.outgoingAlerts.innerText).contains(email);
    await t.expect(this.outgoingAlerts.innerText).contains(message);
  }

  async verifyCustomerAlertReceived(email) {
    await t.expect(this.customerAlerts.innerText).contains(email);
  }

  async sendAlert(email, message) {
    await this.openAlertSystem();
    await t.typeText(this.alertMessageInput, message);
    await t.click(this.sendAlertButton);
    await this.verifyAlertSent(email, message);
  }
}

export default AlertSystem;