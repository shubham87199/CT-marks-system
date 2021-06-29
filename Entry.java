package ShortProject;

import java.sql.*;
import java.util.Scanner;

import SelectQuerySeed.Password;

import java.awt.*;
import java.awt.event.*;


public class Entry extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1,t2,t3;
	Button b1,b2;
	
	Entry()
	{
		GridLayout g=new GridLayout(4,2);
		setLayout(g);
		
		l1=new Label("user");
		add(l1);
		t1=new TextField();
		add(t1);
		
		l2=new Label("password");
		add(l2);
		t2=new TextField();
		add(t2);

		b1=new Button("login");
		add(b1);
		b1.addActionListener(this);
		b2=new Button("reg");
		add(b2);
		b2.addActionListener(this);
		
		t3=new TextField();
		add(t3);
		
	}	

	public static void main(String[] args)
	{
		Entry f=new Entry();
		f.setSize(600,600);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent z) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//Driver Load 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EDetail","root","shubham");
			
			String a=t1.getText();
			String b=t2.getText();
			
			if(z.getSource()==b1)
			{

				String q="select * from info where name='"+a+"' and password='"+b+"'";
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(q);
				
				if(rs.next())
				{
					t3.setText("valid");

					Select m=new Select();
					m.setSize(600,600);
					m.setVisible(true);
						
				}
				else
				{
					t3.setText("invalid");
				}
			}
			
			if(z.getSource()==b2)
			{
				Detail d=new Detail();
				d.setSize(600,600);
				d.setVisible(true);
			}
			
			
		}
		catch(Exception ex)
		{
			System.out.println("error");
		}
		
		
	}

}
