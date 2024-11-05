// CombiningToolbars.java
// Створення комбінованих панелей інструментів
import javax.swing.*;
import com.porty.swing.*;
import java.awt.event.*;

public class CombiningToolbars extends JFrame {
  public CombiningToolbars() {
    super("CombiningToolbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // декілька панелей інструментів
    JToolBar toolbar1 = new JToolBar();
    toolbar1.add(new OpenAction());
    toolbar1.add(new SaveAction());
    toolbar1.addSeparator();
    toolbar1.add(new JButton("Стиль"));
    JToolBar toolbar2 = new JToolBar();
    toolbar2.add(new JButton("Формат"));
    toolbar2.add(new JComboBox<String>(new String[] {
        "Червоний", "Зелений"}));
    JToolBar toolbar3 = new JToolBar();
    toolbar3.add(new JButton("Звичайний"));
    toolbar3.add(new JButton("Напівжирний"));
    toolbar3.add(new JButton("Підкреслений"));
    // вирівнювання вмісту
    toolbar2.add(Box.createGlue());
    // доамо дві панелі інструментів сюди
    JPanel first =
        BoxLayoutUtils.createHorizontalPanel();
    first.add(toolbar1);
    first.add(Box.createHorizontalStrut(5));
    first.add(toolbar2);
    // комбінуємо отримані панелі
    JPanel all =
        BoxLayoutUtils.createVerticalPanel();
    all.add(first);
    all.add(toolbar3);
    // вирівнювання вмісту
    BoxLayoutUtils.setGroupAlignmentX(
        JComponent.LEFT_ALIGNMENT, first, toolbar3);
    // додамо отримане на північ вікна
    add(all, "North");
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // некілька команд для панелі інструментів
  class OpenAction extends AbstractAction {
    public OpenAction() {
      // налаштуємо знакок команди
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Open16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      // нічого не робимо
    }
  }
  class SaveAction extends AbstractAction {
    public SaveAction() {
      // налаштуємо знакок команди
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Save16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      // нічого не робимо
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CombiningToolbars(); } });
  }
}
