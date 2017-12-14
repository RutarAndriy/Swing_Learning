// BoxStruts.java
// ������������� �������� ��� ������� ������������
import javax.swing.*;
// ���������� ��� ����� �����
import com.porty.swing.BoxLayoutUtils;

public class BoxStruts extends JFrame {
	public BoxStruts() {
		super("BoxStruts");
		setSize(250, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// ������ � ������������ ������� �������������
		JPanel p = BoxLayoutUtils.createVerticalPanel();
		p.add(new JButton("����"));
		// �������� ������������ ��������
		p.add(Box.createVerticalStrut(15));
		// ����� ��������� � �������� ������� �������
		p.add(new JButton("���"));
		p.add(Box.createVerticalStrut(5));
		p.add(new JButton("���"));
		// ������ � �������������� ������� �������������
		JPanel p2 = BoxLayoutUtils.createHorizontalPanel();
		// �������� ����� ������� � ����� ������������
		p2.add(Box.createHorizontalStrut(10));
		p2.add(new JButton("����"));
		// �������� �������������� ��������
		p2.add(Box.createHorizontalStrut(25));
		p2.add(new JButton("���"));
		// ��������� ������ �� ����� � �� ����
		add(p, "North");
		add(p2, "South");
		// ������� ���� �� �����
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BoxStruts(); } });
	}
}
