```text
Find all words matching a pattern in the given dictionary

Given a dictionary of words where each word follows a CamelCase notation, find all words in it that matches a given pattern of all uppercase characters.

CamelCase Notation is the practice of writing compound words or phrases joined without spaces, where each word’s first letter is capitalized.
For example, PowerPoint, LibreOffice, CinemaScope, etc., are in CamelCase.

For example, consider the dictionary.

dict = [Hi, HiTech, HiTechCity, Hello, HelloWorld, HiTechLab]

- If the pattern is HT, the output is [HiTech, HiTechCity, HiTechLab].
- If the pattern is HTC, the output is [HiTechCity].
- If the pattern is H, the output is the same as the input.

```

```text
 Solution: We can use a Trie datastructure to solve this problem. The idea is to insert all uppercase characters of each word in the CamelCase dictionary into a Trie. In contrast, the complete word is stored in a container associated with the corresponding leaf node. After the complete dictionary is processed, traverse the Trie and find all words that match the given pattern.
```