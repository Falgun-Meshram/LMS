package lms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

public class admin extends JFrame {

    JTable leaveTable;
    JFrame mainFrame;
    JScrollPane mainScrollPanel;
    JPanel mainPanel;
    JPanel scrollPanelParent;
    JButton grantLeaveButton;
    JButton rejectLeaveButton;
    JTable table;
    Connection conn;
    static int checkBoxRenderingCount = 0;
    static int count = 0;
    static int approveLeaveArray[];
    static int rejectLeaveArray[];
    boolean isApproveChecked = false;
    boolean isRejectChecked = false;

    admin(Connection conn){
        this.conn = conn;
        System.out.println("Creating admin page");
        initComponents(conn);


    }

    private void initComponents(Connection conn) {
//        DefaultTableModel model = new DefaultTableModel(new String[]{"pid  "," dept "," lid  "," aid  "," sid  "," staff_id"}, 0);
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("pid");
//        model.addColumn("dept");
//        model.addColumn("lid");
//        model.addColumn("aid");
//        model.addColumn("sid");
//        model.addColumn("staff_id");
        approveLeaveArray = new int[100];
        rejectLeaveArray = new int[100];
        leaveTable = new JTable();
        mainFrame = new JFrame();
        mainScrollPanel = new JScrollPane();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();

        mainPanel = new JPanel();
        scrollPanelParent = new JPanel();

        jMenu1.setText("Logout");
        jMenu1.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        jMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                handleLogout(mouseEvent);
            }
        });
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);


        grantLeaveButton = new JButton("GRANT LEAVE");
        rejectLeaveButton = new JButton("REJECT LEAVE");

        grantLeaveButton.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        grantLeaveButton.setBackground(Color.DARK_GRAY);
        grantLeaveButton.setForeground(Color.WHITE);
        grantLeaveButton.setMargin(new Insets(10,25,10,25));
        grantLeaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                handleGrantLeave(actionEvent);

            }
        });

        rejectLeaveButton.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
        rejectLeaveButton.setBackground(Color.DARK_GRAY);
        rejectLeaveButton.setForeground(Color.WHITE);
        rejectLeaveButton.setMargin(new Insets(10,25,10,25));
        rejectLeaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleRejectLeave(actionEvent);
            }
        });

//        mainPanel.add(grantLeaveButton);
//        mainPanel.add(rejectLeaveButton);

        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("Select * from LeaveDetails where status = 'P'");

            table = new JTable(writeResult(res)){
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return Object.class;
                        case 1:
                            return Object.class;
                        case 2:
                            return Object.class;
                        case 3:
                            return Object.class;
                        case 4:
                            return Object.class;
                        default:
                            return Object.class;
                    }
                }
                @Override
                public boolean isCellEditable(int row, int col){
                System.out.println("Is cell editable called for row " + row + "and col " + col);
                    return col == 5;
                }

            };
            createCheckBoxArray(count);
            table.getModel().addTableModelListener(tableModelEvent -> {
                tableChanged(tableModelEvent);
            });
            table.setFont(new Font("Roboto Mono", Font.PLAIN, 24));
            table.getTableHeader().setFont(new Font("Roboto Mono", Font.PLAIN, 24));
            table.setRowHeight(40);
            table.setFillsViewportHeight(true);
            table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(generateBox()));
            table.setColumnSelectionAllowed(true);
//            table.getColumn("Approve Leave").setCellRenderer(new MyTableCellRenderer());
//            table.getColumn("Reject Leave").setCellRenderer(new MyTableCellRenderer());

//            table.setDefaultRenderer(table.getColumnClass(1), new MyTableCellRenderer());

//            mainScrollPanel.add(new JScrollPane(table));
//            mainPanel.add(table);

            mainPanel.setBorder(BorderFactory.createCompoundBorder( new EtchedBorder(),new EmptyBorder(25,25,25,25)));
            GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
            mainPanel.setLayout(mainPanelLayout);

//            mainPanelLayout.setAutoCreateGaps(true);
//            mainPanelLayout.setAutoCreateContainerGaps(true);
            mainPanelLayout.setHorizontalGroup(
                    mainPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                    .addGap(20,20,20)
                    .addComponent(table.getTableHeader())
                    .addComponent(table, 0,GroupLayout.DEFAULT_SIZE, Integer.MAX_VALUE)
//                    .addGroup(mainPanelLayout.createSequentialGroup()
//                            .addGap(20,20,20)
//                            .addComponent(table, 200,400, Integer.MAX_VALUE)
//                            .addGap(20,20,20)
//                    )
                    .addGap(20,20,20)
                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(grantLeaveButton)
                                .addGap(20,20,20)
                                .addComponent(rejectLeaveButton)
                                .addGap(500,500,500)
                        )
                    )

            );
            mainPanelLayout.setVerticalGroup(
                    mainPanelLayout.createSequentialGroup()
                    .addGap(20,20,20)
                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
//                            .addGap(20,20,20)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(table.getTableHeader())
                                .addComponent(table, 0,GroupLayout.DEFAULT_SIZE, Integer.MAX_VALUE)
                            )
                            .addGap(20,20,20)
                     )
                    .addGap(20,20,20)
                    .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(grantLeaveButton)
                        .addGap(20,20,20)
                        .addComponent(rejectLeaveButton)
                    )
            );

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()
                            )

            );

            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()
                            )
            );
            setVisible(true);
            pack();
