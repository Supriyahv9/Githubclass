package Module;

import java.io.File;


import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtils;
import CommonUtils.Listenerimplementation;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;


@Listeners(Listenerimplementation.class)
public class CreateContactModule extends BaseClass  {

	
		
	
	PropertyFileUtils putils = new PropertyFileUtils();
	ExcelUtils eutils = new ExcelUtils();
	WebDriverUtils wutils = new WebDriverUtils();
	
	
	@Test
	public void CreateContact() throws EncryptedDocumentException, IOException, InterruptedException {
		
	
	
	
	//To read data from Excel
	String FIRSTNAME = eutils.getdatafromExcel("Contact", 0, 1);
	String LASTNAME = eutils.getdatafromExcel("Contact", 1, 1);
	String GROUP = eutils.getdatafromExcel("Contact", 2, 1);
	String NAME = eutils.getdatafromExcel("Contact", 3, 1);
	
		
		//Step7:Click on Contacts
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			
		//Step8:Click on +(Create contact..) icon
			driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
			
		//Step9:Enter the First name
			driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
			
		//Step10:Enter the Last name
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			
		//Step11:Click on Group radio button
			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//Step12:Select Support Group in groupdropdown
		WebElement Groupdropdown = driver.findElement(By.name("assigned_group_id"));	
		wutils.handledropdown(Groupdropdown, GROUP);
		
		
	//Step13:Click on + icon in Organization name tf
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	
//		Transfer control from Parent to child
	wutils.Switch(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
			
	//Step14:Search Organization name in search tf
		driver.findElement(By.id("search_txt")).sendKeys(NAME);
	
	//Step15:Click on search now btn
		driver.findElement(By.name("search")).click();
		
	//Step16:Click on Organization name text
		driver.findElement(By.xpath("//a[text()='Pune8']")).click();
		
		
	//Transfer control from Child to parent
		wutils.Switch(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
				
	//Step17:Enter the date in Birthdate
	driver.findElement(By.id("jscal_field_birthday")).sendKeys("2024-01-2");
	
	//Step18:Click on Save btn
	driver.findElement(By.name("button")).click();
	
	Thread.sleep(2000);
	
	//Step19:To Take screenshot of Webpage
	//wutils.totakescreenshot(driver);
	
	
	}
	
	
	}


