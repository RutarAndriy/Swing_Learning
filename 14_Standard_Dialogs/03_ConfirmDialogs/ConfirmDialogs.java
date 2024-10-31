// ConfirmDialogs.java
// Стандартні діалогові вікна для отримання від
// користувача підтвердження здійснюваної дії
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ConfirmDialogs extends JFrame {
  // значок для одного із повідомлень
  private Icon icon = new ImageIcon("Goblet.png");
  public ConfirmDialogs() {
    super("ConfirmDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // після клацання по кнопких відображаються повідомлення
    JButton confirm1 = new JButton("2 і 4 параметри");
    confirm1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // діалогове вікно із 4-ма параметрами
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this, "Ви цього хочете?",
            "Питання",
            JOptionPane.YES_NO_CANCEL_OPTION);
        // найпростіші діалогові вікна
        if ( res == JOptionPane.YES_OPTION )
          JOptionPane.showConfirmDialog(
              ConfirmDialogs.this, "Точно хочете?");
        if ( res == JOptionPane.NO_OPTION )
          JOptionPane.showConfirmDialog(
              ConfirmDialogs.this,
              "Значить, не хочете?");
      }
    });
    JButton confirm2 = new JButton("5 параметрів");
    confirm2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this,
            "Думайте ретельно, отже...",
            "Може статися помилка!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
      }
    });
    JButton confirm3 = new JButton("6 параметрів");
    confirm3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this, "Вам подобається значок?",
            "Повністю налаштоване вікно!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE, icon);
      }
    });
    // додаємо кнопки у вікно
    setLayout(new FlowLayout());
    add(confirm1);
    add(confirm2);
    add(confirm3);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ConfirmDialogs(); } });
  }
}
