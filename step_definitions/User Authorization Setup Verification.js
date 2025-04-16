import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LoginPage from '../pageObjects/LoginPage';
import SettingsPage from '../pageObjects/SettingsPage';
import AuthorizationPage from '../pageObjects/AuthorizationPage';

const loginPage = new LoginPage();
const settingsPage = new SettingsPage();
const authorizationPage = new AuthorizationPage();

Given('access to the application with admin credentials', () => {
  loginPage.visit();
  loginPage.enterAdminCredentials();
});

When('the admin logs in to the application', () => {
  loginPage.submitLogin();
});

Then('the admin user is successfully logged into the application', () => {
  loginPage.verifyLoginSuccess();
});

Given('the application settings page must be accessible', () => {
  settingsPage.ensureAccessible();
});

When('the user navigates to the application settings page', () => {
  settingsPage.navigate();
});

Then('the application settings page is displayed', () => {
  settingsPage.verifyDisplay();
});

When('the user locates the authorization settings section', () => {
  authorizationPage.locateSettingsSection();
});

Then('the authorization settings section is visible', () => {
  authorizationPage.verifySettingsSectionVisible();
});

When('the user defines roles {string}, {string}, and {string} within the application', (role1, role2, role3) => {
  authorizationPage.defineRoles(role1, role2, role3);
});

Then('roles are defined and saved successfully', () => {
  authorizationPage.verifyRolesSaved();
});

When('the user assigns {string}, {string}, and {string} permissions to the {string} role', (perm1, perm2, perm3, role) => {
  authorizationPage.assignPermissions(role, [perm1, perm2, perm3]);
});

Then('permissions are assigned to the {string} role successfully', (role) => {
  authorizationPage.verifyPermissionsAssigned(role);
});

When('the user assigns {string} and {string} permissions to the {string} role', (perm1, perm2, role) => {
  authorizationPage.assignPermissions(role, [perm1, perm2]);
});

Then('permissions are assigned to the {string} role successfully', (role) => {
  authorizationPage.verifyPermissionsAssigned(role);
});

When('the user assigns {string} permission to the {string} role', (perm, role) => {
  authorizationPage.assignPermissions(role, [perm]);
});

Then('permission is assigned to the {string} role successfully', (role) => {
  authorizationPage.verifyPermissionsAssigned(role);
});

When('the admin logs out of the admin account', () => {
  loginPage.logout();
});

Then('the admin is logged out of the application', () => {
  loginPage.verifyLogout();
});

Given('a user with {string} role', (role) => {
  authorizationPage.setUserRole(role);
});

When('the user attempts to execute an action requiring {string} permission', (permission) => {
  authorizationPage.attemptAction(permission);
});

Then('the user is denied access to perform the action', () => {
  authorizationPage.verifyAccessDenied();
});

When('the user attempts to write data', () => {
  authorizationPage.attemptWriteData();
});

Then('the user is denied access to write data', () => {
  authorizationPage.verifyAccessDenied();
});

When('the user performs an action requiring {string} permission', (permission) => {
  authorizationPage.performAction(permission);
});

Then('the user with {string} role successfully performs the action', (role) => {
  authorizationPage.verifyActionSuccess(role);
});

Given('users with {string} role', (role) => {
  authorizationPage.setUserRole(role);
});

When('the users read and write data', () => {
  authorizationPage.readAndWriteData();
});

Then('users with {string} role can read and write data successfully', (role) => {
  authorizationPage.verifyReadWriteSuccess(role);
});

When('the users read data', () => {
  authorizationPage.readData();
});

Then('users with {string} role can read data successfully', (role) => {
  authorizationPage.verifyReadSuccess(role);
});

When('the user checks the application logs for any unauthorized access attempts', () => {
  authorizationPage.checkLogs();
});

Then('unauthorized access attempts are logged', () => {
  authorizationPage.verifyUnauthorizedAccessLogged();
});

When('the user ensures that role-based access control (RBAC) is enforced correctly', () => {
  authorizationPage.ensureRBACEnforced();
});

Then('RBAC is enforced correctly, and users have access only to permitted actions', () => {
  authorizationPage.verifyRBACEnforcement();
});

When('the user verifies that changes to roles and permissions are logged and auditable', () => {
  authorizationPage.verifyChangesLogged();
});

Then('changes to roles and permissions are logged and can be audited', () => {
  authorizationPage.verifyAuditLogs();
});