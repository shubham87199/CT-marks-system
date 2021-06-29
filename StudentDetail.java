package ShortProject;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class StudentDetail extends Frame implements ActionListener
{
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	TextField t1,t2,t3,t4,t5,t6,t7,t8;
	Button b1;
	
	StudentDetail()
	{

		GridLayout g=new GridLayout(9,2);
		setLayout(g);
		
		l1=new Label("rollno");
		add(l1);
		t1=new TextField();
		add(t1);
		
		l2=new Label("name");
		add(l2);
		t2=new TextField();
		add(t2);
		
		l3=new Label("branch");
		add(l3);
		t3=new TextField();
		add(t3);
		
		l4=new Label("Semester");
		add(l4);
		t4=new TextField();
		add(t4);
		
		l5=new Label("mobileno");
		add(l5);
		t5=new TextField();
		add(t5);
		
		l6=new Label("address");
		add(l6);
		t6=new TextField();
		add(t6);
		
		l7=new Label("parent name");
		add(l7);
		t7=new TextField();
		add(t7);
		
		l8=new Label("parent mob");
		add(l8);
		t8=new TextField();
		add(t8);
		
		b1=new Button("save");
		add(b1);
		b1.addActionListener(this);
	}

	public static void main(String[] args) 
	{
		StudentDetail sd=new StudentDetail();
		sd.setSize(600,600);
		sd.setVisible(true);
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
				String e=t5.getText();
				String f=t6.getText();
				String g=t7.getText();
				String h=t8.getText();
				
				if(z.getSource()==b1)
				{
					
					String q="insert into studentdetail value('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";
					
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
