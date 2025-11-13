public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private static final int UNITS_PER_DRIVE = 20;
    private int lifeTimeTravelledUnits = 0;

    @Override
    public void drive() {
        lifeTimeTravelledUnits += UNITS_PER_DRIVE;
    }

    @Override
    public int getDistanceTravelled() {
        return lifeTimeTravelledUnits;
    }
}
