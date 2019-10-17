package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.ICard;

/**
 * Represents a version of the Pyramid Solitaire Game in which the rules are relaxed, such that
 * if a Card will be fully uncovered if it is removed with a fully uncovered Card in front of it,
 * then the move of removing these two Cards is considered valid.
 */
public class Relaxed extends BasicPyramidSolitaire {

  /**
   * Constructs a {@code Relaxed} object.
   */
  public Relaxed() {
    super();
  }

  /**
   * Constructs a {@code Relaxed} object with more parameters for testing.
   */
  public Relaxed(ArrayList<ICard> stock, ICard[][] pyramid,
                 ICard[] currentDraw, boolean gameStarted, Random rand) {
    super(stock, pyramid, currentDraw, gameStarted, rand);
  }

  @Override
  protected boolean isUncoveredTwoCard(int row1, int card1, int row2, int card2) {
    return (this.isUncovered(row1, card1) && this.isUncovered(row2, card2))
            || willBeUnCovered(row1, card1, row2, card2);
  }

  /**
   * Returns if either card will be uncovered if attempted to be removed with the other.
   * Where row2 and card2 is on the bottom left or right.
   *
   * @param row1  the row of the first card
   * @param card1 the position in the row of the first card
   * @param row2  the row of the second card
   * @param card2 the position in the row of the second card
   * @return true if either card can be removed with the other card
   */
  private boolean willBeUnCovered(int row1, int card1, int row2, int card2) {
    /**
    return (Math.abs(card1 - card2) == 1 || Math.abs(card1 - card2) == 0)
            && (isUncovered(row2, card2)
            && row2 - row1 == 1
            && isOtherCardNull(row1, card1, row2, card2)
            || isUncovered(row1, card1)
         //   && Math.abs(row1 - row2) == 1
            && isOtherCardNull(row2, card2, row2, card2));**/

    return row2 - row1 == 1
            && (card2 - card1 == 1 || card2 - card1 == 0)
            && isUncovered(row2, card2)
            && isOtherCardNull(row1, card1, row2, card2);
  }

  /**
   * Returns if there is no other bottom at the location of given parameters row, card.
   *
   * @param row  the row the Card is in.
   * @param card the number card that the Card is in the row.
   * @return if there is no card at the bottom right of this card.
   */
  private boolean isOtherCardNull(int row, int card, int row1, int card1) {
    if (card == this.getRowWidth(row) - 1) {
      return true;
    } else {
      if (card - card1 == -1
              && this.getCardAt(row1, card) == null) {
        //Check the bottom left
        return true;
      } else if (card - card1 == 0
              && this.getCardAt(row1, card + 1) == null) {
        //Checks the bottom right
        return true;
      }
    }
    return false;
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
    for (int i = 0; i < this.getNumRows(); i++) {
      for (int j = 0; j < this.getRowWidth(i); j++) {
        //test the card on the lower right
        if (this.willBeUnCovered(i, j, i + 1, j)) {
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
