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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class summary extends JFrame {
    ResultSet res;
    JPanel mainPanel;


    summary(ResultSet res) throws SQLException {
        this.res = res;
        initComponents();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        try {
            JTable table = new JTable(writeResult(res)){
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
                        default:
                            return Object.class;
                    }
                }
                @Override
                public boolean isCellEditable(int row, int col){
                    return false;
                }

            };
            table.setFont(new Font("Roboto Mono",Font.PLAIN, 24));
            table.getTableHeader().setFont(new Font("Roboto Mono", Font.PLAIN, 24));
            table.setRowHeight(40);
            table.setFillsViewportHeight(true);
            table.setColumnSelectionAllowed(true);

            mainPanel.setBorder(BorderFactory.createCompoundBorder( new EtchedBorder(),new EmptyBorder(25,25,25,25)));
            GroupLayout reportPanelLayout = new GroupLayout(mainPanel);
            mainPanel.setLayout(reportPanelLayout);

            reportPanelLayout.setHorizontalGroup(
                    reportPanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(table.getTableHeader())
                            .addComponent(table, GroupLayout.PREFERRED_SIZE , 800, Integer.MAX_VALUE)
                            .addGap(18, 18, 18)

            );
            reportPanelLayout.setVerticalGroup(
                    reportPanelLayout.createSequentialGroup()
                            .addComponent(table.getTableHeader())
                            .addComponent(table, GroupLayout.PREFERRED_SIZE, 800, Integer.MAX_VALUE)
            );

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()
                            )
            );

            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()
                            )
            );

            setVisible(true);
            pack();

        } catch (SQLException e){
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

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        res.previous();
        while (res.next()) {
//            count++;
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

                vector.add(res.getObject(columnIndex));

                System.out.println(res.getObject(columnIndex));

            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }}
