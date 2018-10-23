public class preorderBST {
    public static void main(String[] args){
        Codec obj = new Codec();
        TreeNode root = obj.deserilize2("5,2,6,1,3,N,N,N,N,N,N,");
    }
    // 感觉还是喜欢最基本的divide and conquer
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        return verify(preorder, 0, preorder.length - 1);
    }

    private boolean verify(int[] a, int start, int end) {
        if(start >= end) return true;
        int pivot = a[start];
        int bigger = -1;
        for(int i = start + 1; i <= end; i++) {
            if(bigger == -1 && a[i] > pivot) bigger = i;
            if(bigger != -1 && a[i] < pivot) return false;
        }
        if(bigger == -1) {
            return verify(a, start + 1, end);
        } else {
            return verify(a, start + 1, bigger - 1) && verify(a, bigger, end);
        }
    }
}