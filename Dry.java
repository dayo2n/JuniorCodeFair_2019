package doldol;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

class DryMachine extends JFrame implements ActionListener {

	private JLabel[] usable;
	private JButton[] machines;
	public int[] num = { 1, 2, 3 };
	public boolean[] flag = { false, false, false };// 모든 세탁기가 사용중이지않은 상태
	
	private JButton back;

//	private int selected;

	private ImageIcon machine = new ImageIcon("non-using.png");
	private ImageIcon machine_using = new ImageIcon("dryer.png");

	public DryMachine() {
		setTitle("Dry Machine");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(700, 500);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("washer1.png");
		this.setIconImage(img);

		JPanel rightBefore = new JPanel();

		JPanel panelAll = new JPanel();
		panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));

		JPanel p0 = new JPanel();// 화면 제목 패널
		JPanel p00 = new JPanel();
		JLabel l1 = new JLabel("충남대학교 학생생활관 세탁실");
		JLabel l2 = new JLabel("건조기 이용 현황");
		p0.add(l1);
		p00.add(l2);
		
		JPanel smaller = new JPanel();
		JPanel p1 = new JPanel();// 건조기 버튼+이용현황 버튼 패널
		p1.setLayout(new GridLayout(0, 3));
		JPanel[] btns = new JPanel[3];
		machines = new JButton[3];
		usable = new JLabel[3];

		for (int i = 0; i < 3; i++) {
			btns[i] = new JPanel();
			btns[i].setLayout((new BoxLayout(btns[i], BoxLayout.Y_AXIS)));
			machines[i] = new JButton();
			machines[i].addActionListener(this);
			usable[i] = new JLabel(num[i] + "번 건조기 : 이용가능");
			machines[i].setIcon(machine);
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
		for (int i = 0; i < 3; i++) {
			usable[i].setText(num[i] + "번 건조기 : 이용가능");
			machines[i].setIcon(machine);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			dispose();
			OrFrame OF2 = new OrFrame();
		}
		for (int i = 0; i < 3; i++) {
			if (e.getSource() == machines[i]) {
				if(flag[i]==false) {
			//	selected = i;
				flag[i] = true;/// 여기서 플래그가 바뀜
				// dispose();
				usable[i].setText(num[i] + "번 건조기 : 사용중");
				machines[i].setIcon(machine_using);
			//	machines[i].setSelected(true);
				PriceAlert PT = new PriceAlert();
				}else {
					AlreadySelected AS = new AlreadySelected();
				}
			}
		}
	}

	public void setFlag(boolean[] Flag) {
		for (int i = 0; i < 4; i++) {
			this.flag[i] = Flag[i];
		}
	}

/*	public int getSelectedNum() {
		return selected;
	}
*/
}
