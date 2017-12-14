// ButtonGroupUse.java
// ����� ButtonGroup �������� ����������
// ������������ �����
import javax.swing.*;
import com.porty.swing.BoxLayoutUtils;
import java.awt.*;

public class ButtonGroupUse extends JFrame {
  public ButtonGroupUse() {
    super("ButtonGroupUse");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // �������� �������������� ������
    // � ������� �������������
    JPanel bh = BoxLayoutUtils.createHorizontalPanel();
    // ������� � ������
    bh.add(new JLabel("��� �� �������������:"));
    bh.add(Box.createHorizontalStrut(12));
    // ��������� ������������ JToggleButton
    JToggleButton b1 = new JToggleButton("���", true);
    JToggleButton b2 = new JToggleButton("����");
    JToggleButton b3 = new JToggleButton("�������");
    // ������� ��� ������ � ������ ButtonGroup
    ButtonGroup bg = new ButtonGroup();
    bg.add(b1);
    bg.add(b2);
    bg.add(b3);
    // ������� ��� ������ � ���������, ����� ���
    // ���� ������������ ���������� "Metal"
    bh.add(b1);
    bh.add(Box.createHorizontalStrut(2));
    bh.add(b2);
    bh.add(Box.createHorizontalStrut(2));
    bh.add(b3);
    getContentPane().add(bh);
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonGroupUse(); } });
  }
}