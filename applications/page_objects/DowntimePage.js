class DowntimePage {
  scheduleDowntime(id) {
    cy.request('POST', `/api/downtime/schedule`, { id }).then((response) => {
      expect(response.status).to.eq(200);
    });
  }

  subscribeUserToDowntimeAlerts(userId) {
    cy.request('POST', `/api/users/${userId}/subscribe/downtime`).then((response) => {
      expect(response.status).to.eq(200);
    });
  }

  verifyNotificationSent(userId, downtimeId) {
    cy.request(`/api/users/${userId}/notifications`).then((response) => {
      expect(response.body).to.have.deep.property('downtimeId', downtimeId);
    });
  }

  visitNotificationCenter(userId) {
    cy.visit(`/users/${userId}/notification-center`);
  }

  verifyDowntimeNotificationDisplayed(downtimeId) {
    cy.get('.notification-list').contains(`Downtime ID: ${downtimeId}`);
  }

  openDowntimeNotification(downtimeId) {
    cy.get('.notification-list').contains(`Downtime ID: ${downtimeId}`).click();
  }

  verifyDowntimeDetails(downtimeId) {
    cy.url().should('include', `/downtime/${downtimeId}/details`);
    cy.get('.downtime-details').should('contain', `Downtime ID: ${downtimeId}`);
  }
}

export default DowntimePage;