class Solution {
    public int maxVowels(String s, int k) {
        List<Character> v = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Set<Character> vowels = new HashSet<Character>(v);

        int vcount =0;
        for(int i=0 ;i<k; i++){
            if(vowels.contains(s.charAt(i))) vcount++;
        }

        int max = vcount;
        int left =0;
        int right = k-1;
        while(right<s.length()-1){
            if(vowels.contains(s.charAt(left))) vcount--;
            left++;
            right++;
            if(vowels.contains(s.charAt(right))) vcount++;
            max = Math.max(max, vcount);
        }

        return max;
    }
}