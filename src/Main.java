import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager.*;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Toolkit;
import javax.swing.JRadioButton;


public class Main {
	/* declare all variables */ 
	private File configFile = new File("config.properties");
	private Properties configProps;
	private Thread R;
	private Runner t = new Runner();
	private boolean startState = true;
	private JFrame frmBossTester;
	private JCheckBox ukcc;
	private JCheckBox ukmc;
	/* c: customer 
	 * m: mobile 
	 * r: retailer
	 * a: agent 
	 * d: distributor 
	 * s: sales 
	 */
	
	private boolean ukcb=false, ukmb=false, ukrb=false, ukab=false, ukdb=false, uksb=false, ukdmab=false;
	private boolean cacb=false, camb=false, carb=false, caab=false, cadb=false, casb=false, cadmab=false;
	private boolean hkcb=false, hkmb=false, hkrb=false, hkab=false, hkdb=false, hksb=false, hkdmab=false;
	private boolean escb=false, esmb=false, esrb=false, esab=false, esdb=false, essb=false, esdmab=false;
	private boolean sgcb=false, sgmb=false, sgrb=false, sgab=false, sgdb=false, sgsb=false, sgdmab=false;
	private boolean decb=false, demb=false, derb=false, deab=false, dedb=false, desb=false, dedmab=false;
	private boolean aucb=false, aumb=false, aurb=false, auab=false, audb=false, ausb=false, audmab=false;
	private boolean jiraqab=false;
	private JCheckBoxMenuItem checkBoxMenuItem_12;
	private JCheckBoxMenuItem checkBoxMenuItem_14;
	private JCheckBoxMenuItem checkBoxMenuItem_15;
	private JTextField ukcui;
	private JTextField ukcpi;
	private JTextField ukcci;
	private JCheckBox ukrc;
	private JCheckBoxMenuItem checkBoxMenuItem;
	private JCheckBoxMenuItem checkBoxMenuItem_1;
	private JCheckBoxMenuItem checkBoxMenuItem_2;
	private JCheckBoxMenuItem checkBoxMenuItem_3;
	private JTextField ukrui;
	private JTextField ukrpi;
	private JTextField ukmui;
	private JTextField ukmpi;
	private JTextField ukmci;
	private JTextField ukaui;
	private JTextField ukapi;
	private JTextField jiraUsr;
	private JTextField jiraqai;
	private JTextField qaversion;
	private JPasswordField jiraPw;
	private JTextField ukdui;
	private JTextField ukdpi;
	private JTextField ukdci;
	private JTextField uksui;
	private JTextField ukspi;
	private JTextField ukdmaui;
	private JTextField ukdmapi;
	private JTextField ukdmaci;
	private JTextField cacui;
	private JTextField cacpi;
	private JTextField cacci;
	private JTextField camui;
	private JTextField campi;
	private JTextField camci;
	private JTextField cadmaui;
	private JTextField cadmapi;
	private JTextField cadmaci;
	private JTextField carui;
	private JTextField carpi;
	private JTextField caaui;
	private JTextField caapi;
	private JTextField cadui;
	private JTextField cadpi;
	private JTextField casui;
	private JTextField caspi;
	private JTextField hkcui;
	private JTextField hkcpi;
	private JTextField hkcci;
	private JTextField hkmui;
	private JTextField hkmpi;
	private JTextField hkmci;
	private JTextField hkdmaui;
	private JTextField hkdmapi;
	private JTextField hkdmaci;
	private JTextField hkrui;
	private JTextField hkrpi;
	private JTextField hkaui;
	private JTextField hkapi;
	private JTextField hkdui;
	private JTextField hkdpi;
	private JTextField hksui;
	private JTextField hkspi;
	private JTextField cacsi;
	private JTextField camsi;
	private JTextField carsi;
	private JTextField cadmasi;
	private JTextField cadsi;
	private JTextField hkdsi;
	private JTextField hkdmasi;
	private JTextField hkmsi;
	private JTextField hkcsi;
	private JTextField hkrsi;
	private JRadioButton rb;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb5;
	private JRadioButton rb6;
	private JButton ukbtn;
	private JButton cabtn;
	private JButton hkbtn;
	private JButton esbtn;
	private JButton debtn;
	private JButton aubtn;
	private JButton sgbtn;
	private JButton jirabtn;
	private boolean uks,cas,hks,sgs,des,aus,ess,jiras;
	private JTextField sgcui;
	private JTextField sgcpi;
	private JTextField sgcci;
	private JTextField sgmui;
	private JTextField sgmpi;
	private JTextField sgmci;
	private JTextField sgdmaui;
	private JTextField sgdmapi;
	private JTextField sgdmaci;
	private JTextField sgrui;
	private JTextField sgrpi;
	private JTextField sgaui;
	private JTextField sgapi;
	private JTextField sgdui;
	private JTextField sgdpi;
	private JTextField sgsui;
	private JTextField sgspi;
	private JTextField sgdsi;
	private JTextField sgdmasi;
	private JTextField sgmsi;
	private JTextField sgcsi;
	private JTextField sgrsi;
	private JPanel sgp;
	private JTextField escui;
	private JTextField escpi;
	private JTextField escci;
	private JTextField esmui;
	private JTextField esmpi;
	private JTextField esmci;
	private JTextField esdmaui;
	private JTextField esdmapi;
	private JTextField esdmaci;
	private JTextField esrui;
	private JTextField esrpi;
	private JTextField esaui;
	private JTextField esapi;
	private JTextField esdui;
	private JTextField esdpi;
	private JTextField essui;
	private JTextField esspi;
	private JTextField esdsi;
	private JTextField esdmasi;
	private JTextField esmsi;
	private JTextField escsi;
	private JTextField esrsi;
	private JPanel esp;
	private JTextField decui;
	private JTextField decpi;
	private JTextField decci;
	private JTextField demui;
	private JTextField dempi;
	private JTextField demci;
	private JTextField dedmaui;
	private JTextField dedmapi;
	private JTextField dedmaci;
	private JTextField derui;
	private JTextField derpi;
	private JTextField deaui;
	private JTextField deapi;
	private JTextField dedui;
	private JTextField dedpi;
	private JTextField desui;
	private JTextField despi;
	private JTextField dedsi;
	private JTextField dedmasi;
	private JTextField demsi;
	private JTextField decsi;
	private JTextField dersi;
	private JPanel dep;
	private JTextField aucui;
	private JTextField aucpi;
	private JTextField aucci;
	private JTextField aumui;
	private JTextField aumpi;
	private JTextField aumci;
	private JTextField audmaui;
	private JTextField audmapi;
	private JTextField audmaci;
	private JTextField aurui;
	private JTextField aurpi;
	private JTextField auaui;
	private JTextField auapi;
	private JTextField audui;
	private JTextField audpi;
	private JTextField ausui;
	private JTextField auspi;
	private JTextField audsi;
	private JTextField audmasi;
	private JTextField aumsi;
	private JTextField aucsi;
	private JTextField aursi;
	private JPanel aup;
	private JTextField ukaci;
	private JTextField caaci;
	private JTextField deasi;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("MAIN");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try { /* create GUI window */ 
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (Exception e) {
						System.out.println("exception: " + e);
					    // If Nimbus is not available, you can set the GUI to another look and feel.
					}
					Main window = new Main(); /* Creates Main Object to call initialize() */ 
					window.frmBossTester.setVisible(true);
				} catch (Exception e) {
					System.out.println("exception: " + e);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		System.out.println("Capital MAIN");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public Thread run(){
		//System.out.println("RUN");
		Thread t1 = new Thread(new Runnable() {
			public void run(){
				try {
					System.out.println("Starting...");
					t.Run();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("exception in run try catch block: " + e1);
					e1.printStackTrace();
				}
			}
		});  
		//System.out.println("got out of run function");
		//System.out.println("t1: " + t1);
		return t1;
	}

	private void initialize() {
		System.out.println("INITIALIZE");
		frmBossTester = new JFrame();
		frmBossTester.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		frmBossTester.setTitle("BOSS Tester");
		frmBossTester.setBounds(200, 200, 1000, 1000);
		frmBossTester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBossTester.getContentPane().setLayout(new CardLayout(0, 0));
		frmBossTester.setLocationRelativeTo(null);
		//frmBossTester.setResizable(false);

		/* define main panel */ 
		final JPanel mainPanel = new JPanel();
		frmBossTester.getContentPane().add(mainPanel, "name_11573469838514");
		mainPanel.setLayout(null);

		/* define elements in JIRA tab */ 
		final JPanel jiraP = new JPanel();
		frmBossTester.getContentPane().add(jiraP, "name_25710554774423");
		jiraP.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("JIRA");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 209, 14);
		jiraP.add(lblNewLabel_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 25, 513, 2);
		jiraP.add(separator_2);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.setBounds(434, 438, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				jiraP.setVisible(false);
				if(jiraqab){
					jirabtn.setForeground(new Color(0, 128, 0));
					jiras=true;
				}else{
					jirabtn.setForeground(Color.RED);
					jiras=false;
				}
			}
		});
		jiraP.add(btnBack);

		final JCheckBox jiraqa = new JCheckBox("Post results to JIRA");
		jiraqa.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				jiraqab = jiraqa.isSelected();
			}
		});
		jiraqa.setBounds(193, 94, 168, 23);
		jiraP.add(jiraqa);

		jiraUsr = new JTextField();
		jiraUsr.setFont(new Font("Calibri", Font.PLAIN, 12));
		jiraUsr.setText("JIRA Username");
		jiraUsr.setBounds(193, 124, 125, 25);
		jiraP.add(jiraUsr);
		jiraUsr.setColumns(10);

		jiraqai = new JTextField();
		jiraqai.setFont(new Font("Calibri", Font.PLAIN, 12));
		jiraqai.setText("Ticket");
		jiraqai.setColumns(10);
		jiraqai.setBounds(193, 186, 125, 25);
		jiraP.add(jiraqai);

		qaversion = new JTextField();
		qaversion.setFont(new Font("Calibri", Font.PLAIN, 12));
		qaversion.setText("Version");
		qaversion.setColumns(10);
		qaversion.setBounds(193, 217, 125, 25);
		jiraP.add(qaversion);

		jiraPw = new JPasswordField();
		jiraPw.setFont(new Font("Calibri", Font.PLAIN, 12));
		jiraPw.setToolTipText("password");
		jiraPw.setBounds(193, 155, 125, 25);
		jiraP.add(jiraPw);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label.setBounds(463, 11, 70, 14);
		jiraP.add(label);
		
		rb = new JRadioButton("BOSSQA");
		rb.setSelected(true);
		rb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(rb.isSelected()){
					rb1.setSelected(false);
					rb2.setSelected(false);
					rb3.setSelected(false);
					rb4.setSelected(false);
					rb5.setSelected(false);
					rb6.setSelected(false);
				}
			}
		});
		rb.setBounds(44, 124, 109, 23);
		jiraP.add(rb);
		
		rb1 = new JRadioButton("BOSSQA1");
		rb1.setEnabled(false);
		rb1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rb1.isSelected()){
					rb.setSelected(false);
					rb2.setSelected(false);
					rb3.setSelected(false);
					rb4.setSelected(false);
					rb5.setSelected(false);
					rb6.setSelected(false);
				}
			}
		});
		rb1.setBounds(44, 150, 109, 23);
		jiraP.add(rb1);
		
		rb2 = new JRadioButton("BOSSQA2");
		rb2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rb2.isSelected()){
					rb.setSelected(false);
					rb1.setSelected(false);
					rb3.setSelected(false);
					rb4.setSelected(false);
					rb5.setSelected(false);
					rb6.setSelected(false);
				}
			}
		});
		rb2.setBounds(44, 176, 109, 23);
		jiraP.add(rb2);
		
		rb3 = new JRadioButton("BOSSQA3");
		rb3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rb3.isSelected()){
					rb.setSelected(false);
					rb1.setSelected(false);
					rb2.setSelected(false);
					rb4.setSelected(false);
					rb5.setSelected(false);
					rb6.setSelected(false);
				}
			}
		});
		rb3.setBounds(44, 202, 109, 23);
		jiraP.add(rb3);
		
		rb4 = new JRadioButton("BOSSQA4");
		rb4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rb4.isSelected()){
					rb.setSelected(false);
					rb1.setSelected(false);
					rb2.setSelected(false);
					rb3.setSelected(false);
					rb5.setSelected(false);
					rb6.setSelected(false);
				}
			}
		});
		rb4.setBounds(44, 228, 109, 23);
		jiraP.add(rb4);
		
		rb5 = new JRadioButton("BOSSQA5");
		rb5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rb5.isSelected()){
					rb.setSelected(false);
					rb1.setSelected(false);
					rb2.setSelected(false);
					rb3.setSelected(false);
					rb4.setSelected(false);
					rb6.setSelected(false);
				}
			}
		});
		rb5.setBounds(44, 254, 109, 23);
		jiraP.add(rb5);
		
		rb6 = new JRadioButton("BOSSQA6");
		rb6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rb6.isSelected()){
					rb.setSelected(false);
					rb1.setSelected(false);
					rb2.setSelected(false);
					rb3.setSelected(false);
					rb4.setSelected(false);
					rb5.setSelected(false);
				}
			}
		});
		rb6.setBounds(44, 280, 109, 23);
		jiraP.add(rb6);

		/* define UK tab */ 
		final JPanel ukp = new JPanel();
		frmBossTester.getContentPane().add(ukp, "name_25708050667821");
		ukp.setLayout(null);

		JLabel lblBossTester = new JLabel("United Kingdom");
		lblBossTester.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblBossTester.setBounds(10, 11, 154, 14);
		ukp.add(lblBossTester);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 25, 513, 2);
		ukp.add(separator_1);

		JButton back = new JButton("Back");
		back.setFont(new Font("Calibri", Font.PLAIN, 14));
		back.setBounds(434, 438, 89, 23);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				ukp.setVisible(false);
				if(ukcb||ukmb||ukrb||ukab||ukdb||uksb||ukdmab){
					ukbtn.setForeground(new Color(0, 128, 0));
					uks=true;
				}else{
					ukbtn.setForeground(Color.RED);
					uks=false;
				}
				
			}
		});
		ukp.add(back);

		ukcc = new JCheckBox("Test Customer Desktop");
		System.out.println("got to JCheckBox Test Customer Desktop");
		ukcc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				ukcb = ukcc.isSelected();
			}
		});
		ukcc.setBounds(10, 32, 174, 23);
		ukp.add(ukcc);

		JPopupMenu popupMenu_4 = new JPopupMenu();
		addPopup(ukcc, popupMenu_4);

		JMenuBar menuBar_4 = new JMenuBar();
		popupMenu_4.add(menuBar_4);

		 checkBoxMenuItem_12 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_12.setSelected(true);
		popupMenu_4.add(checkBoxMenuItem_12);

		 checkBoxMenuItem_14 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_14.setSelected(true);
		popupMenu_4.add(checkBoxMenuItem_14);

		 checkBoxMenuItem_15 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_15.setSelected(true);
		popupMenu_4.add(checkBoxMenuItem_15);
		
		final JCheckBoxMenuItem chckbxmntmNewCheckItem1 = new JCheckBoxMenuItem("Creation");
		chckbxmntmNewCheckItem1.setSelected(true);
		popupMenu_4.add(chckbxmntmNewCheckItem1);

		ukcui = new JTextField();
		ukcui.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukcui.setBounds(10, 62, 144, 25);
		ukcui.setText("Account #");
		ukp.add(ukcui);
		ukcui.setColumns(10);

		ukcpi = new JTextField();
		ukcpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukcpi.setBounds(10, 93, 144, 25);
		ukcpi.setText("Security Code");
		ukcpi.setColumns(10);
		ukp.add(ukcpi);

		ukcci = new JTextField();
		ukcci.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukcci.setBounds(10, 124, 144, 25);
		ukcci.setText("CVV");
		ukcci.setColumns(10);
		ukp.add(ukcci);

		ukrc = new JCheckBox("Test Retailer");
		ukrc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ukrb = ukrc.isSelected();
			}
		});
		ukrc.setBounds(10, 170, 144, 23);
		ukp.add(ukrc);

		JPopupMenu popupMenu_2 = new JPopupMenu();
		addPopup(ukrc, popupMenu_2);

		JMenuBar menuBar_1 = new JMenuBar();
		popupMenu_2.add(menuBar_1);

		 checkBoxMenuItem = new JCheckBoxMenuItem("Update info");
		 checkBoxMenuItem.setSelected(true);
		popupMenu_2.add(checkBoxMenuItem);

		 checkBoxMenuItem_1 = new JCheckBoxMenuItem("Creation");
		 checkBoxMenuItem_1.setSelected(true);
		popupMenu_2.add(checkBoxMenuItem_1);

		 checkBoxMenuItem_2 = new JCheckBoxMenuItem("Payment");
		 checkBoxMenuItem_2.setSelected(true);
		popupMenu_2.add(checkBoxMenuItem_2);

		 checkBoxMenuItem_3 = new JCheckBoxMenuItem("Links");
		 checkBoxMenuItem_3.setSelected(true);
		popupMenu_2.add(checkBoxMenuItem_3);

		ukrui = new JTextField();
		ukrui.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukrui.setBounds(10, 200, 144, 25);
		ukrui.setText("Account #");
		ukrui.setColumns(10);
		ukp.add(ukrui);

		ukrpi = new JTextField();
		ukrpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukrpi.setBounds(10, 231, 144, 25);
		ukrpi.setText("Security Code");
		ukrpi.setColumns(10);
		ukp.add(ukrpi);

		ukmc = new JCheckBox("Test Customer Mobile");
		ukmc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ukmb = ukmc.isSelected();
			}
		});
		ukmc.setBounds(186, 32, 154, 23);
		ukp.add(ukmc);

		JPopupMenu popupMenu_5 = new JPopupMenu();
		addPopup(ukmc, popupMenu_5);

		JMenuBar menuBar_5 = new JMenuBar();
		popupMenu_5.add(menuBar_5);

		/* unsure if used ? */ 
		final JCheckBoxMenuItem checkBoxMenuItem_16 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_16.setSelected(true);
		popupMenu_5.add(checkBoxMenuItem_16);

		final JCheckBoxMenuItem checkBoxMenuItem_18 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_18.setSelected(true);
		popupMenu_5.add(checkBoxMenuItem_18);

		final JCheckBoxMenuItem checkBoxMenuItem_19 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_19.setSelected(true);
		popupMenu_5.add(checkBoxMenuItem_19);
		
		final JCheckBoxMenuItem chckbxmntmNewCheckItem_2 = new JCheckBoxMenuItem("Creation");
		chckbxmntmNewCheckItem_2.setSelected(true);
		popupMenu_5.add(chckbxmntmNewCheckItem_2);

		ukmui = new JTextField();
		ukmui.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukmui.setBounds(186, 62, 144, 25);
		ukmui.setText("Account #");
		ukmui.setColumns(10);
		ukp.add(ukmui);

		ukmpi = new JTextField();
		ukmpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukmpi.setBounds(186, 93, 144, 25);
		ukmpi.setText("Security Code");
		ukmpi.setColumns(10);
		ukp.add(ukmpi);

		ukmci = new JTextField();
		ukmci.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukmci.setBounds(186, 124, 144, 25);
		ukmci.setText("CVV");
		ukmci.setColumns(10);
		ukp.add(ukmci);

		final JCheckBox ukac = new JCheckBox("Test Agent");
		ukac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ukab = ukac.isSelected();
			}
		});
		ukac.setBounds(186, 170, 97, 23);
		ukp.add(ukac);

		JPopupMenu popupMenu_3 = new JPopupMenu();
		addPopup(ukac, popupMenu_3);

		JMenuBar menuBar_2 = new JMenuBar();
		popupMenu_3.add(menuBar_2);

		final JCheckBoxMenuItem checkBoxMenuItem_5 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_5.setSelected(true);
		popupMenu_3.add(checkBoxMenuItem_5);

		final JCheckBoxMenuItem checkBoxMenuItem_6 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_6.setSelected(true);
		popupMenu_3.add(checkBoxMenuItem_6);

		final JCheckBoxMenuItem checkBoxMenuItem_7 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_7.setSelected(true);
		popupMenu_3.add(checkBoxMenuItem_7);

		ukaui = new JTextField();
		ukaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukaui.setBounds(186, 200, 144, 25);
		ukaui.setText("Account #");
		ukaui.setColumns(10);
		ukp.add(ukaui);

		ukapi = new JTextField();
		ukapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukapi.setBounds(186, 231, 144, 25);
		ukapi.setText("Security Code");
		ukapi.setColumns(10);
		ukp.add(ukapi);

		final JCheckBox ukdc = new JCheckBox("Test Distributor");
		ukdc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ukdb = ukdc.isSelected();
			}
		});
		ukdc.setBounds(10, 309, 123, 23);
		ukp.add(ukdc);

		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(ukdc, popupMenu_1);

		JMenuBar menuBar_3 = new JMenuBar();
		popupMenu_1.add(menuBar_3);

		final JCheckBoxMenuItem checkBoxMenuItem_8 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_8.setSelected(true);
		popupMenu_1.add(checkBoxMenuItem_8);

		final JCheckBoxMenuItem checkBoxMenuItem_9 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_9.setSelected(true);
		popupMenu_1.add(checkBoxMenuItem_9);

		final JCheckBoxMenuItem checkBoxMenuItem_10 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_10.setSelected(true);
		popupMenu_1.add(checkBoxMenuItem_10);

		final JCheckBoxMenuItem checkBoxMenuItem_11 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_11.setSelected(true);
		popupMenu_1.add(checkBoxMenuItem_11);

		ukdui = new JTextField();
		ukdui.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukdui.setBounds(10, 339, 144, 25);
		ukdui.setText("Account #");
		ukdui.setColumns(10);
		ukp.add(ukdui);

		ukdpi = new JTextField();
		ukdpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukdpi.setBounds(10, 370, 144, 25);
		ukdpi.setText("Security Code");
		ukdpi.setColumns(10);
		ukp.add(ukdpi);

		ukdci = new JTextField();
		ukdci.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukdci.setBounds(10, 401, 144, 25);
		ukdci.setText("Security Answer");
		ukdci.setColumns(10);
		ukp.add(ukdci);

		final JCheckBox uksc = new JCheckBox("Test Sales Agent");
		uksc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				uksb = uksc.isSelected();
			}
		});
		uksc.setBounds(186, 309, 123, 23);
		ukp.add(uksc);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(uksc, popupMenu);

		JMenuBar menuBar = new JMenuBar();
		popupMenu.add(menuBar);

		final JCheckBoxMenuItem cb1 = new JCheckBoxMenuItem("Update info");
		cb1.setSelected(true);
		popupMenu.add(cb1);

		final JCheckBoxMenuItem cb2 = new JCheckBoxMenuItem("Creation");
		cb2.setSelected(true);
		popupMenu.add(cb2);

		final JCheckBoxMenuItem cb3 = new JCheckBoxMenuItem("Payment");
		cb3.setSelected(true);
		popupMenu.add(cb3);

		final JCheckBoxMenuItem cb4 = new JCheckBoxMenuItem("Links");
		cb4.setSelected(true);
		popupMenu.add(cb4);

		uksui = new JTextField();
		uksui.setFont(new Font("Calibri", Font.PLAIN, 12));
		uksui.setBounds(186, 339, 144, 25);
		uksui.setText("Account #");
		uksui.setColumns(10);
		ukp.add(uksui);

		ukspi = new JTextField();
		ukspi.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukspi.setBounds(186, 370, 144, 25);
		ukspi.setText("Security Code");
		ukspi.setColumns(10);
		ukp.add(ukspi);

		final JCheckBox ukdmac = new JCheckBox("Test DMA");
		ukdmac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ukdmab = ukdmac.isSelected();
			}
		});
		ukdmac.setEnabled(false);
		ukdmac.setBounds(363, 32, 123, 23);
		ukp.add(ukdmac);

		JPopupMenu popupMenu_6 = new JPopupMenu();
		addPopup(ukdmac, popupMenu_6);

		JMenuBar menuBar_6 = new JMenuBar();
		popupMenu_6.add(menuBar_6);

		final JCheckBoxMenuItem checkBoxMenuItem_13 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_13.setSelected(true);
		popupMenu_6.add(checkBoxMenuItem_13);

		final JCheckBoxMenuItem checkBoxMenuItem_17 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_17.setSelected(true);
		popupMenu_6.add(checkBoxMenuItem_17);

		final JCheckBoxMenuItem checkBoxMenuItem_20 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_20.setSelected(true);
		popupMenu_6.add(checkBoxMenuItem_20);

		final JCheckBoxMenuItem checkBoxMenuItem_21 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_21.setSelected(true);
		popupMenu_6.add(checkBoxMenuItem_21);

		ukdmaui = new JTextField();
		ukdmaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukdmaui.setEnabled(false);
		ukdmaui.setText("Account #");
		ukdmaui.setColumns(10);
		ukdmaui.setBounds(363, 62, 144, 25);
		ukp.add(ukdmaui);

		ukdmapi = new JTextField();
		ukdmapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukdmapi.setEnabled(false);
		ukdmapi.setText("Security Code");
		ukdmapi.setColumns(10);
		ukdmapi.setBounds(363, 93, 144, 25);
		ukp.add(ukdmapi);

		ukdmaci = new JTextField();
		ukdmaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukdmaci.setEnabled(false);
		ukdmaci.setText("CVV");
		ukdmaci.setColumns(10);
		ukdmaci.setBounds(363, 124, 144, 25);
		ukp.add(ukdmaci);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label_1.setBounds(463, 11, 70, 14);
		ukp.add(label_1);
		
		ukaci = new JTextField();
		ukaci.setText("Security Answer");
		ukaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		ukaci.setColumns(10);
		ukaci.setBounds(186, 262, 144, 25);
		ukp.add(ukaci);

		/* define Canada */ 
		final JPanel cap = new JPanel();
		frmBossTester.getContentPane().add(cap, "name_25701714936152");
		cap.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Canada");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 11, 136, 14);
		cap.add(lblNewLabel_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 25, 513, 2);
		cap.add(separator_4);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				cap.setVisible(false);
				if(cacb||camb||carb||caab||cadb||casb||cadmab){
					cabtn.setForeground(new Color(0, 128, 0));
					cas=true;
				}else{
					cabtn.setForeground(Color.RED);
					cas=false;
				}
			}
		});
		btnNewButton_1.setBounds(434, 438, 89, 23);
		cap.add(btnNewButton_1);

		final JCheckBox cacc = new JCheckBox("Test Customer Desktop");
		cacc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cacb = cacc.isSelected();
			}
		});
		cacc.setBounds(10, 32, 174, 23);
		cap.add(cacc);

		JPopupMenu popupMenu_7 = new JPopupMenu();
		addPopup(cacc, popupMenu_7);

		JMenuBar menuBar_7 = new JMenuBar();
		popupMenu_7.add(menuBar_7);

		final JCheckBoxMenuItem checkBoxMenuItem_22 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_22.setSelected(true);
		popupMenu_7.add(checkBoxMenuItem_22);

		final JCheckBoxMenuItem checkBoxMenuItem_24 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_24.setSelected(true);
		popupMenu_7.add(checkBoxMenuItem_24);

		final JCheckBoxMenuItem checkBoxMenuItem_25 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_25.setSelected(true);
		popupMenu_7.add(checkBoxMenuItem_25);
		
		final JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Creation");
		chckbxmntmNewCheckItem.setSelected(true);
		popupMenu_7.add(chckbxmntmNewCheckItem);

		final JCheckBox camc = new JCheckBox("Test Customer Mobile");
		camc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				camb = camc.isSelected();
			}
		});
		camc.setBounds(186, 32, 144, 23);
		cap.add(camc);

		JPopupMenu popupMenu_8 = new JPopupMenu();
		addPopup(camc, popupMenu_8);

		JMenuBar menuBar_8 = new JMenuBar();
		popupMenu_8.add(menuBar_8);

		final JCheckBoxMenuItem checkBoxMenuItem_26 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_26.setSelected(true);
		popupMenu_8.add(checkBoxMenuItem_26);

		final JCheckBoxMenuItem checkBoxMenuItem_28 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_28.setSelected(true);
		popupMenu_8.add(checkBoxMenuItem_28);

		final JCheckBoxMenuItem checkBoxMenuItem_29 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_29.setSelected(true);
		popupMenu_8.add(checkBoxMenuItem_29);
		
		final JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("Creation");
		chckbxmntmNewCheckItem_1.setSelected(true);
		popupMenu_8.add(chckbxmntmNewCheckItem_1);

		final JCheckBox cadmac = new JCheckBox("Test DMA");
		cadmac.setEnabled(false);
		cadmac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cadmab = cadmac.isSelected();
			}
		});
		cadmac.setBounds(363, 32, 123, 23);
		cap.add(cadmac);

		JPopupMenu popupMenu_9 = new JPopupMenu();
		addPopup(cadmac, popupMenu_9);

		JMenuBar menuBar_9 = new JMenuBar();
		popupMenu_9.add(menuBar_9);

		final JCheckBoxMenuItem checkBoxMenuItem_30 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_30.setSelected(true);
		popupMenu_9.add(checkBoxMenuItem_30);

		final JCheckBoxMenuItem checkBoxMenuItem_31 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_31.setSelected(true);
		popupMenu_9.add(checkBoxMenuItem_31);

		final JCheckBoxMenuItem checkBoxMenuItem_32 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_32.setSelected(true);
		popupMenu_9.add(checkBoxMenuItem_32);

		final JCheckBoxMenuItem checkBoxMenuItem_33 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_33.setSelected(true);
		popupMenu_9.add(checkBoxMenuItem_33);

		final JCheckBox carc = new JCheckBox("Test Retailer");
		carc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carb = carc.isSelected();
			}
		});
		carc.setBounds(10, 187, 144, 23);
		cap.add(carc);

		JPopupMenu popupMenu_10 = new JPopupMenu();
		addPopup(carc, popupMenu_10);

		JMenuBar menuBar_10 = new JMenuBar();
		popupMenu_10.add(menuBar_10);

		final JCheckBoxMenuItem checkBoxMenuItem_34 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_34.setSelected(true);
		popupMenu_10.add(checkBoxMenuItem_34);

		final JCheckBoxMenuItem checkBoxMenuItem_35 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_35.setSelected(true);
		popupMenu_10.add(checkBoxMenuItem_35);

		final JCheckBoxMenuItem checkBoxMenuItem_36 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_36.setSelected(true);
		popupMenu_10.add(checkBoxMenuItem_36);

		final JCheckBoxMenuItem checkBoxMenuItem_37 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_37.setSelected(true);
		popupMenu_10.add(checkBoxMenuItem_37);

		final JCheckBox caac = new JCheckBox("Test Agent");
		caac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				caab = caac.isSelected();
			}
		});
		caac.setBounds(186, 187, 97, 23);
		cap.add(caac);

		JPopupMenu popupMenu_11 = new JPopupMenu();
		addPopup(caac, popupMenu_11);

		JMenuBar menuBar_11 = new JMenuBar();
		popupMenu_11.add(menuBar_11);

		final JCheckBoxMenuItem checkBoxMenuItem_39 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_39.setSelected(true);
		popupMenu_11.add(checkBoxMenuItem_39);

		final JCheckBoxMenuItem checkBoxMenuItem_40 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_40.setSelected(true);
		popupMenu_11.add(checkBoxMenuItem_40);

		final JCheckBoxMenuItem checkBoxMenuItem_41 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_41.setSelected(true);
		popupMenu_11.add(checkBoxMenuItem_41);

		final JCheckBox cadc = new JCheckBox("Test Distributor");
		cadc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cadb = cadc.isSelected();
			}
		});
		cadc.setBounds(10, 313, 123, 23);
		cap.add(cadc);

		JPopupMenu popupMenu_12 = new JPopupMenu();
		addPopup(cadc, popupMenu_12);

		JMenuBar menuBar_12 = new JMenuBar();
		popupMenu_12.add(menuBar_12);

		final JCheckBoxMenuItem checkBoxMenuItem_42 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_42.setSelected(true);
		popupMenu_12.add(checkBoxMenuItem_42);

		final JCheckBoxMenuItem checkBoxMenuItem_43 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_43.setSelected(true);
		popupMenu_12.add(checkBoxMenuItem_43);

		final JCheckBoxMenuItem checkBoxMenuItem_44 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_44.setSelected(true);
		popupMenu_12.add(checkBoxMenuItem_44);

		final JCheckBoxMenuItem checkBoxMenuItem_45 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_45.setSelected(true);
		popupMenu_12.add(checkBoxMenuItem_45);

		final JCheckBox casc = new JCheckBox("Test Sales Agent");
		casc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				casb = casc.isSelected();
			}
		});
		casc.setBounds(186, 313, 123, 23);
		cap.add(casc);

		JPopupMenu popupMenu_13 = new JPopupMenu();
		addPopup(casc, popupMenu_13);

		JMenuBar menuBar_13 = new JMenuBar();
		popupMenu_13.add(menuBar_13);

		final JCheckBoxMenuItem checkBoxMenuItem_46 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_46.setSelected(true);
		popupMenu_13.add(checkBoxMenuItem_46);

		final JCheckBoxMenuItem checkBoxMenuItem_47 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_47.setSelected(true);
		popupMenu_13.add(checkBoxMenuItem_47);

		final JCheckBoxMenuItem checkBoxMenuItem_48 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_48.setSelected(true);
		popupMenu_13.add(checkBoxMenuItem_48);

		final JCheckBoxMenuItem checkBoxMenuItem_49 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_49.setSelected(true);
		popupMenu_13.add(checkBoxMenuItem_49);

		cacui = new JTextField();
		cacui.setFont(new Font("Calibri", Font.PLAIN, 12));
		cacui.setText("Account #");
		cacui.setColumns(10);
		cacui.setBounds(10, 62, 144, 25);
		cap.add(cacui);

		cacpi = new JTextField();
		cacpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		cacpi.setText("Security Code");
		cacpi.setColumns(10);
		cacpi.setBounds(10, 93, 144, 25);
		cap.add(cacpi);

		cacci = new JTextField();
		cacci.setFont(new Font("Calibri", Font.PLAIN, 12));
		cacci.setText("CVV");
		cacci.setColumns(10);
		cacci.setBounds(10, 124, 144, 25);
		cap.add(cacci);

		camui = new JTextField();
		camui.setFont(new Font("Calibri", Font.PLAIN, 12));
		camui.setText("Account #");
		camui.setColumns(10);
		camui.setBounds(186, 62, 144, 25);
		cap.add(camui);

		campi = new JTextField();
		campi.setFont(new Font("Calibri", Font.PLAIN, 12));
		campi.setText("Security Code");
		campi.setColumns(10);
		campi.setBounds(186, 93, 144, 25);
		cap.add(campi);

		camci = new JTextField();
		camci.setFont(new Font("Calibri", Font.PLAIN, 12));
		camci.setText("CVV");
		camci.setColumns(10);
		camci.setBounds(186, 124, 144, 25);
		cap.add(camci);

		cadmaui = new JTextField();
		cadmaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		cadmaui.setEnabled(false);
		cadmaui.setText("Account #");
		cadmaui.setColumns(10);
		cadmaui.setBounds(363, 62, 144, 25);
		cap.add(cadmaui);

		cadmapi = new JTextField();
		cadmapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		cadmapi.setEnabled(false);
		cadmapi.setText("Security Code");
		cadmapi.setColumns(10);
		cadmapi.setBounds(363, 93, 144, 25);
		cap.add(cadmapi);

		cadmaci = new JTextField();
		cadmaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		cadmaci.setEnabled(false);
		cadmaci.setText("CVV");
		cadmaci.setColumns(10);
		cadmaci.setBounds(363, 124, 144, 25);
		cap.add(cadmaci);

		carui = new JTextField();
		carui.setFont(new Font("Calibri", Font.PLAIN, 12));
		carui.setText("Account #");
		carui.setColumns(10);
		carui.setBounds(10, 217, 144, 25);
		cap.add(carui);

		carpi = new JTextField();
		carpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		carpi.setText("Security Code");
		carpi.setColumns(10);
		carpi.setBounds(10, 248, 144, 25);
		cap.add(carpi);

		caaui = new JTextField();
		caaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		caaui.setText("Account #");
		caaui.setColumns(10);
		caaui.setBounds(186, 217, 144, 25);
		cap.add(caaui);

		caapi = new JTextField();
		caapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		caapi.setText("Security Code");
		caapi.setColumns(10);
		caapi.setBounds(186, 248, 144, 25);
		cap.add(caapi);

		cadui = new JTextField();
		cadui.setFont(new Font("Calibri", Font.PLAIN, 12));
		cadui.setText("Account #");
		cadui.setColumns(10);
		cadui.setBounds(10, 343, 144, 25);
		cap.add(cadui);

		cadpi = new JTextField();
		cadpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		cadpi.setText("Security Code");
		cadpi.setColumns(10);
		cadpi.setBounds(10, 374, 144, 25);
		cap.add(cadpi);

		casui = new JTextField();
		casui.setFont(new Font("Calibri", Font.PLAIN, 12));
		casui.setText("Account #");
		casui.setColumns(10);
		casui.setBounds(186, 343, 144, 25);
		cap.add(casui);

		caspi = new JTextField();
		caspi.setFont(new Font("Calibri", Font.PLAIN, 12));
		caspi.setText("Security Code");
		caspi.setColumns(10);
		caspi.setBounds(186, 374, 144, 25);
		cap.add(caspi);

		cacsi = new JTextField();
		cacsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		cacsi.setText("Security Answer");
		cacsi.setColumns(10);
		cacsi.setBounds(10, 155, 144, 25);
		cap.add(cacsi);

		camsi = new JTextField();
		camsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		camsi.setText("Security Answer");
		camsi.setColumns(10);
		camsi.setBounds(186, 155, 144, 25);
		cap.add(camsi);

		carsi = new JTextField();
		carsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		carsi.setText("Security Answer");
		carsi.setColumns(10);
		carsi.setBounds(10, 279, 144, 25);
		cap.add(carsi);
		
		cadmasi = new JTextField();
		cadmasi.setFont(new Font("Calibri", Font.PLAIN, 12));
		cadmasi.setEnabled(false);
		cadmasi.setText("Security Answer");
		cadmasi.setColumns(10);
		cadmasi.setBounds(363, 155, 144, 25);
		cap.add(cadmasi);
		
		cadsi = new JTextField();
		cadsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		cadsi.setText("Security Answer");
		cadsi.setColumns(10);
		cadsi.setBounds(10, 405, 144, 25);
		cap.add(cadsi);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label_2.setBounds(463, 11, 70, 14);
		cap.add(label_2);
		
		caaci = new JTextField();
		caaci.setText("Security Answer");
		caaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		caaci.setColumns(10);
		caaci.setBounds(186, 279, 144, 25);
		cap.add(caaci);
		
		/* define Hong Kong */
		final JPanel hkp = new JPanel();
		frmBossTester.getContentPane().add(hkp, "name_25652396154633");
		hkp.setLayout(null);

		JLabel lblBossTester_1 = new JLabel("Hong Kong");
		lblBossTester_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblBossTester_1.setBounds(10, 11, 162, 14);
		hkp.add(lblBossTester_1);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 25, 513, 2);
		hkp.add(separator_6);

		JButton btnBack_2 = new JButton("Back");
		btnBack_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				hkp.setVisible(false);
				if(hkcb||hkmb||hkrb||hkab||hkdb||hksb||hkdmab){
					hkbtn.setForeground(new Color(0, 128, 0));
					hks=true;
				}else{
					hkbtn.setForeground(Color.RED);
					hks=false;
				}
			}
		});
		btnBack_2.setBounds(434, 438, 89, 23);
		hkp.add(btnBack_2);

		final JCheckBox hkcc = new JCheckBox("Test Customer Desktop");
		hkcc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hkcb = hkcc.isSelected();
			}
		});
		hkcc.setBounds(10, 32, 174, 23);
		hkp.add(hkcc);

		JPopupMenu popupMenu_14 = new JPopupMenu();
		addPopup(hkcc, popupMenu_14);

		JMenuBar menuBar_14 = new JMenuBar();
		popupMenu_14.add(menuBar_14);

		final JCheckBoxMenuItem checkBoxMenuItem_50 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_50.setSelected(true);
		popupMenu_14.add(checkBoxMenuItem_50);

		final JCheckBoxMenuItem checkBoxMenuItem_52 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_52.setSelected(true);
		popupMenu_14.add(checkBoxMenuItem_52);

		final JCheckBoxMenuItem checkBoxMenuItem_53 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_53.setSelected(true);
		popupMenu_14.add(checkBoxMenuItem_53);
		
		final JCheckBoxMenuItem chckbxmntmNewCheckItem_3 = new JCheckBoxMenuItem("Creation");
		chckbxmntmNewCheckItem_3.setSelected(true);
		popupMenu_14.add(chckbxmntmNewCheckItem_3);

		final JCheckBox hkmc = new JCheckBox("Test Customer Mobile");
		hkmc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hkmb = hkmc.isSelected();
			}
		});
		hkmc.setBounds(186, 32, 144, 23);
		hkp.add(hkmc);

		JPopupMenu popupMenu_15 = new JPopupMenu();
		addPopup(hkmc, popupMenu_15);

		JMenuBar menuBar_15 = new JMenuBar();
		popupMenu_15.add(menuBar_15);

		final JCheckBoxMenuItem checkBoxMenuItem_54 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_54.setSelected(true);
		popupMenu_15.add(checkBoxMenuItem_54);

		final JCheckBoxMenuItem checkBoxMenuItem_56 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_56.setSelected(true);
		popupMenu_15.add(checkBoxMenuItem_56);

		final JCheckBoxMenuItem checkBoxMenuItem_57 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_57.setSelected(true);
		popupMenu_15.add(checkBoxMenuItem_57);
		
		final JCheckBoxMenuItem chckbxmntmNewCheckItem_4 = new JCheckBoxMenuItem("Creation");
		chckbxmntmNewCheckItem_4.setSelected(true);
		popupMenu_15.add(chckbxmntmNewCheckItem_4);

		final JCheckBox hkdmac = new JCheckBox("Test DMA");
		hkdmac.setEnabled(false);
		hkdmac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hkdmab = hkdmac.isSelected();
			}
		});
		hkdmac.setBounds(363, 32, 123, 23);
		hkp.add(hkdmac);

		JPopupMenu popupMenu_16 = new JPopupMenu();
		addPopup(hkdmac, popupMenu_16);

		JMenuBar menuBar_16 = new JMenuBar();
		popupMenu_16.add(menuBar_16);

		final JCheckBoxMenuItem checkBoxMenuItem_58 = new JCheckBoxMenuItem("Update info");
		popupMenu_16.add(checkBoxMenuItem_58);

		final JCheckBoxMenuItem checkBoxMenuItem_59 = new JCheckBoxMenuItem("Creation");
		popupMenu_16.add(checkBoxMenuItem_59);

		final JCheckBoxMenuItem checkBoxMenuItem_60 = new JCheckBoxMenuItem("Payment");
		popupMenu_16.add(checkBoxMenuItem_60);

		final JCheckBoxMenuItem checkBoxMenuItem_61 = new JCheckBoxMenuItem("Links");
		popupMenu_16.add(checkBoxMenuItem_61);

		final JCheckBox hkrc = new JCheckBox("Test Retailer");
		hkrc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hkrb = hkrc.isSelected();
			}
		});
		hkrc.setBounds(10, 187, 144, 23);
		hkp.add(hkrc);

		JPopupMenu popupMenu_17 = new JPopupMenu();
		addPopup(hkrc, popupMenu_17);

		JMenuBar menuBar_17 = new JMenuBar();
		popupMenu_17.add(menuBar_17);

		final JCheckBoxMenuItem checkBoxMenuItem_62 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_62.setSelected(true);
		popupMenu_17.add(checkBoxMenuItem_62);

		final JCheckBoxMenuItem checkBoxMenuItem_63 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_63.setSelected(true);
		popupMenu_17.add(checkBoxMenuItem_63);

		final JCheckBoxMenuItem checkBoxMenuItem_64 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_64.setSelected(true);
		popupMenu_17.add(checkBoxMenuItem_64);

		final JCheckBoxMenuItem checkBoxMenuItem_65 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_65.setSelected(true);
		popupMenu_17.add(checkBoxMenuItem_65);

		final JCheckBox hkac = new JCheckBox("Test Agent");
		hkac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hkab = hkac.isSelected();
			}
		});
		hkac.setBounds(186, 187, 97, 23);
		hkp.add(hkac);

		JPopupMenu popupMenu_18 = new JPopupMenu();
		addPopup(hkac, popupMenu_18);

		JMenuBar menuBar_18 = new JMenuBar();
		popupMenu_18.add(menuBar_18);

		final JCheckBoxMenuItem checkBoxMenuItem_67 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_67.setSelected(true);
		popupMenu_18.add(checkBoxMenuItem_67);

		final JCheckBoxMenuItem checkBoxMenuItem_68 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_68.setSelected(true);
		popupMenu_18.add(checkBoxMenuItem_68);

		final JCheckBoxMenuItem checkBoxMenuItem_69 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_69.setSelected(true);
		popupMenu_18.add(checkBoxMenuItem_69);

		final JCheckBox hkdc = new JCheckBox("Test Distributor");
		hkdc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hkdb = hkdc.isSelected();
			}
		});
		hkdc.setBounds(10, 302, 123, 23);
		hkp.add(hkdc);

		JPopupMenu popupMenu_19 = new JPopupMenu();
		addPopup(hkdc, popupMenu_19);

		JMenuBar menuBar_19 = new JMenuBar();
		popupMenu_19.add(menuBar_19);

		final JCheckBoxMenuItem checkBoxMenuItem_70 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_70.setSelected(true);
		popupMenu_19.add(checkBoxMenuItem_70);

		final JCheckBoxMenuItem checkBoxMenuItem_71 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_71.setSelected(true);
		popupMenu_19.add(checkBoxMenuItem_71);

		final JCheckBoxMenuItem checkBoxMenuItem_72 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_72.setSelected(true);
		popupMenu_19.add(checkBoxMenuItem_72);

		final JCheckBoxMenuItem checkBoxMenuItem_73 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_73.setSelected(true);
		popupMenu_19.add(checkBoxMenuItem_73);

		final JCheckBox hksc = new JCheckBox("Test Sales Agent");
		hksc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hksb = hksc.isSelected();
			}
		});
		hksc.setBounds(186, 302, 123, 23);
		hkp.add(hksc);

		JPopupMenu popupMenu_20 = new JPopupMenu();
		addPopup(hksc, popupMenu_20);

		JMenuBar menuBar_20 = new JMenuBar();
		popupMenu_20.add(menuBar_20);

		final JCheckBoxMenuItem checkBoxMenuItem_74 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_74.setSelected(true);
		popupMenu_20.add(checkBoxMenuItem_74);

		final JCheckBoxMenuItem checkBoxMenuItem_75 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_75.setSelected(true);
		popupMenu_20.add(checkBoxMenuItem_75);

		final JCheckBoxMenuItem checkBoxMenuItem_76 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_76.setSelected(true);
		popupMenu_20.add(checkBoxMenuItem_76);

		final JCheckBoxMenuItem checkBoxMenuItem_77 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_77.setSelected(true);
		popupMenu_20.add(checkBoxMenuItem_77);

		hkcui = new JTextField();
		hkcui.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkcui.setText("Account #");
		hkcui.setColumns(10);
		hkcui.setBounds(10, 62, 144, 25);
		hkp.add(hkcui);

		hkcpi = new JTextField();
		hkcpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkcpi.setText("Security Code");
		hkcpi.setColumns(10);
		hkcpi.setBounds(10, 93, 144, 25);
		hkp.add(hkcpi);

		hkcci = new JTextField();
		hkcci.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkcci.setText("CVV");
		hkcci.setColumns(10);
		hkcci.setBounds(10, 124, 144, 25);
		hkp.add(hkcci);

		hkmui = new JTextField();
		hkmui.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkmui.setText("Account #");
		hkmui.setColumns(10);
		hkmui.setBounds(186, 62, 144, 25);
		hkp.add(hkmui);

		hkmpi = new JTextField();
		hkmpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkmpi.setText("Security Code");
		hkmpi.setColumns(10);
		hkmpi.setBounds(186, 93, 144, 25);
		hkp.add(hkmpi);

		hkmci = new JTextField();
		hkmci.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkmci.setText("CVV");
		hkmci.setColumns(10);
		hkmci.setBounds(186, 124, 144, 25);
		hkp.add(hkmci);

		hkdmaui = new JTextField();
		hkdmaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkdmaui.setEnabled(false);
		hkdmaui.setText("Account #");
		hkdmaui.setColumns(10);
		hkdmaui.setBounds(363, 62, 144, 25);
		hkp.add(hkdmaui);

		hkdmapi = new JTextField();
		hkdmapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkdmapi.setEnabled(false);
		hkdmapi.setText("Security Code");
		hkdmapi.setColumns(10);
		hkdmapi.setBounds(363, 93, 144, 25);
		hkp.add(hkdmapi);

		hkdmaci = new JTextField();
		hkdmaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkdmaci.setEnabled(false);
		hkdmaci.setText("CVV");
		hkdmaci.setColumns(10);
		hkdmaci.setBounds(363, 124, 144, 25);
		hkp.add(hkdmaci);

		hkrui = new JTextField();
		hkrui.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkrui.setText("Account #");
		hkrui.setColumns(10);
		hkrui.setBounds(10, 217, 144, 25);
		hkp.add(hkrui);

		hkrpi = new JTextField();
		hkrpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkrpi.setText("Security Code");
		hkrpi.setColumns(10);
		hkrpi.setBounds(10, 248, 144, 25);
		hkp.add(hkrpi);

		hkaui = new JTextField();
		hkaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkaui.setText("Account #");
		hkaui.setColumns(10);
		hkaui.setBounds(186, 217, 144, 25);
		hkp.add(hkaui);

		hkapi = new JTextField();
		hkapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkapi.setText("Security Code");
		hkapi.setColumns(10);
		hkapi.setBounds(186, 248, 144, 25);
		hkp.add(hkapi);

		hkdui = new JTextField();
		hkdui.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkdui.setText("Account #");
		hkdui.setColumns(10);
		hkdui.setBounds(10, 332, 144, 25);
		hkp.add(hkdui);

		hkdpi = new JTextField();
		hkdpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkdpi.setText("Security Code");
		hkdpi.setColumns(10);
		hkdpi.setBounds(10, 363, 144, 25);
		hkp.add(hkdpi);

		hksui = new JTextField();
		hksui.setFont(new Font("Calibri", Font.PLAIN, 12));
		hksui.setText("Account #");
		hksui.setColumns(10);
		hksui.setBounds(186, 332, 144, 25);
		hkp.add(hksui);

		hkspi = new JTextField();
		hkspi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkspi.setText("Security Code");
		hkspi.setColumns(10);
		hkspi.setBounds(186, 363, 144, 25);
		hkp.add(hkspi);
		
		hkdsi = new JTextField();
		hkdsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkdsi.setText("Security Answer");
		hkdsi.setColumns(10);
		hkdsi.setBounds(10, 394, 144, 25);
		hkp.add(hkdsi);
		
		hkdmasi = new JTextField();
		hkdmasi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkdmasi.setEnabled(false);
		hkdmasi.setText("Security Answer");
		hkdmasi.setColumns(10);
		hkdmasi.setBounds(363, 155, 144, 25);
		hkp.add(hkdmasi);
		
		hkmsi = new JTextField();
		hkmsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkmsi.setText("Security Answer");
		hkmsi.setColumns(10);
		hkmsi.setBounds(186, 155, 144, 25);
		hkp.add(hkmsi);
		
		hkcsi = new JTextField();
		hkcsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkcsi.setText("Security Answer");
		hkcsi.setColumns(10);
		hkcsi.setBounds(10, 155, 144, 25);
		hkp.add(hkcsi);
		
		hkrsi = new JTextField();
		hkrsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		hkrsi.setText("Security Answer");
		hkrsi.setColumns(10);
		hkrsi.setBounds(10, 279, 144, 25);
		hkp.add(hkrsi);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label_3.setBounds(463, 11, 70, 14);
		hkp.add(label_3);

		/* define Singapore Button */
		final JButton sgbtn = new JButton("Singapore");
		sgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				sgp.setVisible(true);
			}
		});
		sgbtn.setForeground(Color.RED);
		sgbtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		sgbtn.setBounds(10, 138, 145, 23);
		mainPanel.add(sgbtn);
		
		/* define Spain Button */ 
		final JButton esbtn = new JButton("Spain");
		esbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				esp.setVisible(true);
			}
		});
		esbtn.setForeground(Color.RED);
		esbtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		esbtn.setBounds(10, 172, 145, 23);
		mainPanel.add(esbtn);
		
		/* define Germany Button */ 
		final JButton debtn = new JButton("Germany");
		debtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				dep.setVisible(true);
			}
		});
		debtn.setForeground(Color.RED);
		debtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		debtn.setBounds(10, 206, 145, 23);
		mainPanel.add(debtn);
		
		/* define Australia Button */ 
		final JButton aubtn = new JButton("Australia");
		aubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				aup.setVisible(true);
			}
		});
		aubtn.setForeground(Color.RED);
		aubtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		aubtn.setBounds(10, 240, 145, 23);
		mainPanel.add(aubtn);
		
		/* define Singapore tab */ 
		sgp = new JPanel();
		frmBossTester.getContentPane().add(sgp, "name_631224385649103");
		sgp.setLayout(null);
		
		JLabel lblSingapore = new JLabel("Singapore");
		lblSingapore.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSingapore.setBounds(10, 11, 162, 14);
		sgp.add(lblSingapore);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 25, 513, 2);
		sgp.add(separator_3);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				sgp.setVisible(false);
				if(sgcb||sgmb||sgrb||sgab||sgdb||sgsb||sgdmab){
					sgbtn.setForeground(new Color(0, 128, 0));
					sgs=true;
				}else{
					sgbtn.setForeground(Color.RED);
					sgs=false;
				}
			}
		});
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBounds(434, 438, 89, 23);
		sgp.add(button);
		
		final JCheckBox sgcc = new JCheckBox("Test Customer Desktop");
		sgcc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sgcb = sgcc.isSelected();
			}
		});
		sgcc.setBounds(10, 32, 174, 23);
		sgp.add(sgcc);
		
		JPopupMenu popupMenu_21 = new JPopupMenu();
		addPopup(sgcc, popupMenu_21);
		
		JMenuBar menuBar_21 = new JMenuBar();
		popupMenu_21.add(menuBar_21);
		
		final JCheckBoxMenuItem checkBoxMenuItem_4 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_4.setSelected(true);
		popupMenu_21.add(checkBoxMenuItem_4);
		
		final JCheckBoxMenuItem checkBoxMenuItem_23 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_23.setSelected(true);
		popupMenu_21.add(checkBoxMenuItem_23);
		
		final JCheckBoxMenuItem checkBoxMenuItem_27 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_27.setSelected(true);
		popupMenu_21.add(checkBoxMenuItem_27);
		
		final JCheckBoxMenuItem checkBoxMenuItem_38 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_38.setSelected(true);
		popupMenu_21.add(checkBoxMenuItem_38);
		
		final JCheckBox sgmc = new JCheckBox("Test Customer Mobile");
		sgmc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sgmb = sgmc.isSelected();
			}
		});
		sgmc.setBounds(186, 32, 144, 23);
		sgp.add(sgmc);
		
		JPopupMenu popupMenu_22 = new JPopupMenu();
		addPopup(sgmc, popupMenu_22);
		
		JMenuBar menuBar_22 = new JMenuBar();
		popupMenu_22.add(menuBar_22);
		
		final JCheckBoxMenuItem checkBoxMenuItem_51 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_51.setSelected(true);
		popupMenu_22.add(checkBoxMenuItem_51);
		
		final JCheckBoxMenuItem checkBoxMenuItem_55 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_55.setSelected(true);
		popupMenu_22.add(checkBoxMenuItem_55);
		
		final JCheckBoxMenuItem checkBoxMenuItem_66 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_66.setSelected(true);
		popupMenu_22.add(checkBoxMenuItem_66);
		
		final JCheckBoxMenuItem checkBoxMenuItem_78 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_78.setSelected(true);
		popupMenu_22.add(checkBoxMenuItem_78);
		
		final JCheckBox sgdmac = new JCheckBox("Test DMA");
		sgdmac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sgdmab = sgdmac.isSelected();
			}
		});
		sgdmac.setEnabled(false);
		sgdmac.setBounds(363, 32, 123, 23);
		sgp.add(sgdmac);
		
		JPopupMenu popupMenu_23 = new JPopupMenu();
		addPopup(sgdmac, popupMenu_23);
		
		JMenuBar menuBar_23 = new JMenuBar();
		popupMenu_23.add(menuBar_23);
		
		final JCheckBoxMenuItem checkBoxMenuItem_79 = new JCheckBoxMenuItem("Update info");
		popupMenu_23.add(checkBoxMenuItem_79);
		
		final JCheckBoxMenuItem checkBoxMenuItem_80 = new JCheckBoxMenuItem("Creation");
		popupMenu_23.add(checkBoxMenuItem_80);
		
		final JCheckBoxMenuItem checkBoxMenuItem_81 = new JCheckBoxMenuItem("Payment");
		popupMenu_23.add(checkBoxMenuItem_81);
		
		final JCheckBoxMenuItem checkBoxMenuItem_82 = new JCheckBoxMenuItem("Links");
		popupMenu_23.add(checkBoxMenuItem_82);
		
		final JCheckBox sgrc = new JCheckBox("Test Retailer");
		sgrc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sgrb = sgrc.isSelected();
			}
		});
		sgrc.setBounds(10, 187, 144, 23);
		sgp.add(sgrc);
		
		JPopupMenu popupMenu_24 = new JPopupMenu();
		addPopup(sgrc, popupMenu_24);
		
		JMenuBar menuBar_24 = new JMenuBar();
		popupMenu_24.add(menuBar_24);
		
		final JCheckBoxMenuItem checkBoxMenuItem_83 = new JCheckBoxMenuItem("Update info");
		popupMenu_24.add(checkBoxMenuItem_83);
		
		final JCheckBoxMenuItem checkBoxMenuItem_84 = new JCheckBoxMenuItem("Creation");
		popupMenu_24.add(checkBoxMenuItem_84);
		
		final JCheckBoxMenuItem checkBoxMenuItem_85 = new JCheckBoxMenuItem("Payment");
		popupMenu_24.add(checkBoxMenuItem_85);
		
		final JCheckBoxMenuItem checkBoxMenuItem_86 = new JCheckBoxMenuItem("Links");
		popupMenu_24.add(checkBoxMenuItem_86);
		
		final JCheckBox sgac = new JCheckBox("Test Agent");
		sgac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sgab = sgac.isSelected();
			}
		});
		sgac.setBounds(186, 187, 97, 23);
		sgp.add(sgac);
		
		JPopupMenu popupMenu_27 = new JPopupMenu();
		addPopup(sgac, popupMenu_27);
		
		JMenuBar menuBar_27 = new JMenuBar();
		popupMenu_27.add(menuBar_27);
		
		final JCheckBoxMenuItem checkBoxMenuItem_95 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_95.setSelected(true);
		popupMenu_27.add(checkBoxMenuItem_95);
		
		final JCheckBoxMenuItem checkBoxMenuItem_96 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_96.setSelected(true);
		popupMenu_27.add(checkBoxMenuItem_96);
		
		final JCheckBoxMenuItem checkBoxMenuItem_97 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_97.setSelected(true);
		popupMenu_27.add(checkBoxMenuItem_97);
		
		final JCheckBox sgdc = new JCheckBox("Test Distributor");
		sgdc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sgdb = sgdc.isSelected();
			}
		});
		sgdc.setBounds(10, 302, 123, 23);
		sgp.add(sgdc);
		
		JPopupMenu popupMenu_25 = new JPopupMenu();
		addPopup(sgdc, popupMenu_25);
		
		JMenuBar menuBar_25 = new JMenuBar();
		popupMenu_25.add(menuBar_25);
		
		final JCheckBoxMenuItem checkBoxMenuItem_87 = new JCheckBoxMenuItem("Update info");
		popupMenu_25.add(checkBoxMenuItem_87);
		
		final JCheckBoxMenuItem checkBoxMenuItem_88 = new JCheckBoxMenuItem("Creation");
		popupMenu_25.add(checkBoxMenuItem_88);
		
		final JCheckBoxMenuItem checkBoxMenuItem_89 = new JCheckBoxMenuItem("Payment");
		popupMenu_25.add(checkBoxMenuItem_89);
		
		final JCheckBoxMenuItem checkBoxMenuItem_90 = new JCheckBoxMenuItem("Links");
		popupMenu_25.add(checkBoxMenuItem_90);
		
		final JCheckBox sgsc = new JCheckBox("Test Sales Agent");
		sgsc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sgsb = sgsc.isSelected();
			}
		});
		sgsc.setBounds(186, 302, 123, 23);
		sgp.add(sgsc);
		
		JPopupMenu popupMenu_26 = new JPopupMenu();
		addPopup(sgsc, popupMenu_26);
		
		JMenuBar menuBar_26 = new JMenuBar();
		popupMenu_26.add(menuBar_26);
		
		final JCheckBoxMenuItem checkBoxMenuItem_91 = new JCheckBoxMenuItem("Update info");
		popupMenu_26.add(checkBoxMenuItem_91);
		
		final JCheckBoxMenuItem checkBoxMenuItem_92 = new JCheckBoxMenuItem("Creation");
		popupMenu_26.add(checkBoxMenuItem_92);
		
		final JCheckBoxMenuItem checkBoxMenuItem_93 = new JCheckBoxMenuItem("Payment");
		popupMenu_26.add(checkBoxMenuItem_93);
		
		final JCheckBoxMenuItem checkBoxMenuItem_94 = new JCheckBoxMenuItem("Links");
		popupMenu_26.add(checkBoxMenuItem_94);
		
		sgcui = new JTextField();
		sgcui.setText("Account #");
		sgcui.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgcui.setColumns(10);
		sgcui.setBounds(10, 62, 144, 25);
		sgp.add(sgcui);
		
		sgcpi = new JTextField();
		sgcpi.setText("Security Code");
		sgcpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgcpi.setColumns(10);
		sgcpi.setBounds(10, 93, 144, 25);
		sgp.add(sgcpi);
		
		sgcci = new JTextField();
		sgcci.setText("CVV");
		sgcci.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgcci.setColumns(10);
		sgcci.setBounds(10, 124, 144, 25);
		sgp.add(sgcci);
		
		sgmui = new JTextField();
		sgmui.setText("Account #");
		sgmui.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgmui.setColumns(10);
		sgmui.setBounds(186, 62, 144, 25);
		sgp.add(sgmui);
		
		sgmpi = new JTextField();
		sgmpi.setText("Security Code");
		sgmpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgmpi.setColumns(10);
		sgmpi.setBounds(186, 93, 144, 25);
		sgp.add(sgmpi);
		
		sgmci = new JTextField();
		sgmci.setText("CVV");
		sgmci.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgmci.setColumns(10);
		sgmci.setBounds(186, 124, 144, 25);
		sgp.add(sgmci);
		
		sgdmaui = new JTextField();
		sgdmaui.setText("Account #");
		sgdmaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgdmaui.setEnabled(false);
		sgdmaui.setColumns(10);
		sgdmaui.setBounds(363, 62, 144, 25);
		sgp.add(sgdmaui);
		
		sgdmapi = new JTextField();
		sgdmapi.setText("Security Code");
		sgdmapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgdmapi.setEnabled(false);
		sgdmapi.setColumns(10);
		sgdmapi.setBounds(363, 93, 144, 25);
		sgp.add(sgdmapi);
		
		sgdmaci = new JTextField();
		sgdmaci.setText("CVV");
		sgdmaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgdmaci.setEnabled(false);
		sgdmaci.setColumns(10);
		sgdmaci.setBounds(363, 124, 144, 25);
		sgp.add(sgdmaci);
		
		sgrui = new JTextField();
		sgrui.setText("Account #");
		sgrui.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgrui.setColumns(10);
		sgrui.setBounds(10, 217, 144, 25);
		sgp.add(sgrui);
		
		sgrpi = new JTextField();
		sgrpi.setText("Security Code");
		sgrpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgrpi.setColumns(10);
		sgrpi.setBounds(10, 248, 144, 25);
		sgp.add(sgrpi);
		
		sgaui = new JTextField();
		sgaui.setText("Account #");
		sgaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgaui.setColumns(10);
		sgaui.setBounds(186, 217, 144, 25);
		sgp.add(sgaui);
		
		sgapi = new JTextField();
		sgapi.setText("Security Code");
		sgapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgapi.setColumns(10);
		sgapi.setBounds(186, 248, 144, 25);
		sgp.add(sgapi);
		
		sgdui = new JTextField();
		sgdui.setText("Account #");
		sgdui.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgdui.setColumns(10);
		sgdui.setBounds(10, 332, 144, 25);
		sgp.add(sgdui);
		
		sgdpi = new JTextField();
		sgdpi.setText("Security Code");
		sgdpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgdpi.setColumns(10);
		sgdpi.setBounds(10, 363, 144, 25);
		sgp.add(sgdpi);
		
		sgsui = new JTextField();
		sgsui.setText("Account #");
		sgsui.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgsui.setColumns(10);
		sgsui.setBounds(186, 332, 144, 25);
		sgp.add(sgsui);
		
		sgspi = new JTextField();
		sgspi.setText("Security Code");
		sgspi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgspi.setColumns(10);
		sgspi.setBounds(186, 363, 144, 25);
		sgp.add(sgspi);
		
		sgdsi = new JTextField();
		sgdsi.setText("Security Answer");
		sgdsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgdsi.setColumns(10);
		sgdsi.setBounds(10, 394, 144, 25);
		sgp.add(sgdsi);
		
		sgdmasi = new JTextField();
		sgdmasi.setText("Security Answer");
		sgdmasi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgdmasi.setEnabled(false);
		sgdmasi.setColumns(10);
		sgdmasi.setBounds(363, 155, 144, 25);
		sgp.add(sgdmasi);
		
		sgmsi = new JTextField();
		sgmsi.setText("Security Answer");
		sgmsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgmsi.setColumns(10);
		sgmsi.setBounds(186, 155, 144, 25);
		sgp.add(sgmsi);
		
		sgcsi = new JTextField();
		sgcsi.setText("Security Answer");
		sgcsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgcsi.setColumns(10);
		sgcsi.setBounds(10, 155, 144, 25);
		sgp.add(sgcsi);
		
		sgrsi = new JTextField();
		sgrsi.setText("Security Answer");
		sgrsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		sgrsi.setColumns(10);
		sgrsi.setBounds(10, 279, 144, 25);
		sgp.add(sgrsi);
		
		/* define Spain tab */ 
		esp = new JPanel();
		frmBossTester.getContentPane().add(esp, "name_76380826625451");
		esp.setLayout(null);
		
		JLabel lblSpain = new JLabel("Spain");
		lblSpain.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSpain.setBounds(10, 11, 162, 14);
		esp.add(lblSpain);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 25, 513, 2);
		esp.add(separator_5);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(true);
				esp.setVisible(false);
				if(escb||esmb||esrb||esab||esdb||essb||esdmab){
					esbtn.setForeground(new Color(0, 128, 0));
					ess=true;
				}else{
					esbtn.setForeground(Color.RED);
					ess=false;
				}
			}
		});
		button_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		button_1.setBounds(434, 438, 89, 23);
		esp.add(button_1);
		
		final JCheckBox escc = new JCheckBox("Test Customer Desktop");
		escc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				escb = escc.isSelected();
			}
		});
		escc.setBounds(10, 32, 174, 23);
		esp.add(escc);
		
		JPopupMenu popupMenu_28 = new JPopupMenu();
		addPopup(escc, popupMenu_28);
		
		JMenuBar menuBar_28 = new JMenuBar();
		popupMenu_28.add(menuBar_28);
		
		final JCheckBoxMenuItem checkBoxMenuItem_98 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_98.setSelected(true);
		popupMenu_28.add(checkBoxMenuItem_98);
		
		final JCheckBoxMenuItem checkBoxMenuItem_99 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_99.setSelected(true);
		popupMenu_28.add(checkBoxMenuItem_99);
		
		final JCheckBoxMenuItem checkBoxMenuItem_100 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_100.setSelected(true);
		popupMenu_28.add(checkBoxMenuItem_100);
		
		final JCheckBoxMenuItem checkBoxMenuItem_101 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_101.setSelected(true);
		popupMenu_28.add(checkBoxMenuItem_101);
		
		final JCheckBox esmc = new JCheckBox("Test Customer Mobile");
		esmc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				esmb = esmc.isSelected();
			}
		});
		esmc.setBounds(186, 32, 144, 23);
		esp.add(esmc);
		
		JPopupMenu popupMenu_29 = new JPopupMenu();
		addPopup(esmc, popupMenu_29);
		
		JMenuBar menuBar_29 = new JMenuBar();
		popupMenu_29.add(menuBar_29);
		
		final JCheckBoxMenuItem checkBoxMenuItem_102 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_102.setSelected(true);
		popupMenu_29.add(checkBoxMenuItem_102);
		
		final JCheckBoxMenuItem checkBoxMenuItem_103 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_103.setSelected(true);
		popupMenu_29.add(checkBoxMenuItem_103);
		
		final JCheckBoxMenuItem checkBoxMenuItem_104 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_104.setSelected(true);
		popupMenu_29.add(checkBoxMenuItem_104);
		
		final JCheckBoxMenuItem checkBoxMenuItem_105 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_105.setSelected(true);
		popupMenu_29.add(checkBoxMenuItem_105);
		
		final JCheckBox esdmac = new JCheckBox("Test DMA");
		esdmac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				esdmab = esdmac.isSelected();
			}
		});
		esdmac.setEnabled(false);
		esdmac.setBounds(363, 32, 123, 23);
		esp.add(esdmac);
		
		JPopupMenu popupMenu_30 = new JPopupMenu();
		addPopup(esdmac, popupMenu_30);
		
		JMenuBar menuBar_30 = new JMenuBar();
		popupMenu_30.add(menuBar_30);
		
		final JCheckBoxMenuItem checkBoxMenuItem_106 = new JCheckBoxMenuItem("Update info");
		popupMenu_30.add(checkBoxMenuItem_106);
		
		final JCheckBoxMenuItem checkBoxMenuItem_107 = new JCheckBoxMenuItem("Creation");
		popupMenu_30.add(checkBoxMenuItem_107);
		
		final JCheckBoxMenuItem checkBoxMenuItem_108 = new JCheckBoxMenuItem("Payment");
		popupMenu_30.add(checkBoxMenuItem_108);
		
		final JCheckBoxMenuItem checkBoxMenuItem_109 = new JCheckBoxMenuItem("Links");
		popupMenu_30.add(checkBoxMenuItem_109);
		
		final JCheckBox esrc = new JCheckBox("Test Retailer");
		esrc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				esrb = esrc.isSelected();
			}
		});
		esrc.setBounds(10, 187, 144, 23);
		esp.add(esrc);
		
		JPopupMenu popupMenu_31 = new JPopupMenu();
		addPopup(esrc, popupMenu_31);
		
		JMenuBar menuBar_31 = new JMenuBar();
		popupMenu_31.add(menuBar_31);
		
		final JCheckBoxMenuItem checkBoxMenuItem_110 = new JCheckBoxMenuItem("Update info");
		popupMenu_31.add(checkBoxMenuItem_110);
		
		final JCheckBoxMenuItem checkBoxMenuItem_111 = new JCheckBoxMenuItem("Creation");
		popupMenu_31.add(checkBoxMenuItem_111);
		
		final JCheckBoxMenuItem checkBoxMenuItem_112 = new JCheckBoxMenuItem("Payment");
		popupMenu_31.add(checkBoxMenuItem_112);
		
		final JCheckBoxMenuItem checkBoxMenuItem_113 = new JCheckBoxMenuItem("Links");
		popupMenu_31.add(checkBoxMenuItem_113);
		
		final JCheckBox esac = new JCheckBox("Test Agent");
		esac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				esab = esac.isSelected();
			}
		});
		esac.setBounds(186, 187, 97, 23);
		esp.add(esac);
		
		JPopupMenu popupMenu_32 = new JPopupMenu();
		addPopup(esac, popupMenu_32);
		
		JMenuBar menuBar_32 = new JMenuBar();
		popupMenu_32.add(menuBar_32);
		
		final JCheckBoxMenuItem checkBoxMenuItem_115 = new JCheckBoxMenuItem("Creation");
		popupMenu_32.add(checkBoxMenuItem_115);
		
		final JCheckBoxMenuItem checkBoxMenuItem_116 = new JCheckBoxMenuItem("Payment");
		popupMenu_32.add(checkBoxMenuItem_116);
		
		final JCheckBoxMenuItem checkBoxMenuItem_117 = new JCheckBoxMenuItem("Links");
		popupMenu_32.add(checkBoxMenuItem_117);
		
		final JCheckBox esdc = new JCheckBox("Test Distributor");
		esdc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				esdb = esdc.isSelected();
			}
		});
		esdc.setBounds(10, 302, 123, 23);
		esp.add(esdc);
		
		JPopupMenu popupMenu_33 = new JPopupMenu();
		addPopup(esdc, popupMenu_33);
		
		JMenuBar menuBar_33 = new JMenuBar();
		popupMenu_33.add(menuBar_33);
		
		final JCheckBoxMenuItem checkBoxMenuItem_118 = new JCheckBoxMenuItem("Update info");
		popupMenu_33.add(checkBoxMenuItem_118);
		
		final JCheckBoxMenuItem checkBoxMenuItem_119 = new JCheckBoxMenuItem("Creation");
		popupMenu_33.add(checkBoxMenuItem_119);
		
		final JCheckBoxMenuItem checkBoxMenuItem_120 = new JCheckBoxMenuItem("Payment");
		popupMenu_33.add(checkBoxMenuItem_120);
		
		final JCheckBoxMenuItem checkBoxMenuItem_121 = new JCheckBoxMenuItem("Links");
		popupMenu_33.add(checkBoxMenuItem_121);
		
		final JCheckBox essc = new JCheckBox("Test Sales Agent");
		essc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				essb = essc.isSelected();
			}
		});
		essc.setBounds(186, 302, 123, 23);
		esp.add(essc);
		
		JPopupMenu popupMenu_34 = new JPopupMenu();
		addPopup(essc, popupMenu_34);
		
		JMenuBar menuBar_34 = new JMenuBar();
		popupMenu_34.add(menuBar_34);
		
		final JCheckBoxMenuItem checkBoxMenuItem_122 = new JCheckBoxMenuItem("Update info");
		popupMenu_34.add(checkBoxMenuItem_122);
		
		final JCheckBoxMenuItem checkBoxMenuItem_123 = new JCheckBoxMenuItem("Creation");
		popupMenu_34.add(checkBoxMenuItem_123);
		
		final JCheckBoxMenuItem checkBoxMenuItem_124 = new JCheckBoxMenuItem("Payment");
		popupMenu_34.add(checkBoxMenuItem_124);
		
		final JCheckBoxMenuItem checkBoxMenuItem_125 = new JCheckBoxMenuItem("Links");
		popupMenu_34.add(checkBoxMenuItem_125);
		
		escui = new JTextField();
		escui.setText("Account #");
		escui.setFont(new Font("Calibri", Font.PLAIN, 12));
		escui.setColumns(10);
		escui.setBounds(10, 62, 144, 25);
		esp.add(escui);
		
		escpi = new JTextField();
		escpi.setText("Security Code");
		escpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		escpi.setColumns(10);
		escpi.setBounds(10, 93, 144, 25);
		esp.add(escpi);
		
		escci = new JTextField();
		escci.setText("CVV");
		escci.setFont(new Font("Calibri", Font.PLAIN, 12));
		escci.setColumns(10);
		escci.setBounds(10, 124, 144, 25);
		esp.add(escci);
		
		esmui = new JTextField();
		esmui.setText("Account #");
		esmui.setFont(new Font("Calibri", Font.PLAIN, 12));
		esmui.setColumns(10);
		esmui.setBounds(186, 62, 144, 25);
		esp.add(esmui);
		
		esmpi = new JTextField();
		esmpi.setText("Security Code");
		esmpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esmpi.setColumns(10);
		esmpi.setBounds(186, 93, 144, 25);
		esp.add(esmpi);
		
		esmci = new JTextField();
		esmci.setText("CVV");
		esmci.setFont(new Font("Calibri", Font.PLAIN, 12));
		esmci.setColumns(10);
		esmci.setBounds(186, 124, 144, 25);
		esp.add(esmci);
		
		esdmaui = new JTextField();
		esdmaui.setText("Account #");
		esdmaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		esdmaui.setEnabled(false);
		esdmaui.setColumns(10);
		esdmaui.setBounds(363, 62, 144, 25);
		esp.add(esdmaui);
		
		esdmapi = new JTextField();
		esdmapi.setText("Security Code");
		esdmapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esdmapi.setEnabled(false);
		esdmapi.setColumns(10);
		esdmapi.setBounds(363, 93, 144, 25);
		esp.add(esdmapi);
		
		esdmaci = new JTextField();
		esdmaci.setText("CVV");
		esdmaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		esdmaci.setEnabled(false);
		esdmaci.setColumns(10);
		esdmaci.setBounds(363, 124, 144, 25);
		esp.add(esdmaci);
		
		esrui = new JTextField();
		esrui.setText("Account #");
		esrui.setFont(new Font("Calibri", Font.PLAIN, 12));
		esrui.setColumns(10);
		esrui.setBounds(10, 217, 144, 25);
		esp.add(esrui);
		
		esrpi = new JTextField();
		esrpi.setText("Security Code");
		esrpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esrpi.setColumns(10);
		esrpi.setBounds(10, 248, 144, 25);
		esp.add(esrpi);
		
		esaui = new JTextField();
		esaui.setText("Account #");
		esaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		esaui.setColumns(10);
		esaui.setBounds(186, 217, 144, 25);
		esp.add(esaui);
		
		esapi = new JTextField();
		esapi.setText("Security Code");
		esapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esapi.setColumns(10);
		esapi.setBounds(186, 248, 144, 25);
		esp.add(esapi);
		
		esdui = new JTextField();
		esdui.setText("Account #");
		esdui.setFont(new Font("Calibri", Font.PLAIN, 12));
		esdui.setColumns(10);
		esdui.setBounds(10, 332, 144, 25);
		esp.add(esdui);
		
		esdpi = new JTextField();
		esdpi.setText("Security Code");
		esdpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esdpi.setColumns(10);
		esdpi.setBounds(10, 363, 144, 25);
		esp.add(esdpi);
		
		essui = new JTextField();
		essui.setText("Account #");
		essui.setFont(new Font("Calibri", Font.PLAIN, 12));
		essui.setColumns(10);
		essui.setBounds(186, 332, 144, 25);
		esp.add(essui);
		
		esspi = new JTextField();
		esspi.setText("Security Code");
		esspi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esspi.setColumns(10);
		esspi.setBounds(186, 363, 144, 25);
		esp.add(esspi);
		
		esdsi = new JTextField();
		esdsi.setText("Security Answer");
		esdsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esdsi.setColumns(10);
		esdsi.setBounds(10, 394, 144, 25);
		esp.add(esdsi);
		
		esdmasi = new JTextField();
		esdmasi.setText("Security Answer");
		esdmasi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esdmasi.setEnabled(false);
		esdmasi.setColumns(10);
		esdmasi.setBounds(363, 155, 144, 25);
		esp.add(esdmasi);
		
		esmsi = new JTextField();
		esmsi.setText("Security Answer");
		esmsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esmsi.setColumns(10);
		esmsi.setBounds(186, 155, 144, 25);
		esp.add(esmsi);
		
		escsi = new JTextField();
		escsi.setText("Security Answer");
		escsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		escsi.setColumns(10);
		escsi.setBounds(10, 155, 144, 25);
		esp.add(escsi);
		
		esrsi = new JTextField();
		esrsi.setText("Security Answer");
		esrsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		esrsi.setColumns(10);
		esrsi.setBounds(10, 279, 144, 25);
		esp.add(esrsi);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label_6.setBounds(463, 11, 70, 14);
		esp.add(label_6);
		
		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label_5.setBounds(463, 11, 70, 14);
		sgp.add(label_5);
		
		/* define Germany tab */ 
		dep = new JPanel();
		frmBossTester.getContentPane().add(dep, "name_81386019003560");
		dep.setLayout(null);
		
		JLabel Germany = new JLabel("Germany");
		Germany.setFont(new Font("Calibri", Font.PLAIN, 15));
		Germany.setBounds(10, 11, 162, 14);
		dep.add(Germany);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 25, 513, 2);
		dep.add(separator_7);
		
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				dep.setVisible(false);
				if(decb||demb||derb||deab||dedb||desb||dedmab){
					debtn.setForeground(new Color(0, 128, 0));
					des=true;
				}else{
					debtn.setForeground(Color.RED);
					des=false;
				}
			}
		});
		button_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		button_2.setBounds(434, 438, 89, 23);
		dep.add(button_2);
		
		final JCheckBox decc = new JCheckBox("Test Customer Desktop");
		decc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				decb = decc.isSelected();
			}
		});
		decc.setBounds(10, 32, 174, 23);
		dep.add(decc);
		
		JPopupMenu popupMenu_35 = new JPopupMenu();
		addPopup(decc, popupMenu_35);
		
		JMenuBar menuBar_35 = new JMenuBar();
		popupMenu_35.add(menuBar_35);
		
		final JCheckBoxMenuItem checkBoxMenuItem_114 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_114.setSelected(true);
		popupMenu_35.add(checkBoxMenuItem_114);
		
		final JCheckBoxMenuItem checkBoxMenuItem_126 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_126.setSelected(true);
		popupMenu_35.add(checkBoxMenuItem_126);
		
		final JCheckBoxMenuItem checkBoxMenuItem_127 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_127.setSelected(true);
		popupMenu_35.add(checkBoxMenuItem_127);
		
		final JCheckBoxMenuItem checkBoxMenuItem_128 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_128.setSelected(true);
		popupMenu_35.add(checkBoxMenuItem_128);
		
		final JCheckBox demc = new JCheckBox("Test Customer Mobile");
		demc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				demb = demc.isSelected();
			}
		});
		demc.setBounds(186, 32, 144, 23);
		dep.add(demc);
		
		JPopupMenu popupMenu_36 = new JPopupMenu();
		addPopup(demc, popupMenu_36);
		
		JMenuBar menuBar_36 = new JMenuBar();
		popupMenu_36.add(menuBar_36);
		
		final JCheckBoxMenuItem checkBoxMenuItem_129 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_129.setSelected(true);
		popupMenu_36.add(checkBoxMenuItem_129);
		
		final JCheckBoxMenuItem checkBoxMenuItem_130 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_130.setSelected(true);
		popupMenu_36.add(checkBoxMenuItem_130);
		
		final JCheckBoxMenuItem checkBoxMenuItem_131 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_131.setSelected(true);
		popupMenu_36.add(checkBoxMenuItem_131);
		
		final JCheckBoxMenuItem checkBoxMenuItem_132 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_132.setSelected(true);
		popupMenu_36.add(checkBoxMenuItem_132);
		
		final JCheckBox dedmac = new JCheckBox("Test DMA");
		dedmac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				dedmab = dedmac.isSelected();
			}
		});
		dedmac.setEnabled(false);
		dedmac.setBounds(363, 32, 123, 23);
		dep.add(dedmac);
		
		JPopupMenu popupMenu_37 = new JPopupMenu();
		addPopup(dedmac, popupMenu_37);
		
		JMenuBar menuBar_37 = new JMenuBar();
		popupMenu_37.add(menuBar_37);
		
		final JCheckBoxMenuItem checkBoxMenuItem_133 = new JCheckBoxMenuItem("Update info");
		popupMenu_37.add(checkBoxMenuItem_133);
		
		final JCheckBoxMenuItem checkBoxMenuItem_134 = new JCheckBoxMenuItem("Creation");
		popupMenu_37.add(checkBoxMenuItem_134);
		
		final JCheckBoxMenuItem checkBoxMenuItem_135 = new JCheckBoxMenuItem("Payment");
		popupMenu_37.add(checkBoxMenuItem_135);
		
		final JCheckBoxMenuItem checkBoxMenuItem_136 = new JCheckBoxMenuItem("Links");
		popupMenu_37.add(checkBoxMenuItem_136);
		
		final JCheckBox derc = new JCheckBox("Test Retailer");
		derc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				derb = derc.isSelected();
			}
		});
		derc.setBounds(10, 187, 144, 23);
		dep.add(derc);
		
		JPopupMenu popupMenu_38 = new JPopupMenu();
		addPopup(derc, popupMenu_38);
		
		JMenuBar menuBar_38 = new JMenuBar();
		popupMenu_38.add(menuBar_38);
		
		final JCheckBoxMenuItem checkBoxMenuItem_137 = new JCheckBoxMenuItem("Update info");
		popupMenu_38.add(checkBoxMenuItem_137);
		
		final JCheckBoxMenuItem checkBoxMenuItem_138 = new JCheckBoxMenuItem("Creation");
		popupMenu_38.add(checkBoxMenuItem_138);
		
		final JCheckBoxMenuItem checkBoxMenuItem_139 = new JCheckBoxMenuItem("Payment");
		popupMenu_38.add(checkBoxMenuItem_139);
		
		final JCheckBoxMenuItem checkBoxMenuItem_140 = new JCheckBoxMenuItem("Links");
		popupMenu_38.add(checkBoxMenuItem_140);
		
		final JCheckBox deac = new JCheckBox("Test Agent");
		deac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				deab = deac.isSelected();
			}
		});
		deac.setBounds(186, 187, 97, 23);
		dep.add(deac);
		
		JPopupMenu popupMenu_39 = new JPopupMenu();
		addPopup(deac, popupMenu_39);
		
		JMenuBar menuBar_39 = new JMenuBar();
		popupMenu_39.add(menuBar_39);
		
		final JCheckBoxMenuItem checkBoxMenuItem_141 = new JCheckBoxMenuItem("Creation");
		popupMenu_39.add(checkBoxMenuItem_141);
		
		final JCheckBoxMenuItem checkBoxMenuItem_142 = new JCheckBoxMenuItem("Payment");
		popupMenu_39.add(checkBoxMenuItem_142);
		
		final JCheckBoxMenuItem checkBoxMenuItem_143 = new JCheckBoxMenuItem("Links");
		popupMenu_39.add(checkBoxMenuItem_143);
		
		final JCheckBox dedc = new JCheckBox("Test Distributor");
		dedc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				dedb = dedc.isSelected();
			}
		});
		dedc.setBounds(10, 302, 123, 23);
		dep.add(dedc);
		
		JPopupMenu popupMenu_40 = new JPopupMenu();
		addPopup(dedc, popupMenu_40);
		
		JMenuBar menuBar_40 = new JMenuBar();
		popupMenu_40.add(menuBar_40);
		
		final JCheckBoxMenuItem checkBoxMenuItem_144 = new JCheckBoxMenuItem("Update info");
		popupMenu_40.add(checkBoxMenuItem_144);
		
		final JCheckBoxMenuItem checkBoxMenuItem_145 = new JCheckBoxMenuItem("Creation");
		popupMenu_40.add(checkBoxMenuItem_145);
		
		final JCheckBoxMenuItem checkBoxMenuItem_146 = new JCheckBoxMenuItem("Payment");
		popupMenu_40.add(checkBoxMenuItem_146);
		
		final JCheckBoxMenuItem checkBoxMenuItem_147 = new JCheckBoxMenuItem("Links");
		popupMenu_40.add(checkBoxMenuItem_147);
		
		final JCheckBox desc = new JCheckBox("Test Sales Agent");
		desc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				desb = desc.isSelected();
			}
		});
		desc.setBounds(186, 302, 123, 23);
		dep.add(desc);
		
		JPopupMenu popupMenu_41 = new JPopupMenu();
		addPopup(desc, popupMenu_41);
		
		JMenuBar menuBar_41 = new JMenuBar();
		popupMenu_41.add(menuBar_41);
		
		final JCheckBoxMenuItem checkBoxMenuItem_148 = new JCheckBoxMenuItem("Update info");
		popupMenu_41.add(checkBoxMenuItem_148);
		
		final JCheckBoxMenuItem checkBoxMenuItem_149 = new JCheckBoxMenuItem("Creation");
		popupMenu_41.add(checkBoxMenuItem_149);
		
		final JCheckBoxMenuItem checkBoxMenuItem_150 = new JCheckBoxMenuItem("Payment");
		popupMenu_41.add(checkBoxMenuItem_150);
		
		final JCheckBoxMenuItem checkBoxMenuItem_151 = new JCheckBoxMenuItem("Links");
		popupMenu_41.add(checkBoxMenuItem_151);
		
		decui = new JTextField();
		decui.setText("Account #");
		decui.setFont(new Font("Calibri", Font.PLAIN, 12));
		decui.setColumns(10);
		decui.setBounds(10, 62, 144, 25);
		dep.add(decui);
		
		decpi = new JTextField();
		decpi.setText("Security Code");
		decpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		decpi.setColumns(10);
		decpi.setBounds(10, 93, 144, 25);
		dep.add(decpi);
		
		decci = new JTextField();
		decci.setText("CVV");
		decci.setFont(new Font("Calibri", Font.PLAIN, 12));
		decci.setColumns(10);
		decci.setBounds(10, 124, 144, 25);
		dep.add(decci);
		
		demui = new JTextField();
		demui.setText("Account #");
		demui.setFont(new Font("Calibri", Font.PLAIN, 12));
		demui.setColumns(10);
		demui.setBounds(186, 62, 144, 25);
		dep.add(demui);
		
		dempi = new JTextField();
		dempi.setText("Security Code");
		dempi.setFont(new Font("Calibri", Font.PLAIN, 12));
		dempi.setColumns(10);
		dempi.setBounds(186, 93, 144, 25);
		dep.add(dempi);
		
		demci = new JTextField();
		demci.setText("CVV");
		demci.setFont(new Font("Calibri", Font.PLAIN, 12));
		demci.setColumns(10);
		demci.setBounds(186, 124, 144, 25);
		dep.add(demci);
		
		dedmaui = new JTextField();
		dedmaui.setText("Account #");
		dedmaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		dedmaui.setEnabled(false);
		dedmaui.setColumns(10);
		dedmaui.setBounds(363, 62, 144, 25);
		dep.add(dedmaui);
		
		dedmapi = new JTextField();
		dedmapi.setText("Security Code");
		dedmapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		dedmapi.setEnabled(false);
		dedmapi.setColumns(10);
		dedmapi.setBounds(363, 93, 144, 25);
		dep.add(dedmapi);
		
		dedmaci = new JTextField();
		dedmaci.setText("CVV");
		dedmaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		dedmaci.setEnabled(false);
		dedmaci.setColumns(10);
		dedmaci.setBounds(363, 124, 144, 25);
		dep.add(dedmaci);
		
		derui = new JTextField();
		derui.setText("Account #");
		derui.setFont(new Font("Calibri", Font.PLAIN, 12));
		derui.setColumns(10);
		derui.setBounds(10, 217, 144, 25);
		dep.add(derui);
		
		derpi = new JTextField();
		derpi.setText("Security Code");
		derpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		derpi.setColumns(10);
		derpi.setBounds(10, 248, 144, 25);
		dep.add(derpi);
		
		deaui = new JTextField();
		deaui.setText("Account #");
		deaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		deaui.setColumns(10);
		deaui.setBounds(186, 217, 144, 25);
		dep.add(deaui);
		
		deapi = new JTextField();
		deapi.setText("Security Code");
		deapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		deapi.setColumns(10);
		deapi.setBounds(186, 248, 144, 25);
		dep.add(deapi);
		
		dedui = new JTextField();
		dedui.setText("Account #");
		dedui.setFont(new Font("Calibri", Font.PLAIN, 12));
		dedui.setColumns(10);
		dedui.setBounds(10, 332, 144, 25);
		dep.add(dedui);
		
		dedpi = new JTextField();
		dedpi.setText("Security Code");
		dedpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		dedpi.setColumns(10);
		dedpi.setBounds(10, 363, 144, 25);
		dep.add(dedpi);
		
		desui = new JTextField();
		desui.setText("Account #");
		desui.setFont(new Font("Calibri", Font.PLAIN, 12));
		desui.setColumns(10);
		desui.setBounds(186, 332, 144, 25);
		dep.add(desui);
		
		despi = new JTextField();
		despi.setText("Security Code");
		despi.setFont(new Font("Calibri", Font.PLAIN, 12));
		despi.setColumns(10);
		despi.setBounds(186, 363, 144, 25);
		dep.add(despi);
		
		dedsi = new JTextField();
		dedsi.setText("Security Answer");
		dedsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		dedsi.setColumns(10);
		dedsi.setBounds(10, 394, 144, 25);
		dep.add(dedsi);
		
		dedmasi = new JTextField();
		dedmasi.setText("Security Answer");
		dedmasi.setFont(new Font("Calibri", Font.PLAIN, 12));
		dedmasi.setEnabled(false);
		dedmasi.setColumns(10);
		dedmasi.setBounds(363, 155, 144, 25);
		dep.add(dedmasi);
		
		demsi = new JTextField();
		demsi.setText("Security Answer");
		demsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		demsi.setColumns(10);
		demsi.setBounds(186, 155, 144, 25);
		dep.add(demsi);
		
		decsi = new JTextField();
		decsi.setText("Security Answer");
		decsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		decsi.setColumns(10);
		decsi.setBounds(10, 155, 144, 25);
		dep.add(decsi);
		
		dersi = new JTextField();
		dersi.setText("Security Answer");
		dersi.setFont(new Font("Calibri", Font.PLAIN, 12));
		dersi.setColumns(10);
		dersi.setBounds(10, 279, 144, 25);
		dep.add(dersi);
		
		JLabel label_7 = new JLabel("");
		label_7.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label_7.setBounds(463, 11, 70, 14);
		dep.add(label_7);
		
		deasi = new JTextField();
		deasi.setText("Security Answer");
		deasi.setFont(new Font("Calibri", Font.PLAIN, 12));
		deasi.setColumns(10);
		deasi.setBounds(186, 279, 144, 25);
		dep.add(deasi);
		
		/* define Australia tab */ 
		aup = new JPanel();
		frmBossTester.getContentPane().add(aup, "name_84444762793737");
		aup.setLayout(null);
		
		JLabel lblAustralia = new JLabel("Australia");
		lblAustralia.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAustralia.setBounds(10, 11, 162, 14);
		aup.add(lblAustralia);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(10, 25, 513, 2);
		aup.add(separator_8);
		
		JButton button_3 = new JButton("Back");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				aup.setVisible(false);
				if(aucb||aumb||aurb||auab||audb||ausb||audmab){
					aubtn.setForeground(new Color(0, 128, 0));
					aus=true;
				}else{
					aubtn.setForeground(Color.RED);
					aus=false;
				}
			}
		});
		button_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		button_3.setBounds(434, 438, 89, 23);
		aup.add(button_3);
		
		final JCheckBox aucc = new JCheckBox("Test Customer Desktop");
		aucc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				aucb = aucc.isSelected();
			}
		});
		aucc.setBounds(10, 32, 174, 23);
		aup.add(aucc);
		
		JPopupMenu popupMenu_42 = new JPopupMenu();
		addPopup(aucc, popupMenu_42);
		
		JMenuBar menuBar_42 = new JMenuBar();
		popupMenu_42.add(menuBar_42);
		
		final JCheckBoxMenuItem checkBoxMenuItem_152 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_152.setSelected(true);
		popupMenu_42.add(checkBoxMenuItem_152);
		
		final JCheckBoxMenuItem checkBoxMenuItem_153 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_153.setSelected(true);
		popupMenu_42.add(checkBoxMenuItem_153);
		
		final JCheckBoxMenuItem checkBoxMenuItem_154 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_154.setSelected(true);
		popupMenu_42.add(checkBoxMenuItem_154);
		
		final JCheckBoxMenuItem checkBoxMenuItem_155 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_155.setSelected(true);
		popupMenu_42.add(checkBoxMenuItem_155);
		
		final JCheckBox aumc = new JCheckBox("Test Customer Mobile");
		aumc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				aumb = aumc.isSelected();
			}
		});
		aumc.setBounds(186, 32, 144, 23);
		aup.add(aumc);
		
		JPopupMenu popupMenu_43 = new JPopupMenu();
		addPopup(aumc, popupMenu_43);
		
		JMenuBar menuBar_43 = new JMenuBar();
		popupMenu_43.add(menuBar_43);
		
		final JCheckBoxMenuItem checkBoxMenuItem_156 = new JCheckBoxMenuItem("Update info");
		checkBoxMenuItem_156.setSelected(true);
		popupMenu_43.add(checkBoxMenuItem_156);
		
		final JCheckBoxMenuItem checkBoxMenuItem_157 = new JCheckBoxMenuItem("Payment");
		checkBoxMenuItem_157.setSelected(true);
		popupMenu_43.add(checkBoxMenuItem_157);
		
		final JCheckBoxMenuItem checkBoxMenuItem_158 = new JCheckBoxMenuItem("Links");
		checkBoxMenuItem_158.setSelected(true);
		popupMenu_43.add(checkBoxMenuItem_158);
		
		final JCheckBoxMenuItem checkBoxMenuItem_159 = new JCheckBoxMenuItem("Creation");
		checkBoxMenuItem_159.setSelected(true);
		popupMenu_43.add(checkBoxMenuItem_159);
		
		final JCheckBox audmac = new JCheckBox("Test DMA");
		audmac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				audmab = audmac.isSelected();
			}
		});
		audmac.setEnabled(false);
		audmac.setBounds(363, 32, 123, 23);
		aup.add(audmac);
		
		JPopupMenu popupMenu_44 = new JPopupMenu();
		addPopup(audmac, popupMenu_44);
		
		JMenuBar menuBar_44 = new JMenuBar();
		popupMenu_44.add(menuBar_44);
		
		final JCheckBoxMenuItem checkBoxMenuItem_160 = new JCheckBoxMenuItem("Update info");
		popupMenu_44.add(checkBoxMenuItem_160);
		
		final JCheckBoxMenuItem checkBoxMenuItem_161 = new JCheckBoxMenuItem("Creation");
		popupMenu_44.add(checkBoxMenuItem_161);
		
		final JCheckBoxMenuItem checkBoxMenuItem_162 = new JCheckBoxMenuItem("Payment");
		popupMenu_44.add(checkBoxMenuItem_162);
		
		final JCheckBoxMenuItem checkBoxMenuItem_163 = new JCheckBoxMenuItem("Links");
		popupMenu_44.add(checkBoxMenuItem_163);
		
		final JCheckBox aurc = new JCheckBox("Test Retailer");
		aurc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				aurb = aurc.isSelected();
			}
		});
		aurc.setBounds(10, 187, 144, 23);
		aup.add(aurc);
		
		JPopupMenu popupMenu_45 = new JPopupMenu();
		addPopup(aurc, popupMenu_45);
		
		JMenuBar menuBar_45 = new JMenuBar();
		popupMenu_45.add(menuBar_45);
		
		final JCheckBoxMenuItem checkBoxMenuItem_164 = new JCheckBoxMenuItem("Update info");
		popupMenu_45.add(checkBoxMenuItem_164);
		
		final JCheckBoxMenuItem checkBoxMenuItem_165 = new JCheckBoxMenuItem("Creation");
		popupMenu_45.add(checkBoxMenuItem_165);
		
		final JCheckBoxMenuItem checkBoxMenuItem_166 = new JCheckBoxMenuItem("Payment");
		popupMenu_45.add(checkBoxMenuItem_166);
		
		final JCheckBoxMenuItem checkBoxMenuItem_167 = new JCheckBoxMenuItem("Links");
		popupMenu_45.add(checkBoxMenuItem_167);
		
		final JCheckBox auac = new JCheckBox("Test Agent");
		auac.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				auab = auac.isSelected();
			}
		});
		auac.setBounds(186, 187, 97, 23);
		aup.add(auac);
		
		JPopupMenu popupMenu_46 = new JPopupMenu();
		addPopup(auac, popupMenu_46);
		
		JMenuBar menuBar_46 = new JMenuBar();
		popupMenu_46.add(menuBar_46);
		
		final JCheckBoxMenuItem checkBoxMenuItem_168 = new JCheckBoxMenuItem("Creation");
		popupMenu_46.add(checkBoxMenuItem_168);
		
		final JCheckBoxMenuItem checkBoxMenuItem_169 = new JCheckBoxMenuItem("Payment");
		popupMenu_46.add(checkBoxMenuItem_169);
		
		final JCheckBoxMenuItem checkBoxMenuItem_170 = new JCheckBoxMenuItem("Links");
		popupMenu_46.add(checkBoxMenuItem_170);
		
		final JCheckBox audc = new JCheckBox("Test Distributor");
		audc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				audb = audc.isSelected();
			}
		});
		audc.setBounds(10, 302, 123, 23);
		aup.add(audc);
		
		JPopupMenu popupMenu_47 = new JPopupMenu();
		addPopup(audc, popupMenu_47);
		
		JMenuBar menuBar_47 = new JMenuBar();
		popupMenu_47.add(menuBar_47);
		
		final JCheckBoxMenuItem checkBoxMenuItem_171 = new JCheckBoxMenuItem("Update info");
		popupMenu_47.add(checkBoxMenuItem_171);
		
		final JCheckBoxMenuItem checkBoxMenuItem_172 = new JCheckBoxMenuItem("Creation");
		popupMenu_47.add(checkBoxMenuItem_172);
		
		final JCheckBoxMenuItem checkBoxMenuItem_173 = new JCheckBoxMenuItem("Payment");
		popupMenu_47.add(checkBoxMenuItem_173);
		
		final JCheckBoxMenuItem checkBoxMenuItem_174 = new JCheckBoxMenuItem("Links");
		popupMenu_47.add(checkBoxMenuItem_174);
		
		final JCheckBox ausc = new JCheckBox("Test Sales Agent");
		ausc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ausb = ausc.isSelected();
			}
		});
		ausc.setBounds(186, 302, 123, 23);
		aup.add(ausc);
		
		JPopupMenu popupMenu_48 = new JPopupMenu();
		addPopup(ausc, popupMenu_48);
		
		JMenuBar menuBar_48 = new JMenuBar();
		popupMenu_48.add(menuBar_48);
		
		final JCheckBoxMenuItem checkBoxMenuItem_175 = new JCheckBoxMenuItem("Update info");
		popupMenu_48.add(checkBoxMenuItem_175);
		
		final JCheckBoxMenuItem checkBoxMenuItem_176 = new JCheckBoxMenuItem("Creation");
		popupMenu_48.add(checkBoxMenuItem_176);
		
		final JCheckBoxMenuItem checkBoxMenuItem_177 = new JCheckBoxMenuItem("Payment");
		popupMenu_48.add(checkBoxMenuItem_177);
		
		final JCheckBoxMenuItem checkBoxMenuItem_178 = new JCheckBoxMenuItem("Links");
		popupMenu_48.add(checkBoxMenuItem_178);
		
		aucui = new JTextField();
		aucui.setText("Account #");
		aucui.setFont(new Font("Calibri", Font.PLAIN, 12));
		aucui.setColumns(10);
		aucui.setBounds(10, 62, 144, 25);
		aup.add(aucui);
		
		aucpi = new JTextField();
		aucpi.setText("Security Code");
		aucpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		aucpi.setColumns(10);
		aucpi.setBounds(10, 93, 144, 25);
		aup.add(aucpi);
		
		aucci = new JTextField();
		aucci.setText("CVV");
		aucci.setFont(new Font("Calibri", Font.PLAIN, 12));
		aucci.setColumns(10);
		aucci.setBounds(10, 124, 144, 25);
		aup.add(aucci);
		
		aumui = new JTextField();
		aumui.setText("Account #");
		aumui.setFont(new Font("Calibri", Font.PLAIN, 12));
		aumui.setColumns(10);
		aumui.setBounds(186, 62, 144, 25);
		aup.add(aumui);
		
		aumpi = new JTextField();
		aumpi.setText("Security Code");
		aumpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		aumpi.setColumns(10);
		aumpi.setBounds(186, 93, 144, 25);
		aup.add(aumpi);
		
		aumci = new JTextField();
		aumci.setText("CVV");
		aumci.setFont(new Font("Calibri", Font.PLAIN, 12));
		aumci.setColumns(10);
		aumci.setBounds(186, 124, 144, 25);
		aup.add(aumci);
		
		audmaui = new JTextField();
		audmaui.setText("Account #");
		audmaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		audmaui.setEnabled(false);
		audmaui.setColumns(10);
		audmaui.setBounds(363, 62, 144, 25);
		aup.add(audmaui);
		
		audmapi = new JTextField();
		audmapi.setText("Security Code");
		audmapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		audmapi.setEnabled(false);
		audmapi.setColumns(10);
		audmapi.setBounds(363, 93, 144, 25);
		aup.add(audmapi);
		
		audmaci = new JTextField();
		audmaci.setText("CVV");
		audmaci.setFont(new Font("Calibri", Font.PLAIN, 12));
		audmaci.setEnabled(false);
		audmaci.setColumns(10);
		audmaci.setBounds(363, 124, 144, 25);
		aup.add(audmaci);
		
		aurui = new JTextField();
		aurui.setText("Account #");
		aurui.setFont(new Font("Calibri", Font.PLAIN, 12));
		aurui.setColumns(10);
		aurui.setBounds(10, 217, 144, 25);
		aup.add(aurui);
		
		aurpi = new JTextField();
		aurpi.setText("Security Code");
		aurpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		aurpi.setColumns(10);
		aurpi.setBounds(10, 248, 144, 25);
		aup.add(aurpi);
		
		auaui = new JTextField();
		auaui.setText("Account #");
		auaui.setFont(new Font("Calibri", Font.PLAIN, 12));
		auaui.setColumns(10);
		auaui.setBounds(186, 217, 144, 25);
		aup.add(auaui);
		
		auapi = new JTextField();
		auapi.setText("Security Code");
		auapi.setFont(new Font("Calibri", Font.PLAIN, 12));
		auapi.setColumns(10);
		auapi.setBounds(186, 248, 144, 25);
		aup.add(auapi);
		
		audui = new JTextField();
		audui.setText("Account #");
		audui.setFont(new Font("Calibri", Font.PLAIN, 12));
		audui.setColumns(10);
		audui.setBounds(10, 332, 144, 25);
		aup.add(audui);
		
		audpi = new JTextField();
		audpi.setText("Security Code");
		audpi.setFont(new Font("Calibri", Font.PLAIN, 12));
		audpi.setColumns(10);
		audpi.setBounds(10, 363, 144, 25);
		aup.add(audpi);
		
		ausui = new JTextField();
		ausui.setText("Account #");
		ausui.setFont(new Font("Calibri", Font.PLAIN, 12));
		ausui.setColumns(10);
		ausui.setBounds(186, 332, 144, 25);
		aup.add(ausui);
		
		auspi = new JTextField();
		auspi.setText("Security Code");
		auspi.setFont(new Font("Calibri", Font.PLAIN, 12));
		auspi.setColumns(10);
		auspi.setBounds(186, 363, 144, 25);
		aup.add(auspi);
		
		audsi = new JTextField();
		audsi.setText("Security Answer");
		audsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		audsi.setColumns(10);
		audsi.setBounds(10, 394, 144, 25);
		aup.add(audsi);
		
		audmasi = new JTextField();
		audmasi.setText("Security Answer");
		audmasi.setFont(new Font("Calibri", Font.PLAIN, 12));
		audmasi.setEnabled(false);
		audmasi.setColumns(10);
		audmasi.setBounds(363, 155, 144, 25);
		aup.add(audmasi);
		
		aumsi = new JTextField();
		aumsi.setText("Security Answer");
		aumsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		aumsi.setColumns(10);
		aumsi.setBounds(186, 155, 144, 25);
		aup.add(aumsi);
		
		aucsi = new JTextField();
		aucsi.setText("Security Answer");
		aucsi.setFont(new Font("Calibri", Font.PLAIN, 12));
		aucsi.setColumns(10);
		aucsi.setBounds(10, 155, 144, 25);
		aup.add(aucsi);
		
		aursi = new JTextField();
		aursi.setText("Security Answer");
		aursi.setFont(new Font("Calibri", Font.PLAIN, 12));
		aursi.setColumns(10);
		aursi.setBounds(10, 279, 144, 25);
		aup.add(aursi);
		
		JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		label_8.setBounds(463, 11, 70, 14);
		aup.add(label_8);
		
		/* start button */ 
		JButton start = new JButton("Start");
		start.setFont(new Font("Calibri", Font.PLAIN, 23));
		start.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!startState)
					t = new Runner();	
				//System.out.println("Runner t: " + t);
				/* define variables for JIRA tab */ 
				t.postJira = jiraqa.isSelected();
				t.Jira = jiraqai.getText();
				t.jiraUsr = jiraUsr.getText();
				t.jiraPw = jiraPw.getText();
				t.bossVersion = qaversion.getText();
				if(rb.isSelected())
					t.bossqa=0;
				if(rb1.isSelected())
					t.bossqa=1;
				if(rb2.isSelected())
					t.bossqa=2;
				if(rb3.isSelected())
					t.bossqa=3;
				if(rb4.isSelected())
					t.bossqa=4;
				if(rb5.isSelected())
					t.bossqa=5;
				if(rb6.isSelected())
					t.bossqa=6;
				
				/* if UK Tab Check Boxes are selected: 
				 * Customer Desktop
				 * Customer Mobile
				 * Retailer
				 * Agent
				 * Distributor
				 * Sales Agent
				 */
				t.testUKCustomer = ukcc.isSelected();
				t.UKCupdate = checkBoxMenuItem_12.isSelected();
				t.UKCpayment = checkBoxMenuItem_14.isSelected();
				t.UKClinks = checkBoxMenuItem_15.isSelected();
				t.UKCcreation = chckbxmntmNewCheckItem1.isSelected();
				t.UKCusr = ukcui.getText();
				t.UKCpw = ukcpi.getText();
				t.UKCccVeri = ukcci.getText();
				
				t.testUKMobile = ukmc.isSelected();
				t.UKMupdate = checkBoxMenuItem_16.isSelected();
				t.UKMpayment = checkBoxMenuItem_18.isSelected();
				t.UKMlinks = checkBoxMenuItem_19.isSelected();
				t.UKMcreation = chckbxmntmNewCheckItem_2.isSelected();
				t.UKMusr = ukmui.getText();
				t.UKMpw = ukmpi.getText();
				t.UKMccVeri = ukmci.getText();
				
				t.testUKRetailer = ukrc.isSelected();
				t.UKRupdate = checkBoxMenuItem.isSelected();
				t.UKRcreation = checkBoxMenuItem_1.isSelected();
				t.UKRpayment = checkBoxMenuItem_2.isSelected();
				t.UKRlinks = checkBoxMenuItem_3.isSelected();
				t.UKRusr = ukrui.getText();
				t.UKRpw = ukrpi.getText();
				
				t.testUKAgent = ukac.isSelected();
				t.UKAcreation = checkBoxMenuItem_5.isSelected();
				t.UKApayment = checkBoxMenuItem_6.isSelected();
				t.UKAlinks = checkBoxMenuItem_7.isSelected();
				t.UKAusr = ukaui.getText();
				t.UKApw = ukapi.getText();
				t.UKAsecurityAns = ukaci.getText();
				
				t.testUKSagent = uksc.isSelected();
				t.UKSupdate = cb1.isSelected();
				t.UKScreation = cb2.isSelected();
				t.UKSpayment = cb3.isSelected();
				t.UKSlinks = cb4.isSelected();
				t.UKSusr = uksui.getText();
				t.UKSpw = ukspi.getText();
				//t.UKSccVeri = uksci.getText();
				
				t.testUKDist = ukdc.isSelected();
				t.UKDupdate = checkBoxMenuItem_8.isSelected();
				t.UKDcreation = checkBoxMenuItem_9.isSelected();
				t.UKDpayment = checkBoxMenuItem_10.isSelected();
				t.UKDlinks = checkBoxMenuItem_11.isSelected();
				t.UKDusr = ukdui.getText();
				t.UKDpw = ukdpi.getText();
				t.UKDsecurityAns = ukdci.getText();
				
				t.testUKDMA = ukdc.isSelected();
				t.UKDMAupdate = checkBoxMenuItem_13.isSelected();
				t.UKDMAcreation = checkBoxMenuItem_17.isSelected();
				t.UKDMApayment = checkBoxMenuItem_20.isSelected();
				t.UKDMAlinks = checkBoxMenuItem_21.isSelected();
				t.UKDMAusr = ukdmaui.getText();
				t.UKDMApw = ukdmapi.getText();
				t.UKDMAccVeri = ukdmaci.getText();
				
				/* if CA Tab Check Boxes are selected: 
				 * Customer Desktop
				 * Customer Mobile
				 * Retailer
				 * Agent
				 * Distributor
				 * Sales Agent
				 */
				t.testCACustomer = cacc.isSelected();
				t.CACupdate = checkBoxMenuItem_22.isSelected();
				t.CACpayment = checkBoxMenuItem_24.isSelected();
				t.CAClinks = checkBoxMenuItem_25.isSelected();
				t.CACcreation = chckbxmntmNewCheckItem.isSelected();
				t.CACusr = cacui.getText();
				t.CACpw = cacpi.getText();
				t.CACccVeri = cacci.getText();
				t.CACsecurityAnswer = cacsi.getText();
				
				t.testCAMobile = camc.isSelected();
				t.CAMupdate = checkBoxMenuItem_26.isSelected();
				t.CAMpayment = checkBoxMenuItem_28.isSelected();
				t.CAMlinks = checkBoxMenuItem_29.isSelected();
				t.CAMcreation = chckbxmntmNewCheckItem_1.isSelected();
				t.CAMusr = camui.getText();
				t.CAMpw = campi.getText();
				t.CAMccVeri = camci.getText();
				t.CAMsecurityAnswer = camsi.getText();
				
				t.testCARetailer = carc.isSelected();
				t.CARupdate = checkBoxMenuItem_34.isSelected();
				t.CARcreation = checkBoxMenuItem_35.isSelected();
				t.CARpayment = checkBoxMenuItem_36.isSelected();
				t.CARlinks = checkBoxMenuItem_37.isSelected();
				t.CARusr = carui.getText();
				t.CARpw = carpi.getText();
				t.CARsecurityAnswer = carsi.getText();
				
				t.testCAAgent = caac.isSelected();
				t.CAAcreation = checkBoxMenuItem_39.isSelected();
				t.CAApayment = checkBoxMenuItem_40.isSelected();
				t.CAAlinks = checkBoxMenuItem_41.isSelected();
				t.CAAusr = caaui.getText();
				t.CAApw = caapi.getText();
				t.CAAsa = caaci.getText();
				
				t.testCADist = cadc.isSelected();
				t.CADupdate = checkBoxMenuItem_42.isSelected();
				t.CADcreation = checkBoxMenuItem_43.isSelected();
				t.CADpayment = checkBoxMenuItem_44.isSelected();
				t.CADlinks = checkBoxMenuItem_45.isSelected();
				t.CADusr = cadui.getText();
				t.CADpw = cadpi.getText();
				//t.CADccVeri = cadci.getText();
				t.CADsecurityAnswer = cadsi.getText();
				
				t.testCASagent = casc.isSelected();
				t.CASupdate = checkBoxMenuItem_46.isSelected();
				t.CAScreation = checkBoxMenuItem_47.isSelected();
				t.CASpayment = checkBoxMenuItem_48.isSelected();
				t.CASlinks = checkBoxMenuItem_49.isSelected();
				t.CASusr = casui.getText();
				t.CASpw = caspi.getText();
				//t.CASccVeri = casci.getText();
				//t.CASsecurityAnswer = cassi.getText();
				
				t.testCADMA = cadmac.isSelected();
				t.CADMAupdate = checkBoxMenuItem_30.isSelected();
				t.CADMAcreation = checkBoxMenuItem_31.isSelected();
				t.CADMApayment = checkBoxMenuItem_32.isSelected();
				t.CADMAlinks = checkBoxMenuItem_33.isSelected();
				t.CADMAusr = cadmaui.getText();
				t.CADMApw = cadmapi.getText();
				t.CADMAccVeri = cadmaci.getText();
				t.CADMAsecurityAnswer = cadmasi.getText();
				
				/* if HK Tab Check Boxes are selected: 
				 * Customer Desktop
				 * Customer Mobile
				 * Retailer
				 * Agent
				 * Distributor
				 * Sales Agent
				 */
				t.testHKCustomer = hkcc.isSelected();
				t.HKCupdate = checkBoxMenuItem_50.isSelected();
				t.HKCpayment = checkBoxMenuItem_52.isSelected();
				t.HKClinks = checkBoxMenuItem_53.isSelected();
				t.HKCcreation = chckbxmntmNewCheckItem_3.isSelected();
				t.HKCusr = hkcui.getText();
				t.HKCpw = hkcpi.getText();
				t.HKCccVeri = hkcci.getText();
				t.HKCsecurityAnswer = hkcsi.getText();
				
				t.testHKMobile = hkmc.isSelected();
				t.HKMupdate = checkBoxMenuItem_54.isSelected();
				t.HKMpayment = checkBoxMenuItem_56.isSelected();
				t.HKMlinks = checkBoxMenuItem_57.isSelected();
				t.HKMcreation = chckbxmntmNewCheckItem_4.isSelected();
				t.HKMusr = hkmui.getText();
				t.HKMpw = hkmpi.getText();
				t.HKMccVeri = hkmci.getText();
				t.HKMsecurityAnswer = hkmsi.getText();
				
				t.testHKRetailer = hkrc.isSelected();
				t.HKRupdate = checkBoxMenuItem_62.isSelected();
				t.HKRcreation = checkBoxMenuItem_63.isSelected();
				t.HKRpayment = checkBoxMenuItem_64.isSelected();
				t.HKRlinks = checkBoxMenuItem_65.isSelected();
				t.HKRusr = hkrui.getText();
				t.HKRpw = hkrpi.getText();
				t.HKRsecurityAnswer = hkrsi.getText();
				
				t.testHKAgent = hkac.isSelected();
				t.HKAcreation = checkBoxMenuItem_67.isSelected();
				t.HKApayment = checkBoxMenuItem_68.isSelected();
				t.HKAlinks = checkBoxMenuItem_69.isSelected();
				t.HKAusr = hkaui.getText();
				t.HKApw = hkapi.getText();
				
				t.testHKDist = hkdc.isSelected();
				t.HKDupdate = checkBoxMenuItem_70.isSelected();
				t.HKDcreation = checkBoxMenuItem_71.isSelected();
				t.HKDpayment = checkBoxMenuItem_72.isSelected();
				t.HKDlinks = checkBoxMenuItem_73.isSelected();
				t.HKDusr = hkdui.getText();
				t.HKDpw = hkdpi.getText();
				//HKDccVeri = hkdci.getText();
				t.HKDsecurityAnswer = hkdsi.getText();
				
				t.testHKSagent = hksc.isSelected();
				t.HKSupdate = checkBoxMenuItem_74.isSelected();
				t.HKScreation = checkBoxMenuItem_75.isSelected();
				t.HKSpayment = checkBoxMenuItem_76.isSelected();
				t.HKSlinks = checkBoxMenuItem_77.isSelected();
				t.HKSusr = hksui.getText();
				t.HKSpw = hkspi.getText();
				//t.HKSccVeri = hksci.getText();
				//t.HKSsecurityAnswer = hkssi.getText();
				
				t.testHKDMA = hkdmac.isSelected();
				t.HKDMAupdate = checkBoxMenuItem_58.isSelected();
				t.HKDMAcreation = checkBoxMenuItem_59.isSelected();
				t.HKDMApayment = checkBoxMenuItem_60.isSelected();
				t.HKDMAlinks = checkBoxMenuItem_61.isSelected();
				t.HKDMAusr = hkdmaui.getText();
				t.HKDMApw = hkdmapi.getText();
				t.HKDMAccVeri = hkdmaci.getText();
				t.HKDMAsecurityAnswer = hkdmasi.getText();
				
				/* if SG Tab Check Boxes are selected: 
				 * Customer Desktop
				 * Customer Mobile
				 * Retailer
				 * Agent
				 * Distributor
				 * Sales Agent
				 */
				t.testSGCustomer = sgcc.isSelected();
				t.SGCupdate = checkBoxMenuItem_4.isSelected();
				t.SGCpayment = checkBoxMenuItem_23.isSelected();
				t.SGClinks = checkBoxMenuItem_27.isSelected();
				t.SGCcreation = checkBoxMenuItem_38.isSelected();
				t.SGCusr = sgcui.getText();
				t.SGCpw = sgcpi.getText();
				t.SGCccVeri = sgcci.getText();
				t.SGCsecurityAnswer = sgcsi.getText();

				t.testSGMobile = sgmc.isSelected();
				t.SGMupdate = checkBoxMenuItem_51.isSelected();
				t.SGMpayment = checkBoxMenuItem_55.isSelected();
				t.SGMlinks = checkBoxMenuItem_66.isSelected();
				t.SGMcreation = checkBoxMenuItem_78.isSelected();
				t.SGMusr = sgmui.getText();
				t.SGMpw = sgmpi.getText();
				t.SGMccVeri = sgmci.getText();
				t.SGMsecurityAnswer = sgmsi.getText();

				t.testSGRetailer = sgrc.isSelected();
				t.SGRupdate = checkBoxMenuItem_83.isSelected();
				t.SGRcreation = checkBoxMenuItem_84.isSelected();
				t.SGRpayment = checkBoxMenuItem_85.isSelected();
				t.SGRlinks = checkBoxMenuItem_86.isSelected();
				t.SGRusr = sgrui.getText();
				t.SGRpw = sgrpi.getText();
				t.SGRsecurityAnswer = sgrsi.getText();

				t.testSGAgent = sgac.isSelected();
				t.SGAcreation = checkBoxMenuItem_95.isSelected();
				t.SGApayment = checkBoxMenuItem_96.isSelected();
				t.SGAlinks = checkBoxMenuItem_97.isSelected();
				t.SGAusr = sgaui.getText();
				t.SGApw = sgapi.getText();

				t.testSGDist = sgdc.isSelected();
				t.SGDupdate = checkBoxMenuItem_87.isSelected();
				t.SGDcreation = checkBoxMenuItem_88.isSelected();
				t.SGDpayment = checkBoxMenuItem_89.isSelected();
				t.SGDlinks = checkBoxMenuItem_90.isSelected();
				t.SGDusr = sgdui.getText();
				t.SGDpw = sgdpi.getText();
				//SGDccVeri = sgdci.getText();
				t.SGDsecurityAnswer = sgdsi.getText();

				t.testSGSagent = sgsc.isSelected();
				t.SGSupdate = checkBoxMenuItem_91.isSelected();
				t.SGScreation = checkBoxMenuItem_92.isSelected();
				t.SGSpayment = checkBoxMenuItem_93.isSelected();
				t.SGSlinks = checkBoxMenuItem_94.isSelected();
				t.SGSusr = sgsui.getText();
				t.SGSpw = sgspi.getText();
				//t.SGSccVeri = sgsci.getText();
				//t.SGSsecurityAnswer = sgssi.getText();

				t.testSGDMA = sgdmac.isSelected();
				t.SGDMAupdate = checkBoxMenuItem_79.isSelected();
				t.SGDMAcreation = checkBoxMenuItem_80.isSelected();
				t.SGDMApayment = checkBoxMenuItem_81.isSelected();
				t.SGDMAlinks = checkBoxMenuItem_82.isSelected();
				t.SGDMAusr = sgdmaui.getText();
				t.SGDMApw = sgdmapi.getText();
				t.SGDMAccVeri = sgdmaci.getText();
				t.SGDMAsecurityAnswer = sgdmasi.getText();
				
				/* if ES Tab Check Boxes are selected: 
				 * Customer Desktop
				 * Customer Mobile
				 * Retailer
				 * Agent
				 * Distributor
				 * Sales Agent
				 */
				t.testESCustomer = escc.isSelected();
				t.ESCupdate = checkBoxMenuItem_98.isSelected();
				t.ESCpayment = checkBoxMenuItem_99.isSelected();
				t.ESClinks = checkBoxMenuItem_100.isSelected();
				t.ESCcreation = checkBoxMenuItem_101.isSelected();
				t.ESCusr = escui.getText();
				t.ESCpw = escpi.getText();
				t.ESCccVeri = escci.getText();
				t.ESCsecurityAnswer = escsi.getText();

				t.testESMobile = esmc.isSelected();
				t.ESMupdate = checkBoxMenuItem_102.isSelected();
				t.ESMpayment = checkBoxMenuItem_103.isSelected();
				t.ESMlinks = checkBoxMenuItem_104.isSelected();
				t.ESMcreation = checkBoxMenuItem_105.isSelected();
				t.ESMusr = esmui.getText();
				t.ESMpw = esmpi.getText();
				t.ESMccVeri = esmci.getText();
				t.ESMsecurityAnswer = esmsi.getText();

				t.testESRetailer = esrc.isSelected();
				t.ESRupdate = checkBoxMenuItem_110.isSelected();
				t.ESRcreation = checkBoxMenuItem_111.isSelected();
				t.ESRpayment = checkBoxMenuItem_112.isSelected();
				t.ESRlinks = checkBoxMenuItem_113.isSelected();
				t.ESRusr = esrui.getText();
				t.ESRpw = esrpi.getText();
				t.ESRsecurityAnswer = esrsi.getText();

				t.testESAgent = esac.isSelected();
				t.ESAcreation = checkBoxMenuItem_115.isSelected();
				t.ESApayment = checkBoxMenuItem_116.isSelected();
				t.ESAlinks = checkBoxMenuItem_117.isSelected();
				t.ESAusr = esaui.getText();
				t.ESApw = esapi.getText();

				t.testESDist = esdc.isSelected();
				t.ESDupdate = checkBoxMenuItem_118.isSelected();
				t.ESDcreation = checkBoxMenuItem_119.isSelected();
				t.ESDpayment = checkBoxMenuItem_120.isSelected();
				t.ESDlinks = checkBoxMenuItem_121.isSelected();
				t.ESDusr = esdui.getText();
				t.ESDpw = esdpi.getText();
				//ESDccVeri = esdci.getText();
				t.ESDsecurityAnswer = esdsi.getText();

				t.testESSagent = essc.isSelected();
				t.ESSupdate = checkBoxMenuItem_122.isSelected();
				t.ESScreation = checkBoxMenuItem_123.isSelected();
				t.ESSpayment = checkBoxMenuItem_124.isSelected();
				t.ESSlinks = checkBoxMenuItem_125.isSelected();
				t.ESSusr = essui.getText();
				t.ESSpw = esspi.getText();
				//t.ESSccVeri = essci.getText();
				//t.ESSsecurityAnswer = esssi.getText();

				t.testESDMA = esdmac.isSelected();
				t.ESDMAupdate = checkBoxMenuItem_106.isSelected();
				t.ESDMAcreation = checkBoxMenuItem_107.isSelected();
				t.ESDMApayment = checkBoxMenuItem_108.isSelected();
				t.ESDMAlinks = checkBoxMenuItem_109.isSelected();
				t.ESDMAusr = esdmaui.getText();
				t.ESDMApw = esdmapi.getText();
				t.ESDMAccVeri = esdmaci.getText();
				t.ESDMAsecurityAnswer = esdmasi.getText();
				
				/* if DE Tab Check Boxes are selected: 
				 * Customer Desktop
				 * Customer Mobile
				 * Retailer
				 * Agent
				 * Distributor
				 * Sales Agent
				 */
				t.testDECustomer = decc.isSelected();
				t.DECupdate = checkBoxMenuItem_114.isSelected();
				t.DECpayment = checkBoxMenuItem_126.isSelected();
				t.DEClinks = checkBoxMenuItem_127.isSelected();
				t.DECcreation = checkBoxMenuItem_128.isSelected();
				t.DECusr = decui.getText();
				t.DECpw = decpi.getText();
				t.DECccVeri = decci.getText();
				t.DECsecurityAnswer = decsi.getText();

				t.testDEMobile = demc.isSelected();
				t.DEMupdate = checkBoxMenuItem_129.isSelected();
				t.DEMpayment = checkBoxMenuItem_130.isSelected();
				t.DEMlinks = checkBoxMenuItem_131.isSelected();
				t.DEMcreation = checkBoxMenuItem_132.isSelected();
				t.DEMusr = demui.getText();
				t.DEMpw = dempi.getText();
				t.DEMccVeri = demci.getText();
				t.DEMsecurityAnswer = demsi.getText();

				t.testDERetailer = derc.isSelected();
				t.DERupdate = checkBoxMenuItem_137.isSelected();
				t.DERcreation = checkBoxMenuItem_138.isSelected();
				t.DERpayment = checkBoxMenuItem_139.isSelected();
				t.DERlinks = checkBoxMenuItem_140.isSelected();
				t.DERusr = derui.getText();
				t.DERpw = derpi.getText();
				t.DERsecurityAnswer = dersi.getText();
				

				t.testDEAgent = deac.isSelected();
				t.DEAcreation = checkBoxMenuItem_141.isSelected();
				t.DEApayment = checkBoxMenuItem_142.isSelected();
				t.DEAlinks = checkBoxMenuItem_143.isSelected();
				t.DEAusr = deaui.getText();
				t.DEApw = deapi.getText();
				t.DEAsecAns = deasi.getText();

				t.testDEDist = dedc.isSelected();
				t.DEDupdate = checkBoxMenuItem_144.isSelected();
				t.DEDcreation = checkBoxMenuItem_145.isSelected();
				t.DEDpayment = checkBoxMenuItem_146.isSelected();
				t.DEDlinks = checkBoxMenuItem_147.isSelected();
				t.DEDusr = dedui.getText();
				t.DEDpw = dedpi.getText();
				//DEDccVeri = dedci.getText();
				t.DEDsecurityAnswer = dedsi.getText();

				t.testDESagent = desc.isSelected();
				t.DESupdate = checkBoxMenuItem_148.isSelected();
				t.DEScreation = checkBoxMenuItem_149.isSelected();
				t.DESpayment = checkBoxMenuItem_150.isSelected();
				t.DESlinks = checkBoxMenuItem_151.isSelected();
				t.DESusr = desui.getText();
				t.DESpw = despi.getText();
				//t.DESccVeri = desci.getText();
				//t.DESsecurityAnswer = dessi.getText();

				t.testDEDMA = dedmac.isSelected();
				t.DEDMAupdate = checkBoxMenuItem_133.isSelected();
				t.DEDMAcreation = checkBoxMenuItem_134.isSelected();
				t.DEDMApayment = checkBoxMenuItem_135.isSelected();
				t.DEDMAlinks = checkBoxMenuItem_136.isSelected();
				t.DEDMAusr = dedmaui.getText();
				t.DEDMApw = dedmapi.getText();
				t.DEDMAccVeri = dedmaci.getText();
				t.DEDMAsecurityAnswer = dedmasi.getText();
				
				/* if AU Tab Check Boxes are selected: 
				 * Customer Desktop
				 * Customer Mobile
				 * Retailer
				 * Agent
				 * Distributor
				 * Sales Agent
				 */
				t.testAUCustomer = aucc.isSelected();
				t.AUCupdate = checkBoxMenuItem_152.isSelected();
				t.AUCpayment = checkBoxMenuItem_153.isSelected();
				t.AUClinks = checkBoxMenuItem_154.isSelected();
				t.AUCcreation = checkBoxMenuItem_155.isSelected();
				t.AUCusr = aucui.getText();
				t.AUCpw = aucpi.getText();
				t.AUCccVeri = aucci.getText();
				t.AUCsecurityAnswer = aucsi.getText();

				t.testAUMobile = aumc.isSelected();
				t.AUMupdate = checkBoxMenuItem_156.isSelected();
				t.AUMpayment = checkBoxMenuItem_157.isSelected();
				t.AUMlinks = checkBoxMenuItem_158.isSelected();
				t.AUMcreation = checkBoxMenuItem_159.isSelected();
				t.AUMusr = aumui.getText();
				t.AUMpw = aumpi.getText();
				t.AUMccVeri = aumci.getText();
				t.AUMsecurityAnswer = aumsi.getText();

				t.testAURetailer = aurc.isSelected();
				t.AURupdate = checkBoxMenuItem_164.isSelected();
				t.AURcreation = checkBoxMenuItem_165.isSelected();
				t.AURpayment = checkBoxMenuItem_166.isSelected();
				t.AURlinks = checkBoxMenuItem_167.isSelected();
				t.AURusr = aurui.getText();
				t.AURpw = aurpi.getText();
				t.AURsecurityAnswer = aursi.getText();

				t.testAUAgent = auac.isSelected();
				t.AUAcreation = checkBoxMenuItem_168.isSelected();
				t.AUApayment = checkBoxMenuItem_169.isSelected();
				t.AUAlinks = checkBoxMenuItem_170.isSelected();
				t.AUAusr = auaui.getText();
				t.AUApw = auapi.getText();

				t.testAUDist = audc.isSelected();
				t.AUDupdate = checkBoxMenuItem_171.isSelected();
				t.AUDcreation = checkBoxMenuItem_172.isSelected();
				t.AUDpayment = checkBoxMenuItem_173.isSelected();
				t.AUDlinks = checkBoxMenuItem_174.isSelected();
				t.AUDusr = audui.getText();
				t.AUDpw = audpi.getText();
				//AUDccVeri = audci.getText();
				t.AUDsecurityAnswer = audsi.getText();

				t.testAUSagent = ausc.isSelected();
				t.AUSupdate = checkBoxMenuItem_175.isSelected();
				t.AUScreation = checkBoxMenuItem_176.isSelected();
				t.AUSpayment = checkBoxMenuItem_177.isSelected();
				t.AUSlinks = checkBoxMenuItem_178.isSelected();
				t.AUSusr = ausui.getText();
				t.AUSpw = auspi.getText();
				//t.AUSccVeri = ausci.getText();
				//t.AUSsecurityAnswer = aussi.getText();

				t.testAUDMA = audmac.isSelected();
				t.AUDMAupdate = checkBoxMenuItem_160.isSelected();
				t.AUDMAcreation = checkBoxMenuItem_161.isSelected();
				t.AUDMApayment = checkBoxMenuItem_162.isSelected();
				t.AUDMAlinks = checkBoxMenuItem_163.isSelected();
				t.AUDMAusr = audmaui.getText();
				t.AUDMApw = audmapi.getText();
				t.AUDMAccVeri = audmaci.getText();
				t.AUDMAsecurityAnswer = audmasi.getText();
				
				/* if any check boxes in any tabs are selected, run
				 * else if, print out "Nothing to test" */ 
				if(uks || cas || hks || sgs || ess || des || aus){
					/* call run function */
					R = run();
					/* call start function */ 
					R.start(); 
					/* after it has ran, set to false*/ 
					startState = false;
				}else{
					System.err.println("Nothing to test");
				}
			}
		});
		
		/* end of listener */ 
		/* define main Panel */ 
		start.setBounds(10, 340, 145, 121);
		mainPanel.add(start);

		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 89, 14);
		mainPanel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 25, 513, 2);
		mainPanel.add(separator);

		ukbtn = new JButton("United Kingdom");
		ukbtn.setForeground(Color.RED);
		ukbtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		ukbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				ukp.setVisible(true);
			}
		});
		ukbtn.setBounds(10, 36, 145, 23);
		mainPanel.add(ukbtn);

		cabtn = new JButton("Canada");
		cabtn.setForeground(Color.RED);
		cabtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		cabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				cap.setVisible(true);
			}
		});
		cabtn.setBounds(10, 70, 145, 23);
		mainPanel.add(cabtn);

		hkbtn = new JButton("Hong Kong");
		hkbtn.setForeground(Color.RED);
		hkbtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		hkbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				hkp.setVisible(true);
			}
		});
		hkbtn.setBounds(10, 104, 145, 23);
		mainPanel.add(hkbtn);

		jirabtn = new JButton("JIRA");
		jirabtn.setForeground(Color.RED);
		jirabtn.setFont(new Font("Calibri", Font.PLAIN, 14));
		jirabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				jiraP.setVisible(true);
			}
		});
		jirabtn.setBounds(10, 274, 145, 23);
		mainPanel.add(jirabtn);

		JTextPane console2 = new JTextPane();
		console2.setFont(new Font("Calibri", Font.PLAIN, 13));
		console2.setBounds(165, 38, 358, 423);
		mainPanel.add(console2);
		mainPanel.setVisible(true);

		JScrollPane console1 = new JScrollPane(console2);
		console1.setBounds(165, 38, 800, 500);
		mainPanel.add(console1);
		MessageConsole mc = new MessageConsole(console2);
		mc.redirectOut();
		JLabel lblJanMiranda = new JLabel("");
		lblJanMiranda.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		lblJanMiranda.setBounds(463, 11, 70, 14);
		mainPanel.add(lblJanMiranda);
		
		
		mc.redirectErr(Color.RED, null);
		
		/* define load button */ 
		JButton load = new JButton("Load");
		load.setFont(new Font("Calibri", Font.PLAIN, 12));
		load.addActionListener(new ActionListener() {
			/* listener waits for someone to click on load */ 
			public void actionPerformed(ActionEvent e) {
				jiraqa.setSelected(getBoolean(configProps.getProperty("testJira")));
				jiraUsr.setText(configProps.getProperty("jiraUsr"));
				jiraPw.setText(configProps.getProperty("jiraPw"));
				jiraqai.setText(configProps.getProperty("jticket"));
				qaversion.setText(configProps.getProperty("jversion"));
				rb.setSelected(getBoolean(configProps.getProperty("rb")));
				rb1.setSelected(getBoolean(configProps.getProperty("rb1")));
				rb2.setSelected(getBoolean(configProps.getProperty("rb2")));
				rb3.setSelected(getBoolean(configProps.getProperty("rb3")));
				rb4.setSelected(getBoolean(configProps.getProperty("rb4")));
				rb5.setSelected(getBoolean(configProps.getProperty("rb5")));
				rb6.setSelected(getBoolean(configProps.getProperty("rb6")));
				
				ukcc.setSelected(getBoolean(configProps.getProperty("testUKCustomer")));
				checkBoxMenuItem_12.setSelected(getBoolean(configProps.getProperty("UKCupdate")));
				checkBoxMenuItem_14.setSelected(getBoolean(configProps.getProperty("UKCpayment")));
				checkBoxMenuItem_15.setSelected(getBoolean(configProps.getProperty("UKClinks")));
				chckbxmntmNewCheckItem1.setSelected(getBoolean(configProps.getProperty("UKCcreation")));
				ukcui.setText(configProps.getProperty("ukcui"));
				ukcpi.setText(configProps.getProperty("ukcpi"));
				ukcci.setText(configProps.getProperty("ukcci"));
				
				ukmc.setSelected(getBoolean(configProps.getProperty("testUKMobile")));
				checkBoxMenuItem_16.setSelected(getBoolean(configProps.getProperty("UKMupdate")));
				checkBoxMenuItem_18.setSelected(getBoolean(configProps.getProperty("UKMpayment")));
				checkBoxMenuItem_19.setSelected(getBoolean(configProps.getProperty("UKMlinks")));
				chckbxmntmNewCheckItem_2.setSelected(getBoolean(configProps.getProperty("UKMcreation")));
				ukmui.setText(configProps.getProperty("ukmui"));
				ukmpi.setText(configProps.getProperty("ukmpi"));
				ukmci.setText(configProps.getProperty("ukmci"));
				
				ukrc.setSelected(getBoolean(configProps.getProperty("testUKRetailer")));
				checkBoxMenuItem.setSelected(getBoolean(configProps.getProperty("UKRupdate")));
				checkBoxMenuItem_1.setSelected(getBoolean(configProps.getProperty("UKRcreation")));
				checkBoxMenuItem_2.setSelected(getBoolean(configProps.getProperty("UKRpayment")));
				checkBoxMenuItem_3.setSelected(getBoolean(configProps.getProperty("UKRlinks")));
				ukrui.setText(configProps.getProperty("ukrui"));
				ukrpi.setText(configProps.getProperty("ukrpi"));
				
				ukac.setSelected(getBoolean(configProps.getProperty("testUKAgent")));
				checkBoxMenuItem_5.setSelected(getBoolean(configProps.getProperty("UKAcreation")));
				checkBoxMenuItem_6.setSelected(getBoolean(configProps.getProperty("UKApayment")));
				checkBoxMenuItem_7.setSelected(getBoolean(configProps.getProperty("UKAlinks")));
				ukaui.setText(configProps.getProperty("ukaui"));
				ukapi.setText(configProps.getProperty("ukapi"));
				ukaci.setText(configProps.getProperty("ukaci"));
				
				ukdc.setSelected(getBoolean(configProps.getProperty("testUKDist")));
				checkBoxMenuItem_8.setSelected(getBoolean(configProps.getProperty("UKDupdate")));
				checkBoxMenuItem_9.setSelected(getBoolean(configProps.getProperty("UKDcreation")));
				checkBoxMenuItem_10.setSelected(getBoolean(configProps.getProperty("UKDpayment")));
				checkBoxMenuItem_11.setSelected(getBoolean(configProps.getProperty("UKDlinks")));
				ukdui.setText(configProps.getProperty("ukdui"));
				ukdpi.setText(configProps.getProperty("ukdpi"));
				ukdci.setText(configProps.getProperty("ukdci"));
				
				uksc.setSelected(getBoolean(configProps.getProperty("testUKSagent")));
				cb1.setSelected(getBoolean(configProps.getProperty("UKSupdate")));
				cb2.setSelected(getBoolean(configProps.getProperty("UKScreation")));
				cb3.setSelected(getBoolean(configProps.getProperty("UKSpayment")));
				cb4.setSelected(getBoolean(configProps.getProperty("UKSlinks")));
				uksui.setText(configProps.getProperty("uksui"));
				ukspi.setText(configProps.getProperty("ukspi"));
				//uksci.setText(configProps.getProperty("uksci"));
				
				ukdmac.setSelected(getBoolean(configProps.getProperty("testUKDMA")));
				checkBoxMenuItem_13.setSelected(getBoolean(configProps.getProperty("UKDMAupdate")));
				checkBoxMenuItem_17.setSelected(getBoolean(configProps.getProperty("UKDMAcreation")));
				checkBoxMenuItem_20.setSelected(getBoolean(configProps.getProperty("UKDMApayment")));
				checkBoxMenuItem_21.setSelected(getBoolean(configProps.getProperty("UKDMAlinks")));
				ukdmaui.setText(configProps.getProperty("ukdmaui"));
				ukdmapi.setText(configProps.getProperty("ukdmapi"));
				ukdmaci.setText(configProps.getProperty("ukdmaci"));
				
				cacc.setSelected(getBoolean(configProps.getProperty("testCACustomer")));
				checkBoxMenuItem_22.setSelected(getBoolean(configProps.getProperty("CACupdate")));
				checkBoxMenuItem_24.setSelected(getBoolean(configProps.getProperty("CACpayment")));
				checkBoxMenuItem_25.setSelected(getBoolean(configProps.getProperty("CAClinks")));
				chckbxmntmNewCheckItem1.setSelected(getBoolean(configProps.getProperty("CACcreation")));
				cacui.setText(configProps.getProperty("cacui"));
				cacpi.setText(configProps.getProperty("cacpi"));
				cacci.setText(configProps.getProperty("cacci"));
				cacsi.setText(configProps.getProperty("cacsi"));
				
				camc.setSelected(getBoolean(configProps.getProperty("testCAMobile")));
				checkBoxMenuItem_26.setSelected(getBoolean(configProps.getProperty("CAMupdate")));
				checkBoxMenuItem_28.setSelected(getBoolean(configProps.getProperty("CAMpayment")));
				checkBoxMenuItem_29.setSelected(getBoolean(configProps.getProperty("CAMlinks")));
				chckbxmntmNewCheckItem_1.setSelected(getBoolean(configProps.getProperty("CAMcreation")));
				camui.setText(configProps.getProperty("camui"));
				campi.setText(configProps.getProperty("campi"));
				camci.setText(configProps.getProperty("camci"));
				camsi.setText(configProps.getProperty("camsi"));
				
				cadmac.setSelected(getBoolean(configProps.getProperty("testCADMA")));
				checkBoxMenuItem_30.setSelected(getBoolean(configProps.getProperty("CADMAupdate")));
				checkBoxMenuItem_31.setSelected(getBoolean(configProps.getProperty("CADMAcreation")));
				checkBoxMenuItem_32.setSelected(getBoolean(configProps.getProperty("CADMApayment")));
				checkBoxMenuItem_33.setSelected(getBoolean(configProps.getProperty("CADMAlinks")));
				cadmaui.setText(configProps.getProperty("cadmaui"));
				cadmapi.setText(configProps.getProperty("cadmapi"));
				cadmaci.setText(configProps.getProperty("cadmaci"));
				cadmasi.setText(configProps.getProperty("cadmasi"));
				
				carc.setSelected(getBoolean(configProps.getProperty("testCARetailer")));
				checkBoxMenuItem_34.setSelected(getBoolean(configProps.getProperty("CARupdate")));
				checkBoxMenuItem_35.setSelected(getBoolean(configProps.getProperty("CARcreation")));
				checkBoxMenuItem_36.setSelected(getBoolean(configProps.getProperty("CARpayment")));
				checkBoxMenuItem_37.setSelected(getBoolean(configProps.getProperty("CARlinks")));
				carui.setText(configProps.getProperty("carui"));
				carpi.setText(configProps.getProperty("carpi"));
				carsi.setText(configProps.getProperty("carsi"));
				
				caac.setSelected(getBoolean(configProps.getProperty("testCAAgent")));
				checkBoxMenuItem_39.setSelected(getBoolean(configProps.getProperty("CAAcreation")));
				checkBoxMenuItem_40.setSelected(getBoolean(configProps.getProperty("CAApayment")));
				checkBoxMenuItem_41.setSelected(getBoolean(configProps.getProperty("CAAlinks")));
				caaui.setText(configProps.getProperty("caaui"));
				caapi.setText(configProps.getProperty("caapi"));
				caaci.setText(configProps.getProperty("caaci"));
				
				cadc.setSelected(getBoolean(configProps.getProperty("testCADist")));
				checkBoxMenuItem_42.setSelected(getBoolean(configProps.getProperty("CADupdate")));
				checkBoxMenuItem_43.setSelected(getBoolean(configProps.getProperty("CADcreation")));
				checkBoxMenuItem_44.setSelected(getBoolean(configProps.getProperty("CADpayment")));
				checkBoxMenuItem_45.setSelected(getBoolean(configProps.getProperty("CADlinks")));
				cadui.setText(configProps.getProperty("cadui"));
				cadpi.setText(configProps.getProperty("cadpi"));
				//cadci.setText(configProps.getProperty("cadci"));
				cadsi.setText(configProps.getProperty("cadsi"));
				
				casc.setSelected(getBoolean(configProps.getProperty("testCASagent")));
				checkBoxMenuItem_46.setSelected(getBoolean(configProps.getProperty("CASupdate")));
				checkBoxMenuItem_47.setSelected(getBoolean(configProps.getProperty("CAScreation")));
				checkBoxMenuItem_48.setSelected(getBoolean(configProps.getProperty("CASpayment")));
				checkBoxMenuItem_49.setSelected(getBoolean(configProps.getProperty("CASlinks")));
				casui.setText(configProps.getProperty("casui"));
				caspi.setText(configProps.getProperty("caspi"));
				//casci.setText(configProps.getProperty("casci"));
				//cassi.setText(configProps.getProperty("cassi"));
				
				hkcc.setSelected(getBoolean(configProps.getProperty("testHKCustomer")));
				checkBoxMenuItem_50.setSelected(getBoolean(configProps.getProperty("HKCupdate")));
				checkBoxMenuItem_52.setSelected(getBoolean(configProps.getProperty("HKCpayment")));
				checkBoxMenuItem_53.setSelected(getBoolean(configProps.getProperty("HKClinks")));
				chckbxmntmNewCheckItem_3.setSelected(getBoolean(configProps.getProperty("HKCcreation")));
				hkcui.setText(configProps.getProperty("hkcui"));
				hkcpi.setText(configProps.getProperty("hkcpi"));
				hkcci.setText(configProps.getProperty("hkcci"));
				hkcsi.setText(configProps.getProperty("hkcsi"));
				
				hkmc.setSelected(getBoolean(configProps.getProperty("testHKMobile")));
				checkBoxMenuItem_54.setSelected(getBoolean(configProps.getProperty("HKMupdate")));
				checkBoxMenuItem_56.setSelected(getBoolean(configProps.getProperty("HKMpayment")));
				checkBoxMenuItem_57.setSelected(getBoolean(configProps.getProperty("HKMlinks")));
				chckbxmntmNewCheckItem_4.setSelected(getBoolean(configProps.getProperty("HKMcreation")));
				hkmui.setText(configProps.getProperty("hkmui"));
				hkmpi.setText(configProps.getProperty("hkmpi"));
				hkmci.setText(configProps.getProperty("hkmci"));
				hkmsi.setText(configProps.getProperty("hkmsi"));
				
				hkdmac.setSelected(getBoolean(configProps.getProperty("testHKDMA")));
				checkBoxMenuItem_58.setSelected(getBoolean(configProps.getProperty("HKDMAupdate")));
				checkBoxMenuItem_59.setSelected(getBoolean(configProps.getProperty("HKDMAcreation")));
				checkBoxMenuItem_60.setSelected(getBoolean(configProps.getProperty("HKDMApayment")));
				checkBoxMenuItem_61.setSelected(getBoolean(configProps.getProperty("HKDMAlinks")));
				hkdmaui.setText(configProps.getProperty("hkdmaui"));
				hkdmapi.setText(configProps.getProperty("hkdmapi"));
				hkdmaci.setText(configProps.getProperty("hkdmaci"));
				hkdmasi.setText(configProps.getProperty("hkdmasi"));
				
				hkrc.setSelected(getBoolean(configProps.getProperty("testHKRetailer")));
				checkBoxMenuItem_62.setSelected(getBoolean(configProps.getProperty("HKRupdate")));
				checkBoxMenuItem_63.setSelected(getBoolean(configProps.getProperty("HKRcreation")));
				checkBoxMenuItem_64.setSelected(getBoolean(configProps.getProperty("HKRpayment")));
				checkBoxMenuItem_65.setSelected(getBoolean(configProps.getProperty("HKRlinks")));
				hkrui.setText(configProps.getProperty("hkrui"));
				hkrpi.setText(configProps.getProperty("hkrpi"));
				hkrsi.setText(configProps.getProperty("hkrsi"));
				
				hkac.setSelected(getBoolean(configProps.getProperty("testHKAgent")));
				checkBoxMenuItem_67.setSelected(getBoolean(configProps.getProperty("HKAcreation")));
				checkBoxMenuItem_68.setSelected(getBoolean(configProps.getProperty("HKApayment")));
				checkBoxMenuItem_69.setSelected(getBoolean(configProps.getProperty("HKAlinks")));
				hkaui.setText(configProps.getProperty("hkaui"));
				hkapi.setText(configProps.getProperty("hkapi"));
				
				hkdc.setSelected(getBoolean(configProps.getProperty("testHKDist")));
				checkBoxMenuItem_70.setSelected(getBoolean(configProps.getProperty("HKDupdate")));
				checkBoxMenuItem_71.setSelected(getBoolean(configProps.getProperty("HKDcreation")));
				checkBoxMenuItem_72.setSelected(getBoolean(configProps.getProperty("HKDpayment")));
				checkBoxMenuItem_73.setSelected(getBoolean(configProps.getProperty("HKDlinks")));
				hkdui.setText(configProps.getProperty("hkdui"));
				hkdpi.setText(configProps.getProperty("hkdpi"));
				//hkdci.setText(configProps.getProperty("hkdci"));
				hkdsi.setText(configProps.getProperty("hkdsi"));
				
				hksc.setSelected(getBoolean(configProps.getProperty("testHKSagent")));
				checkBoxMenuItem_74.setSelected(getBoolean(configProps.getProperty("HKSupdate")));
				checkBoxMenuItem_75.setSelected(getBoolean(configProps.getProperty("HKScreation")));
				checkBoxMenuItem_76.setSelected(getBoolean(configProps.getProperty("HKSpayment")));
				checkBoxMenuItem_77.setSelected(getBoolean(configProps.getProperty("HKSlinks")));
				hksui.setText(configProps.getProperty("hksui"));
				hkspi.setText(configProps.getProperty("hkspi"));
				//hksci.setText(configProps.getProperty("hksci"));
				//hkssi.setText(configProps.getProperty("hkssi"));
				
				sgcc.setSelected(getBoolean(configProps.getProperty("testSGCustomer")));
				checkBoxMenuItem_4.setSelected(getBoolean(configProps.getProperty("SGCupdate")));
				checkBoxMenuItem_23.setSelected(getBoolean(configProps.getProperty("SGCpayment")));
				checkBoxMenuItem_27.setSelected(getBoolean(configProps.getProperty("SGClinks")));
				checkBoxMenuItem_38.setSelected(getBoolean(configProps.getProperty("SGCcreation")));
				sgcui.setText(configProps.getProperty("sgcui"));
				sgcpi.setText(configProps.getProperty("sgcpi"));
				sgcci.setText(configProps.getProperty("sgcci"));
				sgcsi.setText(configProps.getProperty("sgcsi"));

				sgmc.setSelected(getBoolean(configProps.getProperty("testSGMobile")));
				checkBoxMenuItem_51.setSelected(getBoolean(configProps.getProperty("SGMupdate")));
				checkBoxMenuItem_55.setSelected(getBoolean(configProps.getProperty("SGMpayment")));
				checkBoxMenuItem_66.setSelected(getBoolean(configProps.getProperty("SGMlinks")));
				checkBoxMenuItem_78.setSelected(getBoolean(configProps.getProperty("SGMcreation")));
				sgmui.setText(configProps.getProperty("sgmui"));
				sgmpi.setText(configProps.getProperty("sgmpi"));
				sgmci.setText(configProps.getProperty("sgmci"));
				sgmsi.setText(configProps.getProperty("sgmsi"));

				sgdmac.setSelected(getBoolean(configProps.getProperty("testSGDMA")));
				checkBoxMenuItem_79.setSelected(getBoolean(configProps.getProperty("SGDMAupdate")));
				checkBoxMenuItem_80.setSelected(getBoolean(configProps.getProperty("SGDMAcreation")));
				checkBoxMenuItem_81.setSelected(getBoolean(configProps.getProperty("SGDMApayment")));
				checkBoxMenuItem_82.setSelected(getBoolean(configProps.getProperty("SGDMAlinks")));
				sgdmaui.setText(configProps.getProperty("sgdmaui"));
				sgdmapi.setText(configProps.getProperty("sgdmapi"));
				sgdmaci.setText(configProps.getProperty("sgdmaci"));
				sgdmasi.setText(configProps.getProperty("sgdmasi"));

				sgrc.setSelected(getBoolean(configProps.getProperty("testSGRetailer")));
				checkBoxMenuItem_83.setSelected(getBoolean(configProps.getProperty("SGRupdate")));
				checkBoxMenuItem_84.setSelected(getBoolean(configProps.getProperty("SGRcreation")));
				checkBoxMenuItem_85.setSelected(getBoolean(configProps.getProperty("SGRpayment")));
				checkBoxMenuItem_86.setSelected(getBoolean(configProps.getProperty("SGRlinks")));
				sgrui.setText(configProps.getProperty("sgrui"));
				sgrpi.setText(configProps.getProperty("sgrpi"));
				sgrsi.setText(configProps.getProperty("sgrsi"));

				sgac.setSelected(getBoolean(configProps.getProperty("testSGAgent")));
				checkBoxMenuItem_95.setSelected(getBoolean(configProps.getProperty("SGAcreation")));
				checkBoxMenuItem_96.setSelected(getBoolean(configProps.getProperty("SGApayment")));
				checkBoxMenuItem_97.setSelected(getBoolean(configProps.getProperty("SGAlinks")));
				sgaui.setText(configProps.getProperty("sgaui"));
				sgapi.setText(configProps.getProperty("sgapi"));

				sgdc.setSelected(getBoolean(configProps.getProperty("testSGDist")));
				checkBoxMenuItem_87.setSelected(getBoolean(configProps.getProperty("SGDupdate")));
				checkBoxMenuItem_88.setSelected(getBoolean(configProps.getProperty("SGDcreation")));
				checkBoxMenuItem_89.setSelected(getBoolean(configProps.getProperty("SGDpayment")));
				checkBoxMenuItem_90.setSelected(getBoolean(configProps.getProperty("SGDlinks")));
				sgdui.setText(configProps.getProperty("sgdui"));
				sgdpi.setText(configProps.getProperty("sgdpi"));
				//sgdci.setText(configProps.getProperty("sgdci"));
				sgdsi.setText(configProps.getProperty("sgdsi"));

				sgsc.setSelected(getBoolean(configProps.getProperty("testSGSagent")));
				checkBoxMenuItem_91.setSelected(getBoolean(configProps.getProperty("SGSupdate")));
				checkBoxMenuItem_92.setSelected(getBoolean(configProps.getProperty("SGScreation")));
				checkBoxMenuItem_93.setSelected(getBoolean(configProps.getProperty("SGSpayment")));
				checkBoxMenuItem_94.setSelected(getBoolean(configProps.getProperty("SGSlinks")));
				sgsui.setText(configProps.getProperty("sgsui"));
				sgspi.setText(configProps.getProperty("sgspi"));
				
				escc.setSelected(getBoolean(configProps.getProperty("testESCustomer")));
				checkBoxMenuItem_98.setSelected(getBoolean(configProps.getProperty("ESCupdate")));
				checkBoxMenuItem_99.setSelected(getBoolean(configProps.getProperty("ESCpayment")));
				checkBoxMenuItem_100.setSelected(getBoolean(configProps.getProperty("ESClinks")));
				checkBoxMenuItem_101.setSelected(getBoolean(configProps.getProperty("ESCcreation")));
				escui.setText(configProps.getProperty("escui"));
				escpi.setText(configProps.getProperty("escpi"));
				escci.setText(configProps.getProperty("escci"));
				escsi.setText(configProps.getProperty("escsi"));

				esmc.setSelected(getBoolean(configProps.getProperty("testESMobile")));
				checkBoxMenuItem_102.setSelected(getBoolean(configProps.getProperty("ESMupdate")));
				checkBoxMenuItem_103.setSelected(getBoolean(configProps.getProperty("ESMpayment")));
				checkBoxMenuItem_104.setSelected(getBoolean(configProps.getProperty("ESMlinks")));
				checkBoxMenuItem_105.setSelected(getBoolean(configProps.getProperty("ESMcreation")));
				esmui.setText(configProps.getProperty("esmui"));
				esmpi.setText(configProps.getProperty("esmpi"));
				esmci.setText(configProps.getProperty("esmci"));
				esmsi.setText(configProps.getProperty("esmsi"));

				esdmac.setSelected(getBoolean(configProps.getProperty("testESDMA")));
				checkBoxMenuItem_106.setSelected(getBoolean(configProps.getProperty("ESDMAupdate")));
				checkBoxMenuItem_107.setSelected(getBoolean(configProps.getProperty("ESDMAcreation")));
				checkBoxMenuItem_108.setSelected(getBoolean(configProps.getProperty("ESDMApayment")));
				checkBoxMenuItem_109.setSelected(getBoolean(configProps.getProperty("ESDMAlinks")));
				esdmaui.setText(configProps.getProperty("esdmaui"));
				esdmapi.setText(configProps.getProperty("esdmapi"));
				esdmaci.setText(configProps.getProperty("esdmaci"));
				esdmasi.setText(configProps.getProperty("esdmasi"));

				esrc.setSelected(getBoolean(configProps.getProperty("testESRetailer")));
				checkBoxMenuItem_110.setSelected(getBoolean(configProps.getProperty("ESRupdate")));
				checkBoxMenuItem_111.setSelected(getBoolean(configProps.getProperty("ESRcreation")));
				checkBoxMenuItem_112.setSelected(getBoolean(configProps.getProperty("ESRpayment")));
				checkBoxMenuItem_113.setSelected(getBoolean(configProps.getProperty("ESRlinks")));
				esrui.setText(configProps.getProperty("esrui"));
				esrpi.setText(configProps.getProperty("esrpi"));
				esrsi.setText(configProps.getProperty("esrsi"));

				esac.setSelected(getBoolean(configProps.getProperty("testESAgent")));
				checkBoxMenuItem_115.setSelected(getBoolean(configProps.getProperty("ESAcreation")));
				checkBoxMenuItem_116.setSelected(getBoolean(configProps.getProperty("ESApayment")));
				checkBoxMenuItem_117.setSelected(getBoolean(configProps.getProperty("ESAlinks")));
				esaui.setText(configProps.getProperty("esaui"));
				esapi.setText(configProps.getProperty("esapi"));

				esdc.setSelected(getBoolean(configProps.getProperty("testESDist")));
				checkBoxMenuItem_118.setSelected(getBoolean(configProps.getProperty("ESDupdate")));
				checkBoxMenuItem_119.setSelected(getBoolean(configProps.getProperty("ESDcreation")));
				checkBoxMenuItem_120.setSelected(getBoolean(configProps.getProperty("ESDpayment")));
				checkBoxMenuItem_121.setSelected(getBoolean(configProps.getProperty("ESDlinks")));
				esdui.setText(configProps.getProperty("esdui"));
				esdpi.setText(configProps.getProperty("esdpi"));
				//esdci.setText(configProps.getProperty("esdci"));
				esdsi.setText(configProps.getProperty("esdsi"));

				essc.setSelected(getBoolean(configProps.getProperty("testESSagent")));
				checkBoxMenuItem_122.setSelected(getBoolean(configProps.getProperty("ESSupdate")));
				checkBoxMenuItem_123.setSelected(getBoolean(configProps.getProperty("ESScreation")));
				checkBoxMenuItem_124.setSelected(getBoolean(configProps.getProperty("ESSpayment")));
				checkBoxMenuItem_125.setSelected(getBoolean(configProps.getProperty("ESSlinks")));
				essui.setText(configProps.getProperty("essui"));
				esspi.setText(configProps.getProperty("esspi"));
				
				decc.setSelected(getBoolean(configProps.getProperty("testDECustomer")));
				checkBoxMenuItem_114.setSelected(getBoolean(configProps.getProperty("DECupdate")));
				checkBoxMenuItem_126.setSelected(getBoolean(configProps.getProperty("DECpayment")));
				checkBoxMenuItem_127.setSelected(getBoolean(configProps.getProperty("DEClinks")));
				checkBoxMenuItem_128.setSelected(getBoolean(configProps.getProperty("DECcreation")));
				decui.setText(configProps.getProperty("decui"));
				decpi.setText(configProps.getProperty("decpi"));
				decci.setText(configProps.getProperty("decci"));
				decsi.setText(configProps.getProperty("decsi"));

				demc.setSelected(getBoolean(configProps.getProperty("testDEMobile")));
				checkBoxMenuItem_129.setSelected(getBoolean(configProps.getProperty("DEMupdate")));
				checkBoxMenuItem_130.setSelected(getBoolean(configProps.getProperty("DEMpayment")));
				checkBoxMenuItem_131.setSelected(getBoolean(configProps.getProperty("DEMlinks")));
				checkBoxMenuItem_132.setSelected(getBoolean(configProps.getProperty("DEMcreation")));
				demui.setText(configProps.getProperty("demui"));
				dempi.setText(configProps.getProperty("dempi"));
				demci.setText(configProps.getProperty("demci"));
				demsi.setText(configProps.getProperty("demsi"));

				dedmac.setSelected(getBoolean(configProps.getProperty("testDEDMA")));
				checkBoxMenuItem_133.setSelected(getBoolean(configProps.getProperty("DEDMAupdate")));
				checkBoxMenuItem_134.setSelected(getBoolean(configProps.getProperty("DEDMAcreation")));
				checkBoxMenuItem_135.setSelected(getBoolean(configProps.getProperty("DEDMApayment")));
				checkBoxMenuItem_136.setSelected(getBoolean(configProps.getProperty("DEDMAlinks")));
				dedmaui.setText(configProps.getProperty("dedmaui"));
				dedmapi.setText(configProps.getProperty("dedmapi"));
				dedmaci.setText(configProps.getProperty("dedmaci"));
				dedmasi.setText(configProps.getProperty("dedmasi"));

				derc.setSelected(getBoolean(configProps.getProperty("testDERetailer")));
				checkBoxMenuItem_137.setSelected(getBoolean(configProps.getProperty("DERupdate")));
				checkBoxMenuItem_138.setSelected(getBoolean(configProps.getProperty("DERcreation")));
				checkBoxMenuItem_139.setSelected(getBoolean(configProps.getProperty("DERpayment")));
				checkBoxMenuItem_140.setSelected(getBoolean(configProps.getProperty("DERlinks")));
				derui.setText(configProps.getProperty("derui"));
				derpi.setText(configProps.getProperty("derpi"));
				dersi.setText(configProps.getProperty("dersi"));

				deac.setSelected(getBoolean(configProps.getProperty("testDEAgent")));
				checkBoxMenuItem_141.setSelected(getBoolean(configProps.getProperty("DEAcreation")));
				checkBoxMenuItem_142.setSelected(getBoolean(configProps.getProperty("DEApayment")));
				checkBoxMenuItem_143.setSelected(getBoolean(configProps.getProperty("DEAlinks")));
				deaui.setText(configProps.getProperty("deaui"));
				deapi.setText(configProps.getProperty("deapi"));
				deasi.setText(configProps.getProperty("deasi"));

				dedc.setSelected(getBoolean(configProps.getProperty("testDEDist")));
				checkBoxMenuItem_144.setSelected(getBoolean(configProps.getProperty("DEDupdate")));
				checkBoxMenuItem_145.setSelected(getBoolean(configProps.getProperty("DEDcreation")));
				checkBoxMenuItem_146.setSelected(getBoolean(configProps.getProperty("DEDpayment")));
				checkBoxMenuItem_147.setSelected(getBoolean(configProps.getProperty("DEDlinks")));
				dedui.setText(configProps.getProperty("dedui"));
				dedpi.setText(configProps.getProperty("dedpi"));
				//dedci.setText(configProps.getProperty("dedci"));
				dedsi.setText(configProps.getProperty("dedsi"));

				desc.setSelected(getBoolean(configProps.getProperty("testDESagent")));
				checkBoxMenuItem_148.setSelected(getBoolean(configProps.getProperty("DESupdate")));
				checkBoxMenuItem_149.setSelected(getBoolean(configProps.getProperty("DEScreation")));
				checkBoxMenuItem_150.setSelected(getBoolean(configProps.getProperty("DESpayment")));
				checkBoxMenuItem_151.setSelected(getBoolean(configProps.getProperty("DESlinks")));
				desui.setText(configProps.getProperty("desui"));
				despi.setText(configProps.getProperty("despi"));
				
				
				aucc.setSelected(getBoolean(configProps.getProperty("testAUCustomer")));
				checkBoxMenuItem_152.setSelected(getBoolean(configProps.getProperty("AUCupdate")));
				checkBoxMenuItem_153.setSelected(getBoolean(configProps.getProperty("AUCpayment")));
				checkBoxMenuItem_154.setSelected(getBoolean(configProps.getProperty("AUClinks")));
				checkBoxMenuItem_155.setSelected(getBoolean(configProps.getProperty("AUCcreation")));
				aucui.setText(configProps.getProperty("aucui"));
				aucpi.setText(configProps.getProperty("aucpi"));
				aucci.setText(configProps.getProperty("aucci"));
				aucsi.setText(configProps.getProperty("aucsi"));

				aumc.setSelected(getBoolean(configProps.getProperty("testAUMobile")));
				checkBoxMenuItem_156.setSelected(getBoolean(configProps.getProperty("AUMupdate")));
				checkBoxMenuItem_157.setSelected(getBoolean(configProps.getProperty("AUMpayment")));
				checkBoxMenuItem_158.setSelected(getBoolean(configProps.getProperty("AUMlinks")));
				checkBoxMenuItem_159.setSelected(getBoolean(configProps.getProperty("AUMcreation")));
				aumui.setText(configProps.getProperty("aumui"));
				aumpi.setText(configProps.getProperty("aumpi"));
				aumci.setText(configProps.getProperty("aumci"));
				aumsi.setText(configProps.getProperty("aumsi"));

				audmac.setSelected(getBoolean(configProps.getProperty("testAUDMA")));
				checkBoxMenuItem_160.setSelected(getBoolean(configProps.getProperty("AUDMAupdate")));
				checkBoxMenuItem_161.setSelected(getBoolean(configProps.getProperty("AUDMAcreation")));
				checkBoxMenuItem_162.setSelected(getBoolean(configProps.getProperty("AUDMApayment")));
				checkBoxMenuItem_163.setSelected(getBoolean(configProps.getProperty("AUDMAlinks")));
				audmaui.setText(configProps.getProperty("audmaui"));
				audmapi.setText(configProps.getProperty("audmapi"));
				audmaci.setText(configProps.getProperty("audmaci"));
				audmasi.setText(configProps.getProperty("audmasi"));

				aurc.setSelected(getBoolean(configProps.getProperty("testAURetailer")));
				checkBoxMenuItem_164.setSelected(getBoolean(configProps.getProperty("AURupdate")));
				checkBoxMenuItem_165.setSelected(getBoolean(configProps.getProperty("AURcreation")));
				checkBoxMenuItem_166.setSelected(getBoolean(configProps.getProperty("AURpayment")));
				checkBoxMenuItem_167.setSelected(getBoolean(configProps.getProperty("AURlinks")));
				aurui.setText(configProps.getProperty("aurui"));
				aurpi.setText(configProps.getProperty("aurpi"));
				aursi.setText(configProps.getProperty("aursi"));

				auac.setSelected(getBoolean(configProps.getProperty("testAUAgent")));
				checkBoxMenuItem_168.setSelected(getBoolean(configProps.getProperty("AUAcreation")));
				checkBoxMenuItem_169.setSelected(getBoolean(configProps.getProperty("AUApayment")));
				checkBoxMenuItem_170.setSelected(getBoolean(configProps.getProperty("AUAlinks")));
				auaui.setText(configProps.getProperty("auaui"));
				auapi.setText(configProps.getProperty("auapi"));

				audc.setSelected(getBoolean(configProps.getProperty("testAUDist")));
				checkBoxMenuItem_171.setSelected(getBoolean(configProps.getProperty("AUDupdate")));
				checkBoxMenuItem_172.setSelected(getBoolean(configProps.getProperty("AUDcreation")));
				checkBoxMenuItem_173.setSelected(getBoolean(configProps.getProperty("AUDpayment")));
				checkBoxMenuItem_174.setSelected(getBoolean(configProps.getProperty("AUDlinks")));
				audui.setText(configProps.getProperty("audui"));
				audpi.setText(configProps.getProperty("audpi"));
				//audci.setText(configProps.getProperty("audci"));
				audsi.setText(configProps.getProperty("audsi"));

				ausc.setSelected(getBoolean(configProps.getProperty("testAUSagent")));
				checkBoxMenuItem_175.setSelected(getBoolean(configProps.getProperty("AUSupdate")));
				checkBoxMenuItem_176.setSelected(getBoolean(configProps.getProperty("AUScreation")));
				checkBoxMenuItem_177.setSelected(getBoolean(configProps.getProperty("AUSpayment")));
				checkBoxMenuItem_178.setSelected(getBoolean(configProps.getProperty("AUSlinks")));
				ausui.setText(configProps.getProperty("ausui"));
				auspi.setText(configProps.getProperty("auspi"));
				
				/* if any checkboxes are selected within a country tab, turn the country green */ 
				if(jiraqab){
					jirabtn.setForeground(new Color(0, 128, 0));
					jiras=true;
				}else{
					jirabtn.setForeground(Color.RED);
					jiras=false;
				}
				if(ukcb||ukmb||ukrb||ukab||ukdb||uksb||ukdmab){
					ukbtn.setForeground(new Color(0, 128, 0));
					uks=true;
				}else{
					ukbtn.setForeground(Color.RED);
					uks=false;
				}
				if(cacb||camb||carb||caab||cadb||casb||cadmab){
					cabtn.setForeground(new Color(0, 128, 0));
					cas=true;
				}else{
					cabtn.setForeground(Color.RED);
					cas=false;
				}
				if(hkcb||hkmb||hkrb||hkab||hkdb||hksb||hkdmab){
					hkbtn.setForeground(new Color(0, 128, 0));
					hks=true;
				}else{
					hkbtn.setForeground(Color.RED);
					hks=false;
				}
				if(escb||esmb||esrb||esab||esdb||essb||esdmab){
					esbtn.setForeground(new Color(0, 128, 0));
					ess=true;
				}else{
					esbtn.setForeground(Color.RED);
					ess=false;
				}
				if(sgcb||sgmb||sgrb||sgab||sgdb||sgsb||sgdmab){
					sgbtn.setForeground(new Color(0, 128, 0));
					sgs=true;
				}else{
					sgbtn.setForeground(Color.RED);
					sgs=false;
				}
				if(decb||demb||derb||deab||dedb||desb||dedmab){
					debtn.setForeground(new Color(0, 128, 0));
					des=true;
				}else{
					debtn.setForeground(Color.RED);
					des=false;
				}
				if(aucb||aumb||aurb||auab||audb||ausb||audmab){
					aubtn.setForeground(new Color(0, 128, 0));
					aus=true;
				}else{
					aubtn.setForeground(Color.RED);
					aus=false;
				}
			}
		}); // end green 
		/* set placement of load button 
		 * load.setBound(left, right, up, down) */ 
		load.setBounds(10, 306, 70, 23);
		/* add load button */ 
		mainPanel.add(load);
		
		/* define save button */ 
		JButton save = new JButton("Save");
		save.setFont(new Font("Calibri", Font.PLAIN, 12));
		/* listener waits for save button to be pressed, if pressed, do the events below */ 
		/* SAVE BUTTON saves changes to the GUI to the config file */ 
		save.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				configProps.setProperty("testJira", String.valueOf(jiraqa.isSelected()));
				configProps.setProperty("jiraUsr", jiraUsr.getText());
				configProps.setProperty("jiraPw", jiraPw.getText());
				configProps.setProperty("jticket", jiraqai.getText());
				configProps.setProperty("jversion", qaversion.getText());
				configProps.setProperty("rb", String.valueOf(rb.isSelected()));
				configProps.setProperty("rb1", String.valueOf(rb1.isSelected()));
				configProps.setProperty("rb2", String.valueOf(rb2.isSelected()));
				configProps.setProperty("rb3", String.valueOf(rb3.isSelected()));
				configProps.setProperty("rb4", String.valueOf(rb4.isSelected()));
				configProps.setProperty("rb5", String.valueOf(rb5.isSelected()));
				configProps.setProperty("rb6", String.valueOf(rb6.isSelected()));
				
				configProps.setProperty("testUKCustomer", String.valueOf(ukcc.isSelected()));
				configProps.setProperty("UKCupdate", String.valueOf(checkBoxMenuItem_12.isSelected()));
				configProps.setProperty("UKCpayment", String.valueOf(checkBoxMenuItem_14.isSelected()));
				configProps.setProperty("UKClinks", String.valueOf(checkBoxMenuItem_15.isSelected()));
				configProps.setProperty("UKCcreation", String.valueOf(chckbxmntmNewCheckItem1.isSelected()));
				configProps.setProperty("ukcui", ukcui.getText());
				configProps.setProperty("ukcpi", ukcpi.getText());
				configProps.setProperty("ukcci", ukcci.getText());
				
				configProps.setProperty("testUKMobile", String.valueOf(ukmc.isSelected()));
				configProps.setProperty("UKMupdate", String.valueOf(checkBoxMenuItem_16.isSelected()));
				configProps.setProperty("UKMpayment", String.valueOf(checkBoxMenuItem_18.isSelected()));
				configProps.setProperty("UKMlinks", String.valueOf(checkBoxMenuItem_19.isSelected()));
				configProps.setProperty("UKMcreation", String.valueOf(chckbxmntmNewCheckItem_2.isSelected()));
				configProps.setProperty("ukmui", ukmui.getText());
				configProps.setProperty("ukmpi", ukmpi.getText());
				configProps.setProperty("ukmci", ukmci.getText());
				
				configProps.setProperty("testUKRetailer", String.valueOf(ukrc.isSelected()));
				configProps.setProperty("UKRupdate", String.valueOf(checkBoxMenuItem.isSelected()));
				configProps.setProperty("UKRcreation", String.valueOf(checkBoxMenuItem_1.isSelected()));
				configProps.setProperty("UKRpayment", String.valueOf(checkBoxMenuItem_2.isSelected()));
				configProps.setProperty("UKRlinks", String.valueOf(checkBoxMenuItem_3.isSelected()));
				configProps.setProperty("ukrui", ukrui.getText());
				configProps.setProperty("ukrpi", ukrpi.getText());
				
				configProps.setProperty("testUKAgent", String.valueOf(ukac.isSelected()));
				configProps.setProperty("UKAcreation", String.valueOf(checkBoxMenuItem_5.isSelected()));
				configProps.setProperty("UKApayment", String.valueOf(checkBoxMenuItem_6.isSelected()));
				configProps.setProperty("UKAlinks", String.valueOf(checkBoxMenuItem_7.isSelected()));
				configProps.setProperty("ukaui", ukaui.getText());
				configProps.setProperty("ukapi", ukapi.getText());
				configProps.setProperty("ukaci", ukaci.getText());
				
				configProps.setProperty("testUKDist", String.valueOf(ukdc.isSelected()));
				configProps.setProperty("UKDupdate", String.valueOf(checkBoxMenuItem_8.isSelected()));
				configProps.setProperty("UKDcreation", String.valueOf(checkBoxMenuItem_9.isSelected()));
				configProps.setProperty("UKDpayment", String.valueOf(checkBoxMenuItem_10.isSelected()));
				configProps.setProperty("UKDlinks", String.valueOf(checkBoxMenuItem_11.isSelected()));
				configProps.setProperty("ukdui", ukdui.getText());
				configProps.setProperty("ukdpi", ukdpi.getText());
				configProps.setProperty("ukdci", ukdci.getText());
				
				configProps.setProperty("testUKSagent", String.valueOf(uksc.isSelected()));
				configProps.setProperty("UKSupdate", String.valueOf(cb1.isSelected()));
				configProps.setProperty("UKScreation", String.valueOf(cb2.isSelected()));
				configProps.setProperty("UKSpayment", String.valueOf(cb3.isSelected()));
				configProps.setProperty("UKSlinks", String.valueOf(cb4.isSelected()));
				configProps.setProperty("uksui", uksui.getText());
				configProps.setProperty("ukspi", ukspi.getText());
				//configProps.setProperty("uksci", uksci.getText());
				
				configProps.setProperty("testUKDMA", String.valueOf(ukdmac.isSelected()));
				configProps.setProperty("UKDMAupdate", String.valueOf(checkBoxMenuItem_13.isSelected()));
				configProps.setProperty("UKDMAcreation", String.valueOf(checkBoxMenuItem_17.isSelected()));
				configProps.setProperty("UKDMApayment", String.valueOf(checkBoxMenuItem_20.isSelected()));
				configProps.setProperty("UKDAlinks", String.valueOf(checkBoxMenuItem_21.isSelected()));
				configProps.setProperty("ukdmaui", ukdmaui.getText());
				configProps.setProperty("ukdmapi", ukdmapi.getText());
				configProps.setProperty("ukdmaci", ukdmaci.getText());
				
				configProps.setProperty("testCACustomer", String.valueOf(cacc.isSelected()));
				configProps.setProperty("CACupdate", String.valueOf(checkBoxMenuItem_22.isSelected()));
				configProps.setProperty("CACpayment", String.valueOf(checkBoxMenuItem_24.isSelected()));
				configProps.setProperty("CAClinks", String.valueOf(checkBoxMenuItem_25.isSelected()));
				configProps.setProperty("CACcreation", String.valueOf(chckbxmntmNewCheckItem1.isSelected()));
				configProps.setProperty("cacui", cacui.getText());
				configProps.setProperty("cacpi", cacpi.getText());
				configProps.setProperty("cacci", cacci.getText());
				configProps.setProperty("cacsi", cacsi.getText());
				
				configProps.setProperty("testCAMobile", String.valueOf(camc.isSelected()));
				configProps.setProperty("CAMupdate", String.valueOf(checkBoxMenuItem_26.isSelected()));
				configProps.setProperty("CAMpayment", String.valueOf(checkBoxMenuItem_28.isSelected()));
				configProps.setProperty("CAMlinks", String.valueOf(checkBoxMenuItem_29.isSelected()));
				configProps.setProperty("CAMcreation", String.valueOf(chckbxmntmNewCheckItem_1.isSelected()));
				configProps.setProperty("camui", camui.getText());
				configProps.setProperty("campi", campi.getText());
				configProps.setProperty("camci", camci.getText());
				configProps.setProperty("camsi", camsi.getText());
				
				configProps.setProperty("testCADMA", String.valueOf(cadmac.isSelected()));
				configProps.setProperty("CADMAupdate", String.valueOf(checkBoxMenuItem_30.isSelected()));
				configProps.setProperty("CADMAcreation", String.valueOf(checkBoxMenuItem_31.isSelected()));
				configProps.setProperty("CADMApayment", String.valueOf(checkBoxMenuItem_32.isSelected()));
				configProps.setProperty("CADMAlinks", String.valueOf(checkBoxMenuItem_33.isSelected()));
				configProps.setProperty("cadmaui", cadmaui.getText());
				configProps.setProperty("cadmapi", cadmapi.getText());
				configProps.setProperty("cadmaci", cadmaci.getText());
				configProps.setProperty("cadmasi", cadmasi.getText());
				
				configProps.setProperty("testCARetailer", String.valueOf(carc.isSelected()));
				configProps.setProperty("CARupdate", String.valueOf(checkBoxMenuItem_34.isSelected()));
				configProps.setProperty("CARcreation", String.valueOf(checkBoxMenuItem_35.isSelected()));
				configProps.setProperty("CARpayment", String.valueOf(checkBoxMenuItem_36.isSelected()));
				configProps.setProperty("CARlinks", String.valueOf(checkBoxMenuItem_37.isSelected()));
				configProps.setProperty("carui", carui.getText());
				configProps.setProperty("carpi", carpi.getText());
				configProps.setProperty("carsi", carsi.getText());
				
				configProps.setProperty("testCAAgent", String.valueOf(caac.isSelected()));
				configProps.setProperty("CAAcreation", String.valueOf(checkBoxMenuItem_39.isSelected()));
				configProps.setProperty("CAApayment", String.valueOf(checkBoxMenuItem_40.isSelected()));
				configProps.setProperty("CAAlinks", String.valueOf(checkBoxMenuItem_41.isSelected()));
				configProps.setProperty("caaui", caaui.getText());
				configProps.setProperty("caapi", caapi.getText());
				configProps.setProperty("caaci", caaci.getText());
				
				configProps.setProperty("testCADist", String.valueOf(cadc.isSelected()));
				configProps.setProperty("CADupdate", String.valueOf(checkBoxMenuItem_42.isSelected()));
				configProps.setProperty("CADcreation", String.valueOf(checkBoxMenuItem_43.isSelected()));
				configProps.setProperty("CADpayment", String.valueOf(checkBoxMenuItem_44.isSelected()));
				configProps.setProperty("CADlinks", String.valueOf(checkBoxMenuItem_45.isSelected()));
				configProps.setProperty("cadui", cadui.getText());
				configProps.setProperty("cadpi", cadpi.getText());
				//configProps.setProperty("cadci", cadci.getText());
				configProps.setProperty("cadsi", cadsi.getText());
				
				configProps.setProperty("testCASagent", String.valueOf(casc.isSelected()));
				configProps.setProperty("CASupdate", String.valueOf(checkBoxMenuItem_46.isSelected()));
				configProps.setProperty("CAScreation", String.valueOf(checkBoxMenuItem_47.isSelected()));
				configProps.setProperty("CASpayment", String.valueOf(checkBoxMenuItem_48.isSelected()));
				configProps.setProperty("CASlinks", String.valueOf(checkBoxMenuItem_49.isSelected()));
				configProps.setProperty("casui", casui.getText());
				configProps.setProperty("caspi", caspi.getText());
				//configProps.setProperty("casci", casci.getText());
				//configProps.setProperty("cassi", cassi.getText());
				
				configProps.setProperty("testHKCustomer", String.valueOf(hkcc.isSelected()));
				configProps.setProperty("HKCupdate", String.valueOf(checkBoxMenuItem_50.isSelected()));
				configProps.setProperty("HKCpayment", String.valueOf(checkBoxMenuItem_52.isSelected()));
				configProps.setProperty("HKClinks", String.valueOf(checkBoxMenuItem_53.isSelected()));
				configProps.setProperty("HKCcreation", String.valueOf(chckbxmntmNewCheckItem_3.isSelected()));
				configProps.setProperty("hkcui", hkcui.getText());
				configProps.setProperty("hkcpi", hkcpi.getText());
				configProps.setProperty("hkcci", hkcci.getText());
				configProps.setProperty("hkcsi", hkcsi.getText());
			////	
				configProps.setProperty("testHKMobile", String.valueOf(hkmc.isSelected()));
				configProps.setProperty("HKMupdate", String.valueOf(checkBoxMenuItem_54.isSelected()));
				configProps.setProperty("HKMpayment", String.valueOf(checkBoxMenuItem_56.isSelected()));
				configProps.setProperty("HKMlinks", String.valueOf(checkBoxMenuItem_57.isSelected()));
				configProps.setProperty("HKMcreation", String.valueOf(chckbxmntmNewCheckItem_4.isSelected()));
				configProps.setProperty("hkmui", hkmui.getText());
				configProps.setProperty("hkmpi", hkmpi.getText());
				configProps.setProperty("hkmci", hkmci.getText());
				configProps.setProperty("hkmsi", hkmsi.getText());
				
				configProps.setProperty("testHKDMA", String.valueOf(hkdmac.isSelected()));
				configProps.setProperty("HKDMAupdate", String.valueOf(checkBoxMenuItem_58.isSelected()));
				configProps.setProperty("HKDMAcreation", String.valueOf(checkBoxMenuItem_59.isSelected()));
				configProps.setProperty("HKDMApayment", String.valueOf(checkBoxMenuItem_60.isSelected()));
				configProps.setProperty("HKDMAlinks", String.valueOf(checkBoxMenuItem_61.isSelected()));
				configProps.setProperty("hkdmaui", hkdmaui.getText());
				configProps.setProperty("hkdmapi", hkdmapi.getText());
				configProps.setProperty("hkdmaci", hkdmaci.getText());
				configProps.setProperty("hkdmasi", hkdmasi.getText());
				
				configProps.setProperty("testHKRetailer", String.valueOf(hkrc.isSelected()));
				configProps.setProperty("HKRupdate", String.valueOf(checkBoxMenuItem_62.isSelected()));
				configProps.setProperty("HKRcreation", String.valueOf(checkBoxMenuItem_63.isSelected()));
				configProps.setProperty("HKRpayment", String.valueOf(checkBoxMenuItem_64.isSelected()));
				configProps.setProperty("HKRlinks", String.valueOf(checkBoxMenuItem_65.isSelected()));
				configProps.setProperty("hkrui", hkrui.getText());
				configProps.setProperty("hkrpi", hkrpi.getText());
				configProps.setProperty("hkrsi", hkrsi.getText());
				
				configProps.setProperty("testHKAgent", String.valueOf(hkac.isSelected()));
				configProps.setProperty("HKAcreation", String.valueOf(checkBoxMenuItem_67.isSelected()));
				configProps.setProperty("HKApayment", String.valueOf(checkBoxMenuItem_68.isSelected()));
				configProps.setProperty("HKAlinks", String.valueOf(checkBoxMenuItem_69.isSelected()));
				configProps.setProperty("hkaui", hkaui.getText());
				configProps.setProperty("hkapi", hkapi.getText());
				
				configProps.setProperty("testHKDist", String.valueOf(hkdc.isSelected()));
				configProps.setProperty("HKDupdate", String.valueOf(checkBoxMenuItem_70.isSelected()));
				configProps.setProperty("HKDcreation", String.valueOf(checkBoxMenuItem_71.isSelected()));
				configProps.setProperty("HKDpayment", String.valueOf(checkBoxMenuItem_72.isSelected()));
				configProps.setProperty("HKDlinks", String.valueOf(checkBoxMenuItem_73.isSelected()));
				configProps.setProperty("hkdui", hkdui.getText());
				configProps.setProperty("hkdpi", hkdpi.getText());
				//configProps.setProperty("hkdci", hkdci.getText());
				configProps.setProperty("hkdsi", hkdsi.getText());
				
				configProps.setProperty("testHKSagent", String.valueOf(hksc.isSelected()));
				configProps.setProperty("HKSupdate", String.valueOf(checkBoxMenuItem_74.isSelected()));
				configProps.setProperty("HKScreation", String.valueOf(checkBoxMenuItem_75.isSelected()));
				configProps.setProperty("HKSpayment", String.valueOf(checkBoxMenuItem_76.isSelected()));
				configProps.setProperty("HKSlinks", String.valueOf(checkBoxMenuItem_77.isSelected()));
				configProps.setProperty("hksui", hksui.getText());
				configProps.setProperty("hkspi", hkspi.getText());
				//configProps.setProperty("hksci", hksci.getText());
				//configProps.setProperty("hkssi", hkssi.getText());
				
				configProps.setProperty("testSGCustomer", String.valueOf(sgcc.isSelected()));
				configProps.setProperty("SGCupdate", String.valueOf(checkBoxMenuItem_4.isSelected()));
				configProps.setProperty("SGCpayment", String.valueOf(checkBoxMenuItem_23.isSelected()));
				configProps.setProperty("SGClinks", String.valueOf(checkBoxMenuItem_27.isSelected()));
				configProps.setProperty("SGCcreation", String.valueOf(checkBoxMenuItem_38.isSelected()));
				configProps.setProperty("sgcui", sgcui.getText());
				configProps.setProperty("sgcpi", sgcpi.getText());
				configProps.setProperty("sgcci", sgcci.getText());
				configProps.setProperty("sgcsi", sgcsi.getText());
				////	
				configProps.setProperty("testSGMobile", String.valueOf(sgmc.isSelected()));
				configProps.setProperty("SGMupdate", String.valueOf(checkBoxMenuItem_51.isSelected()));
				configProps.setProperty("SGMpayment", String.valueOf(checkBoxMenuItem_55.isSelected()));
				configProps.setProperty("SGMlinks", String.valueOf(checkBoxMenuItem_66.isSelected()));
				configProps.setProperty("SGMcreation", String.valueOf(checkBoxMenuItem_78.isSelected()));
				configProps.setProperty("sgmui", sgmui.getText());
				configProps.setProperty("sgmpi", sgmpi.getText());
				configProps.setProperty("sgmci", sgmci.getText());
				configProps.setProperty("sgmsi", sgmsi.getText());

				configProps.setProperty("testSGDMA", String.valueOf(sgdmac.isSelected()));
				configProps.setProperty("SGDMAupdate", String.valueOf(checkBoxMenuItem_79.isSelected()));
				configProps.setProperty("SGDMAcreation", String.valueOf(checkBoxMenuItem_80.isSelected()));
				configProps.setProperty("SGDMApayment", String.valueOf(checkBoxMenuItem_81.isSelected()));
				configProps.setProperty("SGDMAlinks", String.valueOf(checkBoxMenuItem_82.isSelected()));
				configProps.setProperty("sgdmaui", sgdmaui.getText());
				configProps.setProperty("sgdmapi", sgdmapi.getText());
				configProps.setProperty("sgdmaci", sgdmaci.getText());
				configProps.setProperty("sgdmasi", sgdmasi.getText());

				configProps.setProperty("testSGRetailer", String.valueOf(sgrc.isSelected()));
				configProps.setProperty("SGRupdate", String.valueOf(checkBoxMenuItem_83.isSelected()));
				configProps.setProperty("SGRcreation", String.valueOf(checkBoxMenuItem_84.isSelected()));
				configProps.setProperty("SGRpayment", String.valueOf(checkBoxMenuItem_85.isSelected()));
				configProps.setProperty("SGRlinks", String.valueOf(checkBoxMenuItem_86.isSelected()));
				configProps.setProperty("sgrui", sgrui.getText());
				configProps.setProperty("sgrpi", sgrpi.getText());
				configProps.setProperty("sgrsi", sgrsi.getText());

				configProps.setProperty("testSGAgent", String.valueOf(sgac.isSelected()));
				configProps.setProperty("SGAcreation", String.valueOf(checkBoxMenuItem_95.isSelected()));
				configProps.setProperty("SGApayment", String.valueOf(checkBoxMenuItem_96.isSelected()));
				configProps.setProperty("SGAlinks", String.valueOf(checkBoxMenuItem_97.isSelected()));
				configProps.setProperty("sgaui", sgaui.getText());
				configProps.setProperty("sgapi", sgapi.getText());

				configProps.setProperty("testSGDist", String.valueOf(sgdc.isSelected()));
				configProps.setProperty("SGDupdate", String.valueOf(checkBoxMenuItem_87.isSelected()));
				configProps.setProperty("SGDcreation", String.valueOf(checkBoxMenuItem_88.isSelected()));
				configProps.setProperty("SGDpayment", String.valueOf(checkBoxMenuItem_89.isSelected()));
				configProps.setProperty("SGDlinks", String.valueOf(checkBoxMenuItem_90.isSelected()));
				configProps.setProperty("sgdui", sgdui.getText());
				configProps.setProperty("sgdpi", sgdpi.getText());
				//configProps.setProperty("sgdci", sgdci.getText());
				configProps.setProperty("sgdsi", sgdsi.getText());

				configProps.setProperty("testSGSagent", String.valueOf(sgsc.isSelected()));
				configProps.setProperty("SGSupdate", String.valueOf(checkBoxMenuItem_91.isSelected()));
				configProps.setProperty("SGScreation", String.valueOf(checkBoxMenuItem_92.isSelected()));
				configProps.setProperty("SGSpayment", String.valueOf(checkBoxMenuItem_93.isSelected()));
				configProps.setProperty("SGSlinks", String.valueOf(checkBoxMenuItem_94.isSelected()));
				configProps.setProperty("sgsui", sgsui.getText());
				configProps.setProperty("sgspi", sgspi.getText());
				//configProps.setProperty("sgsci", sgsci.getText());
				//configProps.setProperty("sgssi", sgssi.getText());
				
				configProps.setProperty("testESCustomer", String.valueOf(escc.isSelected()));
				configProps.setProperty("ESCupdate", String.valueOf(checkBoxMenuItem_98.isSelected()));
				configProps.setProperty("ESCpayment", String.valueOf(checkBoxMenuItem_99.isSelected()));
				configProps.setProperty("ESClinks", String.valueOf(checkBoxMenuItem_100.isSelected()));
				configProps.setProperty("ESCcreation", String.valueOf(checkBoxMenuItem_101.isSelected()));
				configProps.setProperty("escui", escui.getText());
				configProps.setProperty("escpi", escpi.getText());
				configProps.setProperty("escci", escci.getText());
				configProps.setProperty("escsi", escsi.getText());
				////	
				configProps.setProperty("testESMobile", String.valueOf(esmc.isSelected()));
				configProps.setProperty("ESMupdate", String.valueOf(checkBoxMenuItem_102.isSelected()));
				configProps.setProperty("ESMpayment", String.valueOf(checkBoxMenuItem_103.isSelected()));
				configProps.setProperty("ESMlinks", String.valueOf(checkBoxMenuItem_104.isSelected()));
				configProps.setProperty("ESMcreation", String.valueOf(checkBoxMenuItem_105.isSelected()));
				configProps.setProperty("esmui", esmui.getText());
				configProps.setProperty("esmpi", esmpi.getText());
				configProps.setProperty("esmci", esmci.getText());
				configProps.setProperty("esmsi", esmsi.getText());

				configProps.setProperty("testESDMA", String.valueOf(esdmac.isSelected()));
				configProps.setProperty("ESDMAupdate", String.valueOf(checkBoxMenuItem_106.isSelected()));
				configProps.setProperty("ESDMAcreation", String.valueOf(checkBoxMenuItem_107.isSelected()));
				configProps.setProperty("ESDMApayment", String.valueOf(checkBoxMenuItem_108.isSelected()));
				configProps.setProperty("ESDMAlinks", String.valueOf(checkBoxMenuItem_109.isSelected()));
				configProps.setProperty("esdmaui", esdmaui.getText());
				configProps.setProperty("esdmapi", esdmapi.getText());
				configProps.setProperty("esdmaci", esdmaci.getText());
				configProps.setProperty("esdmasi", esdmasi.getText());

				configProps.setProperty("testESRetailer", String.valueOf(esrc.isSelected()));
				configProps.setProperty("ESRupdate", String.valueOf(checkBoxMenuItem_110.isSelected()));
				configProps.setProperty("ESRcreation", String.valueOf(checkBoxMenuItem_111.isSelected()));
				configProps.setProperty("ESRpayment", String.valueOf(checkBoxMenuItem_112.isSelected()));
				configProps.setProperty("ESRlinks", String.valueOf(checkBoxMenuItem_113.isSelected()));
				configProps.setProperty("esrui", esrui.getText());
				configProps.setProperty("esrpi", esrpi.getText());
				configProps.setProperty("esrsi", esrsi.getText());

				configProps.setProperty("testESAgent", String.valueOf(esac.isSelected()));
				configProps.setProperty("ESAcreation", String.valueOf(checkBoxMenuItem_115.isSelected()));
				configProps.setProperty("ESApayment", String.valueOf(checkBoxMenuItem_116.isSelected()));
				configProps.setProperty("ESAlinks", String.valueOf(checkBoxMenuItem_117.isSelected()));
				configProps.setProperty("esaui", esaui.getText());
				configProps.setProperty("esapi", esapi.getText());

				configProps.setProperty("testESDist", String.valueOf(esdc.isSelected()));
				configProps.setProperty("ESDupdate", String.valueOf(checkBoxMenuItem_118.isSelected()));
				configProps.setProperty("ESDcreation", String.valueOf(checkBoxMenuItem_119.isSelected()));
				configProps.setProperty("ESDpayment", String.valueOf(checkBoxMenuItem_120.isSelected()));
				configProps.setProperty("ESDlinks", String.valueOf(checkBoxMenuItem_121.isSelected()));
				configProps.setProperty("esdui", esdui.getText());
				configProps.setProperty("esdpi", esdpi.getText());
				//configProps.setProperty("esdci", esdci.getText());
				configProps.setProperty("esdsi", esdsi.getText());

				configProps.setProperty("testESSagent", String.valueOf(essc.isSelected()));
				configProps.setProperty("ESSupdate", String.valueOf(checkBoxMenuItem_122.isSelected()));
				configProps.setProperty("ESScreation", String.valueOf(checkBoxMenuItem_123.isSelected()));
				configProps.setProperty("ESSpayment", String.valueOf(checkBoxMenuItem_124.isSelected()));
				configProps.setProperty("ESSlinks", String.valueOf(checkBoxMenuItem_125.isSelected()));
				configProps.setProperty("essui", essui.getText());
				configProps.setProperty("esspi", esspi.getText());
				//configProps.setProperty("essci", essci.getText());
				//configProps.setProperty("esssi", esssi.getText());
				
				configProps.setProperty("testDECustomer", String.valueOf(decc.isSelected()));
				configProps.setProperty("DECupdate", String.valueOf(checkBoxMenuItem_114.isSelected()));
				configProps.setProperty("DECpayment", String.valueOf(checkBoxMenuItem_126.isSelected()));
				configProps.setProperty("DEClinks", String.valueOf(checkBoxMenuItem_127.isSelected()));
				configProps.setProperty("DECcreation", String.valueOf(checkBoxMenuItem_128.isSelected()));
				configProps.setProperty("decui", decui.getText());
				configProps.setProperty("decpi", decpi.getText());
				configProps.setProperty("decci", decci.getText());
				configProps.setProperty("decsi", decsi.getText());
				////	
				configProps.setProperty("testDEMobile", String.valueOf(demc.isSelected()));
				configProps.setProperty("DEMupdate", String.valueOf(checkBoxMenuItem_129.isSelected()));
				configProps.setProperty("DEMpayment", String.valueOf(checkBoxMenuItem_130.isSelected()));
				configProps.setProperty("DEMlinks", String.valueOf(checkBoxMenuItem_131.isSelected()));
				configProps.setProperty("DEMcreation", String.valueOf(checkBoxMenuItem_132.isSelected()));
				configProps.setProperty("demui", demui.getText());
				configProps.setProperty("dempi", dempi.getText());
				configProps.setProperty("demci", demci.getText());
				configProps.setProperty("demsi", demsi.getText());

				configProps.setProperty("testDEDMA", String.valueOf(dedmac.isSelected()));
				configProps.setProperty("DEDMAupdate", String.valueOf(checkBoxMenuItem_133.isSelected()));
				configProps.setProperty("DEDMAcreation", String.valueOf(checkBoxMenuItem_134.isSelected()));
				configProps.setProperty("DEDMApayment", String.valueOf(checkBoxMenuItem_135.isSelected()));
				configProps.setProperty("DEDMAlinks", String.valueOf(checkBoxMenuItem_136.isSelected()));
				configProps.setProperty("dedmaui", dedmaui.getText());
				configProps.setProperty("dedmapi", dedmapi.getText());
				configProps.setProperty("dedmaci", dedmaci.getText());
				configProps.setProperty("dedmasi", dedmasi.getText());

				configProps.setProperty("testDERetailer", String.valueOf(derc.isSelected()));
				configProps.setProperty("DERupdate", String.valueOf(checkBoxMenuItem_137.isSelected()));
				configProps.setProperty("DERcreation", String.valueOf(checkBoxMenuItem_138.isSelected()));
				configProps.setProperty("DERpayment", String.valueOf(checkBoxMenuItem_139.isSelected()));
				configProps.setProperty("DERlinks", String.valueOf(checkBoxMenuItem_140.isSelected()));
				configProps.setProperty("derui", derui.getText());
				configProps.setProperty("derpi", derpi.getText());
				configProps.setProperty("dersi", dersi.getText());

				configProps.setProperty("testDEAgent", String.valueOf(deac.isSelected()));
				configProps.setProperty("DEAcreation", String.valueOf(checkBoxMenuItem_141.isSelected()));
				configProps.setProperty("DEApayment", String.valueOf(checkBoxMenuItem_142.isSelected()));
				configProps.setProperty("DEAlinks", String.valueOf(checkBoxMenuItem_143.isSelected()));
				configProps.setProperty("deaui", deaui.getText());
				configProps.setProperty("deapi", deapi.getText());
				configProps.setProperty("deasi", deasi.getText());

				configProps.setProperty("testDEDist", String.valueOf(dedc.isSelected()));
				configProps.setProperty("DEDupdate", String.valueOf(checkBoxMenuItem_144.isSelected()));
				configProps.setProperty("DEDcreation", String.valueOf(checkBoxMenuItem_145.isSelected()));
				configProps.setProperty("DEDpayment", String.valueOf(checkBoxMenuItem_146.isSelected()));
				configProps.setProperty("DEDlinks", String.valueOf(checkBoxMenuItem_147.isSelected()));
				configProps.setProperty("dedui", dedui.getText());
				configProps.setProperty("dedpi", dedpi.getText());
				//configProps.setProperty("dedci", dedci.getText());
				configProps.setProperty("dedsi", dedsi.getText());

				configProps.setProperty("testDESagent", String.valueOf(desc.isSelected()));
				configProps.setProperty("DESupdate", String.valueOf(checkBoxMenuItem_148.isSelected()));
				configProps.setProperty("DEScreation", String.valueOf(checkBoxMenuItem_149.isSelected()));
				configProps.setProperty("DESpayment", String.valueOf(checkBoxMenuItem_150.isSelected()));
				configProps.setProperty("DESlinks", String.valueOf(checkBoxMenuItem_151.isSelected()));
				configProps.setProperty("desui", desui.getText());
				configProps.setProperty("despi", despi.getText());
				//configProps.setProperty("desci", desci.getText());
				//configProps.setProperty("dessi", dessi.getText());
				
				configProps.setProperty("testAUCustomer", String.valueOf(aucc.isSelected()));
				configProps.setProperty("AUCupdate", String.valueOf(checkBoxMenuItem_152.isSelected()));
				configProps.setProperty("AUCpayment", String.valueOf(checkBoxMenuItem_153.isSelected()));
				configProps.setProperty("AUClinks", String.valueOf(checkBoxMenuItem_154.isSelected()));
				configProps.setProperty("AUCcreation", String.valueOf(checkBoxMenuItem_155.isSelected()));
				configProps.setProperty("aucui", aucui.getText());
				configProps.setProperty("aucpi", aucpi.getText());
				configProps.setProperty("aucci", aucci.getText());
				configProps.setProperty("aucsi", aucsi.getText());
				////	
				configProps.setProperty("testAUMobile", String.valueOf(aumc.isSelected()));
				configProps.setProperty("AUMupdate", String.valueOf(checkBoxMenuItem_156.isSelected()));
				configProps.setProperty("AUMpayment", String.valueOf(checkBoxMenuItem_157.isSelected()));
				configProps.setProperty("AUMlinks", String.valueOf(checkBoxMenuItem_158.isSelected()));
				configProps.setProperty("AUMcreation", String.valueOf(checkBoxMenuItem_159.isSelected()));
				configProps.setProperty("aumui", aumui.getText());
				configProps.setProperty("aumpi", aumpi.getText());
				configProps.setProperty("aumci", aumci.getText());
				configProps.setProperty("aumsi", aumsi.getText());

				configProps.setProperty("testAUDMA", String.valueOf(audmac.isSelected()));
				configProps.setProperty("AUDMAupdate", String.valueOf(checkBoxMenuItem_160.isSelected()));
				configProps.setProperty("AUDMAcreation", String.valueOf(checkBoxMenuItem_161.isSelected()));
				configProps.setProperty("AUDMApayment", String.valueOf(checkBoxMenuItem_162.isSelected()));
				configProps.setProperty("AUDMAlinks", String.valueOf(checkBoxMenuItem_163.isSelected()));
				configProps.setProperty("audmaui", audmaui.getText());
				configProps.setProperty("audmapi", audmapi.getText());
				configProps.setProperty("audmaci", audmaci.getText());
				configProps.setProperty("audmasi", audmasi.getText());

				configProps.setProperty("testAURetailer", String.valueOf(aurc.isSelected()));
				configProps.setProperty("AURupdate", String.valueOf(checkBoxMenuItem_164.isSelected()));
				configProps.setProperty("AURcreation", String.valueOf(checkBoxMenuItem_165.isSelected()));
				configProps.setProperty("AURpayment", String.valueOf(checkBoxMenuItem_166.isSelected()));
				configProps.setProperty("AURlinks", String.valueOf(checkBoxMenuItem_167.isSelected()));
				configProps.setProperty("aurui", aurui.getText());
				configProps.setProperty("aurpi", aurpi.getText());
				configProps.setProperty("aursi", aursi.getText());

				configProps.setProperty("testAUAgent", String.valueOf(auac.isSelected()));
				configProps.setProperty("AUAcreation", String.valueOf(checkBoxMenuItem_168.isSelected()));
				configProps.setProperty("AUApayment", String.valueOf(checkBoxMenuItem_169.isSelected()));
				configProps.setProperty("AUAlinks", String.valueOf(checkBoxMenuItem_170.isSelected()));
				configProps.setProperty("auaui", auaui.getText());
				configProps.setProperty("auapi", auapi.getText());

				configProps.setProperty("testAUDist", String.valueOf(audc.isSelected()));
				configProps.setProperty("AUDupdate", String.valueOf(checkBoxMenuItem_171.isSelected()));
				configProps.setProperty("AUDcreation", String.valueOf(checkBoxMenuItem_172.isSelected()));
				configProps.setProperty("AUDpayment", String.valueOf(checkBoxMenuItem_173.isSelected()));
				configProps.setProperty("AUDlinks", String.valueOf(checkBoxMenuItem_174.isSelected()));
				configProps.setProperty("audui", audui.getText());
				configProps.setProperty("audpi", audpi.getText());
				//configProps.setProperty("audci", audci.getText());
				configProps.setProperty("audsi", audsi.getText());

				configProps.setProperty("testAUSagent", String.valueOf(ausc.isSelected()));
				configProps.setProperty("AUSupdate", String.valueOf(checkBoxMenuItem_175.isSelected()));
				configProps.setProperty("AUScreation", String.valueOf(checkBoxMenuItem_176.isSelected()));
				configProps.setProperty("AUSpayment", String.valueOf(checkBoxMenuItem_177.isSelected()));
				configProps.setProperty("AUSlinks", String.valueOf(checkBoxMenuItem_178.isSelected()));
				configProps.setProperty("ausui", ausui.getText());
				configProps.setProperty("auspi", auspi.getText());
				//configProps.setProperty("ausci", ausci.getText());
				//configProps.setProperty("aussi", aussi.getText());
			
				/* actually saves the values we got from the save function to config file by calling saveProperties  */ 
				try {
					saveProperties();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}); // end save 
		
		/* define locatin of save button */ 
		save.setBounds(85, 306, 70, 23);
		/* adds save button */ 
		mainPanel.add(save);
		
	
		/* loads properties to be ran */ 	
		try {
			loadP();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
		}
	
	}

	/* Sets properties and loads information from config file */ 
	private void loadP() throws IOException{
		Properties defaultProps = new Properties();
		// sets default properties
		defaultProps.setProperty("testJira", "false");
		defaultProps.setProperty("jiraUsr", "Username");
		defaultProps.setProperty("jiraPw", "");
		defaultProps.setProperty("jticket", "Ticket");
		defaultProps.setProperty("jversion", "BOSS Version");
		defaultProps.setProperty("rb", "true");
		defaultProps.setProperty("rb1", "false");
		defaultProps.setProperty("rb2", "false");
		defaultProps.setProperty("rb3", "false");
		defaultProps.setProperty("rb4", "false");
		defaultProps.setProperty("rb5", "false");
		defaultProps.setProperty("rb6", "false");
		
		defaultProps.setProperty("testUKCustomer", "false");
		defaultProps.setProperty("UKCupdate", "true");
		defaultProps.setProperty("UKCpayment", "true");
		defaultProps.setProperty("UKClinks", "true");
		defaultProps.setProperty("UKCcreation", "true");
		defaultProps.setProperty("ukcui", "Account #");
		defaultProps.setProperty("ukcpi", "Security Code");
		defaultProps.setProperty("ukcci", "CVV");
		
		defaultProps.setProperty("testUKMobile", "false");
		defaultProps.setProperty("UKMupdate", "true");
		defaultProps.setProperty("UKMpayment", "true");
		defaultProps.setProperty("UKMlinks", "true");
		defaultProps.setProperty("UKMcreation", "true");
		defaultProps.setProperty("ukmui", "Account #");
		defaultProps.setProperty("ukmpi", "Security Code");
		defaultProps.setProperty("ukmci", "CVV");
		
		defaultProps.setProperty("testUKRetailer", "false");
		defaultProps.setProperty("UKRupdate", "true");
		defaultProps.setProperty("UKRcreation", "true");
		defaultProps.setProperty("UKRpayment", "true");
		defaultProps.setProperty("UKRlinks", "true");
		defaultProps.setProperty("ukrui", "Account #");
		defaultProps.setProperty("ukrpi", "Security Code");
		
		defaultProps.setProperty("testUKAgent", "false");
		defaultProps.setProperty("UKAcreation", "true");
		defaultProps.setProperty("UKApayment", "true");
		defaultProps.setProperty("UKAlinks", "true");
		defaultProps.setProperty("ukaui", "Account #");
		defaultProps.setProperty("ukapi", "Security Code");
		defaultProps.setProperty("ukaci", "Security Answer");
		
		defaultProps.setProperty("testUKDist", "false");
		defaultProps.setProperty("UKDupdate", "true");
		defaultProps.setProperty("UKDcreation", "true");
		defaultProps.setProperty("UKDpayment", "true");
		defaultProps.setProperty("UKDlinks", "true");
		defaultProps.setProperty("ukdui", "Account #");
		defaultProps.setProperty("ukdpi", "Security Code");
		defaultProps.setProperty("ukdci", "Security Answer");
		
		defaultProps.setProperty("testUKSagent", "false");
		defaultProps.setProperty("UKSupdate", "true");
		defaultProps.setProperty("UKScreation", "true");
		defaultProps.setProperty("UKSpayment", "true");
		defaultProps.setProperty("UKSlinks", "true");
		defaultProps.setProperty("uksui", "Account #");
		defaultProps.setProperty("ukspi", "Security Code");
		defaultProps.setProperty("uksci", "CVV");
		
		defaultProps.setProperty("testUKDMA", "false");
		defaultProps.setProperty("UKDMAupdate", "true");
		defaultProps.setProperty("UKDMAcreation", "true");
		defaultProps.setProperty("UKDMApayment", "true");
		defaultProps.setProperty("UKDMAlinks", "true");
		defaultProps.setProperty("ukdmaui", "Account #");
		defaultProps.setProperty("ukdmapi", "Security Code");
		defaultProps.setProperty("ukdmaci", "CVV");
		
		defaultProps.setProperty("testCACustomer", "false");
		defaultProps.setProperty("CACupdate", "true");
		defaultProps.setProperty("CACpayment", "true");
		defaultProps.setProperty("CAClinks", "true");
		defaultProps.setProperty("CACcreation", "true");
		defaultProps.setProperty("cacui", "Account #");
		defaultProps.setProperty("cacpi", "Security Code");
		defaultProps.setProperty("cacci", "CVV");
		defaultProps.setProperty("cacsi", "Security Answer");
		
		defaultProps.setProperty("testCAMobile", "false");
		defaultProps.setProperty("CAMupdate", "true");
		defaultProps.setProperty("CAMpayment", "true");
		defaultProps.setProperty("CAMlinks", "true");
		defaultProps.setProperty("CAMcreation", "true");
		defaultProps.setProperty("camui", "Account #");
		defaultProps.setProperty("campi", "Security Code");
		defaultProps.setProperty("camci", "CVV");
		defaultProps.setProperty("camsi", "Security Answer");
		
		defaultProps.setProperty("testCADMA", "false");
		defaultProps.setProperty("CADMAupdate", "true");
		defaultProps.setProperty("CADMAcreation", "true");
		defaultProps.setProperty("CADMApayment", "true");
		defaultProps.setProperty("CADMAlinks", "true");
		defaultProps.setProperty("chckbxmntmNewCheckItem_1", "true");
		defaultProps.setProperty("cadmaui", "Account #");
		defaultProps.setProperty("cadmapi", "Security Code");
		defaultProps.setProperty("cadmaci", "CVV");
		defaultProps.setProperty("cadmasi", "Security Answer");
		
		defaultProps.setProperty("testCARetailer", "false");
		defaultProps.setProperty("CARupdate", "true");
		defaultProps.setProperty("CARcreation", "true");
		defaultProps.setProperty("CARpayment", "true");
		defaultProps.setProperty("CARlinks", "true");
		defaultProps.setProperty("carui", "Account #");
		defaultProps.setProperty("carpi", "Security Code");
		defaultProps.setProperty("carsi", "Security Answer");
		
		defaultProps.setProperty("testCAAgent", "false");
		defaultProps.setProperty("CAAcreation", "true");
		defaultProps.setProperty("CAApayment", "true");
		defaultProps.setProperty("CAAlinks", "true");
		defaultProps.setProperty("caaui", "Account #");
		defaultProps.setProperty("caapi", "Security Code");
		defaultProps.setProperty("caaci", "Security Answer");
		
		defaultProps.setProperty("testCADist", "false");
		defaultProps.setProperty("CADupdate", "true");
		defaultProps.setProperty("CADcreation", "true");
		defaultProps.setProperty("CADpayment", "true");
		defaultProps.setProperty("CADlinks", "true");
		defaultProps.setProperty("cadui", "Account #");
		defaultProps.setProperty("cadpi", "Security Code");
		defaultProps.setProperty("cadci", "CVV");
		defaultProps.setProperty("cadsi", "Security Answer");
		
		defaultProps.setProperty("testCASagent", "false");
		defaultProps.setProperty("CASupdate", "true");
		defaultProps.setProperty("CAScreation", "true");
		defaultProps.setProperty("CASpayment", "true");
		defaultProps.setProperty("CASlinks", "true");
		defaultProps.setProperty("casui", "Account #");
		defaultProps.setProperty("caspi", "Security Code");
		defaultProps.setProperty("casci", "CVV");
		defaultProps.setProperty("cassi", "Security Answer");
		
		defaultProps.setProperty("testHKCustomer", "false");
		defaultProps.setProperty("HKCupdate", "true");
		defaultProps.setProperty("HKCpayment", "true");
		defaultProps.setProperty("HKClinks", "true");
		defaultProps.setProperty("HKCcreation", "true");
		defaultProps.setProperty("hkcui", "Account #");
		defaultProps.setProperty("hkcpi", "Security Code");
		defaultProps.setProperty("hkcci", "CVV");
		defaultProps.setProperty("hkcsi", "Security Answer");
		
		defaultProps.setProperty("testHKMobile", "false");
		defaultProps.setProperty("HKMupdate", "true");
		defaultProps.setProperty("HKMpayment", "true");
		defaultProps.setProperty("HKMlinks", "true");
		defaultProps.setProperty("HKMcreation", "true");
		defaultProps.setProperty("hkmui", "Account #");
		defaultProps.setProperty("hkmpi", "Security Code");
		defaultProps.setProperty("hkmci", "CVV");
		defaultProps.setProperty("hkmsi", "Security Answer");
		
		defaultProps.setProperty("testHKDMA", "false");
		defaultProps.setProperty("HKDMAupdate", "true");
		defaultProps.setProperty("HKDMAcreation", "true");
		defaultProps.setProperty("HKDMApayment", "true");
		defaultProps.setProperty("HKDMAlinks", "true");
		defaultProps.setProperty("hkdmaui", "Account #");
		defaultProps.setProperty("hkdmapi", "Security Code");
		defaultProps.setProperty("hkdmaci", "CVV");
		defaultProps.setProperty("hkdmasi", "Security Answer");
		
		defaultProps.setProperty("testHKRetailer", "false");
		defaultProps.setProperty("HKRupdate", "true");
		defaultProps.setProperty("HKRcreation", "true");
		defaultProps.setProperty("HKRpayment", "true");
		defaultProps.setProperty("HKRlinks", "true");
		defaultProps.setProperty("hkrui", "Account #");
		defaultProps.setProperty("hkrpi", "Security Code");
		defaultProps.setProperty("hkrsi", "Security Answer");
		
		defaultProps.setProperty("testHKAgent", "false");
		defaultProps.setProperty("HKAcreation", "true");
		defaultProps.setProperty("HKApayment", "true");
		defaultProps.setProperty("HKAlinks", "true");
		defaultProps.setProperty("hkaui", "Account #");
		defaultProps.setProperty("hkapi", "Security Code");
		
		defaultProps.setProperty("testHKDist", "false");
		defaultProps.setProperty("HKDupdate", "true");
		defaultProps.setProperty("HKDcreation", "true");
		defaultProps.setProperty("HKDpayment", "true");
		defaultProps.setProperty("HKDlinks", "true");
		defaultProps.setProperty("hkdui", "Account #");
		defaultProps.setProperty("hkdpi", "Security Code");
		defaultProps.setProperty("hkdci", "CVV");
		defaultProps.setProperty("hkdsi", "Security Answer");
		
		defaultProps.setProperty("testHKSagent", "false");
		defaultProps.setProperty("HKSupdate", "true");
		defaultProps.setProperty("HKScreation", "true");
		defaultProps.setProperty("HKSpayment", "true");
		defaultProps.setProperty("HKSlinks", "true");
		defaultProps.setProperty("hksui", "Account #");
		defaultProps.setProperty("hkspi", "Security Code");
		defaultProps.setProperty("hksci", "CVV");
		defaultProps.setProperty("hkssi", "Security Answer");
		
		
		
		defaultProps.setProperty("testSGCustomer", "false");
		defaultProps.setProperty("SGCupdate", "true");
		defaultProps.setProperty("SGCpayment", "true");
		defaultProps.setProperty("SGClinks", "true");
		defaultProps.setProperty("SGCcreation", "true");
		defaultProps.setProperty("sgcui", "Account #");
		defaultProps.setProperty("sgcpi", "Security Code");
		defaultProps.setProperty("sgcci", "CVV");
		defaultProps.setProperty("sgcsi", "Security Answer");

		defaultProps.setProperty("testSGMobile", "false");
		defaultProps.setProperty("SGMupdate", "true");
		defaultProps.setProperty("SGMpayment", "true");
		defaultProps.setProperty("SGMlinks", "true");
		defaultProps.setProperty("SGMcreation", "true");
		defaultProps.setProperty("sgmui", "Account #");
		defaultProps.setProperty("sgmpi", "Security Code");
		defaultProps.setProperty("sgmci", "CVV");
		defaultProps.setProperty("sgmsi", "Security Answer");

		defaultProps.setProperty("testSGDMA", "false");
		defaultProps.setProperty("SGDMAupdate", "true");
		defaultProps.setProperty("SGDMAcreation", "true");
		defaultProps.setProperty("SGDMApayment", "true");
		defaultProps.setProperty("SGDMAlinks", "true");
		defaultProps.setProperty("sgdmaui", "Account #");
		defaultProps.setProperty("sgdmapi", "Security Code");
		defaultProps.setProperty("sgdmaci", "CVV");
		defaultProps.setProperty("sgdmasi", "Security Answer");

		defaultProps.setProperty("testSGRetailer", "false");
		defaultProps.setProperty("SGRupdate", "true");
		defaultProps.setProperty("SGRcreation", "true");
		defaultProps.setProperty("SGRpayment", "true");
		defaultProps.setProperty("SGRlinks", "true");
		defaultProps.setProperty("sgrui", "Account #");
		defaultProps.setProperty("sgrpi", "Security Code");
		defaultProps.setProperty("sgrsi", "Security Answer");

		defaultProps.setProperty("testSGAgent", "false");
		defaultProps.setProperty("SGAcreation", "true");
		defaultProps.setProperty("SGApayment", "true");
		defaultProps.setProperty("SGAlinks", "true");
		defaultProps.setProperty("sgaui", "Account #");
		defaultProps.setProperty("sgapi", "Security Code");

		defaultProps.setProperty("testSGDist", "false");
		defaultProps.setProperty("SGDupdate", "true");
		defaultProps.setProperty("SGDcreation", "true");
		defaultProps.setProperty("SGDpayment", "true");
		defaultProps.setProperty("SGDlinks", "true");
		defaultProps.setProperty("sgdui", "Account #");
		defaultProps.setProperty("sgdpi", "Security Code");
		defaultProps.setProperty("sgdci", "CVV");
		defaultProps.setProperty("sgdsi", "Security Answer");

		defaultProps.setProperty("testSGSagent", "false");
		defaultProps.setProperty("SGSupdate", "true");
		defaultProps.setProperty("SGScreation", "true");
		defaultProps.setProperty("SGSpayment", "true");
		defaultProps.setProperty("SGSlinks", "true");
		defaultProps.setProperty("sgsui", "Account #");
		defaultProps.setProperty("sgspi", "Security Code");
		defaultProps.setProperty("sgsci", "CVV");
		defaultProps.setProperty("sgssi", "Security Answer");
		
		
		
		defaultProps.setProperty("testESCustomer", "false");
		defaultProps.setProperty("ESCupdate", "true");
		defaultProps.setProperty("ESCpayment", "true");
		defaultProps.setProperty("ESClinks", "true");
		defaultProps.setProperty("ESCcreation", "true");
		defaultProps.setProperty("escui", "Account #");
		defaultProps.setProperty("escpi", "Security Code");
		defaultProps.setProperty("escci", "CVV");
		defaultProps.setProperty("escsi", "Security Answer");

		defaultProps.setProperty("testESMobile", "false");
		defaultProps.setProperty("ESMupdate", "true");
		defaultProps.setProperty("ESMpayment", "true");
		defaultProps.setProperty("ESMlinks", "true");
		defaultProps.setProperty("ESMcreation", "true");
		defaultProps.setProperty("esmui", "Account #");
		defaultProps.setProperty("esmpi", "Security Code");
		defaultProps.setProperty("esmci", "CVV");
		defaultProps.setProperty("esmsi", "Security Answer");

		defaultProps.setProperty("testESDMA", "false");
		defaultProps.setProperty("ESDMAupdate", "true");
		defaultProps.setProperty("ESDMAcreation", "true");
		defaultProps.setProperty("ESDMApayment", "true");
		defaultProps.setProperty("ESDMAlinks", "true");
		defaultProps.setProperty("esdmaui", "Account #");
		defaultProps.setProperty("esdmapi", "Security Code");
		defaultProps.setProperty("esdmaci", "CVV");
		defaultProps.setProperty("esdmasi", "Security Answer");

		defaultProps.setProperty("testESRetailer", "false");
		defaultProps.setProperty("ESRupdate", "true");
		defaultProps.setProperty("ESRcreation", "true");
		defaultProps.setProperty("ESRpayment", "true");
		defaultProps.setProperty("ESRlinks", "true");
		defaultProps.setProperty("esrui", "Account #");
		defaultProps.setProperty("esrpi", "Security Code");
		defaultProps.setProperty("esrsi", "Security Answer");

		defaultProps.setProperty("testESAgent", "false");
		defaultProps.setProperty("ESAcreation", "true");
		defaultProps.setProperty("ESApayment", "true");
		defaultProps.setProperty("ESAlinks", "true");
		defaultProps.setProperty("esaui", "Account #");
		defaultProps.setProperty("esapi", "Security Code");

		defaultProps.setProperty("testESDist", "false");
		defaultProps.setProperty("ESDupdate", "true");
		defaultProps.setProperty("ESDcreation", "true");
		defaultProps.setProperty("ESDpayment", "true");
		defaultProps.setProperty("ESDlinks", "true");
		defaultProps.setProperty("esdui", "Account #");
		defaultProps.setProperty("esdpi", "Security Code");
		defaultProps.setProperty("esdci", "CVV");
		defaultProps.setProperty("esdsi", "Security Answer");

		defaultProps.setProperty("testESSagent", "false");
		defaultProps.setProperty("ESSupdate", "true");
		defaultProps.setProperty("ESScreation", "true");
		defaultProps.setProperty("ESSpayment", "true");
		defaultProps.setProperty("ESSlinks", "true");
		defaultProps.setProperty("essui", "Account #");
		defaultProps.setProperty("esspi", "Security Code");
		defaultProps.setProperty("essci", "CVV");
		defaultProps.setProperty("esssi", "Security Answer");
		
		defaultProps.setProperty("testDECustomer", "false");
		defaultProps.setProperty("DECupdate", "true");
		defaultProps.setProperty("DECpayment", "true");
		defaultProps.setProperty("DEClinks", "true");
		defaultProps.setProperty("DECcreation", "true");
		defaultProps.setProperty("decui", "Account #");
		defaultProps.setProperty("decpi", "Security Code");
		defaultProps.setProperty("decci", "CVV");
		defaultProps.setProperty("decsi", "Security Answer");

		defaultProps.setProperty("testDEMobile", "false");
		defaultProps.setProperty("DEMupdate", "true");
		defaultProps.setProperty("DEMpayment", "true");
		defaultProps.setProperty("DEMlinks", "true");
		defaultProps.setProperty("DEMcreation", "true");
		defaultProps.setProperty("demui", "Account #");
		defaultProps.setProperty("dempi", "Security Code");
		defaultProps.setProperty("demci", "CVV");
		defaultProps.setProperty("demsi", "Security Answer");

		defaultProps.setProperty("testDEDMA", "false");
		defaultProps.setProperty("DEDMAupdate", "true");
		defaultProps.setProperty("DEDMAcreation", "true");
		defaultProps.setProperty("DEDMApayment", "true");
		defaultProps.setProperty("DEDMAlinks", "true");
		defaultProps.setProperty("dedmaui", "Account #");
		defaultProps.setProperty("dedmapi", "Security Code");
		defaultProps.setProperty("dedmaci", "CVV");
		defaultProps.setProperty("dedmasi", "Security Answer");

		defaultProps.setProperty("testDERetailer", "false");
		defaultProps.setProperty("DERupdate", "true");
		defaultProps.setProperty("DERcreation", "true");
		defaultProps.setProperty("DERpayment", "true");
		defaultProps.setProperty("DERlinks", "true");
		defaultProps.setProperty("derui", "Account #");
		defaultProps.setProperty("derpi", "Security Code");
		defaultProps.setProperty("dersi", "Security Answer");

		defaultProps.setProperty("testDEAgent", "false");
		defaultProps.setProperty("DEAcreation", "true");
		defaultProps.setProperty("DEApayment", "true");
		defaultProps.setProperty("DEAlinks", "true");
		defaultProps.setProperty("deaui", "Account #");
		defaultProps.setProperty("deapi", "Security Code");
		defaultProps.setProperty("deasi", "Security Answer");

		defaultProps.setProperty("testDEDist", "false");
		defaultProps.setProperty("DEDupdate", "true");
		defaultProps.setProperty("DEDcreation", "true");
		defaultProps.setProperty("DEDpayment", "true");
		defaultProps.setProperty("DEDlinks", "true");
		defaultProps.setProperty("dedui", "Account #");
		defaultProps.setProperty("dedpi", "Security Code");
		defaultProps.setProperty("dedci", "CVV");
		defaultProps.setProperty("dedsi", "Security Answer");

		defaultProps.setProperty("testDESagent", "false");
		defaultProps.setProperty("DESupdate", "true");
		defaultProps.setProperty("DEScreation", "true");
		defaultProps.setProperty("DESpayment", "true");
		defaultProps.setProperty("DESlinks", "true");
		defaultProps.setProperty("desui", "Account #");
		defaultProps.setProperty("despi", "Security Code");
		defaultProps.setProperty("desci", "CVV");
		defaultProps.setProperty("dessi", "Security Answer");
		
		defaultProps.setProperty("testAUCustomer", "false");
		defaultProps.setProperty("AUCupdate", "true");
		defaultProps.setProperty("AUCpayment", "true");
		defaultProps.setProperty("AUClinks", "true");
		defaultProps.setProperty("AUCcreation", "true");
		defaultProps.setProperty("aucui", "Account #");
		defaultProps.setProperty("aucpi", "Security Code");
		defaultProps.setProperty("aucci", "CVV");
		defaultProps.setProperty("aucsi", "Security Answer");

		defaultProps.setProperty("testAUMobile", "false");
		defaultProps.setProperty("AUMupdate", "true");
		defaultProps.setProperty("AUMpayment", "true");
		defaultProps.setProperty("AUMlinks", "true");
		defaultProps.setProperty("AUMcreation", "true");
		defaultProps.setProperty("aumui", "Account #");
		defaultProps.setProperty("aumpi", "Security Code");
		defaultProps.setProperty("aumci", "CVV");
		defaultProps.setProperty("aumsi", "Security Answer");

		defaultProps.setProperty("testAUDMA", "false");
		defaultProps.setProperty("AUDMAupdate", "true");
		defaultProps.setProperty("AUDMAcreation", "true");
		defaultProps.setProperty("AUDMApayment", "true");
		defaultProps.setProperty("AUDMAlinks", "true");
		defaultProps.setProperty("audmaui", "Account #");
		defaultProps.setProperty("audmapi", "Security Code");
		defaultProps.setProperty("audmaci", "CVV");
		defaultProps.setProperty("audmasi", "Security Answer");

		defaultProps.setProperty("testAURetailer", "false");
		defaultProps.setProperty("AURupdate", "true");
		defaultProps.setProperty("AURcreation", "true");
		defaultProps.setProperty("AURpayment", "true");
		defaultProps.setProperty("AURlinks", "true");
		defaultProps.setProperty("aurui", "Account #");
		defaultProps.setProperty("aurpi", "Security Code");
		defaultProps.setProperty("aursi", "Security Answer");

		defaultProps.setProperty("testAUAgent", "false");
		defaultProps.setProperty("AUAcreation", "true");
		defaultProps.setProperty("AUApayment", "true");
		defaultProps.setProperty("AUAlinks", "true");
		defaultProps.setProperty("auaui", "Account #");
		defaultProps.setProperty("auapi", "Security Code");

		defaultProps.setProperty("testAUDist", "false");
		defaultProps.setProperty("AUDupdate", "true");
		defaultProps.setProperty("AUDcreation", "true");
		defaultProps.setProperty("AUDpayment", "true");
		defaultProps.setProperty("AUDlinks", "true");
		defaultProps.setProperty("audui", "Account #");
		defaultProps.setProperty("audpi", "Security Code");
		defaultProps.setProperty("audci", "CVV");
		defaultProps.setProperty("audsi", "Security Answer");

		defaultProps.setProperty("testAUSagent", "false");
		defaultProps.setProperty("AUSupdate", "true");
		defaultProps.setProperty("AUScreation", "true");
		defaultProps.setProperty("AUSpayment", "true");
		defaultProps.setProperty("AUSlinks", "true");
		defaultProps.setProperty("ausui", "Account #");
		defaultProps.setProperty("auspi", "Security Code");
		defaultProps.setProperty("ausci", "CVV");
		defaultProps.setProperty("aussi", "Security Answer");
		
		
		configProps = new Properties(defaultProps);

		/* loads properties from config file */  
		InputStream inputStream = new FileInputStream(configFile);
		configProps.load(inputStream);
		inputStream.close();
		

	}
	
	/* translates text to boolean */ 
	private boolean getBoolean(String q) {
		if(q.equals("true"))return true;
		return false;
	}

	/* ???????????????????????????????? does this do anything ??????????????????????????? */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	/* saves GUI changes into config file */ 
	private void saveProperties() throws IOException {
		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "BOSS Tester Configuration");
		outputStream.close();
	}
}
