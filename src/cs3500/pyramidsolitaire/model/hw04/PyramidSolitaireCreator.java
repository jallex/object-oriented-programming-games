package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * A class to represent an abstracted method of creating a model for the Pyramid Solitaire game for
 * the three different types.
 */
public class PyramidSolitaireCreator {
  /**
   * Represents the type of Pyramid Solitaire Game which can be basic, relaxed, or tripeaks.
   */
  public enum GameType {
    BASIC, RELAXED, TRIPEAKS;
  }

  /**
   * Creates a model for the Pyramid Solitaire Game, given the GameType as a parameter.
   * @param type the GameType that represents the type of Pyramid Solitaire game.
   * @return A model of the correct type of Pyramid Solitaire game.
   */
  public static PyramidSolitaireModel create(GameType type) {
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
