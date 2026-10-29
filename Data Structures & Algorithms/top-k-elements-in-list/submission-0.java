class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        

        Map<Integer, Integer> freqs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqs.merge(nums[i], 1, Integer::sum);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (Map.Entry<Integer, Integer> freq : freqs.entrySet()) {

            pq.offer(new int[]{freq.getKey(), freq.getValue()});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
