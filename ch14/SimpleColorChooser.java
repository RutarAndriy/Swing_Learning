// SimpleColorChooser.java
// ����� ����� � ������� JColorChooser
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleColorChooser extends JFrame {
  public SimpleColorChooser() {
    super("SimpleColorChooser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ������� �� ����� ���� ������ �����
    JButton choose = new JButton("����� ����� ����");
    choose.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(
            SimpleColorChooser.this,
            "�������� ���� ����",
            getContentPane().getBackground());
        // ���� ���� ������, ���������� ���
        if ( color != null)
          getContentPane().setBackground(color);
        repaint();
      }
    });
    // ������� ���� �� �����
    setLayout(new FlowLayout());
    add(choose);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleColorChooser(); } });
  }
}
