class Solution {
    public int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int d = nums[i];
                // swap
                if (d < nums.length) {
                    int tmp = nums[d];
                    nums[d] = nums[i];
                    nums[i] = tmp;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
