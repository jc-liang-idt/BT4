
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class QA_ES_Retailer  {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private String[] results = new String[15];
	private String[] pics = new String[32];
	private int picCount=0;
	private String newNum;
	private String agent;
	private int[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	private String usr;
	private String pw;
	private int r;
	private String bossVersion;

	private String securityAnswer;
	private String pin, dpin;
	private boolean update, creation, payment, links;
	private int type;

	public QA_ES_Retailer(String a, String b, String c, String d, boolean e, boolean f, boolean g, boolean h, int i){
		usr = a;
		pw = b;
		securityAnswer = c;
		bossVersion = d;
		update = e;
		creation = f;
		payment = g;
		links = h;
		type = i;
	}

	//@Before
	public void setUp() throws Exception {
		//System.setProperty("webdriver.firefox.bin", "src/res/Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.firefox.bin", "Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		int qa = Runner.bossqa;
		if(qa==0){
			baseUrl = "http://es.bossqa.cstage01.n2p.com/";
		}else{
			baseUrl = "http://es.bossqa"+qa+".cstage01.n2p.com/";
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//Takes Screenshot and labels it to parameter "error"
	public void screenShot(String error){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		switch(type){
		case 0: 
			try {
				FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Retailer_"+error+".png"));
				pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Retailer_"+error+".png";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1: 
			try {
				FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Cash Retailer_"+error+".png"));
				pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Cash Retailer_"+error+".png";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2: 
			try {
				FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Credit Retailer_"+error+".png"));
				pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Credit Retailer_"+error+".png";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		FileUtils.deleteQuietly(scrFile);
	}

	public String date(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	//logs in, checks if successful and enters security answer
	public boolean login(){
		System.out.println("Logging in...");
		try {
			assertEquals("Minoristas Existentes", driver.findElement(By.cssSelector("h2")).getText());
			driver.findElement(By.id("user_session_login")).clear();
			driver.findElement(By.id("user_session_login")).sendKeys(usr);
			driver.findElement(By.id("user_session_password")).clear();
			driver.findElement(By.id("user_session_password")).sendKeys(pw);
			driver.findElement(By.name("commit")).click();
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))){
				return false;
			}
			try {
				assertEquals("Confirmar correo electrónico y número de teléfono móvil", driver.findElement(By.cssSelector("h1")).getText());
				do{
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys("testbossrev@gmail.com");
				driver.findElement(By.name("email_request_code_btn")).click();
				
				Email q = new Email(usr);
				String w = q.getMail4("es:");
				if(w.equals("hi")) return false;
				int r = w.indexOf("es:");
				w=w.substring(r+4,r+12);
				System.out.println(w);
				
				driver.findElement(By.id("email_code")).sendKeys(w);
				driver.findElement(By.name("verify_email_btn")).click();
				for (int second = 0;; second++) {
			    	if (second >= 60) fail("timeout");
			    	try { if (isElementPresent(By.name("email_request_code_btn"))) break; } catch (Exception e) {}
			    	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
			    }
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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
				}
				if(isElementPresent(By.cssSelector("div.error"))) return false;
				driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
				} catch (Error e) {
			}
			try {
				assertEquals("Confirma tu Identidad", driver.findElement(By.cssSelector("h1")).getText());
				driver.findElement(By.name("spec_email")).click();
				if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
				
				Email q = new Email(usr);
				String w = q.getMail4("es:");
				if(w.equals("hi")) return false;
				int r = w.indexOf("es:");
				w=w.substring(r+3,r+12);

				driver.findElement(By.id("temp_code")).clear();
				driver.findElement(By.id("temp_code")).sendKeys(w);
				driver.findElement(By.id("remember_computer")).click();
			    driver.findElement(By.name("commit")).click();
			    
				if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
			} catch (Error e) {
			}
			try {
				assertTrue(isElementPresent(By.cssSelector("label.optional.ui-mini")));
				driver.findElement(By.id("security_answer")).clear();
				driver.findElement(By.id("security_answer")).sendKeys(securityAnswer);
				driver.findElement(By.id("security_qa_save")).click();
				driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			} catch (Error e) {
			}
			if(isElementPresent(By.cssSelector("div.buttonsX > input[type=\"submit\"]")))
				driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
			if(isElementPresent(By.name("accept"))){
				driver.findElement(By.name("accept")).click();
			}
			if(isElementPresent(By.cssSelector("div.buttonsX > input[type=\"submit\"]")))
				driver.findElement(By.cssSelector("div.buttonsX > input[type=\"submit\"]")).click();
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//Check for certain elements
	public boolean homePage(){
		System.out.println("Checking Home page...");
		try {
			assertEquals("Inicio", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals(usr, driver.findElement(By.xpath("//table[@id='homepage_account_info']/tbody/tr[2]/td[2]")).getText());
		} catch (Error e) {
			return false;
		}
		
		return true;
	}
	//called by the first one if generated number was already chosen
	public void createCust2(){
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[2]/a")).click();
		driver.findElement(By.id("phone_number")).clear();
		newNum = randNum("1");
		driver.findElement(By.id("phone_number")).sendKeys(newNum);
		driver.findElement(By.name("commit")).click();
	}
	//creates a customer
	public boolean createCust(){
		System.out.println("Creating Customer...");
		driver.findElement(By.cssSelector("span.lbl")).click();
		try {
			assertEquals("Boss Revolution / Llamadas Internacionales", driver.findElement(By.cssSelector("h1")).getText());
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
		try {
			assertEquals("El cliente se ha creado correctamente", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//returns random number different from "usr" and parameter "w"
	public String randNum(String w){
		String q;
		do
			q="34" + String.valueOf((int)(Math.floor((Math.random() * 100000000)+899999999)));
		while(q.equals(usr) || q.equals(w));
		return q;
	}

	//tops up customer $1
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
			assertEquals("Se ha realizado la recarga correctamente", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//enters payment info
	public boolean setupRC(){
		System.out.println("Customer-Auto Recharge...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[2]")).click();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 Always Way");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).sendKeys("Madrid");
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("12345");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("Bob Bill");
		new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2017");
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
			assertEquals("Recarga automática de la información actualizada correctamente", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//enters 3 random numbers
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
		if("Los números registrados se han actualizado correctamente.".equals(driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText()))return true;
		return false;
	}

	//enters 2 speed dials
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
			assertEquals("Los números de Marcación Rápida se han actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
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
			assertEquals("QuickCall actualizado con éxito.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//presses send button
	public boolean custSMS(){
		System.out.println("Customer-SMS...");
		driver.findElement(By.linkText("SMS")).click();
		driver.findElement(By.name("sms")).click();
		try {
			assertEquals("SMS fue enviado con éxito", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//checks for elements
	public boolean billingHist(){
		System.out.println("Customer-Billing History...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[7]")).click();
		try {
			assertTrue(isElementPresent(By.id("from_date")));
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Transacción", driver.findElement(By.xpath("//table[@id='customer_billing_history_table']/thead/tr/th[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("to_date")));
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
			assertEquals("Idioma para notificaciones actualizado.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//enters "usr" number to make it sure it won't move to current numbers
	public boolean moveService(){
		System.out.println("Customer-Move Service...");
		driver.findElement(By.xpath("//div[@id='tabnav']/a[9]")).click();
		try {
			assertTrue(isElementPresent(By.id("new_service_number")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("password")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("preferred_locale")));
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

	//checks for elements
	public boolean reports(){
		System.out.println("Testing Reports...");
		driver.findElement(By.linkText("Informes")).click();
		try {
			assertEquals("Informes", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Transacciones de Hoy", driver.findElement(By.cssSelector("span.lbl")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Historial de transacciones", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[3]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Historial de Ingresos", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[5]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Clientes Registrados", driver.findElement(By.cssSelector("li.rs > a > span.lbl")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Resumen por producto", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[4]/a/span[2]")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//checks for elements
	public boolean dTransHist(){
		System.out.println("Testing Daily Transaction History...");
		driver.findElement(By.cssSelector("span.lbl")).click();
		try {
			assertEquals("Transacciones de Hoy", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("transaction_code")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	//checks for elements
	public boolean mTransHist(){
		System.out.println("Testing My Transaction History...");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[3]/a/span[2]")).click();
		try {
			assertEquals("Historial de transacciones", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("a_id")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	//checks for elements
	public boolean loginHist(){
		System.out.println("Testing Revenue History...");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[5]/a/span[2]")).click();
		try {
			assertEquals("Historial de Ingresos", driver.findElement(By.cssSelector("h1")).getText());
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
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	//attempts $50 recharge
	public boolean recharge(){
		if(!isElementPresent(By.linkText("Recargar"))){
			result[19]=2;
			return true;
		}
		System.out.println("Testing Recharge...");
		driver.findElement(By.linkText("Recargar")).click();
		try {
			assertEquals("Recargar", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		if(isElementPresent(By.linkText("Please add one to your account."))){
			driver.findElement(By.linkText("Please add one to your account.")).click();
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("Bob Bill");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_month"))).selectByVisibleText("01");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 Always Way");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).sendKeys("Madrid");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("12345");
			driver.findElement(By.id("business_entity_submit")).click();
			if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
			try {
				assertEquals("Cuenta actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			} catch (Error e) {
				return false;
			}
			driver.findElement(By.linkText("Recargar")).click();
		}
		if(!isElementPresent(By.id("amount"))){
			result[19]=2;
			return true;
		}
		if(isElementPresent(By.id("cvv2"))){
			driver.findElement(By.id("cvv2")).clear();
			driver.findElement(By.id("cvv2")).sendKeys("123");
		}
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		driver.get(baseUrl + "retailers/account/recharge");
		return true;
	}

	//attempts imtu purchase and searches for the bought pin
	public boolean imtu(){
		System.out.println("Testing IMTU...");
		driver.findElement(By.xpath("//div[@id='content']/div/div[3]/ul/li[2]/a/span[1]")).click();
		try {
			assertEquals("Recargas de Móviles / Internacionales", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Comprar PIN");
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("bo");
		driver.findElement(By.id("sender_phone")).clear();
		driver.findElement(By.id("sender_phone")).sendKeys(usr);
		driver.findElement(By.id("imtu_request_email")).clear();
		driver.findElement(By.id("imtu_request_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Gracias. Su compra se ha realizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("IMTU");
		} catch (Error e) {
			return false;
		}
		pin = driver.findElement(By.xpath("//div[@id='invoice']/p[11]")).getText();
		
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[2]/a")).click();
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Redimir PIN");
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("bo");
		driver.findElement(By.name("imtu_request[receiver_phone]")).clear();
		driver.findElement(By.name("imtu_request[receiver_phone]")).sendKeys("59178945678");
		driver.findElement(By.id("pin")).sendKeys(pin);
		driver.findElement(By.id("sender_phone")).clear();
		driver.findElement(By.id("sender_phone")).sendKeys(usr);
		driver.findElement(By.id("imtu_request_email")).clear();
		driver.findElement(By.id("imtu_request_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Gracias. El número de teléfono móvil internacional se ha recargado.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[2]/a")).click();
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Encontrar Transacción");
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
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/a")).click();
		try {
			assertEquals("Recargas de Móviles / Nacionales", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		Select q=new Select(driver.findElement(By.id("carrier")));
		if(q.getOptions().size()==0 || q.getOptions().get(0).getText().equals("null")) return false;
		q.selectByVisibleText("Vodafone");
		
		q=new Select(driver.findElement(By.id("product")));
		q.selectByValue(q.getOptions().get(1).getAttribute("value"));
		//new Select(driver.findElement(By.id("product"))).selectByVisibleText("€10.00");
		driver.findElement(By.id("receiver")).clear();
		driver.findElement(By.id("receiver")).sendKeys("789487561");
		driver.findElement(By.id("sender_phone")).clear();
		driver.findElement(By.id("sender_phone")).sendKeys(usr);
		driver.findElement(By.id("imtu_request_email")).clear();
		driver.findElement(By.id("imtu_request_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("imtu_submit_button")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Gracias. Su compra se ha realizado exitosamente y el número móvil nacional ha sido recargado.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("DMTU");
		} catch (Error e) {
			return false;
		}
		dpin=driver.findElement(By.xpath("//div[@id='invoice']/p[9]")).getText();
		driver.findElement(By.xpath("//ul[@id='side-menu']/li[3]/a")).click();
		new Select(driver.findElement(By.id("imtu_action"))).selectByVisibleText("Encontrar Transacción");
		driver.findElement(By.id("imtu_search_request_pin")).clear();
		driver.findElement(By.id("imtu_search_request_pin")).sendKeys(dpin);
		driver.findElement(By.cssSelector("#find_card > div.imtu-partial > div.buttonsX > #imtu_submit_button")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
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
		}
		return true;
	}

	//checks for elements
	public boolean custSignUp(){
		System.out.println("Testing Customer Sign Up...");
		driver.findElement(By.cssSelector("li.rs > a > span.lbl")).click();
		try {
			assertEquals("Clientes Registrados", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		assertTrue(isElementPresent(By.id("range")));
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	//checks for elements
	public boolean summByProd(){
		System.out.println("Testing Summary by Product...");
		driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div/ul/li[4]/a/span[2]")).click();
		try {
			assertEquals("Resumen por producto", driver.findElement(By.cssSelector("h1")).getText());
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
		driver.findElement(By.id("report_link")).click();
		return true;
	}

	public boolean personalDetails(){
		System.out.println("Updating Personal Details...");
		driver.findElement(By.linkText("Actualizar datos personales")).click();
		try {
			assertEquals("Actualizar datos personales", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).sendKeys("Updated "+date());
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Cuenta actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
			screenShot("Personal Details");
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[2]")).click();
		driver.findElement(By.id("registered_phones_")).clear();
		driver.findElement(By.id("registered_phones_")).sendKeys(randNum("1"));
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Los números registrados se han actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[3]")).click();
		if(isElementPresent(By.id("business_entity_physical_addresses_attributes_0_street2"))){
			if(!"".equals(driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).getAttribute("value"))){
				driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).clear();
				driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street2")).sendKeys("Updated "+date());
				driver.findElement(By.id("business_entity_submit")).click();
				if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
				try {
					assertEquals("Cuenta actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
				} catch (Error e) {
					return false;
				}
			}
		}
		driver.findElement(By.xpath("//div[@id='tabnav']/a[4]")).click();

		try {
			assertEquals("", driver.findElement(By.id("old_security_code")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("", driver.findElement(By.id("security_code")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("", driver.findElement(By.id("security_answer")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.name("commit")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Cuenta actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	//creates agent
	public boolean agents(){
		System.out.println("Testing Agents...");
		driver.findElement(By.linkText("Administrar agentes")).click();
		try {
			assertEquals("Administrar agentes", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.linkText("Nuevo Agente")).click();
		driver.findElement(By.id("business_entity_user_attributes_security_code")).clear();
		driver.findElement(By.id("business_entity_user_attributes_security_code")).sendKeys("1234");
		driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).clear();
		driver.findElement(By.id("business_entity_user_attributes_security_code_confirmation")).sendKeys("1234");
		driver.findElement(By.id("business_entity_user_attributes_login")).clear();
		String q = randNum("1");
		driver.findElement(By.id("business_entity_user_attributes_login")).sendKeys(randNum(q));
		driver.findElement(By.id("business_entity_name")).clear();
		driver.findElement(By.id("business_entity_name")).sendKeys("Westeros");
		driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("Cersei");
		driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
		driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("Lanister");
		driver.findElement(By.id("business_entity_user_attributes_email")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
		driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).clear();
		driver.findElement(By.id("business_entity_phones_attributes_0_number")).sendKeys(q);
		driver.findElement(By.id("business_entity_submit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Agente creado con éxito.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		agent = driver.findElement(By.id("account_number")).getAttribute("value");
		return true;
	}

	//checks for elements
	public boolean crp(){
		System.out.println("Testing Customer Referral Program...");
		driver.findElement(By.linkText("Programa Clientes Referidos")).click();
		try {
			assertEquals("Programa Clientes Referidos", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("qr_home_image")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("qr_new_image")));
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("SITIO DE CLIENTES", driver.findElement(By.cssSelector("div.whalfpx.dib > h2")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("PÁGINA DE REGISTRO", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/div[2]/h2")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}
	//checks for elements
	public boolean commissions(){
		System.out.println("Testing My Commissions...");
		driver.findElement(By.linkText("Mis Comisiones")).click();
		try {
			assertEquals("Mis Comisiones", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Producto - Tipo de la Comisión", driver.findElement(By.cssSelector("th.l")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Comisiones", driver.findElement(By.cssSelector("th.c")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}
	public boolean marketMat(){
		System.out.println("Testing Marketing Materials...");
		driver.findElement(By.linkText("Materiales de marketing")).click();
		try {
			assertEquals("Materiales de marketing", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("BOSS Catalogo Regalo.pdf")));
		} catch (Error e) {
			return false;
		}
		return true;
	}
	//checks for elements
	public boolean contDist(){
		System.out.println("Testing Contact My Distributer...");
		driver.findElement(By.linkText("Contactar a mi distribuidor")).click();
		try {
			assertEquals("Contactar a mi distribuidor", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("mobile_number")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("reason")));
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
	//checks for elements
	public boolean ratesAccess(){
		System.out.println("Testing Rates & Access Numbers...");
		driver.findElement(By.linkText("Tarifas y Números de Acceso")).click();
		try {
			assertEquals("Tarifas y Números de Acceso", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Calculador de Minutos", driver.findElement(By.cssSelector("h2")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Bahrein");
		try {
			assertEquals("Bahrein", driver.findElement(By.cssSelector("tr.even > td.l")).getText());
		} catch (Error e) {
			return false;
		}
		new Select(driver.findElement(By.id("rate_check_country"))).selectByVisibleText("Libia");
		try {
			assertEquals("Libia", driver.findElement(By.cssSelector("tr.even > td.l")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Acceso #", driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]/table/tbody/tr/td[2]/h2")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}
	//checks for elements
	public boolean contUs(){
		System.out.println("Testing Contact Us...");
		driver.findElement(By.linkText("Contáctanos")).click();
		try {
			assertEquals("Contáctanos", driver.findElement(By.cssSelector("h1")).getText());
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
		driver.findElement(By.xpath("(//a[contains(text(),'Contáctanos')])[2]")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("h1")));
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
		return true;
	}
	//checks for elements
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
		return true;
	}
	//logs out
	public boolean logout(){
		System.out.println("Logging Out...");
		driver.findElement(By.id("log-out")).click();
		try {
			assertEquals("Con éxito la sesión.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}
	//attempts $2 refund
	public boolean refund(){
		System.out.println("Testing Refund");
		if(!isElementPresent(By.linkText("Reembolsar mi Saldo"))){
			result[26]=2;
			return true;
		}
		driver.findElement(By.linkText("Reembolsar mi Saldo")).click();
		try {
			assertEquals("Reembolsar mi Saldo", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			return false;
		}
		if(isElementPresent(By.xpath("//div[@id='content']/table/tbody/tr/td[2]"))){
			if("Please call Customer Services at 6415 9093.".equals(driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td[2]")).getText())){
				result[26]=2;
				return true;
			}
		}
		driver.findElement(By.id("amount")).clear();
		driver.findElement(By.id("amount")).sendKeys("2");
		driver.findElement(By.name("commit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		if(driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText().contains("Su cuenta ha sido"))
			return true;
		return false;
	}

	//@Test
	public boolean test() throws Exception {
		//open browser///////////////////////////////////////////////0
		System.out.println("Opening Retailer Portal");
		driver.get(baseUrl + "retailers/login");
		/////////////////////////////////////////////////
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
			/////////////////////////////////////////////////
			if(personalDetails()){
				System.out.println("[Sucess]Updated Personal Details Successfully");
				result[20]=1;
			}else{
				screenShot("Personal Details");
				System.err.println("[Error]Failed to update Personal Details");
			}
		}

		if(creation){
			/////////////////////////////////////////////////
			driver.get(baseUrl+"retailers/home/");
			if(createCust()){
				System.out.println("[Success]Created new Customer Successfully");
				screenShot("Customer Creation");
				result[3]=1;
			}else{
				screenShot("Customer Creation");
				System.err.println("[Error]Failed to create new Customer");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(custTU()){
				System.out.println("[Sucess]Customer-Top Up Successful");
				result[4]=1;
			}else{
				screenShot("Customer Top Up");
				System.err.println("[Error]Customer-Top Up Failed");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(setupRC()){
				System.out.println("[Sucess]Customer-Auto Recharge setup Success");
				result[5]=1;
			}else{
				screenShot("Customer Auto Recharge");
				System.err.println("[Error]Customer-Failed to setup Auto Recharge");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(registeredNumbers()){
				System.out.println("[Sucess]Customer-Changed numbers successfully");
				result[6]=1;
			}else{
				screenShot("Registered Numbers");
				System.err.println("[Error]Customer-Failed to change numbers");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(speedDial()){
				System.out.println("[Sucess]Customer-Changed numbers successfully");
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
				result[32]=1;
			}else{
				screenShot("Quick Call");
				System.err.println("[Error]Customer-Failed to change numbers");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(custSMS()){
				System.out.println("[Sucess]Customer-Sent SMS Successfully");
				result[8]=1;
			}else{
				screenShot("SMS");
				System.err.println("[Error]Customer-Failed to send SMS");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(billingHist()){
				System.out.println("[Sucess]Customer-Billing History looks OK");
				result[9]=1;
			}else{
				screenShot("Billing History");
				System.err.println("[Error]Customer-Something wrong with Billing History");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(notifLang()){
				System.out.println("[Sucess]Customer-Notification Language looks OK");
				result[10]=1;
			}else{
				screenShot("Notification Language");
				System.err.println("[Error]Customer-Something wrong with Notification Language");
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(moveService()){
				System.out.println("[Sucess]Customer-Move Service looks Ok");
				result[11]=1;
			}else{
				screenShot("Notification Language");
				System.err.println("[Error]Customer-Something wrong with move service");
			}
			/////////////////////////////////////////////////
			if(agents()){
				System.out.println("[Sucess]Created Agent");
				screenShot("Agents");
				result[21]=1;
			}else{
				screenShot("Agents");
				System.err.println("[Error]Failed to create Agent");
			}
		}

		if(payment){
			/////////////////////////////////////////////////
			driver.get(baseUrl+"retailers/home/");
			if(imtu()){
				System.out.println("[Sucess]IMTU Sucessful");
				result[12]=1;
			}else{
				screenShot("IMTU");
				System.err.println("[Error]IMTU Failed");
			}
			/////////////////////////////////////////////////
			if(dmtu()){
				System.out.println("[Sucess]DMTU Sucessful");
				result[31]=1;
			}else{
				screenShot("DMTU");
				System.err.println("[Error]DMTU Failed");
			}
			/////////////////////////////////////////////////
			if(recharge()){
				if(result[19]!=2){
					System.out.println("[Sucess]Recharge Successful");
					screenShot("Recharge");
					result[19]=1;
				}else{
					System.out.println("Unrechargeable Account");
				}
			}else{
				screenShot("Recharge");
				System.err.println("[Error]Failed to Recharge");
			}
			/////////////////////////////////////////////////
			if(refund()){
				if(result[26]!=2){
					System.out.println("[Sucess]Refund Successful");
					screenShot("Refund");
					result[26]=1;
				}
			}else{
				if(result[26]!=2){
					screenShot("Refund");
					System.err.println("[Error]Refund Failed");
				}
			}
		}

		if(links){
			/////////////////////////////////////////////////
			driver.get(baseUrl+"retailers/home/");
			driver.findElement(By.cssSelector("span.lbl")).click();
			if(reports()){
				System.out.println("[Sucess]Reports Looks OK");
				result[13]=1;
			}else{
				screenShot("Reports");
				System.err.println("[Error]Something wrong with Reports");
			}
			/////////////////////////////////////////////////
			if(dTransHist()){
				System.out.println("[Sucess]Reports-Daily Transaction History looks OK");
				result[14]=1;
			}else{
				screenShot("Daily Transactions");
				System.err.println("[Error]Reports-Something wrong with Daily Transaction History");
			}
			/////////////////////////////////////////////////
			if(mTransHist()){
				System.out.println("[Sucess]Reports-My Transaction History looks OK");
				result[15]=1;
			}else{
				screenShot("My Transations");
				System.err.println("[Error]Rports-Something wrong with My Transaction History");
			}
			/////////////////////////////////////////////////
			if(loginHist()){
				System.out.println("[Sucess]Reports-Revenue History looks OK");
				result[16]=1;
			}else{
				screenShot("Login History");
				System.err.println("[Error]Reports-Something wrong with Revenue History");
			}
			/////////////////////////////////////////////////
			if(custSignUp()){
				System.out.println("[Sucess]Reports-Customer Signup looks OK");
				result[17]=1;
			}else{
				screenShot("Customer Signup");
				System.err.println("[Error]Reports-Something wrong with Customer Signup");
			}
			/////////////////////////////////////////////////
			if(summByProd()){
				System.out.println("[Sucess]Reports-Summary By Products looks OK");
				result[18]=1;
			}else{
				screenShot("Summary by Product");
				System.err.println("[Error]Reports-Something wrong with Summary By Products");
			}
			/////////////////////////////////////////////////
			if(crp()){
				System.out.println("[Sucess]Customer Referral Program looks OK");
				result[22]=1;
			}else{
				screenShot("Customer Referral Program");
				System.err.println("[Error]Something wrong with Customer Referral Program");
			}
			/////////////////////////////////////////////////
			if(commissions()){
				System.out.println("[Sucess]Commissions look OK");
				result[23]=1;
			}else{
				screenShot("Commissions");
				System.err.println("[Error]Something wrong with Commissions");
			}
			/////////////////////////////////////////////////
			if(marketMat()){
				System.out.println("[Sucess]Market Materials look OK");
				result[24]=1;
			}else{
				screenShot("Market Materials");
				System.err.println("[Error]Something wrong with Market Materials");
			}
			/////////////////////////////////////////////////
			if(contDist()){
				System.out.println("[Sucess]Contact Distributer looks OK");
				result[25]=1;
			}else{
				screenShot("Contact Distributer");
				System.err.println("[Error]Something wrong with Contact Distributer");
			}
			/////////////////////////////////////////////////
			if(ratesAccess()){
				System.out.println("[Sucess]Rates & One Step Dialing look OK");
				result[27]=1;
			}else{
				screenShot("Rates&Access numbers");
				System.err.println("[Error]Something wrong with Rates & One Step Dialing");
			}
			/////////////////////////////////////////////////
			if(contUs()){
				System.out.println("[Sucess]Contact Us looks OK");
				result[28]=1;
			}else{
				screenShot("Contact us");
				System.err.println("[Error]Something wrong with Contact Us");
			}
			/////////////////////////////////////////////////
			if(compCard()){
				System.out.println("[Sucess]Comp Cards Look OK");
				result[29]=1;
			}else{
				screenShot("Comp Cards");
				System.err.println("[Error]Something wrong with Comp Cards");
			}
			////////////////////////////////////////////////
			driver.get(baseUrl+"retailers/home/");
			if(homePage()){
				System.out.println("[Success]Home Page looks good");
				result[2]=1;
			}else{
				screenShot("Homepage");
				System.err.println("[Error]Something wrong with Home Page");
			}
		}
		/////////////////////////////////////////////////
		if(logout()){
			System.out.println("[Sucess]Logout Successful");
			result[30]=1;
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
		System.out.println("***Testing Comlpete***");
		System.out.println("");
		System.out.println("**ES Retailer**");
		/////////////////////////////////////////////////
		if(result[1]==1){
			System.out.println("1) Login Successful - "+usr+ ":" + pw);
			results[1]="1) Login Successful - "+usr+ ":" + pw;
		}else{
			System.out.println("1) Login Unsuccessful");
			results[1]="1) Login Unsuccessful";
			ayOk = false;
		}

		if(update){
			/////////////////////////////////////////////////
			if(result[20]==1){
				System.out.println(r+") Updated Personal Details Successfully");
				results[r++]=r-1+") Updated Personal Details Successfully";
			}else{
				System.out.println(r+") Failed to update Personal Details");
				results[r++]=r-1+"){color:red} Failed to update Personal Details{color}";
				ayOk = false;
			}
		}


		if(creation){
			/////////////////////////////////////////////////
			if(result[3]==1){
				System.out.println(r+") Created new Customer Successfully - "+newNum);
				Email y = new Email(newNum);
				String e = y.getMail("Welcome");
				while(e.equals("hi"))
					e = y.getMail("Welcome");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") Created new Customer Successfully - "+newNum +"\n*email*\n"+e;
			}else{
				System.out.println(r+") Failed to Create new Customer");
				results[r++]=r-1+"){color:red} Failed to Create new Customer{color}";
				ayOk = false;
			}
			/////////////////////////////////////////////////
			if(result[3]==1)
			if(result[4]==1 && result[5]==1 && result[6]==1 && result[7]==1 && result[8]==1 && result[9]==1 && result[10]==1 && result[11]==1 && result[32]==1){
				System.out.println(r+") Customer Functions Work");
				results[r++]=r-1+") Customer Functions Work";
			}else{
				System.out.println(r+") Not all Customer Functions are Working");
				results[r++]=r-1+"){color:red} Not all Customer Functions are Working{color}";
				ayOk = false;
			}
			/////////////////////////////////////////////////
			if(result[21]==1){
				System.out.println(r+") Created new Agent Successfully - "+agent+":"+"1234");
				results[r++]=r-1+") Created new Agent Successfully - "+agent+":"+"1234";
			}else{
				System.out.println(r+") Failed to create new Agent");
				results[r++]=r-1+"){color:red} Failed to create new Agent{color}";
				ayOk = false;
			}
		}

		if(payment){
			/////////////////////////////////////////////////
			if(result[12]==1){
				System.out.println(r+") IMTU Purchase and Search Successful - Pin: "+pin);
				Email y = new Email(usr);
				String e = y.getMail("International");
				while(e.equals("hi"))
					e = y.getMail("International");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") IMTU Purchase and Search Successful - Pin: "+pin+"\n*email*\n"+e;
			}else{
				System.out.println(r+") IMTU Failed");
				results[r++]=r-1+"){color:red} IMTU Failed{color}";
				ayOk = false;
			}
			/////////////////////////////////////////////////
			if(result[31]==1){
				System.out.println(r+") DMTU Purchase and Search Successful - Pin: "+dpin);
				Email y = new Email(usr);
				String e = y.getMail("Vodafone");
				while(e.equals("hi"))
					e = y.getMail("Vodafone");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") DMTU Purchase and Search Successful - Pin: "+dpin+"\n*email*\n"+e;
			}else{
				System.out.println(r+") DMTU Failed");
				results[r++]=r-1+"){color:red} DMTU Failed{color}";
				ayOk = false;
			}
			/////////////////////////////////////////////////
			if(result[19]!=2)
				if(result[19]==1){
					System.out.println(r+") Recharge Successful");
					results[r++]=r-1+") Recharge Successful";
				}else{
					System.out.println(r+") Recharge Failed");
					results[r++]=r-1+"){color:red} Recharge Failed{color}";
					ayOk = false;
				}
			/////////////////////////////////////////////////
			if(result[26]!=2)
				if(result[26]==1){
					System.out.println(r+") Refund Successful");
					results[r++]=r-1+") Refund Successful";
				}else{
					System.out.println(r+") Refund Failed");
					results[r++]=r-1+"){color:red} Refund Failed{color}";
					ayOk = false;
				}
		}
		if(links){
			/////////////////////////////////////////////////
			if(result[13]==1 && result[14]==1 && result[15]==1 && result[16]==1 && result[17]==1 && result[18]==1){
				System.out.println(r+") Reports look OK");
				results[r++]=r-1+") Reports look OK";
			}else{
				System.out.println(r+") Something wrong with the Reports");
				results[r++]=r-1+"){color:red} Something wrong with the Reports{color}";
				ayOk = false;
			}
			/////////////////////////////////////////////////
			if(result[22]==1){
				System.out.println(r+") Customer Referral Program looks OK");
				results[r++]=r-1+") Customer Referral Program looks OK";
			}else{
				System.out.println(r+") Something wrong with Customer Referral Program");
				results[r++]=r-1+"){color:red} Something wrong with Customer Referral Program{color}";
				ayOk = false;
			}
			/////////////////////////////////////////////////
			if(result[27]==1){
				System.out.println(r+") Rates and One Step Dialing look OK");
				results[r++]=r-1+") Rates and One Step Dialing look OK";
			}else{
				System.out.println(r+") Something wrong with Rates and One Step Dialing");
				results[r++]=r-1+"){color:red} Something wrong with Rates and One Step Dialing{color}";
				ayOk = false;
			}
			/////////////////////////////////////////////////
			if(result[2]==1 && result[23]==1 && result[24]==1 && result[25]==1 && result[28]==1 && result[29]==1 ){
				System.out.println(r+") Other links Successful");
				results[r++]=r-1+") Other links Successful";
			}else{
				System.out.println(r+") Something wrong with other links");
				results[r++]=r-1+"){color:red} Something wrong with other links{color}";
				ayOk = false;
			}
		}

		/////////////////////////////////////////////////
		if(result[30]==1){
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