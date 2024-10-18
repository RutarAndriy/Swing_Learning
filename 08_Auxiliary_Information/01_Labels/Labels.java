// Labels.java
// Налаштування вмісту написів
import java.awt.*;
import javax.swing.*;

public class Labels extends JFrame
    implements SwingConstants {
  public Labels() {
    super("Labels");
    // при закритті вікна завершуємо роботу
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // найпростіший напис
    JPanel contents = new JPanel();
    JLabel l1 = new JLabel("Ваше ім'я:");
    JTextField name = new JTextField(20);
    contents.add(l1);
    contents.add(name);
    // напис із значком
    JLabel l2 = new JLabel(new ImageIcon("Monkey.gif"));
    adjustLabel(l2);
    l2.setHorizontalAlignment(LEFT);
    contents.add(l2);
    // напис із нестандартним вирівнюванням
    JLabel l3 = new JLabel("Текст та значок",
        new ImageIcon("Bulb.gif"), RIGHT);
    adjustLabel(l3);
    l3.setVerticalTextPosition(BOTTOM);
    l3.setHorizontalTextPosition(LEFT);
    contents.add(l3);
    // вивід вікна на екран
    setContentPane(contents);
    setSize(320, 300);
    setVisible(true);
  }
  // метод проводить спеціальне налаштування напису
  private void adjustLabel(JLabel l) {
    l.setOpaque(true);
    l.setBackground(Color.white);
    l.setPreferredSize(new Dimension(250, 100));
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Labels(); } });
  }
}
