package cs3500.pyramidsolitaire.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

/**
 * Represents a Controller for Pyramid Solitaire that allows the user to interact with game.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {
  private final Readable rd;
  private final Appendable ap;

  /**
   * Constructs a {@code PyramidSolitaireTextualController} object.
   *
   * @param rd the Readable input
   * @param ap the Appendable output
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap)
          throws IllegalArgumentException {
    if (rd == null
            || ap == null) {
      throw new IllegalArgumentException("The Readable and Appendable cannot be null.");
    }
    this.rd = rd;
    this.ap = ap;
  }

  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck, boolean shuffle,
                           int numRows, int numDraw) {
    if (model == null) {
      throw new IllegalArgumentException("The model cannot be null.");
    }
    try {
      model.startGame(deck, shuffle, numRows, numDraw);
      Scanner scan = new Scanner(this.rd);
      String strInput = "";
      int[] theseInputs;
      int num1;
      int num2;
      int num3;
      int num4;
      while (scan.hasNext()) {
        boolean exceptionThrownDoNotPrint = false;
        strInput = scan.next();
        switch (strInput) {
          case "rm1":
            theseInputs = getInputs(2, scan);
            //signal that the user has quit the game in the inputs
            if (theseInputs == null) {
              break;
            }
            num1 = theseInputs[0] - 1;
            num2 = theseInputs[1] - 1;
            try {
              model.remove(num1, num2);
              if(model.isGameOver() || model.getScore() == 0) {
                break;
              }
              else {
                checkIfFailedToQuit(scan, model);
              }
            } catch (IllegalArgumentException e) {
              this.ap.append("Invalid move. Play again. Remove not valid.\n");
              exceptionThrownDoNotPrint = true;
            }
            break;
          case "rm2":
            theseInputs = getInputs(4, scan);
            if (theseInputs == null) {
              break;
            }
            num1 = theseInputs[0] - 1;
            num2 = theseInputs[1] - 1;
            num3 = theseInputs[2] - 1;
            num4 = theseInputs[3] - 1;
            try {
              model.remove(num1, num2, num3, num4);
              if(model.isGameOver() || model.getScore() == 0) {
                break;
              }
              else {
                checkIfFailedToQuit(scan, model);
              }
            } catch (IllegalArgumentException e) {
              this.ap.append("Invalid move. Play again. Remove not valid.\n");
              exceptionThrownDoNotPrint = true;
            }
            break;
          case "rmwd":
            theseInputs = getInputs(3, scan);
            if (theseInputs == null) {
              break;
            }
            num1 = theseInputs[0] - 1;
            num2 = theseInputs[1] - 1;
            num3 = theseInputs[2] - 1;
            try {
              model.removeUsingDraw(num1, num2, num3);
              if(model.isGameOver() || model.getScore() == 0) {
                break;
              }
              else {
                checkIfFailedToQuit(scan, model);
              }
            } catch (IllegalArgumentException e) {
              this.ap.append("Invalid move. Play again. Remove with draw not valid.\n");
              exceptionThrownDoNotPrint = true;
            }
            break;
          case "dd":
            theseInputs = getInputs(1, scan);
            if (theseInputs == null) {
              break;
            }
            num1 = theseInputs[0] - 1;
            try {
              model.discardDraw(num1);
              if(model.isGameOver() || model.getScore() == 0) {
                break;
              }
              else {
                checkIfFailedToQuit(scan, model);
              }
            } catch (IllegalArgumentException e) {
              this.ap.append("Invalid move. Play again. Discard draw not valid.\n");
              exceptionThrownDoNotPrint = true;
            }
            break;
          case "q":
          case "Q":
            this.ap.append("Game quit!\n"
                    + "State of game when quit:\n");
            break;
          default:
            this.ap.append("Please re-enter a valid input.\n");
            exceptionThrownDoNotPrint = true;
        }
        if (!exceptionThrownDoNotPrint) {
          renderMove(model);
          if (!(model.isGameOver() || model.getScore() == 0)) {
            this.ap.append("\nScore: " + model.getScore() + "\n");
          }
        }
        if (model.isGameOver() || model.getScore() == 0) {
          break;
        }
      }
    } catch (IOException io) {
      throw new IllegalStateException("the Appendable object is unable to transmit output " +
              "or the Readable object is unable to provide inputs.");
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException("Invalid Arguments input to start game.");
    }
  }

  /**
   * Appends the Game Quit message to the appendable if the user quit.
   * @throws IOException if the method fails for some reason
   */
  private void returnQuit() throws IOException {
    this.ap.append("Game quit!\n"
            + "State of game when quit:\n");
  }

  /**
   * Appends the view of the latest model to the appendable.
   * @param m the model
   * @throws IOException if the rendering fails for some reason
   */
  private void renderMove(PyramidSolitaireModel m) throws IOException {
    PyramidSolitaireTextualView view = new PyramidSolitaireTextualView(m, this.ap);
    view.render();
  }

  /**
   * Returns an array of ints containing the input values for the moves.
   * @param numInputs the number of inputs the method requires
   * @param scan the scanner
   * @return An array containing the numeric inputs
   * @throws IOException if the method fails for some reason
   * @throws IllegalStateException if the readable runs out before completing the move
   */
  private int[] getInputs(int numInputs, Scanner scan) throws IOException {
    int soFar = 0;
    int[] myIntArray = new int[numInputs];
    while (soFar < numInputs) {
      if (!scan.hasNext()) {
        throw new IllegalStateException("Readable has run out before move could be completed.");
      } else {
        if (scan.hasNextInt()) {
          myIntArray[soFar] = scan.nextInt();
          soFar += 1;
        } else {
          String s = scan.next();
          if (s.equals("q") || s.equals("Q")) {
            returnQuit();
            //signal for the method to quit the game
            return null;
          } else {
            this.ap.append("Please re-enter a valid input.\n");
          }
        }
      }
    }
    return myIntArray;
  }

  /**
   * Throws an IllegalStateException if the Readable ran out before the user quit the game.
   * @param scan The scanner
   * @throws IllegalStateException if the Readable ran out and the user did not quit the game.
   */
  private void checkIfFailedToQuit(Scanner scan, PyramidSolitaireModel m) {
    if (!scan.hasNext() && !m.isGameOver()) {
      throw new IllegalStateException("User did not enter enough input to complete/quit game.");
    }
  }
}
