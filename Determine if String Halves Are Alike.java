class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int mid = s.length() / 2; 
        int answer = 0;
        for (int i = 0; i < mid; i++) {
            // 앞의 문자열에서 모음 개수를 더하고, 뒤쪽에서는 빼준다.
            if (vowels.indexOf(s.charAt(i)) >= 0) answer++;
            if (vowels.indexOf(s.charAt(i + mid)) >= 0) answer--;
        }
        // 앞뒤의 모음 개수가 동일하면 0이 되므로 true 아니면 false
        if (answer == 0)
            return true;
        else 
            return false;
    }
}
