// TabComponents.java
// Розміщення компонентів у вкладках
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TabComponents extends JFrame {
  public TabComponents() {
    super("TabComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // панель із вкладками
    final JTabbedPane tabs = new JTabbedPane();
    tabs.addTab(null, new JPanel());
    tabs.addTab(null, new JPanel());
    // прапорець у вкладці
    JCheckBox checkBox = new JCheckBox("Прапорець!");
    checkBox.setOpaque(false);
    tabs.setTabComponentAt(0, checkBox);
    // вкладка із написом та кнопкою закривання
    final JPanel panel = new JPanel();
    JLabel label = new JLabel("Можна закрити!");
    JButton closeButton = new JButton(new AbstractAction() {
      {
        putValue(SMALL_ICON, new ImageIcon("Close.png"));
      }
      public void actionPerformed(ActionEvent e) {
        // треба визначити вкладку, у якій знаходиться кнопка
        tabs.removeTabAt(
            tabs.indexOfTabComponent(panel));
      }
    });
    closeButton.setBorderPainted(false);
    closeButton.setContentAreaFilled(false);
    panel.setOpaque(false);
    panel.add(label);
    panel.add(closeButton);
    tabs.setTabComponentAt(1, panel);
    // виводимо вікно на екран
    add(tabs);
    setSize(430, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabComponents(); } });
  }
}
