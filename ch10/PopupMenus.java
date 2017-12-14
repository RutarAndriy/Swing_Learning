// PopupMenus.java
// ������ � ������������ ����
import javax.swing.*;
import java.awt.*;

public class PopupMenus extends JFrame {
  public PopupMenus() {
    super("PopupMenus");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // �������� ����������� ����
    JPopupMenu popup = createPopupMenu();
    // � ����������� � ����� ������ �����������
    ((JComponent)getContentPane()).
        setComponentPopupMenu(popup);
    // "����������" ��� ���� ������
    JButton button = new JButton("����� ����");
    button.setInheritsPopupMenu(true);
    add(button, "South");
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  // ������� ���� ����������� ����
  private JPopupMenu createPopupMenu() {
    // ������� ���� ����������� ����
    JPopupMenu pm = new JPopupMenu();
    // ������� ��� ������
    JMenuItem good = new JMenuItem("�������");
    JMenuItem excellent = new JMenuItem("������������");
    // � ��������� ��� ��� �� ������� add()
    pm.add(good);
    pm.add(excellent);
    return pm;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new PopupMenus(); } });
  }
}
