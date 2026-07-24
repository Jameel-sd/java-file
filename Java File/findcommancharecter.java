import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];

        // Step 1: Initialize minFreq with character counts of the first word
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        // Step 2: Compare with remaining words and keep minimum character counts
        for (int i = 1; i < words.length; i++) {
            int[] charFreq = new int[26];
            for (char c : words[i].toCharArray()) {
                charFreq[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], charFreq[j]);
            }
        }

        // Step 3: Construct the final list of common characters
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;
    }
}