import { checkEmail } from '../support/emailHelper'
class AlertSystem {
  verifyAlertIsSent(email, message) {
    cy.get('#alertLog').should('contain.text', `Alert sent to ${email}`).and('contain.text', message);
  }
  verifyCustomerReceivedAlert(email, message) {
    cy.get('#customerAlerts').should('contain.text', `Received by ${email}: ${message}`);
    cy.task('checkEmail', { email, message }).then(result => {
      expect(result).to.be.true;
    });
  }
  verifyNoAlertSent(email) {
    cy.get('#alertLog').should('not.contain.text', email);
  }
}
export default AlertSystem;