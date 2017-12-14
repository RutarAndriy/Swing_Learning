// UsingSpinnerModels.java
// ������������� ����������� ������� ��������
import javax.swing.*;
import java.awt.*;

public class UsingSpinnerModels extends JFrame {
  // ����� ������ ��� ��������
  private String[] data = {
    "�������", "���������", "�����", "�����"
  };
  public UsingSpinnerModels() {
    super("UsingSpinnerModels");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ �������� ��� ������ �� ������ ������
    SpinnerModel list = new SpinnerListModel(data);
    JSpinner spinner1 = new JSpinner(list);
    // ������ �������� ��� ������ ����� �����
    SpinnerModel numbers = new SpinnerNumberModel(
      4, 0, 100, 1);
    JSpinner spinner2 = new JSpinner(numbers);
    // ������� �������� � ������ �����������
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
          public void run() { new UsingSpinnerModels(); } });
  }
}
