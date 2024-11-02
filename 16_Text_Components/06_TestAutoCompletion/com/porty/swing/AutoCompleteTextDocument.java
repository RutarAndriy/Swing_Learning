// com/porty/swing/AutoCompleteTextDocument.java
// Модель документу із підтримкою автодоповнення
package com.porty.swing;

import javax.swing.text.*;
import javax.swing.*;
import java.util.*;

public class AutoCompleteTextDocument extends PlainDocument {
  // текстовий компонент в якому працює документ
  private JTextComponent comp;
  // список шарів для автодоповнення
  private List<String> words = new ArrayList<String>();
  // конструктор вимагає текстовий компонент
  public AutoCompleteTextDocument(JTextComponent comp) {
    this.comp = comp;
    comp.setDocument(this);
  }
  // додає слово у список
  public void addWord(String word) {
    words.add(word);
  }
  // властивість, керуюча початком автодоповнення
  private int beforeCompletion = 3;
  public void setBeforeCompletion(int value) {
    beforeCompletion = value;
  }

  // викликається при вставці в документ нового тексту
  @Override
  public void insertString(int offs, String str, AttributeSet a)
      throws BadLocationException {
    // поточна позиція в тексті
    int end = offs + str.length();
    // визначаємо позицію поточного слова
    final int wordStart = Utilities.getWordStart(comp, offs);
    // довжина поточного слова
    int wordLength = end - wordStart;
    // перевіряємо, чи можна завершити слово
    if ( wordLength >= beforeCompletion) {
      // отримуємо поточне слово
      String word = getText(wordStart, offs - wordStart) + str;
      // намагаємося знайти його повний варіант у списку
      String wholeWord = "";
      for (String next : words) {
        if (next.startsWith(word)) {
          // слово знайдено
          wholeWord = next;
          break;
        }
      }
      // якщо слово знайдено
      if ( wholeWord.length() > 0) {
        // вирізаємо частину для автодоповнення
        final String toComplete =
            wholeWord.substring(wordLength);
        // позиція для виділення цієї частини
        final int startPos = offs + str.length();
        final int endPos = end + toComplete.length();
        // додаємо добавку до тексту
        str = str + toComplete;
        // відложена задача для виділення добавки
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            try {
              // виділяємо добавлену частину
              comp.setSelectionStart(startPos);
              comp.setSelectionEnd(endPos);
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });
      }
    }
    // батьківський метод додасть текст
    super.insertString(offs, str, a);
  }
}
