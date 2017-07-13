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
public class Employee implements ActionListener {

    JFrame employeeFrame;
    JLabel employeeName_,employeePhone_,employeeSalary_,employeeEmail_,employeeSerianSecurity_,employeeAddress_,employeeUsername_,employeePassword_,search;
    JTextField employeeName,employeePhone,employeeSalary,employeeEmail,employeeUsername,employeeAddress,jsearch;
    JButton add,back,update,delete,show,showAll;
    JFormattedTextField jssn;
    JPasswordField jpassword;
    public void dispaly() {
        employeeFrame=new JFrame("Employees");
                    employeeFrame.setExtendedState(employeeFrame.MAXIMIZED_BOTH);
                    employeeFrame.setDefaultCloseOperation(employeeFrame.EXIT_ON_CLOSE);
                    
                    search=new JLabel("Search For the Employee By Name or SSn");
                    search.setSize(400, 30);
                    search.setLocation(855,30);
                    search.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(search);
                    
                    jsearch=new JTextField();
                    jsearch.setSize(400, 40);
                    jsearch.setLocation(835,70);
                    jsearch.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(jsearch);
                    
                    add=new JButton("Add New");
                    add.setSize(120, 40);
                    add.setLocation(1230, 650);
                    add.addActionListener(this);
                    employeeFrame.add(add);
                    
                    update=new JButton("Update");
                    update.setSize(120, 40);
                    update.setLocation(980, 120);
                    update.addActionListener(this);
                    employeeFrame.add(update);
                    
                    delete=new JButton("Delete");
                    delete.setSize(120, 40);
                    delete.setLocation(1120, 120);
                    delete.addActionListener(this);
                    employeeFrame.add(delete);
                    
                    show=new JButton("Show");
                    show.setSize(120, 40);
                    show.setLocation(840, 120);
                    show.addActionListener(this);
                    employeeFrame.add(show);
                    
                    back=new JButton("Back");
                    back.setSize(120, 40);
                    back.setLocation(1100, 650);
                    back.addActionListener(this);
                    employeeFrame.add(back);
                    
                    showAll=new JButton("Show All Employees");
                    showAll.setSize(200, 40);
                    showAll.setLocation(940, 190);
                    showAll.addActionListener(this);
                    employeeFrame.add(showAll);
                    
                    employeeName_=new JLabel("Employee Name");
                    employeeName_.setSize(230, 30);
                    employeeName_.setLocation(0,30);
                    employeeName_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeeName_);
                    
                    employeeName=new JTextField();
                    employeeName.setSize(300,30);
                    employeeName.setLocation(250,30);
                    employeeName.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(employeeName);
                    
