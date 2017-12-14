// DialogWindows.java
// ���������� ���� � Swing
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DialogWindows extends JFrame {
  public DialogWindows() {
    super("DialogWindows");
    // ����� ��� ��������
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ���� ������, ���������� �������� ���������� ����
    JButton button1 = new JButton("������� ����");
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JDialog dialog =
          createDialog("�����������",
              Dialog.ModalityType.MODELESS);
        dialog.setVisible(true);
      }
      });
    JButton button2 = new JButton("��������� ����");
    button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JDialog dialog =
          createDialog("���������",
              Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setVisible(true);
      }
      });
    // ������� ������ ����������� � ������� ���� �� �����
    JPanel contents = new JPanel();
    contents.add(button1);
    contents.add(button2);
    setContentPane(contents);
    setSize(350, 100);
    setVisible(true);
  }
  // ������� ���������� ����
  private JDialog createDialog(String title, Dialog.ModalityType modal){
    JDialog dialog = new JDialog(this, title, modal);
    dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    dialog.setSize(200, 60);
    return dialog;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new DialogWindows(); } });
  }
}
