import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;
    private final int[] lastWeekCount = {0,2,5,3,7,8,4};

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return this.lastWeekCount;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1]++;
    }

    public boolean hasDayWithoutBirds() {
        return birdsPerDay != null && Arrays.stream(birdsPerDay).anyMatch(n -> n==0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        int end = Math.min(Math.max(0, numberOfDays), birdsPerDay.length);
        return Arrays.stream(birdsPerDay, 0, end).sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay).filter(n -> n>=5).count();
    }
}
