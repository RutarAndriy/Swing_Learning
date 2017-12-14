// ConfirmClosing.java
// ������������� � ������ �� ����������
import javax.swing.*;
import java.awt.event.*;

public class ConfirmClosing extends JFrame {
  public ConfirmClosing() {
    super("����������");
    // ��������� �������� ��������
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    // ��������� ��������� ������� �� ����
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // ������������ ������
        int res = JOptionPane.
         showConfirmDialog(null, "������������� �����?");
        if ( res == JOptionPane.YES_OPTION )
         System.exit(0);
      }
      });
    // ������� ���� �� �����
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new ConfirmClosing(); } });
  }
}
