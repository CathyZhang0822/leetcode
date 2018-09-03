/* Binary Search 经典中的经典
   这道题直接的点在于，判别函数 isBadVersion是直接给出来的。
   但是很多时候，我们需要自己找。
* */
public class firstBadVersion {
    public static void main(String[] args){
        firstBadVersion obj = new firstBadVersion();
        System.out.println(obj.firstBadVersion(8));
    }
    private boolean isBadVersion(int version){
        if(version <= 5){
            return false;
        }else{
            return true;
        }
    }
    private int firstBadVersion(int n){
        int start = 1, end = n;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(isBadVersion(start)){
            return start;
        }
        return end;
    }
}
