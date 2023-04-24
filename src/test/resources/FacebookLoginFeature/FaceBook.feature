
Feature: Application Login
Background:
Given User launch the facebook web application
  Scenario: Home page defaultlogin with valid credentials
   #Given User launch the facebook web application
    When User enters valid username and valid password
    And User needs click the login button
    Then verify user is navigating to home page or not
    
    
  Scenario Outline: Application login with credentials with multiple test case
		#Given User launch the facebook web application
    When User enters valid "<username>" and valid "<password>"
    And User needs click the login button
    Then verify user is navigating to home page or not
     
   
    Examples: 
      | username|password|
      | gowtham|abc@123|
      | mura|12345|
