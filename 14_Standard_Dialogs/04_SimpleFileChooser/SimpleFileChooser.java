// SimpleFileChooser.java
// Створення простих діалоових вікон 
// відкривання та зберігання файлів
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleFileChooser extends JFrame {
  // створюємо загальний екземпляр JFileChooser
  private JFileChooser fc = new JFileChooser();
  public SimpleFileChooser() {
    super("SimpleFileChooser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопка, створююча діалогове вікно для відкривання файлів
    JButton open = new JButton("Відкрити...");
    open.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Виберіть каталог");
        // налаштуємо для вибору каталогу
        fc.setFileSelectionMode(
            JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(
            SimpleFileChooser.this);
        // якщо файл вибраний, відобразимо його
        if ( res == JFileChooser.APPROVE_OPTION )
          JOptionPane.showMessageDialog(
              SimpleFileChooser.this,
              fc.getSelectedFile());
      }
    });
    // кнопка, створююча діалогове вікно для збереження файлу
    JButton save = new JButton("Зберегти...");
    save.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("Збереження файлу");
        // налаштування режиму
        fc.setFileSelectionMode(
            JFileChooser.FILES_ONLY);
        int res = fc.showSaveDialog(
            SimpleFileChooser.this);
        // повідомимо про успіх
        if ( res == JFileChooser.APPROVE_OPTION )
          JOptionPane.showMessageDialog(
              SimpleFileChooser.this,
              "Файл збережено");
      }
    });
    // додамо кнопки і виведемо вікно на екран
    setLayout(new FlowLayout());
    add(open);
    add(save);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleFileChooser(); } });
  }
}
