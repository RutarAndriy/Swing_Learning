// StartingEventThread.java
// �������� ������� ������� ������ �������� �������

import javax.swing.*;
import java.awt.*;

public class StartingEventThread {
  public static void main(String[] args) {
    // �������� ��������� ������� ������� �����
    Toolkit.getDefaultToolkit().
        getSystemEventQueue().push(new CustomQueue());
    // ������� ����
    JFrame frame = new JFrame("����");
    System.out.println("(1) JFrame()");
    // ��������� ������
    JCheckBox checkBox = new JCheckBox("����");
    frame.add(checkBox, "South");
    System.out.println("(2) �������� ������");
    // ������� ������
    DefaultListModel model = new DefaultListModel();
    JList list = new JList(model);
    frame.add(list);
    System.out.println("(3) �������� ������");
    // ��������� ������
    model.addElement("����");
    System.out.println("(4) ���������� ������");
    // ������������ ������� ��������� �� �����
    frame.setVisible(true);
    System.out.println("(5) ��������� ��������");
  }

  // ����������� ������� �������, ����������
  // ���������� ���������� � �������� � �������
  static class CustomQueue extends EventQueue {
    // ����� ������ ������� � �������
    public void postEvent(AWTEvent event) {
      System.out.println("post(), �����: " +
          Thread.currentThread().toString());
      System.out.println("post(), �������: " + event);
      super.postEvent(event);
    }

    // ����� ������������ ������� �� �����������
    protected void dispatchEvent(AWTEvent event) {
      System.out.println("dispatch(), �����: " +
          Thread.currentThread().toString());
      System.out.println("dispatch(), �������: " + event);
      super.dispatchEvent(event);
    }
  }
}
