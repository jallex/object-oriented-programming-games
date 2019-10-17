import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.Type;
import cs3500.pyramidsolitaire.model.hw04.Relaxed;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link cs3500.pyramidsolitaire.model.hw04.Relaxed}
 * for all of its test cases.
 */
public class RelaxedTest {
  //Create parts of the game for testing
  List<ICard> deck1;
  ICard[][] pyramid;
  ICard[] draw;

  ICard[][] pyramid2;
  ICard[][] pyramid6;
  ICard[] draw2;

  ICard[][] pyramid3;
  ICard[][] pyramid4;
  ICard[][] pyramid4v2;
  ICard[][] pyramid5;
  ICard[][] pyramid7;

  Relaxed bps;
  Relaxed bps2;
  Relaxed bps3;
  Relaxed bps4;
  Relaxed bps4v2;
  Relaxed bps5;
  Relaxed bps6;
  Relaxed bps7;
  Relaxed bps8;

  PyramidSolitaireTextualView view;
  PyramidSolitaireTextualView view3;
  PyramidSolitaireTextualView view4;
  PyramidSolitaireTextualView view4v2;
  PyramidSolitaireTextualView view5;
  PyramidSolitaireTextualView view6;
  PyramidSolitaireTextualView view7;

  ICard[] cards;
  ArrayList<ICard> drawCards;
  ArrayList<ICard> cardsArray;

  Random rand;


