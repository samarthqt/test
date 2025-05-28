import { expect } from 'chai'; 
class MobilePage { 
  static visit() { 
    cy.visit('/'); 
  }
  
  static setDeviceResolution(device, resolution) { 
    cy.viewport(resolution.split('x')[0], resolution.split('x')[1]); 
  }
  
  static setMobileDevice() { 
    cy.viewport('iphone-x'); 
  }
  
  static setOrientation(orientation) { 
    cy.viewport(orientation === 'portrait' ? 'iphone-x' : 'iphone-x-landscape'); 
  }
  
  static tapButtonOrLink() { 
    cy.get('button, a').first().click(); 
  }
  
  static focusOnTextInput() { 
    cy.get('input[type=text]').first().focus(); 
  }
  
  static playMedia() { 
    cy.get('video, audio').first().then($media => { 
      if ($media[0].paused) { 
        $media[0].play(); 
      } 
    }); 
  }
  
  static verifyNoLayoutIssues() { 
    cy.get('body').should('not.have.css', 'overflow', 'hidden'); 
  }
  
  static verifyInteractiveElementsFunctional() { 
    cy.get('button, a').should('not.be.disabled'); 
  }
  
  static verifyNavigationMenu() { 
    cy.get('nav').should('be.visible'); 
  }
  
  static verifyContentReadable() { 
    cy.get('body').should('have.css', 'font-size').and('satisfy', (size) => parseFloat(size) > 10); 
  }
  
  static verifyNoHorizontalScrolling() { 
    cy.get('body').should('not.have.css', 'overflow-x', 'scroll'); 
  }
  
  static verifyNoVerticalScrolling() { 
    cy.get('body').should('not.have.css', 'overflow-y', 'scroll'); 
  }
  
  static verifyActionPerformed() { 
    cy.url().should('not.eq', '/'); 
  }
  
  static verifyNoDelay() { 
    cy.get('button, a').first().should('not.have.css', 'transition-delay'); 
  }
  
  static verifyKeyboardAppearance() { 
    cy.get('input[type=text]').first().should('be.focused'); 
  }
  
  static verifyTextEntry() { 
    cy.get('input[type=text]').first().type('Test').should('have.value', 'Test'); 
  }
  
  static verifyMediaPlayback() { 
    cy.get('video, audio').first().should('have.prop', 'paused', false); 
  }
  
  static verifyMediaControls() { 
    cy.get('video, audio').first().within(() => { 
      cy.get('.controls').should('be.visible'); 
    }); 
  }
}

export default MobilePage;