package Presentation;

import businessLogic.Client;
import businessLogic.MenuItem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.*;

public class ClientGUI extends JFrame {
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel raitingLabel;
    private JLabel nrcaloriesLabel;
    private JLabel proteinsLabel;
    private JLabel fatsLabel;
    private JLabel sodiuLabel;
    private JLabel priceLabel;
    private JTextField nameText;
    private JTextField raitingText;
    private JTextField nrcaloriesText;
    private JTextField proteinsText;
    private JTextField fatsText;
    private JTextField sodiumText;
    private JTextField priceText;
    private JTable objectsTable;

    private JTextArea textArea;


    private JButton backButton;
    private JButton createOrderButton;
    private JButton searchButton;


    private JButton showInfoButton;
    private Font myFont = new Font("Times New Roman", Font.PLAIN, 18);



    public ClientGUI(LogView logInView, Client user) {
        super("Client");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 150, 1000, 650);
        this.getContentPane().setBackground(pink);
        this.getContentPane().setLayout(null);


        backButton = new JButton("Back");
        backButton.setBounds(800, 350, 150, 50);
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


        createOrderButton = new JButton("Create Order");
        createOrderButton.setFont(myFont);
        createOrderButton.setBounds(800, 50, 150, 50);
        createOrderButton.setBackground(magenta);
        createOrderButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(createOrderButton);

        searchButton = new JButton("Search");
        searchButton.setFont(myFont);
        searchButton.setBounds(800, 150, 150, 50);
        searchButton.setBackground(magenta);
        searchButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(searchButton);


        showInfoButton = new JButton("Show Info");
        showInfoButton.setFont(myFont);
        showInfoButton.setBounds(800, 250, 150, 50);
        showInfoButton.setBackground(magenta);
        showInfoButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(showInfoButton);

        nameText = new JTextField();
        nameText.setBounds(500,50,200,30);
        nameText.setBackground(lightGray);
        getContentPane().add(nameText);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(400,50,200,30);
        getContentPane().add(nameLabel);

        raitingText = new JTextField();
        raitingText.setBounds(500,90,200,30);
        raitingText.setBackground(lightGray);
        getContentPane().add(raitingText);

        raitingLabel = new JLabel("Raiting");
        raitingLabel.setBounds(400,90,200,30);
        getContentPane().add(raitingLabel);

        nrcaloriesText = new JTextField();
        nrcaloriesText.setBounds(500,130,200,30);
        nrcaloriesText.setBackground(lightGray);
        getContentPane().add(nrcaloriesText);

        nrcaloriesLabel = new JLabel("Calories");
        nrcaloriesLabel.setBounds(400,130,200,30);
        getContentPane().add(nrcaloriesLabel);

        proteinsText = new JTextField();
        proteinsText.setBounds(500,170,200,30);
        proteinsText.setBackground(lightGray);
        getContentPane().add(proteinsText);

        proteinsLabel = new JLabel("Proteins");
        proteinsLabel.setBounds(400,170,200,30);
        getContentPane().add(proteinsLabel);

        fatsText = new JTextField();
        fatsText.setBounds(500,210,200,30);
        fatsText.setBackground(lightGray);
        getContentPane().add(fatsText);

        fatsLabel = new JLabel("Fats");
        fatsLabel.setBounds(400,210,200,30);
        getContentPane().add(fatsLabel);

        sodiumText = new JTextField();
        sodiumText.setBounds(500,250,200,30);
        sodiumText.setBackground(lightGray);
        getContentPane().add(sodiumText);

        sodiuLabel= new JLabel("Sodium");
        sodiuLabel.setBounds(400,250,200,30);
        getContentPane().add(sodiuLabel);

        priceText = new JTextField();
        priceText.setBounds(500,290,200,30);
        priceText.setBackground(lightGray);
        getContentPane().add(priceText);

        priceLabel= new JLabel("Price");
        priceLabel.setBounds(400,290,200,30);
        getContentPane().add(priceLabel);

        objectsTable = new JTable();
        objectsTable.setBounds(50, 50, 300, 500);
        objectsTable.setRowHeight(20);
        objectsTable.setBackground(lightGray);
        objectsTable.getTableHeader().setBackground(magenta);
        objectsTable.getTableHeader().setFont(myFont);
        JScrollPane scrollPane = new JScrollPane(objectsTable);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds(50, 50, 300, 500);
        panel.add(scrollPane);
        getContentPane().add(panel);

        textArea = new JTextArea();
        textArea.setBounds(400, 350, 300, 200);
        textArea.setBackground(lightGray);
        getContentPane().add(textArea);


    }

    public void setTable(ArrayList<MenuItem> menu) {
        String[] fields = {"Menu"};
        Object[][] data = new Object[menu.size()][1];
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
            products[i] = objectsTable.getModel().getValueAt(selection[i], 0).toString();
        }

        return products;
    }

    public String getSelectedRow(){
        int columns = objectsTable.getColumnCount();
        int row = objectsTable.getSelectedRow();
        String[] value = new String[columns];
        for(int i=0;i<columns; i++) {
            value[i] = objectsTable.getModel().getValueAt(row, i).toString();
        }

        return value[0];
    }



    public void addCreateOrderActionListener(ActionListener actionListener)
    {
        createOrderButton.addActionListener(actionListener);
    }

    public void addSearchActionListener(ActionListener actionListener)
    {
        searchButton.addActionListener(actionListener);
    }

    public void addShowInfoButtonActionListener(ActionListener actionListener)
    {
        showInfoButton.addActionListener(actionListener);
    }

    public String getTitle(){
        return nameText.getText();
    }

    public String getPrice() {
        return priceText.getText();
    }

    public String getRating(){
        return raitingText.getText();
    }

    public String getCalories(){
        return nrcaloriesText.getText();
    }

    public String getProteins() {
        return proteinsText.getText();
    }

    public String getFats(){
        return fatsText.getText();
    }

    public String getSodium() {
        return sodiumText.getText();
    }

    public void setInfo(String s) {
        textArea.setText(s);
    }



}
