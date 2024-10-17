// BoxRigidAreas.java
// Приклад використання фіксованих областей
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;
import java.awt.*;

public class BoxRigidAreas extends JFrame {
  public BoxRigidAreas() {
    super("BoxRigidAreas");
    setSize(250, 200);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // вертикальна панель
    JPanel pVert = BoxLayoutUtils.createVerticalPanel();
    pVert.add(new JButton("Один"));
    // горизонтальна панель
    JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
    pHor.add(new JButton("Два"));
    // розмір простору задається у вигляді об'єкта
    // Dimension із пакету java.awt
    pHor.add(Box.createRigidArea(new Dimension(50,120)));
    pHor.add(new JButton("Три"));
    pVert.add(pHor);
    // додаємо вертикальну панель у центр вікна
    add(pVert);
    // виводимо вікно на екран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new BoxRigidAreas(); } });
  }
}
