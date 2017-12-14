// FlowLayoutSample.java
// ���������������� ������������
import java.awt.*;
import javax.swing.*;

public class FlowLayoutSample extends JFrame {
	public FlowLayoutSample() {
		super("FlowLayoutSample");
		setSize(400, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// ������������� ���������������� ������������ �
		// ������������� ����������� �� ������
		setLayout( new FlowLayout( FlowLayout.CENTER ));
		// ��������� ����������
		add( new JButton("����"));
		add( new JButton("���"));
		add( new JButton("���"));
		// ������� ���� �� �����
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new FlowLayoutSample(); } });
	}
}