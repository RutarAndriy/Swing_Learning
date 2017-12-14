// UsingTextFields.java
// ������������� ��������� ����� Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UsingTextFields extends JFrame {
  // ���� ����
  private JTextField smallField, bigField;
  public UsingTextFields() {
    super("UsingTextFields");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ��������� ����
    smallField = new JTextField(10);
    bigField = new JTextField("����� ����", 25);
    // �������������� ���������
    bigField.setFont(new Font("Verdana", Font.PLAIN, 16));
    bigField.setHorizontalAlignment(JTextField.RIGHT);
    // ��������� ��������� �����
    smallField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ���������� ��������� �����
        JOptionPane.showMessageDialog(
            UsingTextFields.this,
            "���� �����: " +
                smallField.getText());
      }
    });
    // ���� � �������
    JPasswordField password = new JPasswordField(15);
    password.setEchoChar('$');
    // ��������� ���� � ���� � ������� ��� �� �����
    setLayout(new FlowLayout());
    add(smallField);
    add(bigField);
    add(password);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTextFields(); } });
  }
}
