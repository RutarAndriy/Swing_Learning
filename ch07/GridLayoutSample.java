// GridLayoutSample.java
// ��������� ������������
import java.awt.*;
import javax.swing.*;

public class GridLayoutSample extends JFrame {
	public GridLayoutSample() {
		super("GridLayoutSample");
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
		add(grid);
		// ������������� ����������� ������
		pack();
		// ���������� ����
		setVisible(true);
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new GridLayoutSample(); } });
	}
}
