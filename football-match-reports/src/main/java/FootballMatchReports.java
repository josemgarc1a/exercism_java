public class FootballMatchReports {    
    private static final String INVALID = "invalid";
    private static final String RIGHT_WING = "right wing";
    private static final String STRIKER = "striker";
    private static final String LEFT_WING = "left wing";
    private static final String MIDFIELDER = "midfielder";
    private static final String RIGHT_BACK = "right back";
    private static final String CENTER_BACK = "center back";
    private static final String LEFT_BACK = "left back";
    private static final String GOALIE = "goalie";

    public static String onField(int shirtNum) {
        switch (shirtNum) {
            case 1:
                return GOALIE;
            case 2:
                return LEFT_BACK;
            case 3, 4:
                return CENTER_BACK;
            case 5:
                return RIGHT_BACK;
            case 6, 7, 8:
                return MIDFIELDER;
            case 9:
                return LEFT_WING;
            case 10:
                return STRIKER;
            case 11:
                return RIGHT_WING;
            default:
                return INVALID;
        }
    }
}
