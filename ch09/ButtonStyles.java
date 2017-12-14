// ButtonStyles.java
// ��������� �������� ���� ������ JButton
// � ������� �������, ������, ����� � �. �.
import javax.swing.*;
import java.awt.*;

public class ButtonStyles extends JFrame {
  public ButtonStyles() {
    super("ButtonStyles");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ���������� ���������������� ������������
    setLayout(
        new FlowLayout( FlowLayout.LEFT, 10, 10));
    // ����� ������� ������
    JButton button = new JButton("������� ������");
    add(button);
    // ������ �� �������� �� ��� ������ �����
    button = new JButton();
    button.setIcon(new ImageIcon("images/b1.gif"));
    button.setRolloverIcon(
        new ImageIcon("images/b1r.gif"));
    button.setPressedIcon(
        new ImageIcon("images/b1p.gif"));
    button.setDisabledIcon(
        new ImageIcon("images/b1d.gif"));
    // ��� ����� ������ ����� ������
    // ��� �������� ����� � ��������
    button.setBorderPainted(false);
    button.setFocusPainted(false);
    button.setContentAreaFilled(false);
    add(button);
    // ������ � ���������� ������ � HTML-�������
    button = new JButton(
        "<html><h2><font color=\"yellow\">������� ������");
    button.setBackground(Color.green);
    add(button);
    // ��������� ������������ ������ � �����������
    button = new JButton("��������� ������������",
        new ImageIcon("images/button.gif"));
    button.setMargin(new Insets(10, 10, 10, 10));
    button.setVerticalAlignment(SwingConstants.TOP);
    button.setHorizontalAlignment(SwingConstants.RIGHT);
    button.setHorizontalTextPosition(SwingConstants.LEFT);
    button.setVerticalTextPosition(SwingConstants.BOTTOM);
    button.setIconTextGap(10);
    // ������� ������ �������, ����� ������� ������������
    button.setPreferredSize(new Dimension(300, 100));
    add(button);
    // ����������� ������
    button = new JButton("���������");
    button.setEnabled(false);
    add(button);
    // ������� ���� �� �����
    setSize(400, 350);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonStyles(); } });
  }
}
