class PropertyPage {
  static get virtualTourButton() {
    return '.virtual-tour-btn';
  }

  static get noTourMessage() {
    return '.no-tour-message';
  }
}

class VirtualTourPage {
  static get tourInterface() {
    return '.tour-interface';
  }

  static get videoQuality() {
    return '.video-quality';
  }

  static get bufferingIndicator() {
    return '.buffering-indicator';
  }

  static get pauseButton() {
    return '.pause-btn';
  }

  static get playButton() {
    return '.play-btn';
  }

  static get navigateButton() {
    return '.navigate-btn';
  }

  static get fullScreenButton() {
    return '.fullscreen-btn';
  }

  static get exitFullScreenButton() {
    return '.exit-fullscreen-btn';
  }

  static get replayButton() {
    return '.replay-btn';
  }

  static get fullScreenIndicator() {
    return '.fullscreen-indicator';
  }
}

class LoginPage {
  static get loginPrompt() {
    return '.login-prompt';
  }
}

module.exports = { PropertyPage, VirtualTourPage, LoginPage };