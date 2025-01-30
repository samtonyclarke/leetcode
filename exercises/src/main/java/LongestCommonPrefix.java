public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));  // Outputs: "fl"
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }

        for (int i = 0; i < shortest.length(); i++) {
            char charToCheck = shortest.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != charToCheck) {
                    return shortest.substring(0, i);
                }
            }
        }
        return shortest;
    }
    
}
