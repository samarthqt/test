{
 import: cy,
 class: ProductInventoryPage,
 methods: [
  {
   name: ensureModuleIsActive,
   description: Navigates to the inventory page and verifies the module is active,
   logic: [
    cy.visit('/inventory'),
    cy.get('#module-status').should('have.text', 'active')
   ]
  },
  {
   name: defineLowInventoryThreshold,
   description: Sets the low inventory threshold value,
   logic: [
    cy.get('#low-inventory-threshold').type('10')
   ]
  },
  {
   name: setInventoryBelowThreshold,
   description: Sets product inventory below the defined threshold,
   logic: [
    cy.get('#product-inventory').clear().type('5')
   ]
  },
  {
   name: verifyStockWarningNotificationSent,
   description: Checks if a stock warning notification is sent,
   logic: [
    cy.get('#notifications').should('contain', 'Stock warning')
   ]
  },
  {
   name: verifyNotificationDetails,
   description: Verifies the details of the notification sent,
   logic: [
    cy.get('#notifications').should('contain', 'Product Name').and('contain', 'Current Inventory: 5')
   ]
  },
  {
   name: setInventoryAboveThreshold,
   description: Sets product inventory above the defined threshold,
   logic: [
    cy.get('#product-inventory').clear().type('15')
   ]
  },
  {
   name: verifyNoNotificationSent,
   description: Confirms that no stock warning notification is sent,
   logic: [
    cy.get('#notifications').should('not.contain', 'Stock warning')
   ]
  },
  {
   name: configureNotificationSettings,
   description: Configures notification settings and saves them,
   logic: [
    cy.get('#notification-settings').click(),
    cy.get('#settings-save').click()
   ]
  },
  {
   name: verifySettingsSaved,
   description: Checks if the notification settings are saved,
   logic: [
    cy.get('#settings-status').should('have.text', 'saved')
   ]
  },
  {
   name: verifyConfiguredSettingsRespected,
   description: Ensures that configured settings are respected in notifications,
   logic: [
    cy.get('#notifications').should('contain', 'Configured settings respected')
   ]
  },
  {
   name: setMultipleProductsBelowThreshold,
   description: Sets multiple products' inventory below the threshold,
   logic: [
    cy.get('#product1-inventory').clear().type('5'),
    cy.get('#product2-inventory').clear().type('3')
   ]
  },
  {
   name: checkInventoryLevels,
   description: Checks current inventory levels,
   logic: [
    cy.get('#check-inventory').click()
   ]
  },
  {
   name: verifyMultipleNotificationsSent,
   description: Verifies that notifications are sent for multiple products,
   logic: [
    cy.get('#notifications').should('contain', 'Product1').and('contain', 'Product2')
   ]
  },
  {
   name: verifyEachNotificationDetails,
   description: Checks details of each notification for multiple products,
   logic: [
    cy.get('#notifications').should('contain', 'Product1: 5').and('contain', 'Product2: 3')
   ]
  },
  {
   name: sendStockWarningNotification,
   description: Sends a stock warning notification manually,
   logic: [
    cy.get('#send-notification').click()
   ]
  },
  {
   name: checkUserNotifications,
   description: Checks notifications visible to the user,
   logic: [
    cy.get('#user-notifications').click()
   ]
  },
  {
   name: verifyUserSeesNotification,
   description: Verifies that the user sees the stock warning notification,
   logic: [
    cy.get('#user-notifications').should('contain', 'Stock warning')
   ]
  },
  {
   name: verifyNotificationContainsProductDetails,
   description: Checks if the notification contains product details,
   logic: [
    cy.get('#user-notifications').should('contain', 'Product Name').and('contain', 'Low Inventory')
   ]
  }
 ],
 export: default ProductInventoryPage
}