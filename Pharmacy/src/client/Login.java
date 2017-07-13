package client;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.PasswordView;
public class Login implements ActionListener
{
    JFrame loginFrame;
            JButton enter,cancel;
            JTextField username;
            JPasswordField password;
            JLabel username_,password_;
            static String USERNAME;
            public void display()
            {
                    loginFrame=new JFrame("Login");
                    loginFrame.setSize(500,280);
                    loginFrame.setLocationRelativeTo(null);

                    enter=new JButton("Login");
                    enter.setSize(100,40);
                    enter.setLocation(360, 180);
                    enter.setFont(new Font("Sans Serif", 0, 20));
                    enter.addActionListener(this);
                    loginFrame.add(enter);

                    cancel=new JButton("Cancel");
                    cancel.setSize(100,40);
                    cancel.setLocation(20, 180);
                    cancel.setFont(new Font("Sans Serif", 0, 20));
                    cancel.addActionListener(this);
                    loginFrame.add(cancel);

                    username_=new JLabel("Username");
                    username_.setSize(120, 30);
                    username_.setLocation(20, 45);
                    username_.setFont(new Font("Sans Serif", 0, 20));
                    loginFrame.add(username_);

                    username=new JTextField();
                    username.setSize(270, 40);
                    username.setLocation(150, 40);
                    username.setFont(new Font("Sans Serif", 0, 20));
                    loginFrame.add(username);

                    password_=new JLabel("Password");
                    password_.setSize(150, 30);
                    password_.setLocation(20, 100);
                    password_.setFont(new Font("Sans Serif", 0, 20));
                    loginFrame.add(password_);

                    password=new JPasswordField();
                    password.setLocation(150, 100);
                    password.setSize(270, 40);
                    password.setFont(new Font("Sans Serif", 0, 20));
                    loginFrame.add(password);

                    loginFrame.setLayout(null);
                    loginFrame.setVisible(true);
            }
            public void actionPerformed(ActionEvent source) 
            {
                JButton clickedButton=(JButton)source.getSource();
                 if(clickedButton==enter)
                {
                     try {
                            checkUsernamePassword();
                         } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
                          }
        }
                    else 
                        loginFrame.setVisible(false);
            }
            public void checkUsernamePassword() throws SQLException {
                Connection conn=Database.getConnection();
                if(!(username.getText().isEmpty()||password.getText().isEmpty()))
                {
                      String enteredUsername=username.getText().toString();
                      String enteredPassword=password.getText().toString();
                      String desiredUsername=null;
                      String desirdPassword=null;
                      boolean employeeRole=false;
                   PreparedStatement ps=conn.prepareStatement("select username,password,flag from login where username=?");
                   ps.setString(1, enteredUsername);
                   ResultSet rs= ps.executeQuery();
                   while(rs.next()) 
                   {
                       desiredUsername=rs.getString("username");
                       desirdPassword=rs.getString("password");
                       // to determine the role of the user (manager/employee)
                       employeeRole=rs.getBoolean("flag"); 
                   }
                       conn.close();
                      // check the username and password for login
                       if(enteredUsername.equalsIgnoreCase(desiredUsername)&& enteredPassword.equalsIgnoreCase(desirdPassword)&&employeeRole)
                       {
                          JOptionPane.showMessageDialog(null, "Login Successful as a Manager", "Success", 1); 
                           USERNAME=desiredUsername;
                           Manager obj=new Manager();
                           loginFrame.setVisible(false);
                           SplashScreen.splashFrame.setVisible(false);
                           
                       }
                       else if(enteredUsername.equalsIgnoreCase(desiredUsername)&& enteredPassword.equalsIgnoreCase(desirdPassword)&&employeeRole==false) 
                       {
                           JOptionPane.showMessageDialog(null, "Login Successful as a Employee", "Success", 1); 
                           USERNAME=desiredUsername;
                           Manager obj=new Manager();
                           loginFrame.setVisible(false);
                           SplashScreen.splashFrame.setVisible(false);
                       }
                       else
                       {
                          JOptionPane.showMessageDialog(null, "invalid Password or Username", "Error", 0); 
                           username.setText("");
                           password.setText("");
                       }
                }
                else
                JOptionPane.showMessageDialog(null,"You Must Enter a Data","Error",0);
            }
}
