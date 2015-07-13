import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestCase  {
	
   
   public static WebDriver createChromeService(String url) throws IOException {
	     
	   ChromeDriverService service = new ChromeDriverService.Builder()
    		         .usingDriverExecutable(new File("C:/99.tmp/chromedriver.exe"))
    		         .usingAnyFreePort() .build();
    	  
	   service.start();
	   
	   WebDriver driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
	   driver.get(url);
	   
	   return driver;
   }
   
   public static WebDriver createIEService(String url) throws IOException {
	     
	   InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
    		         .usingDriverExecutable(new File("C:/99.tmp/IEDriverServer.exe"))
    		         .usingAnyFreePort() .build();
    	  
	   service.start();
	   
	   WebDriver driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.internetExplorer());
	   driver.get(url);
	   
	   return driver;
   }
   
   public static WebDriver createSafariService(String url) throws IOException {
	   
	   WebDriver driver = new SafariDriver();
	   driver.get(url);
	   
	   return driver;
   }
   
	   
   @Test
   public void testGoogleSearch() throws IOException {
	   
//	   WebDriver driver =  createChromeService("http://www.google.com");
	   WebDriver driver =  createIEService("http://www.google.com");
//	   WebDriver driver =  createSafariService("http://www.google.com");
	   
	   WebElement element = driver.findElement(By.name("q"));
	   element.sendKeys("바보");
	   //element.submit();
	   driver.findElement(By.name("btnG")).click();
     
	   // Wait for search to complete
//	   new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains("셀레늄"));
	   new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
     
	   System.out.println( driver.findElement(By.id("resultStats")).getText());
	   System.out.println( driver.findElement(By.id("resultStats")).getText().replaceAll("[^0-9]", ""));
 
	   driver.quit();
 
   }

}