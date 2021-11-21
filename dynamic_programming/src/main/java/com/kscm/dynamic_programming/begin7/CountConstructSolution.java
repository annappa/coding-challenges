package com.kscm.dynamic_programming.begin7;

public class CountConstructSolution {
    //int totalCount=0;

    public int countConstruct(String target, String[] wordsCount) {
        if(target.equals("")) {
            return 1;
        }
        int totalCount = 0;

        for(String word : wordsCount) {
            if(target.indexOf(word) == 0 ) {
                String suffix = target.substring(word.length(), target.length());
                int previousCount = countConstruct(suffix, wordsCount);
                totalCount += previousCount;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        CountConstructSolution countConstructSolution = new CountConstructSolution();
        System.out.println(countConstructSolution.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); //2
    }
}
