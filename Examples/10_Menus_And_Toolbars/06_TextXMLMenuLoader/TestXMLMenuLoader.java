// TestXMLMenuLoader.java
// Перевірка завантаження системи меню із файлу XML
import javax.swing.*;
import com.porty.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class TestXMLMenuLoader extends JFrame {
  public TestXMLMenuLoader() {
    super("TestXMLMenuLoader");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // відкриваємо файл XML із описом меню
    try {
      InputStream stream =
          new FileInputStream("Menu.xml");
      // завантажуємо меню
      XMLMenuLoader loader =
          new XMLMenuLoader(stream);
      loader.parse();
      // встановлюємо рядок меню
      setJMenuBar(loader.getMenuBar("mainMenu"));
      // швидке приєднання прослуховувача
      loader.addActionListener("exit",
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
          });
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TestXMLMenuLoader(); } });
  }
}
