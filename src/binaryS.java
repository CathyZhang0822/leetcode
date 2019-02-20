public class binaryS {
    public static void main(String[] args){
        int[] test = {1,2,2,2,2,2,4,5,6};

        System.out.println("left most index: " + findIdx(test, 2, true));
        System.out.println("right most index: " + findIdx(test, 2, false));
    }

    public static int findIdx(int[] array, int target, boolean leftMost){
        int left = 0, right = array.length-1;
        int middle;
        while(left + 1 < right){
            middle = left + (right - left) / 2;
            if(array[middle] < target){
                left = middle;
            }else if(array[middle] > target){
                right = middle;
            }else{
                /** The key thing is here! **/
                if (leftMost){
                    right = middle;
                }else{
                    left = middle;
                }
            }
        }

        if(array[left] == target) return left;
        else if(array[right] == target) return right;
        else return -1;
    }
}
