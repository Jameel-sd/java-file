import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map each letter (a-z) to its row index (1, 2, or 3)
        int[] charToRow = new int[26];
        
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        for (char c : row1.toCharArray()) charToRow[c - 'a'] = 1;
        for (char c : row2.toCharArray()) charToRow[c - 'a'] = 2;
        for (char c : row3.toCharArray()) charToRow[c - 'a'] = 3;
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            int targetRow = charToRow[lowerWord.charAt(0) - 'a'];
            boolean isValid = true;
            
            for (int i = 1; i < lowerWord.length(); i++) {
                if (charToRow[lowerWord.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}