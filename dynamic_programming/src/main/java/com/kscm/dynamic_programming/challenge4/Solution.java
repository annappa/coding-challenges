package com.kscm.dynamic_programming.challenge4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private static int count=0;
    //Recursion Aproach / Brute Force
    //Time :  O(2^n)
    // Space: O(n)
    public boolean wordBreak_recursion(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    //O(n^3)
    public boolean wordBreak_memoization(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    //O(n^3)
    //
    public boolean wordBreak_bfs(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    public boolean wordBreak_dynamic_programming(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.wordBreak_recursion("leetcode", Arrays.asList(new String[]{"leet","code"})));
        //System.out.println(solution.wordBreak_recursion("applepenapple", Arrays.asList(new String[]{"apple","pen"})));
        //System.out.println(solution.wordBreak_recursion("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"})));
        //System.out.println(solution.wordBreak_recursion("abcd", Arrays.asList(new String[]{"a", "b","c","d","ab"}))); // 2^4 =? 2*2*2*2=16
        /*System.out.println(solution.wordBreak_recursion("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa"})));*/
        //System.out.println("Count:" +count);

        //System.out.println("----Memoization Solution------");
        //System.out.println(solution.wordBreak_memoization("leetcode", Arrays.asList(new String[]{"leet","code"})));
        //System.out.println(solution.wordBreak_memoization("applepenapple", Arrays.asList(new String[]{"apple","pen"})));
        //System.out.println(solution.wordBreak_memoization("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"})));
        //System.out.println(solution.wordBreak_memoization("abcd", Arrays.asList(new String[]{"a", "b","c","d","ab"}))); // 2^4 =? 2*2*2*2=16
       /* System.out.println(solution.wordBreak_memoization("aaaabaaaaaaaaaa",
                Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa"})));*/
        //System.out.println("Count:" +count);

        //System.out.println("----BFS Approach------");
        //System.out.println(solution.wordBreak_bfs("leetcode", Arrays.asList(new String[]{"leet","code"})));
        //System.out.println(solution.wordBreak_bfs("catsanddog", Arrays.asList(new String[]{"cat","cats","sand","and","dog"})));
        //System.out.println(solution.wordBreak_bfs("applepenapple", Arrays.asList(new String[]{"apple","pen"})));
        //System.out.println(solution.wordBreak_bfs("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"})));
        //System.out.println(solution.wordBreak_bfs("abcd", Arrays.asList(new String[]{"a", "b","c","d","ab"}))); // 2^4 =? 2*2*2*2=16
       /* System.out.println(solution.wordBreak_bfs("aaaabaaaaaaaaaa",
                Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa"})));*/
        //System.out.println("Count:" +count);

        System.out.println("----Dynamic Programming------");
        System.out.println(solution.wordBreak_dynamic_programming("catsanddog", Arrays.asList(new String[]{"cat","cats","sand","and","dog"})));
        //System.out.println(solution.wordBreak_dynamic_programming("catsanddogg", Arrays.asList(new String[]{"cat","cats","sand","and","dog"})));
    }
}
