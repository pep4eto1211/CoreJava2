public class Main {

    public static void main(String args[]){
        ServiceUsage service = new ServiceUsage();
        try {
            service.useService();
        } catch (ServiceNotAvailableAtTheMoment serviceNotAvailableAtTheMoment) {
            System.out.println(serviceNotAvailableAtTheMoment.getMessage());
            System.out.println(serviceNotAvailableAtTheMoment.getService());
            serviceNotAvailableAtTheMoment.printStackTrace();
        }
    }
}
