package doldol;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

class PriceAlert extends JFrame implements ActionListener {

    private JButton b1;

    public PriceAlert() {

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(450, 300);
        setTitle("Price tag");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("washer1.png");
        this.setIconImage(img);

        JPanel rightBefore = new JPanel();
        JPanel panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));

        JPanel p0 = new JPanel();
        JPanel p00 = new JPanel();
        JLabel l1 = new JLabel("건조는 45분 후에 완료됩니다.");
        JLabel l2 = new JLabel("건조 비용은 1000원입니다.");
        p0.add(l1);
        p00.add(l2);

        JPanel p1 = new JPanel();
        b1 = new JButton("결제 후 건조기 이용하기");
        b1.addActionListener(this);
        p1.add(b1);

        panelAll.add(p0);
        panelAll.add(p00);
        panelAll.add(p1);
        rightBefore.add(panelAll);
        add(rightBefore);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            dispose();
        }
    }
}

class PriceTag extends JFrame implements ActionListener {

    private JCheckBox[] option = new JCheckBox[3];
    private int[] option_price = { 500, 500, 500 };
    private JButton ok;
    private int total = 0;
    private JLabel alert;
    private JLabel lTotal;

    private JButton selectLaundry;
    public boolean[] Flag = { false, false, false, false };
    private int selected;

    int heyLaundry = 0;

    public PriceTag() {

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(450, 300);
        setTitle("Price tag");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("washer1.png");
        this.setIconImage(img);

        JPanel rightBefore = new JPanel();
        JPanel panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));

        JPanel p0 = new JPanel();
        JPanel p00 = new JPanel();
        JLabel l0 = new JLabel("구매할 옵션을 모두 선택하세요.");
        JLabel l1 = new JLabel("구매하지않을 경우 세탁기 선택 버튼 클릭.");
        p0.add(l0);
        p00.add(l1);

        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        option[0] = new JCheckBox("가루세제 500원");
        option[1] = new JCheckBox("액체세제 500원");
        option[2] = new JCheckBox("섬유유연제 500원");
        for (int i = 0; i < 3; i++) {
            option[i].addActionListener(this);
            p1.add(option[i]);
        }
        ok = new JButton("OK");
        ok.addActionListener(this);
        p1.add(ok);
        alert = new JLabel("기본 세탁 1회 1000원, 38분 소요");
        lTotal = new JLabel("");
        p1.add(alert);
        p1.add(lTotal);

        JPanel p2 = new JPanel();
        selectLaundry = new JButton("결제 후 선택한 세탁기 이용하기");
        selectLaundry.addActionListener(this);
        p2.add(selectLaundry);

        panelAll.add(p0);
        panelAll.add(p00);
        panelAll.add(p1);
        panelAll.add(p2);
        rightBefore.add(panelAll);
        add(rightBefore);
        setVisible(true);
    }

    public int getSelectLaundry() {
        return heyLaundry;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            total = 0;
            for (int i = 0; i < 3; i++) {
                if (option[i].isSelected()) {
                    total += option_price[i];
                }
            }
            lTotal.setText("총 금액: " + (1000 + total));

        }
        if (e.getSource() == selectLaundry) {
            LaundryMachine.usable[0].setText(LaundryMachine.num[0] + "번 세탁기 : 사용중");
            dispose();// 해당 프레임을 종료하는 메소드
        }
    }
}

class AlreadySelected extends JFrame implements ActionListener {

    private JButton exit;

    public AlreadySelected() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(500, 180);
        setTitle("Price tag");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("washer1.png");
        this.setIconImage(img);

        JPanel rightBefore = new JPanel();
        JPanel panelAll = new JPanel();
        panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("선택하신 기기는 이미 사용 중 입니다.");

        JPanel p2 = new JPanel();
        exit = new JButton("되돌아가기");
        exit.addActionListener(this);

        p1.add(l1);
        p2.add(exit);

        panelAll.add(p1);
        panelAll.add(p2);
        rightBefore.add(panelAll);
        add(rightBefore);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit)
            dispose();
    }

}

public class Price {
}
