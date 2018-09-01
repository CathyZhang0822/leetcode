# Leetcode
Just want to push myself to practice coding

| # | Title | Solution | Basic idea (One line) |
|---| ----- | -------- | --------------------- |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | [Java](./src/twoSum.java) | 1. HashMap O(n) and O(n) space.<br>2. Sort with two points O(nlogn) and O(1) space. |
| 167 | [Two Sum II - Input Array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | [Java](./src/twoSumSorted.java) | 1. two pointers O(n) 2. binary search O(log(n!)) |
| 170 | [Two Sum III - Data Structure Design](https://leetcode.com/problems/two-sum-iii-data-structure-design/) | [Java](./src/twoSumDataStructure.java) | Use HashMap to store numbers. Maintain a list with distinct elements. |
| 653 | [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) | [Java](./src/twoSumIV.java) | 1. DFS + HashSet Time: O(n), Space: O(n).<br>2. Inorder traversal + two pointers Time: O(n), Space: O(n) <br>3. BST iterator + stack Time: O(n), Space: O(logn)|
| 15  | [3 sum](https://leetcode.com/problems/3sum/) | [Java](./src/threeSum.java) | for loop + two sum(pay attention to duplicates) Time: O(n^2)|