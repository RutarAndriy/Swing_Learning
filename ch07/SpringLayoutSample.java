// SpringLayoutSample.java
// ������ ��������� SpringLayout
import javax.swing.*;
import java.awt.*;

public class SpringLayoutSample extends JFrame {
	public SpringLayoutSample() {
		super("SpringLayoutSample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������ � �������������� SpringLayout
		SpringLayout sl = new SpringLayout();
		JPanel contents = new JPanel(sl);		
		// ������� ���� �����������
    JButton button1, button2;
		contents.add(button1 = new JButton("������"));
		contents.add(button2 = new JButton("���������"));
		// �������� ��������
		sl.putConstraint(SpringLayout.WEST, button1, 
			5, SpringLayout.WEST, contents);
		sl.putConstraint(SpringLayout.WEST, button2, 5,
			SpringLayout.EAST, button1);		
		// ������� ���� �� �����
		setContentPane(contents);
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new SpringLayoutSample(); } });
	}
}