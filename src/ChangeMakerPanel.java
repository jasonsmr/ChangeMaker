import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.*;

public class ChangeMakerPanel extends JPanel {
    GridBagConstraints loc = new GridBagConstraints();
    ChangeMaker change = new ChangeMaker();
    long quarters, dimes, nickels, pennies;
    ChangeBag bag = new ChangeBag(quarters, dimes, nickels, pennies);
    private JButton loadBtn;
    private JButton saveBtn;
    private JButton takeOutBtn;
    private JButton loadFileBtn;
    private JLabel amountLbl;
    private JLabel quartersAmnt;
    private JLabel dimesAmnt;
    private JLabel nickelsAmnt;
    private JLabel penniesAmnt;
    private JLabel transferAmntLbl;
    private JLabel quartersLbl;
    private JLabel dimesLbl;
    private JLabel nickelsLbl;
    private JLabel penniesLbl;
    private JTextField transferAmntTf;
    private JLabel error;
    private JLabel space1;
    private JLabel space2;
    private JLabel space3;
    private JLabel moneyLbl;
    private JLabel space4;


    public ChangeMakerPanel () {
        change.setAmount(1000);
        JPanel amount = new JPanel(new GridLayout());
        amount.setLayout(new GridLayout(6,2));
        space2 = new JLabel("");
        amount.add (space2);
        space1 = new JLabel("");
        amount.add (space1);
        space4 = new JLabel("");
        amount.add (space4);
        space3 = new JLabel("");
        amount.add (space3);
        amountLbl = new JLabel("Amount:            " );
        amount.add (amountLbl);
        moneyLbl = new JLabel("" + change.getAmount());
        amount.add (moneyLbl);
        transferAmntLbl = new JLabel("Transfer Amount: ");
        amount.add (transferAmntLbl);
        transferAmntTf = new JTextField();
        transferAmntTf.setColumns(1);
        transferAmntTf.setEditable(true);
        amount.add (transferAmntTf);

        error = new JLabel("");
        amount.add (error);
        amount.setVisible(true);



//        amountLbl = new JLabel("Amount:            " );


        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(6,2));

        loadBtn = new JButton("Load");
        loadBtn.addActionListener(new ButtonListener());
        buttons.add (loadBtn);
        takeOutBtn = new JButton("Take Out");
        takeOutBtn.addActionListener(new ButtonListener());
        buttons.add (takeOutBtn);
        quartersLbl = new JLabel("Quarters: ");
        buttons.add (quartersLbl);
        quartersAmnt = new JLabel("" + bag.getQuarters());
        buttons.add (quartersAmnt);
        dimesLbl = new JLabel("Dimes: ");
        buttons.add (dimesLbl);
        dimesAmnt = new JLabel("" + bag.getDimes());
        buttons.add (dimesAmnt);
        nickelsLbl = new JLabel("Nickels: ");
        buttons.add (nickelsLbl);
        nickelsAmnt = new JLabel("" + bag.getNickels());
        buttons.add (nickelsAmnt);
        penniesLbl = new JLabel("Pennies: ");
        buttons.add (penniesLbl);
        penniesAmnt = new JLabel("" + bag.getPennies());
        buttons.add (penniesAmnt);
        loadFileBtn = new JButton("Load From File");
        loadFileBtn.addActionListener(new ButtonListener());
        buttons.add (loadFileBtn);
        saveBtn = new JButton("Save to File");
        saveBtn.addActionListener(new ButtonListener());
        buttons.add(saveBtn);

        buttons.setVisible(true);

        JPanel panels = new JPanel();
        panels.setLayout(new BorderLayout());
        panels.add(amount, BorderLayout.NORTH);
        panels.add(buttons, BorderLayout.SOUTH);
        panels.setVisible(true);
        add(panels);
//        String transfer = transferAmntTf.getText();
//        double transferAmnt = Double.parseDouble(transfer);


//        add (quartersLbl);
//        add (dimesLbl);
//        add (nickelsLbl);
//        add (penniesLbl);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //JComponent buttonPressed = (JComponent)e.getSource();

            if (loadBtn.equals(e.getSource())){
                String transfer = transferAmntTf.getText();
                double transferAmnt = Double.parseDouble(transfer);
                change.setAmount(change.getAmount() + transferAmnt);
            }
            if (saveBtn.equals(e.getSource())){
                change.save("fileName");
            }
            if (loadFileBtn.equals(e.getSource())){
                change.load("fileName");
            }
            if (takeOutBtn.equals(e.getSource())){
                try{

                    String transfer = transferAmntTf.getText();
                    double transferAmnt = Double.parseDouble(transfer);
                    change.takeOut(transferAmnt);

                    quartersAmnt.setText("" + change.getAmQuarters());
                    dimesAmnt.setText("" + change.getAmDimes());
                    nickelsAmnt.setText("" + change.getAmNickels());
                    penniesAmnt.setText("" + change.getAmPennies());
                    error.setText("");
                }catch(IllegalArgumentException n){
                    String message = n.getMessage();
                    //"<html><font color=\"red\">Error: Illegal Amount</font></html>/n"
                    String template = "<html><font color=\"red\">%s</font></html>/n";
                    String text = String.format(template, message);
                    error.setText(text);
                }
            }


            moneyLbl.setText("" + change.getAmount());
        }

    }


}