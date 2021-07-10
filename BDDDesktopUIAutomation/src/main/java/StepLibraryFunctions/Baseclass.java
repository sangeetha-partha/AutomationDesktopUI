package StepLibraryFunctions;

/******************************************************************************
* File Name 	        : Baseclass.java
* 
* Version		        : 0.1
* 
* Author		        : Sangeetha parthasarathy
* 
* Type			        : Base class Library file
* 
* Description	        : This .java file is written to hold all the common functions  
* 				          required for automation, for instance,
*                         examples: driver.findelementbyid(element).click() 
* 
* Step Definition files	: LoginToApplication, ClientScreen
*****************************************************************************/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import utility.yamlLib;
import utility.applaunchLib;
import utility.dbUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.mongodb.DB;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/* base class contains all the common functions which are called in step definition functions*/
public class Baseclass {
	
	public WebDriverWait waitFunction(){
		WebDriverWait wait = new WebDriverWait(driver, 1);
		return wait;
		
	}
	
	   public static RemoteWebDriver driver = null; /* declaring driver instance of RemoteWebDriver as null*/
	   
	   //Actions builder = new Actions(driver);
		
		JSONObject document;
		
		/**************************************************************************
		 * Function Name  : AppLaunch
		 * 
		 * parameters	  : none
		 * 
		 * Return Type	  : void
		 * 
		 * Description    : This function will launch application exe from the
		 *                  path specified in the config.properties file				
		 * 				
		 *************************************************************************/		
		public void AppLaunch() throws FileNotFoundException, IOException, ParseException {
			Map<String, String> map;
			//String path = "/home/1972001/eclipse-workspace/BDDDesktopUIAutomation/src/main/java/utility/test.yaml";
			String path ="/src/BDDDesktopUIAutomation/src/main/java/utility/test.yaml";
			try {
				map = yamlLib.yamlRead(path);
				 System.out.println("Path of the config"+map.get("path_config"));
				 driver = applaunchLib.appLaunch(map.get("path_config"),map.get("app_id"));
			  
				
			} catch(MalformedURLException e) {
			     e.printStackTrace();
			     System.out.println("Error Cause is:- "+e.getCause());
				 System.out.println("Error Message is:- "+e.getMessage());
				 e.printStackTrace();
			}
			
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		
		/**************************************************************************
		 * Function Name  : getElementfromDb
		 * 
		 * parameters	  : which screen, which element and element name, These details
		 * 					provided in mongodb document
		 * 				    usage:  whichscreen - String - "loginscreen"
		 * 							whichelement- String - "Button"
		 * 							element name- String - "Login"
		 * Return Type	  : String - Returns the element which is a string from JSON document
		 * 
		 * Description    : This function will get the element name on a specific screen
		 * 					from mongodb and returns as a string to the caller                  				
		 * 				
		 *************************************************************************/		
		public String getElementfromDb(String whichscreen, String whichelement, String elementname)throws FileNotFoundException, IOException, ParseException {
			
			DB db = (DB) dbUtils.dbGetDatabase("172.17.0.3", 27017, "Automation_Desktop_DB");
			//DB db = (DB) dbUtils.dbGetDatabase("localhost", 27017, "Automation_Desktop_DB");
			document = dbUtils.dbGetDoument(db,"MedicalStore",1, "/src/BDDDesktopUIAutomation/src/main/java/utility/json_array_output.json");
			//document = dbUtils.dbGetDoument(db,"MedicalStore",1, "/home/1972001/eclipse-workspace/BDDDesktopUIAutomation/src/main/java/utility/json_array_output.json");
			System.out.println("Text from doc: "+document);
			//String documentpath= "/home/1972001/eclipse-workspace/BDDDesktopUIAutomation/src/main/java/utility/json_array_output.json";
			String text = dbUtils.dbGetElement(document, whichscreen, whichelement , elementname);
			//String text = dbUtils.dbGetElement(document,"Homescreen", "Button", "admin_textbox");
			System.out.println("Text value is : "+text);
			return text;
			
				
			}
			
		/**************************************************************************
		 * Function Name  : findElementUsingOptions
		 * 
		 * parameters	  : String text and options - Text is the element to be passed to driver
		 * 					and options can be name/ID/Xpath/Classname
		 * 				    usage:  text   - String - "Login"
		 * 							options- String - "name"
		 * 							
		 * Return Type	  : Boolean- Returns True or False to caller
		 * 
		 * Description    : This function will click on the element specifed buy the user
		 * 					depending on the option if its name/ID/Xpath/Classname                  				
		 * 				
		 *************************************************************************/	
		public boolean findElementUsingOptions(String text, String options) throws TimeoutException {
			
			try 
			{	
				WebDriverWait wait = this.waitFunction();
				
				switch(options) {
				
				case "name":
				
				wait.until(ExpectedConditions.elementToBeClickable(By.name((text))));
				WebElement click_element = driver.findElementByName(text);
				click_element.click();
				break;
							
				
				case "classname":
				//wait.until(ExpectedConditions.elementToBeClickable(By.className((text))));
				WebElement click_element1 = driver.findElementByClassName(text);
				click_element1.click();
				break;
				
				
				case "xpath":
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath((text))));
				WebElement click_element2 =driver.findElementByXPath(text);
				click_element2.click();
				
				case "id":
				//wait.until(ExpectedConditions.elementToBeClickable(By.id((text))));
				WebElement click_element3 =driver.findElementById(text);
				click_element3.click();
				break;
				}
				return true;
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
			
			
		}
		
