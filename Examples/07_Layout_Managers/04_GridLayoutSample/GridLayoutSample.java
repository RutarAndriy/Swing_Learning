// GridLayoutSample.java
// Табличне розміщення
import java.awt.*;
import javax.swing.*;

public class GridLayoutSample extends JFrame {
	public GridLayoutSample() {
		super("GridLayoutSample");
		setSize(300, 200);
		setLocation(100, 100);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// допоміжна панель
		JPanel grid = new JPanel();
		// перші два параметри конструктора GridLayout -
		// кількість рядків і стовбців у таблиці
		// наступні два - відстань між клітинками по X та Y
		GridLayout gl = new GridLayout(2, 0, 5, 12);
		grid.setLayout(gl);
		// створюємо 8 кнопок
		for (int i=0; i<8; i++) {
			grid.add(new JButton("Кнопка " + i));
		}
		// поміщаємо нашу панель у центр вікна
		add(grid);
		// встановлюємо оптимальний розмір
		pack();
		// відображаємо вікно
		setVisible(true);
	}
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new GridLayoutSample(); } });
	}
}
