import java.io.File;

import org.apache.commons.io.FileUtils;



public class Runner{

	/* set variables to be used */ 
	///////////////JIRA Info/////////////////////////////////
	boolean postJira = true; //Post to Jira?
	String bossVersion = ""; //in order to store screenshots
	String Jira = ""; //Jira task to post to
	String jiraUsr = "cliang"; //Jira username
	String jiraPw = "Shortbanana24"; //Jira password
	/////////////////////////////////////////////////////////

	///////////////UK Customer Desktop Info//////////////////
	boolean testUKCustomer = false; // Test UK Desktop?
	String UKCusr = ""; //account phone number
	String UKCpw = "secret1234"; //security code
	String UKCccVeri = ""; //credit card CVV
	boolean UKCupdate = true;
	boolean UKCpayment = true;
	boolean UKClinks = true;
	boolean UKCcreation = true;
	/////////////////////////////////////////////////////////

	///////////////UK Retailer Info//////////////////////////
	boolean testUKRetailer = false; // Test UK retailer?
	String UKRusr = ""; //account phone number
	String UKRpw = "secret1234"; //security code
	boolean UKRupdate = true;
	boolean UKRcreation = true;
	boolean UKRpayment = true;
	boolean UKRlinks = true;
	/////////////////////////////////////////////////////////

	///////////////UK Customer Mobile Info///////////////////
	boolean testUKMobile = false; // Test UK mobile?
	String UKMusr = ""; //account phone number
	String UKMpw = ""; //security code
	String UKMccVeri = ""; //credit card CVV
	boolean UKMupdate = true;
	boolean UKMpayment = true;
	boolean UKMlinks = true;
	boolean UKMcreation = true;
	/////////////////////////////////////////////////////////

	///////////////UK Agent Info/////////////////////////////
	boolean testUKAgent = false; // Test UK agent?
	String UKAusr = ""; 
	String UKApw = "";  
	String UKAsecurityAns = "123";
	boolean UKAcreation = true;
	boolean UKApayment = true;
	boolean UKAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////UK Sales Agent Info/////////////////////////////
	boolean testUKSagent = false;
	String UKSusr = ""; 
	String UKSpw = ""; 
	String UKSccVeri;
	boolean UKSupdate = true;
	boolean UKScreation = true;
	boolean UKSpayment = true;
	boolean UKSlinks = true;
	/////////////////////////////////////////////////////////

	///////////////UK Distributer Info/////////////////////////////
	boolean testUKDist = false; 
	String UKDusr = "";
	String UKDpw = ""; 
	String UKDccVeri;
	String UKDsecurityAns = "123";
	boolean UKDupdate = true;
	boolean UKDcreation = true;
	boolean UKDpayment = true;
	boolean UKDlinks = true;
	/////////////////////////////////////////////////////////

	///////////////UK DMA Info/////////////////////////////
	boolean testUKDMA = false; 
	String UKDMAusr = ""; 
	String UKDMApw = ""; 
	String UKDMAccVeri;
	boolean UKDMAupdate = true;
	boolean UKDMAcreation = true;
	boolean UKDMApayment = true;
	boolean UKDMAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////CA Customer Desktop Info//////////////////
	boolean testCACustomer = false; // Test CA Desktop?
	String CACusr = "6111111111"; //account phone number
	String CACpw = "4269"; //security code
	String CACccVeri = "123"; //credit card CVV
	String CACsecurityAnswer = "qq"; // Answer to Security Question
	boolean CACupdate = true;
	boolean CACpayment = true;
	boolean CAClinks = true;
	boolean CACcreation = true;
	/////////////////////////////////////////////////////////

	///////////////CA Retailer Info//////////////////////////
	boolean testCARetailer = false; // Test CA Retailer?
	String CARusr = ""; //account phone number
	String CARpw = "1234"; //security code
	String CARsecurityAnswer = "123"; // Answer to Security Question
	boolean CARupdate = true;
	boolean CARcreation = true;
	boolean CARpayment = true;
	boolean CARlinks = true;
	/////////////////////////////////////////////////////////

	///////////////CA Customer Mobile Info///////////////////
	boolean testCAMobile = false; // Test CA Mobile?
	String CAMusr = "6111111111"; //account phone number
	String CAMpw = "4269"; //security code
	String CAMccVeri = "123"; //credit card CVV
	String CAMsecurityAnswer = "qq"; // Answer to Security Question
	boolean CAMupdate = true;
	boolean CAMpayment = true;
	boolean CAMlinks = true;
	boolean CAMcreation = true;
	/////////////////////////////////////////////////////////

	///////////////CA Agent Info/////////////////////////////
	boolean testCAAgent = false; 
	String CAAusr = "1111094969";
	String CAApw = "1234";
	String CAAsa = "123";
	boolean CAAcreation = true;
	boolean CAApayment = true;
	boolean CAAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////CA Sales Agent Info/////////////////////////////
	boolean testCASagent = false;
	String CASusr = "1111094969"; 
	String CASpw = "1234"; 
	String CASccVeri;
	String CASsecurityAnswer;
	boolean CASupdate = true;
	boolean CAScreation = true;
	boolean CASpayment = true;
	boolean CASlinks = true;
	/////////////////////////////////////////////////////////

	///////////////CA Distributer Info/////////////////////////////
	boolean testCADist = false; 
	String CADusr;
	String CADpw; 
	String CADccVeri;
	String CADsecurityAnswer;
	boolean CADupdate = true;
	boolean CADcreation = true;
	boolean CADpayment = true;
	boolean CADlinks = true;
	/////////////////////////////////////////////////////////

	///////////////CA DMA Info/////////////////////////////
	boolean testCADMA = false; 
	String CADMAusr = "1111094969"; 
	String CADMApw = "1234"; 
	String CADMAsecurityAnswer;
	String CADMAccVeri;
	boolean CADMAupdate = true;
	boolean CADMAcreation = true;
	boolean CADMApayment = true;
	boolean CADMAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////HK Customer Desktop Info//////////////////
	boolean testHKCustomer = false; // Test CA Desktop?
	String HKCusr = ""; //account phone number
	String HKCpw = ""; //security code
	String HKCccVeri = ""; //credit card CVV
	String HKCsecurityAnswer = ""; // Answer to Security Question
	boolean HKCupdate = true;
	boolean HKCpayment = true;
	boolean HKClinks = true;
	boolean HKCcreation = true;
	/////////////////////////////////////////////////////////

