package Presentation;

import businessLogic.BaseProduct;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class BaseGUI extends JFrame {

    private JLabel titleLabel;
    private JLabel keywordLabel;
    private JLabel raitingLabel;
    private JLabel nrcaloriesLabel;
    private JLabel proteinsLabel;
    private JLabel fatsLabel;
    private JLabel sodiuLabel;
    private JLabel priceLabel;
    private JTextField keywordText;
    private JTextField raitingText;
    private JTextField nrcaloriesText;
    private JTextField proteinsText;
    private JTextField fatsText;
    private JTextField sodiumText;
    private JTextField priceText;


    private JButton backButton;
    private JButton addButton;
    private JButton editButton;

    Font myFont = new Font("Times New Roman", Font.PLAIN, 22);




    public BaseGUI(boolean edit, BaseProduct baseProduct, AdministratorGUI administratorGUI) {

        super("Base Product");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 150, 700, 400);
        this.setBackground(Color.pink);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(pink);



        addButton = new JButton("Add");
        addButton.setFont(myFont);
        addButton.setBounds(450, 100, 150, 50);
        addButton.setBackground(magenta);
        addButton.setBorder(new LineBorder(Color.gray,5));
        getContentPane().add(addButton);

        editButton = new JButton("Edit");
        editButton.setFont(myFont);
        editButton.setBounds(450, 100, 150, 50);
        editButton.setBackground(magenta);
        editButton.setBorder(new LineBorder(Color.gray,5));
        getContentPane().add(editButton);

        backButton = new JButton("Back");
        backButton.setFont(myFont);
        backButton.setBounds(450,200,150,50);
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

        keywordText = new JTextField();
        keywordText.setBounds(150,50,200,30);
        keywordText.setBackground(lightGray);
        getContentPane().add(keywordText);

        keywordLabel = new JLabel("KeyWord");
        keywordLabel.setBounds(50,50,200,30);
       // keywordLabel.setFont(myFont);
        getContentPane().add(keywordLabel);

        raitingText = new JTextField();
        raitingText.setBounds(150,90,200,30);
        raitingText.setBackground(lightGray);
        getContentPane().add(raitingText);

        raitingLabel = new JLabel("Raiting");
        raitingLabel.setBounds(50,90,200,30);
        //raitingLabel.setFont(myFont);
        getContentPane().add(raitingLabel);

        nrcaloriesText = new JTextField();
        nrcaloriesText.setBounds(150,130,200,30);
        nrcaloriesText.setBackground(lightGray);
        getContentPane().add(nrcaloriesText);

        nrcaloriesLabel = new JLabel("Calories");
        nrcaloriesLabel.setBounds(50,130,200,30);
        //nrcaloriesLabel.setFont(myFont);
        getContentPane().add(nrcaloriesLabel);

        proteinsText = new JTextField();
        proteinsText.setBounds(150,170,200,30);
        proteinsText.setBackground(lightGray);
        getContentPane().add(proteinsText);

        proteinsLabel = new JLabel("Proteins");
        proteinsLabel.setBounds(50,170,200,30);
        //proteinsLabel.setFont(myFont);
        getContentPane().add(proteinsLabel);

        fatsText = new JTextField();
        fatsText.setBounds(150,210,200,30);
        fatsText.setBackground(lightGray);
        getContentPane().add(fatsText);

        fatsLabel = new JLabel("Fats");
        fatsLabel.setBounds(50,210,200,30);
        //fatsLabel.setFont(myFont);
        getContentPane().add(fatsLabel);

        sodiumText = new JTextField();
        sodiumText.setBounds(150,250,200,30);
        sodiumText.setBackground(lightGray);
        getContentPane().add(sodiumText);

        sodiuLabel= new JLabel("Sodium");
        sodiuLabel.setBounds(50,250,200,30);
        //sodiuLabel.setFont(myFont);
        getContentPane().add(sodiuLabel);

        priceText = new JTextField();
        priceText.setBounds(150,290,200,30);
        priceText.setBackground(lightGray);
        getContentPane().add(priceText);

        priceLabel= new JLabel("Price");
        priceLabel.setBounds(50,290,200,30);
        //proteinsLabel.setFont(myFont);
        getContentPane().add(priceLabel);

        if(edit) {
            addButton.setVisible(false);
            keywordText.setEditable(false);
        }
        else
            editButton.setVisible(false);
    }

    public void addCreateButtonActionListener(ActionListener actionListener)
    {
        addButton.addActionListener(actionListener);
    }
    public void addEditButtonActionListener(ActionListener actionListener)
    {
        editButton.addActionListener(actionListener);
    }

    public String getTitle(){
        return keywordText.getText();
    }
    public void setTitle(String s) {
        keywordText.setText(s);
    }
    public String getPrice(){ return priceText.getText();}
    public String getRaiting(){return raitingText.getText(); }
    public String getCalories(){return nrcaloriesText.getText();}
    public String getProteins(){return proteinsText.getText();}
    public String getFats(){return fatsText.getText();}
    public String getSodium(){return sodiumText.getText();}
    public void setPrice(String s){ priceText.setText(s);}
    public void setRaiting(String s){ raitingText.setText(s);}
    public void setCalories(String s){ nrcaloriesText.setText(s);}
    public void setFats(String s){ fatsText.setText(s);}
    public void setSodium(String s){ sodiumText.setText(s);}
    public void setProteins(String s){ proteinsText.setText(s);}


}

