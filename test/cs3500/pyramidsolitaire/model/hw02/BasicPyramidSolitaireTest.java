package cs3500.pyramidsolitaire.model.hw02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link BasicPyramidSolitaire} for all of its test cases.
 */
public class BasicPyramidSolitaireTest {
  //Create parts of the game for testing
  List<ICard> deck1;
  List<ICard> deck1Removed;
  ICard[][] pyramid;
  ICard[] draw;

  ICard[][] pyramid2;
  ICard[] draw2;

  ICard[][] pyramid3;

  ICard[][] pyramid5;

  BasicPyramidSolitaire bps;
  BasicPyramidSolitaire bps2;
  BasicPyramidSolitaire bps3;
  BasicPyramidSolitaire bps4;
  BasicPyramidSolitaire bps5;
  BasicPyramidSolitaire bps6;
  BasicPyramidSolitaire bps7;

  PyramidSolitaireTextualView view;
  PyramidSolitaireTextualView view3;
  PyramidSolitaireTextualView view4;
  PyramidSolitaireTextualView view5;

  ICard[] cards;
  ArrayList<ICard> drawCards;
  ArrayList<ICard> cardsArray;

  Random rand;


  @Before
  public void setUp() throws Exception {
    //BPS 1
    this.bps = new BasicPyramidSolitaire();

    this.rand = new Random(10);

    //The deck
    this.deck1 = new ArrayList<ICard>();
    deck1.add(new Card(1, Type.HEARTS));
    deck1.add(new Card(1, Type.CLUBS));
    deck1.add(new Card(1, Type.DIAMONDS));
    deck1.add(new Card(1, Type.SPADES));
    deck1.add(new Card(2, Type.HEARTS));
    deck1.add(new Card(2, Type.CLUBS));
    deck1.add(new Card(2, Type.DIAMONDS));
    deck1.add(new Card(2, Type.SPADES));
    deck1.add(new Card(3, Type.HEARTS));
    deck1.add(new Card(3, Type.CLUBS));
    deck1.add(new Card(3, Type.DIAMONDS));
    deck1.add(new Card(3, Type.SPADES));
    deck1.add(new Card(4, Type.HEARTS));
    deck1.add(new Card(4, Type.CLUBS));
    deck1.add(new Card(4, Type.DIAMONDS));
    deck1.add(new Card(4, Type.SPADES));
    deck1.add(new Card(5, Type.HEARTS));
    deck1.add(new Card(5, Type.CLUBS));
    deck1.add(new Card(5, Type.DIAMONDS));
    deck1.add(new Card(5, Type.SPADES));
    deck1.add(new Card(6, Type.HEARTS));
    deck1.add(new Card(6, Type.CLUBS));
    deck1.add(new Card(6, Type.DIAMONDS));
    deck1.add(new Card(6, Type.SPADES));
    deck1.add(new Card(7, Type.HEARTS));
    deck1.add(new Card(7, Type.CLUBS));
    deck1.add(new Card(7, Type.DIAMONDS));
    deck1.add(new Card(7, Type.SPADES));
    deck1.add(new Card(8, Type.HEARTS));
    deck1.add(new Card(8, Type.CLUBS));
    deck1.add(new Card(8, Type.DIAMONDS));
    deck1.add(new Card(8, Type.SPADES));
    deck1.add(new Card(9, Type.HEARTS));
    deck1.add(new Card(9, Type.CLUBS));
    deck1.add(new Card(9, Type.DIAMONDS));
    deck1.add(new Card(9, Type.SPADES));
    deck1.add(new Card(10, Type.HEARTS));
    deck1.add(new Card(10, Type.CLUBS));
    deck1.add(new Card(10, Type.DIAMONDS));
    deck1.add(new Card(10, Type.SPADES));
    deck1.add(new Card(11, Type.HEARTS));
    deck1.add(new Card(11, Type.CLUBS));
    deck1.add(new Card(11, Type.DIAMONDS));
    deck1.add(new Card(11, Type.SPADES));
    deck1.add(new Card(12, Type.HEARTS));
    deck1.add(new Card(12, Type.CLUBS));
    deck1.add(new Card(12, Type.DIAMONDS));
    deck1.add(new Card(12, Type.SPADES));
    deck1.add(new Card(13, Type.HEARTS));
    deck1.add(new Card(13, Type.CLUBS));
    deck1.add(new Card(13, Type.DIAMONDS));
    deck1.add(new Card(13, Type.SPADES));

    //The stock pile
    this.deck1Removed = new ArrayList<ICard>();
    deck1Removed.add(new Card(4, Type.HEARTS));
    deck1Removed.add(new Card(4, Type.CLUBS));
    deck1Removed.add(new Card(4, Type.DIAMONDS));
    deck1Removed.add(new Card(4, Type.SPADES));
    deck1Removed.add(new Card(5, Type.HEARTS));
    deck1Removed.add(new Card(5, Type.CLUBS));
    deck1Removed.add(new Card(5, Type.DIAMONDS));
    deck1Removed.add(new Card(5, Type.SPADES));
    deck1Removed.add(new Card(6, Type.HEARTS));
    deck1Removed.add(new Card(6, Type.CLUBS));
    deck1Removed.add(new Card(6, Type.DIAMONDS));
    deck1Removed.add(new Card(6, Type.SPADES));
    deck1Removed.add(new Card(7, Type.HEARTS));
    deck1Removed.add(new Card(7, Type.CLUBS));
    deck1Removed.add(new Card(7, Type.DIAMONDS));
    deck1Removed.add(new Card(7, Type.SPADES));
    deck1Removed.add(new Card(8, Type.HEARTS));
    deck1Removed.add(new Card(8, Type.CLUBS));
    deck1Removed.add(new Card(8, Type.DIAMONDS));
    deck1Removed.add(new Card(8, Type.SPADES));
    deck1Removed.add(new Card(9, Type.HEARTS));
    deck1Removed.add(new Card(9, Type.CLUBS));
    deck1Removed.add(new Card(9, Type.DIAMONDS));
    deck1Removed.add(new Card(9, Type.SPADES));
    deck1Removed.add(new Card(10, Type.HEARTS));
    deck1Removed.add(new Card(10, Type.CLUBS));
    deck1Removed.add(new Card(10, Type.DIAMONDS));
    deck1Removed.add(new Card(10, Type.SPADES));
    deck1Removed.add(new Card(11, Type.HEARTS));
    deck1Removed.add(new Card(11, Type.CLUBS));
    deck1Removed.add(new Card(11, Type.DIAMONDS));
    deck1Removed.add(new Card(11, Type.SPADES));
    deck1Removed.add(new Card(12, Type.HEARTS));
    deck1Removed.add(new Card(12, Type.CLUBS));
    deck1Removed.add(new Card(12, Type.DIAMONDS));
    deck1Removed.add(new Card(12, Type.SPADES));
    deck1Removed.add(new Card(13, Type.HEARTS));
    deck1Removed.add(new Card(13, Type.CLUBS));
    deck1Removed.add(new Card(13, Type.DIAMONDS));
    deck1Removed.add(new Card(13, Type.SPADES));

    //Pyramid
    this.pyramid = new ICard[4][];
    ICard[] row0 = {new Card(1, Type.HEARTS)};
    this.pyramid[0] = row0;
    ICard[] row1 = {new Card(1, Type.CLUBS), new Card(1, Type.DIAMONDS)};
    this.pyramid[1] = row1;
    ICard[] row2 = {new Card(1, Type.SPADES), new Card(2, Type.HEARTS),
      new Card(2, Type.CLUBS)};
    this.pyramid[2] = row2;
    ICard[] row3 = {new Card(2, Type.DIAMONDS), new Card(2, Type.SPADES),
      new Card(3, Type.HEARTS), new Card(3, Type.CLUBS)};
    this.pyramid[3] = row3;

    //Another Pyramid
    this.pyramid3 = new ICard[3][];
    ICard[] row30 = {new Card(12, Type.HEARTS)};
    this.pyramid3[0] = row30;
    ICard[] row31 = {new Card(13, Type.CLUBS), new Card(1, Type.DIAMONDS)};
    this.pyramid3[1] = row31;
    ICard[] row32 = {new Card(8, Type.SPADES), new Card(5, Type.HEARTS),
      new Card(13, Type.CLUBS)};
    this.pyramid3[2] = row32;

    //Empty Pyramid
    this.pyramid5 = new ICard[3][];
    ICard[] row50 = {new EmptyCard()};
    this.pyramid5[0] = row50;
    ICard[] row51 = {new EmptyCard(), new EmptyCard()};
    this.pyramid5[1] = row51;
    ICard[] row52 = {new EmptyCard(), new EmptyCard(), new EmptyCard()};
    this.pyramid5[2] = row52;

    //Current draw pile
    this.draw = new ICard[2];
    this.draw[0] = (new Card(3, Type.DIAMONDS));
    this.draw[1] = (new Card(3, Type.SPADES));

    this.pyramid2 = new ICard[3][];
    ICard[] row20 = {new Card(12, Type.HEARTS)};
    this.pyramid2[0] = row20;
    ICard[] row21 = {new Card(13, Type.CLUBS), new Card(1, Type.DIAMONDS)};
    this.pyramid2[1] = row21;
    ICard[] row22 = {new Card(1, Type.SPADES), new Card(5, Type.HEARTS),
      new Card(8, Type.CLUBS)};
    this.pyramid2[2] = row22;

    this.draw2 = new ICard[1];
    this.draw2[0] = new Card(12, Type.CLUBS);

    this.bps2 = new BasicPyramidSolitaire(new ArrayList<ICard>(), this.pyramid2,
            this.draw2, true, this.rand);
    this.bps3 = new BasicPyramidSolitaire(new ArrayList<ICard>(), this.pyramid3,
            this.draw2, true, this.rand);
    this.bps6 = new BasicPyramidSolitaire(new ArrayList<ICard>(), this.pyramid,
            new ICard[0], true, this.rand);

    this.view = new PyramidSolitaireTextualView(this.bps2);
    this.view3 = new PyramidSolitaireTextualView(this.bps3);

    cards = new ICard[3];
    cards[0] = new Card(1, Type.CLUBS);
    cards[1] = new Card(2, Type.HEARTS);
    cards[2] = new Card(3, Type.SPADES);
    cardsArray = new ArrayList<ICard>();
    cardsArray.add(new Card(1, Type.CLUBS));
    cardsArray.add(new Card(2, Type.HEARTS));
    cardsArray.add(new Card(3, Type.SPADES));
    drawCards = new ArrayList<ICard>();
    drawCards.add(new Card(4, Type.CLUBS));
    drawCards.add(new Card(5, Type.HEARTS));
    drawCards.add(new Card(6, Type.SPADES));

    this.bps4 = new BasicPyramidSolitaire(drawCards, this.pyramid2,
            cards, true, this.rand);

    this.view4 = new PyramidSolitaireTextualView(this.bps4);

    this.bps5 = new BasicPyramidSolitaire(drawCards, this.pyramid5,
            cards, true, this.rand);
    this.bps7 = new BasicPyramidSolitaire(new ArrayList<ICard>(), this.pyramid2,
            this.draw2, false, this.rand);
    this.view5 = new PyramidSolitaireTextualView(this.bps);
  }

