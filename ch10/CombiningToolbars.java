// CombiningToolbars.java
// �������� ��������������� �������
// ������������
import javax.swing.*;
import com.porty.swing.*;
import java.awt.event.*;

public class CombiningToolbars extends JFrame {
  public CombiningToolbars() {
    super("CombiningToolbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� ������� ������������
    JToolBar toolbar1 = new JToolBar();
    toolbar1.add(new OpenAction());
    toolbar1.add(new SaveAction());
    toolbar1.addSeparator();
    toolbar1.add(new JButton("�����"));
    JToolBar toolbar2 = new JToolBar();
    toolbar2.add(new JButton("������"));
    toolbar2.add(new JComboBox(new String[] {
        "�������", "�������"}));
    JToolBar toolbar3 = new JToolBar();
    toolbar3.add(new JButton("�������"));
    toolbar3.add(new JButton("����������"));
    toolbar3.add(new JButton("������������"));
    // ������������ �����������
    toolbar2.add(Box.createGlue());
    // ������� ��� ������ ������������ ����
    JPanel first =
        BoxLayoutUtils.createHorizontalPanel();
    first.add(toolbar1);
    first.add(Box.createHorizontalStrut(5));
    first.add(toolbar2);
    // ����������� ���������� ������
    JPanel all =
        BoxLayoutUtils.createVerticalPanel();
    all.add(first);
    all.add(toolbar3);
    // ������������ �����������
    BoxLayoutUtils.setGroupAlignmentX(
        JComponent.LEFT_ALIGNMENT, first, toolbar3);
    // ������� ���������� �� ����� ����
    add(all, "North");
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ��������� ������ ��� ������� ������������
  class OpenAction extends AbstractAction {
    public OpenAction() {
      // �������� ������ �������
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Open16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      // ������ �� ������
    }
  }
  class SaveAction extends AbstractAction {
    public SaveAction() {
      // �������� ������ �������
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("images/Save16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      // ������ �� ������
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CombiningToolbars(); } });
  }
}