  @Before
  public void setUp() throws Exception {
    //BPS 1
    this.bps = new Relaxed();

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

    this.pyramid5 = new ICard[3][];
    ICard[] row50 = {new Card(12, Type.HEARTS)};
    this.pyramid5[0] = row50;
    ICard[] row51 = {new Card(5, Type.CLUBS), new Card(10, Type.DIAMONDS)};
    this.pyramid5[1] = row51;
    ICard[] row52 = {new Card(1, Type.SPADES), null,
        new Card(8, Type.CLUBS)};
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

    this.pyramid6 = new ICard[3][];
    ICard[] row60 = {new Card(12, Type.HEARTS)};
    this.pyramid6[0] = row60;
    ICard[] row61 = {new Card(8, Type.CLUBS), new Card(5, Type.DIAMONDS)};
    this.pyramid6[1] = row61;
    ICard[] row62 = {new Card(1, Type.SPADES), null,
        new Card(12, Type.CLUBS)};
    this.pyramid6[2] = row62;

    this.draw2 = new ICard[1];
    this.draw2[0] = new Card(12, Type.CLUBS);

    this.bps2 = new Relaxed(new ArrayList<ICard>(), this.pyramid2,
            this.draw2, true, this.rand);
    this.bps3 = new Relaxed(new ArrayList<ICard>(), this.pyramid3,
            this.draw2, true, this.rand);
    this.bps6 = new Relaxed(new ArrayList<ICard>(), this.pyramid6,
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

    this.pyramid4 = new ICard[3][];
    ICard[] row40 = {new Card(12, Type.HEARTS)};
    this.pyramid4[0] = row40;
    ICard[] row41 = {new Card(10, Type.CLUBS), new Card(5, Type.DIAMONDS)};
    this.pyramid4[1] = row41;
    ICard[] row42 = {new Card(1, Type.SPADES), null,
        new Card(8, Type.CLUBS)};
    this.pyramid4[2] = row42;

    this.pyramid4v2 = new ICard[3][];
    ICard[] row402 = {new Card(12, Type.HEARTS)};
    this.pyramid4v2[0] = row402;
    ICard[] row412 = {new Card(5, Type.CLUBS), new Card(10, Type.DIAMONDS)};
    this.pyramid4v2[1] = row412;
    ICard[] row422 = {new Card(8, Type.SPADES), null, new Card(1, Type.CLUBS)};
    this.pyramid4v2[2] = row422;

    this.pyramid7 = new ICard[3][];
    ICard[] row70 = {new Card(12, Type.HEARTS)};
    this.pyramid7[0] = row70;
    ICard[] row71 = {new Card(10, Type.CLUBS), new Card(5, Type.DIAMONDS)};
    this.pyramid7[1] = row71;
    ICard[] row72 = {new Card(3, Type.SPADES), new Card(1, Type.HEARTS),
        new Card(8, Type.CLUBS)};
    this.pyramid7[2] = row72;

    this.bps4 = new Relaxed(drawCards, this.pyramid4,
            cards, true, this.rand);
    this.bps4v2 = new Relaxed(drawCards, this.pyramid4v2,
            cards, true, this.rand);

    this.view4 = new PyramidSolitaireTextualView(this.bps4);
    this.view4v2 = new PyramidSolitaireTextualView(this.bps4v2);

    this.bps5 = new Relaxed(drawCards, this.pyramid5,
            cards, true, this.rand);
    this.view5 = new PyramidSolitaireTextualView(this.bps5);
    this.view6 = new PyramidSolitaireTextualView(this.bps6);
    this.bps7 = new Relaxed(new ArrayList<ICard>(), this.pyramid4,
            new ICard[2], true, this.rand);
    this.bps8 = new Relaxed(new ArrayList<ICard>(), this.pyramid7,
            new ICard[2], true, this.rand);
  }

  @Test
  public void testRemove2CardsRelaxedVersionRight() {
    //removes 2 cards where 1 card is fully uncovered and the other is partially covered
    //by the first card, removing from the bottom right of the card
    assertEquals("    Q♥\n" +
            "  10♣ 5♦\n" +
            "A♠      8♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view4.toString());
    this.bps4.remove(1, 1, 2, 2);
    assertEquals("    Q♥\n" +
            "  10♣\n" +
            "A♠\n" +
            "Draw: A♣, 2♥, 3♠", this.view4.toString());
  }

  @Test
  public void testRemove2CardsRelaxedVersion2Right() {
    //removes 2 cards with the same conditions as the previous test but flips
    //if they are the 1st ICard in the method or the second. Removing from bottom right of the card
    assertEquals("    Q♥\n" +
            "  10♣ 5♦\n" +
            "A♠      8♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view4.toString());
    this.bps4.remove(2, 2, 1, 1);
    assertEquals("    Q♥\n" +
            "  10♣\n" +
            "A♠\n" +
            "Draw: A♣, 2♥, 3♠", this.view4.toString());
  }

  @Test
  public void testRemove2CardsRelaxedVersionLeft() {
    //removes 2 cards where 1 card is fully uncovered and the other is partially covered
    //by the first card. removing from bottom left of the card.
    assertEquals("    Q♥\n" +
            "  5♣  10♦\n" +
            "8♠      A♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view4v2.toString());
    this.bps4v2.remove(2, 0, 1, 0);
    assertEquals("    Q♥\n" +
            "      10♦\n" +
            "        A♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view4v2.toString());
  }

  @Test
  public void testRemove2CardsRelaxedVersion2Left() {
    //removes 2 cards with the same conditions as the previous test but flips
    //if they are the 1st ICard in the method or the second. removing from bottom left of card.
    assertEquals("    Q♥\n" +
            "  5♣  10♦\n" +
            "8♠      A♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view4v2.toString());
    this.bps4v2.remove(1, 0, 2, 0);
    assertEquals("    Q♥\n" +
            "      10♦\n" +
            "        A♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view4v2.toString());
  }

  @Test
  public void testGameIsNotOverYet() {
    //tests the case where the game would have been over in BasicPyramidSolitaire,
    //but is not over in the Relaxed version because there are still moves left.
    assertEquals(false, this.bps7.isGameOver());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove2CardsRelaxedFailed() {
    //tries to remove 2 cards where one is fully uncovered but not covering the other
    assertEquals("    Q♥\n" +
            "  5♣  10♦\n" +
            "A♠      8♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view5.toString());
    this.bps5.remove(2, 2, 0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove2CardsRelaxedFailed2() {
    //tries to remove 2 cards where one is fully uncovered but not covering the other
    //but flips if they are ICard 1 or 2 in the method.
    assertEquals("    Q♥\n" +
            "  5♣  10♦\n" +
            "A♠      8♣\n" +
            "Draw: A♣, 2♥, 3♠", this.view5.toString());
    this.bps5.remove(0, 1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove2CardsRelaxedFailed3() {
    //tries to remove two cards where both are partially uncovered
    assertEquals("    Q♥\n" +
            "  8♣  5♦\n" +
            "A♠      Q♣\n" +
            "Draw:", this.view6.toString());
    this.bps6.remove(1, 0, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove2CardsRelaxedFailed4() {
    //tries to remove two cards where they do not add to 13
    assertEquals("    Q♥\n" +
            "  8♣  5♦\n" +
            "A♠      Q♣\n" +
            "Draw:", this.view6.toString());
    this.bps6.remove(2, 0, 1, 0);
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
  //tries to remove an null
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
    this.bps.remove(2, 1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove 2 covered cards that add to 13
  public void testRemove2CardsException23() {
    this.bps2.remove(0, 0, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  //Tries to remove a Card that is fully covered but fits other requirements in Relaxed game.
  public void testRemove2CardsException24() {
    this.bps8.remove(3, 1, 2, 1);
  }
}