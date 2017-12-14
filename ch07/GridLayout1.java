// GridLayout1.java
// ��������� ������������
import java.awt.*;
import javax.swing.*;

public class GridLayout1 extends JFrame {
	public GridLayout1() {
		super("GridLayout1");
		setSize(300, 200);
		setLocation(100, 100);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// ��������������� ������
		JPanel grid = new JPanel();
		// ������ ��� ��������� ������������ GridLayout -
		// ���������� ����� � �������� � �������
		// ������ ��� - ���������� ����� �������� �� X � Y
		GridLayout gl = new GridLayout(2, 0, 5, 12);
		grid.setLayout(gl);
		// ������� 8 ������
		for (int i=0; i<8; i++) {
			grid.add(new JButton("������ " + i));
		}
		// �������� ���� ������ � ����� ����
		getContentPane().add(grid);
		// ������������� ����������� ������
		pack();
		// ���������� ����
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayout1();
	}
}