	///////////////HK Retailer Info//////////////////////////
	boolean testHKRetailer = false; // Test CA Retailer?
	String HKRusr = ""; //account phone number
	String HKRpw = ""; //security code
	String HKRsecurityAnswer = ""; // Answer to Security Question
	boolean HKRupdate = true;
	boolean HKRcreation = true;
	boolean HKRpayment = true;
	boolean HKRlinks = true;
	/////////////////////////////////////////////////////////

	///////////////HK Customer Mobile Info///////////////////
	boolean testHKMobile = false; // Test CA Mobile?
	String HKMusr = ""; //account phone number
	String HKMpw = ""; //security code
	String HKMccVeri = ""; //credit card CVV
	String HKMsecurityAnswer = ""; // Answer to Security Question
	boolean HKMupdate = true;
	boolean HKMpayment = true;
	boolean HKMlinks = true;
	boolean HKMcreation = true;
	/////////////////////////////////////////////////////////

	///////////////HK Agent Info/////////////////////////////
	boolean testHKAgent = false; 
	String HKAusr = "";
	String HKApw = "";
	boolean HKAcreation = true;
	boolean HKApayment = true;
	boolean HKAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////HK Sales Agent Info/////////////////////////////
	boolean testHKSagent = false;
	String HKSusr = ""; 
	String HKSpw = ""; 
	String HKSccVeri = ""; //credit card CVV
	String HKSsecurityAnswer = "123"; // Answer to Security Question
	boolean HKSupdate = true;
	boolean HKScreation = true;
	boolean HKSpayment = true;
	boolean HKSlinks = true;
	/////////////////////////////////////////////////////////

	///////////////HK Distributer Info/////////////////////////////
	boolean testHKDist = false; 
	String HKDusr = "";
	String HKDpw = ""; 
	String HKDccVeri = ""; //credit card CVV
	String HKDsecurityAnswer = ""; // Answer to Security Question
	boolean HKDupdate = true;
	boolean HKDcreation = true;
	boolean HKDpayment = true;
	boolean HKDlinks = true;
	/////////////////////////////////////////////////////////

	///////////////HK DMA Info/////////////////////////////
	boolean testHKDMA = false; 
	String HKDMAusr = ""; 
	String HKDMApw = ""; 
	String HKDMAccVeri = ""; //credit card CVV
	String HKDMAsecurityAnswer = ""; // Answer to Security Question
	boolean HKDMAupdate = true;
	boolean HKDMAcreation = true;
	boolean HKDMApayment = true;
	boolean HKDMAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////SG Customer Desktop Info//////////////////
	boolean testSGCustomer = false; // Test CA Desktop?
	String SGCusr = ""; //account phone number
	String SGCpw = ""; //security code
	String SGCccVeri = ""; //credit card CVV
	String SGCsecurityAnswer = ""; // Answer to Security Question
	boolean SGCupdate = true;
	boolean SGCpayment = true;
	boolean SGClinks = true;
	boolean SGCcreation = true;
	/////////////////////////////////////////////////////////

	///////////////SG Retailer Info//////////////////////////
	boolean testSGRetailer = false; // Test CA Retailer?
	String SGRusr = ""; //account phone number
	String SGRpw = ""; //security code
	String SGRsecurityAnswer = ""; // Answer to Security Question
	boolean SGRupdate = true;
	boolean SGRcreation = true;
	boolean SGRpayment = true;
	boolean SGRlinks = true;
	/////////////////////////////////////////////////////////

	///////////////SG Customer Mobile Info///////////////////
	boolean testSGMobile = false; // Test CA Mobile?
	String SGMusr = ""; //account phone number
	String SGMpw = ""; //security code
	String SGMccVeri = ""; //credit card CVV
	String SGMsecurityAnswer = ""; // Answer to Security Question
	boolean SGMupdate = true;
	boolean SGMpayment = true;
	boolean SGMlinks = true;
	boolean SGMcreation = true;
	/////////////////////////////////////////////////////////

	///////////////SG Agent Info/////////////////////////////
	boolean testSGAgent = false; 
	String SGAusr = "";
	String SGApw = "";
	boolean SGAcreation = true;
	boolean SGApayment = true;
	boolean SGAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////SG Sales Agent Info/////////////////////////////
	boolean testSGSagent = false;
	String SGSusr = ""; 
	String SGSpw = ""; 
	String SGSccVeri = ""; //credit card CVV
	String SGSsecurityAnswer = ""; // Answer to Security Question
	boolean SGSupdate = true;
	boolean SGScreation = true;
	boolean SGSpayment = true;
	boolean SGSlinks = true;
	/////////////////////////////////////////////////////////

	///////////////SG Distributer Info/////////////////////////////
	boolean testSGDist = false; 
	String SGDusr = "";
	String SGDpw = ""; 
	String SGDccVeri = ""; //credit card CVV
	String SGDsecurityAnswer = ""; // Answer to Security Question
	boolean SGDupdate = true;
	boolean SGDcreation = true;
	boolean SGDpayment = true;
	boolean SGDlinks = true;
	/////////////////////////////////////////////////////////

	///////////////SG DMA Info/////////////////////////////
	boolean testSGDMA = false; 
	String SGDMAusr = ""; 
	String SGDMApw = ""; 
	String SGDMAccVeri = ""; //credit card CVV
	String SGDMAsecurityAnswer = ""; // Answer to Security Question
	boolean SGDMAupdate = true;
	boolean SGDMAcreation = true;
	boolean SGDMApayment = true;
	boolean SGDMAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////ES Customer Desktop Info//////////////////
	boolean testESCustomer = false; // Test CA Desktop?
	String ESCusr = ""; //account phone number
	String ESCpw = ""; //security code
	String ESCccVeri = ""; //credit card CVV
	String ESCsecurityAnswer = ""; // Answer to Security Question
	boolean ESCupdate = true;
	boolean ESCpayment = true;
	boolean ESClinks = true;
	boolean ESCcreation = true;
	/////////////////////////////////////////////////////////

