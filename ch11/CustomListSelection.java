// CustomListSelection.java
// ���������� ������� ������ ���������
import javax.swing.*;
import java.awt.*;

public class CustomListSelection extends JFrame {
  private String[] data = { "����������", "������",
      "��������", "�������"};
  public CustomListSelection() {
    super("CustomListSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������ � ������� ��� � ����
    JList list = new JList(data);
    list.setSelectionModel(new CustomSelectionModel());
    add(new JScrollPane(list));
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  // ����������� ������ ���������
  class CustomSelectionModel
      extends DefaultListSelectionModel {
    // ���������� ��������� ���������
    public void addSelectionInterval(int idx0, int idx1) {
      super.addSelectionInterval(idx0, idx1);
      adjustSelection(idx0);
    }
    // ��������� ��������� ���������
    public void setSelectionInterval(int idx0, int idx1) {
      super.setSelectionInterval(idx0, idx1);
      adjustSelection(idx0);
    }
    // ����� ����� "���������" ���������
    private void adjustSelection(int idx) {
      if ( idx == 0 )
        addSelectionInterval(2, 2);
      if ( idx == 1 )
        addSelectionInterval(3, 3);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomListSelection(); } });
  }
}