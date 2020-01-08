package doldol;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

class LaundryMachine extends JFrame implements ActionListener {

    private JButton back;

    public static JLabel[] usable;
    private JButton[] machines;
    public static int[] num = { 1, 2, 3, 4 };
    public boolean[] flag = { false, false, false, false };// 모든 세탁기가 사용중이지않은 상태

    private int selected;

    private ImageIcon machine = new ImageIcon("non-using.png");
    private ImageIcon machine_using = new ImageIcon("using.png");

    public LaundryMachine() {
        setTitle("Laundry Machine");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700, 520);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("washer1.png");
        this.setIconImage(img);

        JPanel rightBefore = new JPanel();

        JPanel panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));

        JPanel p0 = new JPanel();// 화면 제목 패널
        JPanel p00 = new JPanel();
        JLabel l1 = new JLabel("충남대학교 학생생활관 세탁실");
        JLabel l2 = new JLabel("세탁기 이용 현황");
        p0.add(l1);
        p00.add(l2);

        JPanel smaller = new JPanel();
        JPanel p1 = new JPanel();// 세탁기 버튼+이용현황 버튼 패널
        p1.setLayout(new GridLayout(0, 2));
        JPanel[] btns = new JPanel[4];
        machines = new JButton[4];
        usable = new JLabel[4];

        for (int i = 0; i < 4; i++) {
            btns[i] = new JPanel();
            btns[i].setLayout((new BoxLayout(btns[i], BoxLayout.Y_AXIS)));
            machines[i] = new JButton();
            machines[i].addActionListener(this);
            if (flag[i] == false) {
                usable[i] = new JLabel(num[i] + "번 세탁기 : 이용가능");
                machines[i].setIcon(machine);
            } else if (flag[i] == true) {
                usable[i] = new JLabel(num[i] + "번 세탁기 : 이용가능");
                machines[i].setIcon(machine);
            }
            btns[i].add(machines[i]);
            btns[i].add(usable[i]);
            p1.add(btns[i]);
        }
        JPanel p2 = new JPanel();
        back = new JButton("뒤로 이동");
        back.addActionListener(this);
        p2.add(back);

        smaller.add(p1);
        panelAll.add(p0);
        panelAll.add(p00);
        panelAll.add(smaller);
        panelAll.add(p2);
        rightBefore.add(panelAll);
        add(rightBefore);
        setVisible(true);
    }

    public void endLaundry(JButton washer) {
        for (int i = 0; i < 4; i++) {
            usable[i].setText(num[i] + "번 세탁기 : 이용가능");
            machines[i].setIcon(machine);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            OrFrame OF2 = new OrFrame();
        }
        for (int i = 0; i < 4; i++) {
            if (e.getSource() == machines[i]) {
                if (flag[i] == false) {
                    // selected = i;
                    // dispose();
                    PriceTag PT = new PriceTag();
                    flag[i] = true;/// 여기서 플래그가 바뀜
                    System.out.println(flag[i]);
                    // usable[i].setText(num[i] + "번 세탁기 : 사용중");
                    // machines[i].setIcon(machine_using);
                    // machines[i].setSelected(true);
                } else {
                    AlreadySelected AS = new AlreadySelected();
                }
            }
        }
    }
}

public class Laundry {
}