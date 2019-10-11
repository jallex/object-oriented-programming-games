import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Type;
import cs3500.pyramidsolitaire.model.hw04.Relaxed;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link PyramidSolitaireTextualView} for all of its test cases.
 */
public class BasicPyramidSolitaireViewTest {
  PyramidSolitaireModel bps;
  PyramidSolitaireModel bps2;
  Relaxed bps3;
  //Create parts of the game for testing
  List<ICard> deck1;
  ICard[][] pyramid;
  ArrayList<ICard> draw;

  PyramidSolitaireTextualView view;
  PyramidSolitaireTextualView view2;
  PyramidSolitaireTextualView view3;

  Random rand;

  @Before
  public void setUp() throws Exception {
    this.rand = new Random();
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

    this.pyramid = new ICard[4][];
    ICard[] row0 = {null};
    this.pyramid[0] = row0;
    ICard[] row1 = {new Card(10, Type.CLUBS), new Card(10, Type.DIAMONDS)};
    this.pyramid[1] = row1;
    ICard[] row2 = {new Card(10, Type.SPADES), null, null};
    this.pyramid[2] = row2;
    ICard[] row3 = {null, new Card(2, Type.SPADES), new Card(3, Type.HEARTS),
      null};
    this.pyramid[3] = row3;

    this.bps = new BasicPyramidSolitaire();
    this.bps2 = new BasicPyramidSolitaire();
    this.bps3 = new Relaxed();
    this.view = new PyramidSolitaireTextualView(this.bps);
    this.view2 = new PyramidSolitaireTextualView(this.bps2);
  }

  @Test
  public void testToString() {
    this.bps.startGame(this.deck1, false, 4, 2);
    this.view = new PyramidSolitaireTextualView(this.bps);
    assertEquals(
            "      A♥\n" +
                    "    A♣  A♦\n" +
                    "  A♠  2♥  2♣\n" +
                    "2♦  2♠  3♥  3♣\n" +
                    "Draw: 3♦, 3♠", this.view.toString());
    bps2 = new BasicPyramidSolitaire(new ArrayList<ICard>(),
            this.pyramid, new ICard[0], true, this.rand);
    this.view2 = new PyramidSolitaireTextualView(this.bps2);
    assertEquals(
            "\n" +
                    "    10♣ 10♦\n" +
                    "  10♠\n" +
                    "    2♠  3♥\n" +
                    "Draw:", this.view2.toString());
    this.bps3.startGame(this.deck1, false, 4, 2);
    this.view = new PyramidSolitaireTextualView(this.bps3);
    assertEquals(
            "      A♥\n" +
                    "    A♣  A♦\n" +
                    "  A♠  2♥  2♣\n" +
                    "2♦  2♠  3♥  3♣\n" +
                    "Draw: 3♦, 3♠", this.view.toString());
  }
}
