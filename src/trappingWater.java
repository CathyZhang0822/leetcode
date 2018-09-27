public class trappingWater {
    public static void main(String[] args){
        int[] height = new int[]{0,1,0,2,1,-1,1,3,2,1,2,1};
        System.out.println(trap2(height));
    }
    /* We can treat this array as a set of adjacent containers.
       Thinking about how can we calculate water for a single container:
       imagine pouring water from the lower boundary, then we can sum up water each bin:
       res += (lowedge - binheight)
       For multiple containers:
       Search from left to right and maintain a max height of left and right separately,
       which is like a one-side wall of partial container.
       When we meet a new container, we just update the boundary's height
    * */
    public static int trap(int[] height){
        int left = 0, right = height.length-1;
        int res = 0;
        int maxLeft = height[left], maxRight = height[right];
        while(left < right){
            System.out.println("maxleft:" + maxLeft);
            if(maxLeft <= maxRight){
                res += maxLeft - height[left];
                left ++;
                if(height[left] >= maxLeft) maxLeft = height[left];
            }else{
                res += maxRight - height[right];
                right --;
                if(height[right] >= maxRight) maxRight = height[right];
            }
        }
        return res;
    }
    // follow up: 变形，假如height里面有-1，即为漏水，怎么做
    /* Compare to the origin problem: instead of summing up water each bin.
       we sum up water each container
    * */
    public static int trap2(int[] height){
        int left = 0, right = height.length - 1;
        int res = 0;
        // we can use two variables to help represent current container's water
        // int cur: how much water it can contain; boolean leak: whether it leaks or not
        // when we meet a new container(判断条件：maxLeft/maxRight更新) res += cur(不漏水) /0（漏水)
        int cur = 0;
        boolean leak = false;
        int maxLeft = height[left], maxRight = height[right];
        while(left < right){
            if(maxLeft <= maxRight){
                // move left
                if(height[left] < 0) leak = true;
                cur += maxLeft - height[left];
                left ++;
                // find a new container: we need do two things:
                // 1: sum up last container's water to result
                // 2: restore container
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                    res += leak ? 0 : cur;
                    // restore container
                    leak = false;
                    cur = 0;
                }
            }else{
                // move right
                if(height[right] < 0) leak = true;
                cur += maxRight - height[right];
                right --;
                if(height[right] > maxRight){
                    // update container
                    maxRight = height[right];
                    res += leak ? 0 : cur;
                    // restore container
                    leak = false;
                    cur = 0;
                }
            }
        }
        return res;
    }
}
