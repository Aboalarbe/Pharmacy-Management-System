package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Dimension2D;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import oracle.dfw.incident.Problem;

public class Customer implements ActionListener
{
    JFrame companyFrame;
            JLabel customerName_,doctorName_,customerPhone_,customerAge_,customerAddress_;
            JTextField customerName, doctorname,customerPhone,customerAge,customerAddress;
            JButton next,back;
            public void display()
            {
                    companyFrame =new JFrame("Register Customer Data");
                    companyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    companyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

                    next=new JButton("Next");
                    next.setSize(130, 40);
                    next.setLocation(1210, 650);
                    next.addActionListener(this);
                    companyFrame.add(next);


                    back=new JButton("Back");
                    back.setSize(130, 40);
                    back.setLocation(1050, 650);
                    back.addActionListener(this);
                    companyFrame.add(back);
                    
                    customerName_=new JLabel("Customer Name ");
                    customerName_.setSize(230, 40);
                    customerName_.setLocation(60,30);
                    customerName_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(customerName_);
                    
                    customerName=new JTextField();
                    customerName.setSize(300,40);
                    customerName.setLocation(350,30);
                    customerName.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(customerName);

                    doctorName_=new JLabel("Doctor Name ");
                    doctorName_.setSize(230, 30);
                    doctorName_.setLocation(60,120);
                    doctorName_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add( doctorName_);
                    
                    doctorname=new JTextField();
                    doctorname.setSize(300,40);
                    doctorname.setLocation(350,120);
                    doctorname.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(doctorname);

                    customerAge_=new JLabel("Customer Age");
                    customerAge_.setSize(230, 30);
                    customerAge_.setLocation(60, 210);
                    customerAge_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(customerAge_);
                    
                    customerAge=new JTextField();
                    customerAge.setSize(300, 40);
                    customerAge.setLocation(350, 210);
                    customerAge.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(customerAge);
                    
                    customerPhone_=new JLabel("Customer Phone");
                    customerPhone_.setSize(230, 30);
                    customerPhone_.setLocation(60, 300);
                    customerPhone_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(customerPhone_);
                
                    customerPhone=new JTextField();
                    customerPhone.setSize(300, 40);
                    customerPhone.setLocation(350, 300);
                    customerPhone.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(customerPhone);
                    
                     customerAddress_=new JLabel("Customer Address");
                     customerAddress_.setSize(230, 30);
                     customerAddress_.setLocation(60, 390);
                     customerAddress_.setFont(new Font("Sans Serif", 0, 25));
                     companyFrame.add(customerAddress_);
                
                     customerAddress=new JTextField();
                     customerAddress.setSize(300, 40);
                     customerAddress.setLocation(350, 390);
                     customerAddress.setFont(new Font("Sans Serif", 0, 20));
                     companyFrame.add(customerAddress);


                    companyFrame.setLayout(null);
                    companyFrame.setVisible(true);
            }
            public void actionPerformed(ActionEvent source) 
        {
                JButton clickedButton=(JButton)source.getSource();
           if(clickedButton==next)
       {
                  if(!(customerAge.getText().isEmpty()))
             {
               try {
                    int newId=autoIncrementId();
                    registerNewCustomer(newId);
                    JOptionPane.showMessageDialog(null,"Data Saved Successfully","Success",1);
                    Sales obj=new Sales();
                    obj.display();
                    companyFrame.setVisible(false);
                  } catch (SQLException e) {
                     JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
                  }
              }
                    else
            JOptionPane.showMessageDialog(null,"Age must Be Entered","Error",0);
        }
            else
                 {
                     Manager obj=new Manager();
                     companyFrame.setVisible(false);
                 }
            }
    public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement ps1=conn.prepareStatement("select id from customer");
        ResultSet rs=ps1.executeQuery();
        int currentId=0;
        while(rs.next())
        {
        currentId=rs.getInt("id");
        }
       conn.close();
       newId=++currentId; 
       return newId;
    }
    public void registerNewCustomer(int id) throws SQLException {
        /*
         * this method insert Customer data
         */
        Connection conn= Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into customer (id,name,doctorname,phone,age,address) values(?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, customerName.getText());
        ps.setString(3, doctorname.getText());
        ps.setString(4, customerPhone.getText());
        ps.setInt(5, Integer.parseInt(customerAge.getText()));
        ps.setString(6, customerAddress.getText());
        ps.executeUpdate();
        conn.commit();
        conn.close();
    }
}
