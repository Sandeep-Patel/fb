import java.util.*;

class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    public String addStrings(String num1, String num2) {
        StringBuilder op = new StringBuilder();
        int carry = 0;

        int i=num1.length()-1, j=num2.length()-1;
        while (i>=0 || j>=0) {
            int x1 = i>=0 ?num1.charAt(i) - '0':0;
            int x2 = j>=0 ?num2.charAt(j) - '0':0;

            int a = carry + x1 + x2;

            op.append(a%10);

            carry = a/10;

            i--;
            j--;
        }
        if (carry != 0)
            op.append(carry);

        return op.reverse().toString();


    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {

        String ss = new Solution().addStrings("9","3");

            System.out.println("Answer = "+ss + " "+ (10==Integer.parseInt(ss)));

    }
}