                    employeePhone_=new JLabel("Employee Phone");
                    employeePhone_.setSize(250, 30);
                    employeePhone_.setLocation(0,100);
                    employeePhone_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeePhone_);
                    
                    employeePhone=new JTextField();
                    employeePhone.setSize(300,30);
                    employeePhone.setLocation(250,100);
                    employeePhone.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(employeePhone);
                    
                    employeeEmail_=new JLabel("Employee E-mail");
                    employeeEmail_.setSize(250, 30);
                    employeeEmail_.setLocation(0,170);
                    employeeEmail_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeeEmail_);
        
                    employeeEmail=new JTextField();
                    employeeEmail.setSize(300,30);
                    employeeEmail.setLocation(250,170);
                    employeeEmail.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(employeeEmail);
                    
                    employeeSerianSecurity_=new JLabel("Employee SSn");
                    employeeSerianSecurity_.setSize(230, 30);
                    employeeSerianSecurity_.setLocation(0,240);
                    employeeSerianSecurity_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeeSerianSecurity_);
        
                    jssn=new JFormattedTextField("**************");
                    jssn.setSize(300,30);
                    jssn.setLocation(250,240);
                    jssn.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(jssn);
                    
                    employeeSalary_=new JLabel("Employee Salary");
                    employeeSalary_.setSize(230, 30);
                    employeeSalary_.setLocation(0,310);
                    employeeSalary_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeeSalary_);
        
                    employeeSalary=new JTextField();
                    employeeSalary.setSize(300,30);
                    employeeSalary.setLocation(250,310);
                    employeeSalary.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(employeeSalary);
                
                    
                    employeeAddress_=new JLabel("Employee Address");
                    employeeAddress_.setSize(230, 30);
                    employeeAddress_.setLocation(0,380);
                    employeeAddress_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeeAddress_);
                    
                    employeeAddress=new JTextField();
                    employeeAddress.setSize(300,30);
                    employeeAddress.setLocation(250,380);
                    employeeAddress.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(employeeAddress);
                    
                    employeeUsername_=new JLabel("Employee Username");
                    employeeUsername_.setSize(250, 30);
                    employeeUsername_.setLocation(0,450);
                    employeeUsername_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeeUsername_);
                    
                    employeeUsername=new JTextField();
                    employeeUsername.setSize(300,30);
                    employeeUsername.setLocation(250,450);
                    employeeUsername.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(employeeUsername);
                    
                    employeePassword_=new JLabel("Employee Pasword");
                    employeePassword_.setSize(230, 30);
                    employeePassword_.setLocation(0,520);
                    employeePassword_.setFont(new Font("Sans Serif", 0, 25));
                    employeeFrame.add(employeePassword_);
                    
                    jpassword=new JPasswordField();
                    jpassword.setSize(300,30);
                    jpassword.setLocation(250,520);
                    jpassword.setFont(new Font("Sans Serif", 0, 20));
                    employeeFrame.add(jpassword);
                    
                    employeeFrame.setLayout(null);
                    employeeFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent src) 
    {
        JButton click=(JButton)src.getSource();
        if(click==add)
        {
        try {
            if(employeeName.getText().isEmpty()||jpassword.getText().isEmpty()
               ||employeeSalary.getText().isEmpty()||employeePhone.getText().isEmpty()||jssn.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Enter All Data please","Error",0);
            registerNewEmployee();
            JOptionPane.showMessageDialog(null, "The Employee Successfully Added", "Success", 1);
            updateGui();
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
            }
        }
        else if(click==show)
        {
            if(jsearch.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "Enter the Name of The Employee", "Erorr", 0);
         else
          {        
            try {
             displaySpecificEmployee();
             add.setEnabled(false);
             employeeUsername.setEditable(false);
             jpassword.setEditable(false);
            } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
              }
           }
        }
        else if(click==update)
        {
        try {
             updateEmployeeData();
             JOptionPane.showMessageDialog(null,"The Data Updated Successfully","Success",1);
             updateGui();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
             }
        }
        else if(click==delete)
        {
            if(jsearch.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "Enter the Name of The Employee", "Erorr", 0);
            else
          {
            try {
              removeSpecificEmployee();
              JOptionPane.showMessageDialog(null,"The Employee Deleted Successfully","Success",1);
              updateGui();
              } catch (SQLException e) {
               JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
             }
          }
        }
        else if(click==showAll)
        {
            ShowAllEmployees obj=new ShowAllEmployees();
            obj.displayallEmployees();
        }
        else
        {
            employeeFrame.setVisible(false);
            Manager obj=new Manager();
        }
    }
    public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id for employee table
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement ps1=conn.prepareStatement("select id from employee");
        ResultSet rs=ps1.executeQuery();
        int currentId=0;
        while(rs.next())
        {
        currentId=rs.getInt("id");
        }
       newId=++currentId; 
       return newId;
    }
    public int autoIncrementId2() throws SQLException {
        /*
         * this method refer to Auto increment id for login table
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement ps1=conn.prepareStatement("select id from login");
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
    public void registerNewEmployee() throws SQLException {
        /*
         * this method insert the employee data into the database
         */
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employee (id,name,phone,ssn,email,salary," +
            "address) values(?,?,?,?,?,?,?)");
        PreparedStatement ps2=conn.prepareStatement("insert into login (id,username,password,flag,emp_id) values(?,?,?,?,?)");
        ps.setInt(1,autoIncrementId());
        ps.setString(2, employeeName.getText());
        ps.setString(3, employeePhone.getText());
        ps.setString(4,jssn.getText());
        ps.setString(5, employeeEmail.getText());
        ps.setInt(6, Integer.parseInt(employeeSalary.getText()));
        ps.setString(7, employeeAddress.getText()); 
        ps2.setInt(1, autoIncrementId2());
        ps2.setString(2, employeeUsername.getText());
        ps2.setString(3, jpassword.getText());
        ps2.setInt(4, 0);
        ps2.setInt(5, autoIncrementId());
        ps.executeUpdate();
        ps2.executeUpdate();
        conn.commit();
        conn.close();
    }
    public void displaySpecificEmployee() throws SQLException {
        /*
         * this method get the data from the database and set them into the form
         */
        Connection conn= Database.getConnection();
        conn = Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from employee where name=? or ssn=?");
        ps.setString(1, jsearch.getText());
        ps.setString(2, jsearch.getText());
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            employeeName.setText(rs.getString("name"));
            employeePhone.setText(rs.getString("phone"));
            employeeSalary.setText(rs.getInt("salary")+"");
            employeeAddress.setText(rs.getString("address"));
            employeeEmail.setText(rs.getString("email"));
            jssn.setText(rs.getString("ssn"));
        }
        conn.close();
    }
    public void removeSpecificEmployee() throws SQLException {
        /*
         * this method delete specific employee from the database
         */
       Connection conn= Database.getConnection();
       PreparedStatement ps=conn.prepareStatement("delete from employee where name=?");
       ps.setString(1, jsearch.getText());
       ps.executeUpdate();
       conn.commit();
       conn.close();
    }
    public void updateEmployeeData() throws SQLException {
        /*
         * this method update the Employee data in the database 
         */
        Connection conn=Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employee set name=?,phone=?,email=?" +
            ",address=?,salary=?,ssn=?");
        ps.setString(1, employeeName.getText());
        ps.setString(2, employeePhone.getText());
        ps.setString(3, employeeEmail.getText());
        ps.setString(4, employeeAddress.getText());
        ps.setInt(5, Integer.parseInt(employeeSalary.getText()));
        ps.setString(6, jssn.getText());
        ps.executeUpdate();
        conn.commit();
        conn.close();
    }
    public void updateGui() {
        /*
         * this method update the form (GUI) after the operation done 
         */
        employeeName.setText("");
        employeePhone.setText("");
        employeeSalary.setText("");
        employeeAddress.setText("");
        employeeEmail.setText("");
        jpassword.setText("");
        employeeUsername.setText("");
        jssn.setText("");
        jsearch.setText("");
    }
}
