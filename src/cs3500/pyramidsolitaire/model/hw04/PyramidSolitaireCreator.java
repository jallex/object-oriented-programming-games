package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

public class PyramidSolitaireCreator {
  public enum Gametype {
    BASIC, RELAXED, TRIPEAKS;
  }

  static <GameType> PyramidSolitaireModel create(GameType type) {
    PyramidSolitaireModel model;
    if (type == Gametype.BASIC) {
      model = new BasicPyramidSolitaire();
    } else if (type == Gametype.RELAXED) {
      model = new Relaxed();
    } else {
      model = new TriPeaks();
    }
    return model;
  }
}
