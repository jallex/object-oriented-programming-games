import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Type;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link PyramidSolitaireController} for all of its test cases.
 */
public class BasicPyramidSolitaireControllerTest {
  BasicPyramidSolitaire bps = new BasicPyramidSolitaire();
  List<ICard> deck1;
  List<ICard> deck2;
  List<ICard> deck3;
  Random rand = new Random();

  @Before
  public void setUp() throws Exception {
    this.deck1 = new ArrayList<ICard>();
    deck1.add(new Card(1, Type.HEARTS));
    deck1.add(new Card(1, Type.CLUBS));
    deck1.add(new Card(1, Type.DIAMONDS));
    deck1.add(new Card(1, Type.SPADES));
    deck1.add(new Card(2, Type.HEARTS));
    deck1.add(new Card(2, Type.CLUBS));
    deck1.add(new Card(10, Type.DIAMONDS));
    deck1.add(new Card(10, Type.SPADES));
    deck1.add(new Card(3, Type.HEARTS));
    deck1.add(new Card(13, Type.CLUBS));
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
    deck1.add(new Card(2, Type.DIAMONDS));
    deck1.add(new Card(2, Type.SPADES));
    deck1.add(new Card(11, Type.HEARTS));
    deck1.add(new Card(11, Type.CLUBS));
    deck1.add(new Card(11, Type.DIAMONDS));
    deck1.add(new Card(11, Type.SPADES));
    deck1.add(new Card(12, Type.HEARTS));
    deck1.add(new Card(12, Type.CLUBS));
    deck1.add(new Card(12, Type.DIAMONDS));
    deck1.add(new Card(12, Type.SPADES));
    deck1.add(new Card(13, Type.HEARTS));
    deck1.add(new Card(3, Type.CLUBS));
    deck1.add(new Card(13, Type.DIAMONDS));
    deck1.add(new Card(13, Type.SPADES));

    this.deck2 = new ArrayList<ICard>();
    deck2.add(new Card(3, Type.HEARTS));
    deck2.add(new Card(10, Type.CLUBS));
    deck2.add(new Card(1, Type.HEARTS));
    deck2.add(new Card(1, Type.CLUBS));
    deck2.add(new Card(1, Type.DIAMONDS));
    deck2.add(new Card(1, Type.SPADES));
    deck2.add(new Card(2, Type.HEARTS));
    deck2.add(new Card(2, Type.CLUBS));
    deck2.add(new Card(10, Type.DIAMONDS));
    deck2.add(new Card(10, Type.SPADES));
    deck2.add(new Card(13, Type.CLUBS));
    deck2.add(new Card(3, Type.DIAMONDS));
    deck2.add(new Card(3, Type.SPADES));
    deck2.add(new Card(4, Type.HEARTS));
    deck2.add(new Card(4, Type.CLUBS));
    deck2.add(new Card(4, Type.DIAMONDS));
    deck2.add(new Card(4, Type.SPADES));
    deck2.add(new Card(5, Type.HEARTS));
    deck2.add(new Card(5, Type.CLUBS));
    deck2.add(new Card(5, Type.DIAMONDS));
    deck2.add(new Card(5, Type.SPADES));
    deck2.add(new Card(6, Type.HEARTS));
    deck2.add(new Card(6, Type.CLUBS));
    deck2.add(new Card(6, Type.DIAMONDS));
    deck2.add(new Card(6, Type.SPADES));
    deck2.add(new Card(7, Type.HEARTS));
    deck2.add(new Card(7, Type.CLUBS));
    deck2.add(new Card(7, Type.DIAMONDS));
    deck2.add(new Card(7, Type.SPADES));
    deck2.add(new Card(8, Type.HEARTS));
    deck2.add(new Card(8, Type.CLUBS));
    deck2.add(new Card(8, Type.DIAMONDS));
    deck2.add(new Card(8, Type.SPADES));
    deck2.add(new Card(9, Type.HEARTS));
    deck2.add(new Card(9, Type.CLUBS));
    deck2.add(new Card(9, Type.DIAMONDS));
    deck2.add(new Card(9, Type.SPADES));
    deck2.add(new Card(10, Type.HEARTS));
    deck2.add(new Card(2, Type.DIAMONDS));
    deck2.add(new Card(2, Type.SPADES));
    deck2.add(new Card(11, Type.HEARTS));
    deck2.add(new Card(11, Type.CLUBS));
    deck2.add(new Card(11, Type.DIAMONDS));
    deck2.add(new Card(11, Type.SPADES));
    deck2.add(new Card(12, Type.HEARTS));
    deck2.add(new Card(12, Type.CLUBS));
    deck2.add(new Card(12, Type.DIAMONDS));
    deck2.add(new Card(12, Type.SPADES));
    deck2.add(new Card(13, Type.HEARTS));
    deck2.add(new Card(3, Type.CLUBS));
    deck2.add(new Card(13, Type.DIAMONDS));
    deck2.add(new Card(13, Type.SPADES));

    this.deck3 = new ArrayList<ICard>();
    deck3.add(new Card(10, Type.CLUBS));
    deck3.add(new Card(1, Type.CLUBS));
    deck3.add(new Card(3, Type.CLUBS));
    deck3.add(new Card(10, Type.HEARTS));
    deck3.add(new Card(12, Type.HEARTS));
    deck3.add(new Card(12, Type.CLUBS));
    deck3.add(new Card(12, Type.DIAMONDS));
    deck3.add(new Card(12, Type.SPADES));
    deck3.add(new Card(13, Type.HEARTS));
    deck3.add(new Card(13, Type.DIAMONDS));
    deck3.add(new Card(13, Type.CLUBS));
    deck3.add(new Card(13, Type.SPADES));
    deck3.add(new Card(3, Type.DIAMONDS));
    deck3.add(new Card(3, Type.SPADES));
    deck3.add(new Card(3, Type.HEARTS));
    deck3.add(new Card(1, Type.HEARTS));
    deck3.add(new Card(1, Type.DIAMONDS));
    deck3.add(new Card(1, Type.SPADES));
    deck3.add(new Card(2, Type.HEARTS));
    deck3.add(new Card(2, Type.CLUBS));
    deck3.add(new Card(10, Type.DIAMONDS));
    deck3.add(new Card(10, Type.SPADES));
    deck3.add(new Card(4, Type.HEARTS));
    deck3.add(new Card(4, Type.CLUBS));
    deck3.add(new Card(4, Type.DIAMONDS));
    deck3.add(new Card(4, Type.SPADES));
    deck3.add(new Card(5, Type.HEARTS));
    deck3.add(new Card(5, Type.CLUBS));
    deck3.add(new Card(5, Type.DIAMONDS));
    deck3.add(new Card(5, Type.SPADES));
    deck3.add(new Card(6, Type.HEARTS));
    deck3.add(new Card(6, Type.CLUBS));
    deck3.add(new Card(6, Type.DIAMONDS));
    deck3.add(new Card(6, Type.SPADES));
    deck3.add(new Card(7, Type.HEARTS));
    deck3.add(new Card(7, Type.CLUBS));
    deck3.add(new Card(7, Type.DIAMONDS));
    deck3.add(new Card(7, Type.SPADES));
    deck3.add(new Card(8, Type.HEARTS));
    deck3.add(new Card(8, Type.CLUBS));
    deck3.add(new Card(8, Type.DIAMONDS));
    deck3.add(new Card(8, Type.SPADES));
    deck3.add(new Card(9, Type.HEARTS));
    deck3.add(new Card(9, Type.CLUBS));
    deck3.add(new Card(9, Type.DIAMONDS));
    deck3.add(new Card(9, Type.SPADES));
    deck3.add(new Card(2, Type.DIAMONDS));
    deck3.add(new Card(2, Type.SPADES));
    deck3.add(new Card(11, Type.HEARTS));
    deck3.add(new Card(11, Type.CLUBS));
    deck3.add(new Card(11, Type.DIAMONDS));
    deck3.add(new Card(11, Type.SPADES));

  }


