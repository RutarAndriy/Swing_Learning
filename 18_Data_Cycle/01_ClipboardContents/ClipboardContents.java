// ClipboardContents.java
// Доступ до вмісту буфера обміну
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;

public class ClipboardContents extends JFrame {
  public ClipboardContents() {
    super("ClipboardContents");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо кнопку отримання вмісту
    JButton getButton = new JButton("Отримати");
    // текстове поле для виводу даних
    final JTextArea textArea = new JTextArea();
    getButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          // буфер обміну
          Clipboard clipboard = Toolkit.getDefaultToolkit().
              getSystemClipboard();
          // виведемо всі типи даних
          for (DataFlavor next:
              clipboard.getAvailableDataFlavors()) {
            textArea.append(next.toString() + "\n");
            // спроба отримати самі дані
            textArea.append(clipboard.
                getData(next).toString() + "\n");
          }
        } catch (UnsupportedFlavorException ex) {
          ex.printStackTrace();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    });
    add(new JScrollPane(textArea));
    add(getButton, "South");
    // виведемо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() { new ClipboardContents(); } });
  }
}
