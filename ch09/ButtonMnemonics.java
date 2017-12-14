// ButtonMnemonics.java
// ��������� �������� ������������ ��������
import javax.swing.*;
import java.awt.*;

public class ButtonMnemonics extends JFrame {
  public ButtonMnemonics() {
    super("ButtonMnemonics");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ���������� ���������������� ������������
    setLayout(new FlowLayout());
    // ������� ������
    JButton button = new JButton("������� ����!");
    // ��������� (������� ������)
    button.setMnemonic('�');
    add(button);
    // ��� ���� ������, ������ ������� �� ����������
    button = new JButton("All Right!");
    button.setMnemonic('L');
    button.setToolTipText("����� �����");
    button.setDisplayedMnemonicIndex(2);
    add(button);
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonMnemonics(); } });
  }
}
