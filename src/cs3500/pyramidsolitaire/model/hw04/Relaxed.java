package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.ICard;

public class Relaxed extends BasicPyramidSolitaire {

  public Relaxed() {
    super();
  }

  public Relaxed(ArrayList<ICard> stock, ICard[][] pyramid,
                 ICard[] currentDraw, boolean gameStarted, Random rand) {
    super(stock, pyramid, currentDraw, gameStarted, rand);
  }

  @Override
  protected boolean isUncoveredTwoCard(int row1, int card1, int row2, int card2) {
    return isUncovered(row1, card1) || willBeUnCovered(row1, card1, row2, card2);
  }

  /**
   * Returns if either card will be uncovered if attempted to be removed with the other.
   * @param row1 the row of the first card
   * @param card1 the position in the row of the first card
   * @param row2 the row of the second card
   * @param card2 the position in the row of the second card
   * @return true if either card can be removed with the other card
   */
  private boolean willBeUnCovered(int row1, int card1, int row2, int card2) {
    return isUncovered(row2, card2)
            && Math.abs(row1 - row2) == 1
            && Math.abs(card1 - card2) == 1
            ||
            isUncovered(row1, card1)
                    && Math.abs(row1 - row2) == 1
                    && Math.abs(card1 - card2) == 1;
  }

  @Override
  protected boolean isMore13Pair() {
    return this.exposedAddTo13(this.findExposedCards())
            || this.areRelaxedMovesLeft()
            || this.drawAndExposedAddTo13(this.findExposedCards());
  }

  /**
   * Returns if there are still moves left in the Relaxed version of Pyramid Solitaire.
   * @return if there are still moves left in the game.
   */
  private boolean areRelaxedMovesLeft() {
    for(int i = 0; i < this.getNumRows(); i++) {
      for(int j = 0; j < this.getRowWidth(i); j++) {
        //test the card on the lower right
        if(this.willBeUnCovered(i, j, i + 1, j)) {
          return true;
        }
        //test the card on the lower left
          if (i != 0 && this.willBeUnCovered(i, j, i + 1, j - 1)) {
            return true;
          }
      }
    }
    return false;
  }
}
