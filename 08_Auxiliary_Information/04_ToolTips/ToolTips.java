// ToolTips.java
// Підказки в Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolTips extends JFrame {
  public ToolTips() {
    super("ToolTips");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо декілька кнопок з підказками
    JButton b1 = new JButton("Один");
    b1.setToolTipText("Це перша кнопка");
    JButton b2 = new JButton() {
      public Point getToolTipLocation(MouseEvent e) {
        return new Point(10, 10);
      }
      public String getToolTipText(MouseEvent e) {
        if ( e.getY() > 10 ) {
          return "Нижня частина кнопки!";
        }
        return super.getToolTipText(e);
      }
    };
    b2.setText("Два");
    b2.setToolTipText("<html><h3>Це друга кнопка.<ul>" +
        "Вона:<li>Нічого не робить<li>Але її можна натиснути!");
    JPanel contents = new JPanel();
    contents.add(b1);
    contents.add(b2);
    // виводимо вікно на екран
    add(contents);
    setSize(400, 150);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ToolTips(); } });
  }
}
