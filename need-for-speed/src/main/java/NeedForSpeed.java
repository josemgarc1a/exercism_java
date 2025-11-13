class NeedForSpeed {

    private int speedInMeters;
    private int batteryDrain;

    private int metersDriven = 0;
    private int currentBattery = 100;
    private static final int NITRO_TOP_SPEED = 50;
    private static final int NITRO_BATTERY_DRAIN = 4;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speedInMeters = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryDrain>currentBattery;
    }

    public int distanceDriven() {
        return metersDriven;
    }

    public void drive() {
        if (batteryDrained()) return;
        metersDriven += speedInMeters;
        currentBattery -= batteryDrain;
    }

    public int fullBatteryRange() {
        return speedInMeters * (100/batteryDrain);
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(NITRO_TOP_SPEED, NITRO_BATTERY_DRAIN);
    }
}

class RaceTrack {

    private int raceTrackDistance;

    RaceTrack(int distance) {
        raceTrackDistance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return car.fullBatteryRange() >= this.raceTrackDistance;
    }
}
