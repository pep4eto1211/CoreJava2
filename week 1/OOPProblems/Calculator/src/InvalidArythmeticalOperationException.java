/**
 * Created by pepsi on 17-May-15.
 */
public class InvalidArythmeticalOperationException extends Exception {
    public InvalidArythmeticalOperationException() {
    }

    @Override
    public String getMessage() {
        return "This operator is not valid!";
    }
}
