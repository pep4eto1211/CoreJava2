public class NullKeyException extends IllegalArgumentException {
    public NullKeyException() {
        super("Key can't be null.");
    }
}
