package Registration;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.*;
	import pages.Registration_FirstPage;

	public class RegistrationFirstPage {
    public String baseUrl = "http://myrgo-preprod.ctt.co.uk/register";
    public String Ringusername = "myRingGoTest";
    public String Ringpassword = "W4t3Rf4lls";
    public String AutoURL = "http://" + Ringusername  + ":" + Ringpassword + "@" + "myrgo-preprod.ctt.co.uk/register" ;
    public String basepath = System.getProperty("user.dir");
    public String chromepath = basepath + "\\drivers\\chromedriver.exe";
    
    public WebDriver driver;
    Registration_FirstPage FirstPageobj;
    
  @BeforeClass
    public void Launchbrowser(){
	  System.setProperty("webdriver.chrome.driver", chromepath); 
      driver = new ChromeDriver(); 
      driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  driver.get(AutoURL);
	  }
	  @AfterClass
	  public void closebrowser() {
		  driver.close();
		  driver.quit();
	  }
	  
	  @Test (priority=1)
	  public void FirstPage_VerifyTitle() {
		  FirstPageobj = new Registration_FirstPage(driver);
		  // Verify Page Title to make sure the Right page
		  String actualTitle = FirstPageobj.getLoginTitle();
	      String expectedTitle = "RingGo Cashless Parking Solution: Register for a RingGo account";
	      Assert.assertEquals(actualTitle, expectedTitle);
	      
	  }
	  
	  @Test (priority=2)
	  public void verifyMobileNumber_InValidNumber() throws Exception{
	      FirstPageobj.setTextonMobileNumberText("0333");
	      String expectedMsg = "Phone number is invalid";
	      FirstPageobj.checkMobileNumberValidation(expectedMsg);
	 	  }

	  @Test (priority=2)
	  public void verifyMobileNumber_AlreadyUsed() throws Exception{
		  FirstPageobj.setTextonMobileNumberText("0123456789");
	      String expectedMsg = "Number is already in use. If this is your number, please login, retrieve your PIN or reset your password .";
	      FirstPageobj.checkMobileNumberValidation(expectedMsg);
	  }
	  
	  @Test (priority=3)
	  public void verifyMobileNumber_ValidNumber() throws Exception{
	      FirstPageobj.setTextonMobileNumberText("0333456011");
	      String expectedMsg = "Number available to register";
	      FirstPageobj.checkMobileNumberValidation(expectedMsg);
	      }
	  
	  @Test (priority=4)
	  public void verifyEmail_InValid() throws Exception{
		  FirstPageobj.setemailaddressText("dummy");
	      String expectedMsg = "Email is invalid";
	      FirstPageobj.checkEmailValidation(expectedMsg);
	  }
	  
	  @Test (priority=5)
	  public void verifyEmail_Valid() throws Exception{
		  FirstPageobj.setemailaddressText("validemail11@email.com");
	      String expectedMsg = "Email available to register";
	      FirstPageobj.checkEmailValidation(expectedMsg);
	  }
	   @Test (priority=5)
	  public void verifypasswordInValid() throws Exception{
		  FirstPageobj.setPassword("Mhdushjc");
		  Thread.sleep(2000);
	      String expectedMsg = "The password does not meet the correct format.";
	      FirstPageobj.checkPasswordFieldValidation(expectedMsg);
	  }
	   @Test (priority=5)
		  public void verifypasswordValid() throws Exception{
		  FirstPageobj.setPassword("Mhdushjh11");
	  }
	    @Test (priority=6)
	   public void TermsandCondition() throws Exception {
	    	Thread.sleep(80000);
	    	FirstPageobj.checkTermsandCondition();
	   }	
		@Test(priority=7)
		public void clicknextButton() throws Exception {
			FirstPageobj.nextButton();
		}
	   @Test(priority=8)
		public void clickfinishButton() throws Exception {
				FirstPageobj.FinishButton();
			}
	   @Test(priority=9)
		public void clickupdatenameBtn() throws Exception {
			FirstPageobj.updateyourNameLink();
		}
	   @Test(priority=10)
		public void ContactPage_SelectTitle() throws Exception {
		   FirstPageobj.contactPage_selectTitle("Mr");
		}
	   @Test(priority=11)
		public void ContactPage_EnterFirstName() throws Exception {
		   FirstPageobj.contactPage_EnterFirstName("FirstName");
		}	   
	  @Test(priority=12)
	  public void contactPage_EnterLastName() throws Exception{
		  FirstPageobj.contactPage_EnterLastName("lastname");
	  }
	  @Test(priority=13)
	  public void contactPage_confirmMail() throws Exception{
		  FirstPageobj.contactPage_confirmmailId("validemail11@email.com");
	  }
	  @Test(priority=14)
	  public void contactPagc_Savebutton() throws Exception{
		  FirstPageobj.contactPage_saveBtn();
	  }
	  @Test(priority=14)
	  public void contactPage_UpdateYourPaymentlink() throws Exception{
		  FirstPageobj.updateyourPaymentDetails();
	  }	  
	  @Test(priority=15)
	  public void PaymentPage_clickNewaddcard() throws Exception{
		  FirstPageobj.Paymentpage_addNewCard();
	  }
	  @Test(priority=16)
	  public void PaymentPage_EntercardDetails() throws Exception{
		  FirstPageobj.Paymentpage_CardDetails("4929123123123127");
	  }
	  @Test(priority=17)
	  public void PaymentPage_EnterstartDate() throws Exception{
		  FirstPageobj.Paymentpage_Startdate("0110");		  
	  }
	  @Test(priority=18)
	  public void PaymentPage_EnterExpireDate() throws Exception{
		  FirstPageobj.Paymentpage_ExpireDate("1221");
	  }
	  @Test(priority=19)
	  public void PaymentPage_clickAddCard() throws Exception{
		  FirstPageobj.Paymentpage_AddCard();
	  }
	  @Test(priority=20)
	  public void PaymentPage_MyAccount() throws Exception{
		  FirstPageobj.clickMyaccount();
	  }
	  @Test(priority=21)
	  public void FirstPage_updateVechical() throws Exception{
		  FirstPageobj.updateVechicleDetails();
		  }  
	  @Test(priority=22)
	  public void VehiclePage_addVechical() throws Exception{
		  FirstPageobj.VehiclePage_addVechicle();
	  }  
	  @Test(priority=23)
	  public void VehiclePage_enterNumberPlate() throws Exception{
		  FirstPageobj.VehiclePage_NumberPlate("A34343");
	  }    
	  @Test(priority=23)
	  public void VehiclePage_selectcolor() throws Exception{
		  FirstPageobj.VehiclePage_chooseColor("Black");
	  } 
	  @Test(priority=24)
	  public void VehiclePage_selectCarName() throws Exception{
		  FirstPageobj.VehiclePage_Makecar("Audi");
	  } 
	  @Test(priority=25)
	  public void VeciclePage_selectCarName() throws Exception{
		  FirstPageobj.VehiclePage_vechicleType("Car");
	  } 
	  @Test(priority=26)
	  public void VeciclePage_onwershipType() throws Exception{
		  FirstPageobj.VehiclePage_Ownership("Private Owned Vehicle");
	  } 	  
	  @Test(priority=26)
	  public void Vehicle_saveButton() throws Exception{
		  FirstPageobj.VehiclePage_saveBtn();
	  }
	  @Test(priority=27)
	  public void VeciclePage_myaccount() throws Exception{
		  FirstPageobj.clickMyaccount();
	  } 
	
	}
	
	
	
