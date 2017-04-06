package rgpio;

import devices.DeviceMonitorThread;
import devices.*;

public class RGPIO {

    public RGPIO() {
        
     new DeviceModels();
     
     new DeviceMonitorThread().start();
    }

}
