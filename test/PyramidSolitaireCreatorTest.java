import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.TriPeaks;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.ICard;
import cs3500.pyramidsolitaire.model.hw02.Type;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator}
 * for all of its test cases.
 */
public class PyramidSolitaireCreatorTest {
PyramidSolitaireCreator psm = new PyramidSolitaireCreator();

  @Before
  public void setUp() throws Exception {
  }

  /**
  @Test
  public void testGameType () {
    assertEquals(true, this.psm.create(PyramidSolitaireCreator.Gametype.BASIC)
            instanceof BasicPyramidSolitaire);
    assertEquals(true, this.psm.create(PyramidSolitaireCreator.Gametype.RELAXED)
            instanceof BasicPyramidSolitaire);
    assertEquals(true, this.psm.create(PyramidSolitaireCreator.Gametype.TRIPEAKS)
            instanceof BasicPyramidSolitaire);
  }
  **/
}