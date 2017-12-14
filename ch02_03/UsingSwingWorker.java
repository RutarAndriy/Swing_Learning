// UsingSwingWorker.java
// ����� SwingWorker ��� ������������ ����������

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class UsingSwingWorker extends JFrame {
  private JButton button;

  public UsingSwingWorker() {
    super("UsingSwingWorker");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ �� ����������
    button = new JButton("��������� ������� ������");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // �������� ��������� ������ ������
        new ComplexJob().execute();
        button.setText("���������...");
      }
    });
    // �������� ������ ����������� � ������� ���� �� �����
    setLayout(new FlowLayout());
    add(new JTextField(20));
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  // �����, ����������� "������� ������"
  class ComplexJob extends SwingWorker<String, String> {
    // ����� ����������� ������, ��� ��������� �����!
    public String doInBackground() throws Exception {
      Thread.sleep(2000);
      // ��������� ������������� ����������
      publish("�������� ������ ���������...");
      Thread.sleep(2000);
      return "";
    }

    // ��������� ������������� �����������
    // ��� ����� �������� �������!
    public void process(List<String> chunks) {
      button.setText(chunks.get(0));
    }

    // ��������� ������ - � ����� ��� ����� ��������
    public void done() {
      button.setText("������ ���������");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new UsingSwingWorker();
          }
        });
  }
}