		/**************************************************************************
		 * Function Name  : sendKeystoTextbox
		 * 
		 * parameters	  : String text and options and Keystosend- Text is the element to be passed to driver
		 * 					and options can be name/ID/Xpath/Classname, Keystosend is the text to input in the textbox
		 * 				    usage:  text      - String - "Login"
		 * 							options   - String - "name"
		 *                          Keystosend- String - "<texttoinput>"
		 * 							
		 * Return Type	  : Boolean- Returns True or False to caller
		 * 
		 * Description    : This function will click on the element specifed buy the user
		 * 					depending on the option if its name/ID/Xpath/Classname and input the text                 				
		 * 				
		 *************************************************************************/	
public boolean sendKeystoTextbox(String text, String options, String Keystosend) throws TimeoutException{
			
			try 
			{	
				
				switch(options) {
				case "name":
				//wait.until(ExpectedConditions.elementToBeClickable(By.name((text))));
				
				WebElement click_element1 =driver.findElementByName(text);
				click_element1.sendKeys(Keystosend);
				break;
				
				
				case "classname":
				//wait.until(ExpectedConditions.elementToBeClickable(By.className((text))));
				WebElement click_element2 =driver.findElementByClassName(text);
				click_element2.sendKeys(Keystosend);
				break;
				
				
				case "xpath":
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath((text))));
				WebElement click_element3 =driver.findElementByXPath(text);
				click_element3.sendKeys(Keystosend);
				break;
				
				
				case "id":
				//wait.until(ExpectedConditions.elementToBeClickable(By.id((text))));
				WebElement click_element4 = driver.findElementById(text);
				click_element4.sendKeys(Keystosend);
				break;
				
				}
				return true;
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
}
/**************************************************************************
 * Function Name  : sendKeysKeyboardTAB
 * 
 * parameters	  : String text and options and Keystosend- Text is the element to be passed to driver
 * 					and options can be name/ID/Xpath/Classname
 * 				    usage:  text      - String - "Login"
 * 							options   - String - "name"
 *                          
 * 							
 * Return Type	  : Boolean- Returns True or False to caller
 * 
 * Description    : This function will click on the element specifed buy the user
 * 					depending on the option if its name/ID/Xpath/Classname  and performs TAB option                				
 * 				
 *************************************************************************/
public boolean sendKeysKeyboardTAB(String text, String options) throws TimeoutException{
	
	try 
	{	
		
		switch(options) {
		case "name":
		//wait.until(ExpectedConditions.elementToBeClickable(By.name((text))));
		
		WebElement clickelement1 = driver.findElementByName(text);
		clickelement1.sendKeys(Keys.TAB);
		break;
		
		
		case "classname":
		//wait.until(ExpectedConditions.elementToBeClickable(By.className((text))));
		WebElement clickelement2 = driver.findElementByClassName(text);
		clickelement2.sendKeys(Keys.TAB);
		break;
		
		
		case "xpath":
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath((text))));
		WebElement clickelement3 = driver.findElementByXPath(text);
		clickelement3.sendKeys(Keys.TAB);
		break;
		
		
		case "id":
		//wait.until(ExpectedConditions.elementToBeClickable(By.id((text))));
		WebElement clickelement4 = driver.findElementById(text);
		clickelement4.sendKeys(Keys.TAB);
		break;
		}
		return true;
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
}

