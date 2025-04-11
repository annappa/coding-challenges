##INfo
[Reduce the string by removing K consecutive identical characters](https://www.geeksforgeeks.org/reduce-the-string-by-removing-k-consecutive-identical-characters/)

##Question


## Approach: 
This problem can be solved using the Stack data structure. Follow the steps below to solve the problem:

1. Initialize a stack of pair<char, int>, to store characters and their respective consecutive frequencies.
2. Iterate over the characters of the string.
3. If the current character is different from the character present currently at the top of the stack, then set its frequency to 1.
4. Otherwise, if the current character is the same as the character at the top of the stack, then increase its frequency by 1.
5. If the frequency of the character at the top of the stack is K, pop that out of the stack.
6. Finally, print the characters which are remaining in the stack as the resultant string.
