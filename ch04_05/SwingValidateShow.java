// ��������� Swing - ����������� �����������
// ����������� � ���� ����. � ��������� ����� revalidate()
// ��������� �� ������������ � �������
import javax.swing.*;

public class SwingValidateShow extends JFrame {
  private static JButton button, newButton;

  public SwingValidateShow() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(400, 300);
    JPanel contents = new JPanel();
    button = new JButton("�����");
    JButton button2 = new JButton("����� 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingValidateShow().setVisible(true);
      }
    });
    Thread.sleep(2000);
    // ������ ��� ����� ��������� ���� �������
    // revalidate() � �� ����� �� ������ ���������
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        button.setText("����� ������� �����");
      }
    });
    // ��� ���������� � ��������� revalidate()
    // ������������� �� ����������
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        newButton = new JButton("�������");
        button.getParent().add(newButton);
      }
    });
    Thread.sleep(2000);
    // revalidate() ����� ���� ������ �� ������ ������
    newButton.revalidate();
  }
}