class LandlordPage {
  login(email, password) {
    cy.get('#email').type(email);
    cy.get('#password').type(password);
    cy.get('#login-button').click();
  }

  navigateToListings() {
    cy.get('#listings-module').click();
  }

  clickAddNewProperty() {
    cy.get('#add-new-property-button').click();
  }

  enterPropertyDescription(description) {
    cy.get('#property-description').type(description);
  }

  uploadPhotos(photoPaths) {
    photoPaths.forEach((photoPath, index) => {
      cy.get(`#photo-upload-${index}`).attachFile(photoPath);
    });
  }

  enterRentDetails(rent) {
    cy.get('#rent-details').type(rent);
  }

  setAvailabilityDate(date) {
    cy.get('#availability-date').type(date);
  }

  submitPropertyListing() {
    cy.get('#submit-property-button').click();
  }

  verifyListingDetails(propertyId, details) {
    cy.get(`#listing-${propertyId}`).within(() => {
      cy.get('.description').should('contain', details.description);
      details.photos.forEach(photo => {
        cy.get('.photos').should('contain', photo);
      });
      cy.get('.rent').should('contain', details.rent);
      cy.get('.availability').should('contain', details.availability);
    });
  }

  logout() {
    cy.get('#logout-button').click();
  }
}