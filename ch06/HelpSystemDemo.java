// HelpSystemDemo.java
// ��� ���������� ������ ����� ������ � ��������
// ������� ������
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpSystemDemo extends JFrame {
  // ����������� ��� ����
  private JButton button1, button2, help;
  private HelpSystem hs = new HelpSystem();
  private InterceptPane ip = new InterceptPane();
  private ImageIcon helpIcon = new ImageIcon("Help.gif");

  public HelpSystemDemo() {
    super("HelpSystemDemo");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ��� ���������
    button1 = new JButton("���-�� ������");
    button2 = new JButton("���� ���-�� ������");
    JPanel contents = new JPanel();
    contents.add(button1);
    contents.add(button2);
    // ������ ������ ������
    help = new JButton(helpIcon);
    help.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ��� ������� �������� ���������� ������
        ip.setVisible(true);
        // � ����������� ��������� ����
        getRootPane().setCursor(getToolkit().
            createCustomCursor(helpIcon.getImage(),
            new Point(0, 0), ""));
      }
    });
    contents.add(help);
    // ����������� ��� ��������� � ���������� ������
    setContentPane(contents);
    setGlassPane(ip);
    // ������� ���� �� �����
    setSize(200, 200);
    setVisible(true);
  }
  // ���������, ��������������� �������
  class InterceptPane extends JComponent {
    InterceptPane() {
      // ���� �������� ������� �� ����
      enableEvents(MouseEvent.MOUSE_EVENT_MASK);
      enableEvents(KeyEvent.KEY_EVENT_MASK);
      // �� ��������� ������� � ���������
      setVisible(false);
      setOpaque(false);
    }
    // ������������� ������� �� ����
    public void processMouseEvent(MouseEvent e) {
      // ����������� ������� ����
      if ( e.getID() == MouseEvent.MOUSE_PRESSED) {
        // ����������, ����� ��������� ��� ������
        Component contentPane = getContentPane();
        MouseEvent ne =
            SwingUtilities.convertMouseEvent(
                this, e, contentPane);
        // ������� ��������� � ��������� �����������
        Component visibleComp =
            SwingUtilities.getDeepestComponentAt(
                contentPane, ne.getX(), ne.getY());
        // ���������� ���������� ����������
        JOptionPane.showMessageDialog(
            null, hs.getHelpFor(visibleComp));
        // �����������
        setVisible(false);
        // ���������� �� ����� ������� ��������� ����
        getRootPane().setCursor(
            Cursor.getDefaultCursor());
      }
    }
  }
  // �������� ������� ������
  class HelpSystem {
    // �������� ������ ��� �����������
    public String getHelpFor(Component comp) {
      if ( comp == button1)
        return "������������� �������. ����� �� �����";
      else if ( comp == button2 )
        return "������ ��������? ����� ����� �����!";
      return "���� � �� ����, ��� ��� �����";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HelpSystemDemo(); } });
  }
}