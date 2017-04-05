package devices;

public class DeviceModels {

    public DeviceModels() {
        
        Device d;
        
        d = Device.createDeviceModel("ANALOGSENSOR");
        d.addAnalogOutput("analogValue");

        d = Device.createDeviceModel("POWERSWITCH");
        d.addDigitalInput("on/off");

    }
}
