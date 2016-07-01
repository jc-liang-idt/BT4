<<<<<<< HEAD
import java.awt.AWTException;
import java.io.*; 
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
=======
>>>>>>> 329f5bdbb228b512d1e814e3c218d232882d2dac
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

<<<<<<< HEAD


public class Jira {
=======
public class Jira extends Thread{
>>>>>>> 329f5bdbb228b512d1e814e3c218d232882d2dac
	
	public static void main (String[] args){
		Jira testJira = new Jira("", "cliang", "Shortbanana24"); 
		Report a1=new Report();
		testJira.post("**BOSS UK Distributor**", a1);
	}

	
	private String Jira;
	private String jiraUsr;
	private String jiraPw;
	private String[] results;
	private String[] pics;
	private int picCount;
	private int r;
	private WebDriver driver = new FirefoxDriver();
<<<<<<< HEAD
	
	public void setUp() throws Exception {
		//System.setProperty("webdriver.firefox.bin", "src/res/Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.firefox.bin", "Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		int qa = Runner.bossqa;
		if(qa==0){
			String baseUrl = "http://uk.bossqa.cstage01.n2p.com/";
		}else{
			String baseUrl = "http://uk.bossqa"+qa+".cstage01.n2p.com/";
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
=======
	private Thread dialog_handle_thread;
	
>>>>>>> 329f5bdbb228b512d1e814e3c218d232882d2dac

	public Jira(String jira, String jiraUsr, String jiraPw){
		this.Jira = jira;
		this.jiraUsr = jiraUsr;
		this.jiraPw = jiraPw;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("");
		System.out.println("Opening JIRA Ticket: "+Jira);
		driver.get("https://bugs.idt.net/browse/" + Jira);
		driver.findElement(By.id("login-form-username")).clear();
		driver.findElement(By.id("login-form-username")).sendKeys(jiraUsr);
		driver.findElement(By.id("login-form-password")).clear();
		driver.findElement(By.id("login-form-password")).sendKeys(jiraPw);
		driver.findElement(By.id("login-form-submit")).click();

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

/*	public void run(){
		dialog_handle_thread = new Thread(new Runnable() {
			public void run(){
				try {
					System.out.println("Starting...");
					// pass in the path into the dialog
					// click the 'open' button
					// sleep for like 20 seconds
					Thread.sleep(1000);
					// Child Thread do the upload file action and click on open, letting the program return to the main thread
					System.out.println("before running exe");
					Runtime.getRuntime().exec("C:\\Users\\jsu\\Desktop\\AutoIT\\FileUpload.exe");
					//driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone -dui-type-parsed')]/label[contains(@class, 'issue-drop-zone__button aui-button')]")).click();
					System.out.println("after running exe");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("exception in run try catch block: " + e1);
					e1.printStackTrace();
				}
			}
		});  
	} */
	
	public void post(String type, Report q){
		System.out.println("Posting test results on JIRA: "+Jira+"...");
		results = q.getResults();
		pics = q.getPics();
		picCount = q.getCount();
		r = q.getR();
		for (int second = 0;; second++) {
			if (second >= 60) break;
			try { if (isElementPresent(By.cssSelector("#comment-issue > span.trigger-label"))) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.findElement(By.cssSelector("span.dropdown-text")).click();
		driver.findElement(By.id("attach-file")).click();
		
		for (int second = 0;; second++) {
			if (second >= 120) break;
			try { 
				System.out.println("in waiting for loop");
				driver.switchTo().activeElement();
				if (isElementPresent(By.cssSelector("label.issue-drop-zone__button.aui-button")) == true) {
					System.out.println("Found 'Select Files' Button");
					break; 
				}
			} 
			catch (Exception e) {}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int y=0; y<picCount; y++){

			System.out.println("pics part");
			try {
				driver.switchTo().activeElement();
<<<<<<< HEAD
				System.out.println("switched to active element");
				//driver.findElement(By.cssSelector("label.issue-drop-zone__file.upfile")).sendKeys(pics[y]);
				//driver.findElement(By.xpath("//label[contains(@class, 'issue-drop-zone__button')]")).click();
				/* most plausible*/ 
				//driver.findElement(By.xpath("//label[contains(@class, 'issue-drop-zone__button')]")).sendKeys(pics[y]);
				/*WebElement fileInput = driver.findElement(By.name("issue-drop-zone__button")); 
				System.out.println("found or not: " + driver.findElement(By.name("issue-drop-zone__button")));
				fileInput.sendKeys(pics[y]); 
				System.out.println(pics[y]);
				*/				
				//driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone__button')]/button[2]")).click();
				//System.out.println("pic count: " + picCount + pics[y]); 
				//driver.findElement(By.cssSelector("label.issue-drop-zone__button.aui-button")).sendKeys(pics[y]);
			/*
		
				if (driver.findElement(By.cssSelector("label.issue-drop-zone__button.aui-button"))== null){
					System.out.println("null 1");
				}
				else{
				
					System.out.println("1");
					
					File Ifile = new File(pics[y]); 
					WebElement inputField = driver.findElement(By.cssSelector("label.issue-drop-zone__button.aui-button"));
					inputField.sendKeys(Ifile.getAbsolutePath());
			
					//System.out.println(driver.findElement(By.cssSelector("label.issue-drop-zone__button.aui-button")));
					//driver.findElement(By.cssSelector("label.issue-drop-zone__button.aui-button")).click(); 
					//driver.findElement(By.id("attach-file-submit")).click(); 
			
					String jsScript = "var input = document.getElementsByTagName('input')[0];"
					        +"input.value='/BOSS_Screenshots_v4.81';";
					JavascriptExecutor executor = (JavascriptExecutor)driver;
				}
		*/
				//driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone -dui-type-parsed')]/label[contains(@class, 'issue-drop-zone__button aui-button')]")).sendKeys(pics[y]);
				if (driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone -dui-type-parsed')]/label[contains(@class, 'issue-drop-zone__button aui-button')]"))== null ){
					System.out.println("null 2");
				}
				else{
					System.out.println("2");
					
					String jsScript = "var input = document.getElementsByTagName('label')[0];"
					        +"input.value='/C/BOSS_Screenshots_v4.81';" + "console.log(input)";
					System.out.println("jsScript script: " + jsScript);
					
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript(jsScript);
					/*
					File fileI = new File(pics[y]);
					WebElement fieldInput = driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone -dui-type-parsed')]/label[contains(@class, 'issue-drop-zone__button aui-button')]")); 
					fieldInput.sendKeys(fileI.getAbsolutePath());
					*/
					//System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone -dui-type-parsed')]/label[contains(@class, 'issue-drop-zone__button aui-button')]"))); 
					//driver.findElement(By.cssSelector("label.issue-drop-zone__button.aui-button")).click(); 
					//driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone -dui-type-parsed')]/label[contains(@class, 'issue-drop-zone__button aui-button')]")).sendKeys(pics[y]);
					//driver.findElement(By.id("attach-file-submit")).click(); 
				
				}
=======
				System.out.println("pic count: " + picCount);
				System.out.println(pics[y]); 
				
				// call Click in a separate thread, and then call the AutoIt script. Once the AutoIt script closes the dialog box, 
				// the click will return, and the rest of your test can continue.
			/*	try {
					run(); // call child thread
				}
				catch (Exception e) {
					System.out.println("exception while running the child thread");
					e.printStackTrace();
				} */
				// Main Thread clicks on the button
				driver.findElement(By.xpath("//div[contains(@class, 'issue-drop-zone -dui-type-parsed')]/label[contains(@class, 'issue-drop-zone__button aui-button')]")).click();
				
				
				
>>>>>>> 329f5bdbb228b512d1e814e3c218d232882d2dac
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.findElement(By.xpath("(//textarea[@id='comment'])[2]")).clear();
		driver.findElement(By.xpath("(//textarea[@id='comment'])[2]")).sendKeys(type+"\n");
		for(int y=1; y < r; y++){
			driver.findElement(By.xpath("(//textarea[@id='comment'])[2]")).sendKeys(results[y]+"\n");
		}
		System.out.println("not yet clicked");
		driver.findElement(By.id("attach-file-submit")).click();
		System.out.println("clicked it");
		for (int second = 0;; second++) {
			System.out.println("for loop");
			if (second >= 120) break;
			/*
			try { 
				if (!isElementPresent(By.xpath("(//textarea[@id='comment'])[2]"))) break; 
				} 
			catch (Exception e) {
					
			}
			try {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		System.out.println("Posted Results");

	}

}
