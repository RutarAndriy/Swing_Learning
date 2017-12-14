// SpinnerLabelEditor.java
// �������� �������� JSpinner �� ������ �������
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SpinnerLabelEditor extends JFrame {
  // ������ ��� ������
  private String[] data = {
      "�������", "�������", "�����"
  };
  public SpinnerLabelEditor() {
    super("SpinnerLabelEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� �������
    JSpinner spinner = new JSpinner(
        new SpinnerListModel(data));
    // ������������ ��� ��������
    LabelEditor editor = new LabelEditor();
    spinner.setEditor(editor);
    // ������������ ���������
    spinner.addChangeListener(editor);
    // ��� ��������� �� ������ ����������
    // ����� �� ��������� ����� �������
    spinner.getModel().setValue(data[1]);
    // ������� ���� �� �����
    setLayout(new FlowLayout());
    add(spinner);
    setSize(300, 200);
    setVisible(true);
  }
  // ����������� �������� ��� ��������
  class LabelEditor extends JLabel
      implements ChangeListener {
    // ����� ��������� �������
    public void stateChanged(ChangeEvent e) {
      // �������� �������
      JSpinner spinner = (JSpinner)e.getSource();
      // �������� ������� �������
      Object value = spinner.getValue();
      // ������������� ����� ��������
      if ( value.equals(data[0]) ) {
        setText("<html><h2><font color=\"red\">"
            + value);
      }
      if ( value.equals(data[1]) ) {
        setText("<html><h3><font color=\"green\">"
            + value);
      }
      if ( value.equals(data[2]) ) {
        setText("<html><h4><font color=\"blue\">"
            + value);
      }
    }
    // ������ ���������
    public Dimension getPreferredSize() {
      return new Dimension(100, 30);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SpinnerLabelEditor(); } });
  }
}