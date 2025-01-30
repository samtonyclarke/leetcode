import java.util.*;

public class MinimalKSegments {
    
    //This function should accept a list as an input and compute an intriguing property related to contiguous blocks 
    // within the list.
    //
    //More specifically, you must select a particular integer, k, from the list. Once you've selected k, the function 
    // should remove all occurrences of k from the list, thereby splitting it into several contiguous blocks or 
    // remaining sub-lists. A unique feature of k is that it is chosen such that the maximum length among these blocks 
    // is minimized.
    //
    //For instance, consider the list {1, 2, 2, 3, 1, 4, 4, 4, 1, 2, 5}. If we eliminate all instances of 2 (our k), 
    // the remaining blocks would be {1}, {3, 1, 4, 4, 4, 1}, {5}, with the longest containing 6 elements. Now, if we 
    // instead remove all instances of 1, the new remaining blocks would be {2, 2, 3}, {4, 4, 4}, {2, 5}, the longest 
    // of which contains 3 elements. As such, the function should return 1 in this case, as it leads to a minimally 
    // maximal block length.

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 1, 4, 4, 4, 1, 2, 5);
        int optimizedResult = minimalMaxBlock(list);
        System.out.println(optimizedResult);
    }
    

    public static int minimalMaxBlock(List<Integer> list) {
        HashMap<Integer, Integer> lastOccurrence = new HashMap<>();
        HashMap<Integer, Integer> maxBlockSizes = new HashMap<>();

        for (int i = 0; i < list.size(); ++i) {
            int num = list.get(i);
            if (!lastOccurrence.containsKey(num)) {
                maxBlockSizes.put(num, i);
            } else {
                int blockSize = i - lastOccurrence.get(num) - 1;
                maxBlockSizes.put(num, Math.max(maxBlockSizes.get(num), blockSize));
            }
            lastOccurrence.put(num, i);
        }

        for (Map.Entry<Integer, Integer> entry : lastOccurrence.entrySet()) {
            int num = entry.getKey();
            int pos = entry.getValue();
            int blockSize = list.size() - pos - 1;
            maxBlockSizes.put(num, Math.max(maxBlockSizes.get(num), blockSize));
        }

        int minNum = -1;
        int minBlockSize = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : maxBlockSizes.entrySet()) {
            if (entry.getValue() < minBlockSize) {
                minBlockSize = entry.getValue();
                minNum = entry.getKey();
            }
        }

        return minNum;
    }

    public static int minimalMaxBlockBruteforce(List<Integer> list) {
        int minMaxBlockSize = Integer.MAX_VALUE;
        int minNum = -1;

        Set<Integer> uniqueElements = new HashSet<>(list);

        for (int num : uniqueElements) {
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i) == num) {
                    indices.add(i);
                }
            }
            indices.add(0, -1);
            indices.add(list.size());

            int maxBlockSize = 0;
            for (int i = 1; i < indices.size(); ++i) {
                maxBlockSize = Math.max(maxBlockSize, indices.get(i) - indices.get(i - 1) - 1);
            }

            if (maxBlockSize < minMaxBlockSize) {
                minMaxBlockSize = maxBlockSize;
                minNum = num;
            }
        }

        return minNum;
    }
    
}
