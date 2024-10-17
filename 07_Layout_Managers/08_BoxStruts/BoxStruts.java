// BoxStruts.java
// Використання клинів при блоковому розміщеннні
import javax.swing.*;
// використовуємо наш новий клас
import com.porty.swing.BoxLayoutUtils;

public class BoxStruts extends JFrame {
	public BoxStruts() {
		super("BoxStruts");
		setSize(250, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// панель із вертикальним блоковим розміщенням
		JPanel p = BoxLayoutUtils.createVerticalPanel();
		p.add(new JButton("Один"));
		// створення вертикального клину
		p.add(Box.createVerticalStrut(15));
		// новий компонент та клин іншого розміру
		p.add(new JButton("Два"));
		p.add(Box.createVerticalStrut(5));
		p.add(new JButton("Три"));
		// панель із горизонтальним блоковим розміщенням
		JPanel p2 = BoxLayoutUtils.createHorizontalPanel();
		// клини можна ставити і перед компонентами
		p2.add(Box.createHorizontalStrut(10));
		p2.add(new JButton("Один"));
		// створення горизонтального клину
		p2.add(Box.createHorizontalStrut(25));
		p2.add(new JButton("Два"));
		// додаємо панелі на північ та південь вікна
		add(p, "North");
		add(p2, "South");
		// виводимо вікно на екран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BoxStruts(); } });
	}
}
