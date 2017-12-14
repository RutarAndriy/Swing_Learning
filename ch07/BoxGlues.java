// BoxGlues.java
// ������������� ������������
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;

public class BoxGlues extends JFrame {
  public BoxGlues() {
    super("BoxGlues");
    setSize(250, 200);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������ � ������������ ������� �������������
    // � ��� �������� ��� ��������� ������
    JPanel main = BoxLayoutUtils.createVerticalPanel();
    // ������������ ������
    JPanel pVert = BoxLayoutUtils.createVerticalPanel();
    // ����������� ����� ������������ ���������
    // �� ����
    pVert.add(Box.createVerticalGlue());
    pVert.add(new JButton("����"));
    pVert.add(new JButton("���"));
    // �������������� ������
    // ������ ����� ���������� ���������� �� ������
    JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
    pHor.add(Box.createHorizontalGlue());
    pHor.add(new JButton("���"));
    pHor.add(new JButton("������"));
    pHor.add(Box.createHorizontalGlue());
    // ���������� ������ �����������
    main.add(pVert);
    main.add(Box.createVerticalStrut(15));
    main.add(pHor);
    // ��������� ������ � ����� ����
    add(main);
    // ������� ���� �� �����
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new BoxGlues(); } });
  }
}