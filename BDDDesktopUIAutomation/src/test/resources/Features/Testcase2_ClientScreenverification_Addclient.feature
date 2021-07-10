Feature: Client addition in Medical store application
As a Tester I want to test the Client screen in Medical store application 
Verify all the tabs in it and add new client in to db

Scenario Outline: Medical store Login Test Scenario verify the client menu add new
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" and "<password>"
	Then The user clicks on Login button
	Then the user finds Medical store Welcome Profile screen
	Then the user clicks on CLIENT Menu
	Then the user clicks on ADD NEW 
	Then the user verifies the client screen
	Then the user checks for the field clientname
	Then the user checks for the field surname
	Then the user checks for the field city
	Then the user checks for the field mobilenumber
	Then the user checks for the field address
	Then the user checks for the field addclient button
	Then The User Logs out
		
	Examples: 
		| username           | password    |
		| admin              | admin       |
		
		
	
		
		Scenario Outline: Medical store Login Test Scenario verify tabs
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" and "<password>"
	Then The user clicks on Login button
	Then the user finds Medical store Welcome Profile screen
	Then the user clicks on CLIENT Menu
	Then the user clicks on ADD NEW 
	Then the user checks if the Addnewclient tab is present in client screen
	Then the user checks if the Delnewclient tab is present in client screen
	Then the user checks if the Viewclientlist tab is present in client screen
	Then The User Logs out
		
	Examples: 
		| username           | password    |
		| admin              | admin       |
		
		
		
		Scenario Outline: Medical store Add client Test Scenario add new client to db
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" and "<password>"
	Then The user clicks on Login button
	Then the user finds Medical store Welcome Profile screen
	Then the user clicks on CLIENT Menu
	Then the user clicks on ADD NEW 
	Then the user enters the clientname "<clientname>" 
	Then the user enters the field surname "<surname>" 
	Then the user enters the field city "<city>" 
	Then the user enters the field mobilenumber "<mobile>" 
	Then the user enters the field address "<address>" 
	Then the user clicks field addclient button
	Then the user verifies pop up of clientadded successfully
	Then the user clicks ok button
	Then The User Logs out
		
	Examples: 
		| username   | password    |   clientname | surname | city     |mobile   | address|
		| admin      | admin       |   johny      | castle  | newyork  |12367890 | USA    |  
		| admin      | admin       |   sam        | curran  | melbourne|43463457 | Aussy  |
		
		
Scenario Outline: Verify the addded client in back end DB
Given the user has started the sql server and provided "<table>" and "<query>" and "<verificationvalue> "


Examples: 
		| table           | query             | verificationvalue                  |
		| ClientMst       | CU_name='Matt'   | 3 Matt Weizz Chicago USA 374574747 |
		
		
Scenario Outline: Verify the addded client in UI
Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" and "<password>"
	Then The user clicks on Login button
	Then the user finds Medical store Welcome Profile screen
	Then the user clicks on CLIENT Menu
	Then the user clicks on ADD NEW 
	Then the user clicks on Clientlist
	Then the user checks for the data in the table "<detail> "
	Then The User Logs out

Examples: 
		Examples: 
		| username           | password    |detail                           |
		| admin              | admin       |sam curran Aussy 43463457 melbourne| 
		
		
		
Scenario Outline: failure scenario wrong log in pw
	Given user has logged in to Login Page
	When The title of login page is Medical store Login
	Then  The user enters "<username>" and "<password>"
	Then The user clicks on Login button
	Then the user finds Medical store Welcome Profile screen
	Then the user clicks ok button
	Then The User Logs out
	
		
	Examples: 
		| username           | password    |
		| admin              | admins       |
		

	
	
		
		