// TestXMLMenuLoader.java
// �������� �������� ������� ���� �� ����� XML
import javax.swing.*;
import com.porty.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class TestXMLMenuLoader extends JFrame {
  public TestXMLMenuLoader() {
    super("TestXMLMenuLoader");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� ���� XML � ��������� ����
    try {
      InputStream stream =
          new FileInputStream("menu.xml");
      // ��������� ����
      XMLMenuLoader loader =
          new XMLMenuLoader(stream);
      loader.parse();
      // ������������� ������ ����
      setJMenuBar(loader.getMenuBar("mainMenu"));
      // ������� ������������� ���������
      loader.addActionListener("exit",
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
          });
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TestXMLMenuLoader(); } });
  }
}