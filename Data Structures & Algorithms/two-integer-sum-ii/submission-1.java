class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int i1 = 0;
        int i2 = numbers.length - 1;

        while (i1 < i2) {
            if (numbers[i1] + numbers[i2] > target) {
                i2--;
            } else if (numbers[i1] + numbers[i2] < target) {
                i1++;
            } else {
                return new int[] {i1 + 1, i2 + 1};
            }
        }

        return new int[0];
    }
}
