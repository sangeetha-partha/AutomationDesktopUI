package MyStepDefinitions;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************
* File Name 	: LoginScreen.java
* 
* Version		: 0.1
* 
* Author		: Sangeetha parthasarathy
* 
* Type			:Step Definition file
* 
* Description	: This .java file is written to test the LoginScreen, Adding new client 
*                feature of Medical Store application 
* 
* Test cases	: Testcase1_Loginfeature
*****************************************************************************/


import org.junit.Assert;
import org.openqa.selenium.WebElement;

import utility.appSQLDBInterface;
import StepLibraryFunctions.Baseclass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/*Below class contains the step definition of LoginScreen, add new client feature This extends Baseclass*/
/*Junit settings for run all the defined test cases*/

public class ClientScreen extends Baseclass{
	Baseclass object = new Baseclass();
	appSQLDBInterface dbobj = new appSQLDBInterface();
@Then("^the user clicks on CLIENT Menu$")
public void the_user_clicks_on_CLIENT_Menu() throws Throwable {
	String client = object.getElementfromDb("LoginScreen", "Button", "CLIENT DROPDOWN");
	object.findElementUsingOptions(client,"name");
	
}

@Then("^the user clicks on ADD NEW$")
public void the_user_clicks_on_ADD_NEW() throws Throwable {
	String client = object.getElementfromDb("LoginScreen", "Button", "Addnewbutton");
	object.sendKeysKeyboardTAB(client,"name");
	object.sendKeysKeyboardEnter(client,"name");

	
}


@Then("^the user verifies the client screen$")
public void the_user_verifies_the_client_screen() throws Throwable {
	String client = object.getElementfromDb("LoginScreen", "Button", "Manageclientdetail");
	String text_from_tool = object.getAttribute(client, "name", "LegacyName");
	Assert.assertEquals(text_from_tool, "MANAGE CLIENT DETAIL HERE !!");

	
}


@Then("^the user checks if the Addnewclient tab is present in client screen$")
public void the_user_checks_if_the_Addnewclient_tab_is_present_in_client_screen() throws Throwable {
	String client_addnewclient = object.getElementfromDb("LoginScreen", "Button", "Add new client");
	String text_from_tool = object.CheckifanElementisEnabled(client_addnewclient, "name");
	Assert.assertEquals(text_from_tool, "True");
}


@Then("^the user checks for the field clientname$")
public void the_user_checks_for_the_field_clientname() throws Throwable {
	String client_addnewclient = object.getElementfromDb("LoginScreen", "Button", "Clientname");
	String text_from_tool = object.CheckifanElementisEnabled(client_addnewclient, "name");
	Assert.assertEquals(text_from_tool, "True");
}


@Then("^the user checks for the field surname$")
public void the_user_checks_for_the_field_surname() throws Throwable {
	String client_addnewclient = object.getElementfromDb("LoginScreen", "Button", "surname");
	String text_from_tool = object.CheckifanElementisEnabled(client_addnewclient, "name");
	Assert.assertEquals(text_from_tool, "True");
}

@Then("^the user checks for the field city$")
public void the_user_checks_for_the_field_city() throws Throwable {
	String client_addnewclient = object.getElementfromDb("LoginScreen", "Button", "city");
	String text_from_tool = object.CheckifanElementisEnabled(client_addnewclient, "name");
	Assert.assertEquals(text_from_tool, "True");
}

@Then("^the user checks for the field mobilenumber$")
public void the_user_checks_for_the_field_mobilenumber() throws Throwable {
	String client_addnewclient = object.getElementfromDb("LoginScreen", "Button", "mobile");
	String text_from_tool = object.CheckifanElementisEnabled(client_addnewclient, "name");
	Assert.assertEquals(text_from_tool, "True");
		}

@Then("^the user checks for the field address$")
public void the_user_checks_for_the_field_address() throws Throwable {
	String client_address = object.getElementfromDb("LoginScreen", "Button", "address");
	String text_from_tool = object.CheckifanElementisEnabled(client_address, "name");
	Assert.assertEquals(text_from_tool, "True");
		}

@Then("^the user checks for the field addclient button$")
public void the_user_checks_for_the_field_addclient_button() throws Throwable {
	String client_addclientbutton = object.getElementfromDb("LoginScreen", "Button", "Addclient");
	String text_from_tool = object.CheckifanElementisEnabled(client_addclientbutton, "name");
	Assert.assertEquals(text_from_tool, "True");
		}

@Then("^the user checks if the Delnewclient tab is present in client screen$")
public void the_user_checks_if_the_Delnewclient_tab_is_present_in_client_screen() throws Throwable {
	String client_delnewclient = object.getElementfromDb("LoginScreen", "Button", "removeclienttab");
	String text_from_tool = object.CheckifanElementisEnabled(client_delnewclient, "name");
	Assert.assertEquals(text_from_tool, "True");
}

@Then("^the user checks if the Viewclientlist tab is present in client screen$")
public void the_user_checks_if_the_Viewclientlist_tab_is_present_in_client_screen() throws Throwable {
	String client_delnewclient = object.getElementfromDb("LoginScreen", "Button", "clientlisttab");
	String text_from_tool = object.CheckifanElementisEnabled(client_delnewclient, "name");
	Assert.assertEquals(text_from_tool, "True");
}

@Then("^the user enters the clientname \"([^\"]*)\"$")
public void the_user_enters_the_clientname(String clientname) throws Throwable {
	String cli_element = object.getElementfromDb("LoginScreen", "Button", "Clientname");
	System.out.println("val is : "+cli_element);
	object.findElementUsingOptions(cli_element,"name");
	object.sendKeystoTextbox(cli_element,"name",clientname);
	
    
}
@Then("^the user enters the field surname \"([^\"]*)\"$")
public void the_user_enters_the_field_surname(String surname) throws Throwable {
	String cli_surelement = object.getElementfromDb("LoginScreen", "Button", "surname");
	object.findElementUsingOptions(cli_surelement,"name");
	object.sendKeystoTextbox(cli_surelement,"name",surname);
	
    
}

@Then("^the user enters the field city \"([^\"]*)\"$")
public void the_user_enters_the_field_city(String city) throws Throwable {
	String cli_city = object.getElementfromDb("LoginScreen", "Button", "city");
	object.findElementUsingOptions(cli_city,"name");
	object.sendKeystoTextbox(cli_city,"name",city);
	
    
}
@Then("^the user enters the field address \"([^\"]*)\"$")
public void the_user_enters_the_field_address(String address) throws Throwable {
	String cli_address = object.getElementfromDb("LoginScreen", "Button", "address");
	object.findElementUsingOptions(cli_address,"name");
	object.sendKeystoTextbox(cli_address,"name",address);
	
    
}
@Then("^the user enters the field mobilenumber \"([^\"]*)\"$")
public void the_user_enters_the_field_mobilenumber(String mobile) throws Throwable {
	String cli_mobile = object.getElementfromDb("LoginScreen", "Button", "mobile");
	object.findElementUsingOptions(cli_mobile,"name");
	object.sendKeystoTextbox(cli_mobile,"name",mobile);
	
    
}

@Then ("^the user clicks field addclient button$")
public void the_user_clicks_field_addclient_button() throws Throwable {
   String Addclientbutton = object.getElementfromDb("LoginScreen", "Button", "Addclient");
   System.out.println(Addclientbutton);
   object.findElementUsingOptions(Addclientbutton,"name");
}

@Then ("^the user verifies pop up of clientadded successfully$")
public void the_user_verifies_pop_up_of_clientadded_successfully() throws Throwable {
	   String popup = object.getElementfromDb("LoginScreen", "Button", "popupsuccess");
	   String text_from_tool = object.getAttribute(popup, "name", "LegacyName");
	  Assert.assertEquals(text_from_tool, "Client Added Susscessfully !!");
	}

@Given("^the user has started the sql server and provided \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
public void the_user_has_started_the_sql_server_and_provided_and_and(String table, String query, String verificationvalue) throws Throwable {
	   @SuppressWarnings("static-access")
	String dbdata = dbobj.readrow(table,query);
	    Assert.assertEquals(dbdata, verificationvalue);
	}

@Then("^the user clicks on Clientlist$")
public void the_user_clicks_on_Clientlist() throws Throwable {
	String clientlist = object.getElementfromDb("LoginScreen", "Button", "clientlisttab");
	object.findElementUsingOptions(clientlist,"name");

	
}

@Then("^the user checks for the data in the table \"([^\"]*)\"$")
public void the_user_checks_for_the_data_in_the_table(String detail) throws Throwable {
	String clientlist = object.getElementfromDb("LoginScreen", "Button", "clientlisttab");
	String xpath = object.getElementfromDb("LoginScreen", "Button", "dataxpath");
	object.findElementUsingOptions(clientlist,"name");
	String Last =object.findLastchildelement(xpath);
	System.out.println("The last elemetn is " + Last);
	String strtoassert = object.getrowfromtable(Last);
	System.out.println(strtoassert);
	Assert.assertEquals(strtoassert, detail);
    
}



}
	


