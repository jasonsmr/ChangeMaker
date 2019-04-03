import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String arg[]) {

        JMenu fileMenu;
        JMenuItem quitItem;
        JCheckBoxMenuItem quartersItem;
        JCheckBoxMenuItem dimesItem;
        JCheckBoxMenuItem nickelsItem;
        JCheckBoxMenuItem penniesItem;
        JMenuBar menus;

        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit!");
        quitItem.addActionListener(new exitApp());
        quartersItem = new JCheckBoxMenuItem("Suspend Quarters");
        dimesItem = new JCheckBoxMenuItem("Suspend Dimes");
        nickelsItem = new JCheckBoxMenuItem("Suspend Nickels");
        penniesItem = new JCheckBoxMenuItem("Suspend Pennies");

        fileMenu.add(quartersItem);
        fileMenu.add(dimesItem);
        fileMenu.add(nickelsItem);
        fileMenu.add(penniesItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();

        menus.add(fileMenu);

        JFrame gui = new JFrame("Money Maker 1.0");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ChangeMakerPanelMain panel =
                new ChangeMakerPanelMain(quitItem, quartersItem, dimesItem, nickelsItem, penniesItem);

        gui.getContentPane().add(panel);

        gui.setSize(1100, 400);
        gui.setJMenuBar(menus);
        gui.setVisible(true);
    }
    // Exit app
    static class exitApp implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);

        }
    }
}