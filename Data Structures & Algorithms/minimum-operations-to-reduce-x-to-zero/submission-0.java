class Solution {

    public int minOperations(int[] nums, int x) {

        int arraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
        }
        int k = arraySum - x;

        int maxLen = -1;
        int windowSum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {

            windowSum += nums[i];

            while (left <= i && windowSum > k) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == k) {
                maxLen = Math.max(maxLen, i - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}
