// TabSelection.java
// Робота з активними вкладками і обробка подій
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class TabSelection extends JFrame {
  public TabSelection() {
    super("TabSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо нашу панель із вкладками
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Вкладка", new JPanel());
    tabs.addTab("Ще вкладка", new JPanel());
    // додаємо прослуховувача подій
    tabs.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // додаємо на вкладку новий компонент
        JPanel panel = (JPanel)
            ((JTabbedPane)e.getSource()).
                getSelectedComponent();
        panel.add(new JButton("Кнопка"));
      }
    });
    // робота із низькорівневими подіями
    tabs.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // дізнаємося, на якій вкладці відбулося клацання
        int idx = ((JTabbedPane)e.getSource()).
            indexAtLocation(e.getX(), e.getY());
        JOptionPane.showMessageDialog(
            null, "Index: " + idx);
      }
    });
    // виводимо вікно на екран
    add(tabs);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabSelection(); } });
  }
}
