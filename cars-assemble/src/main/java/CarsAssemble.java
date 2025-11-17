public class CarsAssemble {

    private static final int CARS_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        return speed * CARS_PER_HOUR * getSuccessRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) Math.floor(productionRatePerHour(speed) / 60);
    }

    private static double getSuccessRate(int speed) {
        switch (speed) {
            case 1, 2, 3, 4:
                return 1.0;
            case 5, 6, 7, 8:
                return 0.9;
            case 9:
                return 0.8;
            case 10:
                return 0.77;
            default:
                return 0;
        }
    }
}
