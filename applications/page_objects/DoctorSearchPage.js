class DoctorSearchPage {
  navigateTo() {
    cy.visit('/appointment-management/doctor-search');
  }

  enterSpecialty(specialty) {
    cy.get('#specialty-filter').type(specialty);
  }

  enterLocation(location) {
    cy.get('#location-filter').type(location);
  }

  selectAvailability(availability) {
    cy.get('#availability-filter').select(availability);
  }

  clickSearchButton() {
    cy.get('#search-button').click();
  }

  verifyDoctorProfile(specialty, location, availability) {
    cy.get('.doctor-profile').should('contain', specialty);
    cy.get('.doctor-profile').should('contain', location);
    cy.get('.doctor-profile').should('contain', availability);
  }
}