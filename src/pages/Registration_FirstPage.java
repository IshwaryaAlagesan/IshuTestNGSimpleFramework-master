package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Registration_FirstPage {

	WebDriver driver;

	/// Register Landing Page Fields
    By mobilenumberText = By.xpath("//input[@id='field-Member_CLI']");
    By mobilenumberValidationLabel = By.xpath("//span[@id='climsgbox']");
    By emailaddressText = By.xpath("//input[@id='field-Member_Email']");
    By emailaddressValidationLabel = By.xpath("//span[@id='emailmsgbox']");
    By passwordText = By.xpath("//input[@id='field-MemberPassword']");
    By passwordValidationLabel = By.xpath("//span[@class='error']");
    By agreeCheckBox = By.xpath("//input[@name='terms']");
    By nextBtn = By.xpath("//input[@id='labyrinth_UserDetails_next']");
    By finishBtn=By.xpath("//input[@id='labyrinth_finish']");
    By updateyourName=By.xpath("//a[contains(text(),'Please update your name')]");
    By updatePayment=By.xpath("//div[@class='widget']//div//a[contains(text(),'Please update your payment details')]");
    By updateVachicledetails=By.xpath("//a[contains(text(),'Please update your vehicle details')]");
    By myaccount =By.xpath("//a[contains(text(),'My Account')]");
   
   /// Contact Page Fields
	By TittleSelect=By.xpath("//select[@id='field-Member_Title']");
	By firstName=By.xpath("//input[@id='field-Member_Firstname']");
	By LastName=By.xpath("//input[@id='field-Member_Lastname']");
	By confirmMailId=By.xpath("//input[@id='field-Member_Email_Confirm']");
	By SaveBtn=By.xpath("//input[@name='submits[submit]']");

	/// Payment Page Fields
	 By addNewcard =By.xpath("//a[@class='gp-card-trigger gp-no-auto-close']");
	 By cardNumber= By.xpath("//input[@placeholder='Enter card number']");
	 By startDate=By.xpath("//div[3]//label[1]//input[1]");
	 By endDate=By.xpath("//div[4]//label[1]//input[1]");
	 By clickaddCardBtn =By.xpath("//button[@id='addCardBtn']");
	 
	 /// Vehicle Page Fields
	By addVachicle =By.xpath("//a[@class='ringgo-tooltip']");
	By NumberPlate=By.xpath("//input[@id='field-VRN']");
	By ChooseColor=By.xpath("//select[@id='field-Colour']");
	By MakeCar=By.xpath("//select[@id='field-Make']");
	By CarType=By.xpath("//select[@id='field-TypeShow']");
	By OwnerShip=By.xpath("//select[@id='field-OwnershipId']");
	By vehicleSaveBtn=By.xpath("//input[@name='submits[submit]']");
   
    public Registration_FirstPage(WebDriver driver){
        this.driver = driver;
    }

    //Set user name in text box
    public void setTextonMobileNumberText( String strTexttoType) throws Exception{
        driver.findElement(mobilenumberText).clear();
        driver.findElement(mobilenumberText).sendKeys(strTexttoType);
        driver.findElement(mobilenumberText).sendKeys(Keys.TAB);
        Thread.sleep(1000);
    }
    
    public void checkMobileNumberValidation( String expectedMsg ){
    	String actualMsg = driver.findElement(mobilenumberValidationLabel).getText();
	    Assert.assertEquals(actualMsg, expectedMsg);
    }    
    // Set Mail id in textbox
    public void setemailaddressText(String strMailID) throws Exception{
    	driver.findElement(emailaddressText).clear();
    	driver.findElement(emailaddressText).sendKeys(strMailID);
    	driver.findElement(emailaddressText).sendKeys(Keys.TAB);
    	Thread.sleep(1000);
    }

    // Validate Email address validation msg box
    public void checkEmailValidation(String expectedMsg){
    	String actualMsg = driver.findElement(emailaddressValidationLabel).getText();
	    Assert.assertEquals(actualMsg, expectedMsg);
    }        
    
    //Set password in password textbox
    public void setPassword(String strPassword) throws Exception{
    	driver.findElement(passwordText).clear();
    	driver.findElement(passwordText).sendKeys(strPassword);
    	driver.findElement(passwordText).sendKeys(Keys.TAB);
    	Thread.sleep(2000);
    }
    // Validate password validation msg box
    public void checkPasswordFieldValidation(String expectedMsg) throws Exception{
    	String actualMsg = driver.findElement(passwordValidationLabel).getText();
	    Assert.assertEquals(actualMsg, expectedMsg);
    }      
    
    //terms and condition
   public void checkTermsandCondition() throws Exception {
	   driver.findElement(agreeCheckBox).click();
	   Thread.sleep(1000);
   }
public void nextButton() throws Exception {
	driver.findElement(nextBtn).click();
	Thread.sleep(1000);
}
public void FinishButton() throws Exception {
	  driver.findElement(finishBtn).click();
	  Thread.sleep(1000);
}
public void updateyourNameLink() throws Exception {
driver.findElement(updateyourName).click();
Thread.sleep(1000);

}
public void updateyourPaymentDetails() throws Exception {
driver.findElement(updatePayment).click();
Thread.sleep(1000);

}
public void updateVechicleDetails() throws Exception {
driver.findElement(updateVachicledetails).click();
Thread.sleep(1000);
}
public void clickMyaccount() throws Exception {
	Thread.sleep(1000);
driver.findElement(myaccount).click();
Thread.sleep(1000);
}

///// Contact Page Functions
public void contactPage_selectTitle(String title) throws Exception {
	Thread.sleep(1000);
	Select MemberTittle=new Select(driver.findElement(TittleSelect));
	MemberTittle.selectByVisibleText(title);
//	driver.findElement(TittleSelect).sendKeys("Mr");
  Thread.sleep(1000);
}
public void contactPage_EnterFirstName(String name) throws Exception {
	 driver.findElement(firstName).sendKeys(name);
	  Thread.sleep(1000);
	}
public void contactPage_EnterLastName(String name) throws Exception {
	 driver.findElement(LastName).sendKeys(name);
	  Thread.sleep(1000);

	}	
public void contactPage_confirmmailId(String mail) throws Exception {
	driver.findElement(confirmMailId).sendKeys(mail);
	  Thread.sleep(1000);

}
public void contactPage_saveBtn() throws Exception {
	Thread.sleep(1000);
	driver.findElement(SaveBtn).click();
	  Thread.sleep(1000);
}


//// Payment Page Functions
public void Paymentpage_addNewCard() throws Exception {
	 driver.findElement(addNewcard).click();
	  Thread.sleep(1000);
}
public void Paymentpage_CardDetails(String number) throws Exception {
	 driver.findElement(cardNumber).sendKeys(number);
	  Thread.sleep(1000);
}
public void Paymentpage_Startdate(String number) throws Exception {
	 driver.findElement(startDate).sendKeys(number);
	  Thread.sleep(1000);	  
}
public void Paymentpage_ExpireDate(String number) throws Exception {
	 driver.findElement(endDate).sendKeys(number);
	  Thread.sleep(1000);
}
public void Paymentpage_AddCard() throws Exception {
	 driver.findElement(clickaddCardBtn).click();
	  Thread.sleep(1000);	  
}


/// Vehicle Page Functions
public void VehiclePage_addVechicle() throws Exception{
	driver.findElement(addVachicle).click();
	Thread.sleep(1000);
}

public void VehiclePage_NumberPlate(String Number)  throws Exception{
	driver.findElement(NumberPlate).sendKeys(Number);
	Thread.sleep(1000);
}

public void VehiclePage_chooseColor(String colorname)  throws Exception{
	driver.findElement(ChooseColor).click();
	Select CarColor =new Select(driver.findElement(ChooseColor));
	CarColor.selectByVisibleText(colorname);
    Thread.sleep(1000);
}

public void VehiclePage_Makecar(String carname)  throws Exception{
//	driver.findElement(MakeCar).click();
	Select CarName =new Select(driver.findElement(MakeCar));
	CarName.selectByVisibleText(carname);
    Thread.sleep(1000);
}

public void VehiclePage_vechicleType(String typename)  throws Exception{
//	driver.findElement(CarType).click();
	Select vechicleTypeName =new Select(driver.findElement(CarType));
     vechicleTypeName.selectByVisibleText(typename);
   Thread.sleep(1000);
}
public void VehiclePage_Ownership(String ownershipname)  throws Exception{
//	driver.findElement(OwnerShip).click();
	Select OwnerShipName =new Select(driver.findElement(OwnerShip));
	OwnerShipName.selectByVisibleText(ownershipname);
	Thread.sleep(1000);
}
public void VehiclePage_saveBtn() throws Exception {
	Thread.sleep(1000);
	driver.findElement(SaveBtn).click();
	  Thread.sleep(3000);
}


    //Get the title of Login Page
    public String getLoginTitle(){
    	return driver.getTitle();
    }
}
