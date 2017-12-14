// CommandButtons.java
// �������� ������ ��������� ������
import javax.swing.*;
import java.awt.*;

public class CommandButtons extends JFrame {
	public CommandButtons() {
		super("CommandButtons");
		setSize(350, 250);
		setLocation(150, 100);
		setDefaultCloseOperation( EXIT_ON_CLOSE );    
		// ������� ������ � ��������� ������������� ���
		// ������������ �������� ������
		JPanel grid = new JPanel(
			new GridLayout(1, 2, 5, 0) );
		// ��������� ����������
		grid.add( new JButton("OK"));
		grid.add( new JButton("������"));
		// �������� ���������� � ������ � ����������������
		// �������������, ����������� �� ������� ����
		JPanel flow = new JPanel(
			new FlowLayout( FlowLayout.RIGHT ));
		flow.add(grid);
		// �������� ������ ������ ���� ����
		add(flow, BorderLayout.SOUTH );
		// ������� ���� �� �����
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new CommandButtons(); } });
	}
}