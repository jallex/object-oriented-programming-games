import java.util.ArrayList;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Represents a Mock of the BasicPyramidSolitaire Model to test that the Controller correctly
 * interacts with it.
 */
public class MockModel implements PyramidSolitaireModel {
  final StringBuilder log;

  MockModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public List getDeck() {
    log.append("getDeck() called.");
    return new ArrayList();
  }

  @Override
  public void startGame(List deck, boolean shouldShuffle, int numRows, int numDraw) {
    log.append("startGame(List deck, boolean shouldShuffle, int numRows, int numDraw) called.");
    log.append("deck: ");
    for (int i = 0; i < deck.size(); i++) {
      log.append(deck.get(i).toString());
    }
    log.append(String.format("shouldShuffle: %b, numRows: %d, numDraw: %d", shouldShuffle,
            numRows, numDraw));

  }

  @Override
  public void remove(int row1, int card1, int row2, int card2) throws IllegalStateException {
    log.append(String.format("The remove(int row1, int card1, int row2, int card2)" +
            " method was called."));
    log.append(String.format("row1: %d, card1: %d, row2: %d, card2: %d", row1,
            card1, row2, card2));
  }

  @Override
  public void remove(int row, int card) throws IllegalStateException {
    log.append(String.format("The remove(int row, int card) method was called."));
    log.append(String.format("row: %d, card: %d", row,
            card));
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card) throws IllegalStateException {
    log.append(String.format("The removeUsingDraw(int drawIndex, int row, int card)" +
            " method was called."));
    log.append(String.format("drawIndex: %d, row: %d, card: %d", drawIndex, row,
            card));
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalStateException {
    log.append(String.format("The discardDraw(int drawIndex)" +
            " method was called."));
    log.append(String.format("drawIndex: %d", drawIndex));
  }

  @Override
  public int getNumRows() {
    log.append(String.format("The getNumRows()" +
            " method was called."));
    return 0;
  }

  @Override
  public int getNumDraw() {
    log.append(String.format("The getNumDraw()" +
            " method was called."));
    return 0;
  }

  @Override
  public int getRowWidth(int row) {
    log.append(String.format("The getRowWidth(int row)" +
            " method was called."));
    log.append(String.format("row: %d", row));
    return 0;
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    log.append(String.format("The isGameOver()" +
            " method was called."));
    return true;
  }

  @Override
  public int getScore() throws IllegalStateException {
    log.append(String.format("The getScore()" +
            " method was called."));
    return 0;
  }

  @Override
  public Object getCardAt(int row, int card) throws IllegalStateException {
    log.append(String.format("The getCardAt(int row, int card)" +
            " method was called."));
    log.append(String.format("row: %d, card: %d", row,
            card));
    return null;
  }

  @Override
  public List getDrawCards() throws IllegalStateException {
    log.append(String.format("The getDrawCards()" +
            " method was called."));
    return null;
  }
}
