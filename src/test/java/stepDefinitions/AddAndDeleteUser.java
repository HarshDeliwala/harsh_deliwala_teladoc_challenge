package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AddAndDeleteUser 
{
	WebDriver driver;
	boolean status=false;
	
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}
	@Given("enter the URL")
	public void enter_the_url() {
		
		driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
	    
	}
	@When("Click on Add User button")
	public void click_on_add_user_button() {
		
		driver.findElement(By.xpath("//button[normalize-space()='Add User']")).click();
		
		
	    
	}
	@When("Enter details and save")
	public void enter_details_and_save() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("dummy");
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("user1");
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("user1");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='15']")).click();
		
		WebElement dd=driver.findElement(By.xpath("//select[@name='RoleId']"));
		Select select=new Select(dd);
		select.selectByVisibleText("Admin");
		
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("user1@yopmail.com");
		driver.findElement(By.xpath("//input[@name='Mobilephone']")).sendKeys("1234567890");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
	    
	}
	@Then("Validate if user has been added to the table")
	public void validate_if_user_has_been_added_to_the_table() {
	    
		//Find total number of rows in table 7
		int total_rows=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr")).size();
		
		//Find total number of columns in table 11
		int total_cols=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//th")).size();
		
		//boolean status=false;
		for(int r=1;r<=total_rows;r++)
		{
			String username=driver.findElement(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr["+r+"]//td[3]")).getText();
			if(username.equals("user1"))
			{
				System.out.println("User is added to the tale");
				status=true;
				
				Assert.assertTrue(true);
				break;
			}
			
			
		}
		if(status==false)
		{
			System.out.println("User Not Found");
			Assert.fail();
		}
	}
		
		
		@When("Search user with name and delete from table")
		public void search_user_with_name_and_delete_from_table() {
			
			//Find total number of rows in table 7
					boolean status1=false;
					int total_rows=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr")).size();
					
					//Find total number of columns in table 11
					int total_cols=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//th")).size();
					
					
					for(int r=1;r<=total_rows;r++)
					{
						String username=driver.findElement(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr["+r+"]//td[3]")).getText();
						if(username.equals("novak"))
						{
							
							driver.findElement(By.xpath("//tbody/tr["+r+"]/td[11]/button[1]/i[1]")).click();
							driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
							
							status1=true;
							
							Assert.assertTrue(true);
							break;
						}
						
						
					}
					if(status==false)
					{
						System.out.println("User Not Found");
						Assert.fail();
					}
		
	}

		@Then("Validate if user is deleted from the table")
		public void validate_if_user_is_deleted_from_the_table() throws InterruptedException
		{
			if(status==true)
			{
				int total_rows=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr")).size();
				
				
				boolean status2=false;
				//boolean status1=false;
				for(int r=1;r<=total_rows;r++)
				{
					String username=driver.findElement(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr["+r+"]//td[3]")).getText();
					
					if(!username.equals("novak"))
					{
						System.out.println("User is deleted from table successfully");
						status2=true;
						Assert.assertTrue(true);
						break;
					}
				}
				if(status2==false)
				{
					System.out.println("User is NOT deleted from table" );
					Assert.fail();
				}
			}
			Thread.sleep(3000);
			driver.quit();
		}

		
		
		
}
