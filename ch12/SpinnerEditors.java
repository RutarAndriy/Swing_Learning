// SpinnerEditors.java
// ����������� ��������� ���������
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SpinnerEditors extends JFrame {
  // ������ ��� ������� ��������
  private String[] data = {
      "������", "������", "���������"
  };
  public SpinnerEditors() {
    super("SpinnerEditors");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� �� ������ �������
    JSpinner spinner1 = new JSpinner(
        new SpinnerListModel(data));
    // ����������� ��������
    ((JSpinner.ListEditor)spinner1.getEditor()).
        getTextField().setColumns(15);
    // ����� ���
    SpinnerDateModel dates = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    JSpinner spinner2 = new JSpinner(dates);
    // ����������� ��������
    ((JSpinner.DateEditor)spinner2.getEditor()).
        getTextField().setEditable(false);
    // ��������� �������� � ������ �����������
    setLayout(new FlowLayout());
    add(spinner1);
    add(spinner2);
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SpinnerEditors(); } });
  }
}
