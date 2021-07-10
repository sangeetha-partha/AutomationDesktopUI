package MyStepDefinitions;


/******************************************************************************
* File Name 	: LoginToApplication.java
* 
* Version		: 0.1
* 
* Author		: Sangeetha parthasarathy
* 
* Type			:Step Definition file
* 
* Description	: This .java file is written to test the Login feature of 
* 				  Medical Store application 
* 
* Test cases	: Testcase1_Loginfeature
*****************************************************************************/



import java.net.MalformedURLException;
import utility.screenshotLib;
import utility.applaunchLib;
import org.junit.Assert;
import StepLibraryFunctions.Baseclass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/*Below class contains the step definition of login feature This extends Baseclass*/
/*Junit settings for run all the defined test cases*/

public class LoginToApplication extends Baseclass{
	Baseclass object = new Baseclass();
	screenshotLib screenobj = new screenshotLib();

@Given("^user has logged in to Login Page$")
public void user_has_logged_in_to_Login_Page() throws Throwable {
	try {
		object.AppLaunch();
		
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		     System.out.println("Error Cause is:- "+e.getCause());
			 System.out.println("Error Message is:- "+e.getMessage());
		}
		
}

@When("^The title of login page is Medical store Login$")
public void the_title_of_login_page_is_Audiometry_Login() throws Throwable {
	String title = object.getElementfromDb("LoginScreen", "Button", "Title");
	String title_from_tool = object.getAttribute(title, "name", "LegacyName");
	Assert.assertEquals(title_from_tool, "MEDICAL STORE SYSTEM");
	
}

@Then("^The user enters \"([^\"]*)\" and \"([^\"]*)\"$")
public void the_user_enters_and(String username, String password) throws Throwable {
	String admin_element = object.getElementfromDb("LoginScreen", "Button", "admin_textbox");
	System.out.println(admin_element);
	System.out.println("*****************");
	object.findElementUsingOptions(admin_element,"name");
	
	object.sendKeystoTextbox(admin_element,"name",username);
	String password_element = object.getElementfromDb("LoginScreen", "Button", "password_textbox");
	object.findElementUsingOptions(password_element,"name");
	object.sendKeystoTextbox(password_element,"name",password);
    
}

@SuppressWarnings("static-access")
@Then("^The user enters \"([^\"]*)\"$")
public void the_user_enters_(String username) throws Throwable {
	String admin_element = object.getElementfromDb("LoginScreen", "Button", "admin_textbox");
	object.findElementUsingOptions(admin_element,"name");
	object.sendKeystoTextbox(admin_element,"name",username);
	screenobj.captureScreenshot("username", driver);
	
    
}

@Then("^The user enters password\"([^\"]*)\"$")
public void the_user_enters_password(String password) throws Throwable {
	String pw_element = object.getElementfromDb("LoginScreen", "Button", "password_textbox");
	object.findElementUsingOptions(pw_element,"name");
	object.sendKeystoTextbox(pw_element,"name",password);
	
    
}

@Then("^the user finds error dialog$")
public void the_user_finds_error_dialog() throws Throwable {
	String dialogtext = object.getElementfromDb("LoginScreen", "Button", "onlyusername");
	String title_from_tool = object.getAttribute(dialogtext, "name", "LegacyName");
	Assert.assertEquals(title_from_tool, "Enter Login Password !");
	
}

@Then("^the user finds error dialog for missng loginname$")
public void the_user_finds_error_dialog_for_missing_loginname() throws Throwable {
	String dialogtext = object.getElementfromDb("LoginScreen", "Button", "Onlypw");
	String title_from_tool = object.getAttribute(dialogtext, "name", "LegacyName");
	Assert.assertEquals(title_from_tool, "Enter Login Name !");
	
}

@Then("^the user clicks ok button$")
public void the_user_clicks_ok_button() throws Throwable {
	String ok = object.getElementfromDb("LoginScreen", "Button", "Okbutton");
	object.findElementUsingOptions(ok, "name");
	
}

@Then("^the user finds popup$")
public void the_user_finds_popup() throws Throwable {
	String dialogtext = object.getElementfromDb("LoginScreen", "Button", "wrongpw");
	String title_from_tool = object.getAttribute(dialogtext, "name", "LegacyName");
	Assert.assertEquals(title_from_tool, "Invalid LoginName OR Password !");
	
}

@Then ("^The user clicks on Login button$")
public void the_user_clicks_on_login_button() throws Throwable{
	String login_element = object.getElementfromDb("LoginScreen", "Button", "login_box");
	object.findElementUsingOptions(login_element,"name");
	
	
}

@Then ("^the user finds Medical store Welcome Profile screen")
public void the_user_finds_Medical_store_Welcome_Profile_screen() throws Throwable {
	String Welcometext = object.getElementfromDb("LoginScreen", "Button", "Welcometext");
	String text_from_tool = object.getAttribute(Welcometext, "name", "LegacyName");
	Assert.assertEquals(text_from_tool, "welcome admin");
	
			}

@Then("^The User Logs out$")
public void the_User_Close_the_browser() throws Throwable {
	driver.quit();
   
}

}
