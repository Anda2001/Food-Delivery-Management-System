package Presentation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class ReportGUI extends JFrame {

    private final JComboBox reportBox;
    private JLabel titleLabel;
    private JButton generateButton;
    private JButton backButton;
    private JLabel startLabel;
    private JLabel endLabel;
    private JLabel timesOrderLabel;
    private JLabel minOrderLabel;
    private JLabel minPriceLabel;
    private JLabel dayLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;
    private JTextField startText;
    private JTextField endText;
    private JTextField timesOderText;
    private JTextField minOrderText;
    private JTextField minPriceText;
    private JTextField dayText;
    private JTextField monthText;
    private JTextField yearText;
    private Font myFont = new Font("Times New Roman", Font.PLAIN, 22);



    public ReportGUI(AdministratorGUI administratorGUI)
    {


        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setBounds(500, 150, 900, 500);
        this.setBackground(pink);
        this.getContentPane().setBackground(pink);
        this.getContentPane().setLayout(null);

        //Font biggerFont = new Font("Times New Roman", Font.PLAIN, 18);
       // Font hugeFont = new Font("Times New Roman", Font.PLAIN, 32);

        titleLabel = new JLabel("Generate Report:  ");
        titleLabel.setFont(myFont);
        titleLabel.setBounds(500, 50, 450, 50);
        getContentPane().add(titleLabel);

        backButton = new JButton("Back");
        backButton.setBounds(500, 300, 150, 50);
        backButton.setBackground(magenta);
        backButton.setBorder(new LineBorder(Color.gray, 5));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                administratorGUI.setVisible(true);
                setVisible(false);


            }
        });
        getContentPane().add(backButton);

        startLabel = new JLabel("StartHour");
        startLabel.setBounds(100,100,200,30);
        getContentPane().add(startLabel);

        startText = new JTextField();
        startText.setBounds(200,100,200,30);
        startText.setBackground(lightGray);
        getContentPane().add(startText);

        endLabel = new JLabel("EndHour");
        endLabel.setBounds(100,140,200,30);
        getContentPane().add(endLabel);

        endText = new JTextField();
        endText.setBounds(200,140,200,30);
        endText.setBackground(lightGray);
        getContentPane().add(endText);

        timesOrderLabel = new JLabel("TimesOrdered");
        timesOrderLabel.setBounds(100,180,200,30);
        getContentPane().add(timesOrderLabel);

        timesOderText = new JTextField();
        timesOderText.setBounds(200,180,200,30);
        timesOderText.setBackground(lightGray);
        getContentPane().add(timesOderText);

        minOrderLabel = new JLabel("MinimOrders");
        minOrderLabel.setBounds(100,220,200,30);
        getContentPane().add(minOrderLabel);

        minOrderText = new JTextField();
        minOrderText.setBounds(200,220,200,30);
        minOrderText.setBackground(lightGray);
        getContentPane().add(minOrderText);

        minPriceLabel = new JLabel("MinimPrice");
        minPriceLabel.setBounds(100,260,200,30);
        getContentPane().add(minPriceLabel);

        minPriceText = new JTextField();
        minPriceText.setBounds(200,260,200,30);
        minPriceText.setBackground(lightGray);
        getContentPane().add(minPriceText);

        dayLabel= new JLabel("Day");
        dayLabel.setBounds(100,300,200,30);
        getContentPane().add(dayLabel);

        dayText = new JTextField();
        dayText.setBounds(200,300,200,30);
        dayText.setBackground(lightGray);
        getContentPane().add(dayText);

        monthLabel= new JLabel("Month");
        monthLabel.setBounds(100,340,200,30);
        getContentPane().add(monthLabel);

        monthText = new JTextField();
        monthText.setBounds(200,340,200,30);
        monthText.setBackground(lightGray);
        getContentPane().add(monthText);

        yearLabel= new JLabel("Year");
        yearLabel.setBounds(100,380,200,30);
        getContentPane().add(yearLabel);

        yearText = new JTextField();
        yearText.setBounds(200,380,200,30);
        yearText.setBackground(lightGray);
        getContentPane().add(yearText);


        generateButton = new JButton("Generate");
        //generateButton.setFont(biggerFont);
        generateButton.setBounds(500, 225, 150, 50);
        generateButton.setBackground(magenta);
        generateButton.setBorder(new LineBorder(Color.gray, 5));
        getContentPane().add(generateButton);

        reportBox = new JComboBox();
        reportBox.setBounds(500, 150, 200, 50);
        reportBox.setFont(myFont);
        reportBox.setBackground(lightGray);
        reportBox.setBorder(new LineBorder(Color.gray, 5));
        reportBox.addItem("Report1");
        reportBox.addItem("Report2");
        reportBox.addItem("Report3");
        reportBox.addItem("Report4");
        getContentPane().add(reportBox);

    }

    public String getStart() {
        return startText.getText();
    }
    public String getEnd() {
        return endText.getText();
    }
    public String getTimes() {
        return timesOderText.getText();
    }
    public String getMinimTimes() {
        return minOrderText.getText();
    }
    public String getMinPrice() {
        return minPriceText.getText();
    }
    public String getDay(){
        return dayText.getText();
    }
    public String getMonth(){
        return monthText.getText();
    }
    public String getYear(){
        return yearText.getText();
    }

    public void generateReportButton(ActionListener actionListener) {
        generateButton.addActionListener(actionListener);
    }

    public String getReportType() {
        String reportBoxSelectedItem= (String) reportBox.getSelectedItem();
        assert reportBoxSelectedItem != null;
        return reportBoxSelectedItem;

    }

    public String getDate(){
        return dayText.getText()+"-"+monthText.getText()+"-"+yearText.getText();
    }

}
