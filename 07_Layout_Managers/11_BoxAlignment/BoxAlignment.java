// BoxAlignment.java
// Як блокове розміщення забезпечує вирівнювання
// компонентів по осях
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;

public class BoxAlignment extends JFrame {
	public BoxAlignment() {
		super("BoxAlignment");
		setSize(400, 150);
		setDefaultCloseOperation( EXIT_ON_CLOSE );    
		// вертикальна панель
		JPanel pv = BoxLayoutUtils.createVerticalPanel();
		// кнопка з вирівнюванням по лівій межі
		JButton jb = new JButton("Ліва межа");
		jb.setAlignmentX(LEFT_ALIGNMENT);
		pv.add(jb);
		// кнопка із центральним вирівнюванням
		jb = new JButton("Вирівнювання по центру");
		jb.setAlignmentX(CENTER_ALIGNMENT);
		pv.add(jb);
		// нарешті, кнопка із вирівнюванням по правому краю
		jb = new JButton("Права межа");
		jb.setAlignmentX(RIGHT_ALIGNMENT);
		pv.add(jb);
		// додаємо панель у центр вікна
		add(pv);
		// виводимо вікно на екран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BoxAlignment(); } });
	}
}
