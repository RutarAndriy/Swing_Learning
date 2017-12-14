// LoginDialog2.java
// ������ ����� � ������� � ������� MigLayout
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class LoginDialog2 extends JDialog {
  public LoginDialog2(JFrame parent) {
    super(parent, "���� � �������");
    // �������� ���� ��� ��������
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    // ��������� ������������ � ����� ����
    add(createGUI());
    // ������ ���������������� ������
    pack();
    // ������� ���� �� �����
    setVisible(true);
  }

  // ���� ����� ����� ���������� ������ �
  // ��������� �������������
  private JPanel createGUI() {
    // 1. �������� ������
    // � ������������ ������ "����" ������� �������
    JPanel main = new JPanel(new MigLayout("", "[][grow]"));
    // ������ ��� �����
    main.add(new JLabel("���:"));
    main.add(new JTextField(15), "gap rel, wrap rel, growx");
    // ������ ��� �����
    main.add(new JLabel("������:"));
    main.add(new JTextField(15), "gap rel, wrap unrel, growx");
    // ������ ��� ����� - ������ ����������� �������
    // ���������� ������ ������, ��������� ������ �� ���
    main.add(new JButton("OK"), "skip 1, split, sg buttons, align right");
    main.add(new JButton("������"), "sg buttons");
    // ������
    return main;
  }
  // �������� ����� ��� �������� ����������� ����
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new LoginDialog2(new JFrame());
      }
    });
  }
}