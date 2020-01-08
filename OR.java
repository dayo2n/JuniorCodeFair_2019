package doldol;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

class OrFrame extends JFrame implements ActionListener {

    private ImageIcon laun = new ImageIcon("laun_shirt.png");
    private ImageIcon dry = new ImageIcon("dry_shirt.png");
    private JButton b1;
    private JButton b2;

    private JButton back;

    public OrFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(600, 500);
        setTitle("Laundry or Dry");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("washer1.png");
        this.setIconImage(img);

        JPanel rightBefore = new JPanel();
        JPanel panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("충남대학교 학생생활관 세탁실");
        p1.add(l1);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(0, 2));
        b1 = new JButton(laun);
        b2 = new JButton(dry);
        b1.addActionListener(this);
        b2.addActionListener(this);
        p2.add(b1);
        p2.add(b2);

        JPanel p3 = new JPanel();
        JLabel l2 = new JLabel("세탁기 or 건조기");
        p3.add(l2);

        JPanel p4 = new JPanel();
        back = new JButton("뒤로 이동");
        back.addActionListener(this);
        p4.add(back);

        panelAll.add(p1);
        panelAll.add(p2);
        panelAll.add(p3);
        panelAll.add(p4);
        rightBefore.add(panelAll);
        add(rightBefore);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            MainFrame MF = new MainFrame();
        }
        if (e.getSource() == b1) {
            dispose();
            LaundryMachine LM = new LaundryMachine();
        } else if (e.getSource() == b2) {
            dispose();
            DryMachine DM = new DryMachine();
        }
    }
}