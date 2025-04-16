describe('Unauthorized Access to Patient Data', () => {
    const unauthorizedUser = {
        username: 'U12345',
        password: 'wrongpassword'
    };

    it('should deny access to the system with unauthorized credentials', () => {
        cy.visit('/login');
        cy.get('#username').type(unauthorizedUser.username);
        cy.get('#password').type(unauthorizedUser.password);
        cy.get('button[type="submit"]').click();
        cy.get('.error-message').should('contain', 'Access is denied');
    });

    it('should deny access to patient data via API', () => {
        cy.request({
            method: 'GET',
            url: '/api/patient-data',
            failOnStatusCode: false,
            auth: {
                user: unauthorizedUser.username,
                pass: unauthorizedUser.password
            }
        }).then((response) => {
            expect(response.status).to.eq(401);
            expect(response.body).to.have.property('error', 'Access is denied');
        });
    });
});