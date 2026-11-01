class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        double runningSum = 0.0;
        for (int i = 0; i < k; i++) {
            runningSum += arr[i];
        }

        int count = 0;
        if (runningSum / k >= threshold) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {

            runningSum += arr[i] - arr[i-k];

            if (runningSum / k >= threshold) {
                count++;
            }
            
        }

        return count;
    }
}