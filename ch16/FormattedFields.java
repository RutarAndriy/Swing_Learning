// FormattedFields.java
// ���������� ����� JFormattedTextField
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.util.Date;
import java.awt.*;

public class FormattedFields extends JFrame {
  // ���� ��� ���������������� ����� ������
  private JFormattedTextField
      phoneField, dateField, numberField;
  public FormattedFields() {
    super("FormattedFields");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������������ ���� �� ������ �����
    // ���������� �����
    try {
      MaskFormatter phone =
          new MaskFormatter("+#-###-###-##-##");
      phone.setPlaceholderCharacter('0');
      phoneField = new JFormattedTextField(phone);
      phoneField.setColumns(15);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // �������������� ����
    // ������ ����
    DateFormat date =
        new SimpleDateFormat("dd MMMM yyyy, EEEE");
    // ��������� �������������� �������
    DateFormatter formatter = new DateFormatter(date);
    formatter.setAllowsInvalid(false);
    formatter.setOverwriteMode(true);
    // ��������� ���������� ����
    dateField = new JFormattedTextField(formatter);
    dateField.setColumns(15);
    dateField.setValue(new Date());
    // �������������� �����
    // ������ ����� � �����������
    NumberFormat number = new DecimalFormat("##0.##E0");
    numberField = new JFormattedTextField(
        new NumberFormatter(number));
    // ��������� ����
    numberField.setColumns(10);
    numberField.setValue(1500);
    // ��������� ���� � ������ �����������
    setLayout(new FlowLayout());
    add(new JLabel("�������:"));
    add(phoneField);
    add(new JLabel("����:"));
    add(dateField);
    add(new JLabel("�����:"));
    add(numberField);
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FormattedFields(); } });
  }
}
