package rgpio;

public class RGPIODispatcher {

    public RGPIODispatcher() {
     new RGPIODispatcherThread().start();
    }

}
