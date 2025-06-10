import { expect } from 'chai';
class ProjectsPage {
    static clickProjectsMenu() {
        cy.get('#projectsMenu').click();
    }

    static verifyCreateNewProjectOption() {
        cy.get('#createNewProject').should('be.visible');
    }

    static navigateToProjectsPage() {
        cy.visit('/projects');
    }

    static verifyProjectsPageTitle(expectedTitle) {
        cy.title().should('eq', expectedTitle);
    }

    static clickCreateNewProjectButton() {
        cy.get('#createNewProject').click();
    }

    static fillProjectName(name) {
        cy.get('#projectNameInput').type(name);
    }

    static fillProjectDescription(description) {
        cy.get('#projectDescriptionInput').type(description);
    }

    static submitProjectForm() {
        cy.get('#submitProjectForm').click();
    }

    static verifyProjectInList(projectName) {
        cy.get('.project-list').contains(projectName).should('be.visible');
    }

    static deleteProject(projectName) {
        cy.get(`.project-item:contains(${projectName})`).find('.delete-button').click();
    }

    static confirmDeleteProject() {
        cy.get('#confirmDeleteButton').click();
    }

    static verifyProjectDeleted(projectName) {
        cy.get('.project-list').contains(projectName).should('not.exist');
    }
}

export default ProjectsPage;