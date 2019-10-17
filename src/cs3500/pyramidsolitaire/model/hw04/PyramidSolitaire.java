package cs3500.pyramidsolitaire.model.hw04;

import java.io.InputStreamReader;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;

/**
 * The main class to run a game of Pyramid Solitaire.
 */
public final class PyramidSolitaire {
  /**
   * The method of entry to start a game of Pyramid Solitaire.
   * The Array of Strings as arguments will start with either "basic",
   * "relaxed", or "tripeaks" and then may also include 2 optional number parameters R D,
   * that represent the number of rows in the pyramid and the number of draw cards.
   * @param args The array String of arguments
   */
  public static void main(String[] args) {
    PyramidSolitaireModel model;
    int numRows = 7;
    int numDraw = 3;
    
    if (args[0].equals("basic")) {
      model = PyramidSolitaireCreator.create(GameType.BASIC);
    }
    else if (args[0].equals("relaxed")) {
      model = PyramidSolitaireCreator.create(GameType.RELAXED);
    }
    else {
      model = PyramidSolitaireCreator.create(GameType.TRIPEAKS);
    }
    if (args.length == 3) {
      numRows = Integer.parseInt(args[1]);
      numDraw = Integer.parseInt(args[2]);
    }
    new PyramidSolitaireTextualController(new InputStreamReader(System.in),
            System.out).playGame(model,
            model.getDeck(), true, numRows, numDraw);
  }
}