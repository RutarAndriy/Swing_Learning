// BoxSample.java
// Блокове розміщення
import javax.swing.*;
import java.awt.*;

public class BoxSampleY extends JFrame {
	public BoxSampleY() {
		super("BoxSample - Y");
		setSize(400, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// отримуємо панель вмісту
		Container c = getContentPane();
		// встановлюємо блокове розміщення по
		// осі Y (стовбцем)
		BoxLayout boxy = new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(boxy);
		// додаємо компоненти
		c.add( new JButton("Один"));
		c.add( new JButton("Два"));
		c.add( new JButton("Три"));
		// виводимо вікно на екран
		setVisible(true);
	}
	static class BoxSampleX extends JFrame {
		public BoxSampleX() {
			super("BoxSample - X");
			// задаємо розмір і позицію вікна
			setSize(400, 200);
			setLocation(100, 100);
			setDefaultCloseOperation( EXIT_ON_CLOSE  );
			// отримуємо панель вмісту
			Container c  = getContentPane();
		    // встановлюємо блокове розміщення по
		    // осі X (рядком)
			BoxLayout boxx = 
				new BoxLayout(c, BoxLayout.X_AXIS);
			c.setLayout(boxx);
			// додаємо компоненти
			c.add( new JButton("Один"));
			c.add( new JButton("Два"));
			c.add( new JButton("Три"));
			// виводимо вікно на екран
			setVisible(true);
		}    
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BoxSampleY(); new BoxSampleX(); } });
	}
}
