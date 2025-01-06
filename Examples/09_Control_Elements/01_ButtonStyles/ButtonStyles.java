// ButtonStyles.java
// Зміна зовнішнього вигляду кнопок JButton
// із допомогою значків, кольорів, рамок і т.п.
import javax.swing.*;
import java.awt.*;

public class ButtonStyles extends JFrame {
  public ButtonStyles() {
    super("ButtonStyles");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // використовуємо послідовне розміщення
    setLayout(
        new FlowLayout( FlowLayout.LEFT, 10, 10));
    // найпростіша кнопка
    JButton button = new JButton("Звичайна кнопка");
    add(button);
    // кнопка зі значками на всі випадки життя
    button = new JButton();
    button.setIcon(new ImageIcon("images/B1.gif"));
    button.setRolloverIcon(
        new ImageIcon("images/B1r.gif"));
    button.setPressedIcon(
        new ImageIcon("images/B1p.gif"));
    button.setDisabledIcon(
        new ImageIcon("images/B1d.gif"));
    // для такої кнопки краще прибрати
    // всі непотрібні рамки та заливку
    button.setBorderPainted(false);
    button.setFocusPainted(false);
    button.setContentAreaFilled(false);
    add(button);
    // кнопка із зміненим кольором та HTML-текстом
    button = new JButton(
        "<html><h2><font color=\"yellow\">Зелена кнопка");
    button.setBackground(Color.green);
    add(button);
    // зміна вирівнювання тексту та зображення
    button = new JButton("Зміна вирівнювання",
        new ImageIcon("images/Button.gif"));
    button.setMargin(new Insets(10, 10, 10, 10));
    button.setVerticalAlignment(SwingConstants.TOP);
    button.setHorizontalAlignment(SwingConstants.RIGHT);
    button.setHorizontalTextPosition(SwingConstants.LEFT);
    button.setVerticalTextPosition(SwingConstants.BOTTOM);
    button.setIconTextGap(10);
    // робимо кнопку великою, щоб побачити вирівнювання
    button.setPreferredSize(new Dimension(300, 100));
    add(button);
    // вимкнена кнопка
    button = new JButton("Вимкнено");
    button.setEnabled(false);
    add(button);
    // виводимо вікно на екран
    setSize(400, 350);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonStyles(); } });
  }
}
