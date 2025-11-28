import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LogLevel {
    UNKNOWN("UNK",0),
    TRACE("TRC",1),
    DEBUG("DBG",2),
    INFO("INF",4),
    WARNING("WRN",5),
    ERROR("ERR",6),
    FATAL("FTL",42);

    private final String shortLogLevel;
    private final int encodedLogLevel;

    LogLevel(String shortLogLevel, int encodedLogLevel) {
        this.shortLogLevel = shortLogLevel;
        this.encodedLogLevel = encodedLogLevel;
    }
    
    public String getShortLogLevel() {
        return this.shortLogLevel;
    }

    public int getEncodedLogLevel() {
        return this.encodedLogLevel;
    }

    private static final Map<String, LogLevel> LOOKUP = 
        Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(
                        LogLevel::getShortLogLevel, 
                        Function.identity()));

    public static LogLevel findByShortLogLevel(String shortLogLevel) {
        return LOOKUP.getOrDefault(shortLogLevel, UNKNOWN);
    }

}
