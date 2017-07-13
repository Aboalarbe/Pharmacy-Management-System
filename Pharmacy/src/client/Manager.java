package client;

import client.helpedClasses.About;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;

import java.io.File;
import java.io.IOException;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Manager implements ActionListener
{
    JFrame managerFrame;
    JButton reports,stock,companies,emplyees,saleProduct, purchases, returns, calculator, pharmacyIndexing, drugs,about,exit;
    public Manager() {
        try {
             if(!(isManager())) {
                 managerFrame=new JFrame("Manager");
                 managerFrame.setExtendedState(managerFrame.MAXIMIZED_BOTH);
                 managerFrame.setDefaultCloseOperation(managerFrame.EXIT_ON_CLOSE);
                 
                 //to add background Image
                 try {
                        managerFrame. setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("pharmacy.jpg")))));
                         } catch (IOException e) {
                            System.out.print(e.getMessage());
                    }
                 
                 saleProduct=new JButton("Sale Products");
                 saleProduct.setSize(200, 70);
                 saleProduct.setLocation(620,40);
                 saleProduct.setFont(new Font("Sans Serif", 0    , 18));
                 saleProduct.addActionListener(this);
                 managerFrame.add(saleProduct);
                 
                 purchases=new JButton("Purchases");
                 purchases.setSize(200, 70);
                 purchases.setLocation(70,40);
                 purchases.setFont(new Font("Sans Serif", 0    , 18));
                 purchases.addActionListener(this);
                 managerFrame.add(purchases);
                 purchases.setEnabled(false);
                 
                 returns=new JButton("Returns");
                 returns.setSize(200, 70);
                 returns.setLocation(1100,40);
                 returns.setFont(new Font("Sans Serif", 0    , 18));
                 returns.addActionListener(this);
                 managerFrame.add(returns);
                 
                 drugs=new JButton("Drugs");
                 drugs.setSize(200,70);
                 drugs.setLocation(70,250);
                 drugs.setFont(new Font("Sans Serif", 0    , 18));
                 drugs.addActionListener(this);
                 managerFrame.add(drugs);
                 drugs.setEnabled(false);
                 
                 companies=new JButton("Companies");
                 companies.setSize(200, 70);
                 companies.setLocation(620,250);
                 companies.setFont(new Font("Sans Serif", 0    , 18));
                 companies.addActionListener(this);
                 managerFrame.add(companies);
                 companies.setEnabled(false);
                 
                 emplyees=new JButton("Employees");
                 emplyees.setSize(200,70);
                 emplyees.setLocation(1100,250);
                 emplyees.setFont(new Font("Sans Serif", 0    , 18));
                 emplyees.addActionListener(this);
                 managerFrame.add(emplyees);
                 emplyees.setEnabled(false);
                 
                 pharmacyIndexing=new JButton("Indexing");
                 pharmacyIndexing.setSize(200, 70);
                 pharmacyIndexing.setLocation(70,450);
                 pharmacyIndexing.setFont(new Font("Sans Serif", 0    , 18));
                 pharmacyIndexing.addActionListener(this);
                 managerFrame.add(pharmacyIndexing);
                 
                 calculator=new JButton(" Calculator");
                 calculator.setSize(200, 70);
                 calculator.setLocation(620,620);
                 calculator.setFont(new Font("Sans Serif", 0    , 18));
                 calculator.addActionListener(this);
                 managerFrame.add(calculator);
                 
                 about=new JButton("About");
                 about.setSize(200, 70);
                 about.setLocation(70,620);
                 about.setFont(new Font("Sans Serif", 0    , 18));
                 about.addActionListener(this);
                 managerFrame.add(about);
                 
                 exit=new JButton("Exit");
                 exit.setSize(200, 70);
                 exit.setLocation(1100,620);
                 exit.setFont(new Font("Sans Serif", 0    , 18));
                 exit.addActionListener(this);
                 managerFrame.add(exit);
                 
                 
                 reports=new JButton("Reports");
                 reports.setSize(200, 70);
                 reports.setLocation(620,450);
                 reports.setFont(new Font("Sans Serif", 0    , 18));
                 reports.addActionListener(this);
                 managerFrame.add(reports);
                 reports.setEnabled(false);
                 
                 stock=new JButton("Medicine Stock");
                 stock.setSize(200, 70);
                 stock.setLocation(1100,450);
                 stock.setFont(new Font("Sans Serif", 0    , 18));
                 stock.addActionListener(this);
                 managerFrame.add(stock);
                 stock.setEnabled(false);
                 
                 managerFrame.setLayout(null);
                 managerFrame.setVisible(true);
             }
            else {
                 managerFrame=new JFrame("Manager");
                 managerFrame.setExtendedState(managerFrame.MAXIMIZED_BOTH);
                 managerFrame.setDefaultCloseOperation(managerFrame.EXIT_ON_CLOSE);
                 
                 //to add background Image
                 try {
                        managerFrame. setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("pharmacy.jpg")))));
                         } catch (IOException e) {
                            System.out.print(e.getMessage());
                    }
                
                 saleProduct=new JButton("Sale Products");
                 saleProduct.setSize(200, 70);
                 saleProduct.setLocation(620,40);
                 saleProduct.setFont(new Font("Sans Serif", 0    , 18));
                 saleProduct.addActionListener(this);
                 managerFrame.add(saleProduct);
                 
                 purchases=new JButton("Purchases");
                 purchases.setSize(200, 70);
                 purchases.setLocation(70,40);
                 purchases.setFont(new Font("Sans Serif", 0    , 18));
                 purchases.addActionListener(this);
                 managerFrame.add(purchases);
                 
                 returns=new JButton("Returns");
                 returns.setSize(200, 70);
                 returns.setLocation(1100,40);
                 returns.setFont(new Font("Sans Serif", 0    , 18));
                 returns.addActionListener(this);
                 managerFrame.add(returns);
                 
                 drugs=new JButton("Drugs");
                 drugs.setSize(200,70);
                 drugs.setLocation(70,250);
                 drugs.setFont(new Font("Sans Serif", 0    , 18));
                 drugs.addActionListener(this);
                 managerFrame.add(drugs);
                 
                 companies=new JButton("Companies");
                 companies.setSize(200, 70);
                 companies.setLocation(620,250);
                 companies.setFont(new Font("Sans Serif", 0    , 18));
                 companies.addActionListener(this);
                 managerFrame.add(companies);
                 
                 emplyees=new JButton("Employees");
                 emplyees.setSize(200,70);
                 emplyees.setLocation(1100,250);
                 emplyees.setFont(new Font("Sans Serif", 0    , 18));
                 emplyees.addActionListener(this);
                 managerFrame.add(emplyees);
                 
                 pharmacyIndexing=new JButton("Indexing");
                 pharmacyIndexing.setSize(200, 70);
                 pharmacyIndexing.setLocation(70,450);
                 pharmacyIndexing.setFont(new Font("Sans Serif", 0    , 18));
                 pharmacyIndexing.addActionListener(this);
                 managerFrame.add(pharmacyIndexing);
                 
                 calculator=new JButton(" Calculator");
                 calculator.setSize(200, 70);
                 calculator.setLocation(620,620);
                 calculator.setFont(new Font("Sans Serif", 0    , 18));
                 calculator.addActionListener(this);
                 managerFrame.add(calculator);
                 
                 about=new JButton("About");
                 about.setSize(200, 70);
                 about.setLocation(70,620);
                 about.setFont(new Font("Sans Serif", 0    , 18));
                 about.addActionListener(this);
                 managerFrame.add(about);
                 
                 exit=new JButton("Exit");
                 exit.setSize(200, 70);
                 exit.setLocation(1100,620);
                 exit.setFont(new Font("Sans Serif", 0    , 18));
                 exit.addActionListener(this);
                 managerFrame.add(exit);
                 
                 reports=new JButton("Reports");
                 reports.setSize(200, 70);
                 reports.setLocation(620,450);
                 reports.setFont(new Font("Sans Serif", 0    , 18));
                 reports.addActionListener(this);
                 managerFrame.add(reports);
                 
                 stock=new JButton("Medicine Stock");
                 stock.setSize(200, 70);
                 stock.setLocation(1100,450);
                 stock.setFont(new Font("Sans Serif", 0    , 18));
                 stock.addActionListener(this);
                 managerFrame.add(stock);
                 
                 managerFrame.setLayout(null);
                 managerFrame.setVisible(true);
             }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
    }
    public void actionPerformed(ActionEvent source) 
    {
        JButton clickedButton=(JButton)source.getSource();
        if(clickedButton==saleProduct) 
        {
            Customer obj=new Customer();
            obj.display();
            managerFrame.setVisible(false);
        }
        else if(clickedButton==purchases)
        {
            Purchases obj=new Purchases();
            obj.display();
            managerFrame.setVisible(false);
        }
        else if(clickedButton==returns) 
        {
            Returns obj=new Returns();
            obj.display();
            managerFrame.setVisible(false);
        }
        else if(clickedButton==drugs)
        {
            Drug obj=new Drug();
            obj.display();
            managerFrame.setVisible(false);
        }
        else if(clickedButton== calculator)
        {
            try {
                Runtime.getRuntime().exec("calc");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        else if(clickedButton==pharmacyIndexing)
        {
            managerFrame.setVisible(false);
            Indexing obj=new Indexing();
            obj.display();
        }
        else if(clickedButton== reports) 
        {
            Reports obj=new Reports();
            obj.display();
        }
        else if(clickedButton==companies) 
        {
            managerFrame.setVisible(false);
            Company obj=new Company();
            obj.dispaly();
        }
        else if(clickedButton==emplyees) 
        {
            managerFrame.setVisible(false);
            Employee obj=new Employee();
            obj.dispaly();
        }
        else if(clickedButton==stock)
        {   
            managerFrame.setVisible(false);
            Stock obj=new Stock();
            obj.display();
        }
        else if(clickedButton==about) 
        {
            About obj=new About();
            obj.display();
        }
        else
        managerFrame.dispatchEvent(new WindowEvent(managerFrame, WindowEvent.WINDOW_CLOSING));
    }
    public boolean isManager() throws SQLException {
        /*
         * this method check if the user if (manager/employee) 
         * to enable some functios to the manager 
         */
        boolean employeeRole=false;
        Connection conn=Database.getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement("select flag from login where username=?");
        preparedStatement.setString(1, Login.USERNAME);
        ResultSet resultset=preparedStatement.executeQuery();
        while(resultset.next()) {
            employeeRole=resultset.getBoolean("flag");
        }
        return employeeRole;
    }
}
