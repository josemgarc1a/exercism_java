public class StringDivider {
    public static void main(String[] args) {
        StringDivider sd = new StringDivider();
        // sd.stringDivider("ABCABC", "QWE"); //Not a great match
        // sd.stringDivider("ABCABC", "ABC");
        // sd.stringDivider("ABABAB", "ABAB"); //AB
        // sd.stringDivider("ABABABABABAB", "ABABABAB"); //AB
        // sd.stringDivider("ABCDABCDABCD", "ABCD"); //ABCD
        sd.stringDivider("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");
    }

    public String stringDivider(String str, String pattern) {
        if (str == null || pattern == null || str.isEmpty() ||pattern.isEmpty()) {
            return "";
        }

        int strLength = str.length();
        int patternLength = pattern.length();
        

        String divider = "";

        // Pattern must start at position 0
        if (!str.startsWith(pattern) && !pattern.startsWith(str)) {
            return "";
        } 
        
        // Check if string is composed entirely of the pattern
        if (strLength >= patternLength) {
            int simplifiedPatternLength = strLength % patternLength;
            if (strLength % patternLength == 0) {
                System.out.println("All B fits into A");
                divider = getDivider(str, pattern, strLength, patternLength);
            } else {
                System.out.println("Part of B fits into A");
                String bSub = pattern.substring(0,simplifiedPatternLength);
                if (strLength % simplifiedPatternLength == 0) {
                    divider = getDivider(str, bSub, strLength, simplifiedPatternLength);
                }
            }
        } else {
            // Pattern is longer than string - find common divisor
            System.out.println("Pattern is longer than string");
            int gcd = gcd(patternLength, strLength);
            
            // Try all divisors of GCD, starting from largest
            for (int len = gcd; len > 0; len--) {
                if (strLength % len == 0 && patternLength % len == 0) {
                    String candidate = str.substring(0, len);
                    // Check if pattern starts with this candidate
                    if (pattern.startsWith(candidate)) {
                        // Check if both strings are composed of this candidate
                        if (isComposedOf(str, candidate, len) && 
                            isComposedOf(pattern, candidate, len)) {
                            divider = candidate;
                            break;
                        }
                    }
                }
            }
        }

        
        System.out.println("Divider="+divider);
        return divider;
    }

    // Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Check if string is composed entirely of the pattern
    private boolean isComposedOf(String str, String pattern, int patternLength) {
        int strLength = str.length();
        if (strLength % patternLength != 0) {
            return false;
        }
        
        int repetitions = strLength / patternLength;
        for (int rep = 0; rep < repetitions; rep++) {
            int start = rep * patternLength;
            for (int i = 0; i < patternLength; i++) {
                if (str.charAt(start + i) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getDivider(String str, String pattern, int strLength, int patternLength) {
        String divider = "";
        for (int i=str.indexOf(pattern); i<strLength; i+=patternLength) {
            if(str.substring(i, i+patternLength).equals(pattern)) {
                divider = pattern;
            } else {
                divider = "";
                break;
            }
        }
        return divider;
    }
}
