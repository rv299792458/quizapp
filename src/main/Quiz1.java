package main;


import java.awt.EventQueue;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import db.Driver;
import net.proteanit.sql.DbUtils;

import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.*;
import javax.swing.JScrollBar;

public class Quiz1 implements ActionListener{

	private JFrame frame;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTextField UserNametext;
	private JPanel  LoginPanel,BackGroundPanel;
	private JPanel  SignUpPanel;
	private JPasswordField passtext;
	private JTextField unSignupText;
	private JTextField RollNoText;
	private JPasswordField PassText;
	private JPasswordField ConPassText;
	private JPanel HelpPanel,AdminPanel;
	//private JButton PreviewAdmin;
	private JPanel AbtPanel,PreviewPanel ;
	private Connection con;
	private String s1,s2,Admin="IMRV";
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField QuestionField,WrongAnsField3;
	private JTextField CorrectAnsField;
	private JTextField WrongAnsField1;
	private JTextField WrongAnsField2;
	private JTextField QuestionNoField;
	private JTable PTable;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz1 window = new Quiz1();
					window.frame.setVisible(true);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */ 
	public Quiz1() {
		
		con=Driver.createConnection();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 985, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//BackGroundPanel.setVisible(true);
		
		
		
		//-------------------------------------------------------------------------------------------------------login button
		
		JButton Loginbtn = new JButton("LOGIN");    
		Loginbtn.setBounds(464, 25, 97, 25);
		Loginbtn.addActionListener(this);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(Loginbtn);	
		
		//------------------------------------------------------------------------------------------------------login button close
		
		//------------------------------------------------------------------------------------------------------SignUp button
		JButton Signbtn = new JButton("SIGN-UP");	
		Signbtn.setBounds(598, 25, 97, 25);
		Signbtn.addActionListener(this);
		frame.getContentPane().add(Signbtn);	
		//----------------------------------------------------------------------------------------------------Sign up button close
		
		//-------------------------------------------------------------------------------------------------About button 
		
		JButton abtbtn = new JButton("ABOUT");
		abtbtn.addActionListener(this);
		abtbtn.setBounds(724, 25, 97, 25);
		/*abtbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel.setVisible(false);
				SignUpPanel.setVisible(false);
				AbtPanel.setVisible(true);
				HelpPanel.setVisible(false);
				BackGroundPanel.setVisible(false);
				PreviewPanel.setVisible(false);
				AdminPanel.setVisible(false);
			}
		});*/
		frame.getContentPane().add(abtbtn);
		
		//-------------------------------------------------------------------------------------------------About button close
		
		//-------------------------------------------------------------------------------------------------Help button 
		
		JButton help = new JButton("HELP");
		help.addActionListener(this);
		/*help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});*/
	
		help.setBounds(854, 25, 97, 25);
		frame.getContentPane().add(help);
		
		//-------------------------------------------------------------------------------------------------Help button close
		
		
		//-------------------------------------------------------------------------------------------------image taskbar
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 983, 75);
		lblNewLabel.setIcon(new ImageIcon(Quiz1.class.getResource("/com/images/tex2.jpg")));
		frame.getContentPane().add(lblNewLabel);
		layeredPane.setForeground(new Color(240, 248, 255));
		layeredPane.setBackground(new Color(240, 248, 255));
		//-------------------------------------------------------------------------------------------------image taskbar close
		
		//-------------------------------------------------------------------------------------------------Layered Pane
		
		layeredPane.setBounds(0, 74, 983, 472);
		frame.getContentPane().add(layeredPane);
		 layeredPane.setLayout(null);
		
		//-------------------------------------------------------------------------------------------------Sign up panel 
		 SignUpPanel = new JPanel();
		 SignUpPanel.setBounds(12, 13, 947, 443);
		 layeredPane.setLayer(SignUpPanel, 10);
		 layeredPane.add(SignUpPanel);
		 SignUpPanel.setOpaque(true);
		 SignUpPanel.setVisible(false);
		 SignUpPanel.setLayout(null);
		 
		 unSignupText = new JTextField();
		 unSignupText.setBounds(308, 54, 150, 30);
		 SignUpPanel.add(unSignupText);
		 unSignupText.setColumns(10);
		 
