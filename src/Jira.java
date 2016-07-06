
import java.awt.AWTException;
import java.io.*; 
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.JavascriptLibrary;


public class Jira{
	
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
	private Thread dialog_handle_thread;
	
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

		System.out.println("before span dropdown");
		driver.findElement(By.cssSelector("span.dropdown-text")).click();
		driver.findElement(By.id("attach-file")).click();
		System.out.println("after the attach-file dropdown is clicked");
		
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

				System.out.println("switched to active element");
				//driver.findElement(By.cssSelector("label.issue-drop-zone__file.upfile")).sendKeys(pics[y]);
				//driver.findElement(By.xpath("//label[contains(@class, 'issue-drop-zone__button aui-button')]")).sendKeys(pics[y]);
				
				System.out.println("pic count: " + picCount);
				System.out.println(pics[y]); 
				//WebElement input = driver.findElement(By.xpath("//label[contains(@class, 'issue-drop-zone__button aui-button')]"));
				WebElement input = driver.findElement(By.className("upfile"));
				//input.issue-drop-zone__file.ignore-inline-attach.upfile
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);
				JavascriptLibrary jsLib = new JavascriptLibrary(); 
				jsLib.executeScript(driver, "document.getElementsByClassName('upfile')[0].style.display = 'block';");
				input.sendKeys(pics[y]);
				//driver.findElement(By.xpath("//label[contains(@class, 'issue-drop-zone__button aui-button')]")).click();
				
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
