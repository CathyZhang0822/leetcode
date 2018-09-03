public class search2DMetrixII {
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,4,7},{2,5,8},{3,6,9},{10,13,14}};
        search2DMetrixII obj = new search2DMetrixII();
        System.out.println(obj.search(matrix, 11));
        System.out.println(obj.searchv2(matrix, 11));

    }
    /* Approach1: binary search tree model
       low left corner, high right corner 就特别像BST的ROOT
       最长的PATH就是M+N
    * */
    private boolean search(int[][] nums, int target){
        if(nums == null || nums.length == 0 || nums[0].length ==0){
            return false;
        }
        int i = nums.length-1, j = 0;
        while(i >=0 && j < nums[0].length){
            if(nums[i][j] == target){
                return true;
            }else if(nums[i][j] < target){
                j ++;
            }else{
                i --;
            }
        }
        return false;
    }
    /* Approach2: binary search row by row. Time: O(m*logn)
    * */
    private boolean searchv2(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for(int i =0; i < matrix.length; i++){
            //binary search here
            if(target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]){
                if(bs(matrix[i], target)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bs(int[]nums, int target){
        int left = 0, right = nums.length-1;
        int mid;
        while(left + 1 < right){
            mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[left] == target || nums[right] == target){
            return true;
        }else{
            return false;
        }
    }

}
