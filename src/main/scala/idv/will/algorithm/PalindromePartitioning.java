package idv.will.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void backtrack(List<List<String>> list, List<String> tmpList, String s, int start) {
        if(start == s.length()) {
            list.add(new ArrayList<>(tmpList));
        } else {
            for(int i = start; i < s.length(); i++) {
                if(isPalindrome(s.substring(start, i+1))) {
                    tmpList.add(s.substring(start, i+1));
                    backtrack(list, tmpList, s, i+1);
                    tmpList.remove(tmpList.size()-1);
                }
            }
        }
    }

    public boolean isPalindrome(String s) {
        int middle = s.length()/2;
        int count = 0;
        while(count < middle) {
            int leftIndex = middle-count-1;
            int rightIndex = middle+count;
            if(s.length()%2 != 0) {
                rightIndex++;
            }
            if(s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }
            count++;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("aabbbb"));
    }
}
