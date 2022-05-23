package com.StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepDefinition_UniversalClass {
	
	public static WebDriver driver;
	static Properties prop=new Properties();

@Given("User is on Browser")
public void user_is_on_browser() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\selenium-java-4.1.2\\chromedriver.exe");
	driver= new ChromeDriver();
}

@When("User enters URL in address bar")
public void user_enters_url_in_address_bar() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to(prop.getProperty("URL"));
	driver.manage().window().maximize();
}

@Then("User lands on Universal class Home Page")
public void user_lands_on_universal_class_home_page() {
	driver.quit();	
}

@Given("User is on Universal Class Page")
public void user_is_on_universal_class_page() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	System.setProperty("webdriver.chrome.driver","D:\\Selenium\\selenium-java-4.1.2\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.navigate().to(prop.getProperty("URL"));
	driver.manage().window().maximize();
	
}

@When("User clicks on more option button")
public void user_clicks_on_more_option_button() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("moreoptionButton_xpath"))).click();
}

@Then("User is able to view options like Sign in, subscribe , etc")
public void user_is_able_to_view_options_like_sign_in_subscribe_etc() {
	if(driver.findElement(By.xpath(prop.getProperty("moreoptionButton_xpath")))!= null)
	{
		System.out.println("User is able to view options like Sign in, subscribe , etc");
	}
	else
	{
		System.out.println("User is not able to view options like Sign in, subscribe , etc");
	}
	driver.quit();
}

@Then("User click on close button to close the more option list")
public void user_click_on_close_button_to_close_the_more_option_list() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("closeButton_xpath"))).click();
	driver.quit();
}
	

@Then("User click on Sign in button and Member sign in window will appears")
public void user_click_on_sign_in_button_and_member_sign_in_window_will_appears() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to("https://members.universalclass.com/login.htm");
	driver.manage().window().maximize();
	driver.quit();
}

@Then("User click on Sign in button and see two text box for email and password resp")
public void user_click_on_sign_in_button_and_see_two_text_box_for_email_and_password_resp() throws Exception {
	
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to("https://members.universalclass.com/login.htm");
	driver.manage().window().maximize();
	if(driver.findElement(By.id(prop.getProperty("email_id")))!= null)
	{
		System.out.println("Email textbox is present");
	}
	else
	{
		System.out.println("Email textbox is not present");
	}
	if(driver.findElement(By.id(prop.getProperty("password_id")))!= null)
	{
		System.out.println("password textbox is present");
	}
	else
	{
		System.out.println("password textbox is not present");
	}
	driver.quit();
}

@Then("User click on Sign in button and Enter new email for sign up")
public void user_click_on_sign_in_button_and_enter_new_email_for_sign_up() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	File g=new File("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\DataSource\\data.xlsx");
	FileInputStream is = new FileInputStream(g);
	XSSFWorkbook w = new XSSFWorkbook(is);
	XSSFSheet sheet = w.getSheetAt(0);	
	DataFormatter formatter = new DataFormatter();
	String email = formatter.formatCellValue(sheet.getRow(1).getCell(0));
	String password = formatter.formatCellValue(sheet.getRow(1).getCell(1));
	driver.navigate().to("https://members.universalclass.com/login.htm");
	driver.manage().window().maximize();
	driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(email);
	driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(password);
	driver.findElement(By.xpath(prop.getProperty("signin_xpath"))).click();
	driver.quit();
}

@Then("User click on Sign in button and Enter email and password for login")
public void user_click_on_sign_in_button_and_enter_email_and_password_for_login() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to("https://members.universalclass.com/login.htm");
	driver.manage().window().maximize();
	File g=new File("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\DataSource\\data.xlsx");
	FileInputStream is = new FileInputStream(g);
	XSSFWorkbook w = new XSSFWorkbook(is);
	XSSFSheet sheet = w.getSheetAt(0);	
	DataFormatter formatter = new DataFormatter();
	String email = formatter.formatCellValue(sheet.getRow(1).getCell(0));
	String password = formatter.formatCellValue(sheet.getRow(1).getCell(1));
	driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(email);
	driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(password);
	driver.findElement(By.xpath(prop.getProperty("signin_xpath"))).click();
	driver.quit();
}

