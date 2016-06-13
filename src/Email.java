import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.InternetAddress;
import javax.mail.search.*;

import com.sun.mail.imap.IMAPFolder;

public class Email {

	static String protocol = "imaps";
	static String host = "imap.gmail.com";
	static String user = "testbossrev@gmail.com";
	static String password = "secret1234";
	static String mbox = "INBOX";
	static boolean debug = false;
	public String num;

	private int tries = 0;

	public Email(String usr){
		num=usr;
	}
	//grabs imtu/dmtu/new customer emails
	public String getMail(String choice) {
		if(tries++ == 7){
			return "GET MAIL ";
		}
		String subject = "[ENV: staging][To: [\"testbossrev@gmail.com\"]] SMS sent to "+num;
		String from = "do_not_reply@idt.net";
		boolean or = false;
		boolean today = true;
		int size = 1;

		try {
			// Get a Properties object
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			// Get a Session object
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			// Get a Store object
			Store store = null;	
			store = session.getStore(protocol);
			// Connect
			store.connect(host, user, password);
			// Open the Folder
			Folder folder = store.getDefaultFolder();
			if (folder == null) {
				System.out.println("Cant find default namespace");
				System.exit(1);
			}

			folder = folder.getFolder(mbox);
			if (folder == null) {
				System.out.println("Invalid folder");
				System.exit(1);
			}

			folder.open(Folder.READ_ONLY);
			SearchTerm term = null;

			if (subject != null)
				term = new SubjectTerm(subject);
			if (from != null) {
				FromStringTerm fromTerm = new FromStringTerm(from);
				if (or)
					term = new OrTerm(term, fromTerm);
				else
					term = new AndTerm(term, fromTerm);
			}
			if (today) {
				Calendar c = Calendar.getInstance();
				//	c.set(Calendar.HOUR, 0);
				c.add(Calendar.MINUTE, -3);
				//	c.set(Calendar.SECOND, 0);
				//	c.set(Calendar.MILLISECOND, 0);
				//	c.set(Calendar.AM_PM, Calendar.AM);
				ReceivedDateTerm startDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.GE, c.getTime());
				c.add(Calendar.DATE, 1);	// next day
				ReceivedDateTerm endDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.LT, c.getTime());
				SearchTerm dateTerm = new AndTerm(startDateTerm, endDateTerm);
				if (or)
					term = new OrTerm(term, dateTerm);
				else
					term = new AndTerm(term, dateTerm);
			}

			if (size >= 0) {
				SizeTerm sizeTerm = new SizeTerm(ComparisonTerm.GT, size);
				if (or)
					term = new OrTerm(term, sizeTerm);
				else
					term = new AndTerm(term, sizeTerm);
			}

			Message[] msgs = folder.search(term);
			//System.out.println("FOUND " + msgs.length + " MESSAGES");
			if (msgs.length == 0) {// no match
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hi";
			}
			// Use a suitable FetchProfile
			FetchProfile fp = new FetchProfile();
			fp.add(FetchProfile.Item.ENVELOPE);
			folder.fetch(msgs, fp);
			int i = msgs.length-1;
			String message = "hi";
			while (i >= 0 && !message.contains(choice)) {
				Object o = msgs[i].getContent();
				message = (String)o;
				i--;
			}
			folder.close(false);
			store.close();
			return message;
		} catch (Exception ex) {
			System.out.println("Oops, got exception! " + ex.getMessage());
			ex.printStackTrace();
		}
		return "hi";
	}
// testing time 

	public static void main(String[] args){
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
		
		long current = System.currentTimeMillis(); 
		System.out.println(formatter.format(current));
		
		long lowerBound = System.currentTimeMillis() - 20000;
		System.out.println(formatter.format(lowerBound));
		
		long upperBound = System.currentTimeMillis() + 20000; 
		System.out.println(formatter.format(upperBound));
		/*
		Calendar c = Calendar.getInstance(); 
		System.out.println(c.getTime());
		
		Calendar lowerBound = Calendar.getInstance();
		lowerBound.add(Calendar.SECOND, -20 );
		System.out.println("lowerBound: " + lowerBound.getTime());
		
		Calendar upperBound = Calendar.getInstance(); 
		upperBound.add(Calendar.SECOND, 20);
		System.out.println("upperBound: " + upperBound.getTime()); 	
		*/
	}
	
	//grabs emails containing email verification codes
