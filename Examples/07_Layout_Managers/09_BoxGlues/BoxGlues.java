// BoxGlues.java
// Використання заповнювачів
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;

public class BoxGlues extends JFrame {
  public BoxGlues() {
    super("BoxGlues");
    setSize(250, 200);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // панель з вертикальним блочним розміщенням
    // у неї помістимо решту панелей
    JPanel main = BoxLayoutUtils.createVerticalPanel();
    // вертикальна панель
    JPanel pVert = BoxLayoutUtils.createVerticalPanel();
    // заповнювач перед компонентами зсовує їх донизу
    pVert.add(Box.createVerticalGlue());
    pVert.add(new JButton("Один"));
    pVert.add(new JButton("Два"));
    // горизонтальна панель
    // тепер можна розмістити компоненти по центру
    JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
    pHor.add(Box.createHorizontalGlue());
    pHor.add(new JButton("Три"));
    pHor.add(new JButton("Чотири"));
    pHor.add(Box.createHorizontalGlue());
    // кладемо панелі вертикально
    main.add(pVert);
    main.add(Box.createVerticalStrut(15));
    main.add(pHor);
    // додаємо панель у центр вікна
    add(main);
    // виводимо вікно на екран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new BoxGlues(); } });
  }
}
