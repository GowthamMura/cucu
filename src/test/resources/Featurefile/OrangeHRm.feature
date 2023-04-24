Feature: This is the login feature for orangeHRm 
  @tag1
  Scenario: This isd login scenario
    Given user is on the login page     
    When user enter the valid "Akilan1008" and "Iphone@11promax"
    And click the login buttton
    Then The should be valid Success message
   
