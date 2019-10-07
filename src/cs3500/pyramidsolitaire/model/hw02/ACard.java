package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents an Abstract Card.
 */
public abstract class ACard implements ICard {
  @Override
  public abstract boolean isEmptyCard();

  @Override
  public boolean addTo13(ICard c) {
    return ! this.isEmptyCard()
            && ! c.isEmptyCard()
            &&
            this.score() + c.score() == 13;
  }

  @Override
  public abstract boolean isKing();

  @Override
  public abstract int score();
}
