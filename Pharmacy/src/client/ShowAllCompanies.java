package client;

import client.helpedClasses.Companies;
import client.helpedClasses.Drugs;

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

public class ShowAllCompanies extends JFrame implements ActionListener
{
    JButton print;
    JTable table;
    ArrayList<Companies>allCompanies=new ArrayList<Companies>(); // to store in it the data which returned from the database

    public ShowAllCompanies() {
        super("All Compines");
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void displayallCompanies() 
    {
        table=new JTable();
        DefaultTableModel model=new DefaultTableModel();
        //To set the Caption of the table column name
        Object[]columnNames =new Object[8];
        columnNames[0]="Id";
        columnNames[1]="Name";
        columnNames[2]="Phone";
        columnNames[3]="Branch";
        columnNames[4]="Website";
        columnNames[5]="Facebook";
        columnNames[6]="Rep.Name";
        columnNames[7]="Rep.Phone";
        try {
            getDrugDataFromDatabase();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
        model.setColumnIdentifiers(columnNames); // set the column names from the above array
        // get the affective data from the helped class which created in client.helpedClasses.
        Object[] rowData=new Object[8];
        for(int i=0;i<allCompanies.size();i++) {
            rowData[0]=allCompanies.get(i).getId();
            rowData[1]=allCompanies.get(i).getName();
            rowData[2]=allCompanies.get(i).getPhone();
            rowData[3]=allCompanies.get(i).getBranch();
            rowData[4]=allCompanies.get(i).getWebsite();
            rowData[5]=allCompanies.get(i).getFacebook();
            rowData[6]=allCompanies.get(i).getSalesRepresentativeName();
            rowData[7]=allCompanies.get(i).getRepresentativePhone();
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
        PreparedStatement PreparedStatement=conn.prepareStatement("select * from company order by id");
        ResultSet resultset=PreparedStatement.executeQuery();
        while(resultset.next()) {
            allCompanies.add(new Companies
                         (resultset.getInt("id"),
                         resultset.getString("name"),
                         resultset.getString("phone"),
                         resultset.getString("website"),
                         resultset.getString("facebook"),
                         resultset.getString("branch"),
                         resultset.getString("salesrepresentitve"),
                         resultset.getString("representativephone"))
                         );
        }
        conn.close();
    }

    public void actionPerformed(ActionEvent source) 
    {
        if(source.getSource()==print) 
        {
            MessageFormat header=new MessageFormat("Companies Informations");
            MessageFormat footer=new MessageFormat("Page (1)");
            try {
                table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            }
        }
    }
}
