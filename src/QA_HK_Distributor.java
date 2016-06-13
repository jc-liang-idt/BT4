
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



public class QA_HK_Distributor  {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private String[] results = new String[17];
	private String[] pics = new String[18];
	private int[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int picCount=0;
	String r1,r1p;
	String r2,r2p;
	String r3,r3p;
	String r4,r4p;
	private String usr;
	private String pw;
	private String bossVersion;
	private int r;
	private boolean update, payment, creation, links;
	private String securityAns;
	private String newNum;
	private String funded;

	public QA_HK_Distributor(String a, String b, String c, String d, boolean e, boolean f, boolean g, boolean h){
		usr = a;
		pw = b;
		securityAns = c;
		bossVersion = d;
		update = e;
		creation = f;
		payment = g;
		links = h;
	}

	//@Before
	public void setUp() throws Exception {
		//System.setProperty("webdriver.firefox.bin", "src/res/Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.firefox.bin", "Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
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
			FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\HK_Distributor_"+error+".png"));
			pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\HK_Distributor_"+error+".png";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileUtils.deleteQuietly(scrFile);
	}

	public String randNum(String w){
		String q;
		do
			q="852" + String.valueOf((int)(Math.floor((Math.random() * 10000000)+89999999)));
		while(q.equals(usr) || q.equals(w));
		return q;
	}

	public String date(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public boolean login(){
		System.out.println("Logging in...");
		driver.findElement(By.id("user_session_login")).clear();
		driver.findElement(By.id("user_session_login")).sendKeys(usr);
		driver.findElement(By.id("user_session_password")).clear();
		driver.findElement(By.id("user_session_password")).sendKeys(pw);
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		if(isElementPresent(By.id("security_answer"))){
			driver.findElement(By.id("security_answer")).clear();
			driver.findElement(By.id("security_answer")).sendKeys(securityAns);
			driver.findElement(By.id("security_qa_save")).click();
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		}
		try {
			assertEquals("Confirm Email and Mobile Number", driver.findElement(By.cssSelector("h1")).getText());
			do{
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys("testbossrev@gmail.com");
				driver.findElement(By.name("email_request_code_btn")).click();

				Email q = new Email(usr);
				String w = q.getMail2("is");
				if(w.equals("hi")) return false;
				int r = w.indexOf("is:");
				w=w.substring(r+3,r+12);
				System.out.println(w);

				driver.findElement(By.id("email_code")).sendKeys(w);
				driver.findElement(By.name("verify_email_btn")).click();
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (isElementPresent(By.name("mobile_request_code_btn"))) break; } catch (Exception e) {}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}while(isElementPresent(By.cssSelector("div.error")));
			driver.findElement(By.id("mobile")).clear();
			driver.findElement(By.id("mobile")).sendKeys(usr);
			driver.findElement(By.name("mobile_request_code_btn")).click();
			veriCode window = new veriCode();
			String b=window.gotIt();
			driver.findElement(By.id("mobile_code")).clear();
			driver.findElement(By.id("mobile_code")).sendKeys(b);
			driver.findElement(By.name("verify_mobile_btn")).click();
			for (int second = 0;; second++) {
		    	if (second >= 60) fail("timeout");
		    	try { if (isElementPresent(By.name("mobile_request_code_btn"))) break; } catch (Exception e) {}
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					
				}
		    }
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isElementPresent(By.cssSelector("div.error"))) return false;
			driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
			} catch (Error e) {
		}
		try {
			assertEquals("Confirm Your Identity", driver.findElement(By.cssSelector("h1")).getText());
			driver.findElement(By.name("spec_email")).click();
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
			
			Email q = new Email(usr);
			String w = q.getMail2("code");
			if(w.equals("hi")) return false;
			int r = w.indexOf("is:");
			w=w.substring(r+3,r+12);

			driver.findElement(By.id("temp_code")).clear();
			driver.findElement(By.id("temp_code")).sendKeys(w);
			driver.findElement(By.id("remember_computer")).click();
		    driver.findElement(By.name("commit")).click();
		    
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		} catch (Error e) {
		}
		if(isElementPresent(By.cssSelector("div.buttonsX > input[type=\"submit\"]")))
			driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
		try {
			assertEquals("Home", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}



	public boolean updateInfo(){
		System.out.println("Updating Personal Details...");
		driver.findElement(By.xpath("//div[@id='content']/div/div[5]/ul/li[5]/a/span[2]")).click();
		driver.findElement(By.linkText("Update My Personal Details")).click();
		try {
			assertEquals("Update My Personal Details", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).clear();
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).sendKeys(randNum("1"));
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).sendKeys("Updated "+date());
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("Personal Details");
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[2]")).click();
		try {
			assertEquals("Update My Personal Details", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).sendKeys("Updated "+date());
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[3]")).click();

		driver.findElement(By.id("old_password")).clear();
		driver.findElement(By.id("old_password")).sendKeys(pw);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pw);
		driver.findElement(By.id("password_confirmation")).clear();
		driver.findElement(By.id("password_confirmation")).sendKeys(pw);
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Account successfully updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			driver.findElement(By.linkText("Update My Personal Details")).click();
			//driver.findElement(By.xpath("//div[@id='tabnav']/a[4]")).click();
			login();
		} catch (Error e) {
			return false;
		}
		/*try {
			assertEquals("Billing Information", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Billing Cycle", driver.findElement(By.xpath("//form[@id='edit_business_entity_6144735']/div[4]/label")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Amount Due", driver.findElement(By.xpath("//form[@id='edit_business_entity_6144735']/div[8]/label")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Credit Card", driver.findElement(By.cssSelector("#credit_card_label > label.optional.ui-mini")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Next Invoice Date", driver.findElement(By.xpath("//form[@id='edit_business_entity_6144735']/div[9]/label")).getText());
		} catch (Error e) {
			return false;
		}*/
		return true;
	}

	public boolean defaultComm(){
		System.out.println("Updating Default Commissions...");
		driver.findElement(By.linkText("Default Commissions")).click();
		try {
			assertEquals("Default Commissions", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("ec__fs")).click();
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("1 record successfully saved", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("ec__fs")).click();
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("1 record successfully saved", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean R1(){
		System.out.println("Creating Cash-Cash Retailer...");
		driver.findElement(By.cssSelector("span.lbl")).click();
		try {
			assertEquals("Register Retailer", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.select_account_type > div")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.cssSelector("a.select_account_type > div")).click();
		driver.findElement(By.id("business_entity_creation_load_amount")).clear();
		driver.findElement(By.id("business_entity_creation_load_amount")).sendKeys("20");
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).sendKeys("1234");
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).sendKeys("1234");
		driver.findElement(By.id("business_entity_user_attributes_access_profiles")).click();
		driver.findElement(By.id("business_entity_name")).clear();
		driver.findElement(By.id("business_entity_name")).sendKeys("King's Landing");
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).clear();
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).sendKeys("85233333333");
		driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("Marjorie");
		driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("Tyrell");
		driver.findElement(By.id("business_entity_user_attributes_email")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 Always Way");
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Retailer created successfully.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		r1 = driver.findElement(By.id("account_number")).getAttribute("value");
		Email q = new Email(usr);
		String w = q.getMail3("Marjorie","hk");
		if(!w.equals("hi")){		
		int r = w.indexOf("code");
		r1p=w.substring(r+8,r+12);
		//System.out.println(r1p);
		}
		return true;
	}

	public boolean R2(){
		System.out.println("Creating Cash-Credit Retailer...");
		driver.findElement(By.linkText("Register Retailer")).click();
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/a[2]/div")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/a[2]/div")).click();
		driver.findElement(By.id("business_entity_creation_load_amount")).clear();
		driver.findElement(By.id("business_entity_creation_load_amount")).sendKeys("20");
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).sendKeys("1234");
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).sendKeys("1234");
		driver.findElement(By.id("business_entity_name")).clear();
		driver.findElement(By.id("business_entity_name")).sendKeys("Lannisport");
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).clear();
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).sendKeys("85233333333");
		driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("Daenerys");
		driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("Targaryen");
		driver.findElement(By.id("business_entity_user_attributes_email")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("Daenerys Targaryen");
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_month"))).selectByVisibleText("03");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 Always Way");
		driver.findElement(By.id("copy_from_billing")).click();
		driver.findElement(By.id("business_entity_submit")).click();
		//if(isElementPresent(By.id("jqdialog_message"))) return false;
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Retailer created successfully.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		r2 = driver.findElement(By.id("account_number")).getAttribute("value");
		Email q = new Email(usr);
		String w = q.getMail3("Daenerys","hk");
		if(w.equals("hi")) return  true;
		int r = w.indexOf("code");
		r2p=w.substring(r+8,r+12);
		//System.out.println(r2p);
		return true;
	}

	public boolean R3(){
		System.out.println("Creating Credit-Credit Retailer...");
		driver.findElement(By.linkText("Register Retailer")).click();
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/a[3]/div")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/a[3]/div")).click();
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).sendKeys("1234");
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).sendKeys("1234");
		driver.findElement(By.id("business_entity_user_attributes_credit_limit_100")).clear();
		driver.findElement(By.id("business_entity_user_attributes_credit_limit_100")).sendKeys("20");
		driver.findElement(By.id("business_entity_name")).clear();
		driver.findElement(By.id("business_entity_name")).sendKeys("The Vale of Arryn");
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).clear();
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).sendKeys("85233333333");
		driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("Catelyn");
		driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("Stark");
		driver.findElement(By.id("business_entity_user_attributes_email")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 Always Way");
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Retailer created successfully.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		r3 = driver.findElement(By.id("account_number")).getAttribute("value");
		Email q = new Email(usr);
		String w = q.getMail3("Catelyn","hk");
		if(w.equals("hi")) return  true;
		int r = w.indexOf("code");
		r3p=w.substring(r+8,r+12);
		//System.out.println(r3p);
		return true;
	}

	public boolean R4(){
		System.out.println("Creating Credit-Invoice Retailer...");
		driver.findElement(By.linkText("Register Retailer")).click();
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/a[4]/div")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/a[4]/div")).click();
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code")).sendKeys("1234");
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).clear();
		//driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).sendKeys("1234");
		//driver.findElement(By.id("business_entity_user_attributes_credit_limit_100")).clear();
		driver.findElement(By.id("business_entity_user_attributes_credit_limit_100")).sendKeys("20");
		driver.findElement(By.id("business_entity_name")).clear();
		driver.findElement(By.id("business_entity_name")).sendKeys("The Wall");
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).clear();
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).sendKeys("85233333333");
		driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("John");
		driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("Snow");
		driver.findElement(By.id("business_entity_user_attributes_email")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("John Snow");
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_month"))).selectByVisibleText("05");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 Always Way");
		driver.findElement(By.id("copy_from_billing")).click();
		driver.findElement(By.id("business_entity_submit")).click();
		//if(isElementPresent(By.id("jqdialog_message"))) return false;
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Retailer created successfully.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		r4 = driver.findElement(By.id("account_number")).getAttribute("value");
		Email q = new Email(usr);
		String w = q.getMail3("John","hk");
		if(w.equals("hi")) return  true;
		int r = w.indexOf("code");
		r4p=w.substring(r+8,r+12);
		//System.out.println(r4p);
		return true;
	}

	public boolean manageRetail(){
		System.out.println("Managing Retailers...");
		driver.findElement(By.linkText("Manage Retailers")).click();
		try {
			assertEquals("Manage Retailers", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("account_number")).clear();
		driver.findElement(By.id("account_number")).sendKeys(r1);
		driver.findElement(By.name("commit")).click();
		try {
			assertTrue(isElementPresent(By.linkText("Manage")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("Manage")).click();
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='tabnav']/a")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_user_attributes_active")).click();
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Retailer details have been updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("Manage Retailers");
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_user_attributes_active")).click();
		driver.findElement(By.id("business_entity_submit")).click();
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='tabnav']/a[2]")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[2]")).click();
		driver.findElement(By.id("ec__fs")).click();
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("1 record successfully saved", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		if(isElementPresent(By.xpath("//div[@id='tabnav']/a[3]"))){
			driver.findElement(By.xpath("//div[@id='tabnav']/a[3]")).click();
			driver.findElement(By.id("amount")).clear();
			driver.findElement(By.id("amount")).sendKeys("1");
			driver.findElement(By.name("commit")).click();
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
			try {
				assertEquals("The recharge was successful", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			} catch (Error e) {
				return false;
			}
		}
		try {
			assertTrue(isElementPresent(By.linkText("Messages")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("Messages")).click();
		return true;
	}

	public boolean manageSales(){
		System.out.println("Managing Sales Agents...");
		driver.findElement(By.linkText("Manage My Sales People")).click();
		try {
			assertEquals("Manage My Sales People", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		newNum="t"+randNum("1");
		driver.findElement(By.linkText("Register Salesperson")).click();
		driver.findElement(By.id("business_entity_user_attributes_login")).clear();
		driver.findElement(By.id("business_entity_user_attributes_login")).sendKeys(newNum);
		driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("Hodor");
		driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("Hodor");
		driver.findElement(By.id("business_entity_user_attributes_password")).clear();
		driver.findElement(By.id("business_entity_user_attributes_password")).sendKeys("1234");
		driver.findElement(By.id("business_entity_user_attributes_password_confirmation")).clear();
		driver.findElement(By.id("business_entity_user_attributes_password_confirmation")).sendKeys("1234");
		driver.findElement(By.id("business_entity_user_attributes_email")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_user_attributes_cash_limit_100")).clear();
		driver.findElement(By.id("business_entity_user_attributes_cash_limit_100")).sendKeys("50");
		driver.findElement(By.id("business_entity_user_attributes_credit_limit_100")).clear();
		driver.findElement(By.id("business_entity_user_attributes_credit_limit_100")).sendKeys("50");
		driver.findElement(By.id("new_sales_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Salesperson created successfully.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("Manage Sales Agent");
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("New Search")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(newNum);
		driver.findElement(By.name("commit")).click();
		try {
			assertEquals(newNum, driver.findElement(By.cssSelector("tr.even > td.l")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("Manage")).click();
		try {
			assertEquals("Edit Salesperson", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_user_attributes_active")).click();
		driver.findElement(By.id("sales_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Salesperson details have been updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_user_attributes_active")).click();
		driver.findElement(By.id("sales_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Salesperson details have been updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean fundRetail(){
		System.out.println("Funding Retailers...");
		driver.findElement(By.xpath("//div[@id='content']/div/div[5]/ul/li/a/span[2]")).click();
		if(creation){
			driver.findElement(By.id("account_number")).clear();
			driver.findElement(By.id("account_number")).sendKeys(r1);
		}
		driver.findElement(By.name("commit")).click();
		if(!isElementPresent(By.cssSelector("tr.even > td.l"))){
			result[9]=2;
			return true;
		}
		funded = driver.findElement(By.cssSelector("td.c")).getText();
		driver.findElement(By.cssSelector("input[id^='amount_']")).clear();
		driver.findElement(By.cssSelector("input[id^='amount_']")).sendKeys("1");
		driver.findElement(By.cssSelector("input[value='Transfer']")).click();
		for (int second = 0;; second++) {
			if (second >= 60) return false;
			try { 
				if (isElementPresent(By.xpath("//td[starts-with(@id,'status_')]/div[2]/p")))
					if("Successfully transferred $1.00".equals(driver.findElement(By.xpath("//td[starts-with(@id,'status_')]/div[2]/p")).getText()))
						return true;
			} catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean recharge(){
		System.out.println("Testing Recharge...");
		if(!isElementPresent(By.linkText("Manage My Account"))){
			result[10]=2;
			return true;
		}
		driver.findElement(By.linkText("Manage My Account")).click();
		/*try {
			assertEquals("Manage My Account", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}*/
		if(!isElementPresent(By.id("amount"))){
			result[10]=2;
			return true;
		}
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-success > p"))) return true;
		return false;
	}

	public boolean reports(){
		System.out.println("Testing Reports...");
		driver.findElement(By.linkText("Reports")).click();
		try {
			assertEquals("Reports", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Commission", driver.findElement(By.cssSelector("span.lbl")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Daily Transaction History (Prepaid)", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[3]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Billing Summary", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[5]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Retailer Signup", driver.findElement(By.linkText("Retailer Signup")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Transactions", driver.findElement(By.cssSelector("li.rs > a > span.lbl")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Sales Team", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[4]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("My Referrals", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[6]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Credit Distribution", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[4]/ul/li/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Retailer Activity", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[4]/ul/li[3]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Trending", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[4]/ul/li[2]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Retailers", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[4]/ul/li[4]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		System.out.println("All reports listed");
		driver.findElement(By.cssSelector("span.lbl")).click();
		try {
			assertEquals("Commission Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_id")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Commission Report looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[3]/a/span[2]")).click();
		try {
			assertEquals("Daily Transaction History (Prepaid)", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("start_date")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Daily Transaction History (Prepaid) looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[5]/a/span[2]")).click();
		try {
			assertEquals("Billing Summary Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Billing Summary Report looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[7]/a/span[2]")).click();
		try {
			assertEquals("Retailer Signup Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Retailer Signup Report looks Ok");
		driver.findElement(By.linkText("Transactions")).click();
		try {
			assertEquals("Transactions Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Transactions Report looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[4]/a/span[2]")).click();
		try {
			assertEquals("Sales Team Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("s_id")));
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("", driver.findElement(By.name("commit")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Sales Team Report looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/ul/li[6]/a/span[2]")).click();
		try {
			assertEquals("My Referrals Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("My Referrals Report looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[4]/ul/li/a/span[2]")).click();
		try {
			assertEquals("Credit Distribution Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_id")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Credit Distribution Report looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[4]/ul/li[3]/a/span[2]")).click();
		try {
			assertEquals("Retailer Activity Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_id")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Retailer Activity Report looks Ok");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[4]/ul/li[2]/a/span[2]")).click();
		try {
			assertEquals("Trending Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_id")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Trending Report looks Ok");
		driver.findElement(By.cssSelector("span.nav_button.nav_button_subs")).click();
		try {
			assertEquals("Retailers Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("r_an")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		System.out.println("Retailers Report looks Ok");
		return true;
	}

	public boolean marketMat(){
		System.out.println("Testing Marketing Materials...");
		driver.findElement(By.linkText("Marketing Materials")).click();
		try {
			assertEquals("Marketing Materials", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Boss Revolution Leaflet.pdf")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Boss Revolution PHP specific handbill.pdf")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Boss Revolution Rate Table.pdf")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean message(){
		System.out.println("Testing Message Center...");
		driver.findElement(By.linkText("Message Center")).click();
		try {
			assertEquals("Message Center", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.cssSelector("a.image_button.add_button")).click();
		try {
			assertEquals("New Message", driver.findElement(By.cssSelector("h2")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("message_title")).clear();
		driver.findElement(By.id("message_title")).sendKeys("New");
		driver.findElement(By.id("message_title")).clear();
		driver.findElement(By.id("message_title")).sendKeys("New Message");
		driver.findElement(By.id("message_body")).clear();
		driver.findElement(By.id("message_body")).sendKeys("STOP THIS MADNESS, IN THE NAME OF YOUR KING!");
		driver.findElement(By.id("message_all_salespeople")).click();
		driver.findElement(By.id("message_all_retailers")).click();
		driver.findElement(By.id("message_submit")).click();
		try {
			assertEquals("Created message \"New Message\"", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean contUs(){
		System.out.println("Testing Contact Us...");
		driver.findElement(By.linkText("Contact Us")).click();
		try {
			assertEquals("Contact Us", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Please call Customer Services at 2159 9083.", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Contact Us')])[2]")).click();
		try {
			assertEquals("Contact Us", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Please call Customer Services at 2159 9083.", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean compCard(){
		System.out.println("Testing Comp Cards...");
		try {
			assertTrue(isElementPresent(By.cssSelector("span.compcard.visa")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("span.compcard.mastercard")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("span.amex.compcard")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='footer']/div[3]/a[2]/img")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.compcard.facebook")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean homePage(){
		System.out.println("Checking Home page...");
		try {
			assertEquals("Home", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals(usr, driver.findElement(By.cssSelector("td.dat")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("span.lbl")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.c_lime.prod > span.lbl")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.c_orange.prod > span.lbl")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Fund Retailers")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/div/div[5]/ul/li[3]/a/span[2]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/div/div[5]/ul/li[8]/a/span[2]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean logout(){
		System.out.println("Logging Out...");
		driver.findElement(By.id("log-out")).click();
		try {
			assertEquals("Successfully logged out.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//@Test
	public boolean test() throws Exception {
		//open browser///////////////////////////////////////////////
		System.out.println("Opening Distributor Portal");
		driver.get(baseUrl + "distributors/login");
		//log in///////////////////////////////////////////////
		if(login()){
			System.out.println("[Success]Login successful");
			result[0]=1;
		}else{
			screenShot("Login");
			System.err.println("[Error]Failed to Login, ending test");
			tearDown();
			return false;
		}


		if(update){
			/////////////////////////////////////////////////
			if(updateInfo()){
				System.out.println("[Sucess]Updated Personal Details Successfully");
				result[1]=1;
			}else{
				screenShot("Personal Details");
				System.err.println("[Error]Failed to Update Personal Details");
			}
			/////////////////////////////////////////////////
			if(defaultComm()){
				System.out.println("[Sucess]Updated Default Commissions Successfully");
				screenShot("Default Commissions");
				result[2]=1;
			}else{
				screenShot("Default Commissions");
				System.err.println("[Error]Failed to Update Default Commissions");
			}
			driver.get(baseUrl+"distributors/home/");	
		}

		if(creation){
			/////////////////////////////////////////////////
			if(R1()){
				System.out.println("[Sucess]Created Cash-Cash Retailer Successfully");
				screenShot("Cash-Cash");
				result[3]=1;
			}else{
				screenShot("Cash-Cash");
				System.err.println("[Error]Failed to create Cash-Cash Retailer");
			}
			/////////////////////////////////////////////////
			if(R2()){
				System.out.println("[Sucess]Created Cash-Credit Retailer Successfully");
				screenShot("Cash-Credit");
				result[4]=1;
			}else{
				screenShot("Cash-Credit");
				System.err.println("[Error]Failed to create Cash-Credit Retailer");
			}
			/////////////////////////////////////////////////
			if(R3()){
				System.out.println("[Sucess]Created Credit-Credit Retailer Successfully");
				screenShot("Credit-Credit");
				result[5]=1;
			}else{
				screenShot("Credit-Credit");
				System.err.println("[Error]Failed to create Credit-Credit Retailer");
			}
			/////////////////////////////////////////////////
			if(R4()){
				System.out.println("[Sucess]Created Credit-Invoice Retailer Successfully");
				screenShot("Credit-Invoice");
				result[6]=1;
			}else{
				screenShot("Credit-Invoice");
				System.err.println("[Error]Failed to create Credit-Invoice Retailer");
			}
			/////////////////////////////////////////////////
			if(manageRetail()){
				System.out.println("[Sucess]Successfully Managed Retailers");
				result[7]=1;
			}else{
				screenShot("Manage Retailers");
				System.err.println("[Error]Failed to Manage Retailers");
			}
			/////////////////////////////////////////////////
			if(manageSales()){
				System.out.println("[Sucess]Managed Sales Agents Successfully");
				result[8]=1;
			}else{
				screenShot("Manage Sales Agent");
				System.err.println("[Error]Faild to manage Sales Agents");
			}
			driver.get(baseUrl+"distributors/home/");	
		}




		if(payment){
			/////////////////////////////////////////////////
			if(fundRetail()){
				if(result[9]!=2){
					System.out.println("[Sucess]Funded Retailer Sucessfully");
					screenShot("Fund Retailers");
					result[9]=1;
				}else{
					System.err.println("No Retailers to Fund");
				}
			}else{
				screenShot("Fund Retailers");
				System.err.println("[Error]Failed to Fund Retailer");
			}
			/////////////////////////////////////////////////
			if(recharge()){
				if(result[10]!=2){
					System.out.println("[Sucess]Recharged Sucessfully");
					screenShot("Recharge");
					result[10]=1;
				}else{
					System.err.println("Unrechargeable Account");
				}
			}else{
				screenShot("Recharge");
				System.err.println("[Error]Failed to Recharge Account");
			}
			driver.get(baseUrl+"distributors/home/");	
		}



		if(links){
			/////////////////////////////////////////////////
			if(reports()){
				System.out.println("[Sucess]Reports Look Ok");
				result[11]=1;
			}else{
				screenShot("Reports");
				System.err.println("[Error]Something Wrong with Reports");
			}
			/////////////////////////////////////////////////
			if(marketMat()){
				System.out.println("[Sucess]Marketing Materials Look Ok");
				result[12]=1;
			}else{
				screenShot("Marketing Materials");
				System.err.println("[Error]Something Wrong with Marketing Materials");
			}
			/////////////////////////////////////////////////
			if(message()){
				System.out.println("[Sucess]Message Center Works");
				result[13]=1;
			}else{
				screenShot("Message Center");
				System.err.println("[Error]Something wrong with Message Center");
			}
			if(contUs()){
				System.out.println("[Sucess]Contact Us look Ok");
				result[14]=1;
			}else{
				screenShot("Contact Us");
				System.err.println("[Error]Something wrong with Contact Us");
			}
			if(compCard()){
				System.out.println("[Sucess]Comp Cards look Ok");
				result[15]=1;
			}else{
				screenShot("Comp Cards");
				System.err.println("[Error]Something wrong with Comp Cards");
			}
			driver.get(baseUrl+"distributors/home/");	
			if(homePage()){
				System.out.println("[Sucess]Home Page looks Ok");
				result[16]=1;
			}else{
				screenShot("Home Page");
				System.err.println("[Error]Something wrong with Home Page");
			}
		}

		if(logout()){
			System.out.println("[Sucess]Logout Successful");
			result[17]=1;
		}else{
			screenShot("Logout");
			System.err.println("[Error]Logout Failed");
		}
		return true;
	}

	public void print(){
		boolean ayOk = true;
		r=2;
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("***Testing Complete***");
		System.out.println("");
		System.out.println("**HK Distributor**");
		//login//////////////////////
		if(result[0]==1){
			System.out.println("1) Login Successful - "+usr+ ":" + pw);
			results[1]="1) Login Successful - "+usr+ ":" + pw;
		}else{
			System.out.println("1) Login Unsuccessful");
			results[1]="1){color:red} Login Unsuccessful{color}";
			ayOk = false;
		}
		if(update){
			////////////////////////
			if(result[1]==1){
				System.out.println(r+") Updated Personal Details Successfully");
				results[r++]=r-1+") Updated Personal Details Successfully";
			}else{
				System.out.println(r+") Failed to update Personal Details");
				results[r++]=r-1+"){color:red} Failed to update Personal Details{color}";
				ayOk = false;
			}
			if(result[2]==1){
				System.out.println(r+") Updated Default Commissions Successfully");
				results[r++]=r-1+") Updated Default Commissions Successfully";
			}else{
				System.out.println(r+") Failed to Update Default Commissions");
				results[r++]=r-1+"){color:red} Failed to Update Default Commissions{color}";
				ayOk = false;
			}
		}
		////////////////////////
		if(creation){
			if(result[3]==1){
				System.out.println(r+") Created new Cash-Cash Retailer Successfully - "+r1+":"+r1p);
				results[r++]=r-1+") Created new Cash-Cash Retailer Successfully - "+r1+":"+r1p;
			}else{
				System.out.println(r+") Failed to Create new Cash-Cash Retailer");
				results[r++]=r-1+"){color:red} Failed to Create new Cash-Cash Retailer{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[4]==1){
				System.out.println(r+") Created new Cash-Credit Retailer Successfully - "+r2+":"+r2p);
				results[r++]=r-1+") Created new Cash-Credit Retailer Successfully - "+r2+""+r2p;
			}else{
				System.out.println(r+") Failed to Create new Cash-Credit Retailer");
				results[r++]=r-1+"){color:red} Failed to Create new Cash-Credit Retailer{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[5]==1){
				System.out.println(r+") Created new Credit-Credit Retailer Successfully - "+r3+":"+r3p);
				results[r++]=r-1+") Created new Credit-Credit Retailer Successfully - "+r3+":"+r3p;
			}else{
				System.out.println(r+") Failed to Create new Credit-Credit Retailer");
				results[r++]=r-1+"){color:red} Failed to Create new Credit-Credit Retailer{color}";
				ayOk = false;
			}
			if(result[6]==1){
				System.out.println(r+") Created new Credit-Invoice Retailer Successfully - "+r4+":"+r4p);
				results[r++]=r-1+") Created new Credit-Invoice Retailer Successfully - "+r4+":"+r4p;
			}else{
				System.out.println(r+") Failed to Create new Credit-Invoice Retailer");
				results[r++]=r-1+"){color:red} Failed to Create new Credit-Invoice Retailer{color}";
				ayOk = false;
			}
			if(result[7]==1){
				System.out.println(r+") Managed Retailer Successfully - "+r1);
				results[r++]=r-1+") Managed Retailer Successfully - "+r1;
			}else{
				System.out.println(r+") Failed to Manage Retailer");
				results[r++]=r-1+"){color:red} Failed to Manage Retailer{color}";
				ayOk = false;
			}
			if(result[8]==1){
				System.out.println(r+") Created new Sales Agent & Searched Successfully - "+newNum);
				results[r++]=r-1+") Created new Sales Agent & Searched Successfully - "+newNum;
			}else{
				System.out.println(r+") Failed to Create new Sales Agent/Search");
				results[r++]=r-1+"){color:red} Failed to Create new Sales Agent/Search{color}";
				ayOk = false;
			}
		}
		if(payment){
			////////////////////////
			if(result[9]!=2)
				if(result[9]==1){
					System.out.println(r+") Funded Retailer Successfully - "+funded);
					results[r++]=r-1+") Funded Retailer Successfully - "+funded;
				}else{
					System.out.println(r+") Failed to Fund Retailer");
					results[r++]=r-1+"){color:red} Failed to Fund Retailer{color}";
					ayOk = false;
				}
			////////////////////////
			if(result[10]!=2)
				if(result[10]==1){
					System.out.println(r+") Recharge Successful");
					results[r++]=r-1+") Recharge Successful";
				}else{
					System.out.println(r+") Recharge Failed");
					results[r++]=r-1+"){color:red} Recharge Failed{color}";
					ayOk = false;
				}
		}
		if(links){
			////////////////////////
			if(result[11]==1){
				System.out.println(r+") Reports looks Ok");
				results[r++]=r-1+") Reports looks Ok";
			}else{
				System.out.println(r+") Something wrong with Reports");
				results[r++]=r-1+"){color:red} Something wrong with Reports{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[12]==1){
				System.out.println(r+") Marketing Materials look Ok");
				results[r++]=r-1+") Marketing Materials look Ok";
			}else{
				System.out.println(r+") Something wrong Marketing Materials");
				results[r++]=r-1+"){color:red} Something wrong Marketing Materials{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[13]==1 ){
				System.out.println(r+") Created New Message Successfully");
				results[r++]=r-1+") Created New Message Successfully";
			}else{
				System.out.println(r+") Failed to Create new Message");
				results[r++]=r-1+"){color:red} Failed to Create new Message{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[14]==1 && result[15]==1 && result[16]==1 ){
				System.out.println(r+") Other Links look Ok");
				results[r++]=r-1+") Other Links look Ok";
			}else{
				System.out.println(r+") Something wrong with Other Links");
				results[r++]=r-1+"){color:red} Something wrong with Other Links{color}";
				ayOk = false;
			}
		}


		////////////////////////
		if(result[17]==1){
			System.out.println(r+") Logout Successful");
			results[r++]=r-1+") Logout Successful";
		}else{
			System.out.println(r+") Logout Failed");
			results[r++]=r-1+"){color:red} Logout Failed{color}";
			ayOk = false;
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