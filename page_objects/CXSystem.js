import { Selector } from 'testcafe';

class page_objects/CXSystem {
  constructor() {
    this.cxSystemContainer = Selector('.cx-system');
    this.orderIdInput = Selector('#order-id');
    this.submitButton = Selector('button[type=\submit\]');
    this.successMessage = Selector('.success-message');
    this.errorMessage = Selector('.error-message');
  }

  async checkCXSystem(orderId) {
    await t
      .typeText(this.orderIdInput, orderId)
      .click(this.submitButton)
      .expect(this.cxSystemContainer.innerText).contains(orderId);
  }

  async verifySuccessMessage(expectedMessage) {
    await t.expect(this.successMessage.innerText).eql(expectedMessage);
  }

  async verifyErrorMessage(expectedMessage) {
    await t.expect(this.errorMessage.innerText).eql(expectedMessage);
  }

  async submitOrderId(orderId) {
    await t
      .typeText(this.orderIdInput, orderId)
      .click(this.submitButton);
  }

  async isOrderIdDisplayed(orderId) {
    return this.cxSystemContainer.withText(orderId).exists;
  }
}

export default page_objects/CXSystem;