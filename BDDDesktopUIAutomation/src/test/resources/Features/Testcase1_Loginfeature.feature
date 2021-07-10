Feature: Login Feature Medical Store Application
As a tester, I want to test the log in feature in Medical store application, 
with different scenarios

Scenario Outline: Medical store Login Test Scenario
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" and "<password>"
	Then The user clicks on Login button
	Then the user finds Medical store Welcome Profile screen
	Then The User Logs out
		
	Examples: 
		| username           | password    |
		| admin              | admin       |
		

Scenario Outline: Medical store Login Test Scenario error scenario without user name
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters password"<password>" 
	Then The user clicks on Login button
	Then the user finds error dialog for missng loginname
	Then the user clicks ok button
	Then The User Logs out
		
	Examples: 
		| password           | 
		| admin              |
		
		
	Scenario Outline: Medical store Login Test Scenario with wrong password
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" and "<password>"
	Then The user clicks on Login button
	Then the user finds popup
	Then the user clicks ok button
	Then The User Logs out
		
	Examples: 
		| username           | password    |
		| admin              | admins       |
		
		
	Scenario: Medical store Login Test Scenario error scenario with only user name
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then The user clicks on Login button
	Then the user finds error dialog for missng loginname
	Then the user clicks ok button
	Then The User Logs out
		

		
	
	Scenario Outline: Medical store Login Test Scenario error scenario with no password
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" 
	Then The user clicks on Login button
	Then the user finds error dialog
	Then the user clicks ok button
	Then The User Logs out
		
	Examples: 
		| username           | 
		| admin              |
		