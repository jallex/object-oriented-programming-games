package cs3500.pyramidsolitaire.model.hw04;

import java.io.InputStreamReader;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;

public final class PyramidSolitaire {
  public static void main(String[] args) {
    PyramidSolitaireModel model;
    int numRows = 7;
    int numDraw = 4;
    if (args[0].equals("basic")) {
      model = new PyramidSolitaireCreator().create(GameType.BASIC);
    }
    else if (args[0].equals("relaxed")) {
      model = new PyramidSolitaireCreator().create(GameType.RELAXED);
    }
    else {
      model = new PyramidSolitaireCreator().create(GameType.TRIPEAKS);
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