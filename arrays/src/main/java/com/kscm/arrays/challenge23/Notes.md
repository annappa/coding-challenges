##Question
This question was asked in Amazon interview

[1010. Pairs of Songs With Total Durations Divisible by 60](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/)

[Java Simple Solution with with a crystal clear explanation(biginners mindset) HashMap in O(n)](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/636651/Java-Simple-Solution-with-with-a-crystal-clear-explanation(biginners-mindset)-HashMap-in-O(n))

## Explanation
Suppose we have [30, 150, 90].
The total pairs we can form are (30, 150), (90, 30), (90, 150).

Since none of these values are 60, I'm going to do 60 - t % 60 instead of (60 - t % 60) % 60

So when we see 30, we are looking for 60 - 30 % 60 = 30. We haven't seen another 30 yet, so we will not increment cntr (or rather we will, by 0). In our map, we will put 30: 1. What does this means? This means that the remainder 30 is available for use, and the next number that uses it, will be able to create 1 pair with it.

The next number is 150, and we are looking for 60 - 150 % 60 = 30. We see 30 in our map, so we increment cntr by whatever value lives in map[30]. In this case, we increment by map[30] = 1. What this signifies is that we have made a pair between 30 and 150, or in other words, 30 was used to create exactly 1 pair. Now, we will update map[150 % 60] = map[30] by 1, making our map contain 30: 2. What this means is that the next item that requires 30, will be able to make two pairs, one with 30, and one with 150.

Finally, we go to 90, and we are looking for 60 - 90 % 60 = 30. We see map[30] = 2, and so we increment cntr by 2, giving cntr a total value of 3. Why did we do 2? Remember that when map[30] = 2, it means that there is already a pair such that (30, X) are divisible by 60. If you need to use 30 again, then you will be able to create 2 additional pairs. When we see 90, we can now form two pairs: (30, 90) and (90, X). In this case, X is 150.

Let's take this one step further. Assume the last number was 150 again. We are looking for 60 - 150 % 60 = 30. The map now has 30 and a count of 3. What this means is that with remainder 30, we are able to make 3 additional pairs.