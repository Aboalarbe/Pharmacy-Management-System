package client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;   
    import java.awt.Font;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import javax.swing.JButton;
import javax.swing.JFormattedTextField;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
    import javax.swing.JTextField;
public class Company implements ActionListener {
    JFrame companyFrame;
    JLabel companyName_,companyPhone_,companyWebsite_,companyFacebook_,companyBranch_,salesManName_,salesManPhone_,companySearch_;
    JTextField companyName,companyPhone,companyWebsite,companyFacebook,salesManName,salesManPhone,companyBranch,companySearch;
    JButton add,back,update,delete,show,showAll;
    public void dispaly() {
        companyFrame=new JFrame("Companies");
                    companyFrame.setExtendedState(companyFrame.MAXIMIZED_BOTH);
                    companyFrame.setDefaultCloseOperation(companyFrame.EXIT_ON_CLOSE);
                    
                    companySearch_=new JLabel("Search For the Company By Name");
                    companySearch_.setSize(400, 30);
                    companySearch_.setLocation(855,30);
                    companySearch_.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(companySearch_);
                    
                    companySearch=new JTextField();
                    companySearch.setSize(400, 40);
                    companySearch.setLocation(835,70);
                    companySearch.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(companySearch);
                    
                    add=new JButton("Add New");
                    add.setSize(120, 40);
                    add.setLocation(1230, 650);
                    add.addActionListener(this);
                    companyFrame.add(add);
                    
                    update=new JButton("Update");
                    update.setSize(120, 40);
                    update.setLocation(980, 120);
                    update.addActionListener(this);
                    companyFrame.add(update);
                    
                    delete=new JButton("Delete");
                    delete.setSize(120, 40);
                    delete.setLocation(1120, 120);
                    delete.addActionListener(this);
                    companyFrame.add(delete);
                    
                    show=new JButton("Show");
                    show.setSize(120, 40);
                    show.setLocation(840, 120);
                    show.addActionListener(this);
                    companyFrame.add(show);
                    
                    back=new JButton("Back");
                    back.setSize(120, 40);
                    back.setLocation(1100, 650);
                    back.addActionListener(this);
                    companyFrame.add(back);
                    
                    showAll=new JButton("Show All Companies");
                    showAll.setSize(200, 40);
                    showAll.setLocation(940, 190);
                    showAll.addActionListener(this);
                    companyFrame.add(showAll);
                    
                    companyName_=new JLabel("Company Name");
                    companyName_.setSize(230, 30);
                    companyName_.setLocation(0,30);
                    companyName_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(companyName_);
                    
                    companyName=new JTextField();
                    companyName.setSize(300,30);
                    companyName.setLocation(250,30);
                    companyName.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(companyName);
                    
                    companyPhone_=new JLabel("Company Phone");
                    companyPhone_.setSize(250, 30);
                    companyPhone_.setLocation(0,100);
                    companyPhone_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(companyPhone_);
                    
                    companyPhone=new JTextField();
                    companyPhone.setSize(300,30);
                    companyPhone.setLocation(250,100);
                    companyPhone.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(companyPhone);
                    
                    companyWebsite_=new JLabel("Company Website");
                    companyWebsite_.setSize(230, 30);
                    companyWebsite_.setLocation(0,170);
                    companyWebsite_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(companyWebsite_);
        
                    companyWebsite=new JTextField();
                    companyWebsite.setSize(300,30);
                    companyWebsite.setLocation(250,170);
                    companyWebsite.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(companyWebsite);
                    
                    companyFacebook_=new JLabel("Company Facebook");
                    companyFacebook_.setSize(250, 30);
                    companyFacebook_.setLocation(0,240);
                    companyFacebook_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(companyFacebook_);
        
                    companyFacebook=new JTextField();
                    companyFacebook.setSize(300,30);
                    companyFacebook.setLocation(250,240);
                    companyFacebook.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(companyFacebook);
                    
                    companyBranch_=new JLabel("Company Branch ");
                    companyBranch_.setSize(230, 30);
                    companyBranch_.setLocation(0,310);
                    companyBranch_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(companyBranch_);
                    
                    companyBranch=new JTextField();
                    companyBranch.setSize(300,30);
                    companyBranch.setLocation(250,310);
                    companyBranch.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(companyBranch);
                    
                    salesManName_=new JLabel("Sales Representatitve");
                    salesManName_.setSize(250, 30);
                    salesManName_.setLocation(0,380);
                    salesManName_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(salesManName_);
                    
                    salesManName=new JTextField();
                    salesManName.setSize(300,30);
                    salesManName.setLocation(250,380);
                    salesManName.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(salesManName);
                    
                    salesManPhone_=new JLabel("Representative Phone");
                    salesManPhone_.setSize(250, 30);
                    salesManPhone_.setLocation(0,450);
                    salesManPhone_.setFont(new Font("Sans Serif", 0, 25));
                    companyFrame.add(salesManPhone_);
                    
                    salesManPhone=new JTextField();
                    salesManPhone.setSize(300,30);
                    salesManPhone.setLocation(250,450);
                    salesManPhone.setFont(new Font("Sans Serif", 0, 20));
                    companyFrame.add(salesManPhone);
                    
                    companyFrame.setLayout(null);
                    companyFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent source) 
    {

        JButton clickedButton=(JButton)source.getSource();
        if(clickedButton==add)
        {      if(companyName.getText().isEmpty()||companyBranch.getText().isEmpty()||salesManName.getText().isEmpty()
                ||companyWebsite.getText().isEmpty()||companyPhone.getText().isEmpty()||companyFacebook.getText().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Enter All Data please","Error",0);
               }
        else
           {
        try {    
                registerNewCompany();
                JOptionPane.showMessageDialog(null, "The Company Successfully Added", "Success", 1);
                Purchases obj=new Purchases();
                obj.display();
                companyFrame.setVisible(false);
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
            }
          }
        }
        else if(clickedButton==show)
        {
            if(companySearch.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "Enter the Name of The company", "Erorr", 0);
        else
        {
        try {
            displaySpecificCompany();
            add.setEnabled(false);
             } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
            }
         }
        }
        else if(clickedButton==update)
        {
        try {
             updateSpecificCompany();
             JOptionPane.showMessageDialog(null,"The Data Updated Successfully","Success",1);
             updateGui();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
             }
        }
        else if(clickedButton==delete)
        {
            if(companySearch.getText().isEmpty())
             JOptionPane.showMessageDialog(null, "Enter the Name of The company", "Erorr", 0);
        else
         {
            try {
              deleteSpecificCompany();
              JOptionPane.showMessageDialog(null,"The Cpmpany Deleted Successfully","Success",1);
              updateGui();
              } catch (SQLException e) {
               JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
             }
          }       
        }
        else if(clickedButton==showAll)
        {
            ShowAllCompanies obj=new ShowAllCompanies();
            obj.displayallCompanies();
        }
        else
        {
            companyFrame.setVisible(false);
            Manager obj=new Manager();
        }
        }
        public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id for companyFrame table
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement prepareStatment1=conn.prepareStatement("select id from company");
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
        public void registerNewCompany() throws SQLException {
        /*
         * this method insert the companyFrame data into the database
         */
        Connection conn=Database.getConnection();
        PreparedStatement prepareStatment=conn.prepareStatement("insert into company(id,name,phone,website,facebook,branch," +
            "salesrepresentitve,representativephone) values(?,?,?,?,?,?,?,?)");
        prepareStatment.setInt(1,autoIncrementId());
        prepareStatment.setString(2, companyName.getText());
        prepareStatment.setString(3, companyPhone.getText());
        prepareStatment.setString(4, companyWebsite.getText());
        prepareStatment.setString(5, companyFacebook.getText());
        prepareStatment.setString(6,companyBranch.getText());
        prepareStatment.setString(7, salesManName.getText());
        prepareStatment.setString(8, salesManPhone.getText()); 
        prepareStatment.executeUpdate();
        conn.commit();
        conn.close();
        }
        public void displaySpecificCompany() throws SQLException {
        /*
         * this method get the data from the database and set them into the form
         */
        Connection conn= Database.getConnection();
        conn = Database.getConnection();
        PreparedStatement prepareStatment=conn.prepareStatement("select * from company where name=?");
        prepareStatment.setString(1, companySearch.getText());
        ResultSet resultSet=prepareStatment.executeQuery();
        while(resultSet.next())
        {
            companyName.setText(resultSet.getString("name"));
            companyPhone.setText(resultSet.getString("phone"));
            companyWebsite.setText(resultSet.getString("website"));
            salesManName.setText(resultSet.getString("salesrepresentitve"));
            companyFacebook.setText(resultSet.getString("facebook"));
            salesManPhone.setText(resultSet.getString("representativephone"));
            companyBranch.setText(resultSet.getString("branch"));
        }
        conn.close();
        }
        public void deleteSpecificCompany() throws SQLException {
        /*
         * this method delete specific companyFrame from the database
         */
        Connection conn= Database.getConnection();
        PreparedStatement prepareStatment=conn.prepareStatement("delete from company where name=?");
        prepareStatment.setString(1, companySearch.getText());
        prepareStatment.executeUpdate();
        conn.commit();
        conn.close();
        }
        public void updateSpecificCompany() throws SQLException {
        /*
         * this method update the companyFrame data in the database 
         */
        Connection conn=Database.getConnection();
        PreparedStatement prepareStatment=conn.prepareStatement("update company set name=?,phone=?,website=?" +
            ",facebook=?,branch=?,salesrepresentitve=?,representativephone=?");
        prepareStatment.setString(1, companyName.getText());
        prepareStatment.setString(2, companyPhone.getText());
        prepareStatment.setString(3, companyWebsite.getText());
        prepareStatment.setString(4, companyFacebook.getText());
        prepareStatment.setString(5, companyBranch.getText());
        prepareStatment.setString(6, salesManName.getText());
        prepareStatment.setString(7, salesManPhone.getText());
        prepareStatment.executeUpdate();
        conn.commit();
        conn.close();
        }
        public void updateGui() {
        /*
         * this method update the form (GUI) after the operation done 
         */
        companyName.setText("");
        companyPhone.setText("");
        companyWebsite.setText("");
        salesManPhone.setText("");
        companyFacebook.setText("");
        salesManName.setText("");
        companySearch.setText("");
        companyBranch.setText("");
        }
}
