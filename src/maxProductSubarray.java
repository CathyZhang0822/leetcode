public class maxProductSubarray {
    public static void main(String[] args){
        int[] nums = {-4,-3,-2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums){
        int res= nums[0], imax= nums[0], imin=nums[0];
        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];
            if(cur < 0){
                int temp = imax;
                imax = imin;
                imin = temp;}
            imax = Math.max(imax*cur, cur);
            imin = Math.min(imin*cur, cur);
            System.out.println("imax:" + imax);
            System.out.println("imin:" + imin);
            res = Math.max(res,imax);
        }
        return res;
    }
}
