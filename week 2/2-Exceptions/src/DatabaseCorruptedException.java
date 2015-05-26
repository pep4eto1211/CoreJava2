public class DatabaseCorruptedException extends RuntimeException {
    private String m_message = "Your database might be corrupted.";

    @Override
    public String getMessage() {
        return m_message;
    }

    public DatabaseCorruptedException() {
        super();
    }

}