@Then("User click on Sign in button and Enter credentials and face a double check.")
public void user_click_on_sign_in_button_and_enter_credentials_and_face_a_double_check() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to("https://members.universalclass.com/login.htm");
	driver.manage().window().maximize();
	File g=new File("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\DataSource\\data.xlsx");
	FileInputStream is = new FileInputStream(g);
	XSSFWorkbook w = new XSSFWorkbook(is);
	XSSFSheet sheet = w.getSheetAt(0);	
	DataFormatter formatter = new DataFormatter();
	String email = formatter.formatCellValue(sheet.getRow(1).getCell(0));
	String password = formatter.formatCellValue(sheet.getRow(1).getCell(1));
	driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(email);
	driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(password);
	driver.findElement(By.xpath(prop.getProperty("signin_xpath"))).click();
	Thread.sleep(2000);
	driver.quit();
}

@Then("User click on Sign in button and Enter credentials and get a tip for wrong password.")
public void user_click_on_sign_in_button_and_enter_credentials_and_get_a_tip_for_wrong_password() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to("https://members.universalclass.com/login.htm");
	driver.manage().window().maximize();
	File g=new File("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\DataSource\\data.xlsx");
	FileInputStream is = new FileInputStream(g);
	XSSFWorkbook w = new XSSFWorkbook(is);
	XSSFSheet sheet = w.getSheetAt(0);	
	DataFormatter formatter = new DataFormatter();
	String email = formatter.formatCellValue(sheet.getRow(1).getCell(0));
	String password = formatter.formatCellValue(sheet.getRow(1).getCell(1));
	driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(email);
	driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(password);
	driver.findElement(By.xpath(prop.getProperty("signin_xpath"))).click();
	driver.quit();
}

@Then("User click on Sign in button and Enter credentials to land on home page")
public void user_click_on_sign_in_button_and_enter_credentials_to_land_on_home_page() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to("https://members.universalclass.com/login.htm");
	driver.manage().window().maximize();
	File g=new File("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\DataSource\\data.xlsx");
	FileInputStream is = new FileInputStream(g);
	XSSFWorkbook w = new XSSFWorkbook(is);
	XSSFSheet sheet = w.getSheetAt(0);	
	DataFormatter formatter = new DataFormatter();
	String email = formatter.formatCellValue(sheet.getRow(1).getCell(0));
	String password = formatter.formatCellValue(sheet.getRow(1).getCell(1));
	driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys(email);
	driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(password);
	driver.findElement(By.xpath(prop.getProperty("signin_xpath"))).click();
	driver.navigate().to("https://www.universalclass.com/index.htm");
	driver.manage().window().maximize();
	driver.quit();
}

@Then("User click on forgot password link")
public void user_click_on_forgot_password_link() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to(prop.getProperty("forgotpassword_link"));
	driver.manage().window().maximize();
	driver.quit();
}

@Then("User click on email textbox for recovery")
public void user_click_on_email_textbox_for_recovery() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.navigate().to(prop.getProperty("forgotpassword_link"));
	driver.manage().window().maximize();
	driver.quit();
}

@Then("User click on Search bar and enter text")
public void user_click_on_search_bar_and_enter_text() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("SearchBar_xpath"))).sendKeys("SQL");
	driver.quit();
}

@Then("User click on Search bar and enter matched data")
public void user_click_on_search_bar_and_enter_matched_data() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("SearchBar_xpath"))).sendKeys("SQL");
	driver.findElement(By.xpath(prop.getProperty("SearchButton_xpath"))).click();
	driver.quit();
}

@Then("User click on Search bar and enter unmatched data")
public void user_click_on_search_bar_and_enter_unmatched_data() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("SearchBar_xpath"))).sendKeys("aaaa");
	driver.findElement(By.xpath(prop.getProperty("SearchButton_xpath"))).click();
	driver.quit();
}

@Then("User click on Search bar")
public void user_click_on_search_bar() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("SearchBar_xpath"))).click();
	driver.quit();
}


@Then("User click on Search bar and enter no text")
public void user_click_on_search_bar_and_enter_no_text() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("SearchBar_xpath"))).click();
	driver.findElement(By.xpath(prop.getProperty("SearchButton_xpath"))).click();
	driver.quit();
}


@Then("User click on course catalog button")
public void user_click_on_course_catalog_button() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("CourseCatalog_Button_xpath"))).click();
	driver.quit();
}



@Then("User click on my class button")
public void user_click_on_my_class_button() throws Exception {
	FileInputStream ip=new FileInputStream("C:\\Users\\Prashant\\Desktop\\Capgemini Documents\\Study Material\\Module 3\\Eclipse workspace\\UniversalClass\\P1.properties");
	prop.load(ip);
	driver.findElement(By.xpath(prop.getProperty("MyClass_Button_xpath"))).click();
	driver.quit();
}

}
