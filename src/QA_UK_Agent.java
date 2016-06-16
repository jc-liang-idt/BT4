
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class QA_UK_Agent  {
	private WebDriver driver;
	private String baseUrl;
	//private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String[] results = new String[10];
	private String[] pics = new String[26];
	private int picCount=0;
	private String newNum;
	private int[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	private String usr;
	private String pw;
	private String secAns;
	private String bossVersion;
	private int r;
	private boolean creation;
	private boolean payment;
	private boolean links;
	private String pin;
	private String dpin;

	public QA_UK_Agent(String a, String b, String c, String d, boolean e, boolean f, boolean g){
		usr = a;
		pw = b;
		secAns = c;
		bossVersion = d;
		creation = e;
		payment = f;
		links = g;
	}

	//@Before
	public void setUp() throws Exception {
		//System.setProperty("webdriver.firefox.bin", "src/res/Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.firefox.bin", "Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
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
			FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\UK_Agent_"+error+".png"));
			pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\UK_Agent_"+error+".png";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileUtils.deleteQuietly(scrFile);
	}

	public boolean login(){
		System.out.println("Logging in...");
		try {
			assertEquals("Existing Retailers", driver.findElement(By.cssSelector("h2")).getText());
			driver.findElement(By.id("user_session_login")).clear();
			driver.findElement(By.id("user_session_login")).sendKeys(usr);
			driver.findElement(By.id("user_session_password")).clear();
			driver.findElement(By.id("user_session_password")).sendKeys(pw);
			driver.findElement(By.name("commit")).click();
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))){
				return false;
			}
			try {
				assertEquals("Confirm Email and Mobile Number", driver.findElement(By.cssSelector("h1")).getText());
				do{
					driver.findElement(By.id("email")).clear();
					driver.findElement(By.id("email")).sendKeys("testbossrev@gmail.com");
					driver.findElement(By.name("email_request_code_btn")).click();

					Email q = new Email(usr);
					String w = q.getMail2("code");
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
				//if(w.equals("hi")) return false;
				int r = w.indexOf("is:");
				//w=w.substring(r+3,r+12);

				driver.findElement(By.id("temp_code")).clear();
				driver.findElement(By.id("temp_code")).sendKeys(w);
				driver.findElement(By.id("remember_computer")).click();
			    driver.findElement(By.name("commit")).click();
			    
				if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
			} catch (Error e) {
			}
			try {
				assertEquals("To keep your account secure...", driver.findElement(By.cssSelector("h1")).getText());
				driver.findElement(By.id("security_answer")).clear();
				driver.findElement(By.id("security_answer")).sendKeys(secAns);
				driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			} catch (Error e) {
			}

			if(isElementPresent(By.cssSelector("div.buttonsX > input[type=\"submit\"]")))
				driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
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
			assertEquals(usr, driver.findElement(By.xpath("//table[@id='homepage_account_info']/tbody/tr[2]/td[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Account Number", driver.findElement(By.xpath("//table[@id='homepage_account_info']/tbody/tr[2]/td")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("span.lbl")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.c_aqua.prod > span.lbl")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.c_lime.prod > span.lbl")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/div/div[5]/ul/li/a/span[2]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/div/div[5]/ul/li[2]/a/span[2]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public void createCust2(){
		driver.findElement(By.linkText("Boss Revolution PINLESS")).click();
		driver.findElement(By.id("phone_number")).clear();
		newNum = randNum("1");
		driver.findElement(By.id("phone_number")).sendKeys(newNum);
		driver.findElement(By.name("commit")).click();
	}

	public boolean createCust(){
		System.out.println("Creating Customer...");
		driver.findElement(By.cssSelector("span.lbl")).click();
		try {
			assertEquals("Boss Revolution PINLESS", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("phone_number")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("phone_number")).clear();
		newNum = randNum("1");
		driver.findElement(By.id("phone_number")).sendKeys(newNum);
		driver.findElement(By.name("commit")).click();
		if(!isElementPresent(By.cssSelector("div.toast-item.toast-type-success > p")))
			while(!isElementPresent(By.cssSelector("div.toast-item.toast-type-success > p"))){
				createCust2();
			}	
		driver.findElement(By.name("commit")).click();
		while(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))){
			createCust2();
			driver.findElement(By.name("commit")).click();
		}

		try {
			assertEquals("The customer was created successfully", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public String randNum(String w){
		String q;
		do
			q="4478945" + String.valueOf((int)(Math.floor((Math.random() * 10000)+89999)));
		while(q.equals(usr) || q.equals(w));
		return q;
	}

	public boolean custTU(){
		System.out.println("Customer-Top UP...");
		driver.findElement(By.id("amount")).clear();
		driver.findElement(By.id("amount")).sendKeys("1");
		driver.findElement(By.name("commit")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//button[@type='button']"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.findElement(By.xpath("//button[@type='button']")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("td.biglabel"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("The recharge was successful", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean setupRC(){
		System.out.println("Customer-Auto Recharge...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[2]")).click();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 always way");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).sendKeys("london");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("12345");
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("John Snow");
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("4387751111111038");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
		driver.findElement(By.id("business_entity_submit")).click();
		//if(isElementPresent(By.id("jqdialog_message"))) return false;
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.cssSelector("div.toast-item.toast-type-notice > p"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Auto Recharge information updated successfully.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean registeredNumbers(){
		System.out.println("Customer-Registered Numbers...");
		int q = 0;
		do{
			if(q++==3) return false;
			driver.findElement(By.xpath("//div[@id='tabnav']/a[3]")).click();
			String w = randNum("123");
			driver.findElement(By.xpath("(//input[@id='registered_phones_'])[2]")).clear();
			driver.findElement(By.xpath("(//input[@id='registered_phones_'])[2]")).sendKeys(w);
			String e = randNum(w);
			driver.findElement(By.xpath("(//input[@id='registered_phones_'])[3]")).clear();
			driver.findElement(By.xpath("(//input[@id='registered_phones_'])[3]")).sendKeys(e);
			String r = randNum(e);
			driver.findElement(By.xpath("(//input[@id='registered_phones_'])[4]")).clear();
			driver.findElement(By.xpath("(//input[@id='registered_phones_'])[4]")).sendKeys(r);
			driver.findElement(By.name("commit")).click();
		}while(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p")));
		if("The registered numbers were successfully updated.".equals(driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText()))return true;
		return false;
	}

	public boolean quickCall(){
		System.out.println("Customer-Quick Call...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[5]")).click();
		Select q=new Select(driver.findElement(By.id("savorites__index")));
		//System.out.println(q.getOptions().get(0).toString());
		//if(q.getOptions().size()==0 || (q.getOptions().size()==1 && q.getOptions().get(0).toString().contains("firefox"))) return false;
		if(q.getOptions().size()<2) return false;
		q.selectByValue(q.getOptions().get(1).getAttribute("value"));
		driver.findElement(By.id("savorites__phone")).clear();
		driver.findElement(By.id("savorites__phone")).sendKeys("4567894"+ Math.floor((Math.random()*100000)+899999));
		driver.findElement(By.id("savorites__description")).clear();
		driver.findElement(By.id("savorites__description")).sendKeys("Test");
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("QuickCall successfully updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean speedDial(){
		System.out.println("Customer-Speed Dial...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[4]")).click();
		String q = randNum("1");
		driver.findElement(By.id("sdphone1")).clear();
		driver.findElement(By.id("sdphone1")).sendKeys(q);
		driver.findElement(By.id("sddescr1")).clear();
		driver.findElement(By.id("sddescr1")).sendKeys("Robert Stark");
		driver.findElement(By.id("sdphone2")).clear();
		driver.findElement(By.id("sdphone2")).sendKeys(randNum(q));
		driver.findElement(By.id("sddescr2")).clear();
		driver.findElement(By.id("sddescr2")).sendKeys("Ser Jorah");
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("The Speed Dial numbers were successfully updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean custSMS(){
		System.out.println("Customer-SMS...");
		driver.findElement(By.linkText("SMS")).click();
		driver.findElement(By.name("sms")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("SMS was successfully sent", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean billingHist(){
		System.out.println("Customer-Billing History...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[7]")).click();
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
			assertEquals("Date", driver.findElement(By.cssSelector("th")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Transaction", driver.findElement(By.xpath("//table[@id='customer_billing_history_table']/thead/tr/th[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Amount", driver.findElement(By.xpath("//table[@id='customer_billing_history_table']/thead/tr/th[3]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Print")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean notifLang(){
		System.out.println("Customer-Notification Language...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[8]")).click();
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Notification Language updated.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean moveService(){
		System.out.println("Customer-Move Service...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[9]")).click();
		try {
			assertTrue(isElementPresent(By.id("new_service_number")));
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Please enter as a 12 digit phone number beginning with 441, 442, or 447, e.g. 441234512345.", driver.findElement(By.cssSelector("div.msg.last")).getText());
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

	public boolean reports(){
		System.out.println("Testing Reports...");
		driver.findElement(By.linkText("Reports")).click();
		try {
			assertEquals("Reports", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Daily Transaction History", driver.findElement(By.cssSelector("span.lbl")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("My Transaction History", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[3]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Summary by Product", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[4]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean dTransHist(){
		System.out.println("Testing Daily Transaction History...");
		driver.findElement(By.cssSelector("span.lbl")).click();
		try {
			assertEquals("Daily Transaction History", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("customer_account")));
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
		try {
			assertEquals("Starting Balance", driver.findElement(By.xpath("//div[@id='content']/table[2]/tbody/tr/th[3]")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	public boolean mTransHist(){
		System.out.println("Testing My Transaction History...");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[3]/a/span[2]")).click();
		try {
			assertEquals("My Transaction History", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Starting Balance", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/th[3]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Customer Account", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/th[8]")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	public boolean imtu(){
		System.out.println("Testing IMTU...");
		driver.findElement(By.linkText("International Mobile Top-Up")).click();
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Purchase PIN");
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("RU");
		driver.findElement(By.id("sender_phone")).clear();
		driver.findElement(By.id("sender_phone")).sendKeys(usr);
		driver.findElement(By.id("imtu_request_email")).clear();
		driver.findElement(By.id("imtu_request_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			
			// switch to active modal frame
			driver.switchTo().activeElement();
			// find the Continue bottom from the modal
			driver.findElement(By.xpath("//div[contains(@class, 'ui-dialog-buttonset')]/button[1]")).click();
			
			assertEquals("Thank you. Your IMTU purchase was successful.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("IMTU");
		} catch (Error e) {
			return false;
		}
		pin = driver.findElement(By.xpath("//div[@id='invoice']/p[11]")).getText();
		driver.findElement(By.linkText("International Mobile Top-Up")).click();
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Redeem PIN");
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("RU");
		driver.findElement(By.name("imtu_request[receiver_phone]")).clear();
		driver.findElement(By.name("imtu_request[receiver_phone]")).sendKeys("4125658987");
		driver.findElement(By.id("pin")).sendKeys(pin);
		driver.findElement(By.id("sender_phone")).clear();
		driver.findElement(By.id("sender_phone")).sendKeys(usr);
		driver.findElement(By.id("imtu_request_email")).clear();
		driver.findElement(By.id("imtu_request_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			
			// switch to active modal frame
			driver.switchTo().activeElement();
			// find the Continue bottom from the modal
			driver.findElement(By.xpath("//div[contains(@class, 'ui-dialog-buttonset')]/button[1]")).click();
			
			assertEquals("Thank you. The International Mobile Number has been recharged.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("International Mobile Top-Up")).click();
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Find Record");
		driver.findElement(By.id("imtu_search_request_pin")).click();
		driver.findElement(By.id("imtu_search_request_pin")).clear();
		driver.findElement(By.id("imtu_search_request_pin")).sendKeys(pin);
		driver.findElement(By.cssSelector("#find_card > div.imtu-partial > div.buttonsX > #imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals(pin, driver.findElement(By.cssSelector("p.value")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean dmtu(){
		System.out.println("Testing DMTU...");
		driver.findElement(By.linkText("Domestic Mobile Top-Up")).click();
		new Select(driver.findElement(By.id("carrier"))).selectByVisibleText("VirginMobile");
		driver.findElement(By.cssSelector("option[value=\"VirginMobile\"]")).click();
		driver.findElement(By.id("sender_phone")).clear();
		driver.findElement(By.id("sender_phone")).sendKeys(usr);
		driver.findElement(By.id("imtu_request_email")).clear();
		driver.findElement(By.id("imtu_request_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			
			// switch to active modal frame
			driver.switchTo().activeElement();
			// find the Continue bottom from the modal
			driver.findElement(By.xpath("//div[contains(@class, 'ui-dialog-buttonset')]/button[1]")).click();
			
			assertEquals("Thank you. Your DMTU purchase was successful.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("DMTU");
		} catch (Error e) {
			return false;
		}
		dpin=driver.findElement(By.xpath("//div[@id='invoice']/p[9]")).getText();

		driver.findElement(By.linkText("Domestic Mobile Top-Up")).click();
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Find Record");
		driver.findElement(By.id("imtu_search_request_pin")).clear();
		driver.findElement(By.id("imtu_search_request_pin")).sendKeys(dpin);
		driver.findElement(By.cssSelector("#find_card > div.imtu-partial > div.buttonsX > #imtu_submit_button")).click();
		/*
		for (int second = 0;; second++) {
			if (second >= 30) return false;
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
			try { if (isElementPresent(By.cssSelector("p.value"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			assertEquals(dpin, driver.findElement(By.cssSelector("p.value")).getText());
		} catch (Error e) {
			return false;
		}*/
		return true;
	}

	public boolean custSignUp(){
		System.out.println("Testing Customer Sign Up...");
		driver.findElement(By.cssSelector("li.rs > a > span.lbl")).click();
		try {
			assertEquals("Customer Signup Report", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("th.l")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='content']/table/tbody/tr/th[4]")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	public boolean summByProd(){
		System.out.println("Testing Summary by Product...");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[4]/a/span[2]")).click();
		try {
			assertEquals("Summary by Product", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("range")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Product", driver.findElement(By.cssSelector("th.l")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		return true;
	}




	public boolean marketMaterials(){
		System.out.println("Testing Marketing Materials...");
		driver.findElement(By.linkText("Marketing Materials")).click();
		try {
			assertEquals("Marketing Materials", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.cssSelector("span.bullet")).click();
		driver.findElement(By.xpath("//ul[@id='mktree']/li[2]/span")).click();
		driver.findElement(By.xpath("//ul[@id='mktree']/li[3]/span")).click();
		try {
			assertEquals("BOSS VIRTUAL VISA LEAFLET.pdf", driver.findElement(By.linkText("BOSS VIRTUAL VISA LEAFLET.pdf")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("BOSS IMTU South America poster SPANISH.jpeg", driver.findElement(By.linkText("BOSS IMTU South America poster SPANISH.jpeg")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Boss Bundle Details.pdf", driver.findElement(By.linkText("Boss Bundle Details.pdf")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean ratesAccess(){
		System.out.println("Testing Rates & Access Numbers...");
		driver.findElement(By.linkText("Rates & Access Numbers")).click();
		try {
			assertEquals("Rates & Access Numbers", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Afghanistan", driver.findElement(By.cssSelector("tr.even > td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Bahrain");
		try {
			assertEquals("Bahrain Audiotext", driver.findElement(By.cssSelector("tr.odd > td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Bosnia and Herzegovina");
		try {
			assertEquals("Bosnia and Herzegovina Cellular", driver.findElement(By.cssSelector("tr.odd > td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("South Africa");
		try {
			assertEquals("South Africa,Johannesburg", driver.findElement(By.xpath("//table[@id='calculator_rates']/tbody/tr[5]/td")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Birmingham", driver.findElement(By.cssSelector("div.iform > div > table.result > tbody > tr.odd > td")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("London", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/table/tbody/tr[11]/td")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("03302212220", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div/div/table/tbody/tr[6]/td[3]")).getText());
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
			assertEquals("Store Name", driver.findElement(By.cssSelector("label.optional.ui-mini")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("comments")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Contact Us')])[2]")).click();
		try {
			assertEquals("Contact Us", driver.findElement(By.cssSelector("h1")).getText());
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
			assertTrue(isElementPresent(By.xpath("//div[@id='footer']/div[3]/a[2]/img")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.compcard.facebook")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("a.compcard.twitter")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean logout(){
		System.out.println("Logging Out...");
		driver.findElement(By.id("log-out")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Successfully logged out.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("user_session_login")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("user_session_password")));
		} catch (Error e) {
			return false;
		}
		return true;
	}


	//@Test
	public boolean test() throws Exception {
		//open browser///////////////////////////////////////////////0
		System.out.println("Opening Agent Portal");
		driver.get(baseUrl + "retailers/login");
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


		if(creation){
			//Cust Create///////////////////////////////////////////////3
			if(createCust()){
				System.out.println("[Success]Created new Customer Successfully");
				screenShot("Customer Creation");
				result[3]=1;
			}else{
				screenShot("Customer Creation");
				System.err.println("[Error]Failed to create new Customer");

			}
			//Cust top up///////////////////////////////////////////////4
			if(result[3]==1)
			if(custTU()){
				System.out.println("[Sucess]Customer-Top Up Successful");
				//screenShot("Customer Top Up");
				result[4]=1;
			}else{
				screenShot("Customer Top Up");
				System.err.println("[Error]Customer-Top Up Failed");
			}
			//Cust Auto RC///////////////////////////////////////////////5
			if(result[3]==1)
			if(setupRC()){
				System.out.println("[Sucess]Customer-Auto Recharge setup Success");
				//screenShot("Customer Auto Recharge");
				result[5]=1;
			}else{
				screenShot("Customer Auto Recharge");
				System.err.println("[Error]Customer-Failed to setup Auto Recharge");
			}
			//Registered Numbers///////////////////////////////////////////////6
			if(result[3]==1)
			if(registeredNumbers()){
				System.out.println("[Sucess]Customer-Changed numbers successfully");
				//screenShot("Registered Numbers");
				result[6]=1;
			}else{
				screenShot("Registered Numbers");
				System.err.println("[Error]Customer-Failed to change numbers");
			}
			//Speed Dial///////////////////////////////////////////////7
			if(result[3]==1)
			if(speedDial()){
				System.out.println("[Sucess]Customer-Changed numbers successfully");
				//screenShot("Speed Dial");
				result[7]=1;
			}else{
				screenShot("Speed Dial");
				System.err.println("[Error]Customer-Failed to change numbers");
			}
			//quick call///////////////////////////////////////////////8
			if(result[3]==1)
			if(quickCall()){
				System.out.println("[Sucess]Customer-Changed numbers successfully");
				//screenShot("Quick Call");
				result[8]=1;
			}else{
				screenShot("Quick Call");
				System.err.println("[Error]Customer-Failed to change numbers");
			}
			//Cust SMS///////////////////////////////////////////////9
			if(result[3]==1)
			if(custSMS()){
				System.out.println("[Sucess]Customer-Sent SMS Successfully");
				//screenShot("SMS");
				result[9]=1;
			}else{
				screenShot("SMS");
				System.err.println("[Error]Customer-Failed to send SMS");
			}
			//billing Hist///////////////////////////////////////////////10
			if(result[3]==1)
			if(billingHist()){
				System.out.println("[Sucess]Customer-Billing History looks OK");
				//screenShot("Billing History");
				result[10]=1;
			}else{
				screenShot("Billing History");
				System.err.println("[Error]Customer-Something wrong with Billing History");
			}
			//Notification Lang///////////////////////////////////////////////11
			if(result[3]==1)
			if(notifLang()){
				System.out.println("[Sucess]Customer-Changed Notification Language Successfully");
				//screenShot("Notification Language");
				result[11]=1;
			}else{
				screenShot("Notification Language");
				System.err.println("[Error]Customer-Failed to Change Notifiation Language");
			}
			/////////////////////////////////////////////////11
			if(result[3]==1)
			if(moveService()){
				System.out.println("[Sucess]Customer-Move Service looks Ok");
				screenShot("Move Service");
				result[31]=1;
			}else{
				screenShot("Move Service");
				System.err.println("[Error]Customer-Something wrong with Move Service");
			}
			driver.get(baseUrl+"retailers/home/");
		}

		if(payment){
			//IMTU///////////////////////////////////////////////12
			if(imtu()){
				System.out.println("[Sucess]IMTU Sucessful");
				result[12]=1;
			}else{
				screenShot("IMTU");
				System.err.println("[Error]IMTU Failed");
			}
			//DMTU///////////////////////////////////////////////13
			if(dmtu()){
				System.out.println("[Sucess]DMTU Success");
				result[13]=1;
			}else{
				screenShot("DMTU");
				System.err.println("[Error]DMTU Failed");
			}
			driver.get(baseUrl+"retailers/home/");
		}
		if(links){
			//Report///////////////////////////////////////////////14
			if(reports()){
				System.out.println("[Sucess]Reports Looks OK");
				result[14]=1;
			}else{
				screenShot("Reports");
				System.err.println("[Error]Something wrong with Reports");
			}
			//Daily trans///////////////////////////////////////////////15
			if(dTransHist()){
				System.out.println("[Sucess]Reports-Daily Transaction History looks OK");
				result[15]=1;
			}else{
				screenShot("Daily Transactions");
				System.err.println("[Error]Reports-Something wrong with Daily Transaction History");
			}
			//my trans///////////////////////////////////////////////16
			if(mTransHist()){
				System.out.println("[Sucess]Reports-My Transaction History looks OK");
				result[16]=1;
			}else{
				screenShot("My Transations");
				System.err.println("[Error]Rports-Something wrong with My Transaction History");
			}
			//cust sign up///////////////////////////////////////////////18
			if(custSignUp()){
				System.out.println("[Sucess]Reports-Customer Signup looks OK");
				result[18]=1;
			}else{
				screenShot("Customer Signup");
				System.err.println("[Error]Reports-Something wrong with Customer Signup");
			}
			//summ by prod///////////////////////////////////////////////19
			if(summByProd()){
				System.out.println("[Sucess]Reports-Summary By Products looks OK");
				result[19]=1;
			}else{
				screenShot("Summary by Product");
				System.err.println("[Error]Reports-Something wrong with Summary By Products");
			}
			//Market Materials/////////////////////////////////////////////////24
			if(marketMaterials()){
				System.out.println("[Sucess]Market Materials look OK");
				result[24]=1;
			}else{
				screenShot("Market Materials");
				System.err.println("[Error]Something wrong with Market Materials");
			}
			//rates&access#s///////////////////////////////////////////////26
			if(ratesAccess()){
				System.out.println("[Sucess]Rates & Access numbers look OK");
				result[26]=1;
			}else{
				screenShot("Rates&Access numbers");
				System.err.println("[Error]Something wrong with Rates and/or Access Rates");
			}
			//Contact us///////////////////////////////////////////////27
			if(contUs()){
				System.out.println("[Sucess]Contact Us looks OK");
				result[27]=1;
			}else{
				screenShot("Contact us");
				System.err.println("[Error]Something wrong with Contact Us");
			}
			//check home page///////////////////////////////////////////////2
			driver.get(baseUrl+"/retailers/home");
			if(homePage()){
				System.out.println("[Success]Home Page looks good");
				result[2]=1;
			}else{
				screenShot("Homepage");
				System.err.println("[Error]Something wrong with Home Page");
			}
			if(compCard()){
				System.out.println("[Sucess]Comp Cards Look OK");
				result[28]=1;
			}else{
				screenShot("Comp Cards");
				System.err.println("[Error]Something wrong with Comp Cards");
			}
		}

		//Terms and Conditions///////////////////////////////////////////////
		//driver.findElement(By.linkText("Terms & Conditions")).click();
		//Log out///////////////////////////////////////////////28
		if(logout()){
			System.out.println("[Sucess]Logout Successful");
			result[29]=1;
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
		System.out.println("**UK Agent**");
		//login//////////////////////
		if(result[1]==1){
			System.out.println("1) Login Successful - "+usr+ ":" + pw);
			results[1]="1) Login Successful - "+usr+ ":" + pw;
		}else{
			System.out.println("1) Login Unsuccessful");
			results[1]="1) Login Unsuccessful";
			ayOk = false;
		}
		if(creation){
			////////////////////////
			if(result[3]==1){
				System.out.println(r+") Created new Customer Successfully - "+newNum);
				Email y = new Email(newNum);
				String e = y.getMail("Security Code");
				while(e.equals("hi"))
					e = y.getMail("Security Code");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") Created new Customer Successfully -"+newNum +"\n*email*\n"+e;
			}else{
				System.out.println(r+") Failed to Create new Customer");
				results[r++]=r-1+"){color:red} Failed to Create new Customer{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[3]==1)
			if(result[4]==1 && result[5]==1 && result[6]==1 && result[7]==1 && result[8]==1 && result[9]==1 && result[10]==1 && result[11]==1 && result[31]==1){
				System.out.println(r+") Customer Functions Work");
				results[r++]=r-1+") Customer Functions Work";
			}else{
				System.out.println(r+") Not all Customer Functions are Working");
				results[r++]=r-1+"){color:red} Not all Customer Functions are Working{color}";
				ayOk = false;
			}
		}
		if(payment){
			////////////////////////
			if(result[12]==1){
				System.out.println(r+") IMTU Successful - "+pin);
				Email y = new Email(usr);
				String e = y.getMail("International");
				while(e.equals("hi"))
					e = y.getMail("International");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") IMTU Successful - "+pin+"\n*email*\n"+e;
			}else{
				System.out.println(r+") IMTU Failed");
				results[r++]=r-1+"){color:red} IMTU Failed{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[13]==1){
				System.out.println(r+") DMTU Successful -"+dpin);
				Email y = new Email(usr);
				String e = y.getMail("Orange");
				while(e.equals("hi"))
					e = y.getMail("Orange");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") DMTU Successful - "+dpin+"\n*email*\n"+e;
			}else{
				System.out.println(r+") DMTU Failed");
				results[r++]=r-1+"){color:red} DMTU Failed{color}";
				ayOk = false;
			}
		}
		if(links){
			////////////////////////
			if(result[14]==1 && result[15]==1 && result[16]==1 && result[18]==1 && result[19]==1){
				System.out.println(r+") Reports look OK");
				results[r++]=r-1+") Reports look OK";
			}else{
				System.out.println(r+") Something wrong with the Reports");
				results[r++]=r-1+"){color:red} Something wrong with the Reports{color}";
				ayOk = false;
			}
			////////////////////////

			////////////////////////

			////////////////////////

			////////////////////////
			if(result[26]==1){
				System.out.println(r+") Rates and Access Numbers look OK");
				results[r++]=r-1+") Rates and Access Numbers look OK";
			}else{
				System.out.println(r+") Soemthing wrong with Rates and Access Numbers");
				results[r++]=r-1+"){color:red} Something wrong with Rates and Access Numbers{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[2]==1 && result[24]==1 && result[27]==1 && result[28]==1 ){
				System.out.println(r+") Other links Successful");
				results[r++]=r-1+") Other links Successful";
			}else{
				System.out.println(r+") Something wrong with other links");
				results[r++]=r-1+"){color:red} Something wrong with other links{color}";
				ayOk = false;
			}
		}
		////////////////////////
		if(result[29]==1){
			System.out.println(r+") Logout Successful");
			results[r++]=r-1+") Logout Successful";
		}else{
			System.out.println(r+") Logout Failed");
			results[r++]=r-1+"){color:red} Logout Failed{color}";
			ayOk = false;
		}
		////////////////////////

		if(ayOk){
			System.out.println("");
			System.out.println("Everything looks good!");
			//jira();
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
	/*
	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
	 */
}