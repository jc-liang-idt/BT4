
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



public class QA_ES_Customer_Mobile  {
	private WebDriver driver;
	private String baseUrl;
	//private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String[] results = new String[13];
	private String[] pics = new String[20];
	private int picCount=0;
	private int[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0};

	private String usr;
	private String pw;
	private String ccVeri;
	private String securityAns;
	private String bossVersion;
	private int r;
	private boolean update;
	private boolean payment;
	private boolean links;
	private boolean creation;
	private String newNum;

	public QA_ES_Customer_Mobile(String a, String b, String c, String d, String e, boolean f, boolean g, boolean h, boolean i){
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
			baseUrl = "http://es.bossqa.cstage01.n2p.com/";
		}else{
			baseUrl = "http://es.bossqa"+qa+".cstage01.n2p.com/";
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void screenShot(String error){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Mobile_"+error+".png"));
			pics[picCount++]="C:\\BOSS_Screenshots_"+ bossVersion+"\\ES_Mobile_"+error+".png";
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
				assertEquals("Crea una cuenta", driver.findElement(By.cssSelector("h3 > span")).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
			newNum = randNum("1");
			driver.findElement(By.id("new_phone_number")).clear();
			driver.findElement(By.id("new_phone_number")).sendKeys(newNum);
			driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
			driver.findElement(By.id("business_entity_user_attributes_first_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_first_name")).sendKeys("Renlyr");
			driver.findElement(By.id("business_entity_user_attributes_last_name")).clear();
			driver.findElement(By.id("business_entity_user_attributes_last_name")).sendKeys("r");
			driver.findElement(By.id("business_entity_user_attributes_email")).clear();
			driver.findElement(By.id("business_entity_user_attributes_email")).sendKeys("testbossrev@gmail.com");
			driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).clear();
			driver.findElement(By.id("business_entity_user_attributes_email_confirmation")).sendKeys("testbossrev@gmail.com");
			driver.findElement(By.id("form_profile_info_submit")).click();
			driver.findElement(By.xpath("(//input[@value='Continuar'])[3]")).click();
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_payment_method_id"))).selectByVisibleText("Mastercard");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_account_number")).sendKeys("5454545454545454");
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("g e");
			new Select(driver.findElement(By.id("business_entity_banks_attributes_0_cc_exp_year"))).selectByVisibleText("2018");
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).clear();
			driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).sendKeys("123");
			driver.findElement(By.id("btnGetToken")).click();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_street1")).sendKeys("249 Always Way");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_city")).sendKeys("Madrid");
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).clear();
			driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("12345");
			driver.findElement(By.xpath("(//input[@value='Continuar'])[4]")).click();
			driver.findElement(By.xpath("(//input[@value='Continuar'])[5]")).click();
			driver.findElement(By.name("raptcha[t]")).clear();
			driver.findElement(By.name("raptcha[t]")).sendKeys("skip");
			driver.findElement(By.xpath("//input[@value='Crea mi cuenta']")).click();
		}while(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p")) || isElementPresent(By.cssSelector("div.error")) || !isElementPresent(By.cssSelector("div.msg.bold")));
		try {
			assertEquals("Felicitaciones! tu cuenta BR ha sido creada con éxito!", driver.findElement(By.cssSelector("div.msg.bold")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean login(){
		System.out.println("Logging in...");
		try {
			assertEquals("ACCEDER", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("user_session_login")).clear();
		driver.findElement(By.id("user_session_login")).sendKeys(usr);
		driver.findElement(By.id("user_session_password")).clear();
		driver.findElement(By.id("user_session_password")).sendKeys(pw);
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();

		if(!"Para mantener su cuenta segura ...".equals(driver.findElement(By.cssSelector("span")).getText())) return false;
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
			assertEquals("Mi Cuenta", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Número de registro: "+usr, driver.findElement(By.cssSelector("a.ui-link-inherit")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Saldo:", driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[2]/div/div/a/span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Auto-Recarga:", driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[3]/div/div/a/span")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean recharge(){
		System.out.println("Attempting Recharge...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Recarga tu cuenta")).click();		
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Boss Revolution Customers - Recargar", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//form[@id='form_recharge']/div[2]/div/fieldset/div/div[2]/label/span")).click();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_cc_verification_code")).sendKeys(ccVeri);
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Su cuenta ha sido recargada con éxito.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public String randNum(String w){
		String q;
		do
			q="34" + String.valueOf((int)(Math.floor((Math.random() * 100000000)+899999999)));
		while(q.equals(usr) || q.equals(w));
		return q;
	}

	public boolean registeredNumbers(){
		System.out.println("Changing Registered Numbers...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Los Números Registrados")).click();
		try {
			assertEquals("Boss Revolution Customers - Los Números Registrados", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='page']/div[5]/div/div/a/span")).click();
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
		return true;
	}

	public boolean quickCall(){
		System.out.println("Testing Quick Call...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("QuickCall")).click();	
		try {
			assertEquals("Boss Revolution Customers - QuickCall", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[5]/div/ul/li/a/span")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='page']/div[5]/div/ul/li/a/span")).click();
		String f = randNum("1");
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(randNum(f));
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(f);
		driver.findElement(By.name("update")).click();
		if(isElementPresent(By.cssSelector("label.error"))) return false;
		try {
			assertEquals(f, driver.findElement(By.linkText(f)).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean speedDial(){
		System.out.println("Testing Speed Dial...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Marcación Rápida")).click();
		try {
			assertEquals("Boss Revolution Customers - Marcación Rápida", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.xpath("//div[@id='page']/div[5]/div/ul/li/div/div/a/span")));
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='page']/div[5]/div/ul/li/div/div/a/span")).click();
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(randNum("2"));
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("John Snow");
		driver.findElement(By.name("update")).click();
		try {
			assertTrue(isElementPresent(By.cssSelector("a.ui-link-inherit")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean autoRC(){
		System.out.println("Testing Auto Recharge...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Ver cuenta")).click();
		driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[3]/div/div/a/span[2]")).click();
		driver.findElement(By.cssSelector("span.ui-btn-inner")).click();
		driver.findElement(By.xpath("//form[@id='form_auto_recharge']/div[7]/div/fieldset/div/div[2]/label/span")).click();
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Cuenta actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.cssSelector("span.ui-btn-inner")).click();
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Cuenta actualizado correctamente.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean updateDetails(){
		System.out.println("Updating Billing Info...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Actualiza la información de facturación")).click();
		try {
			assertEquals("Boss Revolution Customers - Actualiza la información de facturación", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).clear();
		driver.findElement(By.id("business_entity_banks_attributes_0_account_holder")).sendKeys("Qwerty");
		driver.findElement(By.id("btnGetToken")).click();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).clear();
		driver.findElement(By.id("business_entity_physical_addresses_attributes_0_zip_code")).sendKeys("12234");
		driver.findElement(By.xpath("//input[@value='Actualizar']")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Cuenta actualizado correctamente.", driver.findElement(By.cssSelector("p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean AccessNumbers(){
		System.out.println("Testing Access Numbers...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Ver cuenta")).click();
		driver.findElement(By.xpath("//div[@id='page']/div[4]/ul[2]/li/div/div/a/div")).click();
		try {
			assertEquals("Boss Revolution Customers - Llama con Boss Revolution", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("946545472", driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li/div/div/a/span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("951402854", driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[2]/div/div/a/span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("886318875", driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[3]/div/div/a/span")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean wib(){
		System.out.println("Testing What is Boss Revolution?...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("¿Qué es Boss Revolution?")).click();

		try {
			assertTrue(isElementPresent(By.cssSelector("div.header.first")));
		} catch (Error e) {
			return false;
		}

		return true;
	}

	public boolean raf(){
		System.out.println("Testing RAF...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Amigos Para Siempre")).click();
		try {
			assertEquals("Amigos Para Siempre", driver.findElement(By.cssSelector("h3 > span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Friends_forever_title\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Raf_step2_m\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Raf_step3_m\"]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean callRates(){
		System.out.println("Testing Calling Rates...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Mira las tarifas de lamadas")).click();
		try {
			assertEquals("Boss Revolution Customers - Tarifas de llamadas", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.cssSelector("input.ui-input-text.ui-body-c")).clear();
		driver.findElement(By.cssSelector("input.ui-input-text.ui-body-c")).sendKeys("u");
		driver.findElement(By.linkText("Ucrania")).click();
		try {
			assertEquals("Ucrania", driver.findElement(By.cssSelector("span.fwn")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean mobileApp(){
		System.out.println("Testing Mobile App...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Aplicaciónes Móviles")).click();
		try {
			assertEquals("APLICACIÓNES MÓVILES", driver.findElement(By.cssSelector("span")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Android app on Google Play\"]")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.cssSelector("img[alt=\"Mobile_app_mobile_es-es\"]")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean help(){
		System.out.println("Testing Help...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Mas información")).click();
		try {
			assertEquals("Boss Revolution Customers - Mas información", driver.getTitle());  
		} catch (Error e) {
			return false;
		}
		driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li/div/div/a/div")).click();
		try {
			assertEquals("Boss Revolution Customers - Llamar con Boss Revolution", driver.getTitle()); 
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Utilizando un número de acceso", driver.findElement(By.cssSelector("div.header.first")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("With the Boss Revolution Mobile App", driver.findElement(By.xpath("//div[@id='page']/div[4]/div[5]/div")).getText());
		} catch (Error e) {
			return false;
		}
		System.out.println("	Making A Call Looks OK");
		driver.get(baseUrl + "/?more_info=1");
		driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[2]/div/div/a/div")).click();
		try {
			assertEquals("Boss Revolution Customers - Como recargar tu cuenta", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Por internet", driver.findElement(By.cssSelector("div.header.first")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("In-App Purchase", driver.findElement(By.xpath("//div[@id='page']/div[4]/div[4]/div")).getText());
		} catch (Error e) {
			return false;
		}
		System.out.println("	Adding Funds Looks OK");
		driver.get(baseUrl + "/?more_info=1");
		/*driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[3]/div/div/a/div")).click();
		try {
			assertEquals("Boss Revolution Customers - BOSS REVOLUTION WI-FI", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("¿QUE ES BOSS REVOLUTION WIFI?", driver.findElement(By.cssSelector("div.header")).getText());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("WIFI Ahora GRATIS con tu cuenta Boss Revolution.", driver.findElement(By.xpath("//div[@id='page']/div[4]/div[3]/div[3]")).getText());
		} catch (Error e) {
			return false;
		}
		System.out.println("	BOSS Wi-Fi Looks OK");
		driver.get(baseUrl + "/?more_info=1");*/
		driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[3]/div/div/a/div")).click();
		System.out.println("	Testing Faq...");
		driver.findElement(By.linkText("Generales")).click();
		try {
			assertEquals("Boss Revolution Customers - Preguntas Frecuentes - Generales", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("G1")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("G5")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("G9")));
		} catch (Error e) {
			return false;
		}
		System.out.println("		General Looks OK");
		driver.get(baseUrl + "/customers/faq");
		driver.findElement(By.linkText("Llamadas internacionales")).click();
		try {
			assertEquals("Boss Revolution Customers - Preguntas Frecuentes - Llamadas internacionales", driver.getTitle());
		} catch (Error e) {
			return false;
		}	
		System.out.println("		International Calling Looks OK");
		driver.get(baseUrl + "/customers/faq");
		driver.findElement(By.linkText("Recargas de Móviles")).click();
		try {
			assertEquals("Boss Revolution Customers - Preguntas Frecuentes - Recargas de Móviles", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MTU1")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("MTU2")));
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
		System.out.println("		Mobile Top-Up Looks OK");
		
		driver.get(baseUrl + "/customers/faq");
		driver.findElement(By.linkText("Aplicaciónes Móviles")).click();
		try {
			assertEquals("Boss Revolution Customers - Preguntas Frecuentes - Aplicaciónes Móviles", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		System.out.println("		Mobile App Looks OK");
		driver.get(baseUrl + "/customers/faq");
		driver.findElement(By.linkText("Amigos Para Siempre")).click();
		try {
			assertEquals("Boss Revolution Customers - Preguntas Frecuentes - Amigos Para Siempre", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("RAF1")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("RAF6")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.id("RAF4")));
		} catch (Error e) {
			return false;
		}
		System.out.println("		Refer a Friend Looks OK");
		driver.get(baseUrl + "/?more_info=1");
		driver.findElement(By.xpath("//div[@id='page']/div[4]/ul/li[4]/div/div/a/div")).click();
		try {
			assertEquals("Boss Revolution Customers - Contáctenos", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertEquals("Por favor llame a Servicio al Cliente al 917 714 036", driver.findElement(By.cssSelector("div.header")).getText());
		} catch (Error e) {
			return false;
		}

		System.out.println("	Contact Us looks OK");
		return true;
	}

	public boolean otherCount(){
		System.out.println("Testing Other Countries");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Otros Países")).click();
		try {
			assertEquals("Boss Revolution Customers - Otros Países", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Boss Revolution UK")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Boss Revolution Canada")));
		} catch (Error e) {
			return false;
		}
		try {
			assertTrue(isElementPresent(By.linkText("Boss Revolution Australia")));
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean imtu(){
		System.out.println("Testing IMTU...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Envía recargas de móviles")).click();
		driver.findElement(By.cssSelector("a.ui-link-inherit")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Boss Revolution Customers - Recarga Móviles", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		//new Select(driver.findElement(By.id("country"))).selectByVisibleText("RU");
		Select q=new Select(driver.findElement(By.id("country")));
		if(q.getOptions().size()==0) return false;
		q.selectByVisibleText("bo");
		driver.findElement(By.id("receiver")).clear();
		driver.findElement(By.id("receiver")).sendKeys("59178945678");
		driver.findElement(By.id("imtu_cc_info")).click();
		/*try {
			assertEquals("Order Summary", driver.findElement(By.cssSelector("div.title")).getText());
		} catch (Error e) {
			return false;
		}*/
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Gracias. Su compra se ha realizado exitosamente y el nÃºmero mÃ³vil internacional ha sido recargado.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
		//return true;
	}

	public boolean dmtu(){
		System.out.println("Testing DMTU...");
		driver.findElement(By.cssSelector("a.menu.ui-link")).click();
		driver.findElement(By.linkText("Envía recargas de móviles")).click();
		driver.findElement(By.xpath("//div[@id='page']/div[5]/div/ul/li[2]/div/div/a")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Boss Revolution Customers - Recarga Móviles", driver.getTitle());
		} catch (Error e) {
			return false;
		}
		//new Select(driver.findElement(By.id("carrier"))).selectByVisibleText("Vodafone");
		Select q=new Select(driver.findElement(By.id("carrier")));
		if(q.getOptions().size()==0) return false;
		q.selectByVisibleText("Vodafone");
		Select w=new Select(driver.findElement(By.id("product")));
		w.selectByValue(w.getOptions().get(1).getAttribute("value"));
		//new Select(driver.findElement(By.id("product"))).selectByVisibleText("â‚¬10.00");;
		driver.findElement(By.id("imtu_cc_info")).click();
		/*try {
			assertEquals("Order Summary", driver.findElement(By.cssSelector("div.title")).getText());
		} catch (Error e) {
			return false;
		}*/
		driver.findElement(By.cssSelector("input.ui-btn-hidden")).click();
		if(isElementPresent(By.cssSelector("div.toast-item.toast-type-error > p"))) return false;
		try {
			assertEquals("Gracias. Su compra se ha realizado exitosamente y el nÃºmero mÃ³vil nacional ha sido recargado.", driver.findElement(By.cssSelector("div.toast-item.toast-type-notice > p")).getText());
		} catch (Error e) {
			return false;
		}
		return true;
	}

	public boolean logout(){
		System.out.println("Logging Out...");
		driver.findElement(By.cssSelector("a.logout.ui-link")).click();
		try {
			assertEquals("Con éxito la sesión.", driver.findElement(By.cssSelector("p")).getText());
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
				System.err.println("[Error]Failed to update Auto Recharge");
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
			/////////////////////////////////////////////////10
			if(quickCall()){
				System.out.println("[Sucess]Changed Numbers Successfully");
				screenShot("Quick Call");
				result[10]=1;
			}else{
				screenShot("Quick Call");
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
			/////////////////////////////////////////////////7
			if(dmtu()){
				System.out.println("[Sucess]DMTU Successful");
				screenShot("DMTU");
				result[7]=1;
			}else{
				screenShot("DMTU");
				System.err.println("[Error]DMTU Failed");
			}
		}
		if(links){
			/////////////////////////////////////////////////5
			if(AccessNumbers()){
				System.out.println("[Sucess]Acess Numbers look OK");
				result[5]=1;
			}else{
				screenShot("Acess Numbers");
				System.err.println("[Error]Something wrong with Access Numbers");
			}
			/////////////////////////////////////////////////8
			if(raf()){
				System.out.println("[Sucess]Refer a Friend looks OK");
				result[8]=1;
			}else{screenShot("RAF");
			System.err.println("[Error]Something wrong with Refer a Friend");
			}
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
			/////////////////////////////////////////////////15
			if(mobileApp()){
				System.out.println("[Sucess]Mobile App looks OK");
				result[15]=1;
			}else{
				screenShot("Mobile App");
				System.err.println("[Error]Something wrong with Mobile App");
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
				System.out.println("[Sucess]Customer Creation Sucessful");
				screenShot("Customer Creation");
				result[19]=1;
			}else{
				screenShot("Customer Creation");
				System.err.println("[Error]Customer Creation Failed");
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
		System.out.println("**ES Customer Mobile**");
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
			//QC & SD//////////////////////
			if(result[10]==1){
				if(result[11]==1){
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
				if(result[11]==1){
					System.out.println(r+") Quick Call update failed but Speed Dial Numbers updated Successfully");
					results[r++]=r-1+") Quick Call update failed but Speed Dial Numbers updated Successfully";
					ayOk = false;
				}else{
					System.out.println(r+") Quick Call and Speed Dial update failed");
					results[r++]=r-1+"){color:red} Quick Call and Speed Dial update failed{color}";
					ayOk = false;
				}
			}
			//Update Details//////////////////////
			if(result[12]==1){
				System.out.println(r+") Updated Billing Info Successfully");
				results[r++]=r-1+") Updated Billing Info Successfully";
			}else{
				System.out.println(r+") Failed to update Billing Info");
				results[r++]=r-1+") {color:red}Failed to update Billing Info{color}";
				ayOk = false;
			}
			////////////////////////
			if(result[4]==1){
				System.out.println(r+") Auto Recharge OK");
				results[r++]=r-1+") Auto Recharge OK";
			}else{
				System.out.println(r+") Something wrong with Auto Recharge");
				results[r++]=r-1+"){color:red} Something wrong with Auto Recharge{color}";
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
			//DMTU//////////////////////
			if(result[7]==1){
				System.out.println(r+") DMTU Successful");
				Email y = new Email(usr);
				String e = y.getMail("Orange");
				while(e.equals("hi"))
					e = y.getMail("Orange");
				System.out.println("*Email*");
				System.out.println(e);
				System.out.println("");
				results[r++]=r-1+") DMTU Successful\n*email*\n"+e;
			}else{
				System.out.println(r+") DMTU Failed");
				results[r++]=r-1+"){color:red} DMTU Failed{color}";
				ayOk = false;
			}
		}
		if(links){
			//Navigation//////////////////////
			if(result[2]==1 && result[8]==1 && result[13]==1 && result[14]==1 && result[15]==1 && result[17]==1 && result[5]==1){
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