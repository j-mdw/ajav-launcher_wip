import java.lang.Exception;

public class UnexpectedTokenException extends Exception {
  String token;

  public UnexpectedTokenException(String token, int line) {
    super("Unexpected token: " + token + " found on input file line " + line);
    this.token = token;
  }

  public UnexpectedTokenException(String token) {
    super("Unexpected token: " + token);
    this.token = token;
  }
}
