package amazon.page;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazon_page {
	
WebDriver driver;
	
	public amazon_page(WebDriver ldriver)
	{
		this.driver = ldriver;

	}
	//LOCATORS//
	
	//Google search of amazon 
	@FindBy(xpath="//input[@title='Search']")
	WebElement GoogleSearch;
	@FindBy(xpath="(//input[@value=\"Google Search\"])[2]")
	WebElement Enter;
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement GoogleSearch2;
	@FindBy(xpath="(//cite[@class='iUh30 tjvcx'])[1]")
	WebElement AmazonInLink;
	
	//Amazon Signin 
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
    WebElement Sign_In;
	
	@FindBy(xpath="//input[@id='ap_email']")
    WebElement Email;
	
	@FindBy(xpath="//input[@id='continue']")
    WebElement Continue;
	
	@FindBy(xpath="//input[@id='ap_password']")
    WebElement Password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
    WebElement Signin;
	
	//OTP is manually added as Twilio is not working
	@FindBy(xpath="//input[@id='auth-signin-button']")
	WebElement Signinotp;
	
	//Searching for products
	@FindBy(xpath="(//span[contains(text(), 'All')])[2]")
    WebElement All_Search;
	
	@FindBy(xpath="//div[contains(text(),'TV, Appliances, Electronics')]")
    WebElement Electronics;
	
	@FindBy(xpath="(//a[contains(text(),'All Electronics')])[2]")
    WebElement All_Electronics;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
    WebElement Search_Bar;
	
	@FindBy(xpath="//input[@id='low-price']")
    WebElement Min_Price;
	
	@FindBy(xpath="//input[@id='high-price']")
    WebElement Max_Price;
	
	@FindBy(xpath="//input[@class='a-button-input']")
    WebElement Go;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    WebElement GoProd;
	
	@FindBy(xpath="//a[@aria-label='Go to page 2']")
    WebElement Page2;
	
	@FindBy(xpath="//span[@aria-label='Current page, page 1']")
    WebElement Page1;
	
	
	
	
	
	//create new wish list
	@FindBy(xpath="//span[contains(text(),'Create a Wish List')]")
    WebElement Wish;
	
	@FindBy(xpath="(//span[@class='a-button-inner'])[1]")
    WebElement Createlist;
	
	@FindBy(xpath="(//span[@class='a-button-inner'])[9]")
    WebElement Createlist2;
	
	//Add item into wishlist
	@FindBy(xpath="//span[@id='wishListMainButton']")
    WebElement addwish;
    
    @FindBy(xpath="//span[@id='huc-view-your-list-button']")
    WebElement viewwish;
    
    @FindBy(xpath="(//h2[@class='a-size-base'])[1]")
    WebElement validateitem;
    
	
	
	//Methods//
	
	//Searching for amazon in google search and print all the search results 
	public void Search(String Googleinput) throws InterruptedException
	{
		Thread.sleep(5000);
		GoogleSearch.sendKeys(Googleinput);
		Thread.sleep(5000);
		GoogleSearch.sendKeys(Keys.RETURN);
		Thread.sleep(5000);
		List<WebElement> searchResults = driver.findElements(By.xpath("//cite[@class]"));
		for (WebElement result : searchResults) {
	 System.out.println(result.getText());
	}
		
	}
	//Searching Amazon in in search result for login into Amazon.in
	public void Amazon_In_Search(String Googleinput2) throws InterruptedException
	{
		Thread.sleep(3000);
		GoogleSearch2.clear();
		GoogleSearch2.sendKeys(Googleinput2);
		Thread.sleep(6000);
		GoogleSearch2.sendKeys(Keys.RETURN);
		Thread.sleep(10000);
		AmazonInLink.click();
		Thread.sleep(3000);

	}
	//Sign in to amazon
	public void Signin_Amz(String email, String pass) throws InterruptedException
	{
		
		Thread.sleep(7000);
		Sign_In.click();
        Thread.sleep(5000);
        Email.sendKeys(email);
        Thread.sleep(2000);
        Continue.click();
        Thread.sleep(5000);
        Password.sendKeys(pass);
        Signin.click();
        Thread.sleep(20000);
		Signinotp.click();
        Thread.sleep(7000);
        
     }
   //Creating new wish list 
	public void Create_Wish_List() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement elementToHover = driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));
		actions.moveToElement(elementToHover).build().perform();
		Thread.sleep(2000);
        Wish.click();
        Thread.sleep(5000);
       // JavascriptExecutor jse = (JavascriptExecutor) driver;
	  //  jse.executeScript("arguments[0].click();", Createlist);
	  //  Thread.sleep(5000);
        Createlist.click();
        Thread.sleep(8000);
        Createlist2.click();
        Thread.sleep(5000);
    }

  //Search by going into All electronics and dell computers and filter for 30000 to 50000 products
	public void Amazon_Test(String input, int MinValue, int MaxValue) throws InterruptedException
	{
	    Thread.sleep(5000);
		All_Search.click();
		Thread.sleep(3000);
		Electronics.click();
		Thread.sleep(3000);
		All_Electronics.click();
		Thread.sleep(3000);
		Search_Bar.sendKeys(input);
		Thread.sleep(3000);
		Search_Bar.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		String Min = Integer.toString(MinValue);
		Min_Price.sendKeys(Min);
		Thread.sleep(3000);
		String Max = Integer.toString(MaxValue);
		Max_Price.sendKeys(Max);
		Thread.sleep(3000);
		Go.click();
		Thread.sleep(8000);

		
	}
	//Searching and validate all the  products of 30000 to 50000  
		public void Validate_Test() throws InterruptedException
	{
	
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='a-price-whole']")); 
		for (WebElement result : elements) {
		System.out.println(result.getText());
		String value = result.getText();
		float price = Float.parseFloat(value.replaceAll(",", "").toString());
		Assert.assertTrue(30000 <= price && price <= 50000);
		System.out.println("products are in the range of 30k to 50k");
		
		}
		Page2.click();
		Thread.sleep(5000);
		List<WebElement> elements2 =driver.findElements(By.xpath("//span[@class='a-price-whole']")); 
		for (WebElement result2 : elements2) {
		System.out.println(result2.getText());
		String value = result2.getText();
		float price = Float.parseFloat(value.replaceAll(",", "").toString());
		Assert.assertTrue(30000 <= price && price <= 50000);
		System.out.println("products are in the range of 30k to 50k");
		}

	}
		public void Product() throws InterruptedException
		{
			
		//Printing all products name which have rating 5 out of 5 
			String amz = null;
			float stars;
			int count = 1;
	    //Scraping all the product's div
			List<WebElement> products = driver.findElements(By.xpath("//div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']"));
				for (WebElement prodresult : products) 
			{
				System.out.println("Rating is:");
		//Scraping all the ratings of products 
				WebElement rating = driver.findElement(By.xpath("(//span[@class='a-size-base'])["+count+"]"));
		//converting string into int and print the ratings 
				String rat = rating.getText();
				stars = Float.parseFloat(rat.toString());
				int ratingvalue = (int) stars;
				System.out.println(stars);
        //If the rating of product is 5 then print there names 
				if(ratingvalue==5)
				{
					WebElement prodname = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])["+count+"]"));
					System.out.println("The product name is:" + prodname.getText());
					amz = prodname.getText();

				}
				
				count++;
				if(count==19)
				{
					count=1;
					break;
				}
					
			}
				Page1.click();
				List<WebElement> products2 = driver.findElements(By.xpath("//div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 sg-col-12-of-24 s-list-col-right']"));
				for (WebElement prodresult : products2) 
			{
				System.out.println("Rating is:");
		//Scraping all the ratings of products 
				WebElement rating = driver.findElement(By.xpath("(//span[@class='a-size-base'])["+count+"]"));
		//converting string into int and print the ratings 
				String rat = rating.getText();
				stars = Float.parseFloat(rat.toString());
				int ratingvalue = (int) stars;
				System.out.println(stars);
        //If the rating of product is 5 then print there names 
				if(ratingvalue==5)
				{
					WebElement prodname = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])["+count+"]"));
					System.out.println("The product name is:" + prodname.getText());
					amz = prodname.getText();

				}
				
				count++;
				if(count==19)
				{
					count=1;
					break;
				}
					
			}
				
				
			
			//Clearing the search bar of amazon
			Thread.sleep(3000);
			Search_Bar.clear();
			Search_Bar.sendKeys(amz);
			Thread.sleep(3000);
			Search_Bar.sendKeys(Keys.RETURN);
			String currentHandle= driver.getWindowHandle();
			GoProd.click();
			Thread.sleep(8000);
		//Switch to new window and add the first 5 star rating product into wishlist
			Set<String> handles=driver.getWindowHandles();
			for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
			driver.switchTo().window(actual); 
			Thread.sleep(4000);
			addwish.click();
			Thread.sleep(4000);
			viewwish.click();
			Thread.sleep(5000);
			String item = validateitem.getText();
			Assert.assertEquals(amz,item);
	        System.out.println("product is added in the wish list");
			}
			
			}
			
		}
		
		
	
	
		
			
			
		
}

