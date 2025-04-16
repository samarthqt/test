describe('Electronic Referral System', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const referralPage = new ReferralPage();

  before(() => {
    cy.visit('/');
  });

  it('should allow healthcare providers to refer patients electronically', () => {
    // Step 1: Log in to the healthcare provider portal
    loginPage.login('valid_username', 'valid_password');
    dashboardPage.verifyDashboardDisplayed();

    // Step 2: Navigate to the 'Referrals' section
    dashboardPage.navigateToReferrals();
    referralPage.verifyReferralInterfaceDisplayed();

    // Step 3: Select 'Create New Referral'
    referralPage.createNewReferral();
    referralPage.verifyReferralFormDisplayed();

    // Step 4: Enter patient ID and verify patient details
    referralPage.enterPatientID('P123');
    referralPage.verifyPatientDetails();

    // Step 5: Enter specialist ID and verify specialist details
    referralPage.enterSpecialistID('S456');
    referralPage.verifySpecialistDetails();

    // Step 6: Fill in the referral reason and additional notes
    referralPage.enterReferralReason('Cardiovascular Consultation');
    referralPage.enterAdditionalNotes('Patient requires immediate attention.');

    // Step 7: Submit the referral request
    referralPage.submitReferral();
    referralPage.verifyReferralConfirmation();

    // Step 8: Verify the referral notification sent to the patient
    referralPage.verifyReferralNotificationSent();

    // Step 9: Check referral status in the system
    referralPage.verifyReferralStatus('Sent');

    // Step 10: Log out from the provider portal
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});