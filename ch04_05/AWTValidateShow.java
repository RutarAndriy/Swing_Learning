// ������� ��������� AWT - ��� ��������� ��������
//  ��� ������ ���������� �������� ������� validate()
import java.awt.*;

public class AWTValidateShow extends Frame {
  private static Button button;

  public AWTValidateShow() {
    setSize(400, 300);
    Panel contents = new Panel();
    button = new Button("�����");
    Button button2 = new Button("����� 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    new AWTValidateShow().setVisible(true);
    Thread.sleep(2000);
    button.setLabel("����� ������� �����");
    // � ����� ������� ������ ��������� - ������ invalidate()
    // ����� �������� validate() � ����������
    Thread.sleep(2000);
    // ����� ������ ���������� ���� ���������
    // � ��� ��� ���������� (������)
    button.getParent().validate();
  }
}