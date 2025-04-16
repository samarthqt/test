describe('API Rate Limiting', () => {
  const apiPage = new ApiPage();
  const userId = 'test_user';
  const apiLimit = 100;

  beforeEach(() => {
    cy.login(userId);
  });

  it('should process API calls within the allowed limit', () => {
    for (let i = 0; i < apiLimit; i++) {
      apiPage.makeApiCall().then((response) => {
        expect(response.status).to.eq(200);
      });
    }
  });

  it('should track the number of API calls made', () => {
    apiPage.getApiCallCount().then((count) => {
      expect(count).to.eq(apiLimit);
    });
  });

  it('should notify user when maximum API calls are reached', () => {
    apiPage.makeApiCall().then((response) => {
      expect(response.status).to.eq(429);
      expect(response.body.message).to.eq('Rate limit exceeded');
    });
  });

  it('should block additional API calls and display an error message', () => {
    apiPage.makeApiCall().then((response) => {
      expect(response.status).to.eq(429);
      expect(response.body.message).to.eq('Rate limit exceeded');
    });
  });

  it('should reset rate limiting period', () => {
    cy.wait(3600000); // Wait for 1 hour
    apiPage.makeApiCall().then((response) => {
      expect(response.status).to.eq(200);
    });
  });

  it('should process API calls after the reset', () => {
    apiPage.makeApiCall().then((response) => {
      expect(response.status).to.eq(200);
    });
  });
});