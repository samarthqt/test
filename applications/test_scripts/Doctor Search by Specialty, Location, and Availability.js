describe('Doctor Search by Specialty, Location, and Availability', () => {
  before(() => {
    cy.login(); // Custom command to log into the system
  });

  it('should allow patients to search for doctors based on specialty, location, and availability', () => {
    const doctorSearchPage = new DoctorSearchPage();
    doctorSearchPage.navigateTo();

    doctorSearchPage.enterSpecialty('Cardiology');
    doctorSearchPage.enterLocation('New York');
    doctorSearchPage.selectAvailability('Next week');
    doctorSearchPage.clickSearchButton();

    doctorSearchPage.verifyDoctorProfile('Cardiology', 'New York', 'Next week');
  });
});