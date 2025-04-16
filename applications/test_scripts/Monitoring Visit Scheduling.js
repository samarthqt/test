describe('Monitoring Visit Scheduling', () => {
  const siteCoordinator = new SiteCoordinator();

  before(() => {
    siteCoordinator.login();
  });

  it('should navigate to the Visit Scheduling module', () => {
    siteCoordinator.visitSchedulingModule();
  });

  it('should select site S001 and display site details', () => {
    siteCoordinator.selectSite('S001');
  });

  it('should schedule a new visit', () => {
    siteCoordinator.scheduleNewVisit();
    siteCoordinator.enterVisitDate('2023-10-15');
    siteCoordinator.linkTrialProgressReport('TPR001');
    siteCoordinator.submitVisitSchedule();
  });

  it('should verify the visit schedule includes the linked trial progress report', () => {
    siteCoordinator.verifyVisitSchedule('TPR001');
  });

  it('should check notifications are sent to site staff', () => {
    siteCoordinator.verifyNotifications();
  });

  it('should access the site calendar to view scheduled visits', () => {
    siteCoordinator.accessSiteCalendar();
  });

  it('should export visit schedule data to PDF format', () => {
    siteCoordinator.exportVisitScheduleToPDF();
  });

  it('should generate a visit summary report for all sites', () => {
    siteCoordinator.generateVisitSummaryReport();
  });

  it('should allow rescheduling of monitoring visits', () => {
    siteCoordinator.checkReschedulingOptions();
  });

  it('should review the audit trail for visit scheduling actions', () => {
    siteCoordinator.reviewAuditTrail('S001');
  });

  it('should validate security measures for visit scheduling data', () => {
    siteCoordinator.validateSecurityMeasures();
  });
});