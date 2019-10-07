package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents an Empty Card in the game (No Card present).
 */
public class EmptyCard extends ACard {

  @Override
  public String toString() {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    return this instanceof EmptyCard;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean isEmptyCard() {
    return true;
  }

  @Override
  public boolean isKing() {
    return false;
  }

  @Override
  public int score() {
    return 0;
  }

}
