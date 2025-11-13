import java.util.ArrayList;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        var rankedCard = new ArrayList<>(cars);
        rankedCard.sort(java.util.Collections.reverseOrder());
        return rankedCard;
    }
}
