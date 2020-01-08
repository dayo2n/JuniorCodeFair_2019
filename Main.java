package doldol;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MainFrame extends JFrame implements ActionListener {

    private JButton[] b = new JButton[13];

    public MainFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(550, 750);
        setTitle("Welcome to doldol's laundry");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("washer1.png");
        this.setIconImage(img);

        JPanel panelAll = new JPanel();

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel();
        ImageIcon map = new ImageIcon("dorm_map.png");
        l1.setIcon(map);
        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 5));
        String[] dorm_num = new String[13];
        ButtonGroup dorm_group = new ButtonGroup();
        for (int i = 0; i < 13; i++) {
            dorm_num[i] = (i + 1) + "동";
            b[i] = new JButton(dorm_num[i]);
            b[i].addActionListener(this);
            dorm_group.add(b[i]);
            p2.add(b[i]);
        }

        panelAll.add(p1);
        panelAll.add(p2);
        add(panelAll);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 13; i++) {
            if (e.getSource() == b[i]) {
                dispose();
                OrFrame OF = new OrFrame();
            }

        }
    }

}

/*
 * public class Main { public static void main(String[] args) { MainFrame MF =
 * new MainFrame(); } }
 */