  @Test
  public void testGetDeck() {
    assertEquals(this.deck1, this.bps.getDeck());
    System.out.println(deck1.size());
  }

  @Test
  public void startGame() {
    assertEquals("", this.view5.toString());
    this.bps.startGame(this.deck1, false, 4, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("      A♥\n" +
            "    A♣  A♦\n" +
            "  A♠  2♥  2♣\n" +
            "2♦  2♠  3♥  3♣\n" +
            "Draw: 3♦, 3♠", this.view4.toString());
  }

  @Test
  public void startGameWithRandom() {
    assertEquals("", this.view5.toString());
    this.bps = new BasicPyramidSolitaire(this.rand);
    this.bps.startGame(this.deck1, true, 4, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("      8♦\n" +
            "    6♠  5♥\n" +
            "  2♦  6♣  5♠\n" +
            "7♦  3♣  Q♣  A♦\n" +
            "Draw: Q♠, 9♥", this.view4.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException2() {
    this.bps.startGame(this.deck1, false, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException27() {
    this.bps.startGame(this.deck1, false, 10, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException3() {
    this.bps.startGame(this.deck1, false, 4, 10000);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException4() {
    this.bps.startGame(this.deck1Removed, false, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException5() {
    this.bps.startGame(new ArrayList<ICard>(), false, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException6() {
    this.bps.startGame(this.deck1, false, -1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException7() {
    this.bps.startGame(this.deck1, false, 100, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException79() {
    this.bps.startGame(this.deck1, false, 100, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameException80() {
    this.bps.startGame(this.deck1, false, 2, -1);
  }

  @Test
  public void testRemove2Cards() {
    assertEquals("    Q♥\n"
            + "  K♣  A♦\n"
            + "A♠  5♥  8♣\n"
            + "Draw: Q♣", this.view.toString());
    this.bps2.remove(2, 1, 2, 2);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "A♠\n" +
            "Draw: Q♣", this.view.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  //tries to remove an emptyCard
  public void testRemove2CardsException0() {
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥  K♣\n" +
            "Draw: Q♣", this.view3.toString());
    this.bps3.remove(2, 2);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥\n" +
            "Draw: Q♣", this.view3.toString());
    this.bps3.remove(2, 0, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //throws IllegalArgumentException if the move is invalid
  public void testRemove2CardsException1() {
    this.bps.startGame(this.deck1, false, 4, 2);
    this.bps.remove(2, 1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //throws IllegalArgumentException if the move is invalid
  public void testRemove2CardsException12() {
    this.bps.startGame(this.deck1, false, 4, 2);
    this.bps.remove(-2, 1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //throws IllegalArgumentException if the move is invalid
  public void testRemove2CardsException13() {
    this.bps.startGame(this.deck1, false, 4, 2);
    this.bps.remove(2, 100, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //throws IllegalArgumentException if the move is invalid
  public void testRemove2CardsException14() {
    this.bps.startGame(this.deck1, false, 4, 2);
    this.bps.remove(2, 1, -5, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //throws IllegalArgumentException if the move is invalid
  public void testRemove2CardsException15() {
    this.bps.startGame(this.deck1, false, 4, 2);
    this.bps.remove(2, 1, -5, 200);
  }


  @Test(expected = IllegalStateException.class)
  //throws IllegalStateException if the game has not yet been started
  public void testRemove2CardsException2() {
    this.bps7.remove(2, 1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove 2 covered cards that add to 13
  public void testRemove2CardsException23() {
    this.bps2.remove(0, 0, 1, 1);
  }

  @Test
  public void testRemove1Card() {
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥  K♣\n" +
            "Draw: Q♣", this.view3.toString());
    this.bps3.remove(2, 2);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥\n" +
            "Draw: Q♣", this.view3.toString());
  }

  @Test(expected = IllegalStateException.class)
  //throws IllegalStateException if the game has not yet been started
  public void testRemove1CardException2() {
    this.bps7.remove(2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove a covered King card
  public void testRemove1CardException23() {
    this.bps3.remove(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove an EmptyCard
  public void testRemove1CardException27() {
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥  K♣\n" +
            "Draw: Q♣", this.view3.toString());
    this.bps3.remove(2, 2);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥\n" +
            "Draw: Q♣", this.view3.toString());
    this.bps3.remove(2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove1CardException24() {
    this.bps3.remove(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove1CardException25() {
    this.bps3.remove(1, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove1CardException26() {
    this.bps3.remove(0, -2);
  }

  @Test
  public void testRemoveUsingDraw() {
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "A♠  5♥  8♣\n" +
            "Draw: Q♣", this.view.toString());
    this.bps2.removeUsingDraw(0, 2, 0);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "    5♥  8♣\n" +
            "Draw:", this.view.toString());
  }

  @Test(expected = IllegalStateException.class)
  //throws IllegalStateException if the game has not yet been started
  public void testRemoveUsingDrawException2() {
    this.bps7.removeUsingDraw(0, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove a covered card
  public void testRemoveUsingDrawException3() {
    this.bps2.removeUsingDraw(0, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove an EmptyCard
  public void testRemoveUsingDrawException4() {
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥  K♣\n" +
            "Draw: Q♣", this.view3.toString());
    this.bps3.remove(2, 2);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "8♠  5♥\n" +
            "Draw: Q♣", this.view3.toString());
    this.bps3.removeUsingDraw(0, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove an index less than 0
  public void testRemoveUsingDrawException6() {
    this.bps2.removeUsingDraw(-1, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove an index greater than the sie of the draw pile
  public void testRemoveUsingDrawException7() {
    this.bps2.removeUsingDraw(10, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException8() {
    this.bps2.removeUsingDraw(0, -1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException9() {
    this.bps2.removeUsingDraw(0, 20, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException10() {
    this.bps2.removeUsingDraw(0, 20, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawException11() {
    this.bps2.removeUsingDraw(0, 20, 10);
  }

  @Test
  public void testDiscardDraw() {
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "A♠  5♥  8♣\n" +
            "Draw: Q♣", this.view.toString());
    this.bps2.discardDraw(0);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "A♠  5♥  8♣\n" +
            "Draw:", this.view.toString());
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "A♠  5♥  8♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view4.toString());
    this.bps4.discardDraw(0);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "A♠  5♥  8♣\n" +
            "Draw: 4♣, 2♥, 3♠", this.view4.toString());
    this.bps4.discardDraw(0);
    assertEquals("    Q♥\n" +
            "  K♣  A♦\n" +
            "A♠  5♥  8♣\n" +
            "Draw: 5♥, 2♥, 3♠", this.view4.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException1() {
    this.bps2.discardDraw(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawException2() {
    this.bps2.discardDraw(10);
  }

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawException3() {
    this.bps7.discardDraw(0);
  }

  @Test
  public void testGetNumRows() {
    //If the game has not started
    assertEquals(-1, this.bps.getNumRows());
    this.bps.startGame(this.deck1, false, 4, 2);
    assertEquals(4, this.bps.getNumRows());
    assertEquals(3, this.bps2.getNumRows());
    assertEquals(3, this.bps4.getNumRows());
  }

  @Test
  public void testGetNumDraw() {
    //before game has started
    assertEquals(-1, this.bps.getNumDraw());
    this.bps.startGame(this.deck1, false, 4, 2);
    assertEquals(2, this.bps.getNumDraw());
  }


  @Test
  public void testGetRowWidth() {
    this.bps.startGame(this.deck1, false, 4, 2);
    assertEquals(1, this.bps.getRowWidth(0));
    assertEquals(2, this.bps.getRowWidth(1));
    assertEquals(3, this.bps.getRowWidth(2));
    assertEquals(4, this.bps.getRowWidth(3));
  }

  @Test(expected = IllegalStateException.class)
  //tries to get row width before game has started.
  public void testGetRowWidthException1() {
    this.bps7.getRowWidth(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException2() {
    this.bps5.getRowWidth(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthException3() {
    this.bps5.getRowWidth(10);
  }

  @Test
  public void testIsGameOver() {
    //if the game is won
    assertEquals(true, this.bps5.isGameOver());
    //Game is not over
    assertEquals(false, this.bps2.isGameOver());
    //if there are no more moves left
    assertEquals(true, this.bps6.isGameOver());
  }

  @Test(expected = IllegalStateException.class)
  //tries to see if the game is over before game has started.
  public void testIsGameOverException2() {
    this.bps7.isGameOver();
  }

  @Test
  public void testGetScore() {
    assertEquals(40, this.bps2.getScore());
    assertEquals(52, this.bps3.getScore());
    assertEquals(40, this.bps4.getScore());
    assertEquals(0, this.bps5.getScore());
  }

  @Test(expected = IllegalStateException.class)
  //tries to get score before game has started.
  public void testGetScoreException2() {
    this.bps7.getScore();
  }

  @Test
  public void testGetCardAt() {
    assertEquals(new Card(12, Type.HEARTS), this.bps2.getCardAt(0, 0));
    assertEquals(new Card(1, Type.DIAMONDS), this.bps2.getCardAt(1, 1));
    assertEquals(new Card(1, Type.SPADES), this.bps2.getCardAt(2, 0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtException() {
    this.bps2.getCardAt(-1, 0);
    this.bps2.getCardAt(1, 3);
    this.bps2.getCardAt(3, 0);
    this.bps2.getCardAt(1, -1);
  }

  @Test(expected = IllegalStateException.class)
  //tries to get card before game has started.
  public void testGetCardAtException2() {
    this.bps7.getCardAt(0, 0);
  }

  @Test
  public void testGetDrawCards() {
    assertEquals(this.cardsArray, this.bps4.getDrawCards());
  }

  @Test(expected = IllegalStateException.class)
  //tries to get draw cards before game has started.
  public void testGetDrawCardException2() {
    this.bps7.getDrawCards();
  }

  @Test
  //tests restarting a Game when it is in progress
  public void testGetDrawCardException20() {
    assertEquals("", this.view5.toString());
    this.bps.startGame(this.deck1, false, 4, 2);
    assertEquals("    Q♥\n"
            + "  K♣  A♦\n"
            + "A♠  5♥  8♣\n"
            + "Draw: A♣, 2♥, 3♠", this.view4.toString());
    this.bps.startGame(this.deck1, false, 4, 2);
    assertEquals("    Q♥\n"
            + "  K♣  A♦\n"
            + "A♠  5♥  8♣\n"
            + "Draw: A♣, 2♥, 3♠", this.view4.toString());
  }
}