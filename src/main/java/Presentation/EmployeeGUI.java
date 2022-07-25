package Presentation;

import businessLogic.MenuItem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static java.awt.Color.magenta;

public class EmployeeGUI extends JFrame implements Observer  {

    private final JLabel ordersLabel = new JLabel ("Orders: ");
    private final JButton backButton;
    private JTextArea ordersText = new JTextArea(1,10);

    public EmployeeGUI(LogView logInView) {
        JFrame frame = new JFrame ("Orders");
        frame.setBackground(Color.pink);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JScrollPane scroll = new JScrollPane(ordersText);

        FlowLayout flLayout = new FlowLayout();
        panel.setBackground(Color.pink);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel1.setLayout(flLayout);

        panel.add(ordersLabel);
        panel.add(scroll);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        backButton.setBackground(magenta);
        backButton.setBorder(new LineBorder(Color.gray, 5));
        backButton.setBounds(750, 550, 100, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                logInView.setVisible(true);

            }
        });
        panel.add(backButton);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void updateList(ArrayList<businessLogic.MenuItem> items, int orderId){
        String str = "Order " + orderId + ": ";
        for(businessLogic.MenuItem i : items){
            str += "\t" + i.getTitle() + " \n";
        }
        String s = ordersText.getText();
        s += str;
        ordersText.setText(s);
    }

    public void show(ArrayList<businessLogic.MenuItem> items, int clientId, int orderId){
        String str = "Client with id " + clientId + " has ordered the products: \n";
        for(MenuItem i : items){
            str += "\t" + i.getTitle() + "\n";
        }
        JFrame frame = new JFrame("New order");
        frame.setSize(500,250);
        JTextArea ta = new JTextArea();
        ta.setText(str);
        JScrollPane s = new JScrollPane(ta);
        frame.add(s);
        frame.setVisible(true);
        updateList(items, orderId);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setVisible(true);
        this.show();
        System.out.println(arg.toString());
        int x = JOptionPane.showConfirmDialog(null, arg, "Notification !", 2);
        if (x == 0) {
            System.out.println("Chef will cook!");
            this.setVisible(false);
        } else {
            System.out.println("Chef is busy, but will still cook later!");
            this.setVisible(false);
        }
    }
}