
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



public class QA_CA_Customer_Desktop  {
	private WebDriver driver;
	private String baseUrl;
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
	private String securityAnswer;
	private boolean update, payment, links, creation;
	private String newNum;

	public QA_CA_Customer_Desktop(String a, String b, String c, String d, String e, boolean f, boolean g, boolean h, boolean i){
		usr = a;
		pw = b;
		ccVeri = c;
		securityAnswer = d;
		bossVersion = e;
		update = f;
		payment = g;
		links = h;
		creation = i;
	}

	//@Before
	public void setUp() throws Exception {
		//System.setProperty("webdriver.firefox.bin", "src/res/Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.firefox.bin", "Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		int qa = Runner.bossqa;
		if(qa==0){
			baseUrl = "http://ca.bossqa.cstage01.n2p.com/";
		}else{
			baseUrl = "http://ca.bossqa"+qa+".cstage01.n2p.com/";
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void screenShot(String error){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\CA_Customer_"+error+".png"));
			pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\CA_Customer_"+error+".png";
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
		System.out.println("Creating new Customer...");
		do{
			driver.get(baseUrl + "/customers/new");
			driver.findElement(By.id("new_phone_number")).clear();
			newNum = randNum(usr);
			driver.findElement(By.id("new_phone_number")).sendKeys(newNum);
			driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("Greatest");
			driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("Ever");
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
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("1234567");
			new Select(driver.findElement(By.id("business_entity_physical_addresses_attributes_0_state"))).selectByVisibleText("British Columbia");
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("Bob Bill");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).sendKeys("123");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("1234567");
			driver.findElement(By.name("raptcha[t]")).clear();
			driver.findElement(By.name("raptcha[t]")).sendKeys("skip");
			driver.findElement(By.id("business_entity_submit")).click();
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		}while(isElementPresent(By.cssSelector("div.small.red")) || !isElementPresent(By.xpath("//form[@id='user_session_new']/div[2]")));
		try {
			assertEquals("THANK YOU FOR CHOOSING Boss Revolution", driver.findElement(By.xpath("//form[@id='user_session_new']/div[2]")).getText());
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
			try {
				assertEquals("To keep your account secure...", driver.findElement(By.id("subheader_C")).getText());
				driver.findElement(By.id("security_answer")).clear();
				driver.findElement(By.id("security_answer")).sendKeys(securityAnswer);
				driver.findElement(By.id("security_qa_save")).click();
				driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			} catch (Error e) {

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
			q="111"+String.valueOf((int)(Math.floor((Math.random() * 1000000)+8999999)));
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
			screenShot("Personal Details");
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
		driver.findElement(By.cssSelector("#A_Tm > div.title > span")).click();
		driver.findElement(By.xpath("//div[@id='A_T']/div/a[2]/div[2]")).click();
		//driver.findElement(By.linkText("Billing History")).click();
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
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("img[alt=\"En-ca_vcard\"]"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"En-ca_vcard\"]")));
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
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("Ghana");
		driver.findElement(By.cssSelector("option[value=\"GH\"]")).click();
		driver.findElement(By.id("receiver")).clear();
		driver.findElement(By.id("receiver")).sendKeys("0264561234");
		driver.findElement(By.id("imtu_request_email")).clear();
		driver.findElement(By.id("imtu_request_email")).sendKeys("testbossrev@gmail.com");
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

	public boolean rates(){
		System.out.println("Testing Rates...");
		driver.findElement(By.linkText("Rates")).click();
		try {
			assertEquals("Rates", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("India", driver.findElement(By.cssSelector("td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Guam");
		try {
			assertEquals("Guam", driver.findElement(By.cssSelector("td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Hong Kong");
		try {
			assertEquals("Hong Kong", driver.findElement(By.cssSelector("td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Rwanda");
		try {
			assertEquals("Rwanda", driver.findElement(By.cssSelector("td.l")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Personal Access Number", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean mobileApp(){
		System.out.println("Testing Mobile App...");
		driver.findElement(By.linkText("Mobile Apps")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Mobile_app_desktop_en-ca\"]")));
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

	public boolean raf2(){
		System.out.println("Testing Refer a Friend(2)...");
		driver.findElement(By.xpath("//div[@id='header']/div[3]/ul/li[9]/span")).click();
		//driver.findElement(By.linkText("Refer A Friend")).click();
		/*
		try {
			assertEquals("Refer A Friend", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"En-ca_1\"]")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("INVITE")).click();
		try {
			assertEquals("My Referrals", driver.findElement(By.xpath("//form[@id='new_raf_request']/div[5]")).getText());
		} catch (Error e) {
			return false;
		}
		return true;*/
		driver.findElement(By.linkText("Friends Forever")).click();
		try {
			assertEquals("Friends Forever", driver.findElement(By.id("subheader_C")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"En-ca_1\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"En-ca_2\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("INVITE")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("INVITE")).click();
		try {
			assertTrue(isElementPresent(By.id("subheader_C")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("raf_request_first_name")));
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
			assertTrue(isElementPresent(By.cssSelector("#br-logo > img")));
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
		driver.get(baseUrl + "customers/home");
		//log in///////////////////////////////////////////////1
		if(update||payment||links){
			if(login()){
				System.out.println("[Success]Login successful");
				result[1]=1;
			}else{
				screenShot("Login");
				System.err.println("[Error]Failed to Login, ending test");
				tearDown();
				return false;
			}
		}

		if(update){
			//Registered numbers///////////////////////////////////////////////4
			if(registeredNumbers(1)){
				System.out.println("[Sucess]Changed numbers successfully");
				screenShot("Registered Numbers");
				result[4]=1;
			}else{
				screenShot("Registered Numbers");
				System.err.println("[Error]Failed to change numbers");
			}
			//Speed Dial///////////////////////////////////////////////6
			if(speedDial()){
				System.out.println("[Sucess]Changed numbers successfully");
				screenShot("Speed Dial");
				result[6]=1;
			}else{
				screenShot("Speed Dial");
				System.err.println("[Error]Failed to change numbers");
			}
			//Call History///////////////////////////////////////////////7
			if(callHistory()){
				System.out.println("[Sucess]Call History seems ok");
				screenShot("CallHistory");
				result[7]=1;
			}else{
				screenShot("Call History");
				System.err.println("[Error]Something wrong with Call History");
			}
			//Update Details///////////////////////////////////////////////8
			if(updateDetails()){
				System.out.println("[Sucess]Updated Personal Details Sucessfully");
				result[8]=1;
			}else{
				screenShot("Update Details");
				System.err.println("[Error]Failed to Update Personal Details");
			}
			driver.get(baseUrl+"customers/home/");
		}

		if(payment){
			//Recharge///////////////////////////////////////////////3
			if(recharge()){
				System.out.println("[Success]Recharge successful");
				screenShot("Recharge");
				result[3]=1;
			}else{
				screenShot("Recharge");
				System.err.println("[Error]Recharge failed");

			}
			//IMTU///////////////////////////////////////////////15
			if(imtu()){
				System.out.println("[Sucess]IMTU successful");
				screenShot("IMTU");
				result[15]=1;
			}else{
				screenShot("IMTU");
				System.err.println("[Error]IMTU failed");
			}
			driver.get(baseUrl+"customers/home/");
		}

		if(links){
			//Billing History///////////////////////////////////////////////9
			if(billingHist()){
				System.out.println("[Sucess]Billing History looks OK");
				result[9]=1;
			}else{
				screenShot("Billing History");
				System.err.println("[Error]Something Wrong with Billing History");
			}
			//Move Service///////////////////////////////////////////////10
			if(moveService()){
				System.out.println("[Sucess]Move Service OK");
				result[10]=1;
			}else{
				screenShot("Move Service");
				System.err.println("[Error]Something wrong with Move Service");
			}
			//Refer a Friend///////////////////////////////////////////////11
			if(raf()){
				System.out.println("[Sucess]RAF Right Page");
				result[11]=1;
			}else{
				screenShot("RAF");
				System.err.println("[Error]Raf Wrong Page");
			}
			//Virtual Calling Card///////////////////////////////////////////////12
			if(vcc()){
				System.out.println("[Sucess]VCC shows up");
				result[12]=1;
			}else{
				screenShot("VCC");
				System.err.println("[Error]VCC doesn't show up");
			}
			//Contact Us///////////////////////////////////////////////13
			if(contactUs()){
				System.out.println("[Sucess]Contact Us looks OK");
				result[13]=1;
			}else{
				screenShot("Contact Us");
				System.err.println("[Error]Something wrong with Contact Us");
			}
			//Request Refund///////////////////////////////////////////////14
			if(reqRefund()){
				System.out.println("[Sucess]Request Refund looks OK");
				result[14]=1;
			}else{
				screenShot("Request Refund");
				System.err.println("[Error]Something wrong with Request Refund");
			}
			//Rates///////////////////////////////////////////////17
			if(rates()){
				System.out.println("[Sucess]Rates looks OK");
				result[17]=1;
			}else{
				screenShot("Rates");
				System.err.println("[Error]Something wrong with Rates");
			}
			//Mobile App///////////////////////////////////////////////18
			if(mobileApp()){
				System.out.println("[Sucess]Mobile App looks OK");
				result[18]=1;
			}else{
				screenShot("Mobile App");
				System.err.println("[Error]Something wrong with Mobile App");
			}
			//Faq///////////////////////////////////////////////19
			if(faq()){
				System.out.println("[Sucess]FAQ looks OK");
				result[19]=1;
			}else{
				screenShot("Faq");
				System.err.println("[Error]Something wrong with FAQ");
			}
			//Dialing Tips///////////////////////////////////////////////20
			if(dialingTips()){
				System.out.println("[Sucess]Dialing Tips looks OK");
				result[20]=1;
			}else{
				screenShot("Dialing Tips");
				System.err.println("[Error]Something wrong with Dialing Tips");
			}
			//How it Works///////////////////////////////////////////////21
			if(hiw()){
				System.out.println("[Sucess]How it Works looks OK");
				result[21]=1;
			}else{
				screenShot("How It Works");
				System.err.println("[Error]Something wrong with How it Works");
			}
			//Features///////////////////////////////////////////////22
			if(features()){
				System.out.println("[Sucess]Features looks OK");
				result[22]=1;
			}else{
				screenShot("Features");
				System.err.println("[Error]Something wrong with Features");
			}
			//Free Wi-Fi///////////////////////////////////////////////23

			//Refer a Friend/////////////////////////////////////////////////24
			if(raf2()){
				System.out.println("[Sucess]Refer a Friend(2) looks OK");
				result[24]=1;
			}else{
				screenShot("RAF");
				System.err.println("[Error]Something wrong with Refer a Friend(2)");
			}
			//Contact us///////////////////////////////////////////////25
			if(contactUs2()){
				System.out.println("[Sucess]Contact Us(2) looks OK");
				result[25]=1;
			}else{
				screenShot("Contact Us");
				System.err.println("[Error]Something wrong with Contact Us(2)");
			}
			//Site map///////////////////////////////////////////////26
			if(siteMap()){
				System.out.println("[Sucess]Site Map looks OK");
				result[26]=1;
			}else{
				screenShot("Site Map");
				System.err.println("[Error]Something wrong with Site Map");
			}
			//Become a Reseller///////////////////////////////////////////////27
			if(reseller()){
				System.out.println("[Sucess]Beome a Reseller looks OK");
				result[27]=1;
			}else{
				screenShot("Reseller");
				System.err.println("[Error]Something wrong with Beome a Reseller");
			}
			//check home page///////////////////////////////////////////////2
			driver.get(baseUrl+"customers/home/");
			if(homePage()){
				System.out.println("[Success]Home Page looks good");
				result[2]=1;
			}else{
				screenShot("Homepage");
				System.err.println("[Error]Something wrong with Home Page");
			}
		}
		//Terms and Conditions///////////////////////////////////////////////
		//driver.findElement(By.linkText("Terms & Conditions")).click();
		//Log out///////////////////////////////////////////////28
		if(update||payment||links){
			if(logout()){
				System.out.println("[Sucess]Logout Successful");
				result[28]=1;
			}else{
				screenShot("Logout");
				System.err.println("[Error]Logout Failed");
			}
		}
		if(creation){
			if(createCust()){
				System.out.println("[Success]Created Customer Successfully");
				screenShot("Customer Creation");
				result[29] = 1;
			}else{
				screenShot("Customer Creation");
				System.err.println("[Error]Failed to Create Customer");
			}
		}
		return true;
	}
	
	int r = 1;
	public void print(){
		boolean ayOk = true;
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("***Testing Complete***");
		System.out.println("");
		System.out.println("**CA Customer Desktop**");
		if(update||payment||links){
			//login//////////////////////
			if(result[1]==1){
				System.out.println(r+") Login Successful - "+usr+ ":" + pw);
				results[r++]=r-1+") Login Successful - "+usr+ ":" + pw;
			}else{
				System.out.println(r+") Login Unsuccessful");
				results[r++]=r-1+") Login Unsuccessful";
				ayOk = false;
			}
		}
		if(update){
			//registered number//////////////////////
			if(result[4]==1){
				System.out.println(r+") Updated Registered Numbers Successfully");
				results[r++]=r-1+") Updated Registered Numbers Successfully";
			}else{
				System.out.println(r+") Failed to update Registered Numbers");
				results[r++]=r-1+"){color:red} Failed to update Registered Numbers{color}";
				ayOk = false;
			}
			////////////////////////

			if(result[6]==1){
				System.out.println(r+") Updated Speed Dial Numbers Successfully");
				results[r++]=r-1+") Updated Speed Dial Numbers Successfully";
			}else{
				System.out.println(r+") Speed Dial update failed");
				results[r++]=r-1+"){color:red} Speed Dial update failed{color}";
				ayOk = false;
			}
			//Update Details//////////////////////
			if(result[8]==1){
				System.out.println(r+") Updated Personal Details Successfully");
				results[r++]=r-1+") Updated Personal Details Successfully";
			}else{
				System.out.println(r+") Failed to update Personal Details");
				results[r++]=r-1+"){color:red} Failed to update Personal Details{color}";
				ayOk = false;
			}
		}

		if(payment){
			//recharge//////////////////////
			if(result[3]==1){
				System.out.println(r+") Recharge Successful");
				results[r++]=r-1+") Recharge Successful";
			}else{
				System.out.println(r+") Recharge Unsuccessful");
				results[r++]=r-1+"){color:red} Recharge Unsuccessful{color}";
				ayOk = false;
			}
			//IMTU//////////////////////
			if(result[15]==1){
				System.out.println(r+") IMTU Successful");
				Email y = new Email("1"+usr);
				String e = y.getMail("International");
				while(e.equals("hi"))
					e = y.getMail("International");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") IMTU Successful\n*email*\n"+e;
			}else{
				System.out.println(r+") IMTU Failed");
				results[r++]=r-1+"){color:red} IMTU Failed{color}";
				ayOk = false;
			}
		}

		if(links){
			//Move Service//////////////////////
			if(result[10]==1){
				System.out.println(r+") Move Service OK");
				results[r++]=r-1+") Move Service OK";
			}else{
				System.out.println(r+") Move Service Failed");
				results[r++]=r-1+"){color:red} Move Service Failed{color}";
				ayOk = false;
			}
			if(result[17]==1){
				System.out.println(r+") Rates looks Ok");
				results[r++]=r-1+") Rates looks Ok";
			}else{
				System.out.println(r+") Something wrong with Rates");
				results[r++]=r-1+"){color:red} Something with Rates{color}";
				ayOk = false;
			}
			///////////////
			if(result[12]==1){
				System.out.println(r+") VCC Shows up");
				results[r++]=r-1+") VCC Shows up";
			}else{
				System.out.println(r+") Something wrong with VCC");
				results[r++]=r-1+"){color:red} Something with VCC{color}";
				ayOk = false;
			}
			////////////////
			if(result[2]==1 && result[7]==1 && result[9]==1 && result[11]==1 && result[12]==1 && result[13]==1 && result[14]==1 && result[18]==1 && result[19]==1 && result[20]==1 && result[21]==1 && result[22]==1 && result[24]==1 && result[25]==1 && result[26]==1 && result[27]==1){
				System.out.println(r+") Other Navigation Links are Correct");
				results[r++]=r-1+") Other Navigation Links are Correct";
			}else{
				System.out.println(r+") Incorrect Navigation Link(s) Present");
				results[r++]=r-1+"){color:red} Incorrect Navigation Link(s) Present{color}";
				ayOk = false;
			}
		}
		if(update||payment||links){
			//Logout//////////////////////
			if(result[28]==1){
				System.out.println(r+") Logout Successful");
				results[r++]=r-1+") Logout Successful";
			}else{
				System.out.println(r+") Logout Failed");
				results[r++]=r-1+"){color:red} Logout Failed{color}";
				ayOk = false;
			}
		}
		if(creation){
			if(result[29]==1){
				System.out.println(r+") Customer Creation Successful - "+newNum);
				Email y = new Email("1"+newNum);
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
		}
		if(ayOk){
			System.out.println("");
			System.out.println("Everything looks good!");
		}
	}

	public Report Reports(){
		return new Report(results, pics, picCount, r);
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