public static String getMail2(String choice) {
	String returnString = "";
	try{
		
		Thread.sleep(4000);
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		
		Session session = Session.getDefaultInstance(props, null);
		Store store = null; 
		store = session.getStore("imaps"); 
		store.connect(host, user, password); 
		
		System.out.println("connected");
		Folder inbox = store.getFolder("INBOX"); 
		inbox.open(Folder.READ_WRITE);
		
		Flags seen = new Flags(Flags.Flag.SEEN); 
		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		
		Message[] messages = inbox.search(unseenFlagTerm); 
		System.out.println("GOT TO MESSAGES");
		for (int i =0 ; i < messages.length; i++){
			System.out.println("got inside messages");
			Message message = messages[i]; 
			
			DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
			
			long messageReceived = message.getReceivedDate().getTime();
			long lowerBound = System.currentTimeMillis() - 40000;	
			long upperBound = System.currentTimeMillis() + 40000; 
			
			System.out.println("lower bound: " + formatter.format(lowerBound));
			System.out.println("received: " + formatter.format(messageReceived));
			System.out.println("upper bound: " + formatter.format(upperBound));
			
			if (message.getSubject().toString().equals("BOSS Revolution Portal Security") 
					&& message.getFrom()[0].toString().equals("pa-israel@corp.idt.net")
					&& messageReceived >= lowerBound && messageReceived <= upperBound
					){
				System.out.println("All 3 conditions met!" );
				String answerArray = message.getContent().toString(); 
				returnString = answerArray.substring(82, 91); 
				System.out.println("return string: " + returnString);
			}
			
		}
		//SearchTerm sender = new FromTerm(new InternetAddress("pa-israel@corp.idt.net"));
		/*Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false)); 		
		String[] answerArray = new String[50];
		for (int i = 0; i < messages.length; i++){
			//messages = inbox.search(sender) TODO: how to incorporate sender and subject field? ; 
		
			answerArray[i] = messages[i].getContent().toString();	
			System.out.println("answerArray at position" + i + " " + answerArray[i]);
		}
		
		
		System.out.println(answerArray[1]);
		String returnValue = answerArray[0]; 
		String ret = returnValue.substring(82, 91); 
		returnString = ret; 
		System.out.println(" IS THIS RIGHT: " + ret);
	
		inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), true);; 
		*/
		inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), true); 	
	}
	catch(Exception ex){
		ex.printStackTrace(); 
	}
	return returnString;
}
	
