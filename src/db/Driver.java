package db;
import java.sql.*;


import javax.swing.JOptionPane;
public class Driver {
	private static Connection con;
	//private static Statement st;
	//private static ResultSet rs;
	public static void closedConnection()
	{
		try {
			if(con!=null)
			con.close();
			
			}
		catch(SQLException se){
			System.out.println(se);
		}
	}
	
	public static Connection createConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/fblZBdAgkg?characterEncoding=UTF8","fblZBdAgkg","Z7Yx3e1C0j");
			//System.out.println(con);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datasql","root","root");
			//st=con.createStatement();
			
			}
		catch(ClassNotFoundException | SQLException cse){
			System.out.println(cse);
		}
		return con;
	}
	public void main(String[] args) {
		Connection con =createConnection();
		System.out.println(con);
	}
	

}
