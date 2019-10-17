import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw04.TriPeaks;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.Type;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link cs3500.pyramidsolitaire.model.hw04.TriPeaks}
 * for all of its test cases.
 */
public class TriPeaksTest {
  //Create parts of the game for testing
  List<ICard> deck1;
  ICard[][] pyramid;
  ICard[] draw;

  ICard[][] pyramid2;
  ICard[] draw2;

  ICard[][] pyramid3;

  ICard[][] pyramid5;

  TriPeaks bps;
  TriPeaks bps2;
  TriPeaks bps3;
  TriPeaks bps4;
  TriPeaks bps5;
  TriPeaks bps6;
  TriPeaks bps7;

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
    this.bps = new TriPeaks();

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

    //Empty Pyramid
    this.pyramid5 = new ICard[3][];
    ICard[] row50 = {null};
    this.pyramid5[0] = row50;
    ICard[] row51 = {null, null};
    this.pyramid5[1] = row51;
    ICard[] row52 = {null, null, null};
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

    this.bps2 = new TriPeaks(new ArrayList<ICard>(), this.pyramid2,
        this.draw2, true, this.rand);
    this.bps3 = new TriPeaks(new ArrayList<ICard>(), this.pyramid3,
        this.draw2, true, this.rand);
    this.bps6 = new TriPeaks(new ArrayList<ICard>(), this.pyramid,
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

    this.bps4 = new TriPeaks(drawCards, this.pyramid2, cards, true, this.rand);

    this.view4 = new PyramidSolitaireTextualView(this.bps4);

    this.bps5 = new TriPeaks(drawCards, this.pyramid5, cards, true, this.rand);
    this.bps7 = new TriPeaks(new ArrayList<ICard>(), this.pyramid2,
        this.draw2, false, this.rand);
    this.view5 = new PyramidSolitaireTextualView(this.bps);
  }

  @Test
  public void startGame() {
    assertEquals("", this.view5.toString());
    this.bps.startGame(this.deck1, false, 7, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("            A♥          A♣          A♦\n" +
            "          A♠  2♥      2♣  2♦      2♠  3♥\n" +
            "        3♣  3♦  3♠  4♥  4♣  4♦  4♠  5♥  5♣\n" +
            "      5♦  5♠  6♥  6♣  6♦  6♠  7♥  7♣  7♦  7♠\n" +
            "    8♥  8♣  8♦  8♠  9♥  9♣  9♦  9♠  10♥ 10♣ 10♦\n" +
            "  10♠ J♥  J♣  J♦  J♠  Q♥  Q♣  Q♦  Q♠  K♥  K♣  K♦\n" +
            "K♠  A♥  A♣  A♦  A♠  2♥  2♣  2♦  2♠  3♥  3♣  3♦  3♠\n" +
            "Draw: 4♥, 4♣", this.view4.toString());
  }

  @Test
  public void startGameWith8Rows() {
    assertEquals("", this.view5.toString());
    this.bps.startGame(this.deck1, false, 8, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("              A♥              A♣              A♦\n" +
            "            A♠  2♥          2♣  2♦          2♠  3♥\n" +
            "          3♣  3♦  3♠      4♥  4♣  4♦      4♠  5♥  5♣\n" +
            "        5♦  5♠  6♥  6♣  6♦  6♠  7♥  7♣  7♦  7♠  8♥  8♣\n" +
            "      8♦  8♠  9♥  9♣  9♦  9♠  10♥ 10♣ 10♦ 10♠ J♥  J♣  J♦\n" +
            "    J♠  Q♥  Q♣  Q♦  Q♠  K♥  K♣  K♦  K♠  A♥  A♣  A♦  A♠  2♥\n" +
            "  2♣  2♦  2♠  3♥  3♣  3♦  3♠  4♥  4♣  4♦  4♠  5♥  5♣  5♦  5♠\n" +
            "6♥  6♣  6♦  6♠  7♥  7♣  7♦  7♠  8♥  8♣  8♦  8♠  9♥  9♣  9♦  9♠\n" +
            "Draw: 10♥, 10♣", this.view4.toString());
  }

  @Test
  public void startGameWith1Row() {
    assertEquals("", this.view5.toString());
    this.bps.startGame(this.deck1, false, 1, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("A♥\n" +
            "Draw: A♣, A♦", this.view4.toString());
  }

  @Test
  public void startGameWith2Rows() {
    assertEquals("", this.view5.toString());
    this.bps.startGame(this.deck1, false, 2, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("  A♥  A♣  A♦\n" +
            "A♠  2♥  2♣  2♦\n" +
            "Draw: 2♠, 3♥", this.view4.toString());
  }

  @Test
  public void startGameWith3Rows() {
    assertEquals("", this.view5.toString());
    this.bps.startGame(this.deck1, false, 3, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("    A♥  A♣  A♦\n" +
            "  A♠  2♥  2♣  2♦\n" +
            "2♠  3♥  3♣  3♦  3♠\n" +
            "Draw: 4♥, 4♣", this.view4.toString());
  }

  @Test
  public void startGameWithRandom() {
    assertEquals("", this.view5.toString());
    this.bps = new TriPeaks(this.rand);
    this.bps.startGame(this.deck1, true, 4, 2);
    this.view4 = new PyramidSolitaireTextualView(this.bps);
    assertEquals("      3♠      10♣     J♥\n" +
            "    4♥  5♥  9♥  8♦  A♥  9♦\n" +
            "  10♥ 5♠  4♠  Q♠  8♣  K♣  5♦\n" +
            "9♠  2♠  9♣  Q♥  A♦  6♦  5♦  6♣\n" +
            "Draw: 5♠, Q♣", this.view4.toString());
  }
}