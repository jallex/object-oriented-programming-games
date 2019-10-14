package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.Type;

public class TriPeaks extends BasicPyramidSolitaire {

  public TriPeaks() {
    super();
  }

  public TriPeaks(ArrayList<ICard> stock, ICard[][] pyramid,
                  ICard[] currentDraw, boolean gameStarted, Random rand) {
    super(stock, pyramid, currentDraw, gameStarted, rand);
  }

  public TriPeaks(Random rand) {
    super(rand);
  }

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
   * Returns if this deck is valid concerning the number of copies of cards in the deck. There must
   * be one other copy of the card in the deck, and the cards cannot be null.
   *
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

  //Questions: test the new exceptions of decks
  //remake getRowWidth
  /**
   @Override
   protected ICard[][] initializePyramid(int rows, ArrayList<ICard> deckArray) {
   ICard[][] pyrLayout = new ICard[rows][];
   //find the number of cards that should be on the bottom level of the pyramid.
   //7 x 7 pyramid -
   //row + 1 / 2
   int bottomRowAmt = this.findBottomRow(rows - 1);
   int fullRowsBeforePeaks = (rows + 1) / 2;
   for (int i = rows - 1; i >= fullRowsBeforePeaks - 1; i--) {
   pyrLayout[i] = this.createRow(bottomRowAmt, deckArray);
   bottomRowAmt -= 1;
   }
   //the number of nulls in between each split off pyramid
   int numNullSpaced = 1;
   for (int i = fullRowsBeforePeaks; i >= 0; i--) {
   pyrLayout[i] = this.createBranchingRow(bottomRowAmt, deckArray, numNullSpaced);
   bottomRowAmt -= 1;
   numNullSpaced += 1;
   }
   return pyrLayout;
   }

   protected ICard[] createBranchingRow(int numCardsPerRow, ArrayList<ICard> deckArray,
   int numNullSpaced) {
   ICard[] thisRow = new ICard[numCardsPerRow];
   int index = 0;
   //the number of Cards between each gap of nulls in the row
   int numCardsSpaced = (numCardsPerRow - (2 * numNullSpaced)) / 3;
   for (int i = 1; i <= 5; i++) {
   //Place nulls
   if (i % 2 == 0) {
   for (int j = 0; j < numNullSpaced; j++) {
   if (index <= numCardsPerRow - 1) {
   thisRow[index] = null;
   index += 1;
   }
   }
   } else { //place Cards
   for (int j = 0; j < numCardsSpaced; j++) {
   if (deckArray.size() > 0 && index <= numCardsPerRow - 1) {
   thisRow[index] = deckArray.get(0);
   //remove the card we just used from the stock
   deckArray.remove(0);
   index += 1;
   } else {
   throw new IllegalArgumentException("Not enough cards in the stock to create pyramid.");
   }
   }
   }
   }
   return thisRow;
   }
   **/

  @Override
  protected ICard[][] initializePyramid(int rows, ArrayList<ICard> deckArray) {
    ICard[][] pyrLayout = new ICard[rows][];
    //the total number of nulls in the 0 indexed row
    int numNulls;
    if (rows <= 3) {
      numNulls = 0;
    } else {
      numNulls = (rows) / 2 - 1;
    }

    //the current index row of the pyramid.
    int index = 0;

    int numCardsInRow;
    if (rows == 1) {
      numCardsInRow = 1;
    }
    else {
      numCardsInRow = numCardsInRow(index);
    }

    //the number of consecutive cards in a group of cards where 3 groups are in a row
    int conseqCards = numCardsInRow / 3;

    //the number of consecutive nulls in a group of nulls where 2 groups of nulls are in a row
    int conseqNulls = numNulls - index;

    int numPyramidRowsTriPeaks = (rows - 1) / 2;

    //the row width
    int rowWidth;
    if (conseqNulls <= 0) {
      rowWidth = numCardsInRow;
    } else {
      rowWidth = numCardsInRow + 2 * conseqNulls;
    }

    for (int i = 0; i < numPyramidRowsTriPeaks; i++) {
      pyrLayout[i] = this.createBranchingRow(index, conseqCards, conseqNulls, deckArray, rowWidth);
      index += 1;
      conseqCards = this.numCardsInRow(index) / 3;
      conseqNulls = numNulls - index;
      rowWidth += 1;
    }

    for (int i = numPyramidRowsTriPeaks; i < rows; i++) {
      pyrLayout[i] = this.createRow(rowWidth, deckArray);
      rowWidth += 1;
    }
    return pyrLayout;
  }

  private ICard[] createBranchingRow(int rowNum, int conseqCards, int conseqNulls,
                                       ArrayList<ICard> deckArray, int rowWidth) {
    int rowIndex = 0;
    ICard[] thisRow = new ICard[rowWidth];
    if (conseqNulls < 1) {
      for (int i = 0; i < conseqCards * 3; i++) {
        if (deckArray.size() > 0) {
          thisRow[rowIndex] = deckArray.get(0);
          //remove the card we just used from the stock
          deckArray.remove(0);
          rowIndex += 1;
        } else {
          throw new IllegalArgumentException("Not enough cards in the stock to create pyramid.");
        }
      }
      return thisRow;
    }

    for (int i = 1; i <= 5; i++) {
      //Place nulls
      if (i % 2 == 0) {
        for (int j = 0; j < conseqNulls; j++) {
          thisRow[rowIndex] = null;
          rowIndex += 1;
        }
      } else { //place Cards
        for (int j = 0; j < conseqCards; j++) {
          if (deckArray.size() > 0) {
            thisRow[rowIndex] = deckArray.get(0);
            //remove the card we just used from the stock
            deckArray.remove(0);
            rowIndex += 1;
          } else {
            throw new IllegalArgumentException("Not enough cards in the stock to create pyramid.");
          }
        }
      }
    }
    return thisRow;
  }

  /**
   @Override
   public int getRowWidth(int row) {
   if (!this.isGameStarted()) {
   throw new IllegalStateException("Game has not started, cannot get row width.");
   } else if (row < 0
   || row > this.getNumRows() - 1) {
   throw new IllegalArgumentException("This row is not valid. Must be > -1 and " +
   "< pyramid length");
   }
   //the total number of nulls in the 0 indexed row
   int numNulls;
   if (this.getNumRows() <= 3) {
   numNulls = 0;
   } else {
   numNulls = this.getNumRows() / 2 - 1;
   }

   //number of cards in the row for the tripeaks section of pyramid
   int numCardsInRow = 3 * (row + 1);

   //the number of consecutive nulls in a group of nulls where 2 groups of nulls are in a row
   int conseqNulls = numNulls - row;

   int numPyramidRowsTriPeaks = (this.getNumRows() - 1) / 2;

   //the row width
   int rowWidth;
   if (row < numPyramidRowsTriPeaks) {
   if (conseqNulls <= 0) {
   rowWidth = numCardsInRow;
   } else {
   rowWidth = numCardsInRow + 2 * conseqNulls;
   }
   }
   else {

   }
   return rowWidth;
   }

   private int findBottomRow(int numRows) {
   if (numRows == 0) {
   return 7;
   }
   return 1 + this.findBottomRow(numRows - 1);
   }
   */

  //number of cards in the row for the tripeaks section of pyramid
  private int numCardsInRow(int index) {
    return 3 * (index + 1);
  }
}