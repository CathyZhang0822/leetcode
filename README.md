# Leetcode
Just want to push myself to practice coding

| # | Title | Solution | Basic idea (One line) |
|---| ----- | -------- | --------------------- |
| | **n sum** | | |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | [Java](./src/twoSum.java) | 1. HashMap O(n) and O(n) space.<br>2. Sort with two points O(nlogn) and O(1) space. |
| 167 | [Two Sum II - Input Array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | [Java](./src/twoSumSorted.java) | 1. two pointers O(n) 2. binary search O(log(n!)) |
| 170 | [Two Sum III - Data Structure Design](https://leetcode.com/problems/two-sum-iii-data-structure-design/) | [Java](./src/twoSumDataStructure.java) | Use HashMap to store numbers. Maintain a list with distinct elements. |
| 653 | [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) | [Java](./src/twoSumIV.java) | 1. DFS + HashSet Time: O(n), Space: O(n).<br>2. Inorder traversal + two pointers Time: O(n), Space: O(n) <br>3. BST iterator + stack Time: O(n), Space: O(logn) |
| 15 | [3 sum](https://leetcode.com/problems/3sum/) | [Java](./src/threeSum.java) | for loop + two sum(pay attention to duplicates) Time: O(n^2)|
| | **sliding window algorithm** | | |
| 3 | [Longest Substring without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |[Java](./src/longestSubstringWithoutRepeatingCharacters.java) | two pointers, sliding window algorithm |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [Java](./src/minWindowSubstring.java) | two pointers, sliding window algorithm |
| 159 | [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | [Java](./src/longestSubstringTwoDistinct.java) | two pointers, sliding window algorithm |
| 340 | [Longest Substring with At Most k Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | [Java](./src/longestSubstringKDisctince.java) | two pointers, sliding window algorighm | 
| 438 | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [Java](./src/anagramsInString.java) | 1. sliding window 固定窗口，比较两格hashmap -> 比较两个array -> 维护一个array <br> 2. two pointers + sliding window 活动窗口 |
| 567 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [Java](./src/permutationInString.java) | sliding window 固定窗口，比较两格hashmap -> 比较两个array -> 维护一个array|
| 395 | [Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/) | | |
| | **binary search** | | |
| 278 | [First Bad Version](https://leetcode.com/problems/first-bad-version/) | [Java](./src/firstBadVersion.java) | Binary Search Time: O(logN) Space: O(1)|
| 35 | [Search Insert Position](https://leetcode.com/problems/search-insert-position/) | [Java](./src/searchInsertPosition.java) | Binary Search, 注意边界条件 |
| 852 | [Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/) | [Java](./src/peakIndex.java) | 1. Binary Search iterative Time: O(logN) Space: O(1) <br> 2. Binary Search recursive Time: O(logN) Space: O(logN) <br> 3. for loop .. |
| 162 | [Find Peak Element](https://leetcode.com/problems/find-peak-element/) | [Java](./src/peakElement.java) | same as 852 山峰数组，关键找出判断二分的条件 |
| 153 | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | [Java](./src/findMinInRotatedSortedArray.java) |Binary Search 跟nums[right]比较|
| 154 | [Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/) | [Java](./src/findMinInRotatedSortedArrayII.java) | 包含duplicates,还是Binary Search 当nums[mid]和nums[right]相等时，right--。但是时间复杂度变O(n), worst case: 11101111 |
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | [Java](./src/searchInRotatedSortedArray.java) | 两次二分法，先找出rotate的点，再在一边进行normal binary search |
| 74 | [Search a 2D metrix](https://leetcode.com/problems/search-a-2d-matrix/) | [Java](./src/search2DMetrix.java) | 把2Dmetric看成一个sorted array，还是binary search Time: O(log(m*n)) = O(log(m)+log(n)) |
| 240 | [Search a 2D metrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/) | [Java](./src/search2DMetrixII.java) |1. binary search tree model. Time: O(m+n) <br> 2. binary search Time:O(m*log(n)) |
| 825 | [Friends Of Appropriate Age](https://leetcode.com/problems/friends-of-appropriate-ages/) | [Java](./src/friendsOfApproriateAge.java) | 1. 如果没有年龄限制 binary search 2.如果有年龄限制可简化，用 counts[] sum[]|
| | **back tracking** | | |
| 78 | [Subsets](https://leetcode.com/problems/subsets/) | [Java](./src/subsets.java) | back tracking 两种方法构造recursion tree 剪枝的那个TREE更容易处理remove duplicates的问题|
| 90 | [SubsetsII](https://leetcode.com/problems/subsets-ii/) | [Java](./src/subsetsII.java) | 有duplicates应该怎样处理(对于每个node，剪掉相同的branches) |
| 77 | [Combinations](https://leetcode.com/problems/combinations/) | [Java](./src/combinations.java) |自己稍微改动一下，练习了一下应对duplicates的情况。Time: O(C(n,k)/C(K)) ~ O(n!) |
| 39 | [Combination Sum](https://leetcode.com/problems/combination-sum/) | [Java](./src/combinationSum.java) | 1. 引入index来确定有多少branches <br> 2。去重问题 T:exponential|
| 40 | [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | [Java](./src/combinationSummII.java) | 相同的recursion tree,不同的限制条件|
| 216 | [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/description/) | [Java](./scr/combinationSummIII.java) | 相同的recursion tree,不同的限制条件 |
| 46 | [Permutations](https://leetcode.com/problems/permutations/) |[Java](./src/permutations.java) |1. remove/add elements from arraylist <br> 2. use a boolean array |
| 47 | [PermutationsII](https://leetcode.com/problems/permutations-ii/)|[Java](./src/permutationsII.java)|For each node, remove duplicate branches|
| 20 | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) |[Java](./src/validParentheses.java)| valid parentheses: 每当我们放一个右括号的时候，已经放的左括号要比右括号的数量多|
| 22 | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) |[Java](./src/generateParentheses.java) | backtracking的经典题目，对于每一个position（Node）,有两个branches：（ 或 ）|
| 401 | [Binary Watch](https://leetcode.com/problems/binary-watch/) |[Java](./src/binaryWatch.java) |把num分成两个数num1，num2。分别对hours和minutes求combination sum。<br> 9.5 notes: 这几天系统刷backtracking的题。发现这道题的子问题其实就是combination sum |
| 17 | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) |[Java](./src/letterCombinations.java) | 非常经典直接，多少层：按了多少键 <br> 每个NODE多少branches：每个键课代表多少数字|
| 681 | [Next Closet Time](https://leetcode.com/problems/next-closest-time/description/) |[Java](./src/nextClosetTime.java) | Approach1: simulate the clock and move forward by one minute. Chech whether 4 digits are allowed. Time: O(24*60) <br> Approach2: 用已经存在的digits做DFS排列组合，看那种最closest time：O(4*4*4*4 = 256)|
| 79 | [Word Search](https://leetcode.com/problems/word-search/) | [Java](./src/wordSearch.java) |Time complexity: time O(mn*4^k) where k is the length of the string|
| 51 | [N Queens](https://leetcode.com/problems/n-queens/) | [Java](./src/nQueens.java) | n层，每个node n个branch <br> if delta(col, row) equals, same diagnol1; <br> if sum(col, row) equals, same diagnal2.|
| 52 | [N Queens II](https://leetcode.com/problems/n-queens-ii/) | [Java](./src/nQueens.java) | 一个是返回count，一个是返回paths。注意 new ArrayList<>(path) !!|
| 139 | [Word Break](https://leetcode.com/problems/word-break/) | [Java](./src/wordBreak.java) |memorized dfs：如果直接用DFS的话，时间复杂度：O(N!)。因为很多相同的substring算了很多遍。用map记录下distinct substring的解->O(N^2)。因为用n*(n-1)/2个substring|
| 140 | [Word Break II](https://leetcode.com/problems/word-break-ii/) | [Java](./src/wordBreakII.java) |1. true or false: boolean DP[] 2.all paths: LinkedList<String> [] DP, 每个value是一个list of string| 
| 394 | [Decode String](https://leetcode.com/problems/decode-string/) | [Java](./src/decodeString.java) | 1. use stack Time: O(n) Space: O(n) <br> 2. use recursion Time:O(n)我觉得O(n) 因为string的每个元素只走了一遍 Space:O(1)|
| | **BFS**| |
| 909 | [Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/) |[Java](./src/snakeAndLadders.java) |经典BFS,求最短路径。别忘了用visited防止TLE |
| | **tree** | | |
| 297 | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [Java](./src/Codec.java) |我把它写在了tree的第一个是因为之后都要用它来构建tree了。总结了两种方法，熟练掌握。<br>1. use queue to traverse/construct the tree level by level <br> 2. recursively pre-order traverse/construct the tree |
| 449 | [Serialize and Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/) |[Java](./src/CodecBST.java)| 1. preorder traverse. Take advantage of BST, 不需要全局变量，就可以判断string里面哪边是左树，哪边是右树 <br> 2. use a queue, level order traverse |
| 94 | [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | [Java](./src/inorder.java) |方法1：recursively inorder traverse the tree into a list. T:O(n) S:O(h) <br>方法2：iteratively inorder traverse the tree, use a stack(在stack pop的时候值放进res里面) T:O(n) S:O(n)|
| 144 | [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | [Java](./src/preorder.java) | 这里只写了iterative：iteratively preorder traverse the tree, use a stack(在push node into stack的时候, add val into res) T:O(n) S:O(n)|
| 98 | [Valid Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) | [Java](./src/validBST.java) |1:recursively inorder traverse the tree into a list. T:O(n) S:O(n)<br> 2.iteratively inorder traverse the tree using a stack. T:O(n) S:O(n) <br> 3.recursively inorder traverse the tree using two boundary values: min, max T:O(n) S:O(1) <br>考虑integer overflow：long pre = Long.MIN_VALUE; |
| 623 | [Add One Row To Tree](https://leetcode.com/problems/add-one-row-to-tree/) | [Java](./src/add1Row.java) | 一道经典BFS的题，注意corner case |
| 450 | [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/) | [Java](./src/deleteNodeInBST.java) |1. search for a node to remove <br> 2. If the node is found, delete the node <br>|
| 109 | [Convert Sorted List into Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) |[Java](./src/lltoBST.java)|Divide and Conquer |
| | **DP, Palindrome(Substring, Subsequence..)**| | |
| LC外 | [Longest Common Substring](https://en.wikipedia.org/wiki/Longest_common_substring_problem) | [Java](./src/longestCommonSubstring.java) | DP: O(n*m) <br> if(s(i) == t(j)): DP(i)(j) = DP(i-1)(j-1)+1 |
| LC外 | [Longest Common Subsequence](https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/) | [Java](./src/longestCommonSubsequence.java) | DP: O(n*m) <br> if(s(i) == t(j)): DP(i)(j) = DP(i-1)(j-1)+1 <br> if(s(i)!=t(j)): DP(i)(j) = Math.mDP(i-1)(j-1)|
| 5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | [Java](./src/longestPalindromicSubstring.java) | Approach 1. DP: boolean DP(i)(j) = (DP(i+1)(j-1) && (s(i) == s(j))即当两边的字符一样且substring也是palindrome。 二维boolean DP矩阵，从对角线往斜上方走。T:O(n^2) S:O(n^2) <br> Approach 2: expand function T:O(n^2) S:O(1)|
| 647 | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/) | [Java](./src/palindromSubstrings.java) |use expand helper function T:O(n^2) S:O(1)|
| 516 | [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/) | [Java](./src/longestPalindromSubsequence.java) | DP: dp(i)(k): the longest palindromic subsequence's length of substring(i, j) <br> dp(i)(j) = dp(i+1)(j-1) + 2 if s.charAt(i) == s.charAt(j) <br> otherwise, dp(i)(j) = Math.max(dp(i+1)(j), dp(i)(j-1))|
| 647 | [Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/) | [Java](./src/longestContinuousIncreasingSubsequence.java) | O(N)思路|
| 300 | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) | [Java](./src/longestIncreasingSubsequence.java) | O(N^2)思路|
| 32 | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/) | [Java](./src/longestValidParentheses.java) | O(N)思路|
| 44 | [Wild Card Matching](https://leetcode.com/problems/wildcard-matching/) | [Java](./src/wildCardMatching.java) | |
| 10 | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/) | [Java](./src/regularExpressionMatching.java) | |
| 322 | [Coin Change](https://leetcode.com/problems/coin-change/) | [Java](./src/coinChange.java)| 经典DP题目 |
| 518 | [Coin Change 2](https://leetcode.com/problems/coin-change-2/) | [Java](./src/coinChangeII.java)|1. DFS -> memorized DFS, 注意map的key要用list不要用int[] (存在map里的是reference)<br> 2. DP!!! 从最基本的subproblem开始：只用coin1，加上coin2 .. coin5 |
| | **Linked List** | | |
| lc外 | Generate Linked List| [Java](./src/generateLinkedList.java)| 自己写的class用来快速构建linked list 1.generate 2. show|
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | [Java](./src/reverseLinkedList.java) |经典题目 关键在于next指向previous node同时，不能丢掉后面linked list的头 <br> 1. iterative method 2. recursive method |
| 92 | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | [Java](./src/reverseLinkedListII.java) | 慢慢深入到写出来大致分了三步：<br> 1.完全理解从头到尾 reverse linked list <br> 2.从头到第N个 reverse <br> 3.从第M个到第N个 reverse|
| 24 | [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | [Java](./src/reverseLinkedListII.java) | 这道题有很多种解法来做：<br> 1.把92作为helper function，把swap two nodes 看成reverse nodes in 2 group <br> 2.自己比较straightforward的解法 <br> 3.recursive|
| 25 | [Reverse Nodes in K Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [Java](./src/reverseLinkedListII.java) | 1. 把92作为helper function 2.recursive方法|
| 876 | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | [Java](./src/middleofll.java) |快慢指针|
| 237 | [Delete Node in a linked list](https://leetcode.com/problems/delete-node-in-a-linked-list/) | [Java](./src/deleteNode.java) | 这道题很有意思，只给了要删除node的reference. (面试的时候最好问清)|
| 83 | [Remove duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | [Java](./src/removeDuplicates.java) |1.return a new linked list <br> 2. operate **in place** 3. recursive method|
| 203 | [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/) | [Java](./src/removeElements.java) |1.return a new linked list <br> 2. operate **in place** <br> 最大的感受是，假如remove个多个重复元素，可以一个一个remove（`head.next = head.next.next;`），不需要一下就找到头 |
| 21 | [Merge two sorted lists](https://leetcode.com/problems/merge-two-sorted-lists/) | [Java](./src/merge2ll.java) | 分清什么时候把L1放进去，什么时候把L2放进去|
| 23 | [Merge k sorted lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [Java](./src/mergeKll.java) |1. priority queue, compare head of each linked list T:N*LOGK S:K <br> 2. divide and conquer(with merge 2 linked lists) |
| 143 | [**Reorder List**](https://leetcode.com/problems/reorder-list/) | [Java](./src/reorder.java) | **三道经典例题的结合** 1. find the middle of the linked list <br> 2. reverse the second part <br> 3. merge in-place|
| 328 | [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/) | [Java](./src/oddEven.java) |split it into two linked lists then connect them。注意先对ODD操作。|
| 141 | [Linked List Circle](https://leetcode.com/problems/linked-list-cycle/) | [Java](./src/linkedlistcircle.java) | 1. 老生常谈的slow/fast pointers <br> 2 hastset方法，store visited nodes' reference into a set. 我觉得非常straightforward|
| 142 | [Linked List Circle ii](https://leetcode.com/problems/linked-list-cycle-ii/) | [Java](./src/linkedlistcircle.java) | 对于上一道题，返回环开始的地方。用slow/fast pointers方法就需要数学证明了|
| 708 | [Insert into a Cyclic Sorted List](https://leetcode.com/problems/insert-into-a-cyclic-sorted-list/) |[Java](./src/insertIntoCyclic.java)| do...while loop, pay attention to corner cases: <br>1. in the middle <br>2. between head and tail <br>3. duplicates |
| 801 | [Linked List Connected Components](https://leetcode.com/problems/linked-list-components/) | [Java](./src/connectedComponents.java)|自己的直观solution：一个hashset, 一个boolean值 |
| 61 | [Rotate List](https://leetcode.com/problems/rotate-list/) | [Java](./src/rotateList.java) | 1. Get the length 2. move to the (length - n%length) node 3. do the rotation|
| 86 | [Partition List](https://leetcode.com/problems/partition-list/) | [Java](./src/partitionList.java) |iterate 两遍，非常strightforward |
| 117 | [Populating Next Right Pointers in Each Node I,II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) | [Java](./src/populateNextPointer.java) |1. 如果没有space要求，用一个queue BFS就行 <br> 2. O(1) space. Make use of next pointer |
| 138 | [**Copy List with Random Pointer**](https://leetcode.com/problems/copy-list-with-random-pointer/) | [Java](./src/copyListWithRandom.java) | |
| | **Math** | |
| 7 |[Reverse Integer](https://leetcode.com/problems/reverse-integer/) | [Java](./src/reverseInteger.java) |**这道题的关键是处理overflow的问题**<br>`Integer.MAX_VALUE:2147483647` <br> `Integer.MIN_VALUE:-2147483648` <br> 1.Pop and Push Digits & Check before Overflow <br>2. 作弊方法catch exception|
| 9 |[Palindrome Number](https://leetcode.com/problems/palindrome-number/) | [Java](./src/palindromNum.java) |1. contert to string 2. **重点掌握** 思路有些像上面的reverse integer，但是只用reverse 一半，有效防止over flow|
| 50 |[Pow(x,n)](https://leetcode.com/problems/powx-n/) | [Java](./src/pow.java) |recursive method: T(logn) S(logn) 1. n < 0 <br> 2. n == 0 <br> 3. n % 2 == 0 <br> 4. n % 2 == 1 |
| | **Heap (Top K 问题 quick select, treeset)** | |
| 346 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)| [Java](./src/topkFrequentElements.java) |1. use PriorityQueue Time: n + k*log(n) <br> 2.bucket sort T:O(n) List<Integer>[] bucket = new **List**[nums.length+1]; |
| | **Stack,Queue**| |
| 394 | [Decode String](https://leetcode.com/problems/decode-string/) | [Java](./src/decodeString.java) | 1. use stack Time: O(n) Space: O(n) <br> 2. use recursion Time:O(n)我觉得O(n) 因为string的每个元素只走了一遍 Space:O(1)|
| 402 | [Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | [Java](./src/removeKDigits.java) |**非常好的一道题**从straightforward solution到optimized solution(USE A STACK) <br> **思考** 如果是remove k digits 边最大呢？|
| | **Design**| |
| 622 |[Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) |[Java](./src/circularQueue.java) | 用array，和巧妙的头尾指针 |
| | **一些神奇的算法**| |
| 287 |[Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [Java](./src/findDup.java) |这道题一开始就有很多constraints,但是我觉得面试中不可能一开始就有这么多constrains <br> 1. instinct method: use hashmap <br> 2.（虽然modify了array）因为n+1 长度，但是数字只在1-n之间，用swap把它们放到了对应的位置上 3. 很精妙的binary search算法 （但是判断语句跟平常不太一样）|
| | **一些OA** | |
| G |Group Email |[Java](./src/groupEmail.java) | 简单字符串处理 |
| L |Shift String |[Java](./src/linkedinoa.java) | 三步翻转法 |
| L |Max Different |[Java](./src/linkedinoa2.java)| 挺简单的，我好像用了个PQ |
| L |Can U Sort| [Java](./src/canUSort.java) | bucket sort |

