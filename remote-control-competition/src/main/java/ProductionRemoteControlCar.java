class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private final int UNITS_PER_DRIVE = 10;
    private int lifeTimeTravelledUnits = 0;
    private int numberOfVictories = 0;

    @Override
    public void drive() {
        lifeTimeTravelledUnits += UNITS_PER_DRIVE;
    }

    @Override
    public int getDistanceTravelled() {
        return lifeTimeTravelledUnits;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar p) {
        return Integer.compare(this.numberOfVictories, p.numberOfVictories);
    }
}
