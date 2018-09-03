/* 跟852有区别吗？
   无论题目的表现多么的乱花渐欲迷人眼，关键是要找到左右两边判别的式子。
* */
public class peakElement {
    public static void main(String[] args){
        peakElement obj = new peakElement();
        int[] A = {0, 1, 2, 0};
        System.out.println(obj.findPeakElement(A));
    }
    // Approach: binary search recursive
    // 详细SOLUTION: https://leetcode.com/problems/find-peak-element/solution/
    public int findPeakElement(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    private int helper(int[] nums, int left, int right){
        if(left == right){
            return left;
        }
        if(left + 1 == right){
            return (nums[left] > nums[right] ? left : right);
        }
        int mid = left + (right - left) / 2;
        if(nums[mid] < nums[mid+1]){
            return helper(nums,mid,right);
        }else{
            return helper(nums,left,mid);
        }
    }
}
