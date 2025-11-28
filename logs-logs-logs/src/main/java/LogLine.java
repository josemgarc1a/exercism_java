public class LogLine {

    private final String logLine;
    private final LogLevel logLevel;

    public LogLine(String logLine) {
        this.logLine = logLine;

        int open = logLine.indexOf('[');
        int close = logLine.indexOf(']');
        int colon = logLine.indexOf(':');
        
        if (open == -1 || close == -1 || colon == -1) {
            this.logLevel = LogLevel.UNKNOWN;
            return;
        }

        String shortLogLevel = logLine.substring(open + 1, close);
        this.logLevel = LogLevel.findByShortLogLevel(shortLogLevel);
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public String getOutputForShortLog() {
        String logMessage = logLine.substring(
            logLine.indexOf(":") + 1);
        return this.logLevel.getEncodedLogLevel() + ":" + logMessage.trim();
    }
}
