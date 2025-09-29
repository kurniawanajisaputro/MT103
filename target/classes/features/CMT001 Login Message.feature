Feature: Login MT103 Page 001
  Scenario:CMT001 Login Message
    When MT103001 Membuka Halaman CM
    And MT103001 Klik Button Advance
    And MT103001 Klik Button IP Danamon
    And MT103001 Validasi Log In
    And MT103001 Input Username <username> Yang Valid
    And MT103001 Input Password <password> Yang Valid
    And MT103001 Click Button Login Form
    And MT103001 Validasi Homepage
    Then MT103001 Klik Create Message MT103

    Examples:
      | username | password |
      | admin2 | adminadmin |
