describe('Call Center Support During Off-Hours', () => {
  const callCenterPage = new CallCenterPage();

  before(() => {
    cy.visit('/');
  });

  it('should inform users when contacting support outside business hours', () => {
    cy.clock(new Date(2023, 10, 1, 3, 0).getTime()); // Setting current time to 03:00 AM
    callCenterPage.dialSupportLine('+0987654321');
    callCenterPage.verifyAutomatedMessage('The support line is currently closed. Our hours of operation are 9 AM to 5 PM.');
  });
});