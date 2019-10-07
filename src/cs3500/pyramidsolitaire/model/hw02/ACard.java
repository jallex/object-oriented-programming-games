package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents an Abstract Card.
 */
public abstract class ACard implements ICard {
  @Override
  public abstract boolean isEmptyCard();


  @Override
  public abstract boolean isKing();

  @Override
  public abstract int score();
}
