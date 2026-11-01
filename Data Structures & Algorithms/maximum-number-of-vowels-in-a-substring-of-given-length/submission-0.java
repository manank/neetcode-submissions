class Solution {
    public int maxVowels(String s, int k) {

        Set<Character> vowels = new HashSet<>(Set.of(new Character[] {'a', 'e', 'i', 'o', 'u'}));

        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        maxCount = count;
        for (int i = k; i < s.length(); i++) {

            if (vowels.contains(s.charAt(i))) {
                count++;
            } 

            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
