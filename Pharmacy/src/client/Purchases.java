package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Purchases implements ActionListener
{
    JFrame purchaseFrame;
    JLabel youShould_,youShould2,drugName_,companyName_,discount_,quantity_,price_,totalPrice_,total,currentDate,date_;
    JTextField discount,quantity,price;
    JButton registerNewDrug,registerNewCompany,finish,back;
    JComboBox drugName,companyName;
    double totalPrice;
    public void display()
    {
        purchaseFrame=new JFrame("Purchase Product");
        purchaseFrame.setExtendedState(purchaseFrame.MAXIMIZED_BOTH);
        purchaseFrame.setDefaultCloseOperation(purchaseFrame.EXIT_ON_CLOSE);
        
        youShould_=new JLabel("You Must Register The Drug If Not Exsist");
        youShould_.setSize(550, 100);
        youShould_.setLocation(450,0);
        youShould_.setFont(new Font("Sans Serif", 0    , 25));
        youShould_.setForeground(Color.RED);
        purchaseFrame.add(youShould_);
        
        registerNewDrug=new JButton("Register The Drug");
        registerNewDrug.setSize(200, 50);
        registerNewDrug.setLocation(600, 80);
        registerNewDrug.setFont(new Font("Sans Serif", 0    , 18));
        registerNewDrug.addActionListener(this);
        purchaseFrame.add(registerNewDrug);
        
        youShould_=new JLabel("You Must Register The Company If Not Exsist");
        youShould_.setSize(550, 100);
        youShould_.setLocation(430,120);
        youShould_.setFont(new Font("Sans Serif", 0    , 25));
        youShould_.setForeground(Color.RED);
        purchaseFrame.add(youShould_);
        
        finish=new JButton("Finsh");
        finish.setSize(120, 40);
        finish.setLocation(650, 650);
        finish.addActionListener(this);
        purchaseFrame.add(finish);
        
        back=new JButton("Back");
        back.setSize(120, 40);
        back.setLocation(500, 650);
        back.addActionListener(this);
        purchaseFrame.add(back);
        
        registerNewCompany=new JButton("Register The Company");
        registerNewCompany.setSize(220, 50);
        registerNewCompany.setLocation(590, 210);
        registerNewCompany.setFont(new Font("Sans Serif", 0    , 18));
        registerNewCompany.addActionListener(this);
        purchaseFrame.add(registerNewCompany);
        
        drugName_=new JLabel("Drug Name");
        drugName_.setSize(150, 30);
        drugName_.setLocation(20,290);
        drugName_.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(drugName_);
        
        drugName=new JComboBox();
        drugName.setSize(300, 30);
        drugName.setLocation(200,290);
        drugName.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(drugName);
        
        companyName_=new JLabel("Company Name");
        companyName_.setSize(300, 30);
        companyName_.setLocation(10,350);
        companyName_.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(companyName_);
        
        companyName=new JComboBox();
        companyName.setSize(300, 30);
        companyName.setLocation(200,350);
        companyName.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(companyName);
        
        /*
         * this not optional i must fill the commbobix with data
         * from the database to load with form when opened 
         */
        try {
            fillCombobox();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
        
        quantity_=new JLabel("Drug Quantity");
        quantity_.setSize(300, 30);
        quantity_.setLocation(10,410);
        quantity_.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(quantity_);
        
        quantity=new JTextField();
        quantity.setSize(120, 30);
        quantity.setLocation(200,410);
        quantity.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(quantity);
        
        price_=new JLabel("Total Price");
        price_.setSize(300, 30);
        price_.setLocation(10,470);
        price_.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(price_);
        
        price=new JTextField();
        price.setSize(120, 30);
        price.setLocation(200,470);
        price.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(price);
        
        discount_=new JLabel("Discount %");
        discount_.setSize(300, 30);
        discount_.setLocation(10,530);
        discount_.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(discount_);
        
        discount=new JTextField();
        discount.setSize(120, 30);
        discount.setLocation(200,530);
        discount.setFont(new Font("Sans Serif", 0    , 20));
        purchaseFrame.add(discount);
        
        totalPrice_=new JLabel("Required Price :");
        totalPrice_.setSize(230, 30);
        totalPrice_.setLocation(920,650);
        totalPrice_.setForeground(Color.RED);
        totalPrice_.setFont(new Font("Sans Serif", 0, 30));
        purchaseFrame.add(totalPrice_);
        
        total=new JLabel(totalPrice+"");
        total.setSize(230, 30);
        total.setLocation(1170,650);
        total.setFont(new Font("Sans Serif", 0, 40));
        purchaseFrame.add(total);
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datee = new Date();
        String temp=dateFormat.format(datee);
        
        currentDate=new JLabel(temp);
        currentDate.setSize(230, 30);
        currentDate.setLocation(1120,320);
        currentDate.setFont(new Font("Sans Serif", 0, 30));
        purchaseFrame.add(currentDate);
        
        date_=new JLabel("Current Date :");
        date_.setSize(230, 30);
        date_.setLocation(900,320);
        date_.setFont(new Font("Sans Serif", 0, 30));
        purchaseFrame.add(date_);
        
        purchaseFrame.setLayout(null);
        purchaseFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent source) 
    {
        JButton clickedButton=(JButton)source.getSource();
        if(clickedButton==registerNewCompany)
        {
            Company obj=new Company();
            obj.dispaly();
            purchaseFrame.setVisible(false);
        }
        else if(clickedButton==registerNewDrug)
        {
            Drug obj=new Drug();
            obj.display();
            purchaseFrame.setVisible(false);
        }
        else if(clickedButton==finish)
        {
          if(price.getText().isEmpty()||quantity.getText().isEmpty()||discount.getText().isEmpty())
              JOptionPane.showMessageDialog(null, "Enter All Required Data","Error",0);
          else
          {
            int priceBeforeDiscount=Integer.parseInt(price.getText());
            float discountt=Float.parseFloat(discount.getText());
            totalPrice= calculateDiscount(priceBeforeDiscount, discountt);
            total.setText(totalPrice+"");
            try {
                recordTransaction();
                JOptionPane.showMessageDialog(null, "Successfully Added", "Done", 1);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
            }
         }
        }
        else
        {
           Manager obj=new Manager();
            purchaseFrame.setVisible(false);
        }
    }
    public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id for purchases table
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("select id from purchases");
        ResultSet rs=ps.executeQuery();
        int currentId=0;
        while(rs.next())
        {
        currentId=rs.getInt("id");
        }
        conn.close();
       newId=++currentId; 
       return newId;
    }
    public int getDrugId() throws SQLException {
        /*
         * this method refer to get drug id from drug table 
         */
        int drugId=0;
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("select id from drug where name=?");
        ps.setString(1, drugName.getSelectedItem().toString());
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        drugId=rs.getInt("id");
        }
        conn.close();
       return drugId;
    }
    public int getCompanyId() throws SQLException {
        /*
         * this method refer to get company id from company table 
         */
        int companyId=0;
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("select id from company where name=?");
        ps.setString(1, companyName.getSelectedItem().toString());
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
           companyId=rs.getInt("id");
        }
        conn.close();
       return companyId;
    }
    public void fillCombobox() throws SQLException {
        /*
         * this method fill the combobox with data from the daatabase
         */
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("select name from drug");
        PreparedStatement ps2=conn.prepareStatement("select name from company");
        ResultSet rs=ps.executeQuery();
        ResultSet rs2=ps2.executeQuery();        
        while(rs.next()) {
            drugName.addItem(rs.getString("name"));
        }
        while(rs2.next()) {
            companyName.addItem(rs2.getString("name"));
        }
        conn.close();
    }
    public void recordTransaction() throws SQLException {
        /*
         * this method record the purchases transaction in purchases table
         */
        Connection conn=Database.getConnection();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date datee = new Date();
            String temp=dateFormat.format(datee);
        PreparedStatement ps=conn.prepareStatement("insert into purchases (id,drug_id,company_id,quantity,totalprice,discount," +
                                                   "afterdiscount,processdate) values(?,?,?,?,?,?,?,?)");
        ps.setInt(1, autoIncrementId());
        ps.setInt(2, getDrugId());
        ps.setInt(3, getCompanyId());
        ps.setInt(4, Integer.parseInt(quantity.getText()));
        ps.setInt(5, Integer.parseInt(price.getText()));
        ps.setInt(6, Integer.parseInt(discount.getText()));
        ps.setDouble(7, totalPrice);
        ps.setString(8, temp);
        ps.executeUpdate();
        conn.commit();
        conn.close();
    }
    public double calculateDiscount(int priceBeforeDiscount,float discount)
    {
       double priceAfterDiscount=priceBeforeDiscount-(priceBeforeDiscount*(discount/100));
       return priceAfterDiscount;
    }
}