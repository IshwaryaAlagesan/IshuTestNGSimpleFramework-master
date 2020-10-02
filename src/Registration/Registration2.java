package Registration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Registration2 {
    public String baseUrl = "http://myrgo-preprod.ctt.co.uk/register";
    public String Ringusername = "myRingGoTest";
    public String Ringpassword = "W4t3Rf4lls";
    public String AutoURL = "http://" + Ringusername  + ":" + Ringpassword + "@" + "myrgo-preprod.ctt.co.uk/register" ;
    public String basepath = System.getProperty("user.dir");
    public String chromepath = basepath + "\\drivers\\chromedriver.exe";
    //public String driverPath = basepath + "\\drivers\\geckodriver.exe";
    
    public WebDriver driver;
    
  @BeforeClass
    public void browser(){
	  System.setProperty("webdriver.chrome.driver", chromepath); 
      driver = new ChromeDriver(); 
      driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.get(AutoURL);

  }
  @AfterClass
  public void closebrowser() {
	  driver.close();
	  driver.quit();
  }
  @Test
  public void verifyHomepageTitle() {
	  //System.out.println("DriverPath:"+driverPath);
//      try {
	  System.out.println("launching Chrome browser"); 
	  System.out.println("AutoURL ::" + AutoURL);
//      System.setProperty("webdriver.chrome.driver", chromepath);
//      driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();

      String actualTitle = driver.getTitle();
      String expectedTitle = "RingGo Cashless Parking Solution: Register for a RingGo account";
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.findElement(By.xpath("//h1[contains(text(),'Register for a RingGo account')]"));
//      } catch (InterruptedException e) {
		// TODO Auto-generated catch block
//    	  System.out.println("Error catch happened here...");
//		System.out.println(e);
//	}

  }
  @Test
  public void verifyMobileNumber() {
      driver.findElement(By.xpath("//input[@id='field-Member_CLI']")).sendKeys("0123456789");
      
      

  }
}