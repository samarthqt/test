describe('TC-700 104 Send Appointment Reminders with Invalid Contact Method', () => {
    const appointmentPage = new AppointmentPage();
    const loginPage = new LoginPage();

    before(() => {
        loginPage.login('validUser', 'validPassword');
    });

    it('Verify scheduled appointment details for the patient', () => {
        appointmentPage.verifyAppointmentDetails('P12345', '2023-10-20');
    });

    it("Ensure 'Appointment Reminders' module is active in the system", () => {
        appointmentPage.checkModuleStatus();
    });

    it('Configure reminder settings with invalid contact method', () => {
        appointmentPage.setReminderMethod('InvalidMethod');
        appointmentPage.verifyInvalidMethodError();
    });

    it('Attempt to trigger reminder process with invalid contact method', () => {
        appointmentPage.triggerReminderProcess();
        appointmentPage.verifyReminderNotSent();
    });

    after(() => {
        loginPage.logout();
    });
});