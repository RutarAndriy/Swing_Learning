// ButtonGroupUse.java
// Клас ButtonGroup допомагає забезпечити
// ексклюзивний вибір
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;
import java.awt.*;

public class ButtonGroupUse extends JFrame {
  public ButtonGroupUse() {
    super("ButtonGroupUse");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // створюємо горизонтальну панель
    // із блочним розміщенням
    JPanel bh = BoxLayoutUtils.createHorizontalPanel();
    // напис і відступ
    bh.add(new JLabel("Чому ви надаєте перевагу:"));
    bh.add(Box.createHorizontalStrut(12));
    // декілька вимикачів JToggleButton
    JToggleButton b1 = new JToggleButton("Чай", true);
    JToggleButton b2 = new JToggleButton("Кава");
    JToggleButton b3 = new JToggleButton("Лимонад");
    // додамо всі кнопки в групу ButtonGroup
    ButtonGroup bg = new ButtonGroup();
    bg.add(b1);
    bg.add(b2);
    bg.add(b3);
    // додамо всі кнопки в контейнер, врахуємо при
    // цьому рекомендації інтерфейсу "Metal"
    bh.add(b1);
    bh.add(Box.createHorizontalStrut(2));
    bh.add(b2);
    bh.add(Box.createHorizontalStrut(2));
    bh.add(b3);
    getContentPane().add(bh);
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonGroupUse(); } });
  }
}
