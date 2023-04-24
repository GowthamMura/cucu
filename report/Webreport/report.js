$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/FacebookLoginFeature/FaceBook.feature");
formatter.feature({
  "name": "Application Login",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launch the facebook web application",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_launch_the_facebook_web_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Home page defaultlogin with valid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User enters valid username and valid password",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.user_enters_valid_username_and_valid_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User needs click the login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_needs_click_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify user is navigating to home page or not",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.verify_user_is_navigating_to_home_page_or_not()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Application login with credentials with multiple test case",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters valid \"\u003cusername\u003e\" and valid \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User needs click the login button",
  "keyword": "And "
});
formatter.step({
  "name": "verify user is navigating to home page or not",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "gowtham",
        "abc@123"
      ]
    },
    {
      "cells": [
        "mura",
        "12345"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launch the facebook web application",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_launch_the_facebook_web_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Application login with credentials with multiple test case",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters valid \"gowtham\" and valid \"abc@123\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.user_enters_valid_and_valid(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User needs click the login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_needs_click_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify user is navigating to home page or not",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.verify_user_is_navigating_to_home_page_or_not()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launch the facebook web application",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_launch_the_facebook_web_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Application login with credentials with multiple test case",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters valid \"mura\" and valid \"12345\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.user_enters_valid_and_valid(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User needs click the login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_needs_click_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify user is navigating to home page or not",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.verify_user_is_navigating_to_home_page_or_not()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});