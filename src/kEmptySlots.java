import java.util.TreeSet;

/* google oa: 开花问题

* */
public class kEmptySlots {
    public static void main(String[] args){
        int[] flowers = {1,6,7,2,4,3,5};
        int k = 2;
        int m = 2;
        kEmptySlots obj = new kEmptySlots();
        System.out.println(obj.lastDay(flowers, k, m));
    }

    /* LC 683
   Approach 1: use treeset
   Keep track of the already blooming flowers with a sorted list(sorted positions).
   When adding a flower, check how far away its already blooming neighbors are.
   其实思路很intuitive  _ _ f _ _ f _ f_ _
   i represents the day when flower blooms
   flowers[i] represents the flower's position
   TreeSet!!
    * */
    private int kEmpty(int[] flowers, int k){
        TreeSet<Integer> positions = new TreeSet<>();
        for(int i = 0; i < flowers.length; i++){
            int curPos = flowers[i];
            Integer next = positions.higher(curPos);
            Integer last = positions.lower(curPos);
            //System.out.println("next: " + next);
            if((next != null && next - curPos == k+1) || (last != null && curPos - last == k+1)){
                return i+1;
            }
            positions.add(curPos);
        }
        return -1;
    }

    /* 变形：http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=432500&highlight=google
       多了一个parameter M。 求同一天有M堆，每堆大于等于K个连续开花的最晚日期(latest)。时间复杂度O(nlogn)
       EX:
       比如上面提到的例子[1,6,7,2,3,4,5],2,2。
       第一天：XOOOOOO, group = 1
       第二天：XOOOOXO, group = 2
       第三天：XOOOOXX, group = 2
       第四天：XXOOOXX, group = 2
       第五天：XXXOOXX, group = 2
       第六天：XXXXOXX, group = 2
       第七天：XXXXXXX, group = 1
       所以符合条件的就是4，5，6这几天（因为一共粮堆每堆都大于等于2），然后求的是最晚的那一天，就是6
    * */

    private int lastDay(int[] flowers, int k, int m){
        int group = 0;
        TreeSet<Integer> positions = new TreeSet<>();
        for(int i=0; i < flowers.length; i++){
            int curPos = flowers[i];
            Integer next = positions.higher(curPos);
            Integer last = positions.lower(curPos);
            // group + 1
            if((next == null || (next-curPos>1)) && ((last == null) || (curPos - last) > 1)){
                group ++;
            }else if(next != null && last != null && (next-curPos==1) && (curPos-last==1)){
                // group -1 's situation
                group --;
            }
            if(group == m){
                // check whether all groups have at least k flowers
                // 我他妈写不下去了！发现自己想错了，既然还有O(N)过一遍来看每个group的size, 那我何不也顺便看一下有多少个group？
            }
            // don't forget to add current position!
            positions.add(curPos);
        }
        return group;
    }
}
