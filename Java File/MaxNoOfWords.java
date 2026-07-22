public class MaxNoOfWords{
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        
        for (String sentence : sentences) {
            // Split the sentence by spaces
            String[] words = sentence.split(" ");
            // Update the maximum count if this sentence has more words
            maxWords = Math.max(maxWords, words.length);
        }
        
        return maxWords;
    }
}