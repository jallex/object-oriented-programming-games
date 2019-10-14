package cs3500.pyramidsolitaire.view;

import java.io.IOException;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Represents the Textual view of a Pyramid Solitaire Game.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {
  private final PyramidSolitaireModel<?> model;
  private Appendable ap;

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
  }

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  @Override
  public String toString() {
    String empty = "  ";
    if (model.getNumRows() == -1) {
      return "";
    }
    if (model.getScore() == 0) {
      return "You win!";
    }
    if (model.isGameOver()) {
      return "Game over. Score: " + model.getScore();
    }
    StringBuilder stringModel = new StringBuilder();
    int numlength = model.getNumRows() - 1;
    String whiteSpace = "  ";
    for (int i = 0; i < numlength; i++) {
      whiteSpace += "  ";
    }
    String c = "";
    int lengthPreceeding = 0;
    boolean emptyLine = true;
    for (int i = 0; i < model.getNumRows(); i++) {
      int lastNonNull = -1;
      for (int j = 0; j < model.getRowWidth(i); j++) {
        if (model.getCardAt(i, j) != null) {
          lastNonNull = j;
        }
      }
      if (whiteSpace.length() > 1) {
        whiteSpace = whiteSpace.substring(2);
      }
      if (lastNonNull != -1) {
        stringModel.append(whiteSpace);
        for (int j = 0; j <= lastNonNull; j++) {
          if (j != lastNonNull) {
            if (model.getCardAt(i, j) == null) {
              c = "   ";
            } else {
              c = padChar(model.getCardAt(i, j).toString());
            }
          } else {
            if (model.getCardAt(i, j) == null) {
              c = "   ";
            } else {
              c = model.getCardAt(i, j).toString();
            }
          }
          if (j != 0) {
            stringModel.append(" ");
          }
          stringModel.append(c);
        }
      }
      if (i < model.getNumRows() - 1) {
        stringModel.append("\n");
      }
    }
    stringModel.append("\nDraw:");
    int num = lastNonEmpty(model.getDrawCards());
    for (int i = 0; i <= num; i++) {
      if (i != 0 && model.getDrawCards().get(i) != null) {
        stringModel.append(",");
      }
      stringModel.append(" " + model.getDrawCards().get(i));
    }
    return stringModel.toString();
  }

  @Override
  //appends the current textual output to the Appendable
  public void render() throws IOException {
    if (this.ap != null) {
      this.ap.append(this.toString());
    }
  }

  /**
   * Pads all Strings to 3 characters.
   *
   * @param c the String input
   * @return the String padded/formatted to 3 characters
   */
  private String padChar(String c) {
    if (c == null) {
      return "   ";
    }
    if (c.length() == 2) {
      c += " ";
    }
    return c;
  }

  private int lastNonEmpty(List c) {
    for (int i = c.size() - 1; i >= 0; i--) {
      if (c.get(i) != null) {
        return i;
      }
    }
    return -1;
  }
}