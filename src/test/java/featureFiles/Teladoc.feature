#Author Harsh
Feature: Teladoc feature1

@Feature1
Scenario: Add a user and validate the user has been added to the table
Given I want to launch the browser
And enter the URL
When Click on Add User button
And Enter details and save
Then Validate if user has been added to the table
When Search user with name and delete from table
Then Validate if user is deleted from the table