/**************************************************************************
 * Function Name  : sendKeysKeyboardEnter
 * 
 * parameters	  : String text and options and Keystosend- Text is the element to be passed to driver
 * 					and options can be name/ID/Xpath/Classname
 * 				    usage:  text      - String - "Login"
 * 							options   - String - "name"
 *                          
 * 							
 * Return Type	  : Boolean- Returns True or False to caller
 * 
 * Description    : This function will click on the element specifed buy the user
 * 					depending on the option if its name/ID/Xpath/Classname  and performs ENTER option                				
 * 				
 *************************************************************************/
public boolean sendKeysKeyboardEnter(String text, String options) throws TimeoutException{
	
	try 
	{	
		
		switch(options) {
		case "name":
		//wait.until(ExpectedConditions.elementToBeClickable(By.name((text))));
		
		WebElement element1= driver.findElementByName(text);
		element1.sendKeys(Keys.ENTER);
		break;
		
		
		case "classname":
		//wait.until(ExpectedConditions.elementToBeClickable(By.className((text))));
	    WebElement element2= driver.findElementByClassName(text);
	    element2.sendKeys(Keys.ENTER);
	    break;
		
		
		case "xpath":
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath((text))));
		WebElement element3= driver.findElementByXPath(text);
		element3.sendKeys(Keys.ENTER);
		break;
		
		case "id":
		//wait.until(ExpectedConditions.elementToBeClickable(By.id((text))));
	    WebElement element4= driver.findElementById(text);
	    element4.sendKeys(Keys.ENTER);
	    break;
		
		}
		return true;
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
}

/**************************************************************************
 * Function Name  : getAttribute
 * 
 * parameters	  : String text and options and Keystosend- Text is the element to be passed to driver
 * 					and options can be name/ID/Xpath/Classname, Att_name - Attribute
 * 				    usage:  text      - String - "Login"
 * 							options   - String - "name"
 * 							Att_name  - String - "LegacyName"
 *                          
 * 							
 * Return Type	  : String
 * 
 * Description    : This function will return the string of the specific attribute as per the call from user               				
 * 				
 *************************************************************************/

public String getAttribute(String text, String options, String Att_opt) throws TimeoutException{
	String result="";
	try 
	{		
		
		switch(options) {
		case "name":
		//wait.until(ExpectedConditions.elementToBeClickable(By.name((text))));
		
		result =((WebElement) driver.findElementByName(text)).getAttribute(Att_opt).toString();
		break;
		
		case "classname":
		//wait.until(ExpectedConditions.elementToBeClickable(By.className((text))));
		result =((WebElement)driver.findElementByClassName(text)).getAttribute(Att_opt).toString();
		break;
		
		case "xpath":
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath((text))));
		result =((WebElement)driver.findElementByXPath(text)).getAttribute(Att_opt).toString();
		break;
		
		case "id":
		//wait.until(ExpectedConditions.elementToBeClickable(By.id((text))));
		result =((WebElement) driver.findElementById(text)).getAttribute(Att_opt).toString();
		break;
		}
		return result;
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return result;
		
	}
}

/**************************************************************************
 * Function Name  : CheckifanElementisEnabled
 * 
 * parameters	  : String text and options and Keystosend- Text is the element to be passed to driver
 * 					and options can be name/ID/Xpath/Classname
 * 				    usage:  text      - String - "Login"
 * 							options   - String - "name"
 * 							                          
 * 							
 * Return Type	  : String
 * 
 * Description    : This function will return the True or False as per IsEnabled parameter               				
 * 				
 *************************************************************************/

public String CheckifanElementisEnabled(String text, String options) throws TimeoutException{
	String result="";
	try 
	{		
		
		switch(options) {
		case "name":
		//wait.until(ExpectedConditions.elementToBeClickable(By.name((text))));
		
		result =((WebElement) driver.findElementByName(text)).getAttribute("IsEnabled").toString();
		break;
		
		case "classname":
		//wait.until(ExpectedConditions.elementToBeClickable(By.className((text))));
		result =((WebElement)driver.findElementByClassName(text)).getAttribute("IsEnabled").toString();
		break;
		
		case "xpath":
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath((text))));
		result =((WebElement)driver.findElementByXPath(text)).getAttribute("IsEnabled").toString();
		break;
		
		case "id":
		//wait.until(ExpectedConditions.elementToBeClickable(By.id((text))));
		result =((WebElement) driver.findElementById(text)).getAttribute("IsEnabled").toString();
		break;
		}
		return result;
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return result;
		
	}}

