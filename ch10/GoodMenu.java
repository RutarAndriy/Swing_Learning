// GoodMenu.java
// ������������ ���������� � ��������� ��� ���� Swing
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GoodMenu extends JFrame {
  public GoodMenu() {
    super("GoodMenu");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������� ������ �������� ����
    JMenuBar menuBar = new JMenuBar();
    // ��������� ������ ����� �������������
    // ���������� ����
    menuBar.add(createFileMenu());
    menuBar.add(createEditMenu());
    // �������� ���� � ���� ����
    setJMenuBar(menuBar);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  // ������� ���� "����"
  private JMenu createFileMenu() {
    // ���������� ����
    JMenu file = new JMenu("����");
    file.setMnemonic('�');
    // ����� ���� "�������"
    JMenuItem open = new JMenuItem("�������");
    open.setMnemonic('�'); // ������� �����
    // ��������� ������� �������� ������� (��������� �����)
    open.setAccelerator(
      KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
    // ����� ���� "���������"
    JMenuItem save = new JMenuItem("���������");
    save.setMnemonic('�');
    save.setAccelerator(
      KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
    // ������� ��� � ����
    file.add(open);
    file.add(save);
    return file;
  }
  // ������� ���� "������"
  private JMenu createEditMenu() {
    // ���������� ����
    JMenu edit = new JMenu("������");
    edit.setMnemonic('�');
    // ����� ���� "��������"
    JMenuItem cut = new JMenuItem("��������");
    cut.setMnemonic('�');
    cut.setAccelerator(
      KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
    // ����� ���� "����������"
    JMenuItem copy = new JMenuItem("����������");
    copy.setMnemonic('�');
    // ������� �������� ������� ����� ������� � ���
    copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
    // ������
    edit.add(cut);
    edit.add(copy);
    return edit;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new GoodMenu(); } });
  }
}
