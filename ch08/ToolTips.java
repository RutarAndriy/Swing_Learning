// ToolTips.java
// ��������� � Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolTips extends JFrame {
  public ToolTips() {
    super("ToolTips");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ��������� ������ � �����������
    JButton b1 = new JButton("����");
    b1.setToolTipText("��� ������ ������");
    JButton b2 = new JButton() {
      public Point getToolTipLocation(MouseEvent e) {
        return new Point(10, 10);
      }
      public String getToolTipText(MouseEvent e) {
        if ( e.getY() > 10 ) {
          return "������ ����� ������!";
        }
        return super.getToolTipText(e);
      }
    };
    b2.setText("���");
    b2.setToolTipText("<html><h3>��� ������ ������.<ul>" +
        "���:<li>������ �� ������<li>�� �� ����� ������!");
    JPanel contents = new JPanel();
    contents.add(b1);
    contents.add(b2);
    // ������� ���� �� �����
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