		 RollNoText = new JTextField();
		 RollNoText.setBounds(308, 110, 150, 30);
		 SignUpPanel.add(RollNoText);
		 RollNoText.setColumns(10);
		 
		 PassText = new JPasswordField();
		
		 PassText.setBounds(308, 165, 150, 28);
		 SignUpPanel.add(PassText);
		 //PassText.setEchoChar('*');
		 PassText.setColumns(10);
		 
		 ConPassText = new JPasswordField();
		 ConPassText.setBounds(311, 228, 147, 26);
		 SignUpPanel.add(ConPassText);
		 ConPassText.setColumns(10);
		// s1=ConPassText.getText();
		 
		 JButton SignUpbtnPanel = new JButton("Sign Up");
		  SignUpbtnPanel.setBounds(236, 302, 119, 38);
		  SignUpbtnPanel.addActionListener(this);
		 SignUpPanel.add(SignUpbtnPanel);
		 
		 JLabel lblNewLabel_1 = new JLabel("       UserName");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_1.setBounds(156, 53, 150, 30);
		 SignUpPanel.add(lblNewLabel_1);
		 
		 JLabel lblNewLabel_2 = new JLabel("        Roll no.");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2.setBounds(176, 109, 130, 30);
		 SignUpPanel.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("      Password");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_3.setBounds(176, 171, 130, 22);
		 SignUpPanel.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel("Comfirm Password");
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_4.setBounds(176, 228, 134, 26);
		 SignUpPanel.add(lblNewLabel_4);
		 
		 JLabel lblNewLabel_5 = new JLabel("");
		 lblNewLabel_5.setIcon(new ImageIcon(Quiz1.class.getResource("/com/images/exam2.jpg")));
		 lblNewLabel_5.setBounds(517, 13, 387, 417);
		 SignUpPanel.add(lblNewLabel_5);
		 JLabel lblSighback = new JLabel("");
		 lblSighback.setIcon(new ImageIcon(Quiz1.class.getResource("/com/images/backgrn.jpg")));
		 lblSighback.setBounds(0, 0, 947, 443);
			SignUpPanel.add( lblSighback);
		 
		 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++sign upPAnel close
		 
		 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++Login panel
		 
		 LoginPanel = new JPanel();
		 LoginPanel.setBounds(12, 13, 947, 443);
		 layeredPane.setLayer(LoginPanel, 1);
		layeredPane.add(LoginPanel);
		LoginPanel.setOpaque(true);
		LoginPanel.setVisible(false);
		LoginPanel.setLayout(null);
		
		UserNametext = new JTextField();
		UserNametext.setBounds(242, 51, 116, 22);
		UserNametext.setForeground(Color.RED);
		LoginPanel.add(UserNametext);
		UserNametext.setColumns(10);
		
		passtext = new JPasswordField();
		passtext.setBounds(242, 115, 116, 22);
		LoginPanel.add(passtext);
		passtext.setColumns(10);
		
		JButton loginBtnPanel = new JButton("Login");
	/*	loginBtnPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {String s1=UserNametext.getText();
						String s2=passtext.getText();
					String query="SELECT * FROM logintable WHERE Userename='s1' AND Password='s2'";
					 pst=con.prepareStatement(query); 
					// pst.setString(1,UserNametext.getText());
					// pst.setString(2,passtext.getText());
					 rs=pst.executeQuery();
					 int count=0;
					 while(rs.next())
						{
							count=count+1;
						}
						if(count==1)
							{JOptionPane.showMessageDialog(null, "UserName and Password is correct");
						//frame.dispose();
						     
						if(count>1)
							JOptionPane.showMessageDialog(null, " Duplicat UserName and Password ");
						else if(count<1)
							JOptionPane.showMessageDialog(null, "UserName and Password is not correct");
								rs.close();
								pst.close();
							}
				}
				catch(Exception ed){
					JOptionPane.showInternalMessageDialog(null,ed);
				}
				
			}
		});*/
		loginBtnPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBtnPanel.setBounds(150, 189, 158, 35);
		loginBtnPanel.addActionListener(this);
		LoginPanel.add(loginBtnPanel);
		
		JLabel lblNewLabel_6 = new JLabel("User Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(114, 49, 126, 25);
		LoginPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(114, 115, 116, 22);
		LoginPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(Quiz1.class.getResource("/com/images/Screenshot (91).jpg")));
		lblNewLabel_8.setBounds(453, 13, 482, 417);
		LoginPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(Quiz1.class.getResource("/com/images/backgrn.jpg")));
		lblNewLabel_9.setBounds(0, 0, 947, 443);
		LoginPanel.add(lblNewLabel_9);
		
		
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++Components of Login panel	(stop)
		
		 AbtPanel = new JPanel();
		 layeredPane.setLayer(AbtPanel, 9);
		 AbtPanel.setBounds(12, 13, 947, 443);
		layeredPane.add(AbtPanel);
		AbtPanel.setLayout(null);
		AbtPanel.setOpaque(true);
		AbtPanel.setVisible(false);
		
		JTextArea AbtText = new JTextArea();
		AbtText.setFont(new Font("Courier New", Font.BOLD, 18));
		AbtText.setLineWrap(true);
		AbtText.setEditable(false);
		AbtText.setText("The Application was created to replace the trend of pen-paper quiz"+
					"The application was created for a mini project in KIET group of Institution "
					+ "the Application is created by Rahul Verma  Under the Guidance of Rupam Kamarakar and miss Vibha Jain"
					+ "Any recommdation about the application is  welcomed");
		AbtText.setBounds(0, 0, 947, 443);
		AbtPanel.add(AbtText);
		
		HelpPanel = new JPanel();
		layeredPane.setLayer(HelpPanel, 9);
		HelpPanel.setBounds(12, 13, 947, 443);
		HelpPanel.setLayout(null);
		layeredPane.add(HelpPanel);
		HelpPanel.setOpaque(true);
		HelpPanel.setVisible(false);
		
		//JFileChooser j = new JFileChooser(new File("C:\\Users\\rv602\\Desktop\\java test.txt"));
		//File f=j.getSelectedFile();
		JTextArea HelpArea = new JTextArea();
		HelpArea.setFont(new Font("Courier New", Font.BOLD, 18));
		HelpArea.setLineWrap(true);
		HelpArea.setText("What is the name of this app?\r\n" + 
				" Ans:: RVQ ;\r\n" + 
				"What features does it provide?\r\n" + 
				" It provides a sign-up and login Panel for Student;\r\n" + 
				" It also provides a sign up panel and login panel for admin ;\r\n" + 
				"Also provides a panel to edit the database of the app for an Admin User;\r\n" + 
				"It provides a quiz app for time boundation set by the Developer for Student;\r\n" + 
				"And then all depends to your curiosity to discover and recommendations to consider;\r\n" + 
				"Our team is working on it and keep fine-tuning it.;  \r\n" + 
				"");
		HelpArea.setBounds(0, 0, 947, 443);
		HelpPanel.add(HelpArea);
		
		BackGroundPanel = new JPanel();//------------------------------------------------------------------------------background panel--------
		layeredPane.setLayer(BackGroundPanel, 5);
		BackGroundPanel.setBounds(0, 0, 983, 472);
		layeredPane.add(BackGroundPanel);
		BackGroundPanel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Quiz1.class.getResource("/com/images/Screenshot (92).png")));
		lblNewLabel_10.setBounds(0, 0, 983, 472);
		BackGroundPanel.add(lblNewLabel_10);
		
		AdminPanel = new JPanel();
		layeredPane.setLayer(AdminPanel, 8);
		AdminPanel.setBounds(0, 0, 983, 472);
		layeredPane.add(AdminPanel);
		AdminPanel.setLayout(null);
		AdminPanel.setOpaque(true);
		AdminPanel.setVisible(false);
		
		JLabel Question = new JLabel("Question ::");
		Question.setHorizontalAlignment(SwingConstants.RIGHT);
		Question.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Question.setBounds(64, 80, 154, 32);
		AdminPanel.add(Question);
		
		JLabel WrongAnswer2 = new JLabel("Wrong Answer 2::");
		WrongAnswer2.setHorizontalAlignment(SwingConstants.RIGHT);
		WrongAnswer2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		WrongAnswer2.setBounds(64, 230, 154, 32);
		AdminPanel.add(WrongAnswer2);
		
		JLabel CorrectAnswer = new JLabel("Correct Answer::");
		CorrectAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
		CorrectAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		CorrectAnswer.setBounds(64, 130, 154, 32);
		AdminPanel.add(CorrectAnswer);
		
		JLabel WrongAnswer3 = new JLabel("Wrong Answer 3::");
		WrongAnswer3.setHorizontalAlignment(SwingConstants.RIGHT);
		WrongAnswer3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		WrongAnswer3.setBounds(64, 275, 154, 32);
		AdminPanel.add(WrongAnswer3);
		
		JLabel WrongAnswer1 = new JLabel("Wrong Answer 1::");
		WrongAnswer1.setHorizontalAlignment(SwingConstants.RIGHT);
		WrongAnswer1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		WrongAnswer1.setBounds(64, 180, 154, 32);
		AdminPanel.add(WrongAnswer1);
		
		CorrectAnsField = new JTextField();
		CorrectAnsField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		CorrectAnsField.setBackground(SystemColor.info);
		CorrectAnsField.setBounds(230, 135, 670, 22);
		AdminPanel.add(CorrectAnsField);
		CorrectAnsField.setColumns(10);
		
		QuestionField = new JTextField();
		QuestionField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		QuestionField.setBackground(SystemColor.info);
		QuestionField.setBounds(230, 85, 670, 22);
		AdminPanel.add(QuestionField);
		QuestionField.setColumns(10);
		
		WrongAnsField1 = new JTextField();
		WrongAnsField1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		WrongAnsField1.setBackground(SystemColor.info);
		WrongAnsField1.setBounds(230, 185, 670, 22);
		AdminPanel.add(WrongAnsField1);
		WrongAnsField1.setColumns(10);
		
		WrongAnsField2 = new JTextField();
		WrongAnsField2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		WrongAnsField2.setBackground(SystemColor.info);
		WrongAnsField2.setBounds(230, 235, 670, 22);
		AdminPanel.add(WrongAnsField2);
		WrongAnsField2.setColumns(10);
		
		WrongAnsField3 = new JTextField();
		WrongAnsField3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		WrongAnsField3.setBackground(SystemColor.info);
		WrongAnsField3.setBounds(230, 285, 670, 22);
		AdminPanel.add(WrongAnsField3);
		WrongAnsField3.setColumns(10);
		
		QuestionNoField = new JTextField();
		QuestionNoField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		QuestionNoField.setBackground(SystemColor.info);
		QuestionNoField.setBounds(230, 37, 116, 22);
		AdminPanel.add(QuestionNoField);
		QuestionNoField.setColumns(10);
		
		JLabel QuestionNo = new JLabel("Question No.::");
		QuestionNo.setHorizontalAlignment(SwingConstants.RIGHT);
		QuestionNo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		QuestionNo.setBounds(64, 31, 154, 32);
		AdminPanel.add(QuestionNo);
		
		JButton SumbitAdmin = new JButton("Submit");
		SumbitAdmin.addActionListener(this) ;
	
		SumbitAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		SumbitAdmin.setBounds(64, 355, 120, 32);
		AdminPanel.add(SumbitAdmin);
		
		JButton UpdateAdmin = new JButton("Update");
		UpdateAdmin.addActionListener(this) ;
		UpdateAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		UpdateAdmin.setBounds(244, 355, 120, 32);
		AdminPanel.add(UpdateAdmin);
		
		JButton DeleteAdmin = new JButton("Delete");
		DeleteAdmin.addActionListener(this); 
		
		DeleteAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		DeleteAdmin.setBounds(424, 355, 120, 32);
		AdminPanel.add(DeleteAdmin);
		
		JButton ExitAdmin = new JButton("Exit");
		ExitAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		ExitAdmin.setBounds(785, 355, 120, 32);
		AdminPanel.add(ExitAdmin);
		
		 JButton PreviewAdmin = new JButton("Preview");
		PreviewAdmin.addActionListener(this);
		PreviewAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		PreviewAdmin.setBounds(604, 355, 120, 32);
		AdminPanel.add(PreviewAdmin);
		
		JButton btnNewButton_2 = new JButton(" Next.");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_2.setBounds(64, 400, 120, 32);
		AdminPanel.add(btnNewButton_2);
		 btnNewButton_2.addActionListener(this);
		
		
		
		JLabel ImageLable = new JLabel("New label");
		ImageLable.setIcon(new ImageIcon(Quiz1.class.getResource("/com/images/backgrn.jpg")));
		ImageLable.setBounds(12, 13, 947, 443);
		AdminPanel.add(ImageLable);
		
		PreviewPanel = new JPanel();
		layeredPane.setLayer(PreviewPanel, 11);
		PreviewPanel.setBounds(0, 0, 983, 472);
		layeredPane.add(PreviewPanel);
		PreviewPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 942, 433);
		PreviewPanel.add(panel);
		panel.setLayout(null);
		
		PTable = new JTable();
		PTable.setBounds(0, 0, 942, 365);
		panel.add(PTable);
		
		JButton BackButton = new JButton("BACK");
		BackButton.setBounds(425, 378, 97, 25);
		panel.add(BackButton);
		BackButton.addActionListener(this);
		PreviewPanel.setVisible(false);
		PreviewPanel.setVisible(false);
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@action for sign up butoon
		// TODO Auto-generated method stub
		String caption =e.getActionCommand();
		System.out.println(s1);
		System.out.println(s2);
		if(caption.equals("Sign Up"))
		{	s2=PassText.getText();
			s1=ConPassText.getText();
			if(s1.equals(s2))
			{
				
			try {
				
		 		String query="insert into logintable values (?,?,?,?)";                                      //insert a value in Mysql
				PreparedStatement pst=con.prepareStatement(query);
			
				pst.setInt(1, 0);
				pst.setString(2,unSignupText.getText());
				pst.setString(3,s2);
				pst.setString(4,RollNoText.getText());
				
				int row =pst.executeUpdate();
				if(row>0){
					System.out.println("ok1");
				}
				
				JOptionPane.showMessageDialog(null, "Data Saved");
				pst.close();
		 		}catch(SQLException ec)
		 		{
		 			System.out.println(ec);
		 		}
			}else
			{
				JOptionPane.showMessageDialog(null,"Enter the correct Password");
			}
		}
		 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@action for signup button closed
	
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@action for Login button closed
		if(caption.equals("Login"))
		{	
			
			
			System.out.println("getit");
			try {  
				
			String s3=UserNametext.getText();
			String s4=passtext.getText();
			System.out.println(s3+s4);
		
			String query="SELECT * FROM logintable WHERE Userename='"+s3+"' AND Password='"+s4+"'";
		 pst=con.prepareStatement(query); 
		 rs=pst.executeQuery();
		 int count=0;
		 while(rs.next())
			{
				count=count+1;
			}
			if(count==1)
			{	if(s4.equals(Admin))//------------------------------------------------------------------------------------------------Admin Panel Start
				{
				AdminPanel.setVisible(true);
				}//------------------------------------------------------------------------------------------------Admin Panel Stop
			else {
				JOptionPane.showMessageDialog(null, "UserName and Password is correct");
				frame.dispose();
				AfterLogin al=new AfterLogin();
				al.SomeVal(s3,s4);
				al.setVisible(true);
			}
			
			}
			     
			if(count>1)
				JOptionPane.showMessageDialog(null, " Duplicat UserName and Password ");
			else if(count<1)
				JOptionPane.showMessageDialog(null, "UserName and Password is not correct");
					rs.close();
					pst.close();
				}
	
	catch(Exception ed){
		System.out.println(ed);
	}
		}
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Action for Login button closed
		//-----------------------------------------------------------------------------Action button for Submit Admin
		if(caption.equals("Submit"))
		{	System.out.println("ok3");
			
			try {
				String query2="insert into maintable values (?,?,?,?,?,?,?)";
				PreparedStatement pst2=con.prepareStatement(query2);
				pst2.setInt(1,0);
				pst2.setString(2,QuestionField.getText());
				pst2.setString(3,CorrectAnsField.getText());
				pst2.setString(4,WrongAnsField1.getText());
				pst2.setString(5,WrongAnsField2.getText());
				pst2.setString(6,WrongAnsField3.getText());
				pst2.setString(7,QuestionNoField.getText());
				int row2=pst2.executeUpdate();
				
				if(row2>0)
					{
						JOptionPane.showMessageDialog(null,"Question Saved");
					}
				
				}catch(Exception SS) {
					System.out.println(SS);
								}
		}
		 if(caption.equals("Update"))
		
		{
			try {
				String query2="update maintable set Questions='"+QuestionField.getText()+"',Option1='"+CorrectAnsField.getText()+"',Option2='"+WrongAnsField1.getText()+"',Option3='"+WrongAnsField2.getText()+"',Option4='"+WrongAnsField3.getText()+"' where no='"+QuestionNoField.getText()+"'";
				PreparedStatement pst2=con.prepareStatement(query2);
				pst2.executeUpdate();
				JOptionPane.showMessageDialog(null,"Question Updated");
				}
			catch(Exception em) {
				JOptionPane.showMessageDialog(null,em);
								}
		}
		if(caption.equals("LOGIN"))
		{	System.out.println("LOGIN");
			LoginPanel.setVisible(true);
			SignUpPanel.setVisible(false);
			AbtPanel.setVisible(false);
			HelpPanel.setVisible(false);
			BackGroundPanel.setVisible(false);
			PreviewPanel.setVisible(false);
			AdminPanel.setVisible(false);
		}
		if(caption.equals("Delete"))
		{
			try {
				String query2="delete from  maintable where no=?";
				PreparedStatement pst2=con.prepareStatement(query2);
				pst2.setString(1,QuestionNoField.getText());
				pst2.executeUpdate();
				JOptionPane.showMessageDialog(null,"Question Deleted");
				}
			catch(Exception em) {
				JOptionPane.showMessageDialog(null,em);
								}
		}
		if(caption.equals("Preview"))
		{   
			System.out.println("TB0");
			try {System.out.println("TB1");
				PreviewPanel.setVisible(true);
				System.out.println("TB2");
				String query3="select * from maintable";
				System.out.println("TB3");
				PreparedStatement pst2=con.prepareStatement(query3);
				ResultSet rs=pst2.executeQuery();
				PTable.setModel(DbUtils.resultSetToTableModel(rs));
				//System.out.println("TB4");
				 
				//System.out.println("TB6");
				PTable.setVisible(true);
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(null,e1);
			}
		}
		if(caption.equals("SIGN-UP"))
		{	//System.out.println("Signup");
			LoginPanel.setVisible(false);
			SignUpPanel.setVisible(true);
			AbtPanel.setVisible(false);
			HelpPanel.setVisible(false);
			BackGroundPanel.setVisible(false);
			PreviewPanel.setVisible(false);
			AdminPanel.setVisible(false);
		}
		if(caption.equals("ABOUT"))
		{
			LoginPanel.setVisible(false);
			SignUpPanel.setVisible(false);
		
			HelpPanel.setVisible(false);
			BackGroundPanel.setVisible(false);
			PreviewPanel.setVisible(false);
			AdminPanel.setVisible(false);
			AbtPanel.setVisible(true);
		}
		if(caption.equals("HELP"))
		{
			LoginPanel.setVisible(false);
			SignUpPanel.setVisible(false);
			AbtPanel.setVisible(false);
			HelpPanel.setVisible(true);
			BackGroundPanel.setVisible(false);
			PreviewPanel.setVisible(false);
			AdminPanel.setVisible(false);
		}
		if(caption.equals("Next."))
		{
			AdminPanel.setVisible(true);
			QuestionNoField.setText("");
			CorrectAnsField.setText("");
			QuestionField.setText("");
			WrongAnsField1.setText("");
			WrongAnsField2.setText("");
			WrongAnsField3.setText("");
			try {
				String query2="insert into maintable values (?,?,?,?,?,?,?)";
				PreparedStatement pst2=con.prepareStatement(query2);
				pst2.setInt(1,0);
				pst2.setString(2,QuestionField.getText());
				pst2.setString(3,CorrectAnsField.getText());
				pst2.setString(4,WrongAnsField1.getText());
				pst2.setString(5,WrongAnsField2.getText());
				pst2.setString(6,WrongAnsField3.getText());
				pst2.setString(7,QuestionNoField.getText());
				int row2=pst2.executeUpdate();
				
				if(row2>0)
					{
						JOptionPane.showMessageDialog(null,"Question Saved");
					}
				
				}catch(Exception SS) {
					System.out.println(SS);
								}
			
		}
		if(caption.equals("BACK"))
		{	System.out.println("Back");
			AdminPanel.setVisible(true);
			PreviewPanel.setVisible(false);
		}
		
		
	}    
}

