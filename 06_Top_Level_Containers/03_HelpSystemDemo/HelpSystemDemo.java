// HelpSystemDemo.java
// Приклад як прозора панель може допомогти у створенні
// системи допомоги
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpSystemDemo extends JFrame {
  // необхідні нам поля
  private JButton button1, button2, help;
  private HelpSystem hs = new HelpSystem();
  private InterceptPane ip = new InterceptPane();
  private ImageIcon helpIcon = new ImageIcon("Help.gif");

  public HelpSystemDemo() {
    super("HelpSystemDemo");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо наш інтерфейс
    button1 = new JButton("Що-небуть робить");
    button2 = new JButton("Також що-небуть робить");
    JPanel contents = new JPanel();
    contents.add(button1);
    contents.add(button2);
    // кнопка виклику допомоги
    help = new JButton(helpIcon);
    help.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // при натисненні включаємо прозору панель
        ip.setVisible(true);
        // та спеціальний вказівник миші
        getRootPane().setCursor(getToolkit().
            createCustomCursor(helpIcon.getImage(),
            new Point(0, 0), ""));
      }
    });
    contents.add(help);
    // налаштовуємо наш інтерфейс та прозору панель
    setContentPane(contents);
    setGlassPane(ip);
    // виводимо вікно на екран
    setSize(200, 200);
    setVisible(true);
  }
  // компонент, перехоплюючий події
  class InterceptPane extends JComponent {
    InterceptPane() {
      // потрібно увімкнути події від миші
      enableEvents(MouseEvent.MOUSE_EVENT_MASK);
      enableEvents(KeyEvent.KEY_EVENT_MASK);
      // за замовлуванням невидимий та прозорий
      setVisible(false);
      setOpaque(false);
    }
    // перехоплюємо події від миші
    public void processMouseEvent(MouseEvent e) {
      // відслідковуємо натискання миші
      if ( e.getID() == MouseEvent.MOUSE_PRESSED) {
        // визначаємо, який компонент був вибраний
        Component contentPane = getContentPane();
        MouseEvent ne =
            SwingUtilities.convertMouseEvent(
                this, e, contentPane);
        // видимий компонент у вказаних координатах
        Component visibleComp =
            SwingUtilities.getDeepestComponentAt(
                contentPane, ne.getX(), ne.getY());
        // показуємо довідкову інформацію
        JOptionPane.showMessageDialog(
            null, hs.getHelpFor(visibleComp));
        // вимикаємося
        setVisible(false);
        // повертаємо на місце звичний вказівник миші
        getRootPane().setCursor(
            Cursor.getDefaultCursor());
      }
    }
  }
  // прототип системи допомоги
  class HelpSystem {
    // отримуємо допомогу для компонентів
    public String getHelpFor(Component comp) {
      if ( comp == button1)
        return "Зупиняє реактор. Краще не натискайте";
      else if ( comp == button2 )
        return "Хочите лимонаду? Тоді сміливо натискайте!";
      return "Навіть не знаю, що це таке";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HelpSystemDemo(); } });
  }
}
