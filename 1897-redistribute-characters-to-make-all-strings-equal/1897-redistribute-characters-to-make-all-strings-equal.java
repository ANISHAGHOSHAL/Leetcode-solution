class Solution {
    // Function to check if characters in words can be rearranged
    // to make each word have the same characters in the same frequency.
    public boolean makeEqual(String[] words) {
        
        // Array to store the count of each character (initialized to 0).
        final int[] characterCount = new int[26];

        // Loop through each word in the input array 'words'.
        for (String inputWord : words) {
            // Loop through each character in the current word.
            for (char inputChar : inputWord.toCharArray()) {
                // Increment the count of the current character in 'characterCount'.
                characterCount[inputChar - 'a']++;
            }
        }

        // Check if the count of each character is divisible by the total number of words.
        for (int count : characterCount) {
            if (count % words.length != 0) {
                // If not divisible, characters cannot be rearranged to make all words equal.
                return false;
            }
        }

        // If all characters can be rearranged to make words equal, return true.
        return true;
    }
}
