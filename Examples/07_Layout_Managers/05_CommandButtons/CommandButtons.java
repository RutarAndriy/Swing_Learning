// CommandButtons.java
// Створення панелі командних кнопок
import javax.swing.*;
import java.awt.*;

public class CommandButtons extends JFrame {
	public CommandButtons() {
		super("CommandButtons");
		setSize(350, 250);
		setLocation(150, 100);
		setDefaultCloseOperation( EXIT_ON_CLOSE );    
		// створюємо панель з табличним розташуванням для
		// вирівнювання розмірів кнопок
		JPanel grid = new JPanel(
			new GridLayout(1, 2, 5, 0) );
		// додаємо компоненти
		grid.add( new JButton("OK"));
		grid.add( new JButton("Відміна"));
		// поміщаємо отримане в панель із послідовним
		// розміщенням, вирівненим по правому краю
		JPanel flow = new JPanel(
			new FlowLayout( FlowLayout.RIGHT ));
		flow.add(grid);
		// поміщаємо рядок кнопок внизу вікна
		add(flow, BorderLayout.SOUTH );
		// виводимо вікно на екран
		setVisible(true);
	}  
	public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() { new CommandButtons(); } });
	}
}
