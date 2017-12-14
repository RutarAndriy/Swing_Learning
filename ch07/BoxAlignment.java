// BoxAlignment.java
// ��� ������� ������������ ������������ ������������
// ����������� �� ����
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;

public class BoxAlignment extends JFrame {
	public BoxAlignment() {
		super("BoxAlignment");
		setSize(400, 150);
		setDefaultCloseOperation( EXIT_ON_CLOSE );    
		// ������������ ������
		JPanel pv = BoxLayoutUtils.createVerticalPanel();
		// ������ � ������������� �� ����� �������
		JButton jb = new JButton("����� �������");
		jb.setAlignmentX(LEFT_ALIGNMENT);
		pv.add(jb);
		// ����� � ����������� �������������
		jb = new JButton("������������ �� ������");
		jb.setAlignmentX(CENTER_ALIGNMENT);
		pv.add(jb);
		// �������, ������ � ������������� �� ������� ����
		jb = new JButton("������ �������");
		jb.setAlignmentX(RIGHT_ALIGNMENT);
		pv.add(jb);
		// ��������� ������ � ����� ����
		add(pv);
		// ������� ���� �� �����
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BoxAlignment(); } });
	}
}
