public class ServiceNotAvailableAtTheMoment extends Exception{
    private String m_message = "The requested service is not available at this moment. There might be a problem" +
            " with your connection or the server might be temporary down. ";

    @Override
    public String getMessage() {
        return m_message;
    }

    public Object getService() {
        return m_sender;
    }

    private Object m_sender = null;

    public ServiceNotAvailableAtTheMoment(Object sender) {
        m_sender = sender;
    }

    public ServiceNotAvailableAtTheMoment(Object sender, String message) {
        m_sender = sender;
        m_message = message;
    }
}
