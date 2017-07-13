package client.helpedClasses;

import java.awt.Color;
import java.awt.Font;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame 
{
    JLabel developedBy,mohamed,contacts,phone1,phone2,website,facebook,twitter,mail,copyRight;
    public void display()
    {
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setTitle("About Developer");
        
        //to add background Image
        try {
               this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("about.jpg")))));
                } catch (IOException e) {
                   System.out.print(e.getMessage());
           }
        
        developedBy=new JLabel("Developed By : ");
        developedBy.setSize(550, 100);
        developedBy.setLocation(250,60);
        developedBy.setFont(new Font("Sans Serif", 0    , 40));
        this.add(developedBy);
        
        mohamed=new JLabel("Mohamed Aboalarbe");
        mohamed.setSize(650, 100);
        mohamed.setLocation(550,60);
        mohamed.setFont(new Font("Sans Serif", 0    , 70));
        this.add(mohamed);
        
        contacts=new JLabel("Contacts :- ");
        contacts.setSize(250, 100);
        contacts.setLocation(270,160);
        contacts.setForeground(Color.RED);
        contacts.setFont(new Font("Sans Serif", 0    , 35));
        this.add(contacts);
        
        phone1=new JLabel("* Phone 1 :     01005500593");
        phone1.setSize(400, 100);
        phone1.setLocation(420,220);
        phone1.setFont(new Font("Sans Serif", 0    , 28));
        this.add(phone1);
        
        phone2=new JLabel("* Phone 2 :     01157573242");
        phone2.setSize(400, 100);
        phone2.setLocation(420,280);
        phone2.setFont(new Font("Sans Serif", 0    , 28));
        this.add(phone2);
        
        website=new JLabel("* Website  :     www.Aboalarbe.edu.com");
        website.setSize(500, 100);
        website.setLocation(420,340);
        website.setFont(new Font("Sans Serif", 0    , 28));
        this.add(website);
        
        facebook=new JLabel("* Facebook :    www.facebook.com/MohamedAboalarbe");
        facebook.setSize(700, 100);
        facebook.setLocation(420,400);
        facebook.setFont(new Font("Sans Serif", 0   , 28));
        this.add(facebook);
        
        twitter=new JLabel("* Twitter  :         www.twitter.com/MohamedAboalabe");
        twitter.setSize(670, 100);
        twitter.setLocation(420,460);
        twitter.setFont(new Font("Sans Serif", 0    , 28));
        this.add(twitter);
        
        mail=new JLabel("*  Gmail  :         mohamedaboalarbe@gmail.com");
        mail.setSize(700, 100);
        mail.setLocation(420,520);
        mail.setFont(new Font("Sans Serif", 0    , 28));
        this.add(mail);
        
        copyRight=new JLabel("Copyright © Mohamed Aboalarbe.Co, 2016-2017. All rights reserved.");
        copyRight.setSize(700, 100);
        copyRight.setLocation(450,630);
        copyRight.setForeground(Color.GRAY);
        copyRight.setFont(new Font("Sans Serif", 0    , 18));
        this.add(copyRight);
        
        this.setLayout(null);
        this.setVisible(true);
    }
}
