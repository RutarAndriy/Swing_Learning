// Box1.java
// ������� ������������
import javax.swing.*;
import java.awt.*;

public class Box1 extends JFrame {
	public Box1() {
		super("Box1 - Y");
		setSize(400, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// �������� ������ �����������
		Container c = getContentPane();
		// ������������� ������� ������������ ��
		// ��� Y (���������)
		BoxLayout boxy = new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(boxy);
		// ��������� ����������
		c.add( new JButton("����"));
		c.add( new JButton("���"));
		c.add( new JButton("���"));
		// ������� ���� �� �����
		setVisible(true);
	}
	static class Box2 extends JFrame {
		public Box2() {
			super("Box2 - X");
			// ������������� ������ � ������� ����
			setSize(400, 200);
			setLocation(100, 100);
			setDefaultCloseOperation( EXIT_ON_CLOSE  );
			// ��������  ������ �����������
			Container c  = getContentPane();
			// ������������� ������� ������������ ��
			// ��� X (��������)
			BoxLayout boxx = 
				new BoxLayout(c, BoxLayout.X_AXIS);
			c.setLayout(boxx);
			// ��������� ����������
			c.add( new JButton("����"));
			c.add( new JButton("���"));
			c.add( new JButton("���"));
			// ������� ���� �� �����
			setVisible(true);
		}    
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new Box1(); new Box2(); } });
	}
}