	///////////////ES Retailer Info//////////////////////////
	boolean testESRetailer = false; // Test CA Retailer?
	String ESRusr = ""; //account phone number
	String ESRpw = ""; //security code
	String ESRsecurityAnswer = ""; // Answer to Security Question
	boolean ESRupdate = true;
	boolean ESRcreation = true;
	boolean ESRpayment = true;
	boolean ESRlinks = true;
	/////////////////////////////////////////////////////////

	///////////////ES Customer Mobile Info///////////////////
	boolean testESMobile = false; // Test CA Mobile?
	String ESMusr = ""; //account phone number
	String ESMpw = ""; //security code
	String ESMccVeri = ""; //credit card CVV
	String ESMsecurityAnswer = ""; // Answer to Security Question
	boolean ESMupdate = true;
	boolean ESMpayment = true;
	boolean ESMlinks = true;
	boolean ESMcreation = true;
	/////////////////////////////////////////////////////////

	///////////////ES Agent Info/////////////////////////////
	boolean testESAgent = false; 
	String ESAusr = "";
	String ESApw = "";
	boolean ESAcreation = true;
	boolean ESApayment = true;
	boolean ESAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////ES Sales Agent Info/////////////////////////////
	boolean testESSagent = false;
	String ESSusr = ""; 
	String ESSpw = ""; 
	String ESSccVeri = ""; //credit card CVV
	String ESSsecurityAnswer = ""; // Answer to Security Question
	boolean ESSupdate = true;
	boolean ESScreation = true;
	boolean ESSpayment = true;
	boolean ESSlinks = true;
	/////////////////////////////////////////////////////////

	///////////////ES Distributer Info/////////////////////////////
	boolean testESDist = false; 
	String ESDusr = "";
	String ESDpw = ""; 
	String ESDccVeri = ""; //credit card CVV
	String ESDsecurityAnswer = ""; // Answer to Security Question
	boolean ESDupdate = true;
	boolean ESDcreation = true;
	boolean ESDpayment = true;
	boolean ESDlinks = true;
	/////////////////////////////////////////////////////////

	///////////////ES DMA Info/////////////////////////////
	boolean testESDMA = false; 
	String ESDMAusr = ""; 
	String ESDMApw = ""; 
	String ESDMAccVeri = ""; //credit card CVV
	String ESDMAsecurityAnswer = ""; // Answer to Security Question
	boolean ESDMAupdate = true;
	boolean ESDMAcreation = true;
	boolean ESDMApayment = true;
	boolean ESDMAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////DE Customer Ddektop Info//////////////////
	boolean testDECustomer = false; // Tdet CA Ddektop?
	String DECusr = ""; //account phone number
	String DECpw = ""; //security code
	String DECccVeri = ""; //credit card CVV
	String DECsecurityAnswer = ""; // Answer to Security Qudetion
	boolean DECupdate = true;
	boolean DECpayment = true;
	boolean DEClinks = true;
	boolean DECcreation = true;
	/////////////////////////////////////////////////////////

	///////////////DE Retailer Info//////////////////////////
	boolean testDERetailer = false; // Tdet CA Retailer?
	String DERusr = ""; //account phone number
	String DERpw = ""; //security code
	String DERsecurityAnswer = ""; // Answer to Security Qudetion
	boolean DERupdate = true;
	boolean DERcreation = true;
	boolean DERpayment = true;
	boolean DERlinks = true;
	/////////////////////////////////////////////////////////

	///////////////DE Customer Mobile Info///////////////////
	boolean testDEMobile = false; // Tdet CA Mobile?
	String DEMusr = ""; //account phone number
	String DEMpw = ""; //security code
	String DEMccVeri = ""; //credit card CVV
	String DEMsecurityAnswer = ""; // Answer to Security Qudetion
	boolean DEMupdate = true;
	boolean DEMpayment = true;
	boolean DEMlinks = true;
	boolean DEMcreation = true;
	/////////////////////////////////////////////////////////

	///////////////DE Agent Info/////////////////////////////
	boolean testDEAgent = false; 
	String DEAusr = "";
	String DEApw = "";
	String DEAsecAns = "";
	boolean DEAcreation = true;
	boolean DEApayment = true;
	boolean DEAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////DE Salde Agent Info/////////////////////////////
	boolean testDESagent = false;
	String DESusr = ""; 
	String DESpw = ""; 
	String DESccVeri = ""; //credit card CVV
	String DESsecurityAnswer = ""; // Answer to Security Qudetion
	boolean DESupdate = true;
	boolean DEScreation = true;
	boolean DESpayment = true;
	boolean DESlinks = true;
	/////////////////////////////////////////////////////////

	///////////////DE Distributer Info/////////////////////////////
	boolean testDEDist = false; 
	String DEDusr = "";
	String DEDpw = ""; 
	String DEDccVeri = ""; //credit card CVV
	String DEDsecurityAnswer = ""; // Answer to Security Qudetion
	boolean DEDupdate = true;
	boolean DEDcreation = true;
	boolean DEDpayment = true;
	boolean DEDlinks = true;
	/////////////////////////////////////////////////////////

	///////////////DE DMA Info/////////////////////////////
	boolean testDEDMA = false; 
	String DEDMAusr = ""; 
	String DEDMApw = ""; 
	String DEDMAccVeri = ""; //credit card CVV
	String DEDMAsecurityAnswer = ""; // Answer to Security Qudetion
	boolean DEDMAupdate = true;
	boolean DEDMAcreation = true;
	boolean DEDMApayment = true;
	boolean DEDMAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////AU Customer Dauktop Info//////////////////
	boolean testAUCustomer = false; // Taut CA Dauktop?
	String AUCusr = ""; //account phone number
	String AUCpw = ""; //security coau
	String AUCccVeri = ""; //credit card CVV
	String AUCsecurityAnswer = ""; // Answer to Security Quaution
	boolean AUCupdate = true;
	boolean AUCpayment = true;
	boolean AUClinks = true;
	boolean AUCcreation = true;
	/////////////////////////////////////////////////////////

	///////////////AU Retailer Info//////////////////////////
	boolean testAURetailer = false; // Taut CA Retailer?
	String AURusr = ""; //account phone number
	String AURpw = ""; //security coau
	String AURsecurityAnswer = ""; // Answer to Security Quaution
	boolean AURupdate = true;
	boolean AURcreation = true;
	boolean AURpayment = true;
	boolean AURlinks = true;
	/////////////////////////////////////////////////////////

