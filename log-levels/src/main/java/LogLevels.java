public class LogLevels {

    private static final String COLON_STRING = ":";
    private static final String CLOSING_BRACKET_STRING = "]";
    
    public static String message(String logLine) {
        int colon = logLine.indexOf(COLON_STRING);
        return logLine.substring(colon+1).trim();
    }

    public static String logLevel(String logLine) {
        int closingBraket = logLine.indexOf(CLOSING_BRACKET_STRING);
        if ( closingBraket > 0 ) {
            return logLine.substring(1, closingBraket).toLowerCase();
        }
        return "";
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }
}
