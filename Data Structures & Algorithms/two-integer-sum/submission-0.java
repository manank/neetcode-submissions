class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> values = new HashMap<>();
        values.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int difference = target - nums[i];

            if (values.containsKey(difference)) {
                return new int[] {values.get(difference), i};
            }

            values.put(nums[i], i);
        }

        // not possible
        return new int[0];
    }
}
