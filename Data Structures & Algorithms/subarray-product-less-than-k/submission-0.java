class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int count = 0;
        int product = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {

            product *= nums[i];

            while (left <= i && product  >= k) {
                product /= nums[left];
                left++;
            }

            count += i - left + 1;
        }

        return count;
    }
}