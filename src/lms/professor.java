package lms;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class professor extends JFrame {

    JLabel jLabel5 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel2 = new JLabel();

    JLabel jLabel3 = new JLabel();

    JLabel jLabel4 = new JLabel();

    JLabel jLabel6 = new JLabel();

    JLabel leaveStatusLabel = new JLabel();
    JLabel leaveStatus = new JLabel();

    JLabel startDate = new JLabel("Start Date");
    JTextField startDateTextField = new JTextField();

    JTextField endDateTextField = new JTextField();


    private JPanel jp1, jp2, jp3;
    Connection conn;
    int id;

    public professor(Connection conn, int id){
        this.conn = conn;
        this.id = id;
        initComponents();
    }

    private void initComponents() {

         jp1 = new JPanel();
         jp2 = new JPanel();
         jp3 = new JPanel();


        jLabel5.setText("Leave Balance");
        jLabel5.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jLabel2.setText("Employee Name");
        jLabel2.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jLabel3.setText("Department");
        jLabel3.setFont(new Font("Roboto Mono", Font.PLAIN, 24));



//        leaveStatus.setText("Temp Status");
        leaveStatus.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        leaveStatusLabel.setText("Your current leave status is: ");
        leaveStatusLabel.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

        startDate.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        JLabel endDate = new JLabel("End Date");
        endDate.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

        startDateTextField.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        endDateTextField.setFont(new Font("Roboto Mono", Font.PLAIN, 24));


        JButton applyButton = new JButton("Apply Now");
        applyButton.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        applyButton.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        applyButton.setBackground(Color.DARK_GRAY);
        applyButton.setForeground(Color.WHITE);
        applyButton.setMargin(new Insets(10,25,10,25));
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyButtonClicked(actionEvent);
            }
        });

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        jMenu1.setText("Profile");
        jMenu1.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jMenuBar.add(jMenu1);
        jMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                // TODO Add mouse event handler
                handleProfileShowing(mouseEvent);
            }
        });

        JMenu jMenu2 = new JMenu();
        jMenu2.setText("Leave");
        jMenu2.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jMenuBar.add(jMenu2);
        JMenuItem jMenuItem1 = new JMenuItem();
        jMenuItem1.setText("Apply");
        jMenuItem1.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jMenu2.add(jMenuItem1);
        jMenuItem1.addActionListener(actionEvent -> {
            // TODO Add the action listener
            handleLeaveApplication(actionEvent);
        });

        JMenuItem jMenuItem2 = new JMenuItem();
        jMenuItem2.setText("Status");
        jMenuItem2.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleStatus(actionEvent);
            }
        });
        jMenu2.add(jMenuItem2);

        JMenu jMenu3 = new JMenu();
        jMenu3.setText("Logout");
        jMenu3.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jMenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                handleLogout(mouseEvent);
            }
        });

        jMenuBar.add(jMenu3);

        setJMenuBar(jMenuBar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }

        });

        setVisible(true);

        jp1.setBorder(BorderFactory.createEtchedBorder());

        jp1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jPanel1Layout);
       /* jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );
        */

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7)
                                )
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(141, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(167, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131))

                        )
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel3))
                                )
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)

                                )
                                .addGap(43,43,43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)

                                )
                                .addContainerGap(126, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(184, Short.MAX_VALUE)))
        );

        jp2.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(),new EmptyBorder(50,50,50,50)));
