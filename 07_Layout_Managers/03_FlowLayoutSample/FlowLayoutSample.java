// FlowLayoutSample.java
// Почергове розміщення
import java.awt.*;
import javax.swing.*;

public class FlowLayoutSample extends JFrame {
	public FlowLayoutSample() {
		super("FlowLayoutSample");
		setSize(400, 200);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// встановлюємо почергове розміщення з
		// вирівнюванням компонентів по центру
		setLayout( new FlowLayout( FlowLayout.CENTER ));
		// додаємо компоненти
		add( new JButton("Один"));
		add( new JButton("Два"));
		add( new JButton("Три"));
		// виводимо вікно на екран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new FlowLayoutSample(); } });
	}
}
