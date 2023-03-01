package Test_Scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import helper.BrowseFactory;
import Library.ExcelDataConfig;
import amazon.page.amazon_page;

public class AmazonTest{
	
	//Read data from Excel sheet
	ExcelDataConfig excel = new ExcelDataConfig();
			
	 //This will launch browser to the given url
	WebDriver driver = BrowseFactory.start_Browser("chrome", "https://www.google.com/");
			
	//Create Page Object using Page factory
	amazon_page Amazon = PageFactory.initElements(driver, amazon_page.class);
	
	@Test
	public void GoogleSearch() throws InterruptedException, Exception
	{
		
		//Call method
		Amazon.Search(excel.getData(0, 1, 0));
		Amazon.Amazon_In_Search(excel.getData(0, 2, 0));
		Amazon.Signin_Amz(excel.getData(0, 1, 2), excel.getData(0, 1, 3));
		Amazon.Create_Wish_List();
		Amazon.Amazon_Test(	excel.getData(0, 3, 0), excel.getintData(0, 1, 1), excel.getintData(0, 2, 1));
		Amazon.Validate_Test();
		Amazon.Product();
	}
	
	
	
	

}
