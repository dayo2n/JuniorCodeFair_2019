package doldol;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

class LoginFrame extends JFrame implements ActionListener {

    private JButton login;

    public LoginFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(350, 250);
        setTitle("Welcome to doldol's laundry");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("washer1.png");
        this.setIconImage(img);

        JPanel rightBefore = new JPanel();
        JPanel panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));

        JPanel p0 = new JPanel();
        JLabel l0 = new JLabel("세탁실 도우미 Login");
        p0.add(l0);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0, 2));
        JLabel l1 = new JLabel("학번");
        JTextField t1 = new JTextField(10);
        JLabel l2 = new JLabel("비밀번호");
        JPasswordField w1 = new JPasswordField(10);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(w1);

        JPanel p2 = new JPanel();
        login = new JButton("login");
        login.addActionListener(this);
        p2.add(login);

        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("by 문돌돌이네");
        p3.add(l3);

        panelAll.add(p0);
        panelAll.add(p1);
        panelAll.add(p2);
        panelAll.add(p3);
        rightBefore.add(panelAll);
        add(rightBefore);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {// 서버를 구축하지않았으므로 일단 바로 넘어가기,,
            dispose();
            MainFrame MF = new MainFrame();
        }
    }
}

public class Login {
    public static void main(String[] args) {
        LoginFrame LF = new LoginFrame();
    }
}