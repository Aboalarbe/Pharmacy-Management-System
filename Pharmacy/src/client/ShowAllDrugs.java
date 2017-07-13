package client;

import client.helpedClasses.Drugs;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;

import java.awt.ScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.print.PrinterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.MessageFormat;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowAllDrugs extends JFrame implements ActionListener
{
    JButton print;
    JTable table;
    ArrayList<Drugs>allDrugs=new ArrayList<Drugs>(); // to store in it the data which returned from the database

    public ShowAllDrugs() {
        super("All Drugs");
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void displayAllDrugs() 
    {
         table=new JTable();
        DefaultTableModel model=new DefaultTableModel();
        //To set the Caption of the table column name
        Object[]columnNames =new Object[10];
        columnNames[0]="Id";
        columnNames[1]="Code";
        columnNames[2]="Name";
        columnNames[3]="No.Stripes";
        columnNames[4]="Quantity";
        columnNames[5]="Price";
        columnNames[6]="Type";
        columnNames[7]="Production";
        columnNames[8]="Pro.Date";
        columnNames[9]="Exp.Date";
        try {
            getDrugDataFromDatabase();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
        model.setColumnIdentifiers(columnNames); // set the column names from the above array
        // get the affective data from the helped class which created in client.helpedClasses.
        Object[] rowData=new Object[10];
        for(int i=0;i<allDrugs.size();i++) {
            rowData[0]=allDrugs.get(i).getId();
            rowData[1]=allDrugs.get(i).getCode();
            rowData[2]=allDrugs.get(i).getName();
            rowData[3]=allDrugs.get(i).getNumberOfStripes();
            rowData[4]=allDrugs.get(i).getQuantity();
            rowData[5]=allDrugs.get(i).getPrice();
            rowData[6]=allDrugs.get(i).getType();
            rowData[7]=allDrugs.get(i).getProductioncompany();
            rowData[8]=allDrugs.get(i).getProductiondate();
            rowData[9]=allDrugs.get(i).getExpirationdate();
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
        panel.add(pane,BorderLayout.CENTER);
        panel.add(print,BorderLayout.AFTER_LAST_LINE);
        this.setContentPane(panel);
        
    }
    public void actionPerformed(ActionEvent source) 
    {
        if(source.getSource()==print) 
        {
            MessageFormat header=new MessageFormat("All Available Drugs");
            MessageFormat footer=new MessageFormat("Page (1)");
            try {
                table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            }
        }
    }
    public void getDrugDataFromDatabase() throws SQLException {
        Connection conn=Database.getConnection();
        PreparedStatement PreparedStatement=conn.prepareStatement("select * from drug order by id");
        ResultSet resultset=PreparedStatement.executeQuery();
        while(resultset.next()) {
            allDrugs.add(new Drugs(resultset.getInt("id"),
                         resultset.getInt("quantity"),
                         resultset.getInt("numberofstripes"),
                         resultset.getInt("price"),
                         resultset.getString("name"),
                         resultset.getString("type"),
                         resultset.getString("productiondate"),
                         resultset.getString("expirationdate"),
                         resultset.getString("code"),
                         resultset.getString("productioncompany"))
                         );
        }
        conn.close();
    }
}
