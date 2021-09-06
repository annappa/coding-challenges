package com.kscm.trees.challenge1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Find all words matching a pattern in the given dictionary

Given a dictionary of words where each word follows a CamelCase notation, find all words in it that matches a given pattern of all uppercase characters.

CamelCase Notation is the practice of writing compound words or phrases joined without spaces, where each word’s first letter is capitalized.
For example, PowerPoint, LibreOffice, CinemaScope, etc., are in CamelCase.

For example, consider the dictionary.

dict = [Hi, HiTech, HiTechCity, Hello, HelloWorld, HiTechLab]

- If the pattern is HT, the output is [HiTech, HiTechCity, HiTechLab].
- If the pattern is HTC, the output is [HiTechCity].
- If the pattern is H, the output is the same as the input.
 */

/*
 Solution: We can use a Trie datastructure to solve this problem.
 The idea is to insert all uppercase characters of each word in the CamelCase dictionary into a Trie.
 In contrast, the complete word is stored in a container associated with the corresponding leaf node. After the complete dictionary is processed, traverse the Trie and find all words that match the given pattern.
 */

// A class to store a Trie node
class TrieNode
{
    // each node stores a map to its child nodes
    Map<Character, TrieNode> map = new HashMap<>();

    // true when the node is a leaf node
    boolean isLeaf = false;

    // collection to store a complete list of words in the leaf node
    Set<String> word = new HashSet<>();
}

public class Dictionary
{
    // Function to insert a string into a Trie
    public static TrieNode insert(TrieNode head, String word)
    {
        if (head == null) {
            head = new TrieNode();
        }

        // start from the head node
        TrieNode curr = head;
        for (char c: word.toCharArray())
        {
            // insert only uppercase characters
            if (Character.isUpperCase(c))
            {
                // create a new node if the path doesn't exist
                curr.map.putIfAbsent(c, new TrieNode());

                // go to the next node
                curr = curr.map.get(c);
            }
        }

        // mark the current node as a leaf
        curr.isLeaf = true;

        // push the current word into the set associated with a leaf node
        (curr.word).add(word);

        return head;
    }

    // Function to print all children of a given Trie node
    public static void printAllWords(TrieNode root)
    {
        // base case
        if (root == null) {
            return;
        }

        // if the current node is a leaf, print all words associated with it
        if (root.isLeaf) {
            System.out.println(root.word);
        }

        // recur for all children of the root node
        for (Map.Entry<Character, TrieNode> pair: root.map.entrySet())
        {
            TrieNode child = pair.getValue();
            printAllWords(child);
        }
    }

    // Function to print all words in the CamelCase dictionary, which
    // matches the given pattern
    public static void findAllWords(List<String> dictionary, String pattern)
    {
        // Trie head node
        TrieNode head = null;

        // construct a Trie from the given dictionary
        for (String s: dictionary) {
            head = insert(head, s);
        }

        // search for the given pattern in the Trie
        TrieNode curr = head;
        for (char c: pattern.toCharArray())
        {
            // move to the child node
            curr = curr.map.get(c);

            // if the given pattern is not found (reached end of a path in the Trie)
            if (curr == null) {
                return;
            }
        }

        // print all words matching the given pattern
        printAllWords(curr);
    }

    public static void main(String[] args)
    {
        List<String> dictionary = null;
        dictionary = Arrays.asList("Hi", "HiTech", "HiTechCity", "Techie",
                "TechieDelight", "Hello", "HelloWorld", "HiTechLab");

        String pattern = "HT";
        findAllWords(dictionary, pattern);
    }
}
