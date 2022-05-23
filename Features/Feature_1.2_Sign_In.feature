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
Feature: Verification of Sign In Option
  
  @tag1
  Scenario: To validate that clicking on more option give a list of options like Sign in, subscribe, etc.
    Given User is on Universal Class Page
    When User clicks on more option button
    Then User is able to view options like Sign in, subscribe , etc 
    
    @tag2
  Scenario: To validate that clicking on close botton will close more option list.
    Given User is on Universal Class Page
    When User clicks on more option button
    Then User click on close button to close the more option list
