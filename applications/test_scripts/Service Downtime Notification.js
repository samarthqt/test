describe('Service Downtime Notification', () => {
  const downtimePage = new DowntimePage();

  before(() => {
    downtimePage.scheduleDowntime('222');
  });

  it('should notify users before downtime starts', () => {
    downtimePage.verifyNotificationSent('67890');
  });

  it('should display downtime notification in notification center', () => {
    downtimePage.checkNotificationCenter();
  });

  it('should open downtime notification and redirect to details screen', () => {
    downtimePage.openDowntimeNotification();
  });

  it('should verify downtime details match scheduled downtime', () => {
    downtimePage.verifyDowntimeDetails('222');
  });
});