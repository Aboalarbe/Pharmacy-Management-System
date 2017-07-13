package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Reports implements ActionListener{
    JFrame reportFrame;
    JButton dialyReport,monthelyReport,yearlyReport,profitReport,salesReport,purchasesReport,back;
    public void display() {
        reportFrame=new JFrame("Reports");
        reportFrame.setSize(500,300);
        reportFrame.setLocation(500, 250);
        
        dialyReport=new JButton("Daily Report");
        dialyReport.setSize(130, 40);
        dialyReport.setLocation(20, 20);
        dialyReport.addActionListener(this);
        reportFrame.add(dialyReport);
        
        monthelyReport=new JButton("Monthly Report");
        monthelyReport.setSize(130, 40);
        monthelyReport.setLocation(330, 20);
        monthelyReport.addActionListener(this);
        reportFrame.add(monthelyReport);
        
        yearlyReport=new JButton("Yearly Report");
        yearlyReport.setSize(130, 40);
        yearlyReport.setLocation(20, 170);
        yearlyReport.addActionListener(this);
        reportFrame.add(yearlyReport);
        
        salesReport=new JButton("Sales Report");
        salesReport.setSize(130, 40);
        salesReport.setLocation(20, 100);
        salesReport.addActionListener(this);
        reportFrame.add(salesReport);
        
        profitReport=new JButton("Profit Report");
        profitReport.setSize(130, 40);
        profitReport.setLocation(330, 170);
        profitReport.addActionListener(this);
        reportFrame.add(profitReport);
        
        purchasesReport=new JButton("Purchas Report");
        purchasesReport.setSize(130, 40);
        purchasesReport.setLocation(330, 100);
        purchasesReport.addActionListener(this);
        reportFrame.add(purchasesReport);
        
        back=new JButton("Back");
        back.setSize(90, 40);
        back.setLocation(200, 210);
        back.addActionListener(this);
        reportFrame.add(back);
        
        reportFrame.setLayout(null);
        reportFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent source)
    {
       JButton clickedButton=(JButton)source.getSource(); 
       if(clickedButton==dialyReport) 
       {
           
       }
       else if(clickedButton==monthelyReport)
       {
           
       }
       else if(clickedButton==yearlyReport)
       {
           
       }
       else if(clickedButton==profitReport) 
       {
           
       }
       else if(clickedButton==salesReport) 
       {
           SalesReport obj=new SalesReport();
           obj.displayallSales();
       }
       else
          reportFrame.setVisible(false);

    }
}
