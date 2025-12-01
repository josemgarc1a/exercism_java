import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};
    private static final String REGISTRY_PREFIX = "NCC-";
    private static final int REGISTRY_LOW_BOUND = 1000;
    private static final int REGISTRY_HIGH_BOUND = 10000;
    private static final double DATE_LOW_BOUND = 41000.0;
    private static final double DATE_HIGH_BOUND = 42000.0;

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        return PLANET_CLASSES[random.nextInt(PLANET_CLASSES.length)];
    }

    String randomShipRegistryNumber() {
        return REGISTRY_PREFIX + random.nextInt(REGISTRY_LOW_BOUND,REGISTRY_HIGH_BOUND);
    }

    double randomStardate() {
        return random.nextDouble(DATE_LOW_BOUND, DATE_HIGH_BOUND);
    }
}
