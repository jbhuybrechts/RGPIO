package rgpio;

import devices.DeviceMonitorThread;
import devices.*;

public class RGPIODispatcher {

    public RGPIODispatcher() {
        
     new DeviceModels();
     
     new DeviceMonitorThread().start();
    }

}
