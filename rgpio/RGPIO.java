package rgpio;

import devices.DeviceMonitorThread;
import devices.*;

public class RGPIO {
    
    // bericht aan JB

    public RGPIO() {
        
     new DeviceModels();
     
     new DeviceMonitorThread().start();
    }

}
