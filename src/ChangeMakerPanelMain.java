import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.*;

public class ChangeMakerPanelMain extends JPanel {
    ChangeMaker item = new ChangeMaker();
    //private JMenuItem quitItem;
    private JCheckBoxMenuItem quartersItem;
    private JCheckBoxMenuItem dimesItem;
    private JCheckBoxMenuItem nickelsItem;
    private JCheckBoxMenuItem penniesItem;
    //MenuItemListener menuItemListener = new MenuItemListener();
    private ChangeMakerPanel panel1;
    private ChangeMakerPanel panel2;
    private ChangeMakerPanel panel3;


    public ChangeMakerPanelMain(JMenuItem quitItem, JCheckBoxMenuItem quartersItem, JCheckBoxMenuItem dimesItem, JCheckBoxMenuItem nickelsItem, JCheckBoxMenuItem penniesItem) {
        //setLayout(new GridLayout(8,2));
        panel1 = new ChangeMakerPanel();
        panel2 = new ChangeMakerPanel();
        panel3 = new ChangeMakerPanel();
        this.quartersItem = quartersItem;
        this.quartersItem.addActionListener(new MenuItemListener());
        this.dimesItem = dimesItem;
        this.dimesItem.addActionListener(new MenuItemListener());
        this.nickelsItem = nickelsItem;
        this.nickelsItem.addActionListener(new MenuItemListener());
        this.penniesItem = penniesItem;
        this.penniesItem.addActionListener(new MenuItemListener());


        add(panel1);
        add(panel2);
        add(panel3);


    }

    private class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (quartersItem.equals(e.getSource())) {
                if (item.getQuartersAvail()) {
                    item.setQuartersAvail(false);
                    System.out.println("OFF");
                } else {
                    item.setQuartersAvail(true);
                    System.out.println("ON");
                }
            }

            if (dimesItem.equals(e.getSource())) {
                if (item.getDimesAvail()) {
                    item.setDimesAvail(false);
                } else {
                    item.setDimesAvail(true);
                }
            }
            if (nickelsItem.equals(e.getSource())) {
                if (item.getNickelsAvail()) {
                    item.setNickelsAvail(false);
                } else
                    item.setNickelsAvail(true);
            }
            if (penniesItem.equals(e.getSource())) {
                if (item.getPenniesAvail()) {
                    item.setPenniesAvail(false);
                } else
                    item.setPenniesAvail(true);
            }
        }
    }
}