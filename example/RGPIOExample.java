package example;

import rgpio.*;
import devices.*;

class example{
    public void run(){
        
    }
}

public class RGPIOExample {
    
    public static void main(String args[]) throws Exception {
        
        RGPIO rgpio = new RGPIO();
        
        HandleStateChange h = new HandleStateChange();
 
        // device models are added from device description file
        
        Device d;
        
        d = DeviceModels.addDeviceModel("ANALOGSENSOR");
        d.addAnalogInput("pin0");

        d = DeviceModels.addDeviceModel("POWERSWITCH");
        d.addDigitalInput("on/off");
        
        // devices are added for this specific application
        
        Devices.addDevice("ANALOGSENSOR", "sensor1");
        
        // application
        
        Device sensor1=Devices.getDevice("sensor1");
        Pin pin = sensor1.getPin("pin0");
        pin.addListener(h);
        
        // simulation of events from DeviceMonitorThread
        
        while (true) {
            pin.stateChange(true);
            Thread.sleep(5000);
            pin.stateChange(false);
            Thread.sleep(5000);
        }
    }
}
