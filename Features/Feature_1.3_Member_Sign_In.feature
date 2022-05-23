#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Verification of Sign In Button 

  @tag1
  Scenario: To validate that after clicking on sign in button Member Sign In  window will appears.
   Given User is on Universal Class Page
    When User clicks on more option button
    Then User click on Sign in button and Member sign in window will appears

  @tag2
  Scenario Outline: To validate that Sign in window have text box for Email and password respectively.
     Given User is on Universal Class Page
    When User clicks on more option button
    Then User click on Sign in button and see two text box for email and password resp 

