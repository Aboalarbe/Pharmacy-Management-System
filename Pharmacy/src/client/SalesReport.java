package client;

import client.helpedClasses.Companies;
import client.helpedClasses.Drugs;

import client.helpedClasses.Saless;

import java.awt.BorderLayout;

import java.awt.Font;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.print.PrinterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.MessageFormat;

import java.util.ArrayList;

import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalesReport extends JFrame implements ActionListener
{
    JButton print;
    JTable table;
    ArrayList<Saless>allSales=new ArrayList<Saless>(); // to store in it the data which returned from the database

    public SalesReport() {
        super("Sales Report");
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void displayallSales() 
    {
        table=new JTable();
        DefaultTableModel model=new DefaultTableModel();
        //To set the Caption of the table column name
        Object[]columnNames =new Object[5];
        columnNames[0]="Id";
        columnNames[1]="Total";
        columnNames[2]="Customer Name";
        columnNames[3]="Drug Name";
        columnNames[4]="Date";
        try {
            getDrugDataFromDatabase();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
        model.setColumnIdentifiers(columnNames); // set the column names from the above array
        // get the affective data from the helped class which created in client.helpedClasses.
        Object[] rowData=new Object[5];
        for(int i=0;i<allSales.size();i++) {
            rowData[0]=allSales.get(i).getId();
            rowData[1]=allSales.get(i).getTatalPrice();
            rowData[2]=allSales.get(i).getCustomerName();
            rowData[3]=allSales.get(i).getDrugName();
            rowData[4]=allSales.get(i).getProcessDate();
            model.addRow(rowData);
        }
        print=new JButton("Print");
        print.addActionListener(this);
        table.setModel(model);
        table.setEnabled(false);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
        table.setAutoscrolls(true);
        table.setFillsViewportHeight(true); 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(30);
        table.setFont(new Font("sansSerif",0,18));
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        JScrollPane pane=new JScrollPane(table);
        panel.add(print,BorderLayout.PAGE_END);
        panel.add(pane,BorderLayout.CENTER);
        this.setContentPane(panel);
        
    }
    public void getDrugDataFromDatabase() throws SQLException {
        Connection conn=Database.getConnection();
        PreparedStatement PreparedStatement=conn.prepareStatement("select s.id,c.name,d.name,s.total,s.processdate from customer c join sales s on c.id=s.customer_id join drug d on s.drug_id=d.id order by s.id");
        ResultSet resultset=PreparedStatement.executeQuery();
        while(resultset.next()) {
            allSales.add(new Saless
                         (resultset.getInt("id"),
                         resultset.getInt("total"),
                         resultset.getString("name"),
                         resultset.getString("name"),
                         resultset.getString("processdate"))
                         );
        }
        conn.close();
    }

    public void actionPerformed(ActionEvent source) 
    {
        if(source.getSource()==print) 
        {
            MessageFormat header=new MessageFormat("Sales Informations");
            MessageFormat footer=new MessageFormat("Page (1)");
            try {
                table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            }
        }
    }
}
