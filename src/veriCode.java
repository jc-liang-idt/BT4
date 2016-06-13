import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class veriCode {
	private String mcode;
	private boolean got=false;
	private JFrame frmBossTester;
	private JTextField code;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					veriCode window = new veriCode();
					window.frmBossTester.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public veriCode() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public String gotIt(){
		while(!got){
    			try {
    				Thread.sleep(100);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
		}
		return mcode;
	}
	
	private void initialize() {
		frmBossTester = new JFrame();
		frmBossTester.setLocationRelativeTo(null);
		frmBossTester.setVisible(true);
		frmBossTester.setTitle("BOSS Tester");
		frmBossTester.setBounds(100, 100, 204, 135);
		frmBossTester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBossTester.getContentPane().setLayout(null);
		
		JLabel lblEnterMobileVerification = new JLabel("Enter Mobile Verification Code");
		lblEnterMobileVerification.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEnterMobileVerification.setBounds(10, 11, 230, 27);
		frmBossTester.getContentPane().add(lblEnterMobileVerification);
		
		code = new JTextField();
		code.setBounds(20, 49, 86, 27);
		frmBossTester.getContentPane().add(code);
		code.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(code.getText().equals(""))
					System.err.println("Enter a verification code");
				else{
					mcode = code.getText();
					got=true;
					frmBossTester.setVisible(false);
				}
			}
		});
		btnOk.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnOk.setBounds(117, 49, 47, 23);
		frmBossTester.getContentPane().add(btnOk);
	}
}
