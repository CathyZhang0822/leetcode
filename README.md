# Leetcode
Just want to push myself to practice coding

| # | Title | Solution | Basic idea (One line) |
|---| ----- | -------- | --------------------- |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | [Java](./src/twoSum.java) | 1. HashMap O(n) and O(n) space.<br>2. Sort with two points O(nlogn) and O(1) space. |
| 167 | [Two Sum II - Input Array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | [Java](./src/twoSumSorted.java) | 1. two pointers O(n) 2. binary search O(log(n!)) |
| 170 | [Two Sum III - Data Structure Design](https://leetcode.com/problems/two-sum-iii-data-structure-design/) | [Java](./src/twoSumDataStructure.java) | Use HashMap to store numbers. Maintain a list with distinct elements. |
| 653 | [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) | [Java](./src/twoSumIV.java) | 1. DFS + HashSet Time: O(n), Space: O(n).<br>2. Inorder traversal + two pointers Time: O(n), Space: O(n) <br>3. BST iterator + stack Time: O(n), Space: O(logn) |
| 15 | [3 sum](https://leetcode.com/problems/3sum/) | [Java](./src/threeSum.java) | for loop + two sum(pay attention to duplicates) Time: O(n^2)|
| 3 | [Longest Substring without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |[Java](./src/longestSubstringWithoutRepeatingCharacters.java) | two pointers, sliding window algorithm |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [Java](./src/minWindowSubstring.java) | two pointers, sliding window algorithm |
| 159 | [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | [Java](./src/longestSubstringTwoDistinct.java) | two pointers, sliding window algorithm |
| 340 | [Longest Substring with At Most k Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | [Java](./src/longestSubstringKDisctince.java) | two pointers, sliding window algorighm | 
| 438 | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [Java](./src/anagramsInString.java) | 1. sliding window 固定窗口，比较两格hashmap -> 比较两个array -> 维护一个array <br> 2. two pointers + sliding window 活动窗口 |
| 567 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [Java](./src/permutationInString.java) | sliding window 固定窗口，比较两格hashmap -> 比较两个array -> 维护一个array|
| 278 | [First Bad Version](https://leetcode.com/problems/first-bad-version/) | [Java](./src/firstBadVersion.java) | Binary Search Time: O(logN) Space: O(1)|
| 35 | [Search Insert Position](https://leetcode.com/problems/search-insert-position/) | [Java](./src/searchInsertPosition.java) | Binary Search, 注意边界条件 |
| 852 | [Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/) | [Java](./src/peakIndex.java) | 1. Binary Search iterative Time: O(logN) Space: O(1) <br> 2. Binary Search recursive Time: O(logN) Space: O(logN) <br> 3. for loop .. |
| 162 | [Find Peak Element](https://leetcode.com/problems/find-peak-element/) | [Java](./src/feakElement.java) | same as 852 山峰数组，关键找出判断二分的条件 |
| 153 | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | [Java](./src/findMinInRotatedSortedArray.java) |Binary Search 跟nums[right]比较|
| 154 | [Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/) | [Java](./src/findMinInRotatedSortedArrayII.java) | 包含duplicates,还是Binary Search 当nums[mid]和nums[right]相等时，right--。但是时间复杂度变O(n), worst case: 11101111 |
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | [Java](./src/searchInRotatedSortedArray.java) | 两次二分法，先找出rotate的点，再在一边进行normal binary search |
| 74 | [Search a 2D metrix](https://leetcode.com/problems/search-a-2d-matrix/) | [Java](./src/search2DMetrix.java) | 把2Dmetric看成一个sorted array，还是binary search Time: O(log(m*n)) = O(log(m)+log(n)) |
| 240 | [Search a 2D metrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/) | [Java](./scr/search2DMetrixII.java) |1. binary search tree model. Time: O(m+n) <br> 2. binary search Time:O(m*log(n)) |