public class SimpleCode {

    public static void main(String args[]) {
        SimpleCode sc = new SimpleCode();
        sc.combineStrings("abc", "def");
        sc.combineStrings("asd", "fghjkl");
    }

    public String combineStrings(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int minLength = Math.min(word1.length(), word2.length());
        for (int i=0; i<minLength; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(word1.length() < word2.length() ?
            word2.substring(minLength) :
            word1.substring(minLength));
        
        return sb.toString();
    }
}
