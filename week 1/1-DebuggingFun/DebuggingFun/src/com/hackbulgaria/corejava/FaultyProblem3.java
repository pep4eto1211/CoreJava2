package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        String newSentence = "";
        for (String word: words){
            word = reverse(word);
            newSentence += word + " ";
        }
        return newSentence.trim();
    }

    private String reverse(String word) {
        return Utils.reverseMe(word);
    }
}
