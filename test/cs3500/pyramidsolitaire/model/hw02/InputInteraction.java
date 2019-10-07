package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents a user providing the program with  an input.
 */
class InputInteraction implements Interaction {
  String input;

  InputInteraction(String input) {
    this.input = input;
  }

  public void apply(StringBuilder in, StringBuilder out) {
    in.append(input + " ");
  }
}