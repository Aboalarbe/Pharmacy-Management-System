package client;

import client.helpedClasses.Companies;
import client.helpedClasses.Drugs;

import client.helpedClasses.Employees;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowAllEmployees extends JFrame implements ActionListener
{
    JButton print;
    JTable table;
    ArrayList<Employees>allEmployees=new ArrayList<Employees>(); // to store in it the data which returned from the database

    public ShowAllEmployees() {
        super("All Emloyees");
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void displayallEmployees() 
    {
        table=new JTable();
        DefaultTableModel model=new DefaultTableModel();
        //To set the Caption of the table column name
        Object[]columnNames =new Object[7];
        columnNames[0]="Id";
        columnNames[1]="Name";
        columnNames[2]="Phone";
        columnNames[3]="SSn";
        columnNames[4]="E-Mail";
        columnNames[5]="Salary";
        columnNames[6]="Address";
        try {
            getDrugDataFromDatabase();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
        model.setColumnIdentifiers(columnNames); // set the column names from the above array
        // get the affective data from the helped class which created in client.helpedClasses.
        Object[] rowData=new Object[7];
        for(int i=0;i<allEmployees.size();i++) {
            rowData[0]=allEmployees.get(i).getId();
            rowData[1]=allEmployees.get(i).getName();
            rowData[2]=allEmployees.get(i).getPhone();
            rowData[3]=allEmployees.get(i).getSequrityNumber();
            rowData[4]=allEmployees.get(i).getEmail();
            rowData[5]=allEmployees.get(i).getSalary();
            rowData[6]=allEmployees.get(i).getAddress();
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
        panel.add(print,BorderLayout.AFTER_LAST_LINE);
        panel.add(pane,BorderLayout.CENTER);
        this.setContentPane(panel);
        
    }
    public void actionPerformed(ActionEvent source) 
    {
        if(source.getSource()==print) 
        {
            MessageFormat header=new MessageFormat("Employees Informations");
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
        PreparedStatement PreparedStatement=conn.prepareStatement("select * from employee order by id");
        ResultSet resultset=PreparedStatement.executeQuery();
        while(resultset.next()) {
            allEmployees.add(new Employees
                             (resultset.getInt("id"),
                              resultset.getInt("salary"),
                              resultset.getString("name"),
                              resultset.getString("phone"),
                              resultset.getString("ssn"),
                              resultset.getString("email"),
                              resultset.getString("address"))
                             );
        }
        conn.close();
    }
}
