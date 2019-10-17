import org.junit.Test;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.Relaxed;
import cs3500.pyramidsolitaire.model.hw04.TriPeaks;

import static org.junit.Assert.assertEquals;

/**
 * A testing class, that uses {@link cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator}
 * for all of its test cases.
 */
public class PyramidSolitaireCreatorTest {
  PyramidSolitaireCreator psm = new PyramidSolitaireCreator();

  @Test
  public void testGameType() {
    assertEquals(true, this.psm.create(PyramidSolitaireCreator.GameType.BASIC)
            instanceof BasicPyramidSolitaire);
    assertEquals(true, this.psm.create(PyramidSolitaireCreator.GameType.RELAXED)
            instanceof Relaxed);
    assertEquals(true, this.psm.create(PyramidSolitaireCreator.GameType.TRIPEAKS)
            instanceof TriPeaks);
  }
}