/**************************************************************************
 * Function Name  : findLastchildelement
 * 
 * parameters	  : xpath of the variable
 * 							                          
 * 							
 * Return Type	  : String
 * 
 * Description    : This function will return the lastchild of the element passed               				
 * 				
 *************************************************************************/
	public  String findLastchildelement(String text){
		String Lastchild="";
		try {
					
		List<WebElement> parentele =driver.findElementsByXPath(text);
		int Listsize = parentele.size()-1;
		Lastchild = parentele.get(Listsize).getAttribute("LegacyName").toString();
		System.out.println("The Lastchild is "+Lastchild);
		return Lastchild;	
	}
		catch(Exception e)
		{
			e.printStackTrace();
			
			
		}
		return Lastchild;
		}
	
	/**************************************************************************
	 * Function Name  : findAllchildelement
	 * 
	 * parameters	  : xpath of the variable
	 * 							                          
	 * 							
	 * Return Type	  : String
	 * 
	 * Description    : This function will return the list of children of an element               				
	 * 				
	 *************************************************************************/
		public  List<String> findAllchildelements(String Xpathvariable){
			List<String> Allchildren = new ArrayList<>();
			try {
						
			List<WebElement> parentele =driver.findElementsByXPath(Xpathvariable);
							
			
			for (int i =0; i<parentele.size();i++) {
				String textField = parentele.get(i).getAttribute("LegacyName").toString();
				Allchildren.add(textField);
						
			}
			System.out.println("The list is "+Allchildren);
		}
			catch(Exception e)
			{
				e.printStackTrace();
				
				
			}
			return Allchildren;
			}
		
		/**************************************************************************
		 * Function Name  : findLastchildelement
		 * 
		 * parameters	  : xpath of the variable
		 * 							                          
		 * 							
		 * Return Type	  : String
		 * 
		 * Description    : This function will return the Firstchild of the element passed               				
		 * 				
		 *************************************************************************/
			public  String findFirstchildelement(String text){
				String Firstchild="";
				try {
							
				List<WebElement> parentele =driver.findElementsByXPath(text);
				int Listsize = parentele.size()-1;
				Firstchild = parentele.get(0).getAttribute("LegacyName").toString();
				System.out.println("The Lastchild is "+Firstchild);
					
			}
				catch(Exception e)
				{
					e.printStackTrace();
					
					
				}
				return Firstchild;
				}
			

			/**************************************************************************
			 * Function Name  : getLastrowfromViewClientTable
			 * 
			 * parameters	  : Firstchild parameter of String type
			 * 							                          
			 * 							
			 * Return Type	  : String
			 * 
			 * Description    : This function will return the last appended row content               				
			 * 				
			 *************************************************************************/
				public  String getrowfromtable(String Firstchild){
					String finalstr = "";
					try {
						String[] arrOfStr = Firstchild.split(" ");
					    String Newstring = arrOfStr[1];
					    int rownumber=Integer.parseInt(Newstring)-1;  
					    String name      =   "CU_Name"       + " Row " + rownumber;
					    String surname   =   "CU_Surname"    + " Row " + rownumber;
					    String address   =   "CU_Address"    + " Row " + rownumber;
					    String mobile    =   "CU_Mobile_No"  + " Row " + rownumber;
					    String city      =   "CU_City"       + " Row " + rownumber;
					    List<String> iteratable = new ArrayList<>();
					    iteratable.add(name);
					    iteratable.add(surname);
					    iteratable.add(address);
					    iteratable.add(mobile);
					    iteratable.add(city);
					    
					    for (int i=0; i<iteratable.size(); i++) {
					    	WebElement ele1 = (WebElement) driver.findElementByName(iteratable.get(i));
					    	String textField = ele1.getAttribute("LegacyValue").toString();
					    	finalstr = finalstr + textField +" ";
					    }
								
					
						
				}
					catch(Exception e)
					{
						e.printStackTrace();
						
						
					}
					return finalstr;
					
					}
		
}
