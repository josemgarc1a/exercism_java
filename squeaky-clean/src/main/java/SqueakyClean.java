import java.util.Map;
import java.util.Objects;

class SqueakyClean {

    private static final char HYPHEN = '-';
    private static final char WHITESPACE = ' ';
    private static final char UNDERSCORE='_';
    private static final Map<Character, Character> LEET_MAP = 
    Map.of(
        '4', 'a', 
        '3', 'e',
        '0','o',
        '1','l',
        '7','t');

    static String clean(String identifier) {
        if(Objects.isNull(identifier) || identifier.isEmpty()) {
            return identifier;
        }

        StringBuilder sb = new StringBuilder();
        boolean[] capitalizeNext = {false};
        identifier.chars().forEach(ch -> {
            //Replace White Spaces with Underscore
            if(ch==WHITESPACE) {
                sb.append(UNDERSCORE);
                capitalizeNext[0] = false;
            }
            //Kebab Case to Camel Case
            else if (ch==HYPHEN) {
                capitalizeNext[0] = true;
            }
            //Leet Speak to Normal Text
            else if (LEET_MAP.containsKey((char)ch)) {
                char nextChar = LEET_MAP.get((char)ch);
                sb.append(capitalizeNext[0]? Character.toUpperCase(nextChar) : nextChar);
                capitalizeNext[0] = false;
            }
            //Remove no letters
            else if (Character.isLetter(ch) || ch==UNDERSCORE) {
                sb.append(capitalizeNext[0]? Character.toUpperCase((char)ch) : (char)ch);
                capitalizeNext[0] = false;
            } 
        });
        return sb.toString();
    }
}
