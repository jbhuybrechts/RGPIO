

package devices;


public enum DeviceType {
    Pi3B (40), 
    ESP (2);
   
    private final int nrPins;
    
    DeviceType(int nrPins) {
        this.nrPins = nrPins;
    }
    public int nrPins() { return nrPins; }

}