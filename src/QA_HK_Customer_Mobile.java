
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;



public class QA_HK_Customer_Mobile  {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private String[] results = new String[12];
	private String[] pics = new String[20];
	private int picCount=0;
	private int[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0};

	private String usr;
	private String pw;
	private String ccVeri;
	private String bossVersion;
	private String securityAns;
	private int r;
	private boolean update;
	private boolean payment;
	private boolean links;
	private boolean creation;
	private String newNum;

	public QA_HK_Customer_Mobile(String a, String b, String c, String d, String e, boolean f, boolean g, boolean h, boolean i){
		usr = a;
		pw = b;
		ccVeri = c;
		securityAns=d;
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
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 4 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36");
		driver = new FirefoxDriver(profile);
		int qa = Runner.bossqa;
		if(qa==0){
			baseUrl = "http://hk.bossqa.cstage01.n2p.com/";
		}else{
			baseUrl = "http://hk.bossqa"+qa+".cstage01.n2p.com/";
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void screenShot(String error){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\HK_Mobile_"+error+".png"));
			pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\HK_Mobile_"+error+".png";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileUtils.deleteQuietly(scrFile);
	}
	public boolean createCust(){
		System.out.println("Creating New Customer...");
		int q=0;
		do{
			if(q++==3)return false;
			driver.get(baseUrl + "/customers/login");
			driver.findElement(By.xpath("//form[@id='user_session_new']/div[6]/a/span")).click();
			try {
				assertEquals("Create An Account", driver.findElement(By.cssSelector("h3 > span")).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
			newNum=randNum("1");
			driver.findElement(By.id("new_phone_number")).clear();
			driver.findElement(By.id("new_phone_number")).sendKeys(newNum);
			driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
			driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("qwerty");
			driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("qwe");
			driver.findElement(By.id("business_entity_user_attributes_email")).clear();
			driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
			driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
			driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
			driver.findElement(By.id("form_profile_info_submit")).click();
			driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("t w");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).sendKeys("123");
			driver.findElement(By.id("btnGetToken")).click();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 always way");
			driver.findElement(By.xpath("(//input[@value='Continue'])[4]")).click();
			driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
			driver.findElement(By.name("raptcha[t]")).clear();
			driver.findElement(By.name("raptcha[t]")).sendKeys("skip");
			driver.findElement(By.xpath("//input[@value='Create My Account']")).click();
		}while(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))||isElementPresent(By.cssSelector("div.error")) || !isElementPresent(By.cssSelector("div.msg.bold")));
		try {
			assertEquals("Success! Your Boss Revolution account has been created.", driver.findElement(By.cssSelector("div.msg.bold")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}
	public boolean login(){
		System.out.println("Logging in...");
		try {
			assertEquals("LOG IN", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("user_session_login")).clear();
		driver.findElement(By.id("user_session_login")).sendKeys(usr);
		driver.findElement(By.id("user_session_password")).clear();
		driver.findElement(By.id("user_session_password")).sendKeys(pw);
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();

		if(!"To keep your account secure...".equals(driver.findElement(By.cssSelector("span")).getText())) return false;
		driver.findElement(By.id("security_answer")).clear();
		driver.findElement(By.id("security_answer")).sendKeys(securityAns);
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.buttonsX > input[type=\"submit\"]")))
			driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
		return true;
	}

	public boolean homePage(){
		System.out.println("Checking Home page...");
		try {
			assertEquals("My Account", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Registered Number: "+usr, driver.findElement(By.cssSelector("a.ui-link-inherit")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean recharge(){
		System.out.println("Attempting Recharge...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Add Funds")).click();
		try {
			assertEquals("Recharge", driver.findElement(By.cssSelector("h3 > span")).getText());
		} catch (Error e) {
			return false;
		}
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error")))
			if("Your account is not setup for credit card recharges. Please contact Customer Services.".equals(driver.findElement(By.cssSelector("div.toast-item.toast-type-error")).getText()))
				return false;
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).sendKeys(ccVeri);
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		driver.findElement(By.cssSelector("input.cancel.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Your account has been recharged successfully.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public String randNum(String w){
		String q;
		do
			q="852" + String.valueOf((int)(Math.floor((Math.random() * 10000000)+89999999)));
		while(q.equals(usr) || q.equals(w));
		return q;
	}

	public boolean registeredNumbers(){
		System.out.println("Changing Registered Numbers...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Registered Numbers")).click();
		try {
			assertEquals("Boss Revolution Customers - Registered Numbers", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='page']/div[4]/div/div/a/span")).click();
		String e;
		int r=0;
		do{
			if(r++ == 3) return false;
			driver.findElement(By.id("phone")).clear();
			e = randNum(usr);
			driver.findElement(By.id("phone")).sendKeys(e);
			driver.findElement(By.name("update")).click();
		}while(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p")));
		driver.findElement(By.linkText(e)).click();
		driver.findElement(By.name("delete")).click();
		if(!isElementPresent(By.linkText(e)))
			return true;
		return false;
	}



	public boolean speedDial(){
		System.out.println("Testing Speed Dial...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Speed Dial")).click();
		try {
			assertEquals("Speed Dial", driver.findElement(By.cssSelector("h3 > span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[4]/div/ul/li/div/div/a/span")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='page']/div[4]/div/ul/li/div/div/a/span")).click();
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(randNum("1"));
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("John");
		driver.findElement(By.name("update")).click();
		return true;
	}

	public boolean autoRC(){
		System.out.println("Testing Auto Recharge...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("View your Account")).click();
		driver.findElement(By.xpath("//div[@id='page']/div[3]/ul/li[3]/div/div/a/span[2]")).click();
		driver.findElement(By.cssSelector("span.ui-btn-inner")).click();
		//driver.findElement(By.xpath("//form[@id='form_auto_recharge']/div[7]/div/fieldset/div/div[2]/label/span")).click();
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.cssSelector("span.ui-btn-inner")).click();
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean updateDetails(){
		System.out.println("Updating Billing Info...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Update Billing Info")).click();
		try {
			assertEquals("Update Billing Info", driver.findElement(By.cssSelector("h3 > span")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("qqq");
		driver.findElement(By.id("btnGetToken")).click();
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}


	public boolean wib(){
		System.out.println("Testing What is Boss Revolution?...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("What is Boss Revolution?")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("h4.mt0")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/div[2]/div")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("span.ui-btn-inner")));
		} catch (Error e) {
			return false;
		}
		return true;
	}



	public boolean callRates(){
		System.out.println("Testing Calling Rates...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("View our Calling Rates")).click();
		try {
			assertEquals("Boss Revolution Customers - Calling Rates", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean mobileApp(){
		System.out.println("Testing Mobile Apps...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Mobile Apps")).click();
		try {
			assertEquals("Boss Revolution Customers - MOBILE APPS", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Mobile_app_mobile_en-hk\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Android app on Google Play\"]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean help(){
		System.out.println("Testing Help...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Help")).click();
		try {
			assertEquals("Boss Revolution Customers - Help", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/ul/li/div/div/a/div")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/ul/li[2]/div/div/a/div")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/ul/li[3]/div/div/a/div")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/ul/li[4]/div/div/a/div")));
		} catch (Error e) {
			return false;
		}
		System.out.println("Help looks ok...");
		driver.findElement(By.xpath("//div[@id='page']/div[3]/ul/li/div/div/a/div")).click();
		try {
			assertEquals("Making a Call", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("h4.mt0")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/div[2]/div")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/div[3]/div")));
		} catch (Error e) {
			return false;
		}

		System.out.println("	Making a Call looks ok");
		driver.get(baseUrl+"/?more_info=1");
		driver.findElement(By.xpath("//div[@id='page']/div[3]/ul/li[2]/div/div/a/div")).click();
		try {
			assertEquals("Adding Funds", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("div.header.first")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/div[4]/div")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("h4.mt0")));
		} catch (Error e) {
			return false;
		}
		System.out.println("	Adding Funds looks ok");
		driver.get(baseUrl+"/?more_info=1");
		driver.findElement(By.xpath("//div[@id='page']/div[3]/ul/li[3]/div/div/a/div")).click();
		try {
			assertEquals("Frequently Asked Questions", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("General", driver.findElement(By.linkText("General")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("International Calling", driver.findElement(By.linkText("International Calling")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Mobile Top-Up", driver.findElement(By.linkText("Mobile Top-Up")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Mobile Apps")));
		} catch (Error e) {
			return false;
		}
		System.out.println("	FAQ looks ok");
		driver.findElement(By.linkText("General")).click();
		try {
			assertEquals("Boss Revolution Customers - FAQ - General", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("G2")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("G9")));
		} catch (Error e) {
			return false;
		}
		System.out.println("		General looks ok");
		driver.get(baseUrl+"/customers/faq");
		driver.findElement(By.linkText("International Calling")).click();
		try {
			assertEquals("FAQ - International Calling", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("PC1")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("PC5")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("PC7")));
		} catch (Error e) {
			return false;
		}
		System.out.println("		International Calling looks ok");
		driver.get(baseUrl+"/customers/faq");
		driver.findElement(By.linkText("Mobile Top-Up")).click();
		try {
			assertEquals("FAQ - Mobile Top-Up", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MTU1")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MTU6")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MTU14")));
		} catch (Error e) {
			return false;
		}
		System.out.println("		Mobile Top-Up looks ok");
		driver.get(baseUrl+"/customers/faq");
		driver.findElement(By.linkText("Mobile Apps")).click();
		try {
			assertEquals("Boss Revolution Customers - FAQ - Mobile Apps", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MA1")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MA9")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MA15")));
		} catch (Error e) {
			return false;
		}
		System.out.println("		Mobile Apps looks ok");
		driver.get(baseUrl+"/?more_info=1");
		driver.findElement(By.xpath("//div[@id='page']/div[3]/ul/li[4]/div/div/a/div")).click();
		try {
			assertEquals("Boss Revolution Customers - Contact Us", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.ui-link-inherit")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/ul/li[2]/div/div/a")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[3]/ul/li[3]/div/div/a")));
		} catch (Error e) {
			return false;
		}
		System.out.println("	Contact Us looks ok");
		return true;
	}

	public boolean otherCount(){
		System.out.println("Testing Other Countries");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Other Countries")).click();
		try {
			assertEquals("Boss Revolution Customers - Other Countries", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("div.flag.us")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("div.flag.sg")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("div.au.flag")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("div.es.flag")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean imtu(){
		System.out.println("Testing IMTU...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Send Mobile Top-Up")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p")))
			if("Your credit card on file can not be used for topups. Please update you credit card in Update Billing info or contact Customer Services.".equals(driver.findElement(By.cssSelector("div.toast-item.toast-type-error > p")).getText()))
				return false;
		driver.findElement(By.cssSelector("a.ui-link-inherit")).click();
		try {
			assertEquals("International Mobile Top-Up", driver.findElement(By.cssSelector("h3 > span")).getText());
		} catch (Error e) {
			return false;
		}
		//new Select(driver.findElement(By.id("country"))).selectByVisibleText("Nigeria");
		Select q=new Select(driver.findElement(By.id("country")));
		if(q.getOptions().size()==0) return false;
		q.selectByVisibleText("Nigeria");
		Select w=new Select(driver.findElement(By.id("product")));
		w.selectByValue(w.getOptions().get(1).getAttribute("value"));
		//new Select(driver.findElement(By.id("product"))).selectByVisibleText("$11.20");
		driver.findElement(By.id("receiver")).clear();
		driver.findElement(By.id("receiver")).sendKeys("2347081311257");
		driver.findElement(By.id("imtu_cc_info")).click();
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Thank you. Your purchase was successful and the International Mobile Number recharged.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}


	public boolean logout(){
		System.out.println("Logging Out...");
		driver.findElement(By.cssSelector("a.logout.ui-link")).click();
		try {
			assertEquals("Successfully logged out.", driver.findElement(By.cssSelector("p")).getText());
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
			/////////////////////////////////////////////////4
			if(autoRC()){
				System.out.println("[Sucess]Updated Auto Recharge successfully");
				screenShot("Auto Recharge");
				result[4]=1;
			}else{
				screenShot("Auto Recharge");
				System.err.println("[Error]Failed to update Auto Reharge");
			}
			/////////////////////////////////////////////////9
			if(registeredNumbers()){
				System.out.println("[Sucess]Changed Numbers Successfully");
				screenShot("Registered Numbers");
				result[9]=1;
			}else{
				screenShot("Registered Numbers");
				System.err.println("[Error]Failed to Change Numbers");
			}
			/////////////////////////////////////////////////11
			if(speedDial()){
				System.out.println("[Sucess]Changed Numbers Successfully");
				screenShot("Speed Dial");
				result[11]=1;
			}else{
				screenShot("Speed Dial");
				System.err.println("[Error]Failed to Change Numbers");
			}
			/////////////////////////////////////////////////12
			if(updateDetails()){
				System.out.println("[Sucess]Updated Billing Info Successfully");
				screenShot("Billing info");
				result[12]=1;
			}else{
				screenShot("Billing info");
				System.err.println("[Error]Failed to update Billing Info");
			}
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
			/////////////////////////////////////////////////6
			if(imtu()){
				System.out.println("[Sucess]IMTU Successful");
				screenShot("IMTU");
				result[6]=1;
			}else{
				screenShot("IMTU");
				System.err.println("[Error]IMTU Failed");
			}
			/////////////////////////////////////////////////
		}
		if(links){
			/////////////////////////////////////////////////8

			/////////////////////////////////////////////////13
			if(wib()){
				System.out.println("[Sucess]What is BOSS? looks OK");
				result[13]=1;
			}else{
				screenShot("What is Boss");
				System.err.println("[Error]Something wrong with What is BOSS?");
			}
			/////////////////////////////////////////////////14
			if(callRates()){
				System.out.println("[Sucess]Call Rates looks OK");
				result[14]=1;
			}else{
				screenShot("Call Rates");
				System.err.println("[Error]Something wrong with Call Rates");
			}
			if(mobileApp()){
				System.out.println("[Sucess]Mobile Apps looks OK");
				result[15]=1;
			}else{
				screenShot("Mobile Apps");
				System.err.println("[Error]Something wrong with Mobile Apps");
			}
			/////////////////////////////////////////////////16
			if(help()){
				System.out.println("[Sucess]Help, Faq, and Contact Us look OK");
				result[16]=1;
			}else{
				screenShot("Help");
				System.err.println("[Error]Something wrong with Help, Faq, and Contact Us");
			}
			/////////////////////////////////////////////////17
			if(otherCount()){
				System.out.println("[Sucess]Other Countries looks OK");
				result[17]=1;
			}else{
				screenShot("Other Countries");
				System.err.println("[Error]Something wrong with Other Countries");
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
		if(update||payment||links)
			/////////////////////////////////////////////////18
			if(logout()){
				System.out.println("[Sucess]Logged out Successfully");
				result[18]=1;
			}else{
				screenShot("Log Out");
				System.err.println("[Error]Failed to Logout");
			}
		if(creation)
			if(createCust()){
				System.out.println("[Success]Created Customer Successfully");
				screenShot("Customer Creation");
				result[19] = 1;
			}else{
				screenShot("Customer Creation");
				System.err.println("[Error]Failed to Create Customer");
			}
		return true;
	}

	public void print(){
		r=1;
		boolean ayOk = true;
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("***Testing Comlpete***");
		System.out.println("");
		System.out.println("**HK Customer Mobile**");
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
		if(update){
			//registered number//////////////////////
			if(result[9]==1){
				System.out.println(r+") Updated Registered Numbers Successfully");
				results[r++]=r-1+") Updated Registered Numbers Successfully";
			}else{
				System.out.println(r+") Failed to update Registered Numbers");
				results[r++]=r-1+"){color:red} Failed to update Registered Numbers{color}";
				ayOk = false;
			}
			//SD//////////////////////

			if(result[11]==1){
				System.out.println(r+") Updated Speed Dial Numbers Successfully");
				results[r++]=r-1+") Updated Speed Dial Numbers Successfully";
			}else{
				System.out.println(r+") Speed Dial update Failed");
				results[r++]=r-1+"){color:red} Speed Dial update Failed{color}";
				ayOk = false;
			}
			//Update Details//////////////////////
			if(result[12]==1){
				System.out.println(r+") Updated Billing Info Successfully");
				results[r++]=r-1+") Updated Billing Info Successfully";
			}else{
				System.out.println(r+") Failed to update Billing Info");
				results[r++]=r-1+"){color:red} Failed to update Billing Info{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[4]==1){
				System.out.println(r+") Updated Auto Recharge Successfully");
				results[r++]=r-1+") Updated Auto Recharge Successfully";
			}else{
				System.out.println(r+") Failed to Update Auto Recharge");
				results[r++]=r-1+"){color:red} Failed to Update Auto Recharge{color}";
				ayOk = false;
			}
		}
		if(payment){
			//IMTU//////////////////////
			if(result[6]==1){
				System.out.println(r+") IMTU Successful");
				Email y = new Email(usr);
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
			//recharge//////////////////////
			if(result[3]==1){
				System.out.println(r+") Recharge Successful");
				results[r++]=r-1+") Recharge Successful";
			}else{
				System.out.println(r+") Recharge Unsuccessful");
				results[r++]=r-1+"){color:red} Recharge Unsuccessful{color}";
				ayOk = false;
			}
		}

		if(links){
			//Navigation//////////////////////
			if(result[2]==1 && result[13]==1 && result[14]==1 && result[15]==1 && result[17]==1){
				System.out.println(r+") Other Links are Correct");
				results[r++]=r-1+") Other Links are Correct";
			}else{
				System.out.println(r+") Incorrect Link(s) Present");
				results[r++]=r-1+"){color:red} Incorrect Link(s) Present{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[16]==1){
				System.out.println(r+") Help/Faq/Contact Us  look OK");
				results[r++]=r-1+") Help/Faq/Contact Us  look OK";
			}else{
				System.out.println(r+") Something wrong with Help/Faq/Contact Us");
				results[r++]=r-1+"){color:red} Something wrong with Help/Faq/Contact Us{color}";
				ayOk = false;
			}
		}
		if(update||payment||links)
			//Logout//////////////////////
			if(result[18]==1){
				System.out.println(r+") Logout Successful");
				results[r++]=r-1+") Logout Successful";
			}else{
				System.out.println(r+") Logout Failed");
				results[r++]=r-1+"){color:red} Logout Failed{color}";
				ayOk = false;
			}
		if(creation)
			if(result[19]==1){
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