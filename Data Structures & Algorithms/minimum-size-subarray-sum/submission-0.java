class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minSubArrayLen = Integer.MAX_VALUE;

        int left = 0;
        int windowSum = 0;
        for (int i = 0; i < nums.length; i++) {

            windowSum += nums[i];

            while (left <= i && windowSum >= target) {
                minSubArrayLen = Math.min(minSubArrayLen, i - left + 1);
                
                windowSum -= nums[left];
                left++;
            }
        }

        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }
}