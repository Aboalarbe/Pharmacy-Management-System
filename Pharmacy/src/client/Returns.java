package client;

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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class Returns implements ActionListener
{
    JFrame returnsFrame;
    JLabel customerNameOrPhone_,customerName_,totalPrice_,currentDate,reasonsOfReturn_,dateOfBuy_,today;
    JTextField search,customerName,totalPrice,rasonsOfReturns;
    JButton searchh,finish,back;
    JFormattedTextField dateOfBuy;
    int customerId;
    public void display() 
    {
        returnsFrame=new JFrame("Returns");
        returnsFrame.setExtendedState(returnsFrame.MAXIMIZED_BOTH);
        returnsFrame.setDefaultCloseOperation(returnsFrame.EXIT_ON_CLOSE);
        
        customerNameOrPhone_=new JLabel("Customer Name or Phone :");
        customerNameOrPhone_.setSize(400, 30);
        customerNameOrPhone_.setLocation(200,50);
        customerNameOrPhone_.setFont(new Font("Sans Serif", 0, 25));
        returnsFrame.add(customerNameOrPhone_);
        
        search=new JTextField();
        search.setSize(400,40);
        search.setLocation(530,50);
        search.setFont(new Font("Sans Serif", 0, 20));
        returnsFrame.add(search);
        
        searchh=new JButton("Search");
        searchh.setSize(200, 40);
        searchh.setLocation(630, 120);
        searchh.addActionListener(this);
        returnsFrame.add(searchh);
        
        finish=new JButton("Finish");
        finish.setSize(200, 40);
        finish.setLocation(630, 500);
        finish.addActionListener(this);
        returnsFrame.add(finish);
        
        back=new JButton("Back");
        back.setSize(200, 40);
        back.setLocation(630, 600);
        back.addActionListener(this);
        returnsFrame.add(back);
        
        customerName_=new JLabel("Customer Name");
        customerName_.setSize(200, 30);
        customerName_.setLocation(50,200);
        customerName_.setFont(new Font("Sans Serif", 0, 25));
        returnsFrame.add(customerName_);
        
        customerName=new JTextField();
        customerName.setSize(300,30);
        customerName.setLocation(300,200);
        customerName.setEditable(false);
        customerName.setFont(new Font("Sans Serif", 0, 20));
        returnsFrame.add(customerName);
        
        totalPrice_=new JLabel("Total Price");
        totalPrice_.setSize(200, 30);
        totalPrice_.setLocation(50,250);
        totalPrice_.setFont(new Font("Sans Serif", 0, 25));
        returnsFrame.add(totalPrice_);
        
        totalPrice=new JTextField();
        totalPrice.setSize(300,30);
        totalPrice.setLocation(300,250);
        totalPrice.setEditable(false);
        totalPrice.setFont(new Font("Sans Serif", 0, 20));
        returnsFrame.add(totalPrice);
        
        dateOfBuy_=new JLabel("Buying Date");
        dateOfBuy_.setSize(200, 30);
        dateOfBuy_.setLocation(50,300);
        dateOfBuy_.setFont(new Font("Sans Serif", 0, 25));
        returnsFrame.add(dateOfBuy_);
        
        dateOfBuy=new JFormattedTextField("DD/MM/YYYY");
        dateOfBuy.setSize(300,30);
        dateOfBuy.setLocation(300,300);
        dateOfBuy.setEditable(false);
        dateOfBuy.setFont(new Font("Sans Serif", 0, 20));
        returnsFrame.add(dateOfBuy);
        
        reasonsOfReturn_=new JLabel("Reasons");
        reasonsOfReturn_.setSize(200, 30);
        reasonsOfReturn_.setLocation(50,400);
        reasonsOfReturn_.setFont(new Font("Sans Serif", 0, 25));
        returnsFrame.add(reasonsOfReturn_);
        
        rasonsOfReturns=new JTextField();
        rasonsOfReturns.setSize(300,70);
        rasonsOfReturns.setLocation(300,380);
        rasonsOfReturns.setFont(new Font("Sans Serif", 0, 17));
        returnsFrame.add(rasonsOfReturns);
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datee = new Date();
        String temp=dateFormat.format(datee);
        
        currentDate=new JLabel(temp);
        currentDate.setSize(230, 30);
        currentDate.setLocation(1130,300);
        currentDate.setFont(new Font("Sans Serif", 0, 30));
        returnsFrame.add(currentDate);
        
        today=new JLabel("Current Date :");
        today.setSize(230, 30);
        today.setLocation(900,300);
        today.setFont(new Font("Sans Serif", 0, 30));
        returnsFrame.add(today);
        
        
        returnsFrame.setLayout(null);
        returnsFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent source) 
    {
        JButton clickedButton =(JButton)source.getSource();
        if(clickedButton==searchh)
        {
            if(search.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Enter the name or the phone","Error",0);
            else
          {
             try {
                showData();
                search.setText("");
              } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
              }
          }
         }
        else if(clickedButton==finish) 
        {
            if(totalPrice.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Enter the Data ","Error",0);
            else
            {
               try {
                  insertData();
                  deleteData();
                  JOptionPane.showMessageDialog(null, "Success", "Done", 1);
                  customerName.setText("");
                  totalPrice.setText("");
                  rasonsOfReturns.setText("");
                  dateOfBuy.setText("");
               } catch (SQLException e) {
                  JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
              }
            }
        }
        else
        {
            Manager obj=new Manager();
            returnsFrame.setVisible(false);
        }   
    }
    public void showData() throws SQLException {
        /*
         * this method get the data from the database and set them into the form
         */
        Connection conn= Database.getConnection();
        conn = Database.getConnection();
        PreparedStatement prepareStatment=conn.prepareStatement("select name,phone,customer_id,total,processdate " +
            "from customer join sales on customer.id = sales.customer_id where name=? or phone=?");
        prepareStatment.setString(1, search.getText());
        prepareStatment.setString(2, search.getText());
        ResultSet resultSet=prepareStatment.executeQuery();
        while(resultSet.next())
        {
           customerName.setText(resultSet.getString("name"));
           dateOfBuy.setText(resultSet.getString("processdate"));
           totalPrice.setText(resultSet.getInt("total")+""); 
           customerId=resultSet.getInt("customer_id"); 
        }
        conn.close();
    }
    public void deleteData() throws SQLException {
        /*
         * this method delete specific drug from the database
         */
       Connection conn= Database.getConnection();
       PreparedStatement prepareStatment=conn.prepareStatement("delete from sales where customer_id=?");
       prepareStatment.setInt(1,customerId);
       prepareStatment.executeUpdate();
       conn.commit();
       conn.close();
    }
    public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement prepareStatment1=conn.prepareStatement("select id from returns");
        ResultSet resultSet=prepareStatment1.executeQuery();
        int currentId=0;
        while(resultSet.next())
        {
        currentId=resultSet.getInt("id");
        }
        conn.close();
       newId=++currentId; 
       return newId;
    }
    public void insertData() throws SQLException {
        /*
         * this method insert the data into the database
         */
        Connection conn=Database.getConnection();
        PreparedStatement prepareStatment=conn.prepareStatement("insert into returns (id,customerid,reasons,returndate,total) values(?,?,?,?,?)");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datee = new Date();
        String temp=dateFormat.format(datee);
        prepareStatment.setInt(1, autoIncrementId());
        prepareStatment.setInt(2, customerId);
        prepareStatment.setString(3, rasonsOfReturns.getText());
        prepareStatment.setString(4, temp);
        prepareStatment.setInt(5, Integer.parseInt(totalPrice.getText()));
        prepareStatment.executeUpdate();
        conn.commit();
        conn.close();
    }
}
