public class JedliksToyCar {

    private static final int EMPTY_BATTERY = 0;
    private static final int INITIAL_DISTANCE_DRIVEN = 0;
    private static final int INITIAL_BATTERY_CHARGE = 100;
    private static final int BATTERY_USAGE_PER_DRIVE = 1;
    private static final int METERS_PER_DRIVE = 20;
    
    private int batteryCharge = INITIAL_BATTERY_CHARGE;
    private int metersDriven = INITIAL_DISTANCE_DRIVEN;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven %d meters".formatted(metersDriven);
    }

    public String batteryDisplay() {
        if(batteryCharge==EMPTY_BATTERY) {
            return "Battery empty";
        } else {
            return "Battery at %d%%".formatted(batteryCharge);
        }
    }

    public void drive() {
        if(batteryCharge==EMPTY_BATTERY) return;

        metersDriven += METERS_PER_DRIVE;
        batteryCharge -= BATTERY_USAGE_PER_DRIVE;
    }
}
