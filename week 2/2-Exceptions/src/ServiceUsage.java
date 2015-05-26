public class ServiceUsage {
    public ServiceUsage() {

    }

    public void useService() throws ServiceNotAvailableAtTheMoment{
        throw new ServiceNotAvailableAtTheMoment(this);
    }
}
