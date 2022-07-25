package Presentation;

import businessLogic.MenuItem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.*;

public class CompGUI extends JFrame {

    private JLabel titleLabel;
    private JButton addButton;
    private JButton backButton;
    private JLabel title1Label;
    private JTextField titleText;

    private JTable objectsTable;
    Font myFont = new Font("Times New Roman", Font.PLAIN, 22);


    public CompGUI(AdministratorGUI administratorGUI)
    {

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setBounds(500, 50, 750, 550);
        this.getContentPane().setBackground(pink);
        this.getContentPane().setLayout(null);

      //  Font biggerFont = new Font("Times New Roman", Font.PLAIN, 18);
      //  Font hugeFont = new Font("Times New Roman", Font.PLAIN, 32);

        //titleLabel = new JLabel("Composite operations ");
        //titleLabel.setFont(hugeFont);
        //titleLabel.setBounds(100, 50, 450, 50);
        //getContentPane().add(titleLabel);

        backButton = new JButton("Back");
        backButton.setBounds(500, 300, 150, 50);
        backButton.setFont(myFont);
        backButton.setBackground(magenta);
        backButton.setBorder(new LineBorder(Color.gray, 5));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                administratorGUI.setVisible(true);

            }
        });
        getContentPane().add(backButton);

        title1Label = new JLabel("Title: ");
        title1Label.setBounds(400, 100, 70, 40);
        title1Label.setFont(myFont);
        getContentPane().add(title1Label);

        titleText = new JTextField();
        titleText.setBounds(450, 100, 250, 40);
        titleText.setBackground(lightGray);
        getContentPane().add(titleText);

        addButton = new JButton("Add");
        addButton.setFont(myFont);
        addButton.setBackground(magenta);
        addButton.setBorder(new LineBorder(gray,5));
        addButton.setBounds(500, 220, 150, 50);
        getContentPane().add(addButton);

        objectsTable = new JTable();
        objectsTable.setBounds(50, 50, 300, 400);
        objectsTable.setRowHeight(20);
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


    }

    public void setTable(ArrayList<MenuItem> menu) {
        String[] fields = {"Menu"};
        Object[][] data = new Object[menu.size()][fields.length];
        for(int i=0;i<menu.size();i++) {
            data[i][fields.length-1] = menu.get(i).getTitle();
        }

        DefaultTableModel tableModel = (DefaultTableModel) objectsTable.getModel();
        tableModel.setDataVector(data, fields);
        objectsTable.setModel(tableModel);

    }

    public String[] getSelectedRows(){
        int[] selection = objectsTable.getSelectedRows();
        String[] products = new String[selection.length];

        for(int i=0;i<selection.length; i++) {
            products[i] = objectsTable.getModel().getValueAt(selection[i], objectsTable.getColumnCount()-1).toString();
        }

        return products;
    }

    public String getTitle(){
        return titleText.getText();
    }

    public void addEditButtonActionListener(ActionListener actionListener)
    {
        addButton.addActionListener(actionListener);
    }

}
