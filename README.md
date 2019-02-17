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
| fb 4sum| [4 sum FB面经]()| |//TODO: 如果target是0的话可以用n^2来做 |
| | **two pointers, sliding window algorithm** | | |
| 3 | [Longest Substring without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |[Java](./src/longestSubstringWithoutRepeatingCharacters.java) | two pointers, sliding window algorithm |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [Java](./src/minWindowSubstring.java) | two pointers, sliding window algorithm |
| 159 | [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | [Java](./src/longestSubstringTwoDistinct.java) | two pointers, sliding window algorithm |
| 340 | [Longest Substring with At Most k Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | [Java](./src/longestSubstringKDisctince.java) | two pointers, sliding window algorighm | 
| 438 | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [Java](./src/anagramsInString.java) | 1. sliding window 固定窗口，比较两格hashmap -> 比较两个array -> 维护一个array <br> 2. two pointers + sliding window 活动窗口 |
| 567 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [Java](./src/permutationInString.java) | sliding window 固定窗口，比较两格hashmap -> 比较两个array -> 维护一个array|
| 395 | [Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/) | | |
| 42 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) |[Java](./src/trappingWater.java)|1.two pointer: left, right. 同时用maxLeft, maxRight 维护boundary高度. 从短边注水 <br> 2.变形：如果有-1，漏水怎么办。 instead of summing up water each bin. we sum up water each container|
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
| LC外|[FangFang goes home]() |[Java](./src/pathToHome.java) | 自己出着玩的题目. 一个棋盘，从左上角到右下角一共：C(m+n, m) 或 C(m+n, n)种|
| | **BFS**| |
| 909 | [Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/) |[Java](./src/snakeAndLadders.java) |经典BFS,求最短路径。别忘了用visited防止TLE |
| | **Tree** | | |
| 297 | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [Java](./src/Codec.java) |我把它写在了tree的第一个是因为之后都要用它来构建tree了。总结了两种方法，熟练掌握。<br>1. use queue to traverse/construct the tree level by level <br> 2. recursively pre-order traverse/construct the tree |
| 449 | [Serialize and Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/) |[Java](./src/CodecBST.java)| 1. preorder traverse. Take advantage of BST, 不需要全局变量，就可以判断string里面哪边是左树，哪边是右树 <br> 2. use a queue, level order traverse |
| 428 | [Serialize and Deserialize N-ary Tree](https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/) |[Java](./src/CodecNary.java)|serialize: "preorder" traverse: root \[children] <br> deserialize: 结合了297和calculator的一些技巧。结合括号的recursion。 |
| 431 | [Encode N-ary tree to Binary Tree](https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/) | [Java](./src/CodecConvert.java) |思路：每一层最左边的child作为新root <br> encode: 对于跟自己同一层的nodes，构成其right substree. 自己本身的children，构成其left substree.<br>decode: recursion返回 list<Node>,左边返回的list<node>是自己的children，右边返回的是自己的partners|
| 652 | [Find Duplicate Subtrees](https://leetcode.com/problems/find-duplicate-subtrees/) | [Java](./src/findDupSubTree.java) |关键是利用积累的serialize tree的技巧 |
| 863 | [All Nodes Distance K in Binary Tree](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)| [Java](./src/distanceK.java)| **这道题太好了** 建造了一个新的含有parent的node，clone一遍tree，然后dfs/bfs |
| 742 | [Closet Leaf in a Binary Tree](https://leetcode.com/problems/closest-leaf-in-a-binary-tree/)| [Java](./src/closetLeaf.java)|step1: dfs traverse the tree to find the target node and build parent hashmap <br> step2: bfs traverse the graph, find the closest leaf <br>注意细节比如是add 进queue里面的时候标记为visited |
| 834 | [Sum of Distances in Tree](https://leetcode.com/problems/sum-of-distances-in-tree/)|[Java](./src/sumOfDistances.java)|从n^2 简化至 n, 关键是理解：<br> When we move our root from one node to its connected node, one part of nodes get closer, one the other part get further. |
| |inorder, preorder, poster|  | 相关运用，变形关键是要融会贯通 |
| 94 | [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | [Java](./src/inorder.java) |方法1：recursively inorder traverse the tree into a list. T:O(n) S:O(h) <br>方法2：iteratively inorder traverse the tree, use a stack(在stack pop的时候值放进res里面) T:O(n) S:O(n)|
| 144 | [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | [Java](./src/preorder.java) | 两种iterative的方法：<br> 1.use a stack(在push node into stack的时候, add val into res) T:O(n) S:O(n) <br> 2.用一个stack,对于一个Node的children，从右往左push，那么pop的时候就是从左往右(这种方法很适合推广到n-ary)|
| 145 | [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/) | [Java](./src/postorder.java) | **iterative**方法，观察postorder: 左 右 root, 其实就是preorder 左右翻转版再倒过来|
| 589 | [N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/) | [Java](./src/naryTreePreorder.java) |关键也是**iterative**. 也是两种方法，从preorder binary tree 的两种方法中衍生出来 |
| 590 | [N-ary Tree Postorder Traversal](https://leetcode.com/problems/n-ary-tree-postorder-traversal/)| [Java](./src/naryTreePostorder.java)|preorder 左右翻转版再倒过来|
| 105 | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)| [Java](./src/preAndInorder.java) | 关键是找到root,哪一部分是left tree, 哪一部分是right tree|
| 106 | [Construct Binary Tree from Postorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)| [Java](./src/postAndInorder.java) | postorder就是左右相反的preorder再reverse。注意细节 |
| 889 | [Construct Binary Tree from Preorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)| [Java](./src/preAndPost.java)| |
| 285 | [**Inorder Successor in BST**](https://leetcode.com/problems/inorder-successor-in-bst/) |[Java](./src/inorderSuccessor.java) |method 1 : take advantage of BST time: O(h) <br> method 2: 用stack, 适用于general binary tree|
| 255 | [Verify Preorder Sequence in BST](https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/) | [Java](./src/preorderBST.java) | divide and conquer: O(nlogn)|
| 272 | [Closet BST Value ii](https://leetcode.com/problems/closest-binary-search-tree-value-ii/) |[Java](./src/closetKValues.java) |Got inspired by 285(inorder successor)。Time: O(klog(n)|
| 701 | [Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/) |[Java](./src/insertIntoBST.java)|Got inspired by 285(inorder successor) 关键在于找到该val对应的successor |
| 173 | [BST Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) |[Java](./src/BSTIterator.java) |需要非常熟练掌握。**average time: O(1)** <br> 虽然next()有时候会是O(h),但是总体来说每个Node被visited了2次，一共call了N次|
| 98 |  [Valid Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) | [Java](./src/validBST.java) |1:recursively inorder traverse the tree into a list. T:O(n) S:O(n)<br> 2.iteratively inorder traverse the tree using a stack. T:O(n) S:O(n) <br> 3.recursively inorder traverse the tree using two boundary values: min, max T:O(n) S:O(1) <br>考虑integer overflow：long pre = Long.MIN_VALUE; |
| |bfs dfs |  |top down, bottom up |
| 623 | [Add One Row To Tree](https://leetcode.com/problems/add-one-row-to-tree/) | [Java](./src/add1Row.java) | 一道经典BFS的题，注意corner case |
| 450 | [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/) | [Java](./src/deleteNodeInBST.java) |1. search for a node to remove <br> 2. If the node is found, delete the node <br>|
| 865 | [Smallest Substree with all the Deepest Nodes](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/) |[Java](./src/smallestSubtree.java) |method 1: BFS + Lowest Common Ancestor <br> method 2: dfs (discuss 里面大佬说的) 学习一下 |
| 894 | [All Possible Full Binary Trees](https://leetcode.com/problems/all-possible-full-binary-trees/) | [Java](./src/allFullBT.java) | 警醒一下recursion: 转化成subproblem, 然后call 自己 [solution](https://leetcode.com/problems/all-possible-full-binary-trees/solution/)|
| 559 | [Maximum Depth of N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/) |[Java](./src/maxDepthN.java) | bottom to up 超时了，可以考虑top down dfs 或者 bfs |
| 298 | [Binary Tree Longest Consecutive Sequence](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/)|[Java](./src/btlongestConSeq.java) | top down dfs + 打擂台|
| 549 | [Binary Tree Longest Consecutive Sequence II](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/)|[Java](./src/btlongestConSeqII.java) |top down then bottom up dfs + 打擂台 |
| 337 | [House Robber III](https://leetcode.com/problems/house-robber-iii/) | [Java](./src/houseRobberIII.java)| dfs all the nodes of the tree, each node return two number, int[] num, num[0] is the max value while rob this node, num[1] is max value while not rob this value. |
| |convert tree to list | | 相关问题 |
| 109 | [Convert Sorted List into Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) |[Java](./src/lltoBST.java)|Divide and Conquer |
| 897 | [Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree/)|[Java](./src/inorderBST.java)|还是用那个技巧：用一个全局变量prev |
| 156 | [Binary Tree Upside Down](https://leetcode.com/problems/binary-tree-upside-down/)|[Java](./src/binaryTreeUpsideDown.java) |two methods: 1. recursive 2. iterative(三步：store, change, update) <br> 其思路有点像reverse linked list|
| | **DP, Palindrome(Substring, Subsequence, Subarray..)**| | |
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
| 983 | [Min Cost for Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)| [Java](./src/minCostTicket.java) | 思路来源于coin change这道题 |
| 152 | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/) | [Java](./src/maxProductSubarray.java)| 因为有负数，所以我们不仅要keep track of imax 还要keep track of imin. 乘负数的时候，小的会变成大的，大的会变成小的|
| 325 | [Maximum Size Subarray Sum Equals K](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/) | [Java](./src/subArraySumKMaxSize.java)|presum + hashmap(presum : index) <br> pay attention: map.put(0,-1);|
| 560 |[Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) |[Java](./src/subArraySumk.java)| presum + hashmap (presum : frequency) <br> follow up: if all elements >= 0 (space O(1)). Two pointers |
| 926 | [Flip String to Monotone Increasing](https://leetcode.com/problems/flip-string-to-monotone-increasing/) | [Java](./src/flipToMono.java) | 养成手感了，挺有意思一道题|
| | **Union Find** | | |

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
| 138 | [**Copy List with Random Pointer**](https://leetcode.com/problems/copy-list-with-random-pointer/) | [Java](./src/copyListWithRandom.java) |method 1: use a hashmap 1. copy all nodes 2. assign next and random pointer <br> method 2: space O(1) 把每个node duplicated 一下, 放在后面|
| | **Math** | |
| 7 |[Reverse Integer](https://leetcode.com/problems/reverse-integer/) | [Java](./src/reverseInteger.java) |**这道题的关键是处理overflow的问题**<br>`Integer.MAX_VALUE:2147483647` <br> `Integer.MIN_VALUE:-2147483648` <br> 1.Pop and Push Digits & Check before Overflow <br>2. 作弊方法catch exception|
| 9 |[Palindrome Number](https://leetcode.com/problems/palindrome-number/) | [Java](./src/palindromNum.java) |1. contert to string 2. **重点掌握** 思路有些像上面的reverse integer，但是只用reverse 一半，有效防止over flow|
| 50 |[Pow(x,n)](https://leetcode.com/problems/powx-n/) | [Java](./src/pow.java) |recursive method: T(logn) S(logn) 1. n < 0 <br> 2. n == 0 <br> 3. n % 2 == 0 <br> 4. n % 2 == 1 |
| 65 |[Valid Number](https://leetcode.com/problems/valid-number/) |[Java](./src/validNumber.java) | a general pattern: "-xx.xxe-xx" |
| | **Priority Queue** | | (Top K 问题 quick select, treeset) intervals |
| 346 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)| [Java](./src/topkFrequentElements.java) |1. use PriorityQueue Time: n + k*log(n) <br> 2.bucket sort T:O(n) List<Integer>[] bucket = new **List**[nums.length+1]; |
| 215 | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | [Java](./src/kthLargest.java) | **Quick Select** (注意partition function里面用two pointers swap的模版)|
| 295 | [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/) |[Java](./src/findMedian.java) | two heaps: minheap to store the larger part, maxheap to store the smaller part|
| Pin面经 |[get Top K Rating]()|[Java](./src/getTopKRating.java) |有一个app,要实现两个方法：updateRating()和getTopKRating()，要求getTopK()的时间复杂度O(1) <br> 后怕，发现了自己的知识盲区|
| 759 | [Employee Free Time](https://leetcode.com/problems/employee-free-time/)|[Java](./src/employeeTime.java)| Priority Queue solution based on merging intervals |
| | **Stack,Queue**| |
| 394 | [Decode String](https://leetcode.com/problems/decode-string/) | [Java](./src/decodeString.java) | 1. use stack Time: O(n) Space: O(n) <br> 2. use recursion Time:O(n)我觉得O(n) 因为string的每个元素只走了一遍 Space:O(1)|
| 402 | [Remove K Digits](https://leetcode.com/problems/remove-k-digits/) | [Java](./src/removeKDigits.java) |**非常好的一道题**从straightforward solution到optimized solution(USE A STACK) <br> **思考** 如果是remove k digits 边最大呢？|
| | **Graph** | |
| 261 | [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)| [Java](./src/graphValidTree.java)|判断一个(无向)graph是不是valid tree: <br> 1. 不能有cycles 2. 所有node都要connected <br> 有环：1. **DFS**:一直往下走的path会回到某个已经被visited的点  2. **BFS** queue里面会有重复的点|
| 323 | [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)|[Java](./src/numOfComp.java)| 跟number of islands差不多, graph + dfs |
| 399 | [Evaluate Division](https://leetcode.com/problems/evaluate-division/)|[Java](./src/evaluateDiv.java) |1. edge 有weight 2. dfs + graph |
| 785 | [Is Graph Bipartite](https://leetcode.com/problems/is-graph-bipartite/)|[Java](./src/isBipartite.java)|**经典** 1. 从一个没有染色的node开始，BFS把所有与之构成graph的node染色 <br> 2. 继续从另一个没有染色的node开始，直到所有的node都染色了 |
| 886 | [Possible Bipartition](https://leetcode.com/problems/possible-bipartition/)|[Java](./src/bipartition.java) | 同是bipartite graph问题.不过这个我们需要自己建造一个graph. |
| 928 | [Minimize Malware Spread II](https://leetcode.com/problems/minimize-malware-spread-ii/) |[Java](./src/minMalware.java)|**还是要多练习图的遍历** BFS图的遍历，注意细节：add into queue的时候标记为visited |
| 207 | [Course Schedule](https://leetcode.com/problems/course-schedule/)|[Java](./src/courseSchedule.java) |**经典的拓扑排序问题** 能想到的需要熟练掌握的子问题: <br> 1.构建directed graph 需要好好思考是 child:parents 还是 parent:children <br> 2. 判断有向图里面有没有环 <br> 3.打印拓扑排序  |
| 269 | [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) |[Java](./src/alienDictionary.java)|**很好的一道题** step 1: build directed graph <br> step 2: topological sort<br>还要理解lexicographical order的正确意思来build正确的tree |
| 301 | [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/)|[Java](./src/mht.java)|**类似于**拓扑排序，但是这是一个无向图 [详细解释](https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts) <br> 又是那些细节：什么时候标记为visited。add的时候标记visited是防止queue里面有重复元素，remove的时候标记visited，是标记已经被expanded的node |
| | **Trie** | |
| 208 | [Implement Trie(Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)|[Java](./src/Trie.java)| Trie 相关题目的基础，需要知道它是如何实现的 |
| 211 | [Add and Search Word](https://leetcode.com/problems/add-and-search-word-data-structure-design/) |[Java](./src/WordDictionary.java)| 一道经典的trie与dfs结合的题|
| 676 | [Implement Magic Dictionary](https://leetcode.com/problems/implement-magic-dictionary/) |[Java](./src/magicDictionary.java)|1. 用trie做，找到第一个不同的char，看char之后的substring 能否在当前的子树里面找到。<br> 2. 非常巧妙的hashmap做法 <childstring: [index, char]>|
| 720 | [Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/) |[Java](./src/longestWord.java) |1.很tricy的sort方法 2. trie + dfs (Build a trie in the normal way, then do a dfs to find the longest continuous downward path from the root.)|
| 642 | [Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system/) | [Java](./src/AutocompleteSystem.java) |相对于normal trienode，加了一个set<string> strings. 表示有多少string的prefix是当前prefix.最关键的一点是：每insert一个word,就在经过的node加上这个word | 
| 648 | [Replace Words](https://leetcode.com/problems/replace-words/) | [Java](./src/replaceWords.java)| 一道很直观的trie的题目，对于每个word,找包含的最短的prefix|
| 677 | [Map Sum](https://leetcode.com/problems/map-sum-pairs/) |[Java](./src/MapSum.java)|还是那关键的一步：相对于normal trienode，加了一个set<string> strings. 表示有多少string的prefix是当前prefix |
| 472 | [Concatenated Words](https://leetcode.com/problems/concatenated-words/) |[Java](./src/concatenatedWords.java)|1. for loop + word break解法 <br> 2. Trie + dfs <br> 对当前string进行dfs, 找到一个存在的prefix之后，再对之后的substring进行dfs（for loop） |
| 212 | [Word Search II](https://leetcode.com/problems/word-search-ii/) |[Java](./src/wordSearchII.java)| word search I for loop 版本，但是会tle，用trie优化|
| 425 | [Word Squares](https://leetcode.com/problems/word-squares/)|[Java](./src/wordSquare.java)|Trie + DFS 结合 [Explanation](https://leetcode.com/problems/word-squares/discuss/91333/Explained.-My-Java-solution-using-Trie-126ms-1616) |
| P面经| [打印log]()|[Java](./src/visualizeLog.java) |1.根据题意建立trie tree 2.DFS打印trie tree <br>根据不同情况给trie node赋予不同property children, count, list of words等等 |
| | **Design**| |
| 146 | [LRU](https://leetcode.com/problems/lru-cache/)|[Java](./src/LRU.java) |经典题目LRU，hashmap + doubly linkedlist <br> dll head:most recent used, tail:least recent used |
| 460 | [LFU](https://leetcode.com/problems/lfu-cache/)|[Java](./src/LFU.java) |LRU加强版 <br>Map<Integer, Integer> vals; <br> Map<Integer, Integer> counts; <br> Map<Integer, LinkedHashSet<Integer>> lists; <br>min什么时候变换？ |
| 622 |[Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) |[Java](./src/circularQueue.java) | 用array，和巧妙的头尾指针 |
| 103 |[Design Hit Counter](https://leetcode.com/problems/design-hit-counter/) |[Java1](./src/hitCounter.java)[Java2](./src/HitCounter2.java) |1.用一个简单的queue做(当重复在一个timestampt hit很多次就会很costring) <br> 2.用circular array（推荐） |
| 981 | [Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/description/) | [Java](./src/TimeMap.java) [Java2](./src/TimeMap2.java)| 1. 建造一个Pair class，然后binary search 2. treemap 直接用 floorKey() 这个method |
| | **board 相关题目** | |
| 939 | [Minimum Area Rectangle](https://leetcode.com/problems/minimum-area-rectangle/)|[Java](./src/minAreaRec.java) | 跟google面试题一样，所有point存在hashmap里面，通过看对角线来看是否构成矩形 |
| | **一些神奇的算法**| |
| 287 |[Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [Java](./src/findDup.java) |这道题一开始就有很多constraints,但是我觉得面试中不可能一开始就有这么多constrains <br> 1. instinct method: use hashmap <br> 2.（虽然modify了array）因为n+1 长度，但是数字只在1-n之间，用swap把它们放到了对应的位置上 3. 很精妙的binary search算法 （但是判断语句跟平常不太一样）|
| | **一些OA** | |
| G |Group Email |[Java](./src/groupEmail.java) | 简单字符串处理 |
| L |Shift String |[Java](./src/linkedinoa.java) | 三步翻转法 |
| L |Max Different |[Java](./src/linkedinoa2.java)| 挺简单的，我好像用了个PQ |
| L |Can U Sort| [Java](./src/canUSort.java) | bucket sort |
| 百度 | 有多少不上升/不下降序列  |[Java](./src/baiduoa.java) | dfs -> memorized dfs -> 感觉DP可以做还没想出来 |
| | **Google 面经**| |
| 1 |Concatenated String |[Java](./src/concatenatedStrinng.java) | 1、BFS 2. DP，类似于word break，但是要存储所有的valid combination |
| 2 (lc 890)|Find and Replace Pattern |[Java](./src/wordPattern.java)| 1. lc这道题是要求双向映射都要有唯一性 2.google面经说可以存在 a->b, c->b情况。<br> follow up: 字符变换是否需要中间变量->hashmap映射是否有环 |
| | **Karat 面经** | |
| 1 |有向图三小问 |[Java](./src/findAncestor.java)|1. 第一问是只有0个parents和只有1个parent的节点 <br> 2. 第二问是 两个指定的点有没有公共祖先  <br> 3.第三问是就一个点的最远祖先 |
| 2.(lc 227) | [Basic Calculator](https://leetcode.com/problems/basic-calculator-ii/description/) |[Java](./src/calculator.java) |只含有+,-,/,* 和空格。用stack |
| 3.(lc 224) | [Basic Calculator II](https://leetcode.com/problems/basic-calculator/) | [Java](./src/calculatorII.java)| 只含有+，-, (, ), 和空格。面对有括号的情况，我必将倾向于用recursive的方法，因为括号里面是subproblem。<br>优化recursive方法，把index设置成全局，或者存在int[] index里面|
| 4 | [Basic Calculator III]|[Java](./src/calculatorIII.java)|含有+, -, *, /, (, )等情况 |
| 5 | [Basic Calculator IV]|[Java](./src/calculatorIV.java)|含有+，-，（，）和 变量名 |
| 6 | Task By Level |[Java](./src/taskByLevel.java) |一道经典的topological sort题目（indegree + BFS。但是这里构造graph是用的map: parent : list of children |
| 7 | Security System |[Java](./src/securitySystem.java)|1.找到mismatched person。关键是用0:屋外, 1:屋内。表示状态。 2.关键是two pointer的helper function |
| 8 | 矩阵 |[Java](./src/findRectanangles.java) |1.只有一个矩阵 2.有多个矩阵，互相不重叠 3.不再是矩阵而是形状不规则的区域(有点像number of islands)万事无他唯手熟尔|
| 9 | Domain问题|[Java](./src/Domain.java)|1. 返回domain和所有sub domain被click的总次数 <br> 2.找出两个user之间的longest continuous common history（Longest Common Substring）问题啊！|
| 10 | 设计一个sparse vector class|[Java](./src/sparseVector.java)|实现 add, dot, cosine 操作 |