/*
	public String getMail2(String choice) {

		if(tries++ == 7){
			return "THIS IS MAIL 2 ";
		}
		String subject = "BOSS Revolution Access Security";
		String from = "pa-israel@corp.idt.net";
		boolean or = false;
		boolean today = true;
		int size = 1;
		try {
			Thread.sleep(10500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// Get a Properties object
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			// Get a Session object
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			// Get a Store object
			Store store = null;	
			store = session.getStore(protocol);
			// Connect
			System.out.println("trying to connect to email");
			System.out.println("host: " + host);
			System.out.println("user: " + user);
			System.out.println("password: " + password);
			store.connect(host, user, password);
			// Open the Folder
			Folder folder = store.getDefaultFolder();
			System.out.println("Email.java got here1");
			if (folder == null) {
				System.out.println("Email.java got here2");
				System.out.println("Cant find default namespace");
				System.exit(1);
			}
			System.out.println("Email.java got here3");
			folder = folder.getFolder(mbox);
			System.out.println("Email.java got here4");
			if (folder == null) {
				System.out.println("Email.java got here5");
				System.out.println("Invalid folder");
				System.exit(1);
			}
			System.out.println("Email.java got here6");
			folder.open(Folder.READ_ONLY);
			System.out.println("Email.java got here7");
			SearchTerm term = null;
			System.out.println("Email.java got here8");
			System.out.println("subject is: " + subject);
			if (subject != null){
				System.out.println("Email.java got here9");
				term = new SubjectTerm(subject);
			}
			if (from != null) {
				System.out.println("Email.java got here10");
				FromStringTerm fromTerm = new FromStringTerm(from);
				System.out.println("EMail.java from is: " + from);
				if (or){
					term = new OrTerm(term, fromTerm);
					System.out.println("Email.java if statement OrTerm term is: " + term);
					System.out.println("Email.java if statement OrTerm fromTerm is: " + fromTerm);
				}
				else{
					term = new AndTerm(term, fromTerm);
					System.out.println("Email.java else statement OrTerm term is: " + term);
					System.out.println("Email.java else statement OrTerm fromTerm is: " + fromTerm);
				}
				}
			if (today) {
				System.out.println("Email.java got here11");
				Calendar c = Calendar.getInstance();
				//	c.set(Calendar.HOUR, 0);
				c.add(Calendar.MINUTE, -2);
				//	c.set(Calendar.SECOND, 0);
				//	c.set(Calendar.MILLISECOND, 0);
				//	c.set(Calendar.AM_PM, Calendar.AM);
				ReceivedDateTerm startDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.GE, c.getTime());
				c.add(Calendar.DATE, 1);	// next day
				ReceivedDateTerm endDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.LT, c.getTime());
				SearchTerm dateTerm = new AndTerm(startDateTerm, endDateTerm);
				if (or){
					term = new OrTerm(term, dateTerm);
					System.out.println("Email.java got here11.2");
				}
				else{
					term = new AndTerm(term, dateTerm);
					System.out.println("Email.java got here11.3");
				}
			}

			if (size >= 0) {
				System.out.println("Email.java got here12");
				SizeTerm sizeTerm = new SizeTerm(ComparisonTerm.GT, size);
				if (or){
					term = new OrTerm(term, sizeTerm);
				}
				else{
					term = new AndTerm(term, sizeTerm);
					System.out.println("else statement after here12 term to string is: " + term);
				}
			}
			
			
			System.out.println("Email.java got here13");
			Message[] msgs = folder.search(term);
	
			System.out.println("msg term is : " + term.toString());
			
	
			System.out.println("Email.java search term is: " + term);
			System.out.println("FOUND " + msgs.length + " MESSAGES");
			
			if (msgs.length == 0) {// no match
				try {
					System.out.println("Email.java got here14");
					Thread.sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Email.java got here15");
				}
				return "hi";			
			}
			// Use a suitable FetchProfile
			FetchProfile fp = new FetchProfile();
			fp.add(FetchProfile.Item.ENVELOPE);
			folder.fetch(msgs, fp);
			int i = msgs.length-1;
			String message = "hi";
			System.out.println("Email.java got here16");
			while (i >= 0 && !message.contains(choice)) {
				Object o = msgs[i].getContent();
				System.out.println("Email.java got here17");
				message = (String)o;
				System.out.println("Email.java got here18");
				i--;
			}
			folder.close(false);
			System.out.println("Email.java got here19");
			store.close();
			System.out.println("Email.java got here20");
			System.out.println("Email.java message is: " + message);
			return message;
			
		} catch (Exception ex) {
			System.out.println("EMAIL.JAVA EXCEPTION");
			System.out.println("Oops, got exception! " + ex.getMessage());
			ex.printStackTrace();
		}
		System.out.println("about to return hi, whatever that means");
		return "hi";
	}
*/
	//grabs emails containing passwords for retailers created by distributors
	public String getMail3(String choice, String region) {
		if(tries++ == 7){
			return "GET MAIL 3";
		}
		String subject = "[ENV: staging][To: [\"testbossrev@gmail.com\"]] Welcome to Boss Revolution";
		String from;
		if(region.equals("uk"))
			//from = "revolution-uk@idteurope.com";
			from = "sales@bossrevolution.co.uk";
		else if(region.equals("ca"))
			from = "retailersupport@bossrevolution.ca";
		else if(region.equals("hk"))
			from = "retailer@bossrevolution.com.hk";
		else if(region.equals("sg"))
			from = "retailer@bossrevolution.com.sg";
		else if(region.equals("es")){
			//from = "revolution-es@idteurope.com";
			from = "sales@bossrevolution.es";
			subject = "[ENV: staging][To: [\"testbossrev@gmail.com\"]] Bienvenido a Boss Revolution";
		}else if(region.equals("de"))
			//from = "germany@idteurope.com";
			from = "sales@bossrevolution.de";
		else
			from = "retailer@bossrevolution.com.au";
		
		boolean or = false;
		boolean today = true;
		int size = 1;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// Get a Properties object
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			// Get a Session object
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			// Get a Store object
			Store store = null;	
			store = session.getStore(protocol);
			// Connect
			store.connect(host, user, password);
			// Open the Folder
			Folder folder = store.getDefaultFolder();
			if (folder == null) {
				System.out.println("Cant find default namespace");
				System.exit(1);
			}

			folder = folder.getFolder(mbox);
			if (folder == null) {
				System.out.println("Invalid folder");
				System.exit(1);
			}

			folder.open(Folder.READ_ONLY);
			SearchTerm term = null;

			if (subject != null)
				term = new SubjectTerm(subject);
			if (from != null) {
				FromStringTerm fromTerm = new FromStringTerm(from);
				if (or)
					term = new OrTerm(term, fromTerm);
				else
					term = new AndTerm(term, fromTerm);
			}
			if (today) {
				Calendar c = Calendar.getInstance();
				//	c.set(Calendar.HOUR, 0);
				c.add(Calendar.MINUTE, -3);
				//	c.set(Calendar.SECOND, 0);
				//	c.set(Calendar.MILLISECOND, 0);
				//	c.set(Calendar.AM_PM, Calendar.AM);
				ReceivedDateTerm startDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.GE, c.getTime());
				c.add(Calendar.DATE, 1);	// next day
				ReceivedDateTerm endDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.LT, c.getTime());
				SearchTerm dateTerm = new AndTerm(startDateTerm, endDateTerm);
				if (or)
					term = new OrTerm(term, dateTerm);
				else
					term = new AndTerm(term, dateTerm);
			}
			if (size >= 0) {
				SizeTerm sizeTerm = new SizeTerm(ComparisonTerm.GT, size);
				if (or)
					term = new OrTerm(term, sizeTerm);
				else
					term = new AndTerm(term, sizeTerm);
			}
			Message[] msgs = folder.search(term);
			//System.out.println("FOUND " + msgs.length + " MESSAGES");
			if (msgs.length == 0) {// no match
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hi";
			}
			// Use a suitable FetchProfile
			FetchProfile fp = new FetchProfile();
			fp.add(FetchProfile.Item.ENVELOPE);
			folder.fetch(msgs, fp);
			int i = msgs.length-1;
			String message = "hi";
			while (i >= 0 && !message.contains(choice)) {
				Object o = msgs[i].getContent();
				message = (String)o;
				i--;
			}
			folder.close(false);
			store.close();
			return message;
		} catch (Exception ex) {
			System.out.println("Oops, got exception! " + ex.getMessage());
			ex.printStackTrace();
		}
		return "hi";
	}
	//same as getMail2 but for ES due to Spanish
	public String getMail4(String choice) {
		if(tries++ == 7){
			return "GET MAIL 4";
		}
		String subject = "Verificación de acceso Boss Revolution";
		String from = "pa-israel@corp.idt.net";
		boolean or = false;
		boolean today = true;
		int size = 1;
		try {
			Thread.sleep(10500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// Get a Properties object
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			// Get a Session object
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			// Get a Store object
			Store store = null;	
			store = session.getStore(protocol);
			// Connect
			store.connect(host, user, password);
			// Open the Folder
			Folder folder = store.getDefaultFolder();
			if (folder == null) {
				System.out.println("Cant find default namespace");
				System.exit(1);
			}

			folder = folder.getFolder(mbox);
			if (folder == null) {
				System.out.println("Invalid folder");
				System.exit(1);
			}

			folder.open(Folder.READ_ONLY);
			SearchTerm term = null;

			if (subject != null)
				term = new SubjectTerm(subject);
			if (from != null) {
				FromStringTerm fromTerm = new FromStringTerm(from);
				if (or)
					term = new OrTerm(term, fromTerm);
				else
					term = new AndTerm(term, fromTerm);
			}
			if (today) {
				Calendar c = Calendar.getInstance();
				//	c.set(Calendar.HOUR, 0);
				c.add(Calendar.MINUTE, -2);
				//	c.set(Calendar.SECOND, 0);
				//	c.set(Calendar.MILLISECOND, 0);
				//	c.set(Calendar.AM_PM, Calendar.AM);
				ReceivedDateTerm startDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.GE, c.getTime());
				c.add(Calendar.DATE, 1);	// next day
				ReceivedDateTerm endDateTerm = 
						new ReceivedDateTerm(ComparisonTerm.LT, c.getTime());
				SearchTerm dateTerm = new AndTerm(startDateTerm, endDateTerm);
				if (or)
					term = new OrTerm(term, dateTerm);
				else
					term = new AndTerm(term, dateTerm);
			}

			if (size >= 0) {
				SizeTerm sizeTerm = new SizeTerm(ComparisonTerm.GT, size);
				if (or)
					term = new OrTerm(term, sizeTerm);
				else
					term = new AndTerm(term, sizeTerm);
			}

			Message[] msgs = folder.search(term);
			//System.out.println("FOUND " + msgs.length + " MESSAGES");
			if (msgs.length == 0) {// no match
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hi";
			}
			// Use a suitable FetchProfile
			FetchProfile fp = new FetchProfile();
			fp.add(FetchProfile.Item.ENVELOPE);
			folder.fetch(msgs, fp);
			int i = msgs.length-1;
			String message = "hi";
			while (i >= 0 && !message.contains(choice)) {
				Object o = msgs[i].getContent();
				message = (String)o;
				i--;
			}
			folder.close(false);
			store.close();
			return message;
		} catch (Exception ex) {
			System.out.println("Oops, got exception! " + ex.getMessage());
			ex.printStackTrace();
		}
		return "hi";
	}
}