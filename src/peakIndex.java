/* Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
   Example:
   Input: [0,2,1,0]
   Output: 1
* */
public class peakIndex {
    public static void main(String[] args){
        peakIndex obj = new peakIndex();
        int[] A = {0, 0,0,1,1,1,2,2,2,2,2,2,3,1,1,0};
        System.out.println(obj.peakIndexV1(A));
        System.out.println(obj.peakIndexV2(A));
    }
    /* Approach 1: iterative binary search
       Time: O(logN)
       Space: O(1)
    * */
    private int peakIndexV1(int[] A){
        int start = 0, end = A.length-1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if (A[mid] < A[mid+1]){
                start = mid;
            }else if(A[mid] > A[mid+1]){
                end = mid;
            }
            else{
                end --;
            }
        }
        if(A[start] > A[end]){
            return start;
        }else{
            return end;
        }
    }

    /* Approach 2: recursive way
       Time: O(logN)
       Space: O(logN) (The depth of recursion tree)
    * */
    private int peakIndexV2(int[] A){
        return helper(A,0,A.length-1);
    }

    private int helper(int[] A, int left, int right){
        if(left == right){
            return left;
        }
        if(left + 1 == right){
            return (A[left] > A[right] ? left : right);
        }
        int mid = left + (right - left) / 2;
        if(A[mid] < A[mid+1]){
            return helper(A,mid,right);
        }else{
            return helper(A,left,mid);
        }
    }
}
