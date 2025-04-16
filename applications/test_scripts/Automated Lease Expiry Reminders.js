describe('Automated Lease Expiry Reminders', () => {
  const leaseManagementPage = new LeaseManagementPage();
  const remindersPage = new RemindersPage();

  before(() => {
    cy.login('tenant@example.com', 'password');
  });

  it('should access the Lease Management module', () => {
    leaseManagementPage.visit();
    leaseManagementPage.verifyDashboardDisplayed();
  });

  it('should navigate to the Reminders sub-module', () => {
    remindersPage.visit();
    remindersPage.verifyRemindersPageDisplayed();
  });

  it('should locate the lease for tenant@example.com with expiry date 12/31/2023', () => {
    remindersPage.findLease('tenant@example.com', '12/31/2023');
  });

  it('should verify the reminder settings for the lease', () => {
    remindersPage.verifyReminderSettings();
  });

  it('should check the notification schedule for the reminder', () => {
    remindersPage.verifyNotificationSchedule();
  });

  it('should ensure tenant email is correct', () => {
    remindersPage.verifyTenantEmail('tenant@example.com');
  });

  it('should ensure landlord email is correct', () => {
    remindersPage.verifyLandlordEmail('landlord@example.com');
  });

  it('should simulate the current date as 30 days before lease expiry', () => {
    cy.clock(new Date('2023-12-01').getTime());
  });

  it('should trigger the reminder process manually', () => {
    remindersPage.triggerReminderProcess();
  });

  it('should check the system logs for reminder dispatch entries', () => {
    remindersPage.verifyReminderDispatchLogs();
  });

  it('should verify the tenant receives an email reminder', () => {
    remindersPage.verifyEmailReceived('tenant@example.com');
  });

  it('should verify the landlord receives an email reminder', () => {
    remindersPage.verifyEmailReceived('landlord@example.com');
  });

  it('should check the email content for accuracy', () => {
    remindersPage.verifyEmailContent();
  });

  it('should verify the reminder status is updated in the system', () => {
    remindersPage.verifyReminderStatus();
  });

  after(() => {
    cy.logout();
  });
});