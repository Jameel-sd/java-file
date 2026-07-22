public class LengthOfTheLastWord{
    public int lengthOfLastWord(String s) {
        
        // Remove spaces at the beginning and end
        s = s.trim();
        
        // Split the string into words
        String[] words = s.split(" ");
        
        // Return the length of the last word
        return words[words.length - 1].length();
    }
}