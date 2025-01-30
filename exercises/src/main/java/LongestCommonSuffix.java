public class LongestCommonSuffix {

    public static void main(String args[]) {
        LongestCommonSuffix longestCommonSuffix = new LongestCommonSuffix();
//        System.out.println(longestCommonSuffix.solution(new String[]{"induction", "reduction", "ambition"}));
        System.out.println(longestCommonSuffix.solution(new String[]{"apple", "grapple", "pineapple"}));
    }
    
    public String solution(String[] strs) {

        StringBuilder sb = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String shortest = strs[0];

        for(int i=0;i<strs.length;i++) {
            if (strs[i].length() < shortest.length() ) {
                shortest = strs[i];
            }
        }

        int matched = 0;

        int scanBackFrom = shortest.length()-1;

        while(scanBackFrom>=0) {
            for(int i=0;i<strs.length;i++) {
                int fromEndI = strs[i].length() - matched -1;
                char strC = strs[i].charAt(fromEndI);
                char shortestC = shortest.charAt(scanBackFrom);
                if(strC != shortestC) {
                    return shortest.substring(scanBackFrom+1);
                }
            }
            scanBackFrom--;
            matched++;
        }
        return shortest;
    }
}
