// LoginDialog.java
// ����� �������� ��������������
// ����������������� ���������� �� �������
// ����������� ���� ����� � �������
import javax.swing.*;
import java.awt.*;
import com.porty.swing.BoxLayoutUtils;
import com.porty.swing.GUITools;

public class LoginDialog extends JDialog {
  public LoginDialog(JFrame parent) {
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
    // 1. ��������� ������, ������� ����� ���������
    // ��� ��������� �������� � ������ ������������
    JPanel main =
        BoxLayoutUtils.createVerticalPanel();
    // ����� ��������� ������� ����������� Java,
    // ���������� �������� ��� ���������� ��
    // ������ ���� �� 12 ��������.
    // ��� ����� ���������� ������ �����
    main.setBorder(
        BorderFactory.createEmptyBorder(12,12,12,12));
    // 2. ���������� ��������� "������", �� �������
    // ��� ������ ��������� �� ����� �������
    // �) ������ ��������� ���� � ������� � ����
    JPanel name =
        BoxLayoutUtils.createHorizontalPanel();
    JLabel nameLabel = new JLabel("���:");
    name.add(nameLabel);
    name.add(BoxLayoutUtils.createHorizontalStrut(12));
    JTextField nameField = new JTextField(15);
    name.add(nameField);
    // �) ������ ��������� ���� � ������� � ����
    JPanel password =
        BoxLayoutUtils.createHorizontalPanel();
    JLabel passwrdLabel = new JLabel("������:");
    password.add(passwrdLabel);
    password.add(BoxLayoutUtils.createHorizontalStrut(12));
    JTextField passwrdField = new JTextField(15);
    password.add(passwrdField);
    // �) ��� ������
    JPanel flow = new JPanel( new FlowLayout(
        FlowLayout.RIGHT, 0, 0) );
    JPanel grid = new JPanel( new GridLayout(
        1,2,5,0) );
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("������");
    grid.add(ok);
    grid.add(cancel);
    flow.add(grid);
    // 3. ���������� ����������� �������� ��
    // ������������ �����������, ��������� ��
    // ��������, �������� ���������� ��������
    // �) ������������� ������������
    // ��������� �������
    BoxLayoutUtils.setGroupAlignmentX(
        Component.LEFT_ALIGNMENT,
        name, password, main, flow);
    // �) ����������� ������������ ��������
    // � ��������� �����
    BoxLayoutUtils.setGroupAlignmentY(
        Component.CENTER_ALIGNMENT,
        nameField, passwrdField, nameLabel, passwrdLabel);
    // �) ���������� ������� �������� � ��������� �����
    GUITools.makeSameSize(nameLabel, passwrdLabel);
    // �) ���������� "�����������" ������ ��������� �����
    GUITools.fixTextFieldSize(nameField);
    GUITools.fixTextFieldSize(passwrdField);
    // 4. ������������� "����" ����� � ���������
    main.add(name);
    main.add(BoxLayoutUtils.createVerticalStrut(12));
    main.add(password);
    main.add(BoxLayoutUtils.createVerticalStrut(17));
    main.add(flow);
    // ������
    return main;
  }
  // �������� ����� ��� �������� ����������� ����
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new LoginDialog(new JFrame());
      }
    });
  }
}