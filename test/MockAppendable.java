import java.io.IOException;

/**
 * Represents a Mock Appendable used for testing.
 */
public class MockAppendable implements Appendable {
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("This method is throwing an IOException.");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("This method is throwing an IOException.");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("This method is throwing an IOException.");
  }
}
