// ControllingScrolling.java
// Управління процесом прокрутки з допомогою
// інтерфейсу Scrollable
import javax.swing.*;
import java.awt.*;

public class ControllingScrolling extends JFrame {
  public ControllingScrolling() {
    super("ControllingScrolling");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо в центр панель прокрутки із
    // нашим помпонентом
    add(new JScrollPane(new GridComponent()));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // компонент-"сітка" із особливим режимом прокручування
  class GridComponent extends JPanel
      implements Scrollable {
    // розмір клітинки сітки
    private int CELL_SIZE = 45;
    // кількість клітинок сітки
    private int CELL_COUNT = 50;
    // бажаний розмір компонента
    public Dimension getPreferredSize() {
      return new Dimension(CELL_SIZE*CELL_COUNT,
          CELL_SIZE*CELL_COUNT);
    }
    // промальовка компонента
    public void paintComponent(Graphics g) {
      // потрібно викликати метод базового класу
      super.paintComponent(g);
      for (int x=0; x<CELL_COUNT; x++) {
        for (int y=0; y<CELL_COUNT; y++) {
          // малюємо клітинку
          g.setColor(Color.BLACK);
          g.drawRect(x*CELL_SIZE, y*CELL_SIZE,
              CELL_SIZE, CELL_SIZE);
          // текст із координатами
          g.drawString(""+x+","+y,
              x*CELL_SIZE + 5, y*CELL_SIZE + CELL_SIZE/2);
        }
      }
    }
    // бажаний розмір області прокручування
    public Dimension
    getPreferredScrollableViewportSize() {
      return getPreferredSize();
    }
    // приріст при прокручуванні на один елемент
    public int getScrollableUnitIncrement(
        Rectangle visible, int or, int dir) {
      return CELL_SIZE;
    }
    // приріст при прокручуванні "блоком"
    public int getScrollableBlockIncrement(
        Rectangle visible, int or, int dir) {
      return CELL_SIZE*10;
    }
    // чи потрібно слідкувати за розміром області прокрутки
    public boolean getScrollableTracksViewportWidth() {
      return false;
    }
    public boolean getScrollableTracksViewportHeight() {
      return false;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ControllingScrolling(); } });
  }
}
