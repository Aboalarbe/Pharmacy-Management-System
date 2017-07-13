package client;

import javax.swing.JFrame;   
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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JTextArea;
    import javax.swing.JTextField;

public class Stock implements ActionListener {

    JFrame drugFrame;
    JLabel drugName_,distributionCompanyName_,drugCode_,productionCompanyName_,productionDate_,expirationDate_,drugType_,drugQuantity_,stripes_,drugPrice,search;
    JTextField drugName,distributionCompanyName,drugCode,productionCompanyName,drugQuantity,stripes,jprice,jsearch;
    JComboBox drugType;
    JButton add,back,update,delete,show,showAll;
    JFormattedTextField expirationDate,productionDate;
    double totalPrice;
    public void display()
    {
        drugFrame=new JFrame("Medicenes Stock");
        drugFrame.setExtendedState(drugFrame.MAXIMIZED_BOTH);
        drugFrame.setDefaultCloseOperation(drugFrame.EXIT_ON_CLOSE);
        
        search=new JLabel("Search For the Drug By Name or Code");
        search.setSize(400, 30);
        search.setLocation(855,30);
        search.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(search);
        
        jsearch=new JTextField();
        jsearch.setSize(400, 40);
        jsearch.setLocation(835,70);
        jsearch.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(jsearch);
        
        add=new JButton("Add New");
        add.setSize(120, 40);
        add.setLocation(1230, 650);
        add.addActionListener(this);
        drugFrame.add(add);
        
        update=new JButton("Update");
        update.setSize(120, 40);
        update.setLocation(980, 120);
        update.addActionListener(this);
        drugFrame.add(update);
        
        delete=new JButton("Delete");
        delete.setSize(120, 40);
        delete.setLocation(1120, 120);
        delete.addActionListener(this);
        drugFrame.add(delete);
        
        show=new JButton("Show");
        show.setSize(120, 40);
        show.setLocation(840, 120);
        show.addActionListener(this);
        drugFrame.add(show);
        
        back=new JButton("Back");
        back.setSize(120, 40);
        back.setLocation(1100, 650);
        back.addActionListener(this);
        drugFrame.add(back);
        
        showAll=new JButton("Show All Drugs");
        showAll.setSize(200, 40);
        showAll.setLocation(940, 190);
        showAll.addActionListener(this);
        drugFrame.add(showAll);
        
        drugCode_=new JLabel("Drug Code");
        drugCode_.setSize(230, 30);
        drugCode_.setLocation(20,20);
        drugCode_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(drugCode_);
        
        drugCode=new JTextField();
        drugCode.setSize(300,30);
        drugCode.setLocation(250,20);
        drugCode.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(drugCode);
        
        drugName_=new JLabel("Drug Name");
        drugName_.setSize(230, 30);
        drugName_.setLocation(20,70);
        drugName_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(drugName_);
        
        drugName=new JTextField();
        drugName.setSize(300,30);
        drugName.setLocation(250,70);
        drugName.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(drugName);
        
        distributionCompanyName_=new JLabel("Distribution Company");
        distributionCompanyName_.setSize(250, 30);
        distributionCompanyName_.setLocation(0,120);
        distributionCompanyName_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(distributionCompanyName_);
        
        distributionCompanyName=new JTextField();
        distributionCompanyName.setSize(300,30);
        distributionCompanyName.setLocation(250,120);
        distributionCompanyName.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(distributionCompanyName);
        
        productionCompanyName_=new JLabel("Production Company");
        productionCompanyName_.setSize(250, 30);
        productionCompanyName_.setLocation(0,170);
        productionCompanyName_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(productionCompanyName_);
        
        productionCompanyName=new JTextField();
        productionCompanyName.setSize(300,30);
        productionCompanyName.setLocation(250,170);
        productionCompanyName.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(productionCompanyName);
        
        productionDate_=new JLabel("Production Date");
        productionDate_.setSize(230, 30);
        productionDate_.setLocation(20,220);
        productionDate_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(productionDate_);
        
        productionDate=new JFormattedTextField("DD/MM/YYYY");
        productionDate.setSize(300,30);
        productionDate.setLocation(250,220);
        productionDate.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(productionDate);
        
        expirationDate_=new JLabel("Expiration Date");
        expirationDate_.setSize(230, 30);
        expirationDate_.setLocation(20,270);
        expirationDate_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(expirationDate_);
        
        expirationDate=new JFormattedTextField("DD/MM/YYYY");
        expirationDate.setSize(300,30);
        expirationDate.setLocation(250,270);
        expirationDate.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(expirationDate);
        
        drugType_=new JLabel("Drug Type");
        drugType_.setSize(230, 30);
        drugType_.setLocation(20,320);
        drugType_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(drugType_);
        
        String[] typeStrings = {"","tablets","drinking medicenes","ointments","injection","suppository","eye drop","children drops","vitamins","antibiotics","medicine supplies","beauty kits"};
         drugType= new JComboBox(typeStrings);
         drugType.setSize(300,40);
         drugType.setLocation(250,320);
         drugType.setFont(new Font("Sans Serif", 0       , 20));
         drugFrame.add(drugType);
         drugType.getSelectedItem();
        
        drugQuantity_=new JLabel("Drug Quantity");
        drugQuantity_.setSize(230, 30);
        drugQuantity_.setLocation(20,370);
        drugQuantity_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(drugQuantity_);
        
        drugQuantity=new JTextField();
        drugQuantity.setSize(300,30);
        drugQuantity.setLocation(250,370);
        drugQuantity.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(drugQuantity);
        
        stripes_=new JLabel("No. Stripes");
        stripes_.setSize(230, 30);
        stripes_.setLocation(20,420);
        stripes_.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(stripes_);
        
        stripes=new JTextField();
        stripes.setSize(300,30);
        stripes.setLocation(250,420);
        stripes.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(stripes);
        
        drugPrice=new JLabel("Drug Price");
        drugPrice.setSize(230, 30);
        drugPrice.setLocation(20,470);
        drugPrice.setFont(new Font("Sans Serif", 0, 25));
        drugFrame.add(drugPrice);
        
        jprice=new JTextField();
        jprice.setSize(300,30);
        jprice.setLocation(250,470);
        jprice.setFont(new Font("Sans Serif", 0, 20));
        drugFrame.add(jprice);
        
        drugFrame.setLayout(null);
        drugFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent source) 
    {
        JButton clickedButton=(JButton)source.getSource();
        if(clickedButton==add)
    {
        if(drugQuantity.getText().isEmpty()||jprice.getText().isEmpty()
           ||drugQuantity.getText().isEmpty()||drugCode.getText().isEmpty()||drugName.getText().isEmpty()) 
        {
              JOptionPane.showMessageDialog(null, "Enter All Data please","Error",0);
        }
        else
      {
        try {
            addNewDrug();
            JOptionPane.showMessageDialog(null, "The Drug Successfully Added", "Success", 1);
            updateGui();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
      }
    }
    else if(clickedButton==show) 
    {
        if(jsearch.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Enter the Name of The Drug", "Erorr", 0);
        else
      {
            try {
            displaySpecificDrug();
            add.setEnabled(false);
            expirationDate.setEditable(false);
            productionDate.setEditable(false);
            drugCode.setEditable(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
      }
    }
     else if(clickedButton==update) 
    {
        try {
            updateDataase();
            JOptionPane.showMessageDialog(null,"The Data Updated Successfully","Success",1);
            updateGui();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
    }
      else if(clickedButton==delete)  
    {
        if(jsearch.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Enter the Name of The Drug", "Erorr", 0);
        else
      {
        try {
            removeSpecificDrug();
            JOptionPane.showMessageDialog(null,"The Drug Deleted Successfully","Success",1);
            updateGui();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
        }
      }
    }
       else if(clickedButton==showAll) 
        {
            ShowALLDrugsInStock obj=new ShowALLDrugsInStock();
            obj.displayAllDrugs();
        }
      else
    {
            drugFrame.setVisible(false);
            Manager obj=new Manager();
    }
    }
    public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement ps1=conn.prepareStatement("select id from medecinestock");
        ResultSet rs=ps1.executeQuery();
        int currentId=0;
        while(rs.next())
        {
        currentId=rs.getInt("id");
        }
       newId=++currentId; 
       return newId;
    }
    public void addNewDrug() throws SQLException {
        /*
         * this method insert the procees date and auto increment id
         */
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into medecinestock (id,code,name,type,numberofstripes,productioncompany," +
            "distributioncompany,quantity,price,expirationdate,productiondate) values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1,autoIncrementId());
        ps.setString(2, drugCode.getText());
        ps.setString(3, drugName.getText());
        ps.setString(4, drugType.getSelectedItem().toString());
        ps.setInt(5, Integer.parseInt(stripes.getText()));
        ps.setString(6, productionCompanyName.getText());
        ps.setString(7, distributionCompanyName.getText());
        ps.setInt(8, Integer.parseInt(drugQuantity.getText()));
        ps.setInt(9, Integer.parseInt(jprice.getText()));
        ps.setString(10, expirationDate.getText());
        ps.setString(11, productionDate.getText());         
        ps.executeUpdate();
        conn.commit();
        conn.close();
    }
    public void displaySpecificDrug() throws SQLException {
        /*
         * this method get the data from the database and set them into the form
         */
        Connection conn= Database.getConnection();
        conn = Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from medecinestock where name=? or code=?");
        ps.setString(1, jsearch.getText());
        ps.setString(2, jsearch.getText());
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
           drugCode.setText(rs.getString("code"));
            drugName.setText(rs.getString("name"));
            drugType.setSelectedItem(rs.getString("type"));
            stripes.setText(rs.getInt("numberofstripes")+"");
            productionCompanyName.setText(rs.getString("productioncompany"));
            distributionCompanyName.setText(rs.getString("distributioncompany"));
            drugQuantity.setText(rs.getString("quantity"));
            jprice.setText(rs.getString("price"));
            expirationDate.setText(rs.getString("expirationdate"));
            productionDate.setText(rs.getString("productiondate"));
        }
        conn.close();
    }
    public void removeSpecificDrug() throws SQLException {
        /*
         * this method delete specific drug from the database
         */
       Connection conn= Database.getConnection();
       PreparedStatement ps=conn.prepareStatement("delete from medecinestock where name=?");
       ps.setString(1, jsearch.getText());
       ps.executeUpdate();
       conn.commit();
       conn.close();
    }
    public void updateDataase() throws SQLException {
        /*
         * this method update the drug data in the database 
         */
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("update medecinestock set name=?,type=?,numberofstripes=?" +
            ",productioncompany=?,distributioncompany=?,quantity=?,price=? where name=?");
        ps.setString(1, drugName.getText());
        ps.setString(2, drugType.getSelectedItem().toString());
        ps.setInt(3,Integer.parseInt( stripes.getText()));
        ps.setString(4, productionCompanyName.getText());
        ps.setString(5, distributionCompanyName.getText());
        ps.setInt(6, Integer.parseInt(drugQuantity.getText()));
        ps.setInt(7, Integer.parseInt(jprice.getText()));
        ps.setString(8, jsearch.getText());
        ps.executeUpdate();
        conn.commit();
        conn.close();
    }
    public void updateGui() {
        /*
         * this method update the form (GUI) after the sale operation done 
         * calc the total price for the client
         */
        drugCode.setText("");
        distributionCompanyName.setText("");
        expirationDate.setText("");
        drugName.setText("");
        productionCompanyName.setText("");
        jprice.setText("");
        productionDate.setText("");
        drugQuantity.setText("");
        stripes.setText("");
        drugType.setSelectedItem("");
        jsearch.setText("");
    }
}
