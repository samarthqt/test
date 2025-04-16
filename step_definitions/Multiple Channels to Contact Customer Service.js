describe('Multiple Channels to Contact Customer Service', () => {
  beforeEach(() => {
    cy.visit('/customer-service');
  });

  it('should display the customer service page or contact information', () => {
    cy.get('.customer-service-page').should('be.visible');
  });

  it('should display phone contact information', () => {
    cy.get('.phone-contact').should('be.visible').and('contain', 'Phone Number').and('contain', 'Working Hours');
  });

  it('should display email contact information', () => {
    cy.get('.email-contact').should('be.visible').and('contain', 'Email Address').and('contain', 'Response Time');
  });

  it('should have a live chat option available', () => {
    cy.get('.live-chat-option').should('be.visible');
  });

  it('should open phone dialer with phone number pre-filled', () => {
    cy.get('.phone-contact').click();
    cy.get('.phone-dialer').should('be.visible').and('contain', 'Phone Number');
  });

  it('should open email client with recipient email address pre-filled', () => {
    cy.get('.email-contact').click();
    cy.get('.email-client').should('be.visible').and('contain', 'Email Address');
  });

  it('should open live chat window', () => {
    cy.get('.live-chat-option').click();
    cy.get('.live-chat-window').should('be.visible');
  });

  it('should send message in live chat and receive response', () => {
    cy.get('.live-chat-window').type('Hello, I need help.');
    cy.get('.send-message-button').click();
    cy.get('.chat-response').should('be.visible').and('contain', 'Response');
  });

  it('should display alternative contact methods if available', () => {
    cy.get('.alternative-contact-methods').should('be.visible');
  });

  it('should mention expected response time for each contact method', () => {
    cy.get('.response-time').should('be.visible');
  });

  it('should mention working hours for each contact method', () => {
    cy.get('.working-hours').should('be.visible');
  });

  it('should be reachable through each available channel', () => {
    cy.get('.contact-channel').each(($channel) => {
      cy.wrap($channel).click();
      cy.get('.channel-response').should('be.visible');
    });
  });

  it('should have contact information easily accessible from any page', () => {
    cy.get('.global-contact-info').should('be.visible');
  });

  it('should display contact information correctly on different devices', () => {
    cy.viewport('iphone-x');
    cy.get('.customer-service-page').should('be.visible');
    cy.viewport('macbook-15');
    cy.get('.customer-service-page').should('be.visible');
  });

  it('should have up to date and accurate contact information', () => {
    cy.get('.contact-info').should('be.visible').and('contain', 'Updated Info');
  });
});