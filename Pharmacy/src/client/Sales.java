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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Sales implements ActionListener
{
    JFrame salesFrame;
    JLabel drugName,stripes,price,quantity,expirationdate,currentDate,today,total,totalprice,requirdQuantity,code;
    JTextField jdrugName,jstripes,jprice,jquantity,jdate,jrequired,jcode;
    JButton show,add,update,finish,neworder,back;
    JTextArea invoice;
    int dataPrice,dataStripes,quntaty,drugId,customerId;
    String dataQuantity;
    double totalPrice;
    public void display()
    {
        salesFrame=new JFrame("Sale Product");
        salesFrame.setExtendedState(salesFrame.MAXIMIZED_BOTH);
        salesFrame.setDefaultCloseOperation(salesFrame.EXIT_ON_CLOSE);
        
        drugName=new JLabel("Drug Name");
        drugName.setSize(230, 30);
        drugName.setLocation(20,20);
        drugName.setFont(new Font("Sans Serif", 0, 25));
        salesFrame.add(drugName);
        
        jdrugName=new JTextField();
        jdrugName.setSize(300,30);
        jdrugName.setLocation(210,20);
        jdrugName.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(jdrugName);
        
        show=new JButton("Show Details");
        show.setSize(120, 30);
        show.setLocation(220, 70);
        show.addActionListener(this);
        salesFrame.add(show);

        add=new JButton("Add To Invoice");
        add.setSize(130, 30);
        add.setLocation(370, 70);
        add.addActionListener(this);
        salesFrame.add(add);
        
        finish=new JButton("Finsh Order");
        finish.setSize(120, 30);
        finish.setLocation(950, 600);
        finish.addActionListener(this);
        salesFrame.add(finish);
        
        back=new JButton("Back");
        back.setSize(70, 30);
        back.setLocation(1250, 600);
        back.addActionListener(this);
        salesFrame.add(back);
        
        neworder=new JButton("New Order");
        neworder.setSize(120, 30);
        neworder.setLocation(1100, 600);
        neworder.addActionListener(this);
        salesFrame.add(neworder);
        
        requirdQuantity=new JLabel("Required Quantity");
        requirdQuantity.setSize(230, 30);
        requirdQuantity.setLocation(5,130);
        requirdQuantity.setFont(new Font("Sans Serif", 0, 25));
        salesFrame.add(requirdQuantity);
        
        jrequired=new JTextField("1");
        jrequired.setSize(100,30);
        jrequired.setLocation(230,130);
        jrequired.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(jrequired);
        
        stripes=new JLabel("no.Stripes");
        stripes.setSize(230, 30);
        stripes.setLocation(20,200);
        stripes.setFont(new Font("Sans Serif", 0, 25));
        salesFrame.add(stripes);
        
        jstripes=new JTextField();
        jstripes.setSize(100,30);
        jstripes.setLocation(230,200);
        jstripes.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(jstripes);
        
        update=new JButton("Update Price");
        update.setSize(120, 30);
        update.setLocation(370, 200);
        update.addActionListener(this);
        salesFrame.add(update);
        
        price=new JLabel("Price");
        price.setSize(230, 30);
        price.setLocation(70,260);
        price.setFont(new Font("Sans Serif", 0, 25));
        salesFrame.add(price);
        
        jprice=new JTextField();
        jprice.setSize(300,30);
        jprice.setLocation(220,260);
        jprice.setEditable(false);
        jprice.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(jprice);
        
        quantity=new JLabel("Availabe Quantity");
        quantity.setSize(250, 30);
        quantity.setLocation(5,320);
        quantity.setFont(new Font("Sans Serif", 0, 25));
        salesFrame.add(quantity);
        
        jquantity=new JTextField();
        jquantity.setSize(300,30);
        jquantity.setLocation(220,320);
        jquantity.setEditable(false);
        jquantity.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(jquantity);
        
        expirationdate=new JLabel("Date of Expiration");
        expirationdate.setSize(230, 30);
        expirationdate.setLocation(5,380);
        expirationdate.setFont(new Font("Sans Serif", 0, 25));
        salesFrame.add(expirationdate);
        
        jdate=new JTextField();
        jdate.setSize(300,30);
        jdate.setLocation(220,380);
        jdate.setEditable(false);
        jdate.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(jdate);
        
        code=new JLabel("Drug Code");
        code.setSize(230, 30);
        code.setLocation(20,440);
        code.setFont(new Font("Sans Serif", 0, 25));
        salesFrame.add(code);
        
        jcode=new JTextField();
        jcode.setSize(300,30);
        jcode.setLocation(220,440);
        jcode.setEditable(false);
        jcode.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(jcode);
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datee = new Date();
        String temp=dateFormat.format(datee);
        
        currentDate=new JLabel(temp);
        currentDate.setSize(230, 30);
        currentDate.setLocation(1170,5);
        currentDate.setFont(new Font("Sans Serif", 0, 30));
        salesFrame.add(currentDate);
        
        today=new JLabel("Current Date :");
        today.setSize(230, 30);
        today.setLocation(950,5);
        today.setFont(new Font("Sans Serif", 0, 30));
        salesFrame.add(today);
        
        invoice=new JTextArea();
        invoice.setSize(440,500);
        invoice.setLocation(910,60);
        invoice.setForeground(Color.BLUE);
        invoice.setEditable(false);
        invoice.setFont(new Font("Sans Serif", 0, 20));
        salesFrame.add(invoice);
        
        total=new JLabel("Total Price :");
        total.setSize(230, 30);
        total.setLocation(950,650);
        total.setForeground(Color.RED);
        total.setFont(new Font("Sans Serif", 0, 30));
        salesFrame.add(total);
        
        totalprice=new JLabel(totalPrice+"");
        totalprice.setSize(230, 30);
        totalprice.setLocation(1170,650);
        totalprice.setFont(new Font("Sans Serif", 0, 40));
        salesFrame.add(totalprice);
        
        salesFrame.setLayout(null);
        salesFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent src) 
    {
        JButton click=(JButton)src.getSource();
        if(click==add) 
        {
            
            if(!(jdrugName.getText().isEmpty()||jprice.getText().isEmpty()))
            {
                int newquantity=Integer.parseInt(dataQuantity)-quntaty; //the quantity after the sold operation
                try {
                    updateDataase(newquantity);
                    updateGui(newquantity);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Enter Data !", "Error", 0);
        }
        else if(click==update) 
        {
            /*
             * display the price if the user want specific quantity
             */
            if(jrequired.getText().isEmpty()||jstripes.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Enter the Required Quantity", "Erorr", 0);
             quntaty=Integer.parseInt(jrequired.getText());
            int stripes=Integer.parseInt(jstripes.getText());
            jprice.setText(quntaty*stripes*dataPrice+"");
        }
        else if(click==show)
        {
            try {
                displaySpecificDrug();
                checkQuantity();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
            }
        }
        else if(click==neworder)
        {
            Customer obj=new Customer();
            obj.display();
        }
        else if(click==finish) 
        {
            try {
                int newquantity=Integer.parseInt(dataQuantity)-quntaty;
                updateDataase(newquantity);
                recordTransaction();
                JOptionPane.showMessageDialog(null, "Successfully Added", "Information", 1);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
            }
        }
        else
        {
          salesFrame.setVisible(false);
            Manager obj=new Manager();
        }
    }
    private void checkQuantity() 
    {
        /*
         * this method check the quantity of specific drug in the pharmacy
         */
        if(Integer.parseInt(dataQuantity)<=0) 
        {
            JOptionPane.showMessageDialog(null, "you don`t have "+jdrugName.getText(), "Warning", 2);
            add.setEnabled(false);
            jrequired.setEditable(false);
            jstripes.setEditable(false);
        }
        else if(Integer.parseInt(dataQuantity)<=10)
        {
          JOptionPane.showMessageDialog(null, "Be Aware you have Less Than 10 "+jdrugName.getText(), "Warning", 2);
        }
            else if(quntaty>Integer.parseInt(dataQuantity))
                {
                    JOptionPane.showMessageDialog(null, "you don`t have this Amount of  "+jdrugName.getText(), "Warning", 2);
                    add.setEnabled(false);
                    jrequired.setEditable(false);
                    jstripes.setEditable(false);
                }
        else
        {
            add.setEnabled(true);
            jrequired.setEditable(true);
            jstripes.setEditable(true);
        }
    }
    public void updateDataase(int newValue) throws SQLException {
        /*
         * this method update the drug quantity in the database after the sale operation
         */
        Connection conn=Database.getConnection();
        PreparedStatement ps2=conn.prepareStatement("update drug set quantity=? where name=?");
        ps2.setInt(1, newValue);
        ps2.setString(2, jdrugName.getText());
        ps2.executeUpdate();
        conn.commit();
        conn.close();
    }
    public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement ps1=conn.prepareStatement("select id from sales");
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
    public void recordTransaction() throws SQLException {
        /*
         * this method insert the procees date and auto increment id
         */
        Connection conn=Database.getConnection();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date datee = new Date();
            String temp=dateFormat.format(datee);
        PreparedStatement ps=conn.prepareStatement("insert into sales (id,processdate,total,customer_id,drug_id) values(?,?,?,?,?)");
        ps.setInt(1, autoIncrementId());
        ps.setString(2,temp);
        ps.setDouble(3, totalPrice);
        ps.setInt(4, customerId);
        ps.setInt(5, drugId);
        ps.executeUpdate();
        conn.commit();
        conn.close();
    }
    public void updateGui(int newquantity) {
        /*
         * this method update the form (GUI) after the sale operation done 
         * calc the total price for the client
         */
        JOptionPane.showMessageDialog(null, "Avalible Quantity Became "+newquantity, "Information", 1);
        invoice.setText(invoice.getText()+"\n"+jdrugName.getText()+"\t\t"+jrequired.getText()+"\t"+jprice.getText());
        totalPrice+=Integer.parseInt(jprice.getText());
        totalprice.setText(totalPrice+"");
        jdrugName.setText("");
        jprice.setText("");
        jdate.setText("");
        jquantity.setText("");
        jdate.setText("");
        jstripes.setText("");
        jcode.setText("");
    }
    public void displaySpecificDrug() throws SQLException {
        /*
         * this method get the data from the database and set them into the form
         */
        Connection conn= Database.getConnection();
        if(jdrugName.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Enter the Name of The Drug", "Erorr", 0);
        conn = Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("select numberofstripes,price,quantity,expirationdate,code,id from drug where name=? or code=?");
        PreparedStatement ps2=conn.prepareStatement("select id from customer");
        ps.setString(1, jdrugName.getText());
        ps.setString(2, jdrugName.getText());
        ResultSet rs=ps.executeQuery();
        ResultSet rs2=ps2.executeQuery();
        while(rs.next())
        {
           dataPrice=rs.getInt("price");
           dataStripes=rs.getInt("numberofstripes");
           dataQuantity=rs.getString("quantity");
           jdate.setText(rs.getString("expirationdate")+"");
           jcode.setText(rs.getString("code"));
           drugId=rs.getInt("id");
        }
        while(rs2.next())
        {
           customerId=rs2.getInt("id");
        }
        conn.close();
        jprice.setText(dataPrice*dataStripes+"");
        jquantity.setText(dataQuantity);
        jstripes.setText(dataStripes+"");
    }
}
