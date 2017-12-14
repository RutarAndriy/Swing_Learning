// com/porty/swing/AutoCompleteTextDocument.java
// ������ ��������� � ���������� ��������������
package com.porty.swing;

import javax.swing.text.*;
import javax.swing.*;
import java.util.*;

public class AutoCompleteTextDocument extends PlainDocument {
  // ��������� ��������� � ������� �������� ��������
  private JTextComponent comp;
  // ������ ���� ��� ��������������
  private List<String> words = new ArrayList<String>();
  // ����������� ������� ��������� ���������
  public AutoCompleteTextDocument(JTextComponent comp) {
    this.comp = comp;
    comp.setDocument(this);
  }
  // ��������� ����� � ������
  public void addWord(String word) {
    words.add(word);
  }
  // ��������, ����������� ������� ��������������
  private int beforeCompletion = 3;
  public void setBeforeCompletion(int value) {
    beforeCompletion = value;
  }

  // ���������� ��� ������� � �������� ������ ������
  @Override
  public void insertString(int offs, String str, AttributeSet a)
      throws BadLocationException {
    // ������� ������� � ������
    int end = offs + str.length();
    // ���������� ������� �������� �����
    final int wordStart = Utilities.getWordStart(comp, offs);
    // ����� �������� �����
    int wordLength = end - wordStart;
    // ��������, ����� �� ��������� �����
    if ( wordLength >= beforeCompletion) {
      // �������� ������� �����
      String word = getText(wordStart, offs - wordStart) + str;
      // �������� ����� ��� ������ ������� � ������
      String wholeWord = "";
      for (String next : words) {
        if (next.startsWith(word)) {
          // ����� �������
          wholeWord = next;
          break;
        }
      }
      // ���� ����� �������
      if ( wholeWord.length() > 0) {
        // �������� ����� ��� ��������������
        final String toComplete =
            wholeWord.substring(wordLength);
        // ������� ��� ��������� ���� �����
        final int startPos = offs + str.length();
        final int endPos = end + toComplete.length();
        // ��������� ������� � ������
        str = str + toComplete;
        // ���������� ������ ��� ��������� �������
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            try {
              // ������� ����������� �����
              comp.setSelectionStart(startPos);
              comp.setSelectionEnd(endPos);
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });
      }
    }
    // ������������ ����� ������� �����
    super.insertString(offs, str, a);
  }
}