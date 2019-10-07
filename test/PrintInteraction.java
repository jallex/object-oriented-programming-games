/**
 * Represents the printing of a sequence of lines to output.
 */
class PrintInteraction implements Interaction {
  String[] lines;
  boolean hasNewLine;

  PrintInteraction(String... lines) {
    this.lines = lines;
    this.hasNewLine = true;
  }

  PrintInteraction(boolean hasNewLine, String... lines) {
    this.lines = lines;
    this.hasNewLine = hasNewLine;
  }

  public void apply(StringBuilder in, StringBuilder out) {
    for (String line : lines) {
      if (hasNewLine) {
        out.append(line).append("\n");
      }
      else {
        out.append(line);
      }
    }
  }
}
