import { AWSPage } from '../pageObjects/AWSPage';

const awsPage = new AWSPage();

Given('an AWS account with necessary permissions', () => {
  // Assume permissions are verified outside of test automation
});

And('AWS CLI is installed and configured with access keys', () => {
  // Assume CLI installation is verified outside of test automation
});

And('Docker is installed and configured on the local machine', () => {
  // Assume Docker installation is verified outside of test automation
});

When('the user logs in to the AWS Management Console using valid credentials', () => {
  awsPage.loginToAWS();
});

Then('the AWS Management Console should be accessible', () => {
  awsPage.verifyAWSConsoleAccessible();
});

When('the user navigates to the Elastic Container Service (ECS) dashboard from the AWS services menu', () => {
  awsPage.navigateToECS();
});

Then('the ECS dashboard should be displayed', () => {
  awsPage.verifyECSDashboardDisplayed();
});

When('the user creates a new ECS cluster by selecting 'Create Cluster' and following the setup wizard', () => {
  awsPage.createECSCluster();
});

Then('a new ECS cluster should be created successfully', () => {
  awsPage.verifyECSClusterCreated();
});

When('the user opens a terminal and authenticates Docker to the Amazon ECR registry using the command `aws ecr get-login-password --region <region> | docker login --username AWS --password-stdin <ECR_URI>`', () => {
  awsPage.authenticateDockerToECR();
});

Then('Docker should be authenticated to the Amazon ECR registry successfully', () => {
  awsPage.verifyDockerAuthenticatedToECR();
});

When('the user pushes the Docker image to Amazon ECR using the command `docker push <ECR_URI>/myapp:latest`', () => {
  awsPage.pushDockerImageToECR();
});

Then('the Docker image should be pushed to Amazon ECR successfully', () => {
  awsPage.verifyDockerImagePushedToECR();
});

When('the user creates a new task definition in ECS by selecting 'Task Definitions' and 'Create new Task Definition' using the pushed Docker image URI', () => {
  awsPage.createTaskDefinition();
});

Then('a new task definition should be created successfully', () => {
  awsPage.verifyTaskDefinitionCreated();
});

When('the user configures the task definition with necessary parameters such as CPU, memory, and network settings', () => {
  awsPage.configureTaskDefinitionParameters();
});

Then('the task definition should be configured with the specified parameters', () => {
  awsPage.verifyTaskDefinitionConfigured();
});

When('the user deploys the task definition to the ECS cluster by selecting 'Run Task' and choosing the created task definition', () => {
  awsPage.deployTaskDefinitionToCluster();
});

Then('the application should be deployed successfully on the ECS cluster', () => {
  awsPage.verifyApplicationDeployed();
});

When('the user verifies the task status in the ECS cluster to ensure it is running', () => {
  awsPage.verifyTaskStatusRunning();
});

Then('the task status should be 'RUNNING'', () => {
  awsPage.verifyTaskStatusRunning();
});

When('the user retrieves the public IP or DNS of the running task from the ECS console', () => {
  awsPage.retrievePublicIPOrDNS();
});

Then('the public IP or DNS should be retrieved successfully', () => {
  awsPage.verifyPublicIPOrDNSRetrieved();
});

When('the user accesses the application using the retrieved public IP or DNS in a web browser', () => {
  awsPage.accessApplicationViaWebBrowser();
});

Then('the application should be accessible and display the home page', () => {
  awsPage.verifyApplicationAccessible();
});

When('the user performs a basic functionality test on the application to ensure it is working as expected', () => {
  awsPage.performBasicFunctionalityTest();
});

Then('all basic functionalities of the application should work without errors', () => {
  awsPage.verifyBasicFunctionalityWorks();
});

When('the user checks the application logs in AWS CloudWatch for any errors or warnings', () => {
  awsPage.checkApplicationLogs();
});

Then('the application logs should not contain any critical errors or warnings', () => {
  awsPage.verifyNoCriticalErrorsInLogs();
});

When('the user verifies the application performance metrics in AWS CloudWatch', () => {
  awsPage.verifyPerformanceMetrics();
});

Then('the application performance metrics should be within acceptable limits', () => {
  awsPage.verifyPerformanceMetricsWithinLimits();
});

When('the user logs out from the AWS Management Console', () => {
  awsPage.logoutFromAWS();
});

Then('the user should be logged out from the AWS Management Console successfully', () => {
  awsPage.verifyLogoutSuccessful();
});