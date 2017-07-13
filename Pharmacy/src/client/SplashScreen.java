package client;

import client.helpedClasses.About;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashScreen implements ActionListener
{
	public static JFrame splashFrame;
	JLabel welcome,elnahda,pharmacy;
	JButton enter,exit;
	public void display()
	{
		splashFrame=new JFrame("Welcome");
		splashFrame.setExtendedState(splashFrame.MAXIMIZED_BOTH);  // to make it full size
		splashFrame.setDefaultCloseOperation(splashFrame.EXIT_ON_CLOSE); // exit 
                
                //set background Image 
		try {
                        splashFrame. setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("pharmacy.jpg")))));
                        } catch (IOException e) {
                            System.out.print(e.getMessage());
                    }
        
		welcome=new JLabel("Welcome To");
		welcome.setSize(650,200);
		welcome.setLocation(200, 0);
		welcome.setFont(new Font("Sans Serif", 0	, 100));
		splashFrame.add(welcome);
		
		elnahda=new JLabel("EL Nahda");
		elnahda.setSize(650,400);
		elnahda.setLocation(260, 50);
		elnahda.setFont(new Font("Sans Serif", 0	, 100));
		splashFrame.add(elnahda);
		
		pharmacy=new JLabel("Pharmacy");
		pharmacy.setSize(650,400);
		pharmacy.setLocation(250, 200);
		pharmacy.setFont(new Font("Sans Serif", 0	, 100));
		splashFrame.add(pharmacy);
		
		enter=new JButton("Enter");
		enter.setSize(200,100);
		enter.setLocation(250,570);
		enter.setFont(new Font("Sans Serif", 0	, 40));
		enter.addActionListener(this);
		splashFrame.add(enter);
		
		exit=new JButton("Exit");
		exit.setSize(200,100);
		exit.setLocation(490,570);
		exit.addActionListener(this);
		exit.setFont(new Font("Sans Serif", 0	, 40));
		splashFrame.add(exit);
		
		splashFrame.setLayout(null);
		splashFrame.setVisible(true);
	}
	public static void main(String[] args) 
	{
                SplashScreen obj=new SplashScreen();
		obj.display();
	}
	public void actionPerformed(ActionEvent src)
	{
		JButton click=(JButton)src.getSource();   // to get the clicked Button 
		if(click==enter)
		{
                    Login obj=new Login();
                    obj.display();
		}
		else
			splashFrame.dispatchEvent(new WindowEvent(splashFrame, WindowEvent.WINDOW_CLOSING)); //exit
	}
}










/*
 * 		ImageIcon image = new ImageIcon("a.jpg");
		            JLabel imageLabel = new JLabel(image); 
		            imageLabel.setBounds(10, 20, 400, 750);
		            imageLabel.setVisible(true);
		            splashFrame.add(imageLabel);
 */