import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CloudPage from '../page_objects/cloudPage';

const cloudPage = new CloudPage();

Given('the application is deployed on a cloud platform', () => {
  cloudPage.verifyDeploymentOnCloud();
});

When('the user base and traffic increase', () => {
  cloudPage.simulateTrafficIncrease();
});

Then('the application should automatically scale resources to handle the increased load', () => {
  cloudPage.checkAutoScaling();
});

Given('the application is running in a production environment', () => {
  cloudPage.verifyProductionEnvironment();
});

When('the application uptime is monitored over a year', () => {
  cloudPage.monitorUptime();
});

Then('the total downtime should not exceed 0.1% of the total uptime', () => {
  cloudPage.checkDowntime();
});

Given('the application is receiving traffic from multiple users', () => {
  cloudPage.verifyTrafficReception();
});

When('load balancing is configured', () => {
  cloudPage.configureLoadBalancing();
});

Then('the traffic should be distributed efficiently across servers', () => {
  cloudPage.checkTrafficDistribution();
});

Given('the application infrastructure is set up', () => {
  cloudPage.verifyInfrastructureSetup();
});

When('a component fails', () => {
  cloudPage.simulateComponentFailure();
});

Then('redundant systems should take over to maintain application availability', () => {
  cloudPage.checkRedundantSystems();
});

Given('the application has failover mechanisms in place', () => {
  cloudPage.verifyFailoverMechanisms();
});

When('failover testing is performed regularly', () => {
  cloudPage.performFailoverTesting();
});

Then('the failover mechanisms should work correctly to ensure high availability', () => {
  cloudPage.checkFailoverMechanisms();
});