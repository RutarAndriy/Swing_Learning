// SimpleToolbars.java
// ������� ������ ������������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleToolbars extends JFrame {
  public SimpleToolbars() {
    super("SimpleToolbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ������ ������������
    JToolBar toolbar1 = new JToolBar();
    // ������� ������
    toolbar1.add(new JButton(
        new ImageIcon("images/New16.gif")));
    toolbar1.add(new JButton(
        new ImageIcon("images/Open16.gif")));
    // �����������
    toolbar1.addSeparator();
    // ������� �������
    toolbar1.add(new SaveAction());
    // ������ ������ ������������
    JToolBar toolbar2 = new JToolBar();
    // ������� �������
    toolbar2.add(new SaveAction());
    // �������������� ������
    toolbar2.add(new JComboBox(new String[] {
        "������", "�������" }));
    // ������� ������ ������������ � ����
    add(toolbar1, "North");
    add(toolbar2, "South");
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ������� ��� ������ ������������
  class SaveAction extends AbstractAction {
    public SaveAction() {
      // �������� ������ �������
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Save16.gif"));
      // ����� ���������
      putValue(AbstractAction.SHORT_DESCRIPTION,
          "��������� ��������...");
    }
    public void actionPerformed(ActionEvent e) {
      // ������ �� ������
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleToolbars(); } });
  }
}