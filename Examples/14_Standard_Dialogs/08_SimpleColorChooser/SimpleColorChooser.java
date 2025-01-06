// SimpleColorChooser.java
// Вибір кольору з допомогою JColorChooser
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleColorChooser extends JFrame {
  public SimpleColorChooser() {
    super("SimpleColorChooser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопка виводить на екран вікно вибору кольору
    JButton choose = new JButton("Вибір кольору фону");
    choose.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(
            SimpleColorChooser.this,
            "Виберіть колір фону",
            getContentPane().getBackground());
        // якщо колір вибрано, використовуємо його
        if ( color != null)
          getContentPane().setBackground(color);
        repaint();
      }
    });
    // виводимо вікно на екран
    setLayout(new FlowLayout());
    add(choose);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleColorChooser(); } });
  }
}
