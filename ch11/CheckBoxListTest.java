// CheckBoxListTest.java
// �������� ������ ������ � ��������
import javax.swing.*;
import com.porty.swing.*;
import java.awt.*;

public class CheckBoxListTest {
  // ������ ������
  private static Object[] data = {
      new CheckBoxListElement(false, "������"),
      new CheckBoxListElement(false,
          "<html><h3><font color=red>�������"),
      new CheckBoxListElement(false, "����� �������"),
      new CheckBoxListElement(true, "��������� �����")
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // ������� ������ � ����������� ���
            JList list = new CheckBoxList(data);
            // ��������� � ����
            JFrame frame = new JFrame("CheckBoxListTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