  private void testRun(PyramidSolitaireModel model, Interaction... interactions)
          throws IOException {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller = new
            PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, this.deck1, false, 4, 2);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  //User Won the game
  private void testRunWinGame(PyramidSolitaireModel model, Interaction... interactions)
          throws IOException {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller = new
            PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, this.deck2, false, 1, 1);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  //No more moves left in the game
  private void testRunLoseGame(PyramidSolitaireModel model, Interaction... interactions)
          throws IOException {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller = new
            PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, this.deck3, false, 2, 48);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testRemove() throws IOException {
    Interaction[] remove1Card = new Interaction[]{
      new InputInteraction("rm1 "),
      new InputInteraction("4 "),
      new InputInteraction("4 "),
      new PrintInteraction("      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 31"),
      new InputInteraction("rm2 "),
      new InputInteraction("4 "),
      new InputInteraction("2 "),
      new InputInteraction("4 "),
      new InputInteraction("3 "),
      new PrintInteraction("      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 18"),
      new InputInteraction("rmwd "),
      new InputInteraction("1 "),
      new InputInteraction("4 "),
      new InputInteraction("1 "),
      new PrintInteraction("      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "\n" +
              "Draw: 4♥, 3♠\n" +
              "Score: 8"),
      new InputInteraction("dd "),
      new InputInteraction("1 "),
      new PrintInteraction("      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "\n" +
              "Draw: 4♣, 3♠\n" +
              "Score: 8"),
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "\n" +
              "Draw: 4♣, 3♠\n" +
              "Score: 8")
    };

