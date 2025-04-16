class ApiPage {
  initiateApiCall(userId) {
    cy.request({
      method: 'POST',
      url: `/api/call?userId=${userId}`,
      failOnStatusCode: false
    });
  }

  verifyRateLimitEnforced() {
    cy.request({
      method: 'POST',
      url: '/api/call',
      failOnStatusCode: false
    }).then((response) => {
      expect(response.status).to.eq(429);
      expect(response.body).to.have.property('message', 'Rate limit exceeded');
    });
  }

  verifyUserNotification(userId) {
    cy.request(`/api/notifications?userId=${userId}`).then((response) => {
      expect(response.body.notifications).to.include('You have reached the maximum API call limit.');
    });
  }

  verifyApiCallProcessed() {
    cy.request({
      method: 'POST',
      url: '/api/call'
    }).then((response) => {
      expect(response.status).to.eq(200);
    });
  }

  verifyNoPerformanceDegradation() {
    cy.request({
      method: 'POST',
      url: '/api/call'
    }).then((response) => {
      expect(response.duration).to.be.lessThan(1000);
    });
  }
}