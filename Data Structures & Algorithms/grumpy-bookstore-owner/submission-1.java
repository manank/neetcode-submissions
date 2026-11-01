class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int satisfied = 0;
        int dissatisfied = 0;
        for (int i = 0; i < minutes - 1; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                dissatisfied += customers[i];
            }
        }

        int maxDissatisfied = Integer.MIN_VALUE;

        for (int i = minutes - 1; i < customers.length; i++) {

            if (grumpy[i] == 1) {
                dissatisfied += customers[i];
            } else {
                satisfied += customers[i];
            }

            maxDissatisfied = Math.max(maxDissatisfied, dissatisfied);

            if (grumpy[i - minutes + 1] == 1) {
                dissatisfied -= customers[i - minutes + 1];
            }
        }

        return maxDissatisfied + satisfied;
    }
}