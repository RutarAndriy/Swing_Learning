// SplashScreen.java
// �������� �������� ��� ����������
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
	public SplashScreen() {
		super();
    // ������ � ��������� ���� �� ������
		setLocation(200, 100);
		setSize(300, 300);
		// ������� �������� �����
		try {
			Robot robot = new Robot();
			capture = robot.createScreenCapture(
				new Rectangle(200, 100, 500, 400));
		} catch (Exception ex) { ex.printStackTrace(); }
		// ��������� ���������-��������
		getContentPane().add(new Splash());
		// ������� ���� �� �����
		setVisible(true);
		// ����������� ������ �� ��������� ���������� �������
/*
		try {
			Thread.sleep(10000);
		} catch (Exception e) {  }
*/
		//System.exit(0);
	}
	// ����������� ��� �����������
	private Image capture;
	private Image splash = 
		getToolkit().getImage("splash.gif");
	// ��������� ������ ��������
	class Splash extends JComponent {
		public void paintComponent(Graphics g) {
			// ������ ����� ������
			g.drawImage(capture, 0, 0, this);
			// � ������ ��� - ������� � ���������
			g.drawImage(splash, 0, 0, this);
		}
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new SplashScreen(); } });
	}
}
