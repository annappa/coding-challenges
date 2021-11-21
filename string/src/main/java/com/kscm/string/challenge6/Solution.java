package com.kscm.string.challenge6;

public class Solution {
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //a*, a*b*
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
            //System.out.println(dp[0][i]);
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * Dynamic programming technique for regex matching.
     */
    public boolean isMatch2(String text, String pattern) {
        boolean T[][] = new boolean[text.length() + 1][pattern.length() + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern.charAt(i-1) == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern.charAt(j - 1) == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern.charAt(j-2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length()][pattern.length()];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "aa";
        String p1 = "a";
        System.out.println(solution.isMatch(s1, p1)); // false

        String s2 = "aa";
        String p2 = "a*";
        System.out.println(solution.isMatch(s2, p2)); //  true

        String s3 = "aa";
        String p3 = ".*";
        System.out.println(solution.isMatch(s3, p3)); // true

        String s4 = "aab";
        String p4 = "c*a*b";
        //c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
        System.out.println(solution.isMatch(s4, p4)); // true

        String s5 = "mississippi";
        String p5 = "mis*is*p*.";
        //c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
        System.out.println(solution.isMatch(s5, p5)); // false

        System.out.println("---------  Second Approach ----------");
        String s11 = "aa";
        String p11 = "a";
        System.out.println(solution.isMatch2(s11, p11)); // false

        String s22 = "aa";
        String p22 = "a*";
        System.out.println(solution.isMatch2(s22, p22)); //  true
    }
}
