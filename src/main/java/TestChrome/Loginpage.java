package TestChrome;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Loginbasepage;



public class Loginpage extends BasePage{
	
	
	@Test
	public void logintest() throws IOException {
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		Loginbasepage lbpage=new Loginbasepage(driver);
		
		lbpage.clickSignin();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lbpage.setUsername(Username);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lbpage.setPwd(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lbpage.clickSubmit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		
		if(driver.getTitle().equals("Book My Furniture - QA(2.3.2)-Final"))
		{
			capturescreenshot(driver,"logintest");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	
	}
	}

