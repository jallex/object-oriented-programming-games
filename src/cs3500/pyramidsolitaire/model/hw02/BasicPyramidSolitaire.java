package cs3500.pyramidsolitaire.model.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * Represents a Basic Pyramid Solitaire.
 */
public class BasicPyramidSolitaire implements PyramidSolitaireModel<ICard> {
  //cards currently in the stock
  private ArrayList<ICard> stock;
  //The pyramid layout containing ICards that are currently in the pyramid
  private ICard[][] pyramid;
  //Cards drawn that are currently visible from the stock pile
  private ICard[] currentDraw;
  //is the game started?
  private boolean gameStarted;
  //holds the random object
  private Random rand;

  /**
   * Constructs a {@code BasicPyramidSolitaire} object.
   */
  public BasicPyramidSolitaire() {
    this.gameStarted = false;
    this.rand = new Random();
  }

  /**
   * Constructs a {@code BasicPyramidSolitaire} object that takes in a Random for testing shuffle.
   */
  public BasicPyramidSolitaire(Random rand) {
    this.gameStarted = false;
    this.rand = rand;
  }

  /**
   * Constructs a {@code BasicPyramidSolitaire} object.
   *
   * @param stock       the stock of Cards
   * @param pyramid     the pyramid of ICards
   * @param currentDraw the current ICards available for draw
   * @param gameStarted is the game started yet?
   */
  public BasicPyramidSolitaire(ArrayList<ICard> stock, ICard[][] pyramid,
                               ICard[] currentDraw, boolean gameStarted, Random rand) {
    this.stock = stock;
    this.pyramid = pyramid;
    this.currentDraw = currentDraw;
    this.gameStarted = gameStarted;
    this.rand = rand;
  }

  @Override
  public List<ICard> getDeck() {
    ArrayList<ICard> deck1 = new ArrayList<ICard>();
    for (int i = 1; i <= 13; i++) {
      deck1.add(new Card(i, Type.HEARTS));
      deck1.add(new Card(i, Type.CLUBS));
      deck1.add(new Card(i, Type.DIAMONDS));
      deck1.add(new Card(i, Type.SPADES));
    }
    return deck1;
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2) throws IllegalStateException {
    if (!this.gameStarted) {
      throw new IllegalStateException("Cannot make a move, the game has not started.");
    }
    testInValidRow(row1);
    testInValidCard(row1, card1);
    testInValidRow(row2);
    testInValidCard(row2, card2);
    ICard cardFirst = this.getCardAt(row1, card1);
    ICard cardSecond = this.getCardAt(row2, card2);
    if (cardFirst == null
            || cardSecond == null
            || !(cardFirst.score() + cardSecond.score() == 13)
            || !(this.isUncovered(row1, card1))
            || !(this.isUncovered(row2, card2))) {
      throw new IllegalArgumentException("This move is not legal- cards must be uncovered and " +
              "add to 13.");
    } else {
      pyramid[row1][card1] = null;
      pyramid[row2][card2] = null;
    }
  }

