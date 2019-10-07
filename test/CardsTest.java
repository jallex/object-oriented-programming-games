import org.junit.Test;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.EmptyCard;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.Type;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link ICard} for all of its test cases.
 */
public class CardsTest {

  ICard mtCard = new EmptyCard();
  ICard card1 = new Card(13, Type.SPADES);
  ICard card2 = new Card(8, Type.HEARTS);
  ICard card3 = new Card(5, Type.CLUBS);
  ICard card4 = new Card(1, Type.DIAMONDS);


  @Test
  public void testCards() {
    assertEquals(true, this.mtCard.isEmptyCard());
    assertEquals(false, this.card1.isEmptyCard());
    assertEquals(true, this.card2.addTo13(this.card3));
    assertEquals(false, this.card1.addTo13(this.mtCard));
    assertEquals(false, this.mtCard.addTo13(this.card1));
    assertEquals(false, this.card1.addTo13(this.card2));
    assertEquals(true, this.card1.isKing());
    assertEquals(false, this.card2.isKing());
    assertEquals(false, this.mtCard.isKing());
    assertEquals(0, this.mtCard.score());
    assertEquals(13, this.card1.score());
    assertEquals(true, this.mtCard.equals(new EmptyCard()));
    assertEquals(true, this.card1.equals(new Card(13, Type.SPADES)));
    assertEquals(false, this.card1.equals(this.card2));
    assertEquals("  ", this.mtCard.toString());
    assertEquals("A♦", this.card4.toString());
    assertEquals(new EmptyCard().hashCode(), this.mtCard.hashCode());
    assertEquals(new Card(13, Type.SPADES).hashCode(), this.card1.hashCode());
  }
}
