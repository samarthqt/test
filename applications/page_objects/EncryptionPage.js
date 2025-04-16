class EncryptionPage {
    createUserData(userId, data) {
        return cy.request({
            method: 'POST',
            url: `/api/users/${userId}/data`,
            body: { data: data },
        });
    }

    encryptData(userId, data) {
        return cy.request({
            method: 'POST',
            url: `/api/encrypt`,
            body: { userId: userId, data: data },
        });
    }

    decryptData(userId) {
        return cy.request({
            method: 'GET',
            url: `/api/decrypt/${userId}`,
        }).then(response => response.body.data);
    }

    monitorPerformance() {
        return cy.request({
            method: 'GET',
            url: `/api/performance`,
        }).then(response => response.body);
    }

    deleteUserData(userId) {
        return cy.request({
            method: 'DELETE',
            url: `/api/users/${userId}/data`,
        });
    }
}

export default EncryptionPage;