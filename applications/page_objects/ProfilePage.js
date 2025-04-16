class ProfilePage {
    navigateToCreateProfile() {
        cy.get('#create-profile-btn').click();
    }

    enterDriverName(name) {
        cy.get('#driver-name-input').type(name);
    }

    setSeatPosition(position) {
        cy.get('#seat-position-input').clear().type(position);
    }

    setMirrorAngle(angle) {
        cy.get('#mirror-angle-input').clear().type(angle);
    }

    submitProfile() {
        cy.get('#submit-profile-btn').click();
    }

    navigateToViewProfiles() {
        cy.get('#view-profiles-btn').click();
    }

    verifyDriverName(expectedName) {
        cy.get('#profile-driver-name').should('have.text', expectedName);
    }

    verifySeatPosition(expectedPosition) {
        cy.get('#profile-seat-position').should('have.text', expectedPosition);
    }

    verifyMirrorAngle(expectedAngle) {
        cy.get('#profile-mirror-angle').should('have.text', expectedAngle);
    }

    navigateToUpdateProfile() {
        cy.get('#update-profile-btn').click();
    }

    updateSeatPosition(newPosition) {
        cy.get('#seat-position-input').clear().type(newPosition);
    }

    logout() {
        cy.get('#logout-btn').click();
    }
}