// MenuSystem.java
// �������� ������� ���� � Swing
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class MenuSystem extends JFrame {
  public MenuSystem() {
    super("MenuSystem");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������� ������ �������� ����
    JMenuBar menuBar = new JMenuBar();
    // ��������� � ��� ���������� ����
    menuBar.add(createFileMenu());
    menuBar.add(createWhoMenu());
    // � ������������� �� � ��������
    // ���� ������ ����
    setJMenuBar(menuBar);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  // ������� ���� "����"
  private JMenu createFileMenu() {
    // �������� ���������� ����, ������� �����
    // ��������� ������� ������ ����
    JMenu file = new JMenu("����");
    // ����� ���� (�� �������)
    JMenuItem open =
        new JMenuItem("�������",
            new ImageIcon("images/open16.gif"));
    // ����� ���� �� �������
    JMenuItem exit = new JMenuItem(new ExitAction());
    // ������� ��� � ����
    file.add(open);
    // �����������
    file.addSeparator();
    file.add(exit);
    return file;
  }
  // �������� �������� ����
  private JMenu createWhoMenu() {
    // �������� ���������� ����
    JMenu who = new JMenu("��� �� ?");
    // ����-������
    JCheckBoxMenuItem clever =
        new JCheckBoxMenuItem("�����");
    JCheckBoxMenuItem smart =
        new JCheckBoxMenuItem("��������");
    JCheckBoxMenuItem tender =
        new JCheckBoxMenuItem("������");
    // ����-�������������
    JRadioButtonMenuItem male =
        new JRadioButtonMenuItem("�������");
    JRadioButtonMenuItem female =
        new JRadioButtonMenuItem("�������");
    // ���������� ������������� � ���������� ������
    ButtonGroup bg = new ButtonGroup();
    bg.add(male); bg.add(female);
    // ������� ��� � ����
    who.add(clever);
    who.add(smart);
    who.add(tender);
    // ����������� ����� ������� � ����
    who.add( new JSeparator());
    who.add(male);
    who.add(female);
    return who;
  }
  // ������� ������ �� ����������
  class ExitAction extends AbstractAction {
    ExitAction() {
      putValue(NAME, "�����");
    }
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new MenuSystem(); } });
  }
}
