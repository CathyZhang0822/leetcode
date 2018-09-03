public class search2DMetrix {
    public static void main(String[] args){
        search2DMetrix obj = new search2DMetrix();
        int[][] matrix = new int[][]{{1,2,3,5},{7,9,10,11},{12,15,16,17}};
        System.out.println(obj.search(matrix,4));
    }
    // treat this 2D metric as a sorted list.
    // point x = val / n, y = val % n; (val 就是对应sorted list的index)
    // time： O(log(m*n)) -> O(logm + logn)
    private boolean search(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m*n-1;
        int mid;
        while(left + 1 < right){
            mid = left + (right - left)/2;
            if(matrix[mid/n][mid%n] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(matrix[left/n][left%n] == target || matrix[right/n][right%n] == target){
            return true;
        }else{
            return false;
        }
    }
}
