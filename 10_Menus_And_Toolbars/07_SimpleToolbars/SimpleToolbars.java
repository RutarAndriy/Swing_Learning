// SimpleToolbars.java
// Прості панелі інструментів
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleToolbars extends JFrame {
  public SimpleToolbars() {
    super("SimpleToolbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // перша панель інструментів
    JToolBar toolbar1 = new JToolBar();
    // додамо кнопки
    toolbar1.add(new JButton(
        new ImageIcon("images/New16.gif")));
    toolbar1.add(new JButton(
        new ImageIcon("images/Open16.gif")));
    // розділювач
    toolbar1.addSeparator();
    // додамо команду
    toolbar1.add(new SaveAction());
    // друга панель інструментів
    JToolBar toolbar2 = new JToolBar();
    // додамо команду
    toolbar2.add(new SaveAction());
    // випадаючий список
    toolbar2.add(new JComboBox<String>(new String[] {
        "Жирний", "Звичайний" }));
    // додамо панелі інструментів у вікно
    add(toolbar1, "North");
    add(toolbar2, "South");
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // команда для панелі інструментів
  class SaveAction extends AbstractAction {
    public SaveAction() {
      // налаштуємо значок команди
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Save16.gif"));
      // текст підказки
      putValue(AbstractAction.SHORT_DESCRIPTION,
          "Зберегти документ...");
    }
    public void actionPerformed(ActionEvent e) {
      // нічого не робимо
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleToolbars(); } });
  }
}
