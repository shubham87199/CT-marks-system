package ShortProject;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class ShowFrame extends Frame implements ActionListener
{
	Choice c1;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	Button b1;
	
	ShowFrame()
	{
		GridLayout g=new GridLayout(12,2);
		setLayout(g);
		
		l1=new Label("rollno");
		add(l1);
		c1=new Choice();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//Driver Load 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EDetail","root","shubham");
			
			String q="select * from studentdetail";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(q);
			while(rs.next())
			{
				c1.add(rs.getString("rollno"));
			}
			add(c1);
		}
		catch(Exception ex)
		{
			System.out.println("error");
		}
		
		
		l2=new Label("personal detail");
		add(l2);
		t2=new TextField();
		add(t2);
		
		l3=new Label("user name");
		add(l3);
		t3=new TextField();
		add(t3);
		l4=new Label("mobile number");
		add(l4);
		t4=new TextField();
		add(t4);
		l5=new Label("address");
		add(l5);
		t5=new TextField();
		add(t5);
		
		l6=new Label("marks");
		add(l6);
		t6=new TextField();
		add(t6);
		l7=new Label("marks1");
		add(l7);
		t7=new TextField();
		add(t7);
		l8=new Label("marks2");
		add(l8);
		t8=new TextField();
		add(t8);
		l9=new Label("marks3");
		add(l9);
		t9=new TextField();
		add(t9);
		
		b1=new Button("go");
		add(b1);
		b1.addActionListener(this);
		
	}
	public static void main(String[] args) 
	{
		ShowFrame sd=new ShowFrame();
		sd.setSize(600,600);
		sd.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent z)
	{
		try
		{
			String a=c1.getSelectedItem();
			
			if(z.getSource()==b1)
			{
				Class.forName("com.mysql.jdbc.Driver");//Driver Load 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EDetail","root","shubham");
				
				String q="select * from studentdetail where rollno='"+a+"'";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(q);
				
				while(rs.next())
				{
					t3.setText(rs.getString("name"));
					t4.setText(rs.getString("mobileno"));
					t5.setText(rs.getString("address"));
				}
				
				Class.forName("com.mysql.jdbc.Driver");//Driver Load 
				Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/EDetail","root","shubham");
				
				String w="select * from classtest where rollno='"+a+"'";
				Statement stm=co.createStatement();
				ResultSet r=stmt.executeQuery(w);
				
				while(r.next())
				{
					t7.setText(r.getString("marks1"));
					t8.setText(r.getString("marks"));
					t9.setText(r.getString("marks3"));
				}
				
			}
		}
		catch(Exception ex)
		{
			System.out.println("error");
		}
	}	
}
