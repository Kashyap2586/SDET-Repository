package Testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.*;
import org.apache.logging.*;


import TestChrome.Loginpage;

public class Loginbasepage extends Loginpage {
	
	WebDriver ldriver;
	//Logger log = Logger.getLogger("devpinoyLogger");
	
	public Loginbasepage(WebDriver rdriver){
		
		ldriver=rdriver ;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/form/button[4]/span")
	WebElement txtSignIn ;
	
	@FindBy(xpath="//*[@id=\"emailId\"]")
	WebElement txtUsername ;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement txtPassword ;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement txtSubmit ;
	
	
	public void clickSignin() {
		
		txtSignIn.click();
		//log.info("Click Sign In");
	}
    public void setUsername(String uname) {
		
		txtUsername.sendKeys(uname);
		//log.info("Click Sign In");
	}
    public void setPwd(String Password) {
		
		txtPassword.sendKeys(Password);
		//log.info("Click Sign In");
	}
    public void clickSubmit() {
		
		txtSubmit.click();
	}

}
