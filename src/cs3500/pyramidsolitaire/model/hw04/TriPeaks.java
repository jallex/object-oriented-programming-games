package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.Type;

public class TriPeaks extends BasicPyramidSolitaire {

  @Override
  public List<ICard> getDeck() {
    ArrayList<ICard> deck1 = new ArrayList<ICard>();
    for (int i = 1; i <= 13; i++) {
      deck1.add(new Card(i, Type.HEARTS));
      deck1.add(new Card(i, Type.HEARTS));
      deck1.add(new Card(i, Type.CLUBS));
      deck1.add(new Card(i, Type.CLUBS));
      deck1.add(new Card(i, Type.DIAMONDS));
      deck1.add(new Card(i, Type.DIAMONDS));
      deck1.add(new Card(i, Type.SPADES));
      deck1.add(new Card(i, Type.SPADES));
    }
    return deck1;
  }

  @Override
  protected boolean isNotValidDeck(ArrayList<ICard> deckArray) {
    //checks if deck is valid: model must have 52 cards, no duplicate cards, no EmptyCards
    return !(hasNoOneRepeatOrEmpty(deckArray)
            && deckArray.size() == 104);
  }

  /**
   * Returns if this deck is valid concerning the number of copies of cards in the deck.
   * There must be one other copy of the card in the deck, and the cards cannot be null.
   * @param deckArray the deck that we are checking for copies and nulls.
   * @return true if the deck is valid.
   */
  private boolean hasNoOneRepeatOrEmpty(ArrayList<ICard> deckArray) {
    int count;
    for (int i = 0; i < deckArray.size(); i++) {
      if (deckArray.get(i) == null) {
        return false;
      }
      count = 0;
      for (int j = 0; j < deckArray.size(); j++) {
        if (i != j
                && deckArray.get(i).equals(deckArray.get(j))
                && deckArray.get(i) != null) {
          count += 1;
        }
      }
      //there should be one other card of this kind in the deck
      if (count != 1) {
        return false;
      }
    }
    return true;
  }

  //Questions: how to deal with the stock, how to return the new updated stock


  protected ICard[][] initializePyramid(int rows) {
    ICard[][] pyrLayout = new ICard[rows][];
    //the number of cards we are putting in current row
    int numCardsPerRow = 1;
    //the index of the card in the stock we are placing into the pyramid
    for (int i = rows; i <= 0; i--) {
      pyrLayout[i] = this.createRow(numCardsPerRow);
      numCardsPerRow += 1;
    }
    return pyrLayout;
  }

  protected ICard[] createRow(int numCardsPerRow) {
    ICard[] thisRow = new ICard[numCardsPerRow];
    int index = 0;
    for (int i = 0; i < numCardsPerRow; i++) {
      if (this.stock.size() > 0) {
        thisRow[index] = this.stock.get(0);
        //remove the card we just used from the stock
        this.stock.remove(0);
        index += 1;
      } else {
        throw new IllegalArgumentException("Not enough cards in the stock to create pyramid.");
      }
    }
    return thisRow;
  }
}
