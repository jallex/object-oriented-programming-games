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

  private boolean willBeUnCovered(int row1, int card1, int row2, int card2) {
    return isUncovered(row2, card2)
            && Math.abs(row1 - row2) == 1
            && Math.abs(card1 - card2) == 1
            ||
            isUncovered(row1, card1)
                    && Math.abs(row1 - row2) == 1
                    && Math.abs(card1 - card2) == 1;
  }


  //need to update isGameOver methods.
}