  @Override
  public void remove(int row, int card) throws IllegalStateException {
    if (!this.gameStarted) {
      throw new IllegalStateException("Cannot make a move, the game has not started.");
    }
    testInValidRow(row);
    testInValidCard(row, card);
    ICard card1 = this.getCardAt(row, card);
    if (card1 != null && card1.isKing()
            && this.isUncovered(row, card)) {
      pyramid[row][card] = null;
    } else {
      throw new IllegalArgumentException("This move is not legal- cards must be uncovered and "
              + "add to 13.");
    }
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card) throws IllegalStateException {
    if (!this.gameStarted) {
      throw new IllegalStateException("Cannot make a move, the game has not started.");
    }
    if (drawIndex < 0
            || drawIndex > this.currentDraw.length - 1) {
      throw new IllegalArgumentException("The index of the draw must be >= 0 and <= "
              + "the size of the currentDraw.");
    }
    if (this.currentDraw[drawIndex] == null) {
      throw new IllegalArgumentException("Cannot remove using an empty card.");
    }
    testInValidRow(row);
    testInValidCard(row, card);
    ICard cardFirst = this.getCardAt(row, card);
    ICard cardSecond = this.currentDraw[drawIndex];
    if (cardFirst == null
            || cardSecond == null
            || !(cardFirst.score() + (cardSecond.score()) == 13)
            || !(this.isUncovered(row, card))) {
      throw new IllegalArgumentException("This move is not legal- cards must be uncovered and "
              + "add to 13.");
    } else {
      pyramid[row][card] = null;
      this.discardDraw(drawIndex);
    }
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalStateException {
    if (!this.gameStarted) {
      throw new IllegalStateException("Game has not yet started. Cannot discard draw.");
    } else if (drawIndex < 0
            || drawIndex > this.currentDraw.length) {
      throw new IllegalArgumentException("This move is invalid.");
    } else if (this.currentDraw[drawIndex] == null) {
      throw new IllegalArgumentException("Cannot discard Empty Card.");
    } else if (this.stock.size() > 0) {
      currentDraw[drawIndex] = this.stock.get(0);
      this.stock.remove(0);
    } else {
      this.currentDraw[drawIndex] = null;
    }
  }

  @Override
  public int getNumRows() {
    if (!this.gameStarted) {
      return -1;
    }
    return this.pyramid.length;
  }

  @Override
  public int getNumDraw() {
    if (!gameStarted) {
      return -1;
    } else {
      return this.currentDraw.length;
    }
  }

  @Override
  public int getRowWidth(int row) {
    if (!this.gameStarted) {
      throw new IllegalStateException("Game has not started, cannot get row width.");
    } else if (row < 0
            || row > this.pyramid.length - 1) {
      throw new IllegalArgumentException("This row is not valid. Must be > -1 and " +
              "< pyramid length");
    }
    return this.pyramid[row].length;
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    //stock pile empty
    //no visible cards add to 13 or in combination with draw set
    if (!this.gameStarted) {
      throw new IllegalStateException("Game has not been started.");
    }
    return this.isGameWon()
            ||
            (this.stock.size() == 0
                    && !this.isMore13Pair());
  }

  @Override
  public int getScore() throws IllegalStateException {
    int score = 0;
    for (int i = 0; i < this.pyramid.length; i++) {
      for (int j = 0; j < this.pyramid[i].length; j++) {
        if(this.getCardAt(i, j) != null) {
          score += this.getCardAt(i, j).score();
        }
      }
    }
    return score;
  }

  @Override
  public ICard getCardAt(int row, int card) throws IllegalStateException {
    if (!this.gameStarted) {
      throw new IllegalStateException("Cannot get card, game has not started.");
    }
    if (row > pyramid.length - 1
            || row < 0
            || card > pyramid[row].length - 1
            || card < 0) {
      throw new IllegalArgumentException("Card position is not valid.");
    } else if (pyramid[row][card] == null) {
      return null;
    }
    else {
      return pyramid[row][card];
    }
  }

  @Override
  public List<ICard> getDrawCards() throws IllegalStateException {
    ArrayList<ICard> arr = new ArrayList<ICard>();
    if (!gameStarted) {
      throw new IllegalStateException("The game has not started, cannot get draw cards.");
    } else {
      for (int i = 0; i < this.currentDraw.length; i++) {
        arr.add(this.currentDraw[i]);
      }
      return arr;
    }
  }

  /**
   * Gets the number of cards the pyramid uses.
   *
   * @param rows the number of rows
   * @return the number of cards that the Pyramid should be.
   */
  private int getPyramidSize(int rows) {
    if (rows == 0) {
      return 0;
    }
    return rows + this.getPyramidSize(rows - 1);
  }

  @Override
  public void startGame(List<ICard> deck, boolean shouldShuffle, int numRows, int numDraw) {
    if (deck == null) {
      throw new IllegalArgumentException("deck cannot be null.");
    }
    if (numDraw < 0) {
      throw new IllegalArgumentException("The number of draw cards must be >= 1");
    }
    if (numRows < 1) {
      throw new IllegalArgumentException("The number of rows must be >= 2");
    }
    if (numDraw > 52 - this.getPyramidSize(numRows)) {
      throw new IllegalArgumentException("Number of draw cards cannot be greater than the stock.");
    }

    //put ICards into an ArrayList in the same order
    ArrayList<ICard> deckArray = new ArrayList<ICard>(deck);

    //checks if deck is valid: model must have 52 cards, no duplicate cards, no EmptyCards
    if (!(hasNoRepeatsOrEmpty(deckArray)
            && deckArray.size() == 52)) {
      throw new IllegalArgumentException("This is not a valid deck.");
    }

    //shuffles the deck if needed
    if (shouldShuffle) {
      Collections.shuffle(deckArray, this.rand);
    }

    //create the stock pile
    this.stock = deckArray;

    //Use stock pile to set up the pyramid
    this.pyramid = this.initializePyramid(numRows);


    //create the current Draw
    ICard[] draw = new ICard[numDraw];
    for (int i = 0; i < numDraw; i++) {
      if (this.stock.size() > 0) {
        draw[i] = (this.stock.get(0));
        this.stock.remove(0);
      }
    }
    this.currentDraw = draw;

    this.gameStarted = true;
  }

  /**
   * Creates the pyramid structure of this BasicPyramidStructure's deck based on the given number of
   * rows.
   *
   * @param rows the number of rows in the pyramid.
   * @return the initial Pyramid containing ICards for the game
   */
  private ICard[][] initializePyramid(int rows) {
    ICard[][] pyrLayout = new ICard[rows][];
    //the number of cards we are putting in current row
    int numCardsPerRow = 1;
    //the index of the card in the stock we are placing into the pyramid
    for (int i = 0; i < rows; i++) {
      pyrLayout[i] = this.createRow(numCardsPerRow);
      numCardsPerRow += 1;
    }
    return pyrLayout;
  }

  /**
   * Creates a single row as an Array of ICard in the pyramid.
   *
   * @param numCardsPerRow the number of Cards in this row
   * @return An Array of Cards
   * @throws IllegalArgumentException if not enough cards in the stock to create a pyramid
   */
  private ICard[] createRow(int numCardsPerRow) {
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

  /**
   * Returns if the card at the given row and card position is uncovered.
   *
   * @param row  the row of the ICard
   * @param card the number card in the row
   * @return whether the card at this location is Uncovered.
   */
  private boolean isUncovered(int row, int card) {
    if (row == pyramid.length - 1) {
      return true;
    }
    if (this.getCardAt(row, card) == null) {
      return true;
    }
    return pyramid[row + 1][card] == null
            && pyramid[row + 1][card + 1] == null;
  }

  /**
   * Returns if this deck has no repeated cards in it and has no EmptyCards.
   *
   * @param deckArray the ArrayList that is being checked for validity
   * @return if this ArrayList contains no repeats and no empty cards
   */
  private boolean hasNoRepeatsOrEmpty(ArrayList<ICard> deckArray) {
    for (int i = 0; i < deckArray.size(); i++) {
      for (int j = 0; j < deckArray.size(); j++) {
        if (i != j
                && deckArray.get(i).equals(deckArray.get(j))
                && deckArray.get(i) != null) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns if the game is won, meaning that there are no more Cards on the pyramid.
   *
   * @return if the game has been won.
   */
  private boolean isGameWon() {
    return this.getScore() == 0;
  }

  /**
   * Returns if there are still moves left.
   *
   * @return if there are still moves left to be made in the game.
   */
  private boolean isMore13Pair() {
    ArrayList<ICard> exposed = this.findExposedCards();
    return this.exposedAddTo13(exposed)
            || this.drawAndExposedAddTo13(exposed);
  }

  /**
   * Returns the ArrayList of cards that are uncovered.
   *
   * @return an ArrayList of the uncovered Cards on the pyramid
   */
  private ArrayList<ICard> findExposedCards() {
    ArrayList<ICard> exposed = new ArrayList<ICard>();
    for (int i = 0; i < this.pyramid.length; i++) {
      for (int j = 0; j < this.pyramid[i].length; j++) {
        if (this.isUncovered(i, j) && this.getCardAt(i, j) != null) {
          exposed.add(this.getCardAt(i, j));
        }
      }
    }
    return exposed;
  }

  /**
   * Returns if there are 2 exposed Cards on the pyramid that add to 13.
   *
   * @param exposed the exposed Cards on the pyramid
   * @return if there are 2 exposed Cards on the pyramid that add to 13.
   */
  private boolean exposedAddTo13(ArrayList<ICard> exposed) {
    for (int i = 0; i < exposed.size(); i++) {
      for (int j = 0; j < exposed.size(); j++) {
        if (i != j
                && exposed.get(i).score() + exposed.get(j).score() == 13
        || exposed.get(i).isKing()) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Returns if the player is able to make a move using a Card from the draw pile and an exposed
   * Card on the Pyramid, or if a Card in exposed or the Draw is a King.
   *
   * @param exposed the Cards on the Pyramid that are exposed/revealed
   * @return if the player can make a move using a Card from the draw pile and an exposed card.
   */
  private boolean drawAndExposedAddTo13(ArrayList<ICard> exposed) {
    for (int i = 0; i < exposed.size(); i++) {
      for (int j = 0; j < this.currentDraw.length; j++) {
        if (this.currentDraw[j] != null) {
          if (this.currentDraw[j].score() + exposed.get(i).score() == 13
                  || this.currentDraw[j].isKing()
                  || exposed.get(i).isKing()) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Throws an illegal argument exception if this is not a valid row.
   *
   * @param num the number row that the user input
   * @throws IllegalArgumentException if this is not a valid row number
   */
  private void testInValidRow(int num) {
    if (num > this.pyramid.length - 1
            || num < 0) {
      throw new IllegalArgumentException("This is not a valid row number.");
    }
  }

  /**
   * Throws an illegal argument exception if this is not a valid card.
   *
   * @param row the number row that the user input
   * @param num the number card that the user input
   * @throws IllegalArgumentException if this is not a valid card number
   */
  private void testInValidCard(int row, int num) {
    if (num > this.getRowWidth(row) - 1
            || num < 0) {
      throw new IllegalArgumentException("This is not a valid card number.");
    }
  }
}