//        jp2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jPanel2Layout);

        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                ))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(applyButton)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(applyButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 471, Short.MAX_VALUE)
                        .addComponent(leaveStatusLabel)
                        .addGap(30,30,30)
                        .addComponent(leaveStatus)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createSequentialGroup()
                        .addComponent(leaveStatusLabel)
                        .addGap(30,30,30)
                        .addComponent(leaveStatus)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                                .addComponent(jp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                                .addComponent(jp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                        )

        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                                .addComponent(jp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                                .addComponent(jp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                        )
        );

        pack();
    }

    private void applyButtonClicked(ActionEvent actionEvent) {
        try {
            Statement st = conn.createStatement();
            String s1="Select a.aid,a.balance,s.replacement,s.staff_id,s.replac_id from Person p inner join Attendance a on a.aid = p.aid inner join Staff s on s.staff_id=p.staff_id  where p.pid="+id+";";
            ResultSet res = st.executeQuery(s1);
            res.next();
            String att = res.getString(2);
            String rep = res.getString(3);
            Integer staffid = res.getInt(4);
            Integer replacid = res.getInt(5);
            String startDate = startDateTextField.getText();
            System.out.println("Start date :" + startDate);
            Date startdate = null;
            Date enddate=null;
            Date hsdate = null;
            Date lenddate = null;
            String endDate=null;
            try {
                startdate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                endDate = endDateTextField.getText();
                enddate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }


            System.out.println("End date :" + endDate);
            float FloatAtt = Float.parseFloat(att);
            if(FloatAtt > 75.0 )
            {
                if(rep.equals("n"))
                {
                    System.out.println("Attendance is above criteria: "+att);

                    String s2 = "insert into LeaveDetails (designation,startdate,endDate,status) values('F','"+startDate+"','"+endDate+"','P');";
                    st.executeUpdate(s2);
                    System.out.println("Inserted into LeaveDetails");
                    String s4 = "select l_id from LeaveDetails;";

                    res = st.executeQuery(s4);
                    res.last();

                    System.out.println(res.getString(1));
                    String s3 = "update Person set lid ="+ res.getString(1)+" where pid = "+id+";";
                    st.executeUpdate(s3);
                    JOptionPane.showMessageDialog(this,"You have successfully applied for leave");
                }
                else
                {
                    String s2="Select p.lid from Person p where p.staff_id= "+replacid+";";
                     res=st.executeQuery(s2);
                    res.next();
                    System.out.println(res.getString(1));
                    String s3="Select l.startdate,l.endDate from LeaveDetails l where l.l_id="+res.getString(1)+";";
                    res = st.executeQuery(s3);
                    res.next();
                    String rep_sdate=res.getString(1);
                    String rep_edate=res.getString(2);

                    try {
                        boolean overlap=false;

                        Date repsdate = new SimpleDateFormat("yyyy-MM-dd").parse(rep_sdate);
                        Date repedate = new SimpleDateFormat("yyyy-MM-dd").parse(rep_edate);
                        int comp1=repsdate.compareTo(startdate);
                        int comp2=repedate.compareTo(enddate);

                        if (comp1 >= 0){
                            hsdate = repsdate;
                        } else {
                            hsdate = startdate;
                        }

                        if (comp2 <= 0){
                            lenddate = repedate;
                        } else {
                            lenddate = enddate;
                        }

                        if(hsdate.compareTo(lenddate)<=0)
                        {
                            overlap=true;
                        }

                        if(overlap)
                        {
                            JOptionPane.showMessageDialog(this, "Leave slot is not available for the selected dates");
                        } else {

                            System.out.println("Attendance is above criteria: "+att + "inside no overlap ");


                            String s8 = "insert into LeaveDetails (designation,startdate,endDate,status) values('F','"+startDate+"','"+endDate+"','P');";
                            st.executeUpdate(s8);

                            String s4 = "select l_id from LeaveDetails;";

                            res = st.executeQuery(s4);
                            res.last();

                            System.out.println(res.getString(1));
                            String s7 = "update Person set lid ="+ res.getString(1)+" where pid = "+id+";";
                            st.executeUpdate(s7);
                            JOptionPane.showMessageDialog(this,"You have successfully applied for leave");


                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }

            }
            else
            {
                JOptionPane.showMessageDialog(this,"Your attendance is below 75!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "There was some error!! Please try again at a later time.");
            e.printStackTrace();
        }

    }

    private void handleStatus(ActionEvent actionEvent) {

        try
        {
            Statement st = conn.createStatement();
            String s = "select l.status from LeaveDetails l inner join Person p on l.l_id = p.lid where p.pid = "+id+";";

            ResultSet res = st.executeQuery(s);

//            res.next();

            leaveStatus.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
            leaveStatusLabel.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

            if (res.next()){
                leaveStatusLabel.setText("Your current leave status is: " + res.getString(1));
            } else {
                leaveStatusLabel.setText("You have not applied for any leave");

            }



            jp3.setVisible(true);
            jp1.setVisible(false);
            jp2.setVisible(false);
        } catch (SQLException e){
            e.printStackTrace();
        }

        jp3.setVisible(true);
        jp1.setVisible(false);
        jp2.setVisible(false);
    }

    private void handleLogout(MouseEvent mouseEvent) {
        System.out.println("handleLogout called");
        setVisible(false);
        try {
            new login(true, conn).setVisible(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt)
    {
        initProfile();
        jp1.setVisible(true);
        jp2.setVisible(false);
        jp3.setVisible(false);
    }

    private void handleProfileShowing(MouseEvent mouseEvent) {
        System.out.println("Showing Profile now");
        initProfile();
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp1.setVisible(true);

    }

    private void handleLeaveApplication(ActionEvent actionEvent) {
        System.out.println("Leave Application started");
        jp2.setVisible(true);
        jp1.setVisible(false);
        jp3.setVisible(false);
    }

    private void initProfile(){

        try{

            System.out.println("Profile clicked");

            Statement st = null;
            try {
                st = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String s = "Select l.login_id,s.Name,s.designation,a.balance from Login l inner join Person p on l.login_id = p.pid inner join Staff s on s.staff_id = p.staff_id inner join Attendance a on a.aid = p.aid where l.login_id =" + id + ";";

            ResultSet res = st.executeQuery(s);

            res.next();


            jLabel2.setText("ID: " + res.getString(1));
            jLabel2.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

            jLabel3.setText("Name: " + res.getString(2));
            jLabel3.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

            jLabel5.setText("Attendance: "+ res.getString(4) + "%");
            jLabel5.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

            jLabel7.setText("Designation: "+ res.getString(3));
            jLabel7.setFont(new Font("Roboto Mono", Font.PLAIN, 24));

            jp1.setVisible(true);
            jp2.setVisible(false);
            jp3.setVisible(false);
         //   jp4.setVisible(false);
        }  catch (SQLException e) {
            e.printStackTrace();
        }



    }
}

