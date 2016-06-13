
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class QA_UK_Customer_Desktop  {
	
	public static void main(String[]args){
		System.out.println("QA UK CUSTOMER DESKTOP CLASS: ");
	}
	
	private WebDriver driver;
	private String baseUrl;
	//private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String[] results = new String[13];
	private String[] pics = new String[29];
	private int picCount=0;
	private int[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	private String usr;
	private String pw;
	private String ccVeri;
	private String bossVersion;
	private boolean update;
	private boolean payment;
	private boolean links;
	private boolean creation;
	private String newNum;

	public QA_UK_Customer_Desktop(String a, String b, String c, String d, boolean update, boolean payment, boolean links, boolean q){
		usr = a;
		pw = b;
		ccVeri = c;
		bossVersion = d;
		this.update = update;
		this.payment = payment;
		this.links = links;
		creation = q;
	}

	//@Before
	public void setUp() throws Exception {
		//System.setProperty("webdriver.firefox.bin", "src/res/Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.firefox.bin", "Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		System.out.println("FireFoxDriver Exception");
		int qa = Runner.bossqa;
		if(qa==0){
			baseUrl = "http://uk.bossqa.cstage01.n2p.com/";
		}else{
			baseUrl = "http://uk.bossqa"+qa+".cstage01.n2p.com/";
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void screenShot(String error){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\UK_Customer_"+error+".png"));
			pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\UK_Customer_"+error+".png";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileUtils.deleteQuietly(scrFile);
	}

	public String date(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public boolean createCust(){
		System.out.println("Creating New Customer...");
		int q=0;
		do{
			if(q++==3)return false;
			driver.get(baseUrl + "/customers/login");
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("new_phone_number")).clear();
			newNum = randNum("1");
			driver.findElement(By.id("new_phone_number")).sendKeys(newNum);
			driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("t");
			driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("t");
			driver.findElement(By.id("business_entity_user_attributes_email")).clear();
			driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
			driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
			driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
			driver.findElement(By.id("business_entity_user_attributes_security_answer")).clear();
			driver.findElement(By.id("business_entity_user_attributes_security_answer")).sendKeys("123");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 always way");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).sendKeys("london");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("12345");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("Daenerys Targaryen");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).sendKeys("123");
			driver.findElement(By.name("raptcha[t]")).clear();
			driver.findElement(By.name("raptcha[t]")).sendKeys("skip");
			driver.findElement(By.id("business_entity_submit")).click();
		}while(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))||isElementPresent(By.cssSelector("div.small.red")) || !isElementPresent(By.xpath("//form[@id='user_session_new']/div[2]")));
		try {
			assertEquals("REGISTER - Step 2 of 2", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean login(){
		System.out.println("Logging in...");
		try {
			assertEquals("LOG IN", driver.findElement(By.id("subheader_C")).getText());
			driver.findElement(By.id("user_session_login")).clear();
			driver.findElement(By.id("user_session_login")).sendKeys(usr);
			driver.findElement(By.id("user_session_password")).clear();
			driver.findElement(By.id("user_session_password")).sendKeys(pw);
			driver.findElement(By.cssSelector("div.buttonsX > input[name=\"commit\"]")).click();
			if(isElementPresent(By.cssSelector("p"))){
				return false;
			}
			if(isElementPresent(By.cssSelector("div.buttonsX > input[type=\"submit\"]")))
				driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
			return true;
		} catch (Error e) {
			return false;
		}
	}

	public boolean homePage(){
		System.out.println("Checking Home page...");
		try {
			assertTrue(isElementPresent(By.cssSelector("div.title")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("#M_Tm > div.title")));
		} catch (Error e) {
			return false;	
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("#A_Tm > div.title > span")));
		} catch (Error e) {
			return false;	
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("div.support.tab_image")));
		} catch (Error e) {
			return false;		
		}
		return true;
	}

	public boolean recharge(){
		System.out.println("Attempting Recharge...");
		driver.findElement(By.cssSelector("a.item > div.title")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Make sure to keep your account funded. You don't want to get stuck paying high rates with your service provider or with another service.", driver.findElement(By.cssSelector("div.msg.last")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).sendKeys(ccVeri);
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		if("Your account has been recharged successfully.".equals(driver.findElement(By.cssSelector("p")).getText())){
			return true;
		}
		return false;
	}

	public String randNum(String w){
		String q;
		do
			q="447" + String.valueOf((int)(Math.floor((Math.random() * 100000000))+899999999));
		while(q.equals(usr) || q.equals(w));
		return q;
	}

	public boolean registeredNumbers(int t){
		System.out.println("Changing Registered Numbers...");
		driver.findElement(By.linkText("Registered Numbers")).click();
		driver.findElement(By.xpath("(//input[@id='registered_phones_'])[2]")).clear();
		String w = randNum("123");
		driver.findElement(By.xpath("(//input[@id='registered_phones_'])[2]")).sendKeys(w);
		driver.findElement(By.xpath("(//input[@id='registered_phones_'])[3]")).clear();
		String q = randNum(w);
		driver.findElement(By.xpath("(//input[@id='registered_phones_'])[3]")).sendKeys(q);
		driver.findElement(By.xpath("(//input[@id='registered_phones_'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@id='registered_phones_'])[4]")).sendKeys(randNum(q));
		driver.findElement(By.name("commit")).click();
		if(!isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))&&"The registered numbers were successfully updated.".equals(driver.findElement(By.cssSelector("p")).getText())){
			return true;
		}else{
			if(t==3) return false;
			return registeredNumbers(t+1);
		}
	}

	public boolean quickCall(){
		System.out.println("Testing Quick Call...");
		driver.findElement(By.linkText("QuickCall")).click();
		Select q=new Select(driver.findElement(By.id("savorites__index")));
		//System.out.println(q.getOptions().get(0).toString());
		//if(q.getOptions().size()==0 || (q.getOptions().size()==1 && q.getOptions().get(0).toString().contains("firefox"))) return false;
		if(q.getOptions().size()<2) return false;
		q.selectByValue(q.getOptions().get(1).getAttribute("value"));
		driver.findElement(By.id("savorites__phone")).clear();
		driver.findElement(By.id("savorites__phone")).sendKeys(randNum("1"));
		driver.findElement(By.id("savorites__description")).clear();
		driver.findElement(By.id("savorites__description")).sendKeys("TEST");
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("QuickCall successfully updated.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean speedDial(){
		System.out.println("Testing Speed Dial...");
		driver.findElement(By.linkText("Speed Dial")).click();
		try {
			assertEquals("Speed Dial is a great feature that allows you to save the phone numbers that you dial most often into your account's memory.", driver.findElement(By.cssSelector("div.msg")).getText());
		} catch (Error e) {
			return false;
		}
		String r = randNum("1");
		driver.findElement(By.id("sdphone1")).clear();
		driver.findElement(By.id("sdphone1")).sendKeys(r);
		driver.findElement(By.id("sddescr1")).clear();
		driver.findElement(By.id("sddescr1")).sendKeys("John Snow");
		driver.findElement(By.id("sdphone2")).clear();
		driver.findElement(By.id("sdphone2")).sendKeys(randNum(r));
		driver.findElement(By.id("sddescr2")).clear();
		driver.findElement(By.id("sddescr2")).sendKeys("Brandon Stark");
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		if("The Speed Dial numbers were successfully updated.".equals(driver.findElement(By.cssSelector("p")).getText())){
			return true;
		}
		return false;
	}

	public boolean callHistory(){
		System.out.println("Testing Call History...");
		driver.get(baseUrl + "customers/home/");
		driver.findElement(By.linkText("Call History")).click();
		try {
			assertEquals("Please select a date range of one month or less", driver.findElement(By.cssSelector("div.msg.last")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Call History", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("from_date")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]")).click();
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean updateDetails(){
		System.out.println("Updating Personal Details...");
		driver.findElement(By.linkText("My Account")).click();
		try {
			assertEquals("My Account", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.cssSelector("div.acct.tab_image")).click();
		driver.findElement(By.cssSelector("#A_T > div.action > a.item > div.title")).click();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("qwerty");
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("p")).getText());
			screenShot("UpdateDetails");
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[2]")).click();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).sendKeys("Updated "+date());
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[3]")).click();
		driver.findElement(By.id("old_security_code")).clear();
		driver.findElement(By.id("old_security_code")).sendKeys(pw);
		driver.findElement(By.id("security_code")).clear();
		driver.findElement(By.id("security_code")).sendKeys(pw);
		driver.findElement(By.id("security_code_confirmation")).clear();
		driver.findElement(By.id("security_code_confirmation")).sendKeys(pw);
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean billingHist(){
		System.out.println("Testing Billing History...");
		driver.findElement(By.id("ui-accordion-accordion_side_menu-header-3")).click();
		driver.findElement(By.linkText("Billing History")).click();
		try {
			assertEquals("Billing History", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("from_date")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("to_date")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean moveService(){
		System.out.println("Testing Move Service...");
		driver.findElement(By.linkText("Move Service")).click();
		driver.findElement(By.id("phone_number")).clear();
		driver.findElement(By.id("phone_number")).sendKeys(usr);
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		if("This phone number is not available. Please check if it is correct or contact Customer Service for assistance.".equals(driver.findElement(By.cssSelector("p")).getText())){
			return true;
		}
		return false;
	}

	public boolean raf(){
		System.out.println("Testing RAF...");
		driver.findElement(By.xpath("(//a[contains(text(),'Friends Forever')])[2]")).click();
		try {
			assertEquals("Start earning FREE Calling Rewards for referring friends. Learn More", driver.findElement(By.xpath("//form[@id='new_raf_request']/div[2]")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean vcc(){
		System.out.println("Testing Virtual Calling Card...");
		driver.findElement(By.id("ui-accordion-accordion_side_menu-header-4")).click();
		driver.findElement(By.linkText("Virtual Calling Card")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"En-gb_vcard\"]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean contactUs(){
		System.out.println("Testing Contact Us...");
		driver.findElement(By.linkText("Contact Us")).click();
		try {
			assertEquals("Please let us know how we can help you.", driver.findElement(By.cssSelector("div.msg.last")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean reqRefund(){
		System.out.println("Testing Request Refund...");
		driver.findElement(By.id("ui-accordion-accordion_side_menu-header-4")).click();
		driver.findElement(By.linkText("Request a Refund")).click();
		try {
			assertEquals("Your credit card, as it appears below will be refunded. The refund will not happen instantly. Please allow our Customer Services team time to process your request", driver.findElement(By.cssSelector("div.msg.last")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean imtu(){
		System.out.println("Testing IMTU...");
		driver.findElement(By.linkText("Mobile Top-Up")).click();
		driver.findElement(By.linkText("International Mobile Top-Up")).click();
		//driver.findElement(By.id("country")).click();
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("RU");
		driver.findElement(By.id("receiver")).clear();
		driver.findElement(By.id("receiver")).sendKeys("4124564578");
		driver.findElement(By.id("imtu_submit_button")).click();
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Thank you. Your purchase was successful and the International Mobile Number recharged.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean dmtu(){
		System.out.println("Testing DMTU...");
		driver.findElement(By.linkText("Domestic Mobile Top-Up")).click();
		new Select(driver.findElement(By.id("carrier"))).selectByVisibleText("Orange");
		driver.findElement(By.cssSelector("option[value=\"Orange\"]")).click();
		driver.findElement(By.id("imtu_submit_button")).click();
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Thank you. Your DMTU purchase was successful.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean rates(){
		System.out.println("Testing Rates...");
		driver.findElement(By.linkText("Rates")).click();
		try {
			assertEquals("Rates", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Afghanistan", driver.findElement(By.cssSelector("td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Cuba");
		try {
			assertEquals("Cuba", driver.findElement(By.cssSelector("td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Zimbabwe");
		try {
			assertEquals("Zimbabwe", driver.findElement(By.cssSelector("td.l")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Birmingham", driver.findElement(By.cssSelector("div.iform > div > table.result > tbody > tr.even > td")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("O2 Mobile Contract Tagalog", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div[4]/div/table/tbody/tr[18]/td")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean mobileApp(){
		System.out.println("Testing Mobile App...");
		driver.findElement(By.linkText("Mobile Apps")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Mobile_app_desktop_en-gb\"]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean faq(){
		System.out.println("Testing FAQ...");
		driver.findElement(By.xpath("//div[@id='header']/div[3]/ul/li[9]/span")).click();
		driver.findElement(By.linkText("FAQ")).click();
		try {
			assertEquals("FAQ", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean dialingTips(){
		System.out.println("Testing Dialing Tips...");
		driver.findElement(By.xpath("//div[@id='header']/div[3]/ul/li[9]/span")).click();
		driver.findElement(By.linkText("Dialling Tips")).click();
		try {
			assertEquals("DIALLING TIPS", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean hiw(){
		System.out.println("Testing How It Works...");
		driver.findElement(By.xpath("//div[@id='header']/div[3]/ul/li[9]/span")).click();
		driver.findElement(By.linkText("How it Works")).click();
		try {
			assertEquals("HOW IT WORKS", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean features(){
		System.out.println("Testing Features...");
		driver.findElement(By.xpath("//div[@id='header']/div[3]/ul/li[9]/span")).click();
		driver.findElement(By.linkText("Features")).click();
		try {
			assertEquals("FEATURES", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}
/*
	public boolean wifi(){
		System.out.println("Testing Free Wi-Fi...");
		driver.findElement(By.xpath("//div[@id='header']/div[3]/ul/li[9]/span")).click();
		driver.findElement(By.linkText("Free Wi-Fi")).click();
		try {
			assertEquals("BOSS REVOLUTION WI-FI", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}
*/
	public boolean raf2(){
		System.out.println("Testing Refer a Friend(2)...");
		driver.findElement(By.xpath("//div[@id='header']/div[3]/ul/li[9]/span")).click();
		driver.findElement(By.linkText("Friends Forever")).click();
		/*
		try {
			assertEquals("Refer A Friend", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"En-gb_1\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"En-gb_2\"]")));
		} catch (Error e) {
			return false;
		}
		return true;
		 */
		try {
			assertEquals("Friends Forever", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Ff_desktop_en-gb\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Ff_desktop_en-gb\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Ff_desktop_en-gb\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Ff_desktop_en-gb\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Ff_desktop_en-gb\"]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean contactUs2(){
		System.out.println("Testing Contact Us(2)...");
		driver.findElement(By.linkText("Contact Us")).click();
		try {
			assertEquals("YOU CAN REACH US BY EMAIL OR PHONE AT ANY TIME.", driver.findElement(By.cssSelector("div.msg.bold")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("div.image.users")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean siteMap(){
		System.out.println("Testing Site Map...");
		driver.findElement(By.linkText("Site Map")).click();
		try {
			assertEquals("SITE MAP", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean reseller(){
		System.out.println("Testing Become a Reseller...");
		driver.findElement(By.cssSelector("div.r > a")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Become_dealer_en\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("BECOME A RESELLER", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean logout(){
		System.out.println("Logging out...");
		driver.findElement(By.linkText("LOGOUT")).click();
		try {
			assertEquals("Successfully logged out.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("LOG IN", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//@Test
	public boolean test() throws Exception {
		//open browser///////////////////////////////////////////////0
		System.out.println("Opening Customer Portal");
		driver.get(baseUrl + "/customers/home");
		if(update||payment||links)
			//log in///////////////////////////////////////////////1
			if(login()){
				System.out.println("[Success]Login successful");
				result[1]=1;
			}else{
				screenShot("Login");
				System.err.println("[Error]Failed to Login, ending test");
				tearDown();
				return false;
			}


		if(update){
			//Registered numbers///////////////////////////////////////////////4
			if(registeredNumbers(1)){
				System.out.println("[Sucess]Changed numbers successfully");
				screenShot("RegisteredNumbers");
				result[4]=1;
			}else{
				screenShot("RegisteredNumbers");
				System.err.println("[Error]Failed to change numbers");
				result[4]=3;
			}
			//Quick Call///////////////////////////////////////////////5
			if(quickCall()){
				System.out.println("[Sucess]Changed numbers successfully");
				screenShot("QuickCall");
				result[5]=1;
			}else{
				screenShot("QuickCall");
				System.err.println("[Error]Failed to change numbers");
				result[5]=3;
			}
			//Speed Dial///////////////////////////////////////////////6
			if(speedDial()){
				System.out.println("[Sucess]Changed numbers successfully");
				screenShot("SpeedDial");
				result[6]=1;
			}else{
				screenShot("SpeedDial");
				System.err.println("[Error]Failed to change numbers");
				result[6]=3;
			}
			//Update Details///////////////////////////////////////////////8
			if(updateDetails()){
				System.out.println("[Sucess]Updated Personal Details Sucessfully");
				result[8]=1;
			}else{
				screenShot("UpdateDetails");
				System.err.println("[Error]Failed to Update Personal Details");
				result[8]=3;
			}

		}

		if(payment){
			//Recharge///////////////////////////////////////////////3
			driver.get(baseUrl + "customers/home/");
			if(recharge()){
				System.out.println("[Success]Recharge successful");
				screenShot("Recharge");
				result[3]=1;
			}else{
				screenShot("Recharge");
				System.err.println("[Error]Recharge failed");
				result[3]=3;

			}
			//IMTU///////////////////////////////////////////////15
			if(imtu()){
				System.out.println("[Sucess]IMTU successful");
				screenShot("IMTU");
				result[15]=1;
			}else{
				screenShot("IMTU");
				System.err.println("[Error]IMTU failed");
				result[15]=3;
			}
			//DMTU///////////////////////////////////////////////16
			if(dmtu()){
				System.out.println("[Sucess]DMTU successful");
				screenShot("DMTU");
				result[16]=1;
			}else{
				screenShot("DMTU");
				System.err.println("[Error]DMTU failed");
				result[16]=3;
			}
		}

		if(links){
			//Call History///////////////////////////////////////////////7
			if(callHistory()){
				System.out.println("[Sucess]Call History seems ok");
				result[7]=1;
			}else{
				screenShot("CallHistory");
				System.err.println("[Error]Something wrong with Call History");
				result[7]=3;
			}
			//Billing History///////////////////////////////////////////////9
			if(billingHist()){
				System.out.println("[Sucess]Billing History looks OK");
				result[9]=1;
			}else{
				screenShot("BillingHistory");
				System.err.println("[Error]Something Wrong with Billing History");
				result[9]=3;
			}
			//Move Service///////////////////////////////////////////////10
			if(moveService()){
				System.out.println("[Sucess]Move Service OK");
				//screenShot("MoveService");
				result[10]=1;
			}else{
				screenShot("MoveService");
				System.err.println("[Error]Something wrong with Move Service");
				result[10]=3;
			}
			//Refer a Friend///////////////////////////////////////////////11
			if(raf()){
				System.out.println("[Sucess]RAF Right Page");
				result[11]=1;
			}else{
				screenShot("RAF");
				System.err.println("[Error]Raf Wrong Page");
				result[11]=3;
			}
			//Virtual Calling Card///////////////////////////////////////////////12
			if(vcc()){
				System.out.println("[Sucess]VCC shows up");
				result[12]=1;
			}else{
				screenShot("VCC");
				System.err.println("[Error]VCC doesn't show up");
				result[12]=3;
			}
			//Contact Us///////////////////////////////////////////////13
			if(contactUs()){
				System.out.println("[Sucess]Contact Us looks OK");
				result[13]=1;
			}else{
				screenShot("ContactUs");
				System.err.println("[Error]Something wrong with Contact Us");
				result[13]=3;
			}
			//Request Refund///////////////////////////////////////////////14
			if(reqRefund()){
				System.out.println("[Sucess]Request Refund looks OK");
				result[14]=1;
			}else{
				screenShot("RequestRefund");
				System.err.println("[Error]Something wrong with Request Refund");
				result[14]=3;
			}
			//Rates///////////////////////////////////////////////17
			if(rates()){
				System.out.println("[Sucess]Rates looks OK");
				result[17]=1;
			}else{
				screenShot("Rates");
				System.err.println("[Error]Something wrong with Rates");
				result[17]=3;
			}
			//Mobile App///////////////////////////////////////////////18
			if(mobileApp()){
				System.out.println("[Sucess]Mobile App looks OK");
				result[18]=1;
			}else{
				screenShot("MobileApp");
				System.err.println("[Error]Something wrong with Mobile App");
				result[18]=3;
			}
			//Faq///////////////////////////////////////////////19
			if(faq()){
				System.out.println("[Sucess]FAQ looks OK");
				result[19]=1;
			}else{
				screenShot("Faq");
				System.err.println("[Error]Something wrong with FAQ");
				result[19]=3;
			}
			//Dialing Tips///////////////////////////////////////////////20
			if(dialingTips()){
				System.out.println("[Sucess]Dialing Tips looks OK");
				result[20]=1;
			}else{
				screenShot("DialingTips");
				System.err.println("[Error]Something wrong with Dialing Tips");
				result[20]=3;
			}
			//How it Works///////////////////////////////////////////////21
			if(hiw()){
				System.out.println("[Sucess]How it Works looks OK");
				result[21]=1;
			}else{
				screenShot("HowItWorks");
				System.err.println("[Error]Something wrong with How it Works");
				result[21]=3;
			}
			//Features///////////////////////////////////////////////22
			if(features()){
				System.out.println("[Sucess]Features looks OK");
				result[22]=1;
			}else{
				screenShot("Features");
				System.err.println("[Error]Something wrong with Features");
				result[22]=3;
			}
			//Free Wi-Fi///////////////////////////////////////////////23
			/*if(wifi()){
				System.out.println("[Sucess]Free Wi-Fi looks OK");
				result[23]=1;
			}else{
				screenShot("FreeWiFi");
				System.err.println("[Error]Something wrong with Free Wi-Fi");
				result[23]=3;
			}*/
			//Refer a Friend/////////////////////////////////////////////////24
			if(raf2()){
				System.out.println("[Sucess]Refer a Friend(2) looks OK");
				result[24]=1;
			}else{
				screenShot("RAF");
				System.err.println("[Error]Something wrong with Refer a Friend(2)");
				result[24]=3;
			}
			//Contact us///////////////////////////////////////////////25
			if(contactUs2()){
				System.out.println("[Sucess]Contact Us(2) looks OK");
				result[25]=1;
			}else{
				screenShot("ContactUs");
				System.err.println("[Error]Something wrong with Contact Us(2)");
				result[25]=3;
			}
			//Site map///////////////////////////////////////////////26
			if(siteMap()){
				System.out.println("[Sucess]Site Map looks OK");
				result[26]=1;
			}else{
				screenShot("SiteMap");
				System.err.println("[Error]Something wrong with Site Map");
				result[26]=3;
			}
			//Become a Reseller///////////////////////////////////////////////27
			if(reseller()){
				System.out.println("[Sucess]Become a Reseller looks OK");
				result[27]=1;
			}else{
				screenShot("Reseller");
				System.err.println("[Error]Something wrong with Beome a Reseller");
				result[27]=3;
			}
			//check home page///////////////////////////////////////////////2
			driver.get(baseUrl + "/customers/home/");
			if(homePage()){
				System.out.println("[Success]Home Page looks good");
				result[2]=1;
			}else{
				screenShot("Homepage");
				System.err.println("[Error]Something wrong with Home Page");
				result[2]=3;
			}
		}
		if(update||payment||links)
			//Log out///////////////////////////////////////////////28
			if(logout()){
				System.out.println("[Sucess]Logout Successful");
				result[28]=1;
			}else{
				screenShot("Logout");
				System.err.println("[Error]Logout Failed");
			}
		if(creation)
			if(createCust()){
				System.out.println("[Sucess]Customer Creation Successful");
				screenShot("Customer Creation");
				result[29]=1;
			}else{
				screenShot("Customer Creation");
				System.err.println("[Error]Customer Creation Failed");
			}

		return true;
	}

	int r=1;
	public void print(){
		boolean ayOk = true;	
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("***Testing Comlpete***");
		System.out.println("");
		System.out.println("**UK Customer Desktop**");
		if(update||payment||links)
			//login//////////////////////
			if(result[1]==1){
				System.out.println(r+") Login Successful - "+usr+ ":" + pw);
				results[r++]=r-1+") Login Successful - "+usr+ ":" + pw;
			}else{
				System.out.println(r+") Login Unsuccessful");
				results[r++]=r-1+") Login Unsuccessful";
				ayOk = false;
			}
		//recharge//////////////////////
		if(result[3]==1){
			System.out.println(r+") Recharge Successful");
			results[r++]=r-1+") Recharge Successful";
		}
		if(result[3]==3){
			System.out.println(r+") Recharge Unsuccessful");
			results[r++]=r-1+"){color:red} Recharge Unsuccessful{color}";
			ayOk = false;
		}
		//registered number//////////////////////
		if(result[4]==1){
			System.out.println(r+") Updated Registered Numbers Successfully");
			results[r++]=r-1+") Updated Registered Numbers Successfully";
		}if(result[4]==3){
			System.out.println(r+") Failed to update Registered Numbers");
			results[r++]=r-1+"){color:red} Failed to update Registered Numbers{color}";
			ayOk = false;
		}
		//QC & SD//////////////////////
		if(result[5]!=0){
			if(result[5]==1){
				if(result[6]==1){
					System.out.println(r+") Updated Quick Call and Speed Dial Numbers Successfully");
					Email y = new Email(usr);
					String e = y.getMail("QuickCall");
					while(e.equals("hi"))
						e = y.getMail("QuickCall");
					System.out.println("*Email*");
					System.out.println(e);
					System.out.println("");
					results[r++]=r-1+") Updated Quick Call and Speed Dial Numbers Successfully\n*email*\n"+e;
				}else{
					System.out.println(r+") Updated Quick Call Sucessfully but Speed Dial update failed");
					Email y = new Email(usr);
					String e = y.getMail("QuickCall");
					while(e.equals("hi"))
						e = y.getMail("QuickCall");
					System.out.println("*Email*");
					System.out.println(e);
					System.out.println("");
					results[r++]=r-1+") {color:red}Updated Quick Call Sucessfully but Speed Dial update failed{color}\n*email*\n"+e;
					ayOk = false;
				}
			}else{
				if(result[6]==1){
					System.out.println(r+") Quick Call update failed but Speed Dial Numbers updated Successfully");
					results[r++]=r-1+"){color:red} Quick Call update failed but Speed Dial Numbers updated Successfully{color}";
					ayOk = false;
				}else{
					System.out.println(r+") Quick Call and Speed Dial update failed");
					results[r++]=r-1+"){color:red} Quick Call and Speed Dial update failed{color}";
					ayOk = false;
				}
			}
		}
		//Update Details//////////////////////
		if(result[8]==1){
			System.out.println(r-1+") Updated Personal Details Successfully");
			results[r++]=r-1+") Updated Personal Details Successfully";
		}
		if(result[8]==3){
			System.out.println(r-1+") Failed to update Personal Details");
			results[r++]=r-1+"){color:red} Failed to update Personal Details{color}";
			ayOk = false;
		}
		//Move Service//////////////////////
		if(result[10]==1){
			System.out.println(r+") Move Service OK");
			results[r++]=r-1+") Move Service OK";
		}
		if(result[10]==3){
			System.out.println(r+") Move Service Failed");
			results[r++]=r-1+"){color:red} Move Service Failed{color}";
			ayOk = false;
		}
		//IMTU//////////////////////
		if(result[15]==1){
			System.out.println(r+") IMTU Successful");
			Email y = new Email(usr);
			String e = y.getMail("International");
			while(e.equals("hi"))
				e = y.getMail("International");
			System.out.println("*Email*");
			System.out.println(e);
			System.out.println("");
			results[r++]=r-1+") IMTU Successful\n*email*\n"+e;
		}
		if(result[15]==3){
			System.out.println(r+") IMTU Failed");
			results[r++]=r-1+"){color:red} IMTU Failed{color}";
			ayOk = false;
		}
		//DMTU//////////////////////
		if(result[16]==1){
			System.out.println(r+") DMTU Successful");
			Email y = new Email(usr);
			String e = y.getMail("Orange");
			while(e.equals("hi"))
				e = y.getMail("Orange");
			System.out.println("*Email*");
			System.out.println(e);
			System.out.println("");
			results[r++]=r-1+") DMTU Successful\n*email*\n"+e;
		}
		if(result[16]==3){
			System.out.println(r+") DMTU Failed");
			results[r++]=r-1+"){color:red} DMTU Failed{color}";
			ayOk = false;
		}
		//Navigation//////////////////////
		if(links){
			if(result[17]==1){
				System.out.println(r+") Rates & Access Numbers look Ok");
				results[r++]=r-1+") Rates & Access Numbers look Ok";
			}else{
				System.out.println(r+") Something wrong with Rates & Access Numbers");
				results[r++]=r-1+"){color:red} Something wrong with Rates & Access Numbers{color}";
				ayOk = false;
			}
			if(result[2]==1 && result[7]==1 && result[9]==1 && result[11]==1 && result[12]==1 && result[13]==1 && result[14]==1 && result[18]==1 && result[19]==1 && result[20]==1 && result[21]==1 && result[22]==1 && result[24]==1 && result[25]==1 && result[26]==1 && result[27]==1){
				System.out.println(r+") Other Navigation Links are Correct");
				results[r++]=r-1+") Other Navigation Links are Correct";
			}else{
				System.out.println(r+") Incorrect Navigation Link(s) Present");
				results[r++]=r-1+"){color:red} Incorrect Navigation Link(s) Present{color}";
				ayOk = false;
			}
		}
		if(update||payment||links)
			//Logout//////////////////////
			if(result[28]==1){
				System.out.println(r+") Logout Successful");
				results[r++]=r-1+") Logout Successful";
			}else{
				System.out.println(r+") Logout Failed");
				results[r++]=r-1+"){color:red} Logout Failed{color}";
				ayOk = false;
			}
		if(creation)
			if(result[29]==1){
				System.out.println(r+") Customer Creation Successful - "+newNum);
				Email y = new Email(newNum);
				String e = y.getMail("Welcome");
				while(e.equals("hi"))
					e = y.getMail("Welcome");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") Customer Creation Successful - "+newNum+"\n*email*\n"+e;
			}else{
				System.out.println(r+") Customer Creation Failed");
				results[r++]=r-1+"){color:red} Customer Creation Failed{color}";
				ayOk = false;
			}
		if(ayOk){
			System.out.println("");
			System.out.println("Everything looks good!");
			//jira();
		}
	}

	public Report Reports(){
		return new Report(results, pics, picCount,r);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by){  
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try{  
			driver.findElement(by);  
			return true;  
		}catch(Exception e){  
			return false;  
		}finally{  
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		}  
	}
}