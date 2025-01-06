// VerticalLayout.java
// Простий менеджер розміщення, розміщує
// компоненти у вертикальний ряд з відступами
import java.awt.*;
import javax.swing.*;

public class VerticalLayout implements LayoutManager {
  // відступ між компонентами
  public int GAP = 5;
  // сигнал розмістити компоненти в контейнері
  public void layoutContainer(Container c) {
    Component comps[] = c.getComponents();
    int currentY = GAP;
    for (Component comp : comps) {
      // бажаний розмір компонента
      Dimension pref = comp.getPreferredSize();
      // вказуємо розташування компонента на екрані
      comp.setBounds(GAP, currentY,
          pref.width, pref.height);
      // проміжок між компонентами
      currentY += GAP;
      currentY += pref.height;
    }
  }
  // ці два методи нам не знадобляться
  public void addLayoutComponent(
      String name, Component comp) {
  }
  public void removeLayoutComponent(
      Component comp) {
  }
  // мінімальний розмір для контейнера
  public Dimension minimumLayoutSize(Container c) {
    return calculateBestSize(c);
  }
  // бажаний розмір для контейнера
  public Dimension preferredLayoutSize(Container c) {
    return calculateBestSize(c);
  }

  private Dimension size = new Dimension();
  // вираховує оптимальний розмір контейнера
  private Dimension calculateBestSize(Container c) {
    // спочатку вирахуємо довжину контейнера
    Component[] comps = c.getComponents();
    int maxWidth = 0;
    for (Component comp : comps) {
      int width = comp.getWidth();
      // пошук компонента з максимальною довжиною
      if (width > maxWidth) maxWidth = width;
    }
    // довжина контейнера із врахуванням лівого відступу
    size.width = maxWidth + GAP;
    // вираховуємо висоту контейнера
    int height = 0;
    for (Component comp : comps) {
      height += GAP;
      height += comp.getHeight();
    }
    size.height = height;
    return size;
  }

  // перевіримо роботу нового менеджера
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JFrame frame = new JFrame("VerticalLayout");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            // панель буде використовувати нове розміщення
            JPanel contents = new JPanel(
                new VerticalLayout());
            // додаємо пару кнопок і текстове поле
            contents.add(new JButton("Один"));
            contents.add(new JButton("Два"));
            contents.add(new JTextField(30));
            frame.add(contents);
            frame.setVisible(true);
            frame.pack();
          } });
  }
}
