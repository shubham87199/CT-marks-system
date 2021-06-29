package ShortProject;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class ClasstestFrame extends Frame implements ActionListener
{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
	TextField t2,t3,t4,t5,t6,t7,t8,t9;
	Button b1,b2,b3;
	Choice c1;
	
	
	ClasstestFrame()
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
		
		
		l2=new Label("branch");
		add(l2);
		t2=new TextField();
		add(t2);
		
		l3=new Label("Semester");
		add(l3);
		t3=new TextField();
		add(t3);
		
		l4=new Label("subject1");
		add(l4);
		t4=new TextField();
		add(t4);
		l5=new Label("marks1");
		add(l5);
		t5=new TextField();
		add(t5);
		
		l6=new Label("subject2");
		add(l6);
		t6=new TextField();
		add(t6);
		l7=new Label("marks2");
		add(l7);
		t7=new TextField();
		add(t7);
		
		l8=new Label("subject3");
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
		b2=new Button("save");
		add(b2);
		b2.addActionListener(this);
		b3=new Button("exit");
		add(b3);
		b3.addActionListener(this);
	}
	
	public static void main(String[] args) 
	{
		ClasstestFrame sd=new ClasstestFrame();
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
				
				String q="select branch,semester from studentdetail where rollno='"+a+"'";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(q);
				while(rs.next())
				{
					t2.setText(rs.getString("branch"));
					t3.setText(rs.getString("semester"));
				}
				
			}
			
			String b=t2.getText();
			String c=t3.getText();
			String d=t4.getText();
			String e=t5.getText();
			String f=t6.getText();
			String g=t7.getText();
			String h=t8.getText();
			String i=t9.getText();
			
			if(z.getSource()==b2)
			{
				Class.forName("com.mysql.jdbc.Driver");//Driver Load 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EDetail","root","shubham");
				
				String q="insert into classtest value('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"')";
				System.out.print(q);
				Statement stmt=con.createStatement();
				int rl=stmt.executeUpdate(q);
				
				if(rl!=0)
				{
					System.out.println("save");
					
				}
			}
			if(z.getSource()==b3)
			{
				System.exit(0);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("error");
		}
	}
}
