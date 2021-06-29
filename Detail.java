package ShortProject;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class Detail extends Frame implements ActionListener
{	
	Label l1,l2,l3,l4;
	TextField t1,t2,t3,t4;
	Button b1;
	
	Detail()
	{
		GridLayout g=new GridLayout(6,2);
		setLayout(g);
		
		l1=new Label("name");
		add(l1);
		t1=new TextField();
		add(t1);
		
		l2=new Label("password");
		add(l2);
		t2=new TextField();
		add(t2);
		
		l3=new Label("branch");
		add(l3);
		t3=new TextField();
		add(t3);
		
		l4=new Label("mobile number");
		add(l4);
		t4=new TextField();
		add(t4);
		
		b1=new Button("save");
		add(b1);
		b1.addActionListener(this);
	}
	
	public static void main(String[] args) 
	{
		Detail f=new Detail();
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
			String c=t3.getText();
			String d=t4.getText();
			
			if(z.getSource()==b1)
			{
				
				String q="insert into info value('"+a+"','"+b+"','"+c+"','"+d+"')";
				
				Statement stmt=con.createStatement();
				int rl=stmt.executeUpdate(q);
				
				if(rl!=0)
				{
					System.out.println("save");
				}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("error");
		}
	}
}
