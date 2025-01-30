public class SubArrayMatch {
    public static void main(String args[]) {
        SubArrayMatch subArrayMatch = new SubArrayMatch();
        subArrayMatch.solution(new int[]{-9, -8, -7, -6}, new int[]{-7, -7});
    }

    public boolean solution(int[] listA, int[] listB) {
        for(int i=0;i<listA.length;i++) {
            System.out.print(listA[i]+" ");
        }
        System.out.println("");
        for(int i=0;i<listB.length;i++) {
            System.out.print(listB[i]+" ");
        }

        for(int i=0;i<listA.length;i++) {
            for (int j=0;j<listB.length;j++) {
                if (listA[i] != listB[j]) {
                    break;
                }
                if (listA[i] == listB[j] && j == listB.length -1 ) {
                    System.out.println("returning true because: "+listA[i]+" equals "+listB[j]);
                    System.out.println("I was: "+i+" and j was: "+j);
                    return true;
                }
                if(listA[i] == listB[j]) {
                    i++;
                }
            }
        }
        return false;
    }
}
