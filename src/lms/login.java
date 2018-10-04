/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author student
 */
public class login extends javax.swing.JFrame   {

    private String selectedComboItem;
    private Connection conn;
    /**
     * Creates new form lms
     */
    public login(boolean connectionStatus, Connection conn) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        System.out.println("Login page Loaded");
        this.conn = conn;
        initComponents(connectionStatus);
    }

    public login(boolean connectionStatus) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        initComponents(connectionStatus);
    }


    private void initComponents(boolean connectionStatus) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        JOptionPane msg = new JOptionPane("Please wait for connection to establish!", JOptionPane.PLAIN_MESSAGE);
//        msg.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        final JDialog dlg = msg.createDialog(null,"Connecting ...");
        dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        dlg.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

     if (connectionStatus){

         System.out.println("dlg set to false");
//          dlg.setVisible(false);
          dlg.dispose();

//        String url = "jdbc:mysql://0.tcp.ngrok.io:16224/";		//3306 is the default port number
//        String dbname = "falgun";
//        String driver = "com.mysql.jdbc.Driver";
//        String username = "root";
//        String password = "Mocroscope@911";
//
//        Class.forName(driver).newInstance();
//
//        conn = DriverManager.getConnection(url+dbname, username, password);





         selectedComboItem = "Student";

         jPanel1 = new javax.swing.JPanel();
         JLabel jLabel1 = new JLabel();
         JPanel jPanel2 = new JPanel();
         JLabel jLabel6 = new JLabel();
         jComboBox2 = new javax.swing.JComboBox();
         JLabel jLabel7 = new JLabel();
         jTextField3 = new javax.swing.JTextField();
         JLabel jLabel8 = new JLabel();
         jTextField4 = new JPasswordField();
         JButton jButton2 = new JButton();

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

         jLabel1.setFont(new Font("Roboto Mono", Font.BOLD + Font.ITALIC,28));
         jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         jLabel1.setText("LEAVE MANAGEMENT SYSTEM");
         jLabel1.setAlignmentX(5.0F);
         jLabel1.setAutoscrolls(true);

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                                 .addContainerGap()
                                 .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                                 .addContainerGap()
                                 .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );

         jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

         jLabel6.setText("Select login");
         jLabel6.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

         jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Faculty", "Student", "Admin" }));
         jComboBox2.setSelectedIndex(1);
         jComboBox2.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jComboBox2ActionPerformed(evt);
             }
         });
         jComboBox2.setFont(new Font("Roboto Mono", Font.PLAIN, 20));

         jLabel7.setText("login ID:");
         jLabel7.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

         jTextField3.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField3ActionPerformed(evt);
             }
         });
         jTextField3.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

         jLabel8.setText("Password:");
         jLabel8.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

         jTextField4.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jTextField4ActionPerformed(evt);
             }
         });
         jTextField4.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

         jButton2.setText("LOGIN");
         jButton2.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
         jButton2.setBackground(Color.DARK_GRAY);
         jButton2.setForeground(Color.WHITE);
         jButton2.setMargin(new Insets(10,25,10,25));

         jButton2.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
                     jButton2ActionPerformed(evt);
                 } catch (SQLException e) {
                     JOptionPane.showMessageDialog(jPanel1, "Login Unsuccessful! Please try again!! ");
                     e.printStackTrace();
                 }
             }
         });

         javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
         jPanel2.setLayout(jPanel2Layout);
         jPanel2Layout.setHorizontalGroup(
                 jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                         .addGroup(jPanel2Layout.createSequentialGroup()
                                 .addContainerGap()
                                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(jPanel2Layout.createSequentialGroup()
                                                 .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addGap(56, 56, 56)
                                                 .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                         .addGroup(jPanel2Layout.createSequentialGroup()
                                                 .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addGap(56, 56, 56)
                                                 .addComponent(jTextField3, GroupLayout.DEFAULT_SIZE, 221, GroupLayout.DEFAULT_SIZE))
                                         .addGroup(jPanel2Layout.createSequentialGroup()
                                                 .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addGap(56, 56, 56)
                                                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                         .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                         .addGroup(jPanel2Layout.createSequentialGroup()
                                                                 .addGap(20, 20, 20)
                                                         ))))

                                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                         .addComponent(jButton2)
         );
         jPanel2Layout.setVerticalGroup(
                 jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel2Layout.createSequentialGroup()
                                 .addGap(24, 24, 24)
                                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                         .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                         .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(17, 17, 17)
                                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                         .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                         .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                         .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                         .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(18, 18, 18)
                                 .addComponent(jButton2)
                                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setAutoCreateGaps(true);
         layout.setAutoCreateContainerGaps(true);
         layout.setHorizontalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
                                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                 .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                 .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         )
         );
         layout.setVerticalGroup(
                 layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
                                         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                         .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         )
         );

         pack();

     } else{
//         JOptionPane.showMessageDialog(null, "Please wait for connection to establish. DO NOT close the panel");
         dlg.setVisible(true);
     }
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(jComboBox2.getSelectedItem().equals("Student")){
            System.out.println("Student Selected");
            selectedComboItem = "Student";
        } else if(jComboBox2.getSelectedItem().equals("Faculty")){
            System.out.println("Professor Selected");
            selectedComboItem = "Faculty";
        } else {
            System.out.println("Admin selected");
            selectedComboItem = "Admin";
        }
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if (selectedComboItem.contains("Student")){
            Integer loginId = Integer.parseInt(jTextField3.getText());
            String pwd =  String.valueOf(jTextField4.getPassword());
            System.out.println("Login id is " + loginId + "pwd is: " + pwd);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select l.login_id from Login l inner join Person p on l.login_id = p.pid where l.pwd ='" + pwd + "' and l.login_id=" + loginId + " and p.sid is not null;");
            res.next();
            System.out.println("Logging student user");
            if(res.getString(1) != null ){
                System.out.println("Fetched the DB " + res.getString(1));
                JOptionPane.showMessageDialog(jPanel1, "Successfully Logged in");
                new student(conn,Integer.parseInt(res.getString(1)));
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Login Unsuccessful! Please try again!! ");

            }

        }
        else if(selectedComboItem.contains("Faculty")) {
            Integer loginId = Integer.parseInt(jTextField3.getText());
            String pwd =  String.valueOf(jTextField4.getPassword());
            System.out.println("Login id is " + loginId + "pwd is: " + pwd);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select l.login_id from Login l inner join Person p on l.login_id = p.pid where l.pwd ='" + pwd + "' and l.login_id=" + loginId + " and p.staff_id is not null;");
            res.next();
            System.out.println("Logging Faculty");
            if(res.getString(1) != null ){
                JOptionPane.showMessageDialog(jPanel1, "Successfully Logged in");
                new professor(conn, Integer.parseInt(res.getString(1)));
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Login Unsuccessful! Please try again!! ");
            }


        }
        else {
            String loginId = jTextField3.getText();
            String pwd =  String.valueOf(jTextField4.getPassword());
            System.out.println("Login id is " + loginId + "pwd is: " + pwd);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select * from Admin where pwd ='" + pwd + "' and admin_id='" + loginId + "' ;");
            res.next();
            System.out.println("Logging Admin");
            if(res.getString(1) != null ){
                JOptionPane.showMessageDialog(jPanel1, "Successfully Logged in");
                new admin(conn);
            } else {
                JOptionPane.showMessageDialog(jPanel1, "Login Unsuccessful! Please try again!! ");
            }


        }
        dispose();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Thread mySQLConnection = new Thread(new mysqlConnector());
                    mySQLConnection.start();
                    System.out.println("status of sql connection " + mySQLConnection.getState());
                    new login(false).setVisible(true);

                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

                    JOptionPane.showMessageDialog(null, "Login Unsuccessful! Please try again!! ");
                    e.printStackTrace();
                }
            }
        });
    }

    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPasswordField jTextField4;
    // End of variables declaration
}

class mysqlConnector implements Runnable {


    @Override
    public void run() {

        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/";		//3306 is the default port number
        String dbname = "falgun";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "Mocroscope@911";

        try {

            Class.forName(driver).newInstance();
            System.out.println("New Instance created");

        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
             conn = DriverManager.getConnection(url+dbname, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                new login(true, conn).setVisible(true);
            } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }

        }
    }



}
