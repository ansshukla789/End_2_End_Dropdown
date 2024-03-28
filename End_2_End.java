package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class End_2_End {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anshul\\Downloads\\chromedriver-win32\\chromedriver.exe");// Setting Location of Web Driver 
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    //Auto -Suggestive Dropdown----->
	    driver.findElement(By.id("autosuggest")).sendKeys("In");
	    Thread.sleep(5000);
	  //List<WebElement> options= driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));
	    List<WebElement> options= driver.findElements(By.xpath("//a[@class='ui-corner-all']")); //used findElements in order to get List of Elements in web page and Store them in a List.
	   //Thread.sleep(5000);
	   //System.out.println(options.);
	     for(WebElement op:options) //Used For Each Loop in Order to itterate over every option
	       { 
		     System.out.println(op.getText());
		       if(op.getText().equalsIgnoreCase("India")) //Compare the text
		          {
			        op.click(); //click on text
			        break;      //Break the Loop after you get a option
		      
		          }  
	       }
	     //Dynamic Dropdown
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	    driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click(); /* Parent to Child relationship xpath */
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();
        // Select Check Box
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        //Select dates from calendar
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
	    Thread.sleep(3000);
	    //driver.findElement(By.xpath("(//a[@class='ui-state-default'])[5]")).click();  //selection of future date by (Xpath)[index] locator.
	    driver.findElement(By.linkText("29")).click(); 
	    // selecting radio button
	    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	    //dropdown with looping
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // Printing the text before clicking
	    driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(5000);
	    int i=0;
	    while(i<2)  //2 clicks
	    {
	    driver.findElement(By.id("hrefIncAdt")).click();
	    i++;
	    }
	    for(int a=0; a<2;a++)//2 clicks
	    {
	    driver.findElement(By.id("hrefIncChd")).click();
	    }
	    for(int b=0;b<2;b++) //2 clicks
	    {
	    driver.findElement(By.id("hrefIncInf")).click();
	    }
	    driver.findElement(By.id("btnclosepaxoption")).click();
	   System.out.println( driver.findElement(By.id("divpaxinfo")).getText()); 
	   //Static Dropdown
	   WebElement Staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //Giving the location of Dropdown in WebElement.
	    Select dropdown=new Select(Staticdropdown);//Create a object of select class in order to access the method present in that class.
	    dropdown.selectByIndex(2); //Accessing Method Present in that class.
	   System.out.println( dropdown.getFirstSelectedOption().getText());
	   dropdown.selectByVisibleText("USD");
	   System.out.println( dropdown.getFirstSelectedOption().getText());
	   dropdown.selectByValue("INR");
	   System.out.println( dropdown.getFirstSelectedOption().getText()); 
	   //Click on Search Button
	   driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	    
	

	}

}
