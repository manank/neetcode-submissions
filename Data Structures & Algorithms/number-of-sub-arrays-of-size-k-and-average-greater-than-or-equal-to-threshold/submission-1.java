class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        double runningSum = 0.0;
        for (int i = 0; i < k - 1; i++) {
            runningSum += arr[i];
        }

        int count = 0;
        // if (runningSum / k >= threshold) {
        //     count++;
        // }

        for (int i = k - 1; i < arr.length; i++) {

            runningSum += arr[i];

            if (runningSum / k >= threshold) {
                count++;
            }

            runningSum -= arr[i - k + 1];
            
        }

        return count;
    }
}