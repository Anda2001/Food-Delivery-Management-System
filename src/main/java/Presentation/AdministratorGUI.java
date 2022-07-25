package Presentation;

import businessLogic.DeliveryService;
import businessLogic.MenuItem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.*;

public class AdministratorGUI extends JFrame {

    private final JButton backButton;
    private final JButton createCompositeButton;
    private final JButton deleteButton;
    private final JButton editButton;
    private final JButton generateReportButton;
    private final JButton createBaseButton;
    private final JButton refreshButton;
    public JFrame frame;
    public JTable table;
    JTable objectsTable = new JTable();
    Font myFont = new Font("Times New Roman", Font.PLAIN, 22);
    DeliveryService deliveryService = new DeliveryService();

    public AdministratorGUI( LogView logInView) {
        super("Administrator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 150, 900, 570);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(pink);
        frame = new JFrame("Administrator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);



        objectsTable.setBounds(50, 50, 300, 400);
        objectsTable.setRowHeight(20);
        //objectsTable.setFont(myFont);
        objectsTable.setBackground(lightGray);
       // objectsTable.setBorder(new LineBorder(Color.gray, 5));
        objectsTable.getTableHeader().setBackground(magenta);
        objectsTable.getTableHeader().setFont(myFont);
        JScrollPane scrollPane = new JScrollPane(objectsTable);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds(50, 50, 300, 400);
        panel.add(scrollPane);
        getContentPane().add(panel);


        backButton = new JButton("Back");
        backButton.setBounds(530, 350, 200, 50);
        backButton.setFont(myFont);
        backButton.setBackground(magenta);
        backButton.setBorder(new LineBorder(Color.gray, 5));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                logInView.setVisible(true);

            }
        });
        getContentPane().add(backButton);

        createBaseButton = new JButton("Create Base Product");
        createBaseButton.setBounds(400, 50, 200, 50);
        createBaseButton.setFont(myFont);
        createBaseButton.setBackground(magenta);
        createBaseButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(createBaseButton);

         createCompositeButton = new JButton("Create Composite");
        createCompositeButton.setBounds(650, 50, 200, 50);
        createCompositeButton.setFont(myFont);
        createCompositeButton.setBackground(magenta);
        createCompositeButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(createCompositeButton);


        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400, 150, 200, 50);
        deleteButton.setFont(myFont);
        deleteButton.setBackground(magenta);
        deleteButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(deleteButton);


        editButton = new JButton("Edit");
        editButton.setBounds(650, 150, 200, 50);
        editButton.setFont(myFont);
        editButton.setBackground(magenta);
        editButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(editButton);


        generateReportButton = new JButton("Generate Report");
        generateReportButton.setBounds(400, 250, 200, 50);
        generateReportButton.setFont(myFont);
        generateReportButton.setBackground(magenta);
        generateReportButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(generateReportButton);



        refreshButton = new JButton("Refresh Menu");
        refreshButton.setBounds(650, 250, 200, 50);
        refreshButton.setFont(myFont);
        refreshButton.setBackground(magenta);
        refreshButton.setBorder(new LineBorder(Color.gray, 5));
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryService.deserialize();

            }
        });
        getContentPane().add(refreshButton);
    }

    public void setTable(ArrayList<MenuItem> menuItems) {
        String[] fields = {"Menu"};
        Object[][] data = new Object[menuItems.size()][fields.length];
        for(int i=0;i<menuItems.size();i++) {
            data[i][fields.length-1] = menuItems.get(i).getTitle();
        }

        DefaultTableModel tableModel = (DefaultTableModel) objectsTable.getModel();
        tableModel.setDataVector(data, fields);
        objectsTable.setModel(tableModel);
    }
    public void addDeleteActionListener(ActionListener actionListener)
    {
        deleteButton.addActionListener(actionListener);
    }
    public void addCreateBaseActionListener(ActionListener actionListener)
    {
        createBaseButton.addActionListener(actionListener);
    }
    public void addCreateCompActionListener(ActionListener actionListener)
    {
        createCompositeButton.addActionListener(actionListener);
    }

    public void addEditActionListener(ActionListener actionListener) {
        editButton.addActionListener(actionListener);
    }

    public void setGenerateReportButton(ActionListener actionListener) {
        generateReportButton.addActionListener(actionListener);
    }

    public String getSelectedRow() {
        return objectsTable.getValueAt(objectsTable.getSelectedRow(), 0).toString();
    }

    public void setRefreshButton(ActionListener actionListener) {
        refreshButton.addActionListener(actionListener);
    }


}

