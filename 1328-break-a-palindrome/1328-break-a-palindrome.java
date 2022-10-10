class Solution {
    public String breakPalindrome(String palindrome) {
        StringBuilder strB = new StringBuilder(palindrome);
        
        if(palindrome.length() == 1)
            return "";
        
        for(int i=0; i<palindrome.length(); i++) {
            
            if(palindrome.length()%2 != 0) {
                if(i == palindrome.length()/2 )
                    continue;
            }
            
            if(palindrome.charAt(i) != 'a') {
                strB.setCharAt(i, 'a');
                return strB.toString();
            }
        }
        
        strB.setCharAt(palindrome.length()-1, 'b');
        return strB.toString();    
    }
    
}