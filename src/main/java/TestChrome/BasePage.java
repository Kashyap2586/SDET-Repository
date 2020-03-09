package TestChrome;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

public class BasePage {
	
ConfigProperties Rconfig= new ConfigProperties();
	

    public String baseUrl=Rconfig.getpageurl();
    public String Username=Rconfig.getusername();
    public String password=Rconfig.getpassword();
    public static WebDriver driver;
	//public static Logger logger ;
	
	
    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {
    	
    	if(br.equalsIgnoreCase("chrome"))
    	{
    	System.setProperty("webdriver.chromedrivr.driver",Rconfig.getchromepath());
   	    driver= new ChromeDriver();
    	}
    	else if
    	(br.equalsIgnoreCase("ie")) {
    		System.setProperty("webdriver.ie.driver",Rconfig.iepath());
       	    driver= new InternetExplorerDriver();
    		}
    	//driver.get(baseUrl);
   	    
   	    
   
   	   
    }
     public void capturescreenshot(WebDriver driver, String tname) throws IOException{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File("src\\test\\java\\resources\\screenshots\\"+"Screenshot"+tname+".png");
		//FileUtils.getFileExtension(target);
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}

	
	@AfterClass
	public void tear() {
		
		driver.quit();
		
	} 

}
