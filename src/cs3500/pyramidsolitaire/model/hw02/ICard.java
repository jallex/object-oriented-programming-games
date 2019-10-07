package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents an interface of methods for game cards.
 */
public interface ICard {
  /**
   * Returns if this ICard is an instance of an EmptyCard.
   *
   * @return
   */
  boolean isEmptyCard();

  /**
   * Returns if this ICard's number added with the given Card c adds to 13.
   *
   * @param c the other ICard whose value will be added to this ICard
   * @return
   */
  boolean addTo13(ICard c);

  /**
   * Returns if this ICard is a King.
   *
   * @return if this ICard is a King
   */
  boolean isKing();

  /**
   * Returns the score of this ICard.
   *
   * @return the score of this ICard
   */
  int score();
}