	///////////////AU Customer Mobile Info///////////////////
	boolean testAUMobile = false; // Taut CA Mobile?
	String AUMusr = ""; //account phone number
	String AUMpw = ""; //security coau
	String AUMccVeri = ""; //credit card CVV
	String AUMsecurityAnswer = ""; // Answer to Security Quaution
	boolean AUMupdate = true;
	boolean AUMpayment = true;
	boolean AUMlinks = true;
	boolean AUMcreation = true;
	/////////////////////////////////////////////////////////

	///////////////AU Agent Info/////////////////////////////
	boolean testAUAgent = false; 
	String AUAusr = "";
	String AUApw = "";
	boolean AUAcreation = true;
	boolean AUApayment = true;
	boolean AUAlinks = true;
	/////////////////////////////////////////////////////////

	///////////////AU Salau Agent Info/////////////////////////////
	boolean testAUSagent = false;
	String AUSusr = ""; 
	String AUSpw = ""; 
	String AUSccVeri = ""; //credit card CVV
	String AUSsecurityAnswer = ""; // Answer to Security Quaution
	boolean AUSupdate = true;
	boolean AUScreation = true;
	boolean AUSpayment = true;
	boolean AUSlinks = true;
	/////////////////////////////////////////////////////////

	///////////////AU Distributer Info/////////////////////////////
	boolean testAUDist = false; 
	String AUDusr = "";
	String AUDpw = ""; 
	String AUDccVeri = ""; //credit card CVV
	String AUDsecurityAnswer = ""; // Answer to Security Quaution
	boolean AUDupdate = true;
	boolean AUDcreation = true;
	boolean AUDpayment = true;
	boolean AUDlinks = true;
	/////////////////////////////////////////////////////////

	///////////////AU DMA Info/////////////////////////////
	boolean testAUDMA = false; 
	String AUDMAusr = ""; 
	String AUDMApw = ""; 
	String AUDMAccVeri = ""; //credit card CVV
	String AUDMAsecurityAnswer = ""; // Answer to Security Quaution
	boolean AUDMAupdate = true;
	boolean AUDMAcreation = true;
	boolean AUDMApayment = true;
	boolean AUDMAlinks = true;
	/////////////////////////////////////////////////////////

