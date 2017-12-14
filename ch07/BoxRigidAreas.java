// BoxRigidAreas.java
// ������ ������������� ������������� ��������
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;
import java.awt.*;

public class BoxRigidAreas extends JFrame {
  public BoxRigidAreas() {
    super("BoxRigidAreas");
    setSize(250, 200);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������������ ������
    JPanel pVert = BoxLayoutUtils.createVerticalPanel();
    pVert.add(new JButton("����"));
    // �������������� ������
    JPanel pHor = BoxLayoutUtils.createHorizontalPanel();
    pHor.add(new JButton("���"));
    // ������ ������������ �������� � ���� �������
    // Dimension �� ������ java.awt
    pHor.add(Box.createRigidArea(new Dimension(50,120)));
    pHor.add(new JButton("���"));
    pVert.add(pHor);
    // ��������� ������������ ������ � ����� ����
    add(pVert);
    // ������� ���� �� �����
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new BoxRigidAreas(); } });
  }
}