//            mainFrame.add(new JScrollPane(mainPanel));
//            mainFrame.add(mainPanel);
//
//            mainFrame.setSize(1280, 720);
//            mainFrame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JComboBox generateBox() {

        JComboBox<String > bx = new JComboBox<String>(new String[] { "Select Action","Approve", "Reject"});
//        bx.setModel(new DefaultComboBoxModel(new String[] { "Select Action","Approve", "Reject"}));
        bx.getModel().setSelectedItem("Select Action");
//            bx.setSelectedIndex(1);
        bx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleComboBoxEvent(evt);
            }
        });
        return bx;

    }

    private void handleComboBoxEvent(ActionEvent evt) {
        System.out.println("Event source is " + evt.paramString());
    }

    private void handleRejectLeave(ActionEvent actionEvent) {
        for (int i = 0; i <rejectLeaveArray.length; i++
             ) {
            if (rejectLeaveArray[i] == 1) {
                System.out.println("Rejecting l_id : " + table.getValueAt(i,0));

                String s1 = "delete from LeaveDetails where l_id=" +table.getValueAt(i,0)+ ";";
                // 1. Remove the lid
                // 2. Update the person table
                try {

                    Statement st = conn.createStatement();
                    st.executeUpdate(s1);



                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Please try again! There was an error");

                }

            }
        }
        JOptionPane.showMessageDialog(this, "Successfully Rejected all lids");
        System.out.println("handleRejectLeave called");

    }

    private void handleGrantLeave(ActionEvent actionEvent) {

        for (int i = 0; i <approveLeaveArray.length; i++
                ) {
            if (approveLeaveArray[i] == 1) {
                System.out.println("Approving l_id : " + table.getValueAt(i,0));

                if(table.getValueAt(i,1).equals("S"))
                {
                    String s1 = "update LeaveDetails set status = 'A' where l_id = "+table.getValueAt(i,0)+";";
                    Statement st = null;
                    try {
                        st = conn.createStatement();
                        st.executeUpdate(s1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    this.dispose();
                    new admin(conn);
                }
                else
                {
                    String s1 = "select staff_id from Person where lid = "+table.getValueAt(i,0)+";";
                    try {
                        Statement st = conn.createStatement();
                        ResultSet res = st.executeQuery(s1);
                        res.next();
                        int wantsReplacementId = res.getInt(1);

                        String s2 = "select staff_id from Staff where replacement = 'n' and staff_id !="+wantsReplacementId+";";

                        res = st.executeQuery(s2);
                        if(res.next())
                        {
                            int isReplacementId = res.getInt(1);

                            String s3 = "update Staff set replacement = 'y',replac_id = "+wantsReplacementId+" where staff_id ="+isReplacementId+";";
                            String s4 = "update LeaveDetails set status = 'A' where l_id = "+table.getValueAt(i,0)+";";

                            st.executeUpdate(s3);

                            st.executeUpdate(s4);

                            this.dispose();

                            new admin(conn);

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this,"No replacement available,please Reject for "+table.getValueAt(i,0));
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        System.out.println("handleGrantLeave called");
    }

    private void handleLogout(MouseEvent actionEvent) {
        System.out.println("handleLogout called");
        setVisible(false);
        try {
            new login(true, conn).setVisible(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DefaultTableModel writeResult (ResultSet res) throws SQLException {

        ResultSetMetaData metaData = res.getMetaData();

        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        columnNames.add("Approve/Reject");
//        Vector<String> statusStringVector = new Vector<String>();
//        statusStringVector.add("String");
//        System.out.println( metaData.getColumnName(1));
//        columnNames.add(statusStringVector);


        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (res.next()) {
            count++;
            Vector<Object> vector = new Vector<Object>();
            Object temp = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

                vector.add(res.getObject(columnIndex));

                System.out.println(res.getObject(columnIndex));

            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    private static void createCheckBoxArray(int count) {
        for (int i = 0; i < count; i++){
            approveLeaveArray[i] = -1;
            rejectLeaveArray[i] = -1;
        }
    }


    public void tableChanged(TableModelEvent tableModelEvent) {

        int row = tableModelEvent.getFirstRow();
        int column = tableModelEvent.getColumn();
        TableModel model = (TableModel)tableModelEvent.getSource();
        Object data = model.getValueAt(row, 0);

        System.out.println(table.getValueAt(row,column).toString());
        System.out.println("change is " + data + "for the row" + row + "and the column is " + column);


        String status = table.getValueAt(row, column).toString();

        switch (status){
            case "Approve":
                toggleApproveStatus(row);
                System.out.println("approve is " + approveLeaveArray[row] + "reject is: " + rejectLeaveArray[row]);
                return;
            case  "Reject":
                toggleRejectStatus(row);
                System.out.println("approve is " + approveLeaveArray[row] + "reject is: " + rejectLeaveArray[row]);
                return;
            default: setToDefault(row);
                System.out.println("approve is " + approveLeaveArray[row] + "reject is: " + rejectLeaveArray[row]);
        }


    }

    private void setToDefault(int row) {
        approveLeaveArray[row] = rejectLeaveArray[row] = -1;
    }


    private void toggleApproveStatus(int row) {

        approveLeaveArray[row] = 1;
        rejectLeaveArray[row] = 0;

    }

    private void toggleRejectStatus(int row) {
        rejectLeaveArray[row] = 1;
        approveLeaveArray[row] = 0;
    }
}
