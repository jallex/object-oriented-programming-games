package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

public class PyramidSolitaireCreator {
  public enum GameType {
    BASIC, RELAXED, TRIPEAKS;
  }

  public static <GameType> PyramidSolitaireModel create(GameType type) {
    PyramidSolitaireModel model;
    if (type == PyramidSolitaireCreator.GameType.BASIC) {
      model = new BasicPyramidSolitaire();
    } else if (type == PyramidSolitaireCreator.GameType.RELAXED) {
      model = new Relaxed();
    } else {
      model = new TriPeaks();
    }
    return model;
  }
}
