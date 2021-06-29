package ShortProject;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class Select extends Frame implements ActionListener
{
	Button b1,b2,b3,b4;
	
	Select()
	{
		GridLayout g=new GridLayout(4,1);
		setLayout(g);
		
		b1=new Button("Add Student");
		add(b1);
		b1.addActionListener(this);
		b2=new Button("Add class Test");
		add(b2);
		b2.addActionListener(this);
		b3=new Button("Show");
		add(b3);
		b3.addActionListener(this);
		b4=new Button("logout");
		add(b4);
		b4.addActionListener(this);
	}
	
	public static void main(String[] args)  throws Exception
	{
		Select s=new Select();
		s.setSize(600,600);
		s.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent z) 
	{
		try
		{
			if(z.getSource()==b1)
			{
				StudentDetail sd=new StudentDetail();
				sd.setSize(600,600);
				sd.setVisible(true);
			}
			
			if(z.getSource()==b2)
			{
				ClasstestFrame sd=new ClasstestFrame();
				sd.setSize(600,600);
				sd.setVisible(true);
			}
			
			if(z.getSource()==b3)
			{
				ShowFrame sd=new ShowFrame();
				sd.setSize(600,600);
				sd.setVisible(true);
			}
			
			if(z.getSource()==b4)
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
