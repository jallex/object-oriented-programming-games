package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents a Card with a num and a type.
 */
public final class Card extends ACard {

  private final int num;
  private final Type type;

  /**
   * Constructs a {@code Card} object.
   *
   * @param num  the value of the Card
   * @param type the type of the Card
   */
  public Card(int num, Type type) {
    if (num > 13
            || num < 1) {
      throw new IllegalArgumentException("Card number cannot be < 1 or > 13.");
    } else {
      this.num = num;
    }
    this.type = type;
  }

  @Override
  public String toString() {
    if (this.type.equals(Type.HEARTS)) {
      if (num == 11) {
        return "J♥";
      } else if (num == 12) {
        return "Q♥";
      } else if (num == 13) {
        return "K♥";
      } else if (num == 1) {
        return "A♥";
      }
      return num + "♥";
    }
    if (this.type.equals(Type.SPADES)) {
      if (num == 11) {
        return "J♠";
      } else if (num == 12) {
        return "Q♠";
      } else if (num == 13) {
        return "K♠";
      } else if (num == 1) {
        return "A♠";
      }
      return num + "♠";
    }
    if (this.type.equals(Type.CLUBS)) {
      if (num == 11) {
        return "J♣";
      } else if (num == 12) {
        return "Q♣";
      } else if (num == 13) {
        return "K♣";
      } else if (num == 1) {
        return "A♣";
      }
      return num + "♣";
    } else {
      if (num == 11) {
        return "J♦";
      } else if (num == 12) {
        return "Q♦";
      } else if (num == 13) {
        return "K♦";
      } else if (num == 1) {
        return "A♦";
      }
      return num + "♦";
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    Card c = (Card) obj;

    return (c.num == this.num && c.type.equals(this.type));
  }

  @Override
  public int hashCode() {
    return this.num;
  }

  @Override
  public int score() {
    return num;
  }
}
