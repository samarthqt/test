import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import PerformancePage from '../page_objects/performancePage';

const performancePage = new PerformancePage();

Given('the web version of the application is accessed', () => {
  performancePage.accessWebVersion();
});

Given('the mobile version of the application is accessed', () => {
  performancePage.accessMobileVersion();
});

Given('the application is accessed by 10,000 concurrent users', () => {
  performancePage.simulateConcurrentUsers(10000);
});

Given('the application is being accessed by users', () => {
  performancePage.accessApplication();
});

Given('the user load on the application increases', () => {
  performancePage.increaseUserLoad();
});

Given('it is the scheduled time for a monthly stress test', () => {
  performancePage.scheduleStressTest();
});

When('the application is loaded under standard network conditions', () => {
  performancePage.loadUnderStandardConditions();
});

When('the application is running under standard network conditions', () => {
  performancePage.runUnderStandardConditions();
});

When('performance metrics are generated', () => {
  performancePage.generatePerformanceMetrics();
});

When('the system detects increased load', () => {
  performancePage.detectIncreasedLoad();
});

When('the stress test is conducted', () => {
  performancePage.conductStressTest();
});

Then('the application should load within 3 seconds on average', () => {
  performancePage.verifyLoadTime(3);
});

Then('the system should handle the load with less than 5% error rate', () => {
  performancePage.verifyErrorRate(5);
});

Then('the performance metrics should be logged and monitored in real-time', () => {
  performancePage.verifyRealTimeLogging();
});

Then('the system should automatically scale resources to accommodate the load', () => {
  performancePage.verifyAutoScaling();
});

Then('the application should meet the performance benchmarks', () => {
  performancePage.verifyPerformanceBenchmarks();
});