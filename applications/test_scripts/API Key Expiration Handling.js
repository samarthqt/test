describe('API Key Expiration Handling', () => {
  const expiredApiKey = 'expired_key_123';
  let newApiKey;
  
  it('should fail API call with expired API key', () => {
    cy.request({
      method: 'GET',
      url: '/api/endpoint',
      headers: {
        'Authorization': `Bearer ${expiredApiKey}`
      },
      failOnStatusCode: false
    }).then((response) => {
      expect(response.status).to.equal(401);
      expect(response.body.error).to.include('expired');
    });
  });

  it('should display expired status for API key in developer account', () => {
    cy.visit('/developer/account');
    cy.get('.api-key-status').contains('Expired');
  });

  it('should request a new API key successfully', () => {
    cy.visit('/developer/account');
    cy.get('.request-new-api-key').click();
    cy.get('.notification').should('contain', 'API key request submitted successfully');
  });

  it('should verify new API key is generated and available', () => {
    cy.visit('/developer/account');
    cy.get('.api-key-list').within(() => {
      cy.get('.api-key').last().invoke('text').then((text) => {
        newApiKey = text.trim();
        expect(newApiKey).to.not.equal(expiredApiKey);
      });
    });
  });
});