package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.Driver;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AfterLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static String s1;
	private static String s2;
	private JTextArea QText;
	private JButton Next;
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private int QQ=0,marks=0,nx=0;
	private String nextstr="Start",s= " ",choosenans,rightans,second,mint,hour,s3,s4;
	private JLabel QNo,Marks,hrlable,minlable,seclable,lblNewLabel,lblNewLabel_2;
	private JRadioButton Rb1,Rb2,Rb3,Rb4;
	private ButtonGroup bg;
	private AfterLogin frame;
	
	//private ButtonGroup();
	

	/**
	 * Launch the application.
	 */int sec=60,min=29,hr=00;
	Timer mytimer=new Timer();
	TimerTask task=new TimerTask() {
		public void run()
		{
		 second=Integer.toString(sec);
		 mint=Integer.toString(min);
		 hour=Integer.toString(hr);
		
		hrlable.setText(hour);
		minlable.setText(mint);
		seclable.setText(second);
		//System.out.println(hour+mint+second);
			sec--;
			if(sec==0&&min==0&&hr==0)
			{JOptionPane.showMessageDialog(null,"TimesUp");
			//frame.setVisible(false);
			
			System.exit(0);
		}
			if(sec==0)
			{
				sec=60;
				min--;
			}
			if(min==0&&hr!=0)
			{
				min=60;
				hr--;
			}
		}
	};
	
	public void start()
	{
		mytimer.scheduleAtFixedRate(task,1000 ,1000);
	}
	
	public void SomeVal(String s3,String s4)
	{	
		s1=s3;
		s2=s4;
		lblNewLabel.setText(s1);
		//lblNewLabel_2.setText(s2);
		//System.out.println("??????"+s1);
	}
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					AfterLogin frame = new AfterLogin();
					frame.setVisible(true);
					System.out.println(s1+s2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AfterLogin() {//===========================================================================================TIMER
	
		con=Driver.createConnection();
		start();
		
	//	Timer time=new Timer();
	//	time.schedule(new TimerTask() {
			
	//		@Override
	/*	      public void run() {
				JOptionPane.showMessageDialog(null,"TimesUp");
				//frame.setVisible(false);
				
				System.exit(0);
				
				
			}
		},5000);  */  //3600000
		
		//SomeVal();
		setForeground(Color.GRAY);
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1189, 802);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rvLOGO = new JLabel("New label");
		rvLOGO.setBounds(12, 13, 148, 121);
		rvLOGO.setIcon(new ImageIcon(AfterLogin.class.getResource("/com/images/logo.jpg")));
		contentPane.add(rvLOGO);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setText(s1);
		lblNewLabel.setBounds(1000, 61, 157, 25);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Welcome");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(1000, 23, 156, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 1185, 141);
		lblNewLabel_1.setIcon(new ImageIcon(AfterLogin.class.getResource("/com/images/rvpic2 (2).jpg")));
		contentPane.add(lblNewLabel_1);
		
		JLabel QLogo = new JLabel("Q:");
		QLogo.setBounds(12, 147, 49, 49);
		QLogo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		contentPane.add(QLogo);
		
		QNo = new JLabel("0");
		QNo.setBounds(65, 147, 56, 49);
		QNo.setFont(new Font("Tahoma", Font.ITALIC, 42));
		contentPane.add(QNo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 475, 752, 25);
		contentPane.add(separator);
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++Radio Button group(start)
		 bg=new ButtonGroup();
		
		
		Rb1 = new JRadioButton("");
		Rb1.setBounds(32, 544, 752, 25);
		Rb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(Rb1);
		Rb1.addActionListener(this);
		bg.add(Rb1);
		
		Rb2 = new JRadioButton("");
		Rb2.setBounds(32, 574, 752, 25);
		Rb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(Rb2);
		Rb2.addActionListener(this);
		bg.add(Rb2);
		
		 Rb3 = new JRadioButton("");
		 Rb3.setBounds(33, 604, 751, 25);
		Rb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(Rb3);
		Rb3.addActionListener(this);
		bg.add(Rb3);
		
		Rb4 = new JRadioButton("");
		Rb4.setBounds(32, 634, 751, 25);
		Rb4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(Rb4);
		Rb4.addActionListener(this);
		bg.add(Rb4);
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++Radio Button group(start)
		
		JLabel lblNewLabel_7 = new JLabel("Choose The Correct Options from Below ::");
		lblNewLabel_7.setBounds(32, 513, 725, 32);
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_7);
		
		QText = new JTextArea(20,20);
		QText.setBounds(22, 209, 762, 253);
		QText.setFont(new Font("Courier New", Font.PLAIN, 18));
		QText.setEditable(false);
		contentPane.add(QText);
		QText.setLineWrap(true);
		QText.setColumns(10);
		
		Next = new JButton(nextstr);
		Next.setBounds(623, 680, 134, 49);
		Next.setBackground(new Color(0, 204, 51));
		Next.setFont(new Font("Tahoma", Font.ITALIC, 23));
		contentPane.add(Next);
		
		Marks = new JLabel();
		Marks.setBounds(693, 154, 91, 42);
		Marks.setHorizontalAlignment(SwingConstants.CENTER);
		Marks.setFont(new Font("Tahoma", Font.ITALIC, 22));
		contentPane.add(Marks);
		
		JLabel lblNewLabel_4 = new JLabel("Your Marks:");
		lblNewLabel_4.setBounds(389, 154, 292, 42);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 22));
		contentPane.add(lblNewLabel_4);
		
		hrlable = new JLabel();
		hrlable.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		hrlable.setHorizontalAlignment(SwingConstants.CENTER);
		hrlable.setBounds(944, 213, 56, 16);
		contentPane.add(hrlable);
		
		minlable = new JLabel();
		minlable.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		minlable.setHorizontalAlignment(SwingConstants.CENTER);
		minlable.setBounds(1014, 213, 49, 16);
		contentPane.add(minlable);
		
		seclable = new JLabel();
		seclable.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		seclable.setHorizontalAlignment(SwingConstants.CENTER);
		seclable.setBounds(1075, 213, 63, 16);
		contentPane.add(seclable);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(948, 209, 190, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel(":");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(976, 213, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(":");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(1056, 213, 37, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Timer");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(1014, 174, 67, 16);
		contentPane.add(lblNewLabel_6);
		Next.addActionListener(this);
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Action performed
	@Override
	public void actionPerformed(ActionEvent ef) {
		
		// TODO Auto-generated method stub
		String caption =ef.getActionCommand();
		
		if(caption.equals("Next")||caption.equals("Start"))
		{	nextstr="Next";
			Next.setText("Next");
			try {
				
				 //-----------------------------------------------------------------------------------------------------------Checkink answers by radio buttons
				if(nx==1) {
				 if(Rb1.isSelected())
					 choosenans=Rb1.getText();
				 if(Rb2.isSelected())
					 choosenans=Rb2.getText();
				 if(Rb3.isSelected())
					 choosenans=Rb3.getText();
				 if(Rb4.isSelected())
					 choosenans=Rb4.getText();
				 rightans=rs.getString("Option1");
				// System.out.println(choosenans+"  "+rightans);
				 if(choosenans.equals(rightans))
				  marks=marks+1;
				 bg.clearSelection();
				 
				}nx=1;
			 
				String mk=Integer.toString(marks);
				Marks.setText(mk);
				QQ=QQ+1;
				s=Integer.toString(QQ);
				QNo.setText(s);
				String query="SELECT * FROM maintable WHERE no= '"+s+"'";
				pst=con.prepareStatement(query); 
				 rs=pst.executeQuery();
				 if(rs.next()){
					 String sw=rs.getString("Questions");
					// if (sw.equals(""))
					 //{
						// JOptionPane.showMessageDialog(null,"Question Limit Exceed");
					 //}
					 QText.setText(sw);
					 //--------------------------------------------------------------------------------------------------------Setting  radio options
					 String op1,op2,op3,op4;
					 int rand = (int)(Math.random() * 4) + 1; 
					 String sr=Integer.toString(rand);
					 op1=rs.getString("Option"+sr);
					 
					 rand++;
					 if(rand==5)
						 rand++;	
					 	int y=rand%5;
					 String ys=Integer.toString(y);
					 	op2=rs.getString("Option"+ys);
					 	
					 		rand++;
					 		if(rand==5)
					 			rand++;
						 	y=rand%5;
							 ys=Integer.toString(y);
					 op3=rs.getString("Option"+ys);
					 
					 rand++;
					 if(rand==5)
				 			rand++;
					 	 y=rand%5;
						 ys=Integer.toString(y);
					 op4=rs.getString("Option"+ys);
					 
					 Rb1.setText(op1);
					 Rb2.setText(op2);
					 Rb3.setText(op3);
					 Rb4.setText(op4);
					
			
				 }	
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Question limit exceeds      Your marks are::"+marks);
			}
			
		}
		
	}
}