	static int bossqa = 0;

	
	public void Run() throws Exception{
		/* declare and initiate reports */ 
		Report a1=new Report(), a2=new Report(), a3=new Report(), a4=new Report(), a5=new Report(), a6=new Report(), a7=new Report(), a8=new Report();
		Report b1=new Report(), b2=new Report(), b3=new Report(), b4=new Report(), b5=new Report(), b6=new Report(), b7=new Report(), b8=new Report();
		Report c1=new Report(), c2=new Report(), c3=new Report(), c4=new Report(), c5=new Report(), c6=new Report(), c7=new Report(), c8=new Report();
		Report d1=new Report(), d2=new Report(), d3=new Report(), d4=new Report(), d5=new Report(), d6=new Report(), d7=new Report(), d8=new Report();
		Report e1=new Report(), e2=new Report(), e3=new Report(), e4=new Report(), e5=new Report(), e6=new Report(), e7=new Report(), e8=new Report();
		Report f1=new Report(), f2=new Report(), f3=new Report(), f4=new Report(), f5=new Report(), f6=new Report(), f7=new Report(), f8=new Report();
		Report g1=new Report(), g2=new Report(), g3=new Report(), g4=new Report(), g5=new Report(), g6=new Report(), g7=new Report(), g8=new Report();
		boolean testUKR1 = false, testUKR4 = false;
		boolean testCAR1 = false, testCAR4 = false;
		boolean testHKR1 = false, testHKR4 = false;
		boolean testSGR1 = false, testSGR4 = false;
		boolean testESR1 = false, testESR4 = false;
		boolean testDER1 = false, testDER4 = false;
		boolean testAUR1 = false, testAUR4 = false;

		//FileUtils.deleteQuietly(new File("C:\\BOSS_Screenshots_"+ bossVersion));
		
		/* if any of the tests are selected, if selected, then create object and run */ 
		if(testUKDist){
			QA_UK_Distributor z = new QA_UK_Distributor(UKDusr, UKDpw, UKDsecurityAns, bossVersion, UKDupdate, UKDcreation, UKDpayment, UKDlinks);
			z.setUp();
			boolean dist= z.test();
			if(dist){
				z.tearDown();
				z.print();
				a1 = z.Reports();
				System.out.println("");
			}else{
				testUKDist = false;
			}
			/*
			if(dist && UKDcreation){
				testUKR1=true;
				testUKR4=true;
				System.out.println("Testing Cash Retailer - "+z.r1+":"+z.r1p);
				QA_UK_Retailer R1 = new QA_UK_Retailer(z.r1, z.r1p, bossVersion, true, true, true, true,1);
				R1.setUp();
				if(R1.test()){
					R1.tearDown();
					R1.print();
					a2 = R1.Reports();
					System.out.println("");
				}else{
					testUKR1 = false;
				}
				System.out.println("Testing Credit Retailer - "+z.r3+":"+z.r3p);
				QA_UK_Retailer R4 = new QA_UK_Retailer(z.r3, z.r3p, bossVersion, true, true, true, true,2);
				R4.setUp();
				if(R4.test()){
					R4.tearDown();
					R4.print();
					a3 = R4.Reports();
					System.out.println("");
				}else{
					testUKR4 = false;
				}
			}
			*/
		}
		
		if(testUKSagent){
			QA_UK_SalesAgent z = new QA_UK_SalesAgent(UKSusr, UKSpw, bossVersion, UKSupdate, UKScreation, UKSpayment, UKSlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				a4 = z.Reports();
				System.out.println("");
			}else{
				testUKSagent = false;
			}
		}
		if(testUKRetailer){
			QA_UK_Retailer z = new QA_UK_Retailer("441142433949","1234", bossVersion, UKRupdate, UKRcreation, UKRpayment, UKRlinks,0);
			z.setUp();
			//System.out.println("RUNNER");
			//System.out.println("UK Retailer user name: " + UKSusr);
			//System.out.println("UK Retailer password: " + UKSpw);
			if(z.test()){
				z.tearDown();
				z.print();
				a5 = z.Reports();
				System.out.println("");
			}else{
				testUKRetailer = false;
				System.out.println("did not pass test in runner");
			}
		}
		if(testUKAgent){
			QA_UK_Agent z = new QA_UK_Agent(UKAusr, UKApw, UKAsecurityAns,bossVersion, UKAcreation, UKApayment, UKAlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				a6 = z.Reports();
				System.out.println("");
			}else{
				testUKAgent = false;
			}
		}
		if(testUKCustomer){
			QA_UK_Customer_Desktop z = new QA_UK_Customer_Desktop(UKCusr, UKCpw, UKCccVeri, bossVersion, UKCupdate, UKCpayment, UKClinks, UKCcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				a7 = z.Reports();
				System.out.println("");
			}else{
				testUKCustomer = false;
			}
		}
		if(testUKMobile){
			QA_UK_Customer_Mobile z = new QA_UK_Customer_Mobile(UKMusr, UKMpw, UKMccVeri, bossVersion, UKMupdate, UKMpayment, UKMlinks, UKMcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				a8 = z.Reports();
				System.out.println("");
			}else{
				testUKMobile = false;
			}
		}
		/////////////////////////////////////////////////////////////////////////////
		if(testCADist){
			QA_CA_Distributor z = new QA_CA_Distributor(CADusr, CADpw, CADsecurityAnswer, bossVersion, CADupdate, CADcreation, CADpayment, CADlinks);
			z.setUp();
			boolean dist = z.test();
			if(dist){
				z.tearDown();
				z.print();
				b1 = z.Reports();
				System.out.println("");
			}else{
				testCADist = false;
			}
			/*if(dist && CADcreation){
				testCAR1=true;
				testCAR4=true;
				System.out.println("Testing Cash Retailer - "+z.r1);
				QA_CA_Retailer R1 = new QA_CA_Retailer(z.r1, z.r1p, "123", bossVersion, true, true, true, true,1);
				R1.setUp();
				if(R1.test()){
					R1.tearDown();
					R1.print();
					b2 = R1.Reports();
					System.out.println("");
				}else{
					testCAR1 = false;
				}
				System.out.println("Testing Credit Retailer - "+z.r2);
				QA_CA_Retailer R4 = new QA_CA_Retailer(z.r2, z.r2p, "123", bossVersion, true, true, true, true,2);
				R4.setUp();
				if(R4.test()){
					R4.tearDown();
					R4.print();
					b3 = R4.Reports();
					System.out.println("");
				}else{
					testCAR4 = false;
				}
			}*/
		}
		if(testCASagent){
			QA_CA_SalesAgent z = new QA_CA_SalesAgent(CASusr, CASpw, bossVersion, CASupdate, CAScreation, CASpayment, CASlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				b4 = z.Reports();
				System.out.println("");
			}else{
				testCASagent = false;
			}
		}
		if(testCARetailer){
			QA_CA_Retailer z = new QA_CA_Retailer(CARusr, CARpw, CARsecurityAnswer, bossVersion, CARupdate, CARcreation, CARpayment, CARlinks,0);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				b5 = z.Reports();
				System.out.println("");
			}else{
				testCARetailer = false;
			}
		}
		if(testCAAgent){
			QA_CA_Agent z = new QA_CA_Agent(CAAusr, CAApw, CAAsa, bossVersion, CAAcreation, CAApayment, CAAlinks);
			z.setUp();
			System.out.println("after setup"); 
			if(z.test()){
				z.tearDown();
				z.print();
				b6 = z.Reports();
				System.out.println("");
			}else{
				testCAAgent = false;
			}
		}
		if(testCACustomer){
			QA_CA_Customer_Desktop z = new QA_CA_Customer_Desktop(CACusr, CACpw, CACccVeri, CACsecurityAnswer, bossVersion, CACupdate, CACpayment, CAClinks, CACcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				b7 = z.Reports();
				System.out.println("");
			}else{
				testCACustomer = false;
			}
		}
		if(testCAMobile){
			QA_CA_Customer_Mobile z = new QA_CA_Customer_Mobile(CAMusr, CAMpw, CAMccVeri, CAMsecurityAnswer, bossVersion, CAMupdate, CAMpayment, CAMlinks, CAMcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				b8 = z.Reports();
				System.out.println("");
			}else{
				testCAMobile = false;
			}
		}	
		///////////////////////////////////////////////////////////////////////////
		if(testHKDist){
			QA_HK_Distributor z = new QA_HK_Distributor(HKDusr, HKDpw, HKDsecurityAnswer, bossVersion, HKDupdate, HKDcreation, HKDpayment, HKDlinks);
			z.setUp();
			boolean dist = z.test();
			if(dist){
				z.tearDown();
				z.print();
				c1 = z.Reports();
				System.out.println("");
			}else{
				testHKDist = false;
			}
			/*if(dist && HKDcreation){
				testHKR1=true;
				testHKR4=true;
				System.out.println("Testing Cash Retailer - "+z.r1);
				QA_HK_Retailer R1 = new QA_HK_Retailer(z.r1, z.r1p, "123", bossVersion, true, true, true, true,1);
				R1.setUp();
				if(R1.test()){
					R1.tearDown();
					R1.print();
					c2 = R1.Reports();
					System.out.println("");
				}else{
					testHKR1 = false;
				}
				System.out.println("Testing Credit Retailer - "+z.r4);
				QA_HK_Retailer R4 = new QA_HK_Retailer(z.r4, z.r4p, "123", bossVersion, true, true, true, true,2);
				R4.setUp();
				if(R4.test()){
					R4.tearDown();
					R4.print();
					c3 = R4.Reports();
					System.out.println("");
				}else{
					testHKR4 = false;
				}
			}*/
		}
		if(testHKSagent){
			QA_HK_SalesAgent z = new QA_HK_SalesAgent(HKSusr, HKSpw, bossVersion, HKSupdate, HKScreation, HKSpayment, HKSlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				c4 = z.Reports();
				System.out.println("");
			}else{
				testHKSagent = false;
			}
		}
		if(testHKRetailer){
			QA_HK_Retailer z = new QA_HK_Retailer(HKRusr, HKRpw, HKRsecurityAnswer, bossVersion, HKRupdate, HKRcreation, HKRpayment, HKRlinks,0);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				c5 = z.Reports();
				System.out.println("");
			}else{
				testHKRetailer = false;
			}
		}	
		if(testHKAgent){
			QA_HK_Agent z = new QA_HK_Agent(HKAusr, HKApw, bossVersion, HKAcreation, HKApayment, HKAlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				c6 = z.Reports();
				System.out.println("");
			}else{
				testHKAgent = false;
			}
		}
		if(testHKCustomer){
			QA_HK_Customer_Desktop z = new QA_HK_Customer_Desktop(HKCusr, HKCpw, HKCccVeri, HKCsecurityAnswer, bossVersion, HKCupdate, HKCpayment, HKClinks, HKCcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				c7 = z.Reports();
				System.out.println("");
			}else{
				testHKCustomer = false;
			}
		}
		if(testHKMobile){
			QA_HK_Customer_Mobile z = new QA_HK_Customer_Mobile(HKMusr, HKMpw, HKMccVeri, HKMsecurityAnswer, bossVersion, HKMupdate, HKMpayment, HKMlinks, HKMcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				c8 = z.Reports();
				System.out.println("");
			}else{
				testHKMobile = false;
			}
		}	
		///////////////////////////////////////////////////////////////////////////	
		if(testSGDist){
			QA_SG_Distributor z = new QA_SG_Distributor(SGDusr, SGDpw, SGDsecurityAnswer, bossVersion, SGDupdate, SGDcreation, SGDpayment, SGDlinks);
			z.setUp();
			boolean dist = z.test();
			if(dist){
				z.tearDown();
				z.print();
				d1 = z.Reports();
				System.out.println("");
			}else{
				testSGDist = false;
			}
		/*	if(dist && SGDcreation){
				testSGR1=true;
				testSGR4=true;
				System.out.println("Testing Cash Retailer - "+z.r1);
				QA_SG_Retailer R1 = new QA_SG_Retailer(z.r1, z.r1p, "123", bossVersion, true, true, true, true,1);
				R1.setUp();
				if(R1.test()){
					R1.tearDown();
					R1.print();
					d2 = R1.Reports();
					System.out.println("");
				}else{
					testSGR1 = false;
				}
				System.out.println("Testing Credit Retailer - "+z.r4);
				QA_SG_Retailer R4 = new QA_SG_Retailer(z.r4, z.r4p, "123", bossVersion, true, true, true, true,2);
				R4.setUp();
				if(R4.test()){
					R4.tearDown();
					R4.print();
					d3 = R4.Reports();
					System.out.println("");
				}else{
					testSGR4 = false;
				}
			}*/
		}
		if(testSGSagent){
			QA_SG_SalesAgent z = new QA_SG_SalesAgent(SGSusr, SGSpw, bossVersion, SGSupdate, SGScreation, SGSpayment, SGSlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				d4 = z.Reports();
				System.out.println("");
			}else{
				testSGSagent = false;
			}
		}
		if(testSGRetailer){
			QA_SG_Retailer z = new QA_SG_Retailer(SGRusr, SGRpw, SGRsecurityAnswer, bossVersion, SGRupdate, SGRcreation, SGRpayment, SGRlinks,0);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				d5 = z.Reports();
				System.out.println("");
			}else{
				testSGRetailer = false;
			}
		}	
		if(testSGAgent){
			QA_SG_Agent z = new QA_SG_Agent(SGAusr, SGApw, bossVersion, SGAcreation, SGApayment, SGAlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				d6 = z.Reports();
				System.out.println("");
			}else{
				testSGAgent = false;
			}
		}
		if(testSGCustomer){
			QA_SG_Customer_Desktop z = new QA_SG_Customer_Desktop(SGCusr, SGCpw, SGCccVeri, SGCsecurityAnswer, bossVersion, SGCupdate, SGCpayment, SGClinks, SGCcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				d7 = z.Reports();
				System.out.println("");
			}else{
				testSGCustomer = false;
			}
		}
		if(testSGMobile){
			QA_SG_Customer_Mobile z = new QA_SG_Customer_Mobile(SGMusr, SGMpw, SGMccVeri, SGMsecurityAnswer, bossVersion, SGMupdate, SGMpayment, SGMlinks, SGMcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				d8 = z.Reports();
				System.out.println("");
			}else{
				testSGMobile = false;
			}
		}	
		///////////////////////////////////////////////////////////////////////////	
		if(testESDist){
			QA_ES_Distributor z = new QA_ES_Distributor(ESDusr, ESDpw, ESDsecurityAnswer, bossVersion, ESDupdate, ESDcreation, ESDpayment, ESDlinks);
			z.setUp();
			boolean dist = z.test();
			if(dist){
				z.tearDown();
				z.print();
				e1 = z.Reports();
				System.out.println("");
			}else{
				testESDist = false;
			}
			/*if(dist && ESDcreation){
				testESR1=true;
				testESR4=true;
				System.out.println("Testing Cash Retailer - "+z.r1);
				QA_ES_Retailer R1 = new QA_ES_Retailer(z.r1, z.r1p, "123", bossVersion, true, true, true, true,1);
				R1.setUp();
				if(R1.test()){
					R1.tearDown();
					R1.print();
					e2 = R1.Reports();
					System.out.println("");
				}else{
					testESR1 = false;
				}
				System.out.println("Testing Credit Retailer - "+z.r4);
				QA_ES_Retailer R4 = new QA_ES_Retailer(z.r4, z.r4p, "123", bossVersion, true, true, true, true,2);
				R4.setUp();
				if(R4.test()){
					R4.tearDown();
					R4.print();
					e3 = R4.Reports();
					System.out.println("");
				}else{
					testESR4 = false;
				}
			}*/
		}
		if(testESSagent){
			QA_ES_SalesAgent z = new QA_ES_SalesAgent(ESSusr, ESSpw, bossVersion, ESSupdate, ESScreation, ESSpayment, ESSlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				e4 = z.Reports();
				System.out.println("");
			}else{
				testESSagent = false;
			}
		}
		if(testESRetailer){
			QA_ES_Retailer z = new QA_ES_Retailer(ESRusr, ESRpw, ESRsecurityAnswer, bossVersion, ESRupdate, ESRcreation, ESRpayment, ESRlinks,0);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				e5 = z.Reports();
				System.out.println("");
			}else{
				testESRetailer = false;
			}
		}
		if(testESAgent){
			QA_ES_Agent z = new QA_ES_Agent(ESAusr, ESApw, bossVersion, ESAcreation, ESApayment, ESAlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				e6 = z.Reports();
				System.out.println("");
			}else{
				testESAgent = false;
			}
		}
		if(testESCustomer){
			QA_ES_Customer_Desktop z = new QA_ES_Customer_Desktop(ESCusr, ESCpw, ESCccVeri, ESCsecurityAnswer, bossVersion, ESCupdate, ESCpayment, ESClinks, ESCcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				e7 = z.Reports();
				System.out.println("");
			}else{
				testESCustomer = false;
			}
		}
		if(testESMobile){
			QA_ES_Customer_Mobile z = new QA_ES_Customer_Mobile(ESMusr, ESMpw, ESMccVeri, ESMsecurityAnswer, bossVersion, ESMupdate, ESMpayment, ESMlinks, ESMcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				e8 = z.Reports();
				System.out.println("");
			}else{
				testESMobile = false;
			}
		}	
		///////////////////////////////////////////////////////////////////////////	
		if(testDEDist){
			QA_DE_Distributor z = new QA_DE_Distributor(DEDusr, DEDpw, DEDsecurityAnswer, bossVersion, DEDupdate, DEDcreation, DEDpayment, DEDlinks);
			z.setUp();
			boolean dist = z.test();
			if(dist){
				z.tearDown();
				z.print();
				f1 = z.Reports();
				System.out.println("");
			}else{
				testDEDist = false;
			}
			/*if(dist && DEDcreation){
				testDER1=true;
				testDER4=true;
				System.out.println("Testing Cash Retailer - "+z.r1);
				QA_DE_Retailer R1 = new QA_DE_Retailer(z.r1, z.r1p, "123", bossVersion, true, true, true, true,1);
				R1.setUp();
				if(R1.test()){
					R1.tearDown();
					R1.print();
					f2 = R1.Reports();
					System.out.println("");
				}else{
					testDER1 = false;
				}
				System.out.println("Testing Credit Retailer - "+z.r4);
				QA_DE_Retailer R4 = new QA_DE_Retailer(z.r4, z.r4p, "123", bossVersion, true, true, true, true,2);
				R4.setUp();
				if(R4.test()){
					R4.tearDown();
					R4.print();
					f3 = R4.Reports();
					System.out.println("");
				}else{
					testDER4 = false;
				}
			}*/
		}
		if(testDESagent){
			QA_DE_SalesAgent z = new QA_DE_SalesAgent(DESusr, DESpw, bossVersion, DESupdate, DEScreation, DESpayment, DESlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				f4 = z.Reports();
				System.out.println("");
			}else{
				testDESagent = false;
			}
		}
		if(testDERetailer){
			QA_DE_Retailer z = new QA_DE_Retailer(DERusr, DERpw, DERsecurityAnswer, bossVersion, DERupdate, DERcreation, DERpayment, DERlinks,0);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				f5 = z.Reports();
				System.out.println("");
			}else{
				testDERetailer = false;
			}
		}
		if(testDEAgent){
			QA_DE_Agent z = new QA_DE_Agent(DEAusr, DEApw, DEAsecAns, bossVersion, DEAcreation, DEApayment, DEAlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				f6 = z.Reports();
				System.out.println("");
			}else{
				testDEAgent = false;
			}
		}
		if(testDECustomer){
			QA_DE_Customer_Desktop z = new QA_DE_Customer_Desktop(DECusr, DECpw, DECccVeri, DECsecurityAnswer, bossVersion, DECupdate, DECpayment, DEClinks, DECcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				f7 = z.Reports();
				System.out.println("");
			}else{
				testDECustomer = false;
			}
		}
		if(testDEMobile){
			QA_DE_Customer_Mobile z = new QA_DE_Customer_Mobile(DEMusr, DEMpw, DEMccVeri, DEMsecurityAnswer, bossVersion, DEMupdate, DEMpayment, DEMlinks, DEMcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				f8 = z.Reports();
				System.out.println("");
			}else{
				testDEMobile = false;
			}
		}	
		///////////////////////////////////////////////////////////////////////////	
		if(testAUDist){
			QA_AU_Distributor z = new QA_AU_Distributor(AUDusr, AUDpw, AUDsecurityAnswer, bossVersion, AUDupdate, AUDcreation, AUDpayment, AUDlinks);
			z.setUp();
			boolean dist = z.test();
			if(dist){
				z.tearDown();
				z.print();
				g1 = z.Reports();
				System.out.println("");
			}else{
				testAUDist = false;
			}
		/*	if(dist && AUDcreation){
				testAUR1=true;
				testAUR4=true;
				System.out.println("Testing Cash Retailer - "+z.r1);
				QA_AU_Retailer R1 = new QA_AU_Retailer(z.r1, z.r1p, bossVersion, true, true, true, true,1);
				R1.setUp();
				if(R1.test()){
					R1.tearDown();
					R1.print();
					g2 = R1.Reports();
					System.out.println("");
				}else{
					testAUR1 = false;
				}
				System.out.println("Testing Credit Retailer - "+z.r4);
				QA_AU_Retailer R4 = new QA_AU_Retailer(z.r4, z.r4p, bossVersion, true, true, true, true,2);
				R4.setUp();
				if(R4.test()){
					R4.tearDown();
					R4.print();
					g3 = R4.Reports();
					System.out.println("");
				}else{
					testAUR4 = false;
				}
			}*/
		}
		if(testAUSagent){
			QA_AU_SalesAgent z = new QA_AU_SalesAgent(AUSusr, AUSpw, bossVersion, AUSupdate, AUScreation, AUSpayment, AUSlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				g4 = z.Reports();
				System.out.println("");
			}else{
				testAUSagent = false;
			}
		}
		if(testAURetailer){
			QA_AU_Retailer z = new QA_AU_Retailer(AURusr, AURpw, bossVersion, AURupdate, AURcreation, AURpayment, AURlinks,0);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				g5 = z.Reports();
				System.out.println("");
			}else{
				testAURetailer = false;
			}
		}
		if(testAUAgent){
			QA_AU_Agent z = new QA_AU_Agent(AUAusr, AUApw, bossVersion, AUAcreation, AUApayment, AUAlinks);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				g6 = z.Reports();
				System.out.println("");
			}else{
				testAUAgent = false;
			}
		}
		if(testAUCustomer){
			QA_AU_Customer_Desktop z = new QA_AU_Customer_Desktop(AUCusr, AUCpw, AUCccVeri, AUCsecurityAnswer, bossVersion, AUCupdate, AUCpayment, AUClinks, AUCcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				g7 = z.Reports();
				System.out.println("");
			}else{
				testAUCustomer = false;
			}
		}
		if(testAUMobile){
			QA_AU_Customer_Mobile z = new QA_AU_Customer_Mobile(AUMusr, AUMpw, AUMccVeri, AUMsecurityAnswer, bossVersion, AUMupdate, AUMpayment, AUMlinks, AUMcreation);
			z.setUp();
			if(z.test()){
				z.tearDown();
				z.print();
				g8 = z.Reports();
				System.out.println("");
			}else{
				testAUMobile = false;
			}
		}	

		if(postJira){
			Jira qq = new Jira(Jira, jiraUsr, jiraPw);
			// UK
			if(testUKDist)
			/* unsure if is used 
			if(testUKR1)
				qq.post("**BOSS UK Cash Retailer**", a2);	
			if(testUKR4)
				qq.post("**BOSS UK Credit Retailer**", a3);	
			 unsure if is used */ 
			if(testUKSagent)
				qq.post("**BOSS UK Sales Agent**", a4);
			if(testUKRetailer)
				qq.post("**BOSS UK Re"
						+ ""
						+ ""
						+ "tailer**", a5);	
			if(testUKAgent)
				qq.post("**BOSS UK Agent**", a6);	
			if(testUKCustomer)
				qq.post("**BOSS UK Customer Desktop**", a7);				
			if(testUKMobile)
				qq.post("**BOSS UK Customer Mobile**", a8);
			
			// CA
			if(testCADist)
				qq.post("**BOSS CA Distributor**", b1);	
			/*
			if(testCAR1)
				qq.post("**BOSS CA Cash Retailer**", b2);	
			if(testCAR4)
				qq.post("**BOSS CA Credit Retailer**", b3);	
			 */
			if(testCASagent)
				qq.post("**BOSS CA Sales Agent**", b4);		
			if(testCARetailer)
				qq.post("**BOSS CA Retailer**", b5);		
			if(testCAAgent)
				qq.post("**BOSS CA Agent**", b6);
			if(testCACustomer)
				qq.post("**BOSS CA Customer Desktop**",b7);	
			if(testCAMobile)
				qq.post("**BOSS CA Customer Mobile**", b8);	
			
			// HK
			if(testHKDist)
				qq.post("**BOSS HK Distributor**", c1);
			/*
			if(testHKR1)
				qq.post("**BOSS HK Cash Retailer**", c2);	
			if(testHKR4)
				qq.post("**BOSS HK Credit Retailer**", c3);	
			*/
			if(testHKSagent)
				qq.post("**BOSS HK Sales Agent**", c4);
			if(testHKRetailer)
				qq.post("**BOSS HK Retailer**", c5);
			if(testHKAgent)
				qq.post("**BOSS HK Agent**", c6);
			if(testHKCustomer)
				qq.post("**BOSS HK Customer Desktop**", c7);
			if(testHKMobile)
				qq.post("**BOSS HK Customer Mobile**", c8);
			
			// SG
			if(testSGDist)
				qq.post("**BOSS SG Distributor**", d1);
			/*
			if(testSGR1)
				qq.post("**BOSS SG Cash Retailer**", d2);	
			if(testSGR4)
				qq.post("**BOSS SG Credit Retailer**", d3);	
			*/
			if(testSGSagent)
				qq.post("**BOSS SG Sales Agent**", d4);
			if(testSGRetailer)
				qq.post("**BOSS SG Retailer**", d5);
			if(testSGAgent)
				qq.post("**BOSS SG Agent**", d6);
			if(testSGCustomer)
				qq.post("**BOSS SG Customer Desktop**", d7);
			if(testSGMobile)
				qq.post("**BOSS SG Customer Mobile**", d8);
			
			// ES
			if(testESDist)
				qq.post("**BOSS ES Distributor**", e1);
			/*
			if(testESR1)
				qq.post("**BOSS ES Cash Retailer**", e2);	
			if(testESR4)
				qq.post("**BOSS ES Credit Retailer**", e3);	
			*/
			if(testESSagent)
				qq.post("**BOSS ES Sales Agent**", e4);
			if(testESRetailer)
				qq.post("**BOSS ES Retailer**", e5);
			if(testESAgent)
				qq.post("**BOSS ES Agent**", e6);
			if(testESCustomer)
				qq.post("**BOSS ES Customer Desktop**", e7);	
			if(testESMobile)
				qq.post("**BOSS ES Customer Mobile**", e8);
			
			// DE
			if(testDEDist)
				qq.post("**BOSS DE Distributor**", f1);
			/*
			if(testDER1)
				qq.post("**BOSS DE Cash Retailer**", f2);	
			if(testDER4)
				qq.post("**BOSS DE Credit Retailer**", f3);	
			*/
			if(testDESagent)
				qq.post("**BOSS DE Sales Agent**", f4);
			if(testDERetailer)
				qq.post("**BOSS DE Retailer**", f5);
			if(testDEAgent)
				qq.post("**BOSS DE Agent**", f6);
			if(testDECustomer)
				qq.post("**BOSS DE Customer Desktop**", f7);	
			if(testDEMobile)
				qq.post("**BOSS DE Customer Mobile**", f8);
			
			// AU
			if(testAUDist)
				qq.post("**BOSS AU Distributor**", g1);
			/*
			if(testAUR1)
				qq.post("**BOSS AU Cash Retailer**", g2);	
			if(testAUR4)
				qq.post("**BOSS AU Credit Retailer**", g3);	
			*/
			if(testAUSagent)
				qq.post("**BOSS AU Sales Agent**", g4);
			if(testAURetailer)
				qq.post("**BOSS AU Retailer**", g5);
			if(testAUAgent)
				qq.post("**BOSS AU Agent**", g6);
			if(testAUCustomer)
				qq.post("**BOSS AU Customer Desktop**", g7);	
			if(testAUMobile)
				qq.post("**BOSS AU Customer Mobile**", g8);
		}

	}

}
