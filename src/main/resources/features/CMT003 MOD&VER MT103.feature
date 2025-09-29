Feature: VER MT103 003
  Scenario:CMT003 VER Message MT103
    When MT103003 Validasi Log In
    And MT103003 Input Username <username> Yang Valid
    And MT103003 Input Password <password> Yang Valid
    And MT103003 Click Button Login Form
    And MT103003 Validasi Homepage
    And MT103003 Click Button Verification Page
    And MT103003 Click Button View TRX
    And MT103003 Click Button Modification
    And MT103003 Validasi MOD
    And MT103003 Click Log Out
    Then MT103003 Validasi Log In

Feature: MOD MT103 004
  Scenario:CMT003 MOD Message MT103
    When MT103004 Validasi Log In
    And MT103004 Input Username <username> Yang Valid
    And MT103004 Input Password <password> Yang Valid
    And MT103004 Click Button Login Form
    And MT103004 Validasi Homepage
    And MT103004 Click Button Modification Page
    And MT103004 Click Button View TRX
    And MT103004 Click Body
    And MT103004 Input Reference <reference> Yang Valid
    And MT103004 Click Button Validate
    And MT103004 Click Button Save
    And MT103004 Validasi VER
    Then MT103004 Click Log Out
