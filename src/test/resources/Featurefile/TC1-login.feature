Feature: Verifying Adactin Hotel Login Details

  Scenario Outline: Verifying Adactin Hotel Login Valid
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User Should Verify After Login Success Message "Hello Akilan1008!"

    Examples: 
      | userName   | password        |
      | Akilan1008 | Iphone@11promax |

  Scenario Outline: Verifying Adactin Hotel Enter Key
    Given User is on the Adactin Page
    When User should Perform Login "<userName>" and "<password>" with Enter Key
    Then User Should Verify After Login Success Message "Hello Akilan1008!"

    Examples: 
      | userName   | password        |
      | Akilan1008 | Iphone@11promax |

  Scenario Outline: Verifying Adactin Hotel Invalid Credentials
    Given User is on the Adactin Page
    When User Should Perform Login "<userName>" and "<password>"
    Then User should Verify Login with Invalid Login Credential and Error Message contains "Invalid Login details"

    Examples: 
      | userName | password |
      | Akilan   | Iphone   |
