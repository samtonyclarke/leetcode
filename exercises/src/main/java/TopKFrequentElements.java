import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String args[]) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frq = new HashMap<>();
        
        for(Integer n : nums){
            frq.put(n, frq.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return frq.get(o1) - frq.get(o2) ;
            }
        });
        
        for(Integer n : frq.keySet()){
            priorityQueue.add(n);
        }

        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = priorityQueue.poll();
        }
        return top;
    }
    
}