    testRun(this.bps, remove1Card);
  }

  @Test
  public void testRemoveException() throws IOException {
    Interaction[] discardDraw = new Interaction[]{
      new InputInteraction("dd"),
      new InputInteraction("4"),
      new PrintInteraction("Invalid move. Play again. Discard draw not valid."),
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44")
    };
    testRun(this.bps, discardDraw);
  }

  @Test
  //test if the game is won
  public void testGameWon() throws IOException {
    Interaction[] removeLast = new Interaction[]{
      new InputInteraction("rmwd"),
      new InputInteraction("1"),
      new InputInteraction("1"),
      new InputInteraction("1"),
      new PrintInteraction(false,"You win!")};
    testRunWinGame(this.bps, removeLast);
  }

  @Test
  //if there are no more moves left to be played
  public void testGameOver() throws IOException {
    Interaction[] removeLastPossible = new Interaction[]{
      new InputInteraction("rmwd"),
      new InputInteraction("1"),
      new InputInteraction("2"),
      new InputInteraction("2"),
      new InputInteraction("dd 1"),
      new InputInteraction("dd 2"),
      new InputInteraction("dd 3"),
      new InputInteraction("dd 4"),
      new InputInteraction("dd 5"),
      new InputInteraction("dd 6"),
      new InputInteraction("dd 7"),
      new InputInteraction("dd 8"),
      new InputInteraction("dd 9"),
      new InputInteraction("dd 10"),
      new InputInteraction("dd 11"),
      new InputInteraction("dd 12"),
      new InputInteraction("dd 13"),
      new InputInteraction("dd 14"),
      new InputInteraction("dd 15"),
      new InputInteraction("dd 16"),
      new InputInteraction("dd 17"),
      new InputInteraction("dd 18"),
      new InputInteraction("dd 19"),
      new InputInteraction("dd 20"),
      new InputInteraction("dd 21"),
      new InputInteraction("dd 22"),
      new InputInteraction("dd 23"),
      new InputInteraction("dd 24"),
      new InputInteraction("dd 25"),
      new InputInteraction("dd 26"),
      new InputInteraction("dd 27"),
      new InputInteraction("dd 28"),
      new InputInteraction("dd 29"),
      new InputInteraction("dd 30"),
      new InputInteraction("dd 31"),
      new InputInteraction("dd 32"),
      new InputInteraction("dd 33"),
      new InputInteraction("dd 34"),
      new InputInteraction("dd 35"),
      new InputInteraction("dd 36"),
      new InputInteraction("dd 37"),
      new InputInteraction("dd 38"),
      new InputInteraction("dd 39"),
      new InputInteraction("dd 40"),
      new InputInteraction("dd 41"),
      new InputInteraction("dd 42"),
      new InputInteraction("dd 43"),
      new InputInteraction("dd 44"),
      new InputInteraction("dd 45"),
      new InputInteraction("dd 46"),
      new InputInteraction("dd 47"),
      new InputInteraction("dd 48"),
      new InputInteraction("dd 49"),
      new InputInteraction("dd 50"),
      new PrintInteraction(false, "  10♣\n" +
              "A♣\n" +
              "Draw: J♠, Q♥, Q♣, Q♦, Q♠, K♥, K♦, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠, " +
              "2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, " +
              "7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null, Q♥, Q♣, Q♦, Q♠, K♥, K♦, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠, 2♥, 2♣, " +
              "10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, " +
              "8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null, Q♣, Q♦, Q♠, K♥, K♦, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠, 2♥, 2♣, " +
              "10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, " +
              "8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null, Q♦, Q♠, K♥, K♦, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠, 2♥, 2♣, " +
              "10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, " +
              "8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null, Q♠, K♥, K♦, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠, 2♥, 2♣, " +
              "10♦," +
              " 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, "
              + "8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null, K♥, K♦, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠, 2♥, " +
              "2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, " +
              "7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null, K♦, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠," +
              " 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, " +
              "7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null, K♣, K♠, 3♦, 3♠, 3♥, A♥, A♦, A♠, " +
              "2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, " +
              "7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null, K♠, 3♦, 3♠, 3♥, A♥, " +
              "A♦, A♠, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, " +
              "7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null, 3♦, 3♠, 3♥, A♥, A♦, " +
              "A♠, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, " +
              "7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null, 3♠, 3♥, A♥, A♦, " +
              "A♠, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, " +
              "7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null, 3♥, A♥, A♦, " +
              "A♠, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, " +
              "7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null, A♥, A♦," +
              " A♠, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, " +
              "7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null, A♦, " +
              "A♠, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, " +
              "7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null null, " +
              "A♠, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥," +
              " 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null " +
              "null null, 2♥, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, 6♦," +
              " 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null " +
              "null null null, 2♣, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣, " +
              "6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null " +
              "null null null null, 10♦, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, 6♣," +
              " 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null, 10♠, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, " +
              "5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, " +
              "2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null " +
              "null null null null null null, 4♥, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦, 5♠, 6♥, " +
              "6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null " +
              "null null null null null null null null, 4♣, 4♦, 4♠, 5♥, 5♣, 5♦," +
              " 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, " +
              "9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null" +
              " null null null null null null null null null, 4♦, 4♠, 5♥, 5♣, " +
              "5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣," +
              " 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null, 4♠, 5♥," +
              " 5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, " +
              "9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null, 5♥, " +
              "5♣, 5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, " +
              "9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null " +
              "null null null null null null null null null null null null, 5♣, " +
              "5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, " +
              "9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null " +
              "null null null null null null null null null null null null null, " +
              "5♦, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣," +
              " 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null" +
              " null null null null null null null null null null null null " +
              "null null, 5♠, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, " +
              "9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null " +
              "null null null null null null null null null null null null null " +
              "null, 6♥, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, " +
              "9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null " +
              "null null null null null, 6♣, 6♦, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥, " +
              "8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null " +
              "null null null null null null null null null null null " +
              "null null null null null null null null, 6♦, 6♠, 7♥, " +
              "7♣, 7♦, 7♠, 8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null" +
              " null null null null null null null, 6♠, 7♥, 7♣, 7♦, 7♠, 8♥," +
              " 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null" +
              " null null null null null null null null null null null null" +
              " null null null null null null null null, 7♥, 7♣, 7♦, 7♠, 8♥, " +
              "8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null null " +
              "null null null null null null null null, 7♣, 7♦, 7♠, 8♥, 8♣," +
              " 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null" +
              " null null null null null null null null null null null null " +
              "null null null null null null null null null, 7♦, 7♠, 8♥, 8♣, " +
              "8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null " +
              "null null null null null null null null null null null, 7♠, " +
              "8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null" +
              " null null null null null null null null null null null null" +
              " null null null null null null null null null null null null, " +
              "8♥, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null " +
              "null null null null null null null null null null null null " +
              "null null null null null null null null null null null null " +
              "null null, 8♣, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null " +
              "null null null null null null null null null null null null " +
              "null null null null null null null null null null null " +
              "null null null null, 8♦, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null" +
              " null null null null null null null null null null null null" +
              " null null null, 8♠, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null" +
              " null null null null null null null null null null null null" +
              " null null null null null null null null null null null null" +
              " null null null null, 9♥, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null" +
              " null null null null null null null null null null null null " +
              "null null null null null null null null null null null null null" +
              " null null null null, 9♣, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null, 9♦, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null null, 9♠, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null null, 2♦, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null " +
              "null null null null null null null, 2♠, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null " +
              "null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null" +
              " null null null null null null null null null, J♥, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null" +
              " null null null null null null null null, J♣, J♦\n" +
              "Score: 11\n" +
              "  10♣\n" +
              "A♣\n" +
              "Draw: null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null null" +
              " null null null null null null null null null null null null null null" +
              " null null null null null null, J♦\n" +
              "Score: 11\n" +
              "Game over. Score: 11")};

    testRunLoseGame(this.bps, removeLastPossible);
  }

  @Test
  public void testGameQuit() throws IOException {
    //if the user quits
    Interaction[] quitq = new Interaction[]{
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\n" +
        "State of game when quit:\n" +
        "      A♥\n" +
        "    A♣  A♦\n" +
        "  A♠  2♥  2♣\n" +
        "10♦ 10♠ 3♥  K♣\n" +
        "Draw: 3♦, 3♠\n" +
        "Score: 44"
      )};

    testRun(this.bps, quitq);
  }

  @Test
  public void testGameQuit2() throws IOException {
    //if user quits in the beginning of a move
    Interaction[] quitQ = new Interaction[]{
      new InputInteraction("Q"),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44"
      )};

    testRun(this.bps, quitQ);
  }

  @Test
  public void testGameQuit3() throws IOException {
    //if user quits in the beginning of a move
    Interaction[] quitQ = new Interaction[]{
      new InputInteraction("rm1 "),
      new InputInteraction("Q "),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44")};

    testRun(this.bps, quitQ);
  }


  @Test
  public void testGameQuit5() throws IOException {
    //if user quits in the middle parameter of a move
    Interaction[] quitQ = new Interaction[]{
      new InputInteraction("rm2 "),
      new InputInteraction("1"),
      new InputInteraction("4 "),
      new InputInteraction("Q "),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44")};

    testRun(this.bps, quitQ);
  }

  @Test
  public void testGameQuit4() throws IOException {
    //if user quits at the end of a move
    Interaction[] quitQ = new Interaction[]{
      new InputInteraction("rm2 "),
      new InputInteraction("1"),
      new InputInteraction("4 "),
      new InputInteraction("1 "),
      new InputInteraction("Q "),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44")};
    testRun(this.bps, quitQ);
  }


  @Test
  public void testInvalid1() throws IOException {
    //if user types input other than q, Q, or a number
    Interaction[] invalid1 = new Interaction[]{
      new InputInteraction("rm1"),
      new InputInteraction("j"),
      new PrintInteraction("Please re-enter a valid input."),
      new InputInteraction("s"),
      new PrintInteraction("Please re-enter a valid input."),
      new InputInteraction("4"),
      new InputInteraction("4"),
      new PrintInteraction("      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 31"),
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 31")
    };

    testRun(this.bps, invalid1);

    Interaction[] invalid2 = new Interaction[]{
      new InputInteraction("rm2"),
      new InputInteraction("4"),
      new InputInteraction("yenjend"),
      new PrintInteraction("Please re-enter a valid input."),
      new InputInteraction("2"),
      new InputInteraction("z"),
      new PrintInteraction("Please re-enter a valid input."),
      new InputInteraction("4"),
      new InputInteraction("3"),
      new PrintInteraction("      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦         K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 31"),
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦         K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 31")
    };

    testRun(this.bps, invalid2);
  }

  @Test
  public void testInvalidFromModel() throws IOException {
    //model indicates that a move is invalid
    Interaction[] invalidFromModel = new Interaction[]{
      new InputInteraction("rm1"),
      new InputInteraction("1"),
      new InputInteraction("4"),
      new InputInteraction("Q"),
      new PrintInteraction("Invalid move. Play again. Remove not valid.\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44")
    };
    testRun(this.bps, invalidFromModel);
  }

  @Test
  public void testInvalidFromModel2() throws IOException {
    //model indicates that a move is invalid
    Interaction[] invalidFromModel = new Interaction[]{
      new InputInteraction("rm1"),
      new InputInteraction("1"),
      new InputInteraction("10"),
      new PrintInteraction("Invalid move. Play again. Remove not valid."),
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\nState of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44")
    };
    testRun(this.bps, invalidFromModel);
  }

  @Test
  public void testInvalidMoveCall() throws IOException {
    //Move made is not a valid move
    Interaction[] invalidFromModel = new Interaction[]{
      new InputInteraction("j"),
      new PrintInteraction("Please re-enter a valid input."),
      new InputInteraction("lllllllll"),
      new PrintInteraction("Please re-enter a valid input."),
      new InputInteraction("rm1"),
      new InputInteraction("1"),
      new InputInteraction("10"),
      new PrintInteraction("Invalid move. Play again. Remove not valid."),
      new InputInteraction("q"),
      new PrintInteraction("Game quit!\nState of game when quit:\n" +
              "      A♥\n" +
              "    A♣  A♦\n" +
              "  A♠  2♥  2♣\n" +
              "10♦ 10♠ 3♥  K♣\n" +
              "Draw: 3♦, 3♠\n" +
              "Score: 44")
    };
    testRun(this.bps, invalidFromModel);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() throws IOException {
    //Should throw illegal argument exception if the model is null
    new PyramidSolitaireTextualController(new StringReader("input"),
            new StringBuilder()).playGame(null, this.deck1, false,
            2, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() throws IOException {
    //Should throw illegal argument exception if the Readable is null
    PyramidSolitaireTextualController control =
            new PyramidSolitaireTextualController(null,
                    new StringBuilder());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() throws IOException {
    //Should throw illegal argument exception if the Appendable is null
    PyramidSolitaireTextualController control =
            new PyramidSolitaireTextualController(new StringReader("input"),
                    null);
  }

  @Test(expected = IllegalStateException.class)
  public void testNullDeck() throws IOException {
    //Should throw illegal state exception if the deck is null
    new PyramidSolitaireTextualController(new StringReader("input"),
            new StringBuilder()).playGame(this.bps,
            null, true, 2, 1);
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableRunsOut() throws IOException {
    //If Appendable runs out in the middle of a move, should throw an illegal state exception
    Interaction[] readableRunsOut = new Interaction[]{
      new InputInteraction("rm2 "),
      new InputInteraction("4 "),
      new InputInteraction("4 "),
    };
    testRun(this.bps, readableRunsOut);
  }

  @Test(expected = IllegalStateException.class)
  public void testReadableRunsOutBeginning() throws IOException {
    //If Appendable runs out after a move without quit, should throw an illegal state exception
    Interaction[] readableRunsOut = new Interaction[]{
      new InputInteraction("rm1 "),
      new InputInteraction("4 "),
      new InputInteraction("4 "),
    };
    testRun(this.bps, readableRunsOut);
  }

  @Test
  public void testInputs() throws IOException {
    //test the MockModel
    Reader in = new StringReader("3 4");
    StringBuilder dontCareOutput = new StringBuilder();
    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(in, dontCareOutput);

    StringBuilder log = new StringBuilder();
    PyramidSolitaireModel model = new MockModel(log);

    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.getDeck();
    assertEquals("getDeck() called.", log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.startGame(this.deck1, false, 2, 2);
    assertEquals("startGame(List deck, boolean shouldShuffle, int numRows, int numDraw) " +
            "called.deck: A♥A♣A♦A♠2♥2♣10♦10♠3♥K♣3♦3♠4♥4♣4♦4♠5♥5♣5♦5♠6♥6♣6♦6♠7♥7♣7♦7♠8♥8♣8♦8♠9♥9" +
            "♣9♦9♠10♥10♣2♦2♠J♥J♣J♦J♠Q♥Q♣Q♦Q♠K♥3♣K♦K♠shouldShuffle: false, numRows: 2, " +
            "numDraw: 2", log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.remove(1, 1, 1, 1);
    assertEquals("The remove(int row1, int card1, int row2, int card2) " +
            "method was called.row1: 1, card1: 1, row2: 1, card2: 1", log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.remove(1, 2);
    assertEquals("The remove(int row, int card) method was called.row: 1, card: 2",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.removeUsingDraw(4, 5, 1);
    assertEquals("The removeUsingDraw(int drawIndex, int row, int card) method " +
                    "was called.drawIndex: 4, row: 5, card: 1",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.discardDraw(2);
    assertEquals("The discardDraw(int drawIndex) method was called.drawIndex: 2",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.getNumRows();
    assertEquals("The getNumRows() method was called.",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.getNumDraw();
    assertEquals("The getNumDraw() method was called.",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.getRowWidth(0);
    assertEquals("The getRowWidth(int row) method was called.row: 0",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.isGameOver();
    assertEquals("The isGameOver() method was called.",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.getScore();
    assertEquals("The getScore() method was called.",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.getCardAt(0, 1);
    assertEquals("The getCardAt(int row, int card) method was called.row: 0, card: 1",
            log.toString());

    log = new StringBuilder();
    model = new MockModel(log);
    controller.playGame(this.bps, this.deck1, true, 2, 1);
    model.getDrawCards();
    assertEquals("The getDrawCards() method was called.",
            log.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testInputsMocked() throws IOException {
    //test the MockAppendable
    //Scanner catches readable exceptions so there is no need to test a MockReadable.
    new PyramidSolitaireTextualController(new StringReader("rm1 1 1"), new MockAppendable())
            .playGame(this.bps, this.deck1, false, 2, 1);

  }
}