public class JedliksToyCar {

    private static final int INITIAL_DISTANCE_DRIVEN = 0;
    private static final int INITIAL_BATTERY_CHARGE = 100;
    private static final int BATTERY_USAGE_PER_DRIVE = 1;
    private static final int METERS_PER_DRIVE = 20;
    private int batteryCharge;
    private int metersDriven;
    
    public JedliksToyCar() {
        batteryCharge = INITIAL_BATTERY_CHARGE;
        metersDriven = INITIAL_DISTANCE_DRIVEN;
    }

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven %d meters".formatted(metersDriven);
    }

    public String batteryDisplay() {
        if(batteryCharge==0) {
            return "Battery empty";
        } else {
            return "Battery at %d%%".formatted(batteryCharge);
        }
    }

    public void drive() {
        if(batteryCharge>0) {
            metersDriven += METERS_PER_DRIVE;
            batteryCharge -= BATTERY_USAGE_PER_DRIVE;
        }
    }
}
