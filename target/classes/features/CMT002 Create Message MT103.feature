Feature: Create MT103 002
  Scenario:CMT002 Create Message MT103
#    When MT103002 Validasi MT103Page
    And MT103002 Click Sender Header
    And MT103002 Input Receiver Header <receiver> Yang Valid
    And MT103002 Click Body
    And MT103002 Input Reference <reference> Yang Valid
    And MT103002 Click Tag23B
    And MT103002 Input tag32Acurr <tag32AC> Yang Valid
    And MT103002 Input tag32AAmount <tag32AA>  Yang Valid
    And MT103002 Click Tag50 A Identifiercode
    And MT103002 Input Tag 50 Bic <tag50bic> Yang Valid
    And MT103002 Click Tag59 A Identifiercode
    And MT103002 Input Tag 59 Bic <tag59bic> Yang Valid
    And MT103002 Click Tag 71 OUR
    And MT103002 Click Validate
    And MT103002 Click Submit
    And MT103002 Validasi VER
    Then MT103002 Click Log Out

    Examples:
      | receiver | reference | tag32AC | tag32AA | tag50bic | tag59bic |
      | BDINIDJAXXXX | TESAUTOMATION15 | USD | 1 | BDINIDJAXXXX | BDINIDJAXXXX |
