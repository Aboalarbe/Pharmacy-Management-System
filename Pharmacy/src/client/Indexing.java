package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Dimension2D;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import oracle.dfw.incident.Problem;

public class Indexing implements ActionListener
{
    JFrame indexFrame;
            JLabel drugName_,sideEffects_,effectiveMaterials_,contraindications_,dosage_;
            JTextField drugName, sideEffects,effectiveMaterials,contraindications,dosage;
            JButton save,back,dispaly;
            public void display()
            {
                    indexFrame =new JFrame("Pharmacy Indexing");
                    indexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    indexFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

                    save=new JButton("Save");
                    save.setSize(130, 40);
                    save.setLocation(1210, 650);
                    save.addActionListener(this);
                    indexFrame.add(save);
                    
                    dispaly=new JButton("Display");
                    dispaly.setSize(130, 40);
                    dispaly.setLocation(890, 650);
                    dispaly.addActionListener(this);
                    indexFrame.add(dispaly);

                    back=new JButton("Back");
                    back.setSize(130, 40);
                    back.setLocation(1050, 650);
                    back.addActionListener(this);
                    indexFrame.add(back);
                    
                    drugName_=new JLabel("Drug Name ");
                    drugName_.setSize(230, 40);
                    drugName_.setLocation(60,30);
                    drugName_.setFont(new Font("Sans Serif", 0, 25));
                    indexFrame.add(drugName_);
                    
                    drugName=new JTextField();
                    drugName.setSize(300,40);
                    drugName.setLocation(350,30);
                    drugName.setFont(new Font("Sans Serif", 0, 20));
                    indexFrame.add(drugName);

                    sideEffects_=new JLabel("Side Effects ");
                    sideEffects_.setSize(230, 30);
                    sideEffects_.setLocation(60,120);
                    sideEffects_.setFont(new Font("Sans Serif", 0, 25));
                    indexFrame.add( sideEffects_);
                    
                    sideEffects=new JTextField();
                    sideEffects.setSize(300,40);
                    sideEffects.setLocation(350,120);
                    sideEffects.setFont(new Font("Sans Serif", 0, 20));
                    indexFrame.add(sideEffects);

                    contraindications_=new JLabel("Effective Materials");
                    contraindications_.setSize(230, 30);
                    contraindications_.setLocation(60, 210);
                    contraindications_.setFont(new Font("Sans Serif", 0, 25));
                    indexFrame.add(contraindications_);
                    
                    contraindications=new JTextField();
                    contraindications.setSize(300, 40);
                    contraindications.setLocation(350, 210);
                    contraindications.setFont(new Font("Sans Serif", 0, 20));
                    indexFrame.add(contraindications);
                    
                    effectiveMaterials_=new JLabel("Contraindications");
                    effectiveMaterials_.setSize(230, 30);
                    effectiveMaterials_.setLocation(60, 300);
                    effectiveMaterials_.setFont(new Font("Sans Serif", 0, 25));
                    indexFrame.add(effectiveMaterials_);
                
                    effectiveMaterials=new JTextField();
                    effectiveMaterials.setSize(300, 40);
                    effectiveMaterials.setLocation(350, 300);
                    effectiveMaterials.setFont(new Font("Sans Serif", 0, 20));
                    indexFrame.add(effectiveMaterials);
                    
                     dosage_=new JLabel("Drug Dosage");
                     dosage_.setSize(230, 30);
                     dosage_.setLocation(60, 390);
                     dosage_.setFont(new Font("Sans Serif", 0, 25));
                     indexFrame.add(dosage_);
                
                     dosage=new JTextField();
                     dosage.setSize(300, 40);
                     dosage.setLocation(350, 390);
                     dosage.setFont(new Font("Sans Serif", 0, 20));
                     indexFrame.add(dosage);


                    indexFrame.setLayout(null);
                    indexFrame.setVisible(true);
            }
            public void actionPerformed(ActionEvent source) 
        {
                JButton clickedButton=(JButton)source.getSource();
           if(clickedButton==save)
       {
                  if(!(contraindications.getText().isEmpty())||drugName.getText().isEmpty()||dosage.getText().isEmpty()||effectiveMaterials.getText().isEmpty())
             {
               try {
                    addNewIndexing();
                    JOptionPane.showMessageDialog(null,"Data Saved Successfully","Success",1);
                  } catch (SQLException e) {
                     JOptionPane.showMessageDialog(null,"("+ e.getErrorCode()+")"+" "+e.getMessage(),"Error",0);
                  }
              }
                    else
            JOptionPane.showMessageDialog(null,"Enter All Required Data","Error",0);
        }
           else if(clickedButton==dispaly) {
               ShowAllIndexies obj=new ShowAllIndexies();
               obj.displayallIndexies();
           }
            else
                 {
                     Manager obj=new Manager();
                     indexFrame.setVisible(false);
                 }
            }
    public int autoIncrementId() throws SQLException {
        /*
         * this method refer to Auto increment id
         */
        int newId;
        Connection conn=Database.getConnection();
        PreparedStatement ps1=conn.prepareStatement("select id from indexing");
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
    public void addNewIndexing() throws SQLException {
        /*
         * this method insert drug index data
         */
        Connection conn= Database.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into indexing (id,name,sideeffects,effectivematerial,contraindications,dosage) values(?,?,?,?,?,?)");
        ps.setInt(1,autoIncrementId());
        ps.setString(2, drugName.getText());
        ps.setString(3, sideEffects.getText());
        ps.setString(4, effectiveMaterials.getText());
        ps.setString(5,contraindications.getText());
        ps.setString(6, dosage.getText());
        ps.executeUpdate();
        conn.commit();
